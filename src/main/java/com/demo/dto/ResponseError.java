package com.demo.dto;

public enum ResponseError {
    SUCCESS(200, "调用成功"),
    HC_SUCCESS(0, "调用成功")
    ,UNAUTHORIZED(1013, "授权错误")
    ,ERROR(-9, "服务器异常")
    ,TOKEN_TIMEOUT(1027, "请先登录或登录失效")


    ,ROLE_MULTI(1001, "查询到多个管辖权限")
    ;

    private int code;
    private String msg;

    ResponseError(int code, String message) {
        this.code = code;
        this.msg=message;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
