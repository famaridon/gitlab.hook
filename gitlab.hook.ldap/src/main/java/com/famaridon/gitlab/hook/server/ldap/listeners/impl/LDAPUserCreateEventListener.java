package com.famaridon.gitlab.hook.server.ldap.listeners.impl;

import com.famaridon.gitlab.hook.server.api.beans.system.impl.UserCreateEvent;
import com.famaridon.gitlab.hook.server.ldap.domain.Person;
import com.famaridon.gitlab.hook.server.ldap.services.LDAPService;
import com.famaridon.gitlab.hook.server.sdk.listeners.HookEventListener;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabSession;
import org.gitlab.api.models.GitlabUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by rolfone on 16/05/15.
 */
@Component
public class LDAPUserCreateEventListener implements HookEventListener<UserCreateEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LDAPUserCreateEventListener.class);

    @Autowired
    private LDAPService ldapService;

    @Override
    public void exec(UserCreateEvent event) {
        LOGGER.info("enter into ldap!");
        try {
            GitlabSession session = GitlabAPI.connect("http://home.famaridon.com/gitlab/","famaridon","manager");
            GitlabAPI api = GitlabAPI.connect("http://home.famaridon.com/gitlab/",session.getPrivateToken());

            GitlabUser gitlabUser = api.getUser(event.getUserId());
            // find into ldap
            Person p = this.ldapService.getPersonRepository().findByLogin(gitlabUser.getUsername());
            LOGGER.info("{}",p);



        } catch (IOException e) {
            e.printStackTrace();
        }

//        Person p = this.ldapService.getPersonRepository().findByLogin(event.get);
//        LOGGER.info("Persone : {}", p);
    }


}
