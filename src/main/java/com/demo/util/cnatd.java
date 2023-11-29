package com.demo.util;

import com.alibaba.fastjson.annotation.JSONField;

public class cnatd {
    @JSONField(name = "bedNo")
    private String bedNo;
    @JSONField(name = "bedId")
    private String bedId;
    @JSONField(name = "patientName")
    private String patientName;
    @JSONField(name = "patientId")
    private String patientId;
    @JSONField(name = "gender")
    private String gender;
    @JSONField(name = "age")
    private String age;
    @JSONField(name = "inuseFlag")
    private Integer inuseFlag;
    @JSONField(name = "doctor")
    private String doctor;
    @JSONField(name = "doctorId")
    private String doctorId;
    @JSONField(name = "nurse")
    private String nurse;
    @JSONField(name = "nurseId")
    private String nurseId;
    @JSONField(name = "diagnosis")
    private String diagnosis;
    @JSONField(name = "nursingTips")
    private String nursingTips;
    @JSONField(name = "nursingTipIds")
    private String nursingTipIds;
    @JSONField(name = "inpatientDate")
    private String inpatientDate;
    @JSONField(name = "inpatientNo")
    private String inpatientNo;
    @JSONField(name = "nursingGrade")
    private String nursingGrade;
    @JSONField(name = "nursingGradeCode")
    private String nursingGradeCode;
    @JSONField(name = "deptId")
    private String deptId;
    @JSONField(name = "dept")
    private String dept;
    @JSONField(name = "sipTel")
    private Object sipTel;
    @JSONField(name = "feeType")
    private String feeType;
    @JSONField(name = "patientRoom")
    private String patientRoom;

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getInuseFlag() {
        return inuseFlag;
    }

    public void setInuseFlag(Integer inuseFlag) {
        this.inuseFlag = inuseFlag;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getNursingTips() {
        return nursingTips;
    }

    public void setNursingTips(String nursingTips) {
        this.nursingTips = nursingTips;
    }

    public String getNursingTipIds() {
        return nursingTipIds;
    }

    public void setNursingTipIds(String nursingTipIds) {
        this.nursingTipIds = nursingTipIds;
    }

    public String getInpatientDate() {
        return inpatientDate;
    }

    public void setInpatientDate(String inpatientDate) {
        this.inpatientDate = inpatientDate;
    }

    public String getInpatientNo() {
        return inpatientNo;
    }

    public void setInpatientNo(String inpatientNo) {
        this.inpatientNo = inpatientNo;
    }

    public String getNursingGrade() {
        return nursingGrade;
    }

    public void setNursingGrade(String nursingGrade) {
        this.nursingGrade = nursingGrade;
    }

    public String getNursingGradeCode() {
        return nursingGradeCode;
    }

    public void setNursingGradeCode(String nursingGradeCode) {
        this.nursingGradeCode = nursingGradeCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Object getSipTel() {
        return sipTel;
    }

    public void setSipTel(Object sipTel) {
        this.sipTel = sipTel;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getPatientRoom() {
        return patientRoom;
    }

    public void setPatientRoom(String patientRoom) {
        this.patientRoom = patientRoom;
    }
}
