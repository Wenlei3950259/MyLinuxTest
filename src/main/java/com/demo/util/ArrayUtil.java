package com.demo.util;

import com.google.common.base.Preconditions;

import java.util.Collection;

/**
 * @Author: lichengdong
 * @Since: 2019/9/16
 */
public class ArrayUtil {

    private static final String SEP = ",";

    public static String join(String[] arr, String sep){
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if(s != null && s.trim().length() > 0){
                sb.append(s.trim()).append(sep);
            }
        }
        if(sb.length() > 0){
            sb.delete(sb.lastIndexOf(sep), sb.length());
        }
        return sb.toString();
    }

    public static String join(String[] arr){
        return join(arr, SEP);
    }

    public static String join(Collection<?> arr, String sep){
        if(arr == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object s : arr) {
            if(s != null){
                sb.append(s.toString().trim()).append(sep);
            }
        }
        if(sb.length() > 0){
            sb.delete(sb.lastIndexOf(sep), sb.length());
        }
        return sb.toString();
    }

    public static String join(Collection<?> arr){
        return join(arr, SEP);
    }

    public static String leftPad(String string, int maxLength, char padChar) {
        Preconditions.checkNotNull(string);
        if (string.length() >= maxLength) {
            return string;
        } else {
            StringBuilder sb = new StringBuilder(maxLength);
            for(int i = 0; i < maxLength - string.length(); ++i) {
                sb.append(padChar);
            }
            sb.append(string);
            return sb.toString();
        }
    }
}
