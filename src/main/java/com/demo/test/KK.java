package com.demo.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KK {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        List<NotCompletedInfo> infoList = new ArrayList<>();
        HealthformWrapperDTO dto = new HealthformWrapperDTO();


        infoList.add(new NotCompletedInfo("家庭病床史", "familyHisList"));
        map.put("notCompletedInfo",infoList);
        map.put("healthformWrapperDTO",dto);

        Map map1 = JSONObject.parseObject(JSONObject.toJSONString(map), Map.class);
        List<NotCompletedInfo> infoLis2t = (List<NotCompletedInfo>) map1.get("notCompletedInfo");
        for (NotCompletedInfo s : infoLis2t) {
            Object name = s.getOptionValue().get("name");

            System.out.println(name);
        }
        System.out.println(infoLis2t);
    }

}
