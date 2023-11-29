package com.demo.test;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;
import com.demo.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hutool {

    public static boolean isSameYear(String time1, String time2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = sdf.parse(time1);
            Date date2 = sdf.parse(time2);
            int year1 = date1.getYear() + 1900;
            int year2 = date2.getYear() + 1900;
            return year1 == year2;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "2022-05-09 00:00:00";
//        String s2 = "1998-05-25";

//        boolean sameYear = isSameYear(s1, s2);

//        for (int i = 0; i < 2; i++) {
//
//            if (!DateUtils.isInDaysAgo(DateUtils.date2Str(new Date()), s2, 10)) {
//                continue;
//            }
////            System.out.println("13");
//        }
        //通过公历构建  //500226199805256243
        ChineseDate date = new ChineseDate(DateUtil.parseDate("1998-05-25"));
// 一月
        String chineseMonth = date.getChineseMonth();
        System.out.println(chineseMonth);
// 正月
        String chineseMonthName = date.getChineseMonthName();
        System.out.println(chineseMonthName);
// 初一
        String chineseDay = date.getChineseDay();
        System.out.println(chineseDay);
// 庚子
        String cyclical = date.getCyclical();
        System.out.println(cyclical);
// 生肖：鼠
        String chineseZodiac = date.getChineseZodiac();
// 传统节日（部分支持，逗号分隔）：春节
        String festivals = date.getFestivals();
        System.out.println(festivals);
// 庚子鼠年 正月初一
        System.out.println(date.toString());


//        PS: 6月17号 农历 4月30 生日
    }
}

