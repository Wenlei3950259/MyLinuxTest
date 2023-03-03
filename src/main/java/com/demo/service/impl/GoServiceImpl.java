package com.demo.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.config.wx.Bootstrap;
import com.demo.config.wx.GirlFriend;
import com.demo.config.wx.MessageFactory;
import com.demo.config.wx.Wx;
import com.demo.service.GoService;
import com.demo.util.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class GoServiceImpl implements GoService {
    //宝
    public final String she = "oPTRz6ruWZV4dchdKZvsSFzRzgOE";
    //我
    public final String me = "oPTRz6p2lFAOjhwZkQoO86e1it2c";

    @Override
    public void send() {
        Bootstrap.init();
        String s = "";
        s = HttpUtil.get("https://api.1314.cool/words/api.php");
        s = s.replaceAll("(<br>)", "\n");
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("consName", "双子座");
        paramMap.put("type", "today");
        paramMap.put("key", "1de11d29c2d8dcac8d71a9a9fdc4a2fa");

        String result = HttpUtil.post("http://web.juhe.cn/constellation/getAll", paramMap);
        JSONObject jsonObject = JSON.parseObject(result);
        String luckyFriend = jsonObject.get("QFriend").toString();
        String luckyColor = jsonObject.get("color").toString();
        String luckyWork = jsonObject.get("work").toString();
        String luckyNumber = jsonObject.get("number").toString();
        String money = jsonObject.get("money").toString();
        String summary = jsonObject.get("summary").toString();


        GirlFriend girlFriend = new GirlFriend("李远丽", "重庆", "荣昌", "1998-05-25"
                , "2023-01-26", me,
                s, luckyNumber, luckyFriend, luckyColor, money, luckyWork, summary);
        Date date = new Date();
        String s1 = DateUtils.date2Str(date);
        System.out.println(s1 + " 执行");
//        Wx.sendTemplateMessage(MessageFactory.resolveMessage(girlFriend));

    }

}
