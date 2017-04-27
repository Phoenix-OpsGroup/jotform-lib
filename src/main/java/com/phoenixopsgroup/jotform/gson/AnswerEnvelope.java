/**
 * $Id$
 * <p>
 * Copyright (c) 2017
 */
package com.phoenixopsgroup.jotform.gson;

public class AnswerEnvelope
{

    private String text;
    private String type;
    private Answer answer;
    private String prettyFormat;

    public AnswerEnvelope()
    {

    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Answer getAnswer()
    {
        return answer;
    }

    public void setAnswer(Answer answer)
    {
        this.answer = answer;
    }

    public String getPrettyFormat()
    {
        return prettyFormat;
    }

    public void setPrettyFormat(String prettyFormat)
    {
        this.prettyFormat = prettyFormat;
    }
}
