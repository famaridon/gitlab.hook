package com.famaridon.gitlab.hook.server.api.beans.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by rolfone on 16/05/15.
 */
public class JSONUtils {

    private static ObjectMapper jsonMapper;
    private static boolean bootstrapped = false;

    public synchronized static final void bootstrap(ObjectMapper jsonMapper){
        if(JSONUtils.bootstrapped){
            throw new IllegalStateException("JSONUtils already bootstrapped!");
        }
        JSONUtils.jsonMapper = jsonMapper;
        JSONUtils.bootstrapped=true;
    }

    public static final ObjectMapper getJsonMapper(){
        if(JSONUtils.jsonMapper == null){
            synchronized (JSONUtils.class){
                if(JSONUtils.jsonMapper == null){
                    JSONUtils.bootstrap(new ObjectMapper());
                }
            }
        }
        return jsonMapper;
    }

}
