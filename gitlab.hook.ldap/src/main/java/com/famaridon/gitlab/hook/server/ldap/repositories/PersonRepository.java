package com.famaridon.gitlab.hook.server.ldap.repositories;

import com.famaridon.gitlab.hook.server.ldap.domain.Person;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.repository.LdapRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by rolfone on 16/05/15.
 */
public interface PersonRepository extends LdapRepository<Person> {

    public Person findByLogin(String login);

}
