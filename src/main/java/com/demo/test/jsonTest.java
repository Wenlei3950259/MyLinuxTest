package com.demo.test;

import com.demo.util.StringUtil;

import java.util.regex.Pattern;

public class jsonTest {
    public static void main(String[] args) {
        String ss = "你知道你适合穿什么衣服吗？<br>漂亮的衣服<br>不，是被我征服";
//        String s = deleteNotBrHtml(ss);
       String str = ss.replaceAll("\\n","<br>");
        String newString1 = ss.replace("<br>", "\n");
//        System.out.println(s);
        System.out.println(newString1);
    }



    public static String deleteNotBrHtml(CharSequence cs){
        return Pattern.compile("<br([^>]*)>").matcher(cs).replaceAll("").replaceAll("</br>","\n");
    }

}
