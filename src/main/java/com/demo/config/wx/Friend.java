package com.demo.config.wx;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

import static cn.hutool.core.date.DateUtil.age;

/**
 * @author DokiYolo
 * Date 2022-08-22
 */
public class Friend {

    private final String loveTalk;

    private final String fullName;

    private final Integer howOld;

    private final String province;

    private final String city;

    private final String userId;

    private final String birthday;

    private final String loveTime;

    private final String sex;

    private final String templateId;

    //星座相关
    private final String luckyNumber;
    private final String luckyFriend;
    private final String luckyColor;
    private final String money;
    private final String luckyWork;
    private final String summary;

    public Friend(String fullName, String province, String city, String userId, String birthday, String loveTime, String sex
            , String loveTalk,
                  String luckyNumber, String luckyFriend, String luckyColor, String money, String luckyWork, String summary) {
        this(fullName, province, city, userId, birthday, loveTime, sex, null, loveTalk, luckyNumber, luckyFriend, luckyColor, money, luckyWork, summary);
    }

    public Friend(String fullName, String province, String city, String userId, String birthday, String loveTime, String sex, String templateId
            , String loveTalk, String luckyNumber, String luckyFriend, String luckyColor, String money, String luckyWork, String summary) {
        this.fullName = fullName;
        this.howOld = age(DateUtil.parse(birthday), new Date());
        this.province = province;
        this.city = city;
        this.userId = userId;
        this.birthday = birthday;
        this.loveTime = loveTime;
        this.sex = sex;
        this.loveTalk = loveTalk;
        this.templateId = templateId;
        this.luckyNumber = luckyNumber;
        this.luckyFriend = luckyFriend;
        this.luckyColor = luckyColor;
        this.money = money;
        this.luckyWork = luckyWork;
        this.summary = summary;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public String getLuckyFriend() {
        return luckyFriend;
    }

    public String getLuckyColor() {
        return luckyColor;
    }

    public String getMoney() {
        return money;
    }

    public String getLuckyWork() {
        return luckyWork;
    }

    public String getSummary() {
        return summary;
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

    public String getLoveTime() {
        return loveTime;
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

    public static String getNextDay(DateTime dateTime) {
        dateTime = DateUtil.beginOfDay(dateTime);
        DateTime now = DateUtil.beginOfDay(new Date());
        dateTime.offset(DateField.YEAR, now.year() - dateTime.year());
        if (now.isAfter(dateTime)) {
            return String.valueOf(dateTime.offset(DateField.YEAR, 1).between(now, DateUnit.DAY));
        }
        return String.valueOf(dateTime.between(now, DateUnit.DAY));
    }

    public String getNextMemorialDay() {
        return getMeetTime(loveTime);
    }

    public static String getMeetTime(String loveTime) {
        Date date1 = new Date();
        Date date = DateUtil.parse(loveTime);

        long betweenDay = DateUtil.between(date1, date, DateUnit.DAY);
        return String.valueOf(betweenDay);
    }
}
