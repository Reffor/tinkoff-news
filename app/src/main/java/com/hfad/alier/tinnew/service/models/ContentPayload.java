package com.hfad.alier.tinnew.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentPayload {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;

    @SerializedName("payload")
    @Expose
    private Content payload;

    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    public ContentPayload(){

    }

    public ContentPayload(String resultCode, Content payload) {
        super();
        this.resultCode = resultCode;
        this.payload = payload;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Content getPayload() {
        return payload;
    }

    public void setPayload(Content payload) {
        this.payload = payload;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }
}
