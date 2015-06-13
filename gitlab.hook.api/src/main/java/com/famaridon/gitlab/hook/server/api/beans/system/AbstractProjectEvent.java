package com.famaridon.gitlab.hook.server.api.beans.system;

import com.famaridon.gitlab.hook.server.api.beans.SystemEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public abstract class AbstractProjectEvent extends AbstractSystemEvent {

    @JsonProperty("name")
    protected String name;

    @JsonProperty("owner_email")
    protected String ownerEmail;

    @JsonProperty("owner_name")
    protected String ownerName;

    @JsonProperty("path")
    protected String path;

    @JsonProperty("path_with_namespace")
    protected String pathWithNamespace;

    @JsonProperty("project_id")
    protected Integer projectId;

    @JsonProperty("project_visibility")
    protected String projectVisibility;

    public AbstractProjectEvent(SystemEvent systemEvent) {
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

    public String getPathWithNamespace() {
        return pathWithNamespace;
    }

    public void setPathWithNamespace(String pathWithNamespace) {
        this.pathWithNamespace = pathWithNamespace;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectVisibility() {
        return projectVisibility;
    }

    public void setProjectVisibility(String projectVisibility) {
        this.projectVisibility = projectVisibility;
    }
}
