/**
 * Phoenix Operations Group
 * <p>
 * Copyright (c) 2017
 */
package com.phoenixopsgroup.jotform.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JotformResponse
{

    private static final Logger logger = LoggerFactory.getLogger(JotformResponse.class);

    private int responseCode;
    private long responseId;
    private long formId;
    private String ipAddress;
    private Date created;
    private String updated;
    private Map<Integer,JotformField> fields = new HashMap<>();
    
    public JotformResponse()
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


    public int getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(int responseCode)
    {
        this.responseCode = responseCode;
    }

    public long getResponseId()
    {
        return responseId;
    }

    public void setResponseId(long responseId)
    {
        this.responseId = responseId;
    }

    public long getFormId()
    {
        return formId;
    }

    public void setFormId(long formId)
    {
        this.formId = formId;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public Date getCreated()
    {
        return created;
    }

    public void setCreated(Date created)
    {
        this.created = created;
    }

    public String getUpdated()
    {
        return updated;
    }

    public void setUpdated(String updated)
    {
        this.updated = updated;
    }

    public Map<Integer, JotformField> getFields()
    {
        return fields;
    }

    public void setFields(Map<Integer, JotformField> fields)
    {
        this.fields = fields;
    }

    public void dump()
    {
        for (int key : this.getFields().keySet())
        {
            System.out.println(this.getFields().get(key).getFieldName() + " [" + this.getFields().get(key).getFieldType() + "] " + ":");
            for (String k : this.getFields().get(key).getValues().keySet())
            {
                System.out.println("  " + k + ": " + this.getFields().get(key).getValues().get(k));
            }
            System.out.println();
        }
    }

    public String toJson(boolean lowercaseWithUnderscores)
    {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        
        Gson gson;

        if (lowercaseWithUnderscores)
        {
            gson = gsonBuilder
                    .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                    .setPrettyPrinting()
                    .serializeNulls()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

        } else {
            gson = gsonBuilder
                    .registerTypeAdapter(Date.class, new GsonUTCDateAdapter())
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();

        }
        return gson.toJson(this);
    }

}
