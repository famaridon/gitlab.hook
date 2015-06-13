package com.famaridon.gitlab.hook.server.api.beans.system.impl;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.famaridon.gitlab.hook.server.api.beans.system.AbstractProjectEvent;

/**
 * Map 'project_create' hook event JSON to Object
 * <pre><code>
 * {
 * "created_at":"2012-07-21T07:30:54Z",
 * "event_name":"project_create",
 * "name":"StoreCloud",
 * "owner_email":"johnsmith@gmail.com",
 * "owner_name":"John Smith",
 * "path":"storecloud",
 * "path_with_namespace":"jsmith/storecloud",
 * "project_id":74,
 * "project_visibility":"private"
 * }
 * </code></pre>
 * Created by rolfone on 15/05/15.
 */
public class ProjectCreateEvent extends AbstractProjectEvent {

    public ProjectCreateEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }

}
