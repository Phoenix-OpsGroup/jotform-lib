
package com.phoenixopsgroup.jotform.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class JotformSubmission implements Serializable
{

    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("content")
    @Expose
    private Content content;
    @SerializedName("limit-left")
    @Expose
    private Integer limitLeft;
    @SerializedName("duration")
    @Expose
    private String duration;
    private final static long serialVersionUID = -2073368425672823016L;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public JotformSubmission withResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JotformSubmission withMessage(String message) {
        this.message = message;
        return this;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public JotformSubmission withContent(Content content) {
        this.content = content;
        return this;
    }

    public Integer getLimitLeft() {
        return limitLeft;
    }

    public void setLimitLeft(Integer limitLeft) {
        this.limitLeft = limitLeft;
    }

    public JotformSubmission withLimitLeft(Integer limitLeft) {
        this.limitLeft = limitLeft;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public JotformSubmission withDuration(String duration) {
        this.duration = duration;
        return this;
    }

}
