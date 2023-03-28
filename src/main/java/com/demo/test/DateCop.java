package com.demo.test;

import com.demo.util.StringUtil;

import java.util.stream.IntStream;

public class DateCop {
    public final static String[] HIV = {"是", "否"};

    public static void main(String[] args) {
//        String str = "1 2 3 4 5 6";
//        String delimiter = ",";
//        String[] s = str.split(" ");
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < s.length; i++) {
//            stringBuilder.append(s[i]);
//            stringBuilder.append(delimiter);
//            for (int j = 0; j < i+1; j++) {
//                stringBuilder.append("哈");
//            }
//            if (i < s.length -1) {
//                stringBuilder.append(";");
//            }
//        }
//        String s1 = stringBuilder.toString();
////        System.out.println(s1);

        String a = convertCheckBox("是", HIV);
        System.out.println(a);
    }
    public static String convertCheckBox(String value, String[] labels) {
        if (!StringUtil.isEmpty(value)) {
            if(!StringUtil.isNumber(value)){
                return value;
            }
            String binary = Integer.toBinaryString(Integer.parseInt(value));
            if (StringUtil.isNotEmpty(binary)) {
                StringBuffer buffer = new StringBuffer();
                int length = binary.length();
                for (int i = length - 1; i >= 0; i--) {
                    char c = binary.charAt(i);
                    if ('1' == c) {
                        buffer.append(labels[length - 1 - i]);
                    }
                }
                return buffer.toString();
            }
        }
        return "";
    }

}
