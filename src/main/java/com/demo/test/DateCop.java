package com.demo.test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCop {
    public static void main(String[] args) {
        String ex = "2023-02-27";
        String substring = ex.substring(0, 4);
        System.out.println(substring);
    }
}
