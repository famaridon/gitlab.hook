package com.famaridon.gitlab.hook.server.api.beans.system;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Map 'project_create' hook event JSON to Object
 * <pre><code>
 {
 "created_at": "2012-07-21T07:30:56Z",
 "event_name": "user_add_to_team",
 "project_access": "Master",
 "project_id": 74,
 "project_name": "StoreCloud",
 "project_path": "storecloud",
 "user_email": "johnsmith@gmail.com",
 "user_name": "John Smith",
 "user_id": 41,
 "project_visibility": "private",
 }
 * </code></pre>
 * Created by rolfone on 15/05/15.
 */
public abstract class AbstractUserTeamEvent extends AbstractSystemEvent {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("project_access")
    private String projectAccess;

    @JsonProperty("project_id")
    private Integer projectId;

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("project_path")
    private String projectPath;

    @JsonProperty("project_visibility")
    private String projectVisibility;

    public AbstractUserTeamEvent(SystemEvent systemEvent) {
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

    public String getProjectAccess() {
        return projectAccess;
    }

    public void setProjectAccess(String projectAccess) {
        this.projectAccess = projectAccess;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getProjectVisibility() {
        return projectVisibility;
    }

    public void setProjectVisibility(String projectVisibility) {
        this.projectVisibility = projectVisibility;
    }
}
