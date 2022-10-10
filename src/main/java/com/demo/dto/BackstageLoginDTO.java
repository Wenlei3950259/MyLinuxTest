package com.demo.dto;

import io.swagger.annotations.ApiModelProperty;

public class BackstageLoginDTO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("注册号(手机)")

    private String login;
    @ApiModelProperty("密码")

    private String password ;
    @ApiModelProperty("用户名称")
    private String name ;

    @ApiModelProperty("中联账户")
    private String zlUser ;
    @ApiModelProperty("确认密码")
    private String confirmPassword ;
    @ApiModelProperty("启用(0)停用(1)")
    private String state ;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZlUser() {
        return zlUser;
    }

    public void setZlUser(String zlUser) {
        this.zlUser = zlUser;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
