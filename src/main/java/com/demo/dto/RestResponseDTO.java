package com.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="返回对象",description="接口公共返回对象")
public class RestResponseDTO<T> {

    @ApiModelProperty(value="code", name="code")
    private Integer code = ResponseError.SUCCESS.getCode();
    @ApiModelProperty(value = "返回message信息", name = "message")
    private String msg = "调用成功";
    @ApiModelProperty(value = "返回data", name = "data")
    private T data;
    /**
     * 当前页（请求）
     */
    @ApiModelProperty(value = " 当前页", name = "page")
    private Integer pageNo;
    /**
     * 每页个个数 （请求）
     */
    @ApiModelProperty(value = "每页个个数", name = "size")
    private Integer pageSize;
    /**
     * 总数
     */
    @ApiModelProperty(value = "总数", name = "total")
    private Long totalCount;


    public boolean success() {
        return code != null && code == ResponseError.SUCCESS.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }


}
