# gitlab.hook

This is a simple web server to handel gitlab hooks (actualy only system hooks).

# Project structure

## gitlab.hook.server

A simple SpringBoot server base on Jetty.
System hook is located at http://localhost/system/trigger

## gitlab.hook.api

All GitLab hooks query objects.
### System :
- GroupCreateEvent
- GroupDestroyEvent
- KeyCreateEvent
- KeyDestroyEvent
- ProjectCreateEvent
- ProjectDestroyEvent
- UserAddToGroupEvent
- UserAddToTeamEvent
- UserCreateEvent
- UserDestroyEvent
- UserRemoveFromGroupEvent
- UserRemoveFromTeamEvent

### Web :

## gitlab.hook.sdk

All needed interfaces to extend server.

### Create extended features 
It's realy easy to create new hoot listener create your own classe and extend **HookEventListener\<T\>** where T is the event query type.

Your class :
- should be thread safe
- can be a spring managed bean.

### Enable/Disable extended features 
To enable/disable extended features simply go to application.properties and add or remove properties like **com.famaridon.gitlab.hook-listener-packages[0]**.



## gitlab.hook.ldap

A simple exemple


