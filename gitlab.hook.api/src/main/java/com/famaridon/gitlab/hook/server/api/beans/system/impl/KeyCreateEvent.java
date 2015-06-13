package com.famaridon.gitlab.hook.server.api.beans.system.impl;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractKeyEvent;

/**
 * Created by rolfone on 15/05/15.
 */
public class KeyCreateEvent extends AbstractKeyEvent {

    public KeyCreateEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }
}
