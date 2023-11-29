package com.demo.util;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author coo
 * @date 2019/11/8 16:43
 */
public class DateCalcUtil {
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD_HHMMSS = "yyyyMMdd HH:mm:ss";
    public static final String yyyyMMdd_HHmmss = "yyyyMMdd_HHmmss";
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String YYYYMMDD2 = "yyyyMMdd";
    public static final Pattern SYT = Pattern.compile("((?<year>\\d{1,3})岁)?((?<month>\\d{1,2})月)?((?<day>\\d{1,3})天)?");
    public static final String YYYYMMDDHHMMSS2 = "yyyyMMddHHmmss";
    public static final String HOUR_MINUTE = "HH:mm";
    public static final String YMD_HOUR_MINUTE = "yyyyMMdd HH:mm";
    public static final String NORMAL_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String TABLE_YM = "yyyy_MM";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM",
            "yyyyMMdd", "yyyyMMdd HH:mm:ss"};

    public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD = "yyyy-MM-dd";
    public static final String YMDHM = "yyyy-MM-dd HH:mm";
    private static final String YMDKMS = "y/M/d k:mm:ss";
    private static final String YYYY = "yyyy";
    public static final String YYYY_MM_DD_HH_MI_SS_en = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_MI_SS_cn = "yyyy年MM月dd日HH时mm分ss秒";


    /**
     * 获取现在时间
     *
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date today = new Date();
        Date todayDay = DateUtils.truncate(today, Calendar.DAY_OF_MONTH);
        return todayDay;
    }

    public static Date strToDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static String dateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        return sdf.format(date);
    }

    public static String dateToStrShort(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD2);
        return sdf.format(date);
    }
    public static String dateToStrShortForYear(Date date) {
        String pattern = "yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String dateToStrMouth(Date date) {
        String pattern = "yyyy-MM";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String timeToStr(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(YYYYMMDDHHMMSS).format(date);
    }

    public static String timeToStr2(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(date);
    }

    public static String timeToStr3(Date date) {
        DateFormat df = new SimpleDateFormat(YYYYMMDD_HHMMSS);
        return df.format(date);
    }

    public static Date longToDate(Long timeStampOnSecond) {
        if (null != timeStampOnSecond)
            return new Date(Long.parseLong(timeStampOnSecond + "000"));
        else {
            return new Date(Long.parseLong("0000000000000"));
        }
    }


    /**
     * 获取今天开始时间 (yyyy-MM-dd HH:mm:ss)
     */
    public static Date getCurrentDayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取今天结束时间  (yyyy-MM-dd HH:mm:ss)
     */
    public static Date getCurrentDayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 获得近一月的开始日期和结束日期
     *
     * @return
     */
    public static Map<String, Date> getCurrentOneMonthRange() {
        Map<String, Date> condition = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        condition.put("endDate", calendar.getTime());
        calendar.add(Calendar.MONTH, -1);
        condition.put("startDate", calendar.getTime());
        return condition;
    }

    /**
     * 日期转化为星期
     *
     * @param date
     * @return
     */
    public static String dateToWeek(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 指示一个星期中的某天。
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (weekIndex < 0) {
            weekIndex = 0;
        }
        return weekDays[weekIndex];
    }

    /**
     * 指定日期加上天数后的日期
     *
     * @param num     为增加的天数
     * @param newDate 创建时间
     * @return
     * @throws ParseException
     */
    public static String plusDay(int num, String newDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(YYYYMMDDHHMMSS);
        Date currdate = format.parse(newDate);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        return enddate;
    }


    //当前日期加上天数：


    /**
     * 当前日期加上天数后的日期
     *
     * @param num 为增加的天数
     * @return
     */
    public static String plusDay(int num) {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat(YYYYMMDD);
        String currdate = format.format(d);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        d = ca.getTime();
        String enddate = format.format(d);
        return enddate;
    }


    public static boolean isToday(Date date) {
        //如果大于今天的开始日期，小于今天的结束日期

        if (date.after(getCurrentDayStartTime()) && date.before(getCurrentDayEndTime())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isToday(String str, String formatStr) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH) + 1;
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH) + 1;
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        return year1 == year2 && month1 == month2 && day1 == day2;
    }


    /**
     * 根据身份编号获取生日
     *
     * @param timeStr 身份编号
     * @return 生日(yyyyMMdd)
     */
    public static Long getLongSecondUnit(String timeStr, String pattern) throws ParseException {
        if (timeStr == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = sdf.parse(timeStr);
        return date.getTime() / 1000;
    }

    public static Long getLongSecondUnit(String timeStr) throws ParseException {
        if (timeStr == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD);
        Date date = sdf.parse(timeStr);
        return date.getTime() / 1000;
    }

    public static long getLongSecondUnit() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * @param birthday
     * @return
     */
    public static String getFullAgeByBirthDay(Long birthday) {
        if (birthday == null) {
            return "0岁0月";
        }
        Interval pid = getAgeMonthDayInterval(birthday);
        Period p = pid.toPeriod(PeriodType.yearMonthDayTime());

        int age = p.getYears();

        if (p.getMonths() != 0 || p.getDays() != 0 || p.getHours() != 0 || p.getMinutes() != 0 || p.getMillis() != 0) {
            age++;
        }
        String ageStr = p.getYears() + "岁" + p.getMonths() + "月";
        System.out.println("年龄：" + p.getYears() + "岁, " + p.getMonths() + "月, " + p.getDays() + "天");
        System.out.println("年龄：" + age + "岁");
        return ageStr;
    }

    public static Long getFullAgeByBirthDay(Integer year, Integer month, Integer day) {
        DateTime date = new DateTime();
        if (year != null) {
            date = date.minusYears(year);
        }
        if (month != null) {
            date = date.minusMonths(month);
        }
        if (day != null) {
            date = date.minusDays(day);
        }

        return getTodayStartTimeWithSecond(date.getMillis());
    }


    /**
     * 处理该时间只保留天时间
     *
     * @param birthday
     * @return
     */
    public static String getAgeYearMonthDayByBirthDay(Long birthday) {
        if (birthday == null) {
            return "未知";
        }
        // 转换为ms
        // 处理为当天时间
        Interval pid = getAgeMonthDayInterval(birthday);
        Period p = pid.toPeriod(PeriodType.yearMonthDayTime());
        String sb = p.getYears() + "岁" +
                p.getMonths() + "月" +
                p.getDays() + "天";
        return sb;
    }


    public static String getAgeYearByBirthDay(Long birthday) {
        if (birthday == null) {
            return "未知";
        }
        // 转换为ms
        Interval pid = getAgeMonthDayInterval(birthday);
        Period p = pid.toPeriod();
        String s = String.valueOf(p.getYears());
        return s + "岁";
    }

    public static Integer getAgeYearIntByBirthDay(Long birthday) {
        if (birthday == null) {
            return 0;
        }
        // 转换为ms
        Interval pid = getAgeMonthDayInterval(birthday);
        Period p = pid.toPeriod();
        return p.getYears();
    }

    public static Interval getAgeMonthDayInterval(Long birthday){
        birthday = getTodayStartTime(birthday * 1000);
        Long today = getTodayStartTime(System.currentTimeMillis());
        Interval pid = new Interval(birthday, today);
        return pid;
    }

    public static Interval getInterval(long startTime, long endTime){
        Interval pid = new Interval(startTime,  endTime);
        return pid;
    }

    public static String getAgeMonthByBirthDay(Long birthday) {
        if (birthday == null) {
            return "未知";
        }

        Interval pid = getAgeMonthDayInterval(birthday);
        Period p = pid.toPeriod();
        String sb = String.valueOf(p.getMonths());
        return sb;
    }

    /**
     * 根据岁月天
     * @param syt 岁月天
     * @return
     */
    public static Long getAgeMonthDayLongByBirthDayStr(String syt) {
        if (syt != null) {
            Matcher matcher = SYT.matcher(syt);
            if (matcher.matches()) {
                String ys = matcher.group("year");
                String ms = matcher.group("month");
                String ds = matcher.group("day");
                Integer year = ys == null ? null : Integer.parseInt(ys);
                Integer month = ms == null ? null : Integer.parseInt(ms);
                Integer day = ds == null ? null : Integer.parseInt(ds);
                return getFullAgeByBirthDay(year, month, day);
            }
        }
        return null;
    }

    /**
     * 为0的数据显示
     *
     * @param birthday
     * @return
     */
    public static String getPrettyAgeYearMonthDayByBirthDay(Long birthday) {
        if (birthday == null) {
            return "未知";
        }
        Interval pid = getAgeMonthDayInterval(birthday);
        Period p = pid.toPeriod(PeriodType.yearMonthDayTime());
        StringBuilder sb = new StringBuilder();
        if (p.getYears() != 0) {
            sb.append(p.getYears()).append("岁");
        }
        if (p.getMonths() != 0) {
            sb.append(p.getMonths()).append("月");
        }
        if (p.getDays() != 0) {
            sb.append(p.getDays()).append("天");
        }
        return sb.toString();
    }

    public static Long getTodayStartTime(Long daytimeMills) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(daytimeMills);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static Long getTodayStartTimeWithSecond(Long daytimeMills) {
        return getTodayStartTime(daytimeMills) / 1000;
    }

    public static Long getTodayEndTime(Long daytime) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(daytime);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public static Long getTodayEndTimeWithSecond(Long daytimeMills) {
        return getTodayEndTime(daytimeMills) / 1000;
    }

    public static String format(long timeInMillis, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(timeInMillis));
    }


    /**
     * 获取季度
     */
    public static class Quarter {

        private int year;

        private int firstMonth;

        private int lastMonth;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getFirstMonth() {
            return firstMonth;
        }

        public void setFirstMonth(int firstMonth) {
            this.firstMonth = firstMonth;
        }

        public int getLastMonth() {
            return lastMonth;
        }

        public void setLastMonth(int lastMonth) {
            this.lastMonth = lastMonth;
        }

        /**
         * 精确到s的时间
         *
         * @param timeWithSeconds
         */
        public Quarter(long timeWithSeconds) {
            process(timeWithSeconds);
        }

        /**
         * 精确到s的时间
         *
         * @param year
         * @param includeMonth
         */
        public Quarter(int year, int includeMonth) {
            this.year = year;
            processIncludeMonth(includeMonth);
        }

        private void processIncludeMonth(int includeMonth) {

        }

        private void process(long timeWithSeconds) {

        }

    }

    public static String getNowTimeStr() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    public static String getTimeStr(Long seconds, String pattern) {
        Calendar c = Calendar.getInstance();
        long millions = seconds * 1000;
        c.setTimeInMillis(millions);
        System.out.println("" + c.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(c.getTime());
    }


    public static List<String> getDateValidateList() {
        List<String> list = new ArrayList<>();
        SimpleDateFormat smdate = new SimpleDateFormat(YYYYMMDD2);
        for (int i = -10; i < 2; i++) {
            //获取过去10天到未来一天的日期
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, i);
            list.add(smdate.format(calendar.getTime()));
        }
        return list;
    }

    /**
     * 返回精确到s的生日时间戳
     *
     * @param age
     * @return
     */
    public static Long getBirthdayByAge(String age) {

        if (!age.contains("岁") && !age.contains("月") && !age.contains("天")) {
            return null;
        }

        if (!age.contains("岁")) {
            age = "0岁" + age;
        }
        if (!age.contains("月")) {
            if (age.contains("岁") && age.contains("天")) {
                String pre = age.substring(0, age.indexOf("岁") + 1);
                String suf = age.substring(age.indexOf("岁") + 1);

                age = pre + "0月" + suf;
            } else {
                age += "0月";
            }
        }
        if (!age.contains("天")) {
            age += "0天";
        }

        Integer year = Integer.parseInt(age.substring(0, age.indexOf("岁")));
        Integer mouth = Integer.parseInt(age.substring(age.indexOf("岁") + 1, age.indexOf("月")));
        Integer day = Integer.parseInt(age.substring(age.indexOf("月") + 1, age.indexOf("天")));
//            System.out.println(year+" "+mouth+" " +day);
        return getFullAgeByBirthDay(year, mouth, day);
    }

    /**
     * 返回精确到s的生日时间戳
     *
     * @param age
     * @return
     */
    public static Integer getBirthdayYearByAge(String age) {
        if(age == null){
            return null;
        }
        if (!age.contains("岁") && !age.contains("月") && !age.contains("天")) {
            return Integer.parseInt(age);
        }
        if (!age.contains("岁")) {
            return 0;
        }
        return Integer.parseInt(age.substring(0, age.indexOf("岁")));
    }

    /**
     * 处理该时间只保留岁或月或天，保留高位
     *
     * @param birthday
     * @return
     */
    public static String getAgeYearMonthDayByBirthDay4Report(Long birthday) {
        if (birthday == null) {
            return "未知";
        }
        // 转换为ms
        // 处理为当天时间
        Interval pid = getAgeMonthDayInterval(birthday);
        Period p = pid.toPeriod(PeriodType.yearMonthDayTime());
        if(p.getYears() != 0){
            return p.getYears() + "岁";
        } else if(p.getMonths() != 0){
            return p.getMonths() + "月";
        } else {
            return p.getDays() + "天";
        }
    }

    public static String getIntervalTimeDescription(long startTime, Long endTime) {
        if (endTime == null) {
            return "--";
        }
        long millisDelta = endTime - startTime;
        String suffix = millisDelta < 0 ? " 前": "";
        Interval pid = getInterval(startTime, endTime);
        Period p = pid.toPeriod(PeriodType.yearMonthDayTime());
        StringBuilder sb = new StringBuilder();
        if(p.getYears() != 0){
            sb.append(p.getYears()).append("年");
        }
        if(p.getMonths() != 0){
            sb.append(p.getMonths()).append("月");
        }
        if(p.getDays() != 0){
            sb.append(p.getDays()).append("天");
        }
        if(p.getHours() != 0){
            sb.append(p.getHours()).append("小时");
        }
        if(p.getMinutes() != 0){
            sb.append(p.getMinutes()).append("分钟");
        }
        if(p.getSeconds() != 0){
            sb.append(p.getSeconds()).append("秒");
        }
        if(sb.length() == 0){
            return "--";
        }
        sb.append(suffix);
        return sb.toString();
    }

    public static String getIntervalTimeEnDescription(long startTime, Long endTime) {
        if (endTime == null) {
            return "--";
        }
        long millisDelta = endTime - startTime;
        String suffix = millisDelta < 0 ? " Before": "";
        Interval pid = getInterval(startTime, endTime);
        Period p = pid.toPeriod(PeriodType.time());
        StringBuilder sb = new StringBuilder();
        sb.append(ArrayUtil.leftPad(String.valueOf(p.getHours()), 2, '0')).append(":");
        sb.append(ArrayUtil.leftPad(String.valueOf(p.getMinutes()), 2, '0')).append(":");
        sb.append(ArrayUtil.leftPad(String.valueOf(p.getSeconds()), 2, '0'));
        sb.append(suffix);
        return sb.toString();
    }



    public static String parseDicomAgeFormat(String syt){
        if(Strings.isNullOrEmpty(syt)){
            return "";
        }
        Matcher matcher = SYT.matcher(syt);
        if(!matcher.matches()){
            try {
                int ymd = Integer.parseInt(syt);
                return wildAgeProcess(ymd);
            }catch (Exception e){
                return "";
            }
        }
        String yearMonthDay = matcher.group("year");
        if(!Strings.isNullOrEmpty(yearMonthDay)){
            return ArrayUtil.leftPad(yearMonthDay, 3, '0') + "Y";
        }
        yearMonthDay = matcher.group("month");
        if(!Strings.isNullOrEmpty(yearMonthDay)){
            return ArrayUtil.leftPad(yearMonthDay, 3, '0') + "M";
        }
        yearMonthDay = matcher.group("day");
        if(!Strings.isNullOrEmpty(yearMonthDay)){
            return ArrayUtil.leftPad(yearMonthDay, 3, '0')  + "D";
        }
        return "";
    }

    public static String wildAgeProcess(int age){
        age = Math.abs(age);
        if(age <= 99 ) {
            // 120以下按年算，默认用居多
            return ArrayUtil.leftPad(String.valueOf(age), 3, '0') + "Y";
        } else {
            // 超过 100 按天算
            return ArrayUtil.leftPad(String.valueOf(age), 3, '0') + "D";
        }
    }

    public static String getWildAge(int age) {
        age = Math.abs(age);
        if (age <= 99) {
            // 99以下按年算，默认用居多
            return age + "岁";
        } else {
            // 100按天算
            return age + "天";
        }
    }

    /**
     * jdk8 java.util.Date --> java.time.LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime uDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * java.util.Date --> java.time.LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate uDateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * java.util.Date --> java.time.LocalTime
     *
     * @param date
     * @return
     */
    public static LocalTime uDateToLocalTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * java.time.LocalDateTime --> java.util.Date
     *
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToUdate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * java.time.LocalDate --> java.util.Date
     */
    public static Date localDateToUdate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    /**
     * java.time.LocalTime --> java.util.Date
     */
    public static Date localTimeToUdate(LocalTime localTime) {
        return Date.from(LocalDateTime.of(LocalDate.now(), localTime)
                .atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate --> 时间戳
     */
    public static long localDateToTimestamp(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    /**
     * LocalDateTime --> 时间戳
     */
    public static long localDateTimeToTimestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }


    /**
     * 时间戳 -- > LocalDateTime
     */
    public static LocalDateTime timestampToLocalDateTime(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * 时间戳 -- > LocalDate
     */
    public static LocalDate timestampToLocalDate(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }


    /**
     * 当地日期时间日期
     *
     * @param str 格式 yyyy-MM-dd HH:mm:ss
     * @return {@link String} 返回yyyy-MM-dd
     */
    public static String localDateTimeToLocalDate(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        if (!str.contains(":")) {
            return str;
        }
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(YMDHMS)).toLocalDate().toString();
    }

    /**
     * 判断传入时间是否已是过去时，是昨天返回true，是今天或未来返回false，yyyy-MM-dd 格式字符串
     */
    public static boolean isPast(String time) {
        try {
            LocalDate inputDate = LocalDate.parse(time, DateTimeFormatter.ofPattern(YMD));
            return inputDate.isBefore(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 日期相减
     *
     * @param d1 d1
     * @param d2 d2
     * @return {@link String}
     */
    public static String dateSubtraction(Date d1, Date d2) {
        if (d1.equals(d2)) {
            return "00:00:00";
        }
        long diff;
        if (d1.after(d2)) {
            diff = d1.getTime() - d2.getTime();
        } else {
            diff = d2.getTime() - d1.getTime();
        }
        return sumSecondToTime(diff / 1000);
    }

    /**
     * 功能描述 秒转时分秒
     *
     * @param sumSecond 总秒数
     * @return java.lang.String 返回 “ 01:01:01 ” 格式的时间
     * @author qinda
     * @date 2020/10/29
     */
    public static String sumSecondToTime(long sumSecond) {
        if (sumSecond <= 0) {
            return "00:00:00";
        }
        long h = sumSecond / 3600;
        long m = (sumSecond - h * 3600) / 60;
        long s = sumSecond - h * 3600 - m * 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    /**
     * 计算时间相差多少天
     *
     * @param targetDate 目标日期
     * @return long
     */
    public static long calculateDurationDays(Date targetDate) {
        LocalDateTime target = uDateToLocalDateTime(targetDate);
        return Duration.between(target, LocalDateTime.now()).toDays();
    }

    public static Date getExpireAt(Long expireAt) {
        return new Date(expireAt * 1000);

    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YYYYMMDDHHMMSS);
        Date parse = simpleDateFormat.parse("2023-07-20 14:42:00");
        long l = calculateDurationDays(parse);
        System.out.println(l);
    }

    /**
     * 当地时间比较
     *
     * @param time1 time1
     * @param time2 time2
     * @return int  time1<time2 返回-1 time1>time2 返回1  time1=time2返回0
     */
    public static int localTimeCompare(String time1, String time2) {
        LocalTime t1 = LocalTime.parse(time1);
        LocalTime t2 = LocalTime.parse(time2);
        if (t1.isBefore(t2)) {
            return -1;
        } else if (t1.isAfter(t2)) {
            return 1;
        } else {
            return 0;
        }
    }
}
