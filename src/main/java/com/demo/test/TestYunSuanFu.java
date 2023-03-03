package com.demo.test;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestYunSuanFu {
    public static void main(String[] args) {
        String examDate = "2022-06-20";
        boolean isInSevenDays = isInDaysAgo(date2Str(new Date()),examDate, 15);
        System.out.println(isInSevenDays);

        String checkDate = getDateBefore(examDate, 15);
        System.out.println(checkDate);
        List<String> cdate = new ArrayList<>();
    }

    public static final String YMD = "yyyy-MM-dd";
    public static final int ONE_DAY_M = 86400000;

    private static SimpleDateFormat SDF = new SimpleDateFormat(YMD);

    public static boolean isInDaysAgo(String examDate, String oldExamDate, int day) {
        try {
            Date beDate = SDF.parse(examDate);
            Date cuDate = SDF.parse(oldExamDate);
            return Math.abs(beDate.getTime() - cuDate.getTime()) <= day * ONE_DAY_M;
        } catch (Exception e) {

        }
        return false;
    }

    public static String date2Str(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null) {
            String str = sdf.format(date);
            return str;
        }
        return null;
    }
    public static String getDateBefore(String d, int day) {
        Date date = str2Date(d, "yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return date2Str(now.getTime());

    }
    public static Date str2Date(String str, String fomat) {
        SimpleDateFormat sdf = new SimpleDateFormat(fomat);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
