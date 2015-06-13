package com.famaridon.gitlab.hook.server.api.beans.system.impl;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractUserTeamEvent;

/**
 * Created by rolfone on 15/05/15.
 */
public class UserRemoveFromTeamEvent extends AbstractUserTeamEvent {

    public UserRemoveFromTeamEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }
}
