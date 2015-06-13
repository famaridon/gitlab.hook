package com.famaridon.gitlab.hook.server.api.beans.system;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Map 'project_create' hook event JSON to Object
 * <pre><code>
 {
 "created_at": "2012-07-21T07:44:07Z",
 "email": "js@gitlabhq.com",
 "event_name": "user_create",
 "name": "John Smith",
 "user_id": 41
 }
 * </code></pre>
 * Created by rolfone on 15/05/15.
 */
public abstract class AbstractUserEvent extends AbstractSystemEvent {

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("user_id")
    private Integer userId;

    public AbstractUserEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
