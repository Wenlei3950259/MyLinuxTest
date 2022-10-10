package com.demo.dto;

/**
 * 处理登录返回
 *
 * @param <T>
 * @author jiulin.wang
 */
public class BaseResponse<T> {
    /**
     * 基卫返回状态码
     */
    private Integer code = 0;
    /**
     * 基卫返回数据泛型
     */
    private T data;
    /**
     * 总页数
     */
    private Long total;
    /**
     * 某些接口更新数据后返回ID供回调查询
     */
    private T rows;

    private T list;

    //基卫接口返回的错误信息
    private String msg;

    //是否可做服务返回字段
    private int canOrNot;


    public BaseResponse() {
        super();
    }

    public BaseResponse(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this != null && code != null && code.intValue() == 0;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public int getCanOrNot() {
        return canOrNot;
    }

    public void setCanOrNot(int canOrNot) {
        this.canOrNot = canOrNot;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }
}
