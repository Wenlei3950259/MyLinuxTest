package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ACompareLogDTO {

    /**
     *
     */
    private String id;

    /**
     *
     */

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    private byte[] messageContent;

    /**
     *
     */
    private byte[] oatasks;

    /**
     *
     */
    private byte[] metasks;

    /**
     *
     */
    private String mobile;

    /**
     *
     */
    private String isSend;

    /**
     *
     */
    private String isDel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public byte[] getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(byte[] messageContent) {
        this.messageContent = messageContent;
    }

    public byte[] getOatasks() {
        return oatasks;
    }

    public void setOatasks(byte[] oatasks) {
        this.oatasks = oatasks;
    }

    public byte[] getMetasks() {
        return metasks;
    }

    public void setMetasks(byte[] metasks) {
        this.metasks = metasks;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}
