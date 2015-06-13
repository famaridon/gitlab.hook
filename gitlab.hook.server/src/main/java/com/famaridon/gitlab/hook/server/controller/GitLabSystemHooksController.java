package com.famaridon.gitlab.hook.server.controller;

import com.famaridon.gitlab.hook.server.api.beans.AbstractEvent;
import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractSystemEvent;
import com.famaridon.gitlab.hook.server.configuration.GitLabHooksControllerConfiguration;
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
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by rolfone on 15/05/15.
 */
@RestController()
@RequestMapping("/system")

public class GitLabSystemHooksController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitLabSystemHooksController.class);

    @Autowired
    private ApplicationContext context;

    @Autowired
    private GitLabHooksControllerConfiguration configuration;

    private Map<Class<? extends AbstractEvent>, List<HookEventListener>> hookEventListenersInstanceMap = new HashMap<>();

    @PostConstruct
    protected void init() {
        LOGGER.info("Scan hook listener from {}", this.configuration.getHookListenerPackages());
        for (String packagePrefix : this.configuration.getHookListenerPackages()) {
            Reflections reflections = new Reflections(packagePrefix);

            Set<Class<? extends HookEventListener>> hookEventListeners = reflections.getSubTypesOf(HookEventListener.class);
            for (Class<? extends HookEventListener> hookEventListenerClass : hookEventListeners) {

                if (Modifier.isAbstract(hookEventListenerClass.getModifiers()) || Modifier.isInterface(hookEventListenerClass.getModifiers())) {
                    continue;
                }

                HookEventListener hookEventListenerInstance = null;
                try {
                    // search for spring bean
                    hookEventListenerInstance = this.context.getBean(hookEventListenerClass);
                    LOGGER.debug("Spring bean found for {} .", hookEventListenerClass.getSimpleName());
                } catch (NoSuchBeanDefinitionException e) {
                    // else create new instance
                    try {
                        hookEventListenerInstance = hookEventListenerClass.newInstance();
                        LOGGER.debug("No Spring bean found for {} use manual instance.", hookEventListenerClass.getSimpleName());
                    } catch (InstantiationException | IllegalAccessException ex) {
                        LOGGER.error("Listener {} can't be instantiated!", hookEventListenerClass.getName(), ex);
                        throw new IllegalArgumentException("Listener can't be instantiated!");
                    }
                }

                // store with correct key into map
                ParameterizedType parameterizedType = this.getParameterizedType(hookEventListenerClass, HookEventListener.class);
                Class<? extends AbstractEvent> type = (Class) parameterizedType.getActualTypeArguments()[0];

                List<HookEventListener> listeners = hookEventListenersInstanceMap.get(type);
                if (listeners == null) {
                    listeners = new ArrayList<>();
                    hookEventListenersInstanceMap.put(type, listeners);
                }
                listeners.add(hookEventListenerInstance);

                LOGGER.info("Hook event listener {} found for hook type {}", hookEventListenerClass.getSimpleName(), type.getSimpleName());

            }
        }
    }

    public ParameterizedType getParameterizedType(Class<?> klass, Class<?> interfaceClass) {
        for (Type interfaceType : klass.getGenericInterfaces()) {
            ParameterizedType genericType = (ParameterizedType) interfaceType;
            Class<?> currentInterfaceClass = (Class<?>) genericType.getRawType();
            if (currentInterfaceClass.equals(interfaceClass)) {
                return genericType;
            }
        }
        return null;
    }

    /**
     * Gitlab system hooks is defined <a href="https://gitlab.com/gitlab-org/gitlab-ce/blob/master/doc/system_hooks/system_hooks.mds">here</a>
     */
    @RequestMapping(value = "/trigger", method = RequestMethod.POST, consumes = "application/json")
    public void trigger(@RequestBody SystemEvent event) {
        LOGGER.info("Gitlab system hook '{}' triggered : \n {}", event.getEventName(), event);

        AbstractSystemEvent abstractSystemEvent;
        try {
            abstractSystemEvent = ConstructorUtils.invokeConstructor(event.getEventName().getType(), event);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new IllegalStateException("Can't construct the typed bean!", e);
        }

        List<HookEventListener> hookEventListenersInstanceList = hookEventListenersInstanceMap.get(abstractSystemEvent.getClass());

        if (hookEventListenersInstanceList != null) {
            for (HookEventListener hookEventListenersInstance : hookEventListenersInstanceList) {
                hookEventListenersInstance.exec(abstractSystemEvent);
                LOGGER.debug("Listener {} executed with event : \n {}", hookEventListenersInstance.getClass().getSimpleName(), abstractSystemEvent);
            }
        }
    }

}
