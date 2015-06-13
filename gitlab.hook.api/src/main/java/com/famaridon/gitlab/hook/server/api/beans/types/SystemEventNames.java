package com.famaridon.gitlab.hook.server.api.beans.types;

import com.famaridon.gitlab.hook.server.api.beans.system.AbstractSystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.impl.*;

/**
 * Created by rolfone on 15/05/15.
 */
public enum SystemEventNames {

    project_create(ProjectCreateEvent.class),
    project_destroy(ProjectDestroyEvent.class),
    user_add_to_team(UserAddToTeamEvent.class),
    user_remove_from_team(UserRemoveFromTeamEvent.class),
    user_create(UserCreateEvent.class),
    user_destroy(UserDestroyEvent.class),
    key_create(KeyCreateEvent.class),
    key_destroy(KeyDestroyEvent.class),
    group_create(GroupCreateEvent.class),
    group_destroy(GroupDestroyEvent.class),
    user_add_to_group(UserAddToGroupEvent.class),
    user_remove_from_group(UserRemoveFromGroupEvent.class);

    private Class<? extends AbstractSystemEvent> type;

    SystemEventNames(Class<? extends AbstractSystemEvent> type) {
        this.type = type;
    }

    public Class<? extends AbstractSystemEvent> getType() {
        return type;
    }
}
