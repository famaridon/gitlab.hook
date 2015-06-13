package com.famaridon.gitlab.hook.server.api.beans.system.impl;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractUserEvent;

/**
 * Created by rolfone on 15/05/15.
 */
public class UserCreateEvent extends AbstractUserEvent {

    public UserCreateEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }
}
