package com.hfad.alier.tinnew.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("title")
    @Expose
    private Title title;

    @SerializedName("content")
    @Expose
    public String content;

    @SerializedName("bankInfoTypeId")
    @Expose
    private Long bankInfoTypeId;

    @SerializedName("typeId")
    @Expose
    private String typeId;

    public Content(){

    }

    public Content(Title title, String content) {
        super();
        this.content = content;
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(Long bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
