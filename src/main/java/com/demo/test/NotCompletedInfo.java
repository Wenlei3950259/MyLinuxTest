package com.demo.test;

import java.util.Map;

/**
 * @ClassName NotCompletedInfo
 * @Description: 未完善体检信息
 * @Author: eason.gou
 * @Date: 2021/1/26 16:22
 * @Version 1.0
 **/
public class NotCompletedInfo {
    /**
     * 字段中文名
     */
    private String name;
    /**
     * 字段英文名
     */
    private String field;
    /**
     * 字段类型
     * 1、字符串
     * 2、数字
     * 3、日期
     * 4、单选
     * 5、多选
     */
    private Integer type;
    /**
     * 字段选项值
     */
    private Map<String,Object> optionValue;

    public NotCompletedInfo(String name, String field) {
        this.name = name;
        this.field = field;
    }

    public NotCompletedInfo(String name, String field, Integer type) {
        this.name = name;
        this.field = field;
        this.type = type;
    }

    public NotCompletedInfo(String name, String field, Integer type, Map<String, Object> optionValue) {
        this.name = name;
        this.field = field;
        this.type = type;
        this.optionValue = optionValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Map<String, Object> getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(Map<String, Object> optionValue) {
        this.optionValue = optionValue;
    }
}
