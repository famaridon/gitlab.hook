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
To enable/disable extended features simply go to application.properties add edit 

**com.famaridon.gitlab.hook-listener-packages[0]** property

## gitlab.hook.ldap

A simple exemple


