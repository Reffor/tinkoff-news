package com.hfad.alier.tinnew.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("milliseconds")
    @Expose
    private long milliseconds;

    @SerializedName("bankInfoTypeId")
    @Expose
    private int bankInfoTypeId;

    public Title(){}

    public Title(String id, String name, Long milliseconds) {
        super();
        this.milliseconds = milliseconds;
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(int bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    @Override
    public String toString() {
        return name;
    }
}
