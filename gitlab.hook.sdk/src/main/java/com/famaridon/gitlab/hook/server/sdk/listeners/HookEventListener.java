package com.famaridon.gitlab.hook.server.sdk.listeners;

import com.famaridon.gitlab.hook.server.api.beans.AbstractEvent;

/**
 * Created by rolfone on 15/05/15.
 */
public interface HookEventListener<T extends AbstractEvent> {

    public void exec(T event);

}
