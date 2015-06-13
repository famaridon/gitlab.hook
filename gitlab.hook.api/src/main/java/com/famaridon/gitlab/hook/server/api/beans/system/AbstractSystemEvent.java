package com.famaridon.gitlab.hook.server.api.beans.system;

import com.famaridon.gitlab.hook.server.api.beans.AbstractEvent;
import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by rolfone on 15/05/15.
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public abstract class AbstractSystemEvent extends AbstractEvent {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractSystemEvent.class);

    @JsonIgnore
    protected SystemEvent systemEvent;

    public AbstractSystemEvent(SystemEvent systemEvent) {
        this.systemEvent = systemEvent;
        try {
            BeanUtils.copyProperties(this, systemEvent);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOGGER.error("Bean typing can't be processed due to copy error from {} to {}.", systemEvent.getClass().getName(), this.getClass().getName(), e);
            throw new IllegalStateException("Bean typing can't be processed due to copy error.", e);
        }
    }

}
