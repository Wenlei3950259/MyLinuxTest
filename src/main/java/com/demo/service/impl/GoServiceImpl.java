package com.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.demo.config.util.LoveTalkApi;
import com.demo.config.wx.Bootstrap;
import com.demo.config.wx.GirlFriend;
import com.demo.config.wx.MessageFactory;
import com.demo.config.wx.Wx;
import com.demo.service.GoService;
import org.springframework.stereotype.Service;

@Service
public class GoServiceImpl implements GoService {
    //宝
    public final String userId = "oPTRz6n36QYZmupHpYxCK78EXswE";
    //我
    public final String my = "oPTRz6p2lFAOjhwZkQoO86e1it2c";

    @Override
    public void send() {
        Bootstrap.init();
        LoveTalkApi loveTalkApi = new LoveTalkApi();
        String time = DateUtil.today();
        String lastTime = time.substring(time.length() - 2, time.length());


        String yima = "早安打工人~";
        if (lastTime.equals("07")) {
            yima = getYiMa();
        }

        GirlFriend girlFriend = new GirlFriend("张媛媛",
                "四川省", "泸县", time, yima, "1997-07-30", "2022-10-01 09:00:00", loveTalkApi.getLove(), userId);
        Wx.sendTemplateMessage(MessageFactory.resolveMessage(girlFriend));
        System.out.println("已发送" + time);
    }

    private String getYiMa() {
        return "今天是你来姨妈的日子了哇,照顾好自己哦,抱抱";
    }
}
