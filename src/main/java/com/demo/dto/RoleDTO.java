package com.demo.dto;

/**
    * role
    */
public class RoleDTO {
    /**
    * id
    */
    private Long id;

    /**
    * userId
    */
    private String userId;

    /**
    * departmentId
    */
    private String departmentId;

    /**
    * jobId
    */
    private String jobId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}