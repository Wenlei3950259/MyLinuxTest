package com.demo.dto;

public class DeptDTO {
    private int id;
    private String lis_department_name;
    private String lis_department_id;
    private String org_name;
    private String lis_org_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLis_department_name() {
        return lis_department_name;
    }

    public void setLis_department_name(String lis_department_name) {
        this.lis_department_name = lis_department_name;
    }

    public String getLis_department_id() {
        return lis_department_id;
    }

    public void setLis_department_id(String lis_department_id) {
        this.lis_department_id = lis_department_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getLis_org_id() {
        return lis_org_id;
    }

    public void setLis_org_id(String lis_org_id) {
        this.lis_org_id = lis_org_id;
    }
}
