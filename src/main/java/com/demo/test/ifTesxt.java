package com.demo.test;

public class ifTesxt {
    public static void main(String[] args) {
        String s = "腹部B超异常:肝多发性 囊肿,\n" +
                "肝内增强回声（血管瘤？）,\n" +
                "肝内钙化点灶。;超重;血常规异常：血小板偏低;空腹血糖受损";

        s = s.replaceAll("\r|\n", "");

        System.out.println(s);
    }
}
