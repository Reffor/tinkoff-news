package com.hfad.alier.tinnew.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Payload {

    @SerializedName("resultCode")
    @Expose
    private String resultCode;

    @SerializedName("payload")
    @Expose
    private List<Title> payload = null;

    @SerializedName("trackingId")
    @Expose
    private String trackingId;

    public Payload() {
    }

    public Payload(String resultCode, List<Title> payload, String trackingId) {
        super();
        this.resultCode = resultCode;
        this.payload = payload;
        this.trackingId = trackingId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<Title> getPayload() {
        return payload;
    }

    public void setPayload(List<Title> payload) {
        this.payload = payload;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    @Override
    public String toString() {
        return resultCode;
    }
}
