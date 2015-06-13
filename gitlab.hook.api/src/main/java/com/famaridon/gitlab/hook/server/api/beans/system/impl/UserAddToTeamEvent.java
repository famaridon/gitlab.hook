package com.famaridon.gitlab.hook.server.api.beans.system.impl;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractUserTeamEvent;

/**
 * Created by rolfone on 15/05/15.
 */
public class UserAddToTeamEvent extends AbstractUserTeamEvent {

    public UserAddToTeamEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }
}