package com.famaridon.gitlab.hook.server.api.beans.system;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Map 'project_create' hook event JSON to Object
 * <pre><code>
 {
 "created_at": "2012-07-21T07:30:56Z",
 "event_name": "user_add_to_group",
 "group_access": "Master",
 "group_id": 78,
 "group_name": "StoreCloud",
 "group_path": "storecloud",
 "user_email": "johnsmith@gmail.com",
 "user_name": "John Smith",
 "user_id": 41
 }
 * </code></pre>
 * Created by rolfone on 15/05/15.
 */
public abstract class AbstractUserGroupEvent extends AbstractSystemEvent {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("group_id")
    private Integer groupId;

    @JsonProperty("group_access")
    private String groupAccess;

    @JsonProperty("group_name")
    private String groupName;

    @JsonProperty("group_path")
    private String groupPath;

    public AbstractUserGroupEvent(SystemEvent systemEvent) {
        super(systemEvent);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupAccess() {
        return groupAccess;
    }

    public void setGroupAccess(String groupAccess) {
        this.groupAccess = groupAccess;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPath() {
        return groupPath;
    }

    public void setGroupPath(String groupPath) {
        this.groupPath = groupPath;
    }
}
