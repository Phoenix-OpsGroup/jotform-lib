
package com.phoenixopsgroup.jotform.gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Answer implements Serializable
{
    private Map<String,String> keyValuePairs = new HashMap<>();

    public Map<String, String> getKeyValuePairs()
    {
        return keyValuePairs;
    }

    public void setKeyValuePairs(Map<String, String> keyValuePairs)
    {
        this.keyValuePairs = keyValuePairs;
    }
}
