package com.famaridon.gitlab.hook;

import com.famaridon.gitlab.hook.server.api.beans.utils.JSONUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.repository.config.EnableLdapRepositories;

/**
 * Created by rolfone on 15/05/15.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableLdapRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    @Qualifier("jacksonObjectMapperBuilder")
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Bean
    public ObjectMapper jsonMapper(){
        ObjectMapper jsonMapper = jackson2ObjectMapperBuilder.build();
        //
        JSONUtils.bootstrap(jsonMapper);
        return jsonMapper;
    }

}
