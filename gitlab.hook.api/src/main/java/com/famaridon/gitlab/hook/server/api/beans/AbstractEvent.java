package com.famaridon.gitlab.hook.server.api.beans;

import com.famaridon.gitlab.hook.server.api.beans.utils.JSONUtils;
import com.famaridon.gitlab.hook.server.api.beans.types.SystemEventNames;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by rolfone on 15/05/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractEvent {


    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEvent.class);

    @JsonProperty("created_at")
    protected Date createdAt;

    @JsonProperty("event_name")
    protected SystemEventNames eventName;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public SystemEventNames getEventName() {
        return eventName;
    }

    public void setEventName(SystemEventNames eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        try {
            return JSONUtils.getJsonMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.error("Object type {} can't be serialized to JSON : {}", this.getClass().getName(), e);
            throw new IllegalStateException("Object can't be serialized to JSON", e);
        }
    }

}
