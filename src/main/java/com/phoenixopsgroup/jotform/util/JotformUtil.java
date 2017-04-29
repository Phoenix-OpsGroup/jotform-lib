/**
 * Phoenix Operations Group
 * <p>
 * Copyright (c) 2017
 */
package com.phoenixopsgroup.jotform.util;

import com.phoenixopsgroup.jotform.gson.AnswerEnvelope;
import com.phoenixopsgroup.jotform.gson.JotformSubmission;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JotformUtil
{

    private static final Logger logger = LoggerFactory.getLogger(JotformUtil.class);

    DateFormat createdDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public JotformUtil()
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


    public JotformResponse getResponse(JotformSubmission jotformSubmission)
    {
        JotformResponse jotformResponse = new JotformResponse();

        try
        {

            jotformResponse.setCreated(createdDateFormat.parse(jotformSubmission.getContent().getCreatedAt()));
            jotformResponse.setFormId(Long.parseLong(jotformSubmission.getContent().getFormId()));
            jotformResponse.setIpAddress(jotformSubmission.getContent().getIp());
            jotformResponse.setResponseCode(jotformSubmission.getResponseCode());
            jotformResponse.setResponseId(Long.parseLong(jotformSubmission.getContent().getId()));
            jotformResponse.setUpdated(jotformSubmission.getContent().getUpdatedAt());

            for (String key : jotformSubmission.getContent().getAnswerEnvelopes().keySet())
            {
                AnswerEnvelope answerEnvelope =  jotformSubmission.getContent().getAnswerEnvelopes().get(key);
                JotformField jotformField = new JotformField();
                jotformField.setFieldName(answerEnvelope.getText());
                jotformField.setFieldType(answerEnvelope.getType());

                if (null != answerEnvelope.getAnswer())
                {
                    for (String key2 : answerEnvelope.getAnswer().getKeyValuePairs().keySet())
                    {

                        String value2 = answerEnvelope.getAnswer().getKeyValuePairs().get(key2);
                        jotformField.getKvPairs().put(key2, value2);
                    }
                    jotformResponse.getJotformFieldMap().put(Integer.parseInt(key), jotformField);
                }
            }
            
            
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return jotformResponse;
    }

}
