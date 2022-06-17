package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName a_compare_log
 */
public class ACompareLog implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private Date createDate;

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

    /**
     * 
     */
    private byte[] messageContent;

    /**
     * 
     */
    private byte[] oatasks;

    /**
     * 
     */
    private byte[] metasks;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 
     */
    public String getIsSend() {
        return isSend;
    }

    /**
     * 
     */
    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }

    /**
     * 
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    /**
     * 
     */
    public byte[] getMessageContent() {
        return messageContent;
    }

    /**
     * 
     */
    public void setMessageContent(byte[] messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * 
     */
    public byte[] getOatasks() {
        return oatasks;
    }

    /**
     * 
     */
    public void setOatasks(byte[] oatasks) {
        this.oatasks = oatasks;
    }

    /**
     * 
     */
    public byte[] getMetasks() {
        return metasks;
    }

    /**
     * 
     */
    public void setMetasks(byte[] metasks) {
        this.metasks = metasks;
    }
}
