package com.famaridon.gitlab.hook.server.api.beans.system;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Map 'project_create' hook event JSON to Object
 * <pre><code>
 {
 "created_at": "2012-07-21T07:30:54Z",
 "event_name": "group_create",
 "name": "StoreCloud",
 "owner_email": "johnsmith@gmail.com",
 "owner_name": "John Smith",
 "path": "storecloud",
 "group_id": 78
 }
 * </code></pre>
 * Created by rolfone on 15/05/15.
 */
public abstract class AbstractGroupEvent extends AbstractSystemEvent {

    @JsonProperty("name")
    private String name;

    @JsonProperty("owner_email")
    private String ownerEmail;

    @JsonProperty("owner_name")
    private String ownerName;

    @JsonProperty("path")
    private String path;

    @JsonProperty("group_id")
    private Integer groupId;


    public AbstractGroupEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
