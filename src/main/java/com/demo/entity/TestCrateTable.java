package com.demo.entity;

import java.util.Date;

/**
 * test_crate_table
 */
public class TestCrateTable {
    /**
     * id
     */
    private Long id;

    /**
     * 时间
     */
    private Date createTime;

    /**
     * 是否是你爹
     */
    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}