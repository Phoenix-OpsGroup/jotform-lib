/**
 * $Id$
 * <p>
 * Copyright (c) 2017
 */
package com.phoenixopsgroup.jotform.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;

public class FormQuestionResponse
{

    private int responseCode;
    private String message;

    @SerializedName("content")
    @Expose
    private Map<String,FormQuestion> formQuestionEnvelopes;

    @SerializedName("limit-left")
    @Expose
    private
    int limitLeft;

    private String duration;

    public FormQuestionResponse()
    {

    }
    
    public int getResponseCode()
    {
        return responseCode;
    }

    public void setResponseCode(int responseCode)
    {
        this.responseCode = responseCode;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Map<String, FormQuestion> getFormQuestionEnvelopes()
    {
        return formQuestionEnvelopes;
    }

    public void setFormQuestionEnvelopes(Map<String, FormQuestion> formQuestionEnvelopes)
    {
        this.formQuestionEnvelopes = formQuestionEnvelopes;
    }

    public int getLimitLeft()
    {
        return limitLeft;
    }

    public void setLimitLeft(int limitLeft)
    {
        this.limitLeft = limitLeft;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder
                .toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
