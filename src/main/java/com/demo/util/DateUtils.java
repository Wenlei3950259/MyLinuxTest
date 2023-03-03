/**
 * Copyright © 2015-2016 ChangHong ZhiHui All rights reserved.
 * FileName: DateUtiles.java
 *
 * @author tangy
 * @version 1.0
 * @date 2016年4月8日
 */
package com.demo.util;

import org.apache.commons.lang3.StringUtils;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间和字符串相互转换工具类
 */
public class DateUtils {


    public static final int ONE_DAY_M = 86400000;

    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";

    public static final String YMD = "yyyy-MM-dd";

    public static final String YMD1 = "yyyyMMdd";

    public static final String YMDKMS = "y/M/d k:mm:ss";

    /**
     * 是否超过一周
     *
     * @param addtime
     * @param now
     * @return
     */
    public static boolean moreWeek(Date addtime, Date now) {
        if (now == null) {
            now = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(addtime);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date after7days = calendar.getTime();
        return after7days.getTime() < now.getTime();
    }

    /**
     * 计算传入的日期 examDate 是否再当前日期的 day 日以内
     *
     * @param examDate
     * @param day
     * @return
     */
    public static boolean isInDaysAgo(String examDate, String oldExamDate, Integer day) {
        try {
            Date beDate = SDF.parse(examDate);
            Date cuDate = SDF.parse(oldExamDate);
            return Math.abs(beDate.getTime() - cuDate.getTime()) <= day * ONE_DAY_M;
        } catch (Exception e) {

        }
        return false;
    }

    /**
     * 计算年龄
     *
     * @param nowDate
     * @param birthDay
     * @return
     */

    private static SimpleDateFormat SDF = new SimpleDateFormat(YMD);
    private static SimpleDateFormat SDF1 = new SimpleDateFormat(YMD1);
    private static SimpleDateFormat ZL_SDF = new SimpleDateFormat(YMDKMS);
    private static Calendar startCal = Calendar.getInstance();
    private static Calendar endDaCal = Calendar.getInstance();

    /**
     * 根据身份证获取生日
     *
     * @param cardId
     * @return
     */
    public static String getBirthday(String cardId) {
        String ret = null;
        try {
            Date startDate;    //格式转换
            if (cardId.length() == 18) {
                startDate = SDF1.parse(cardId.substring(6, 14));
            } else { // 15位
                startDate = SDF1.parse("19" + cardId.substring(6, 12));
            }
            ret = SDF.format(startDate);

        } catch (Exception e) {

        }

        return ret;
    }


    /**
     * Date转换成String类型，格式为"yyyy-MM-dd"
     *
     * @param date
     * @return
     */
    public static String date2Str(Date date) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date != null) {
            String str = sdf.format(date);
            return str;
        }
        return null;
    }

    /**
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            String str = sdf.format(date);
            return str;
        }
        return null;
    }

    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();

    }

    public static String getDateBefore(String d, int day) {
        Date date = str2Date(d, "yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return date2Str(now.getTime());

    }

    public static String getDateBefore(int day) {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return date2Str(now.getTime());

    }


    /**
     * Date转换成String类型，格式为"yyyy-MM-dd"
     *
     * @param date
     * @return
     */
    public static String date2Str2(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (date != null) {
            String str = sdf.format(date);
            return str;
        }
        return null;
    }

    /**
     * String转换成Date，格式为"yyyy-MM-dd" 或者 "yyyy-MM-dd HH:mm:ss".
     *
     * @param str "yyyy-MM-dd" / "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static Date str2Date(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            try {
                date = new SimpleDateFormat(YMDHMS).parse(str);
            } catch (ParseException e1) {
                System.err.println("从字符串 :" + str + " 解析时间失败。");
            }
        }
        return date;
    }

    public static Date str2DateYMD(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat(YMDHMS).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将返回的字符串"/Date(1460908800000)/"，转成Date类型
     *
     * @param str
     * @return
     */
    public static Date formatDate(String str) {

        String str2 = "";
        if (StringUtils.isNotEmpty(str)) {
            str = str.trim();
            if (str != null && !"".equals(str)) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) >= 48 && str.charAt(i) <= 57 || '-' == str.charAt(i)) {
                        str2 += str.charAt(i);
                    }
                }
            }
        }

        if (StringUtils.isNotEmpty(str2)) {
            Long l = Long.valueOf(str2);
            Date d = new Date(l);
            return d;
        }

        return null;
    }

    /**
     * 将返回的字符串"/Date(1460908800000)/"，转成String类型
     *
     * @param str
     * @return Sring类型的日期
     */
    public static String formatLongDate2Str(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        String strDate = "";
        try {
            Date date = formatDate(str);
            return date2Str(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strDate;
    }

    public static String strT2Str(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            format.parse(date);
            return format1.format(format.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
            return date.substring(0, date.indexOf("T"));
        }

    }

    public static String strT2Str(String date, String format2) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat format1 = new SimpleDateFormat(format2);
            format.parse(date);
            return format1.format(format.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
            return date.substring(0, date.indexOf("T"));
        }

    }

    public static int getQuarter(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH) + 1;
            if (month >= 1 && month <= 3) {
                return 1;
            }
            if (month >= 4 && month <= 6) {
                return 2;
            }
            if (month >= 7 && month <= 9) {
                return 3;
            }
            if (month >= 10 && month <= 12) {
                return 4;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 根据传入格式格式化日期
     *
     * @param str
     * @return
     */
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

    /**
     * 将yyyy-MM-dd格式的字符串日期转化成/Date(long)/类型
     *
     * @param date
     * @return
     */
    public static String formatDateToLong(String date) {
        String temp = "/Date(temp)/";
        try {
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date date2 = dateFormat1.parse(date);
            String longDate = new Long(date2.getTime()).toString();
            String re = temp.replace("temp", longDate);
            return re;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 被比较时间是否是 当前时间的n天内 （此处时间为n - n+1天）
     *
     * @param date  当前时间
     * @param parse 被比较时间的时间戳
     * @param n
     * @return
     */
    public static boolean isNDaysAgo(Date date, long parse, int n) {
        Date now = str2Date(DateUtils.date2Str(date), "yyyy-MM-dd");
        long nDayAgosmils = org.apache.commons.lang3.time.DateUtils.addDays(now, -n).getTime();
        return parse >= nDayAgosmils;
    }

    public static Date addMonth(Date create_date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(create_date);
        calendar.add(Calendar.MONTH, 3);
        return calendar.getTime();
    }

    /**
     * 获取指定日期上增加指定年数之后的日期
     *
     * @param spDate
     * @param plusYear
     * @return
     */
    public static Date addYear(Date spDate, Integer plusYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(spDate);
        calendar.add(Calendar.YEAR, plusYear);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 将日期格式字符串加年后返回
     * eg: 2018-08-10 + 1年=2019-08-09
     *
     * @param dateStr
     * @param years
     * @return
     */
    public static String addYear(String dateStr, Integer years) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        calendar.add(Calendar.DATE, -1);
        String newDateStr = dateFormat.format(calendar.getTime());
        return newDateStr;
    }

    public static String addYearAndMonth(String dateStr, Integer years) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        calendar.add(Calendar.DATE, -1);
        DateFormat newFormat = new SimpleDateFormat("yyyy年MM月");
        String newDateStr = newFormat.format(calendar.getTime());
        return newDateStr;
    }

    /**
     * 自定义日期转换
     *
     * @param date
     * @param dateStr
     * @return
     */
    public static String custDate2Str(Date date, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
        if (date != null) {
            String str = sdf.format(date);
            return str;
        }
        return null;
    }

    /**
     * 从当前时间减去指定年数 仅用于年龄转换为最大出生日期计算
     * 返回yyyy-MM-dd格式字符串
     *
     * @param years
     * @return
     */
    public static String cutYear2YMD(Integer years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -years);
        return date2Str(calendar.getTime());
    }


    /**
     * 比较两个时间先后，  date1>date2  va=1; date1=date2  va=0; date1<date2  va=-1;
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Integer compare(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        Long c1 = calendar1.getTimeInMillis();
        Long c2 = calendar2.getTimeInMillis();
        return c1.compareTo(c2);
    }


    /**
     * 比较两个时间先后，  date1>date2  va=1; date1=date2  va=0; date1<date2  va=-1;
     *
     * @param date1 开始时间
     * @param date2 结束时间
     * @return true：在范围之间  false：不在范围内
     */
    public static boolean compare(String date1, String date2, Date date) {
        Date date3 = str2Date(date1, YMD);
        Date date4 = str2Date(date2, YMD);
        String date6 = date == null ? date2Str(new Date()) : date2Str(date);
        Date date5 = str2Date(date6, YMD);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date4);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date5);
        Long c1 = calendar1.getTimeInMillis();
        Long c2 = calendar2.getTimeInMillis();
        Long c3 = calendar3.getTimeInMillis();
        if (c3.compareTo(c1) > -1 && c2.compareTo(c3) > -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算起止年限之间的年份数 向上取整
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Integer calculateSignYear(String startTime, String endTime) {
        if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)) {
            return 0;
        }
        Integer y1 = Integer.parseInt(startTime.substring(0, 4));
        Integer y2 = Integer.parseInt(endTime.substring(0, 4));
        Integer m1 = Integer.parseInt(startTime.substring(5, 7));
        Integer m2 = Integer.parseInt(endTime.substring(5, 7));
        Integer d1 = Integer.parseInt(startTime.substring(8, 10));
        Integer d2 = Integer.parseInt(endTime.substring(8, 10));
        int y = y2 - y1;
        if (y < 1) {
            y = 1;
        } else {
            int m = m2 - m1;
            if (m > 0) {
                y = y + 1;
            } else if (m == 0) {
                int d = d2 - d1;
                if (d > 0) {
                    y = y + 1;
                }
            }
        }
        return y;
    }

    /**
     * 将传入时间字符串 转换为指定格式时间字符串
     * 仅支持 "yyyy-MM-dd" "yyyy-MM-dd HH:mm:ss" "yyyyMMdd" "y/M/d k:mm:ss" 4种格式
     *
     * @param dateString
     * @param pattern
     * @return
     */
    public static String parseDate2PatternString(String dateString, String pattern) {
        if (dateString == null || dateString.length() == 0 || dateString.trim().length() == 0) {
            return null;
        }
        Date theDate = null;
        SimpleDateFormat theSdf = new SimpleDateFormat(pattern);
        try {
            theDate = ZL_SDF.parse(dateString);
        } catch (ParseException e) {
            try {
                theDate = SDF.parse(dateString);
            } catch (ParseException e1) {
                try {
                    theDate = SDF1.parse(dateString);
                } catch (ParseException e2) {
                    try {
                        SimpleDateFormat sdf3 = new SimpleDateFormat(YMDHMS);
                        theDate = sdf3.parse(dateString);
                    } catch (ParseException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        return theDate != null ? theSdf.format(theDate) : "";
    }

    //ISO日期转换为UTC日期
    public static XMLGregorianCalendar dateToXml(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gc;
    }

    //UTC日期转换为ISO日期  
    public static Date xmlToDate(XMLGregorianCalendar gc) {
        GregorianCalendar ca = gc.toGregorianCalendar();
        return ca.getTime();
    }

    public static Calendar dateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
