package com.famaridon.gitlab.hook.server.api.beans.system.impl;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractUserGroupEvent;

/**
 * Created by rolfone on 15/05/15.
 */
public class UserAddToGroupEvent extends AbstractUserGroupEvent {

    public UserAddToGroupEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }
}
