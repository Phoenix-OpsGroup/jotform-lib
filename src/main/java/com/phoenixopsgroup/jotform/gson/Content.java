
package com.phoenixopsgroup.jotform.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

public class Content implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("form_id")
    @Expose
    private String formId;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("new")
    @Expose
    private String _new;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("answers")
    @Expose
    private Map<String,AnswerEnvelope> AnswerEnvelopes;


    private final static long serialVersionUID = -835065516461820806L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Content withId(String id) {
        this.id = id;
        return this;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Content withFormId(String formId) {
        this.formId = formId;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Content withIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Content withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Content withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getNew() {
        return _new;
    }

    public void setNew(String _new) {
        this._new = _new;
    }

    public Content withNew(String _new) {
        this._new = _new;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Content withFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Content withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }


    public Map<String, AnswerEnvelope> getAnswerEnvelopes()
    {
        return AnswerEnvelopes;
    }

    public void setAnswerEnvelopes(Map<String, AnswerEnvelope> answerEnvelopes)
    {
        AnswerEnvelopes = answerEnvelopes;
    }
}
