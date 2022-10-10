package com.demo.test;

import org.apache.poi.ss.formula.functions.T;

public class TestData {
    private int code;
    private TestDTO data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public TestDTO getData() {
        return data;
    }

    public void setData(TestDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
