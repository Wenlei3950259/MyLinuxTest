package com.demo.entity;

public class Role {
    private Long id;
    private String userId;
    private String departmentId;
    private String jobId;

    private Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private String getUserId() {
        return userId;
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    private String getJobId() {
        return jobId;
    }

    private void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
