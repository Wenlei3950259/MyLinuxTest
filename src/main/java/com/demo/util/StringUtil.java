package com.demo.util;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tang.q
 */
public class StringUtil {

//    public final static String SEPARATOR = ",";
    public final static String SEPARATOR = "";
    public final static String IS = "1";
    public final static String TREND = "2";
    public final static String IS_C = "是";
    public final static String NO_C = "否";
    public final static String TREND_C = "倾向是";
    public final static String NO = "4";
    /**
     * 正则判断为数字
     */
    private static Pattern pattern = Pattern.compile("[0-9]*");

    public static boolean isEmpty(String src) {
        return src == null || src.trim().length() == 0;
    }

    /**
     *
     * @param dbString 数据库的数据
     * @param cmmitStr 用户提交上来的数据
     * @return
     *
     */
    public static boolean isEdit2Empty(String dbString, String cmmitStr) {
        return !StringUtil.isEmpty(dbString) && StringUtil.isEmpty(cmmitStr);
    }

    public static boolean isDataEmpty(String dbString, String cmmitStr) {
        return dbString == null && StringUtil.isEmpty(cmmitStr);
    }

    public static <T> boolean isEdit2EmptyList(List<T> dbList, List<T> commitList) {
        return !CollectionUtils.isEmpty(dbList) && CollectionUtils.isEmpty(commitList);
    }

    public static <T> boolean isDataListEmpty(List<T> dbList, List<T> commitList) {
        return CollectionUtils.isEmpty(dbList) && CollectionUtils.isEmpty(commitList);
    }

    public static boolean isNotEmpty(String src) {
        return !isEmpty(src);
    }

    /**
     * 传入一组字符串，如果全部为空，返回false,只要有一个不为空，返回true
     * add by hedecai
     *
     * @param strings
     * @return
     */
    public static boolean isNotEmpty(String... strings) {
        boolean b = false;
        if (strings == null || strings.length == 0) {
            return false;
        }
        for (String s : strings) {
            b = isNotEmpty(s);
            if (b) {
                break;
            }
        }
        return b;
    }

    public static boolean need2OverideData(String oldData, String newData){
        return StringUtil.isNotEmpty(newData) && StringUtil.isEmpty(oldData);
    }

    public static boolean isDataEmptyOrZero(String data){
        return StringUtil.isEmpty(data) || "0".equals(data);
    }

    /**
     * 判断一个字符串是数字  包含小数  整数s
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        if (isEmpty(str)){
            return false;
        }
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }

    /**
     * 简单判断下  是数字或者带有X结尾  就可以
     * @param str
     * @return
     */
    public static boolean isCardId(String str) {
        if (isEmpty(str)){
            return false;
        }
        String reg = "^[0-9]+(.[0-9]+)?$";
        if (str.endsWith("X") || str.endsWith("x")){
            return str.substring(0,str.length() - 1).matches(reg);
        }
        return str.matches(reg);
    }

    public static boolean isDateYyyyMMddHHmmss(String str) {
        if (isEmpty(str)){
            return false;
        }
        String reg = "^((([1-2][0-9][0-9][0-9]-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|(20[0-3][0-9]-(0[2469]|11)-(0[1-9]|[12][0-9]|30))) (20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9])$";
        return str.matches(reg);
    }

    public static String subString(String str,int length){
        if(str == null){
            return null;
        }
        if (str.length() <= length){
            return str;
        }
        return str.substring(0,length);
    }

    public static String bool2Number(String bool){
        if (isEmpty(bool)){
            return "";
        }
        if (bool.equals("true")){
            return "0";
        }
        if (bool.equals("false")){
            return "1";
        }
        return "";
    }

    /**
     * 将2的幂的和才分为2的幂的数组
     * @param sum
     * @return
     */
    public static Integer[] split2Power(String sum){
        if (isEmpty(sum)){
            return null;
        }
        try {
            List<Integer> result = new ArrayList<>();
            Integer num = Integer.parseInt(sum);
            String hex = Integer.toBinaryString(num);
            String reverse = new StringBuilder(hex).reverse().toString();
            int count = reverse.length();
            for (int i = 0; i < count ; i ++){
                if (reverse.charAt(i) == '1' ){
                    result.add(2);
                }
            }
        }catch (Exception e){

        }
        return null;
    }

    /**
     * 将数字拆分成2的幂的和
     * @param sum
     * @return
     */
    public static int[] toUgroupArray(int sum){
        if(sum <= 0 ){
           return null;
        }
        String binaryCode = Integer.toBinaryString(sum);
        int index = binaryCode.length() -1;
        String str = "";
        for(int i=0;i<binaryCode.length();i++){
            if(binaryCode.charAt(i) == '1'){
                str = str + index +",";
            }
            index --;
        }
        str = str.substring(0, str.length()-1);
        String[] strArray = str.split(",");
        int[] result = new int[strArray.length];
        for(int i=0;i<strArray.length;i++){
            result[i] = 2 << (Integer.parseInt(strArray[i])-1);
            if (result[i] == 0){
                result[i] = 1;
            }
        }
        return result;
    }

    public static String getFileLastName(String fileName){
        if (isNotEmpty(fileName) && fileName.contains(".")){
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return null;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str 需要判断的值
     * @return true :是
     */
    public static boolean isNumeric(String str){
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }



    public static void main(String[] args) throws Exception{
       System.out.println(JSON.toJSONString(getCarInfo15W("632123820927051")));

    }


    /**
     * 从18位身份证中获取年龄、性别
     * @param CardCode
     * @return
     * @throws Exception
     */
    public static Map<String, String> getCarInfo(String CardCode){
        Map<String, String> map = new HashMap<String, String>();
        String year = CardCode.substring(6).substring(0, 4);// 得到年份
        String yue = CardCode.substring(10).substring(0, 2);// 得到月份
         String day=CardCode.substring(12).substring(0,2);//得到日
        String birthDay = year+"-"+yue+"-"+day;
        String sex;
        if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
            sex = "2";
        } else {
            sex = "1";
        }
        Date date = new Date();// 得到当前的系统时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fyear = format.format(date).substring(0, 4);// 当前年份
        String fyue = format.format(date).substring(5, 7);// 月份
         String fday=format.format(date).substring(8,10);
        int age = 0;
        if (Integer.parseInt(yue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
            age = Integer.parseInt(fyear) - Integer.parseInt(year) + 1;
        } else {// 当前用户还没过生
            age = Integer.parseInt(fyear) - Integer.parseInt(year);
        }
        map.put("sex", sex);
        map.put("age", String.valueOf(age));
        map.put("birthDay",birthDay);
        return map;
    }


    /**
     * 15位身份证的验证
     *
     * @param
     * @throws Exception
     */
    public static Map<String, String> getCarInfo15W(String card) {
        Map<String, String> map = new HashMap<String, String>();
        String uyear = "19" + card.substring(6, 8);// 年份
        String uyue = card.substring(8, 10);// 月份
         String uday=card.substring(10, 12);//日
        String birthDay = uyear+"-"+uyue+"-"+uday;
        String usex = card.substring(14, 15);// 用户的性别
        String sex;
        if (Integer.parseInt(usex) % 2 == 0) {
            sex = "2";
        } else {
            sex = "1";
        }
        Date date = new Date();// 得到当前的系统时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fyear = format.format(date).substring(0, 4);// 当前年份
        String fyue = format.format(date).substring(5, 7);// 月份
        // String fday=format.format(date).substring(8,10);
        int age = 0;
        if (Integer.parseInt(uyue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear) + 1;
        } else {// 当前用户还没过生
            age = Integer.parseInt(fyear) - Integer.parseInt(uyear);
        }
        map.put("sex", sex);
        map.put("age", String.valueOf(age));
        map.put("birthDay",birthDay);
        return map;
    }

}
