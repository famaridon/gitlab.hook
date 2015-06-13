package com.famaridon.gitlab.hook.server.configuration;

import com.famaridon.gitlab.hook.server.api.beans.AbstractEvent;
import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractSystemEvent;
import com.famaridon.gitlab.hook.server.sdk.listeners.HookEventListener;
import org.apache.commons.beanutils.ConstructorUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by rolfone on 15/05/15.
 */
@Configuration
@ConfigurationProperties(prefix = "com.famaridon.gitlab")
public class GitLabHooksControllerConfiguration {

    /**
     * the configurable value.
     */
    private List<String> hookListenerPackages = new ArrayList<>();

    /**
     * Do not remove it's used by springboot to inject array configuration
     *
     * @return
     */
    public List<String> getHookListenerPackages() {
        return hookListenerPackages;
    }

    public void setHookListenerPackages(List<String> hookListenerPackages) {
        this.hookListenerPackages = hookListenerPackages;
    }
}
