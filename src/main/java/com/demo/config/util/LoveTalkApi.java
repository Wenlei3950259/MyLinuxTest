package com.demo.config.util;

import cn.hutool.http.HttpUtil;

public class LoveTalkApi {

    private static String url = "https://api.1314.cool/words/api.php";

    public String getLove() {
        String s = HttpUtil.get(url);
        return deleteNotBrHtml(s);
    }

    public static String deleteNotBrHtml(String cs) {
//        return Pattern.compile("<br([^>]*)>").matcher(cs).replaceAll("").replaceAll("</br>","");
        return cs.replace("<br>", "\n");

    }


}
