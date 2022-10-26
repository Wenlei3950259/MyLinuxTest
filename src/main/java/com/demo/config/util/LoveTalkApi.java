package com.demo.config.util;

import cn.hutool.http.HttpUtil;

import java.util.regex.Pattern;

public class LoveTalkApi {

    private static String url ="https://api.1314.cool/words/api.php";

    public String getLove(){
        String s = HttpUtil.get(url);
        return deleteNotBrHtml(s);
    }

    public static String deleteNotBrHtml(CharSequence cs){
        return Pattern.compile("<br([^>]*)>").matcher(cs).replaceAll("").replaceAll("</br>","");
    }


}
