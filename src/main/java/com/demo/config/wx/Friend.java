package com.demo.config.wx;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import static cn.hutool.core.date.DateUtil.age;

/**
 * @author DokiYolo
 * Date 2022-08-22
 */
public class Friend {

    private final String fullName;

    private final Integer howOld;

    private final String province;

    private final String today;
    private final String yima;

    private final String city;

    private final String userId;

    private final String birthday;

    private final String meetTime;
    private final String loveTalk;

    private final String sex;

    private final String templateId;

    public Friend(String fullName, String province, String today, String yima,String city, String userId, String birthday, String meetTime, String loveTalk, String sex) {
        this(fullName, province, today, yima,city, userId, birthday, meetTime, loveTalk, sex, null);
    }

    public Friend(String fullName, String province, String today, String yima,String city, String userId, String birthday, String meetTime, String loveTalk, String sex, String templateId) {
        this.fullName = fullName;
        this.howOld = age(DateUtil.parse(birthday), new Date());
        this.province = province;
        this.today = today;
        this.yima = yima;
        this.city = city;
        this.userId = userId;
        this.birthday = birthday;
        this.meetTime = meetTime;
        this.loveTalk = loveTalk;
        this.sex = sex;
        this.templateId = templateId;
    }


    public String getToday() {
        return today;
    }

    public String getYima() {
        return yima;
    }

    public String getLoveTalk() {
        return loveTalk;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getHowOld() {
        return howOld;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getUserId() {
        return userId;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMeetTime() {
        return meetTime;
    }

    public String getSex() {
        return sex;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getHowLongLived() {
        return String.valueOf(DateUtil.between(new Date(), DateUtil.parse(birthday), DateUnit.DAY));
    }

    public String getNextBirthdayDays() {
        return getNextDay(DateUtil.parse(birthday));
    }

    public String getNextMemorialDay() {
        return getMeetDay(DateUtil.parse(meetTime));
    }

    private String getMeetDay(DateTime parse) {
        int i = daysBetween(new Date(), parse);
        return String.valueOf(i);
    }

    public static String getNextDay(DateTime dateTime) {
        dateTime = DateUtil.beginOfDay(dateTime);
        DateTime now = DateUtil.beginOfDay(new Date());
        dateTime.offset(DateField.YEAR, now.year() - dateTime.year());
        if (now.isAfter(dateTime)) {
            return String.valueOf(dateTime.offset(DateField.YEAR, 1).between(now, DateUnit.DAY));
        }
        return String.valueOf(dateTime.between(now, DateUnit.DAY));
    }

    public static int daysBetween(Date now, Date returnDate) {

        Calendar cNow = Calendar.getInstance();

        Calendar cReturnDate = Calendar.getInstance();

        cNow.setTime(now);

        cReturnDate.setTime(returnDate);

        setTimeToMidnight(cNow);

        setTimeToMidnight(cReturnDate);

        long todayMs = cNow.getTimeInMillis();

        long returnMs = cReturnDate.getTimeInMillis();

        long intervalMs = todayMs - returnMs;

        return millisecondsToDays(intervalMs);

    }

    public static Date transferString2Date(String s) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
        } catch (ParseException e) {
            //LOGGER.error("时间转换错误, string = {}", s, e);
        }
        return date;
    }

    private static int millisecondsToDays(long intervalMs) {

        return (int) (intervalMs / (1000 * 86400));

    }

    private static void setTimeToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

    }

    public static String deleteNotBrHtml(CharSequence cs) {
        return Pattern.compile("<br([^>]*)>").matcher(cs).replaceAll("").replaceAll("</br>", "");
    }


}
