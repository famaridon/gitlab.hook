package com.famaridon.gitlab.hook.server.api.beans.system.impl;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractGroupEvent;

/**
 * Created by rolfone on 15/05/15.
 */
public class GroupCreateEvent extends AbstractGroupEvent {

    public GroupCreateEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }
}
