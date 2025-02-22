package com.feis.smarthouse.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class used to load load environmental variables
 */
public class Environment {

    private Environment() {
    }

    /*
     * Obtains environmental variables values from the list provided.
     * 
     * @param variablesName the list of all environmental variables key names to
     * retrieve.
     * 
     * @return a Map representing the env variables key-value pair
     */
    public static Map<String, String> getEnvironmentVariables(List<String> variablesName) {
        Map<String, String> env = new HashMap<>();
        for (String name : variablesName) {
            env.put(name, System.getenv(name));
        }
        return env;
    }
}
