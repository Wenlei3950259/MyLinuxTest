package com.demo.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

import java.awt.*;

public class hutool {

    public static void main(String[] args) {

        // 射手座
        String zodiac = DateUtil.getZodiac(Month.DECEMBER.getValue(), 10);
        System.out.println(zodiac);
        // 蛇
        String chineseZodiac = DateUtil.getChineseZodiac(1989);
        String chineseZodiac1 = DateUtil.getChineseZodiac(1998);
        System.out.println(chineseZodiac);
        System.out.println(chineseZodiac1);
        QrCodeUtil.generate(//
                "http://hutool.cn/", //二维码内容
                QrConfig.create().setImg("C:\\Users\\lai dian sheng yin b\\Desktop\\SQL\\maomao.jpg"), //附带logo
                FileUtil.file("e:/qrcodeWithLogo.jpg")//写出到的文件
        );
    }
}
