/**
 * Phoenix Operations Group
 * <p>
 * Copyright (c) 2017
 */
package com.phoenixopsgroup.jotform.util;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class JotformField
{

    private static final Logger logger = LoggerFactory.getLogger(JotformField.class);

    private String fieldName;
    private String fieldType;

    private Map<String,String> kvPairs = new HashMap<>();


    public JotformField()
    {

    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        if (other == this)
        {
            return true;
        }
        if (other.getClass() != getClass())
        {
            return false;
        }
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder
                .toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }

    public Map<String, String> getKvPairs()
    {
        return kvPairs;
    }

    public void setKvPairs(Map<String, String> kvPairs)
    {
        this.kvPairs = kvPairs;
    }

}
