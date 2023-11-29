package com.demo.test;

import com.demo.util.ArrayUtil;
import com.demo.util.DateCalcUtil;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : wenL
 * @create 2023/10/16 10:36
 * @Use : 统计两个时间为使用时间  XX:XX:XX  小时,分,秒
 */
public class TimeUse {
    public static Interval getInterval(long startTime, long endTime) {
        Interval pid = new Interval(startTime, endTime);
        return pid;
    }

    public static String getIntervalTimeEnDescription(long startTime, Long endTime) {
        if (endTime == null) {
            return "--";
        }
        long millisDelta = endTime - startTime;
        String suffix = millisDelta < 0 ? " Before" : "";
        Interval pid = getInterval(startTime, endTime);
        Period p = pid.toPeriod(PeriodType.time());
        StringBuilder sb = new StringBuilder();
        sb.append(ArrayUtil.leftPad(String.valueOf(p.getHours()), 2, '0')).append(":");
        sb.append(ArrayUtil.leftPad(String.valueOf(p.getMinutes()), 2, '0')).append(":");
        sb.append(ArrayUtil.leftPad(String.valueOf(p.getSeconds()), 2, '0'));
        sb.append(suffix);
        return sb.toString();
    }


    public static void main(String[] args) {


        String startTime = "2022-08-16 21:25:25";
        String endTime = "2023-08-17 15:00:31";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(startTime);
            Date date1 = dateFormat.parse(endTime);
            System.out.println("Converted date: " + date);
            long l = date.getTime() / 1000 * 1000;
            long l2 = date1.getTime() / 1000 * 1000;
            String intervalTimeEnDescription = DateCalcUtil.getIntervalTimeEnDescription(l, l2);
            System.out.println(intervalTimeEnDescription);
        } catch (Exception e) {

        }
    }
}
