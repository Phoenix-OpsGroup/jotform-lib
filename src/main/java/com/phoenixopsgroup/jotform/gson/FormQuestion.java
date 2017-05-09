
package com.phoenixopsgroup.jotform.gson;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FormQuestion implements Serializable
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

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder
                .toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
