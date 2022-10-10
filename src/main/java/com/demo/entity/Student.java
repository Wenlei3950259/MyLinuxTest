package com.demo.entity;

public class Student {
    private Long id;
    private String name;
    private String age;
    private String gender;
    private String bj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj;
    }
}
