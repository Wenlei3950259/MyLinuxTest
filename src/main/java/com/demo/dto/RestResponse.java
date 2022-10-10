package com.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="返回对象",description="接口公共返回对象")
public class RestResponse {

    @ApiModelProperty(value="code",name="code")
    private Integer code = 0;
    @ApiModelProperty(value="返回message信息",name="message")
    private String message = "";
    @ApiModelProperty(value="返回data",name="data")
    private Object data;
    /** 当前页（请求） */
    @ApiModelProperty(value=" 当前页",name="page")
    private Integer page;
    /** 每页个个数 （请求）*/
    @ApiModelProperty(value="每页个个数",name="size")
    private Integer size;
    /** 总数 */
    @ApiModelProperty(value="总数",name="total")
    private Long total;
    /** 起始位置 */
    @ApiModelProperty(value="起始位置",name="offset")
    private Integer offset;

    public RestResponse(){
    }
    public RestResponse(Object object){
        data = object;
    }


    public boolean isSuccess(){
        return code != null && code == ResponseError.SUCCESS.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setError(ResponseError error){
        setCode(error.code);
        setMessage(error.msg);
    }

    public void setError(Integer code, String message) {
        setCode(code);
        setMessage(message);
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public static RestResponse transform(BaseResponse br){
        RestResponse rr = new RestResponse();
        if (br == null) {
            rr.setError(100, "获取数据为空");
            return rr;
        }
        rr.setData(br.getData() == null ? br.getRows() : br.getData());
        rr.setCode(br.getCode());
        rr.setMessage(br.getMsg());
        rr.setTotal(br.getTotal());
        return rr;
    }
}
