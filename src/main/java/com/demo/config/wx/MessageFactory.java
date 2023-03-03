package com.demo.config.wx;

import cn.hutool.core.util.StrUtil;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.ArrayList;
import java.util.List;

import static com.demo.config.wx.GaodeUtil.getAdcCode;

/**
 * @author DokiYolo
 * Date 2022-08-22
 */
public class MessageFactory {

    public static WxMpTemplateMessage resolveMessage(Friend friend) {
        return WxMpTemplateMessage.builder()
                .url("https://ofpp.cn") // 点击后的跳转链接 可自行修改 也可以不填
                .toUser(friend.getUserId())
                .templateId(StrUtil.emptyToDefault(friend.getTemplateId(), Bootstrap.TEMPLATE_ID))
                .data(buildData(friend))
                .build();
    }

    public static WxMpTemplateMessage resolveMessageNew(NewHot newHot) {
        return WxMpTemplateMessage.builder()
                .url("https://ofpp.cn") // 点击后的跳转链接 可自行修改 也可以不填
                .toUser(newHot.getUserId())
                .templateId(StrUtil.emptyToDefault(newHot.getTemplateId(), Bootstrap.TEMPLATE_ID_NEW))
                .data(buildData2(newHot))
                .build();
    }

    private static List<WxMpTemplateData> buildData2(NewHot newHot) {
        ArrayList<WxMpTemplateData> list = new ArrayList<>();

        list.add(TemplateDataBuilder.builder().name("title1").value((newHot.getTitle1())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title2").value((newHot.getTitle2())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title3").value((newHot.getTitle3())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title4").value((newHot.getTitle4())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title5").value((newHot.getTitle5())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title6").value((newHot.getTitle6())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title7").value((newHot.getTitle7())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title8").value((newHot.getTitle8())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title9").value((newHot.getTitle9())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title10").value((newHot.getTitle10())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title11").value((newHot.getTitle11())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title12").value((newHot.getTitle12())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title13").value((newHot.getTitle13())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title14").value((newHot.getTitle14())).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("title15").value((newHot.getTitle15())).color("#F00000").build());

        list.add(TemplateDataBuilder.builder().name("digest1").value(newHot.getDigest1()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest2").value(newHot.getDigest2()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest3").value(newHot.getDigest3()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest4").value(newHot.getDigest4()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest5").value(newHot.getDigest5()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest6").value(newHot.getDigest6()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest7").value(newHot.getDigest7()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest8").value(newHot.getDigest8()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest9").value(newHot.getDigest9()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest10").value(newHot.getDigest10()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest11").value(newHot.getDigest11()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest12").value(newHot.getDigest12()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest13").value(newHot.getDigest13()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest14").value(newHot.getDigest14()).color("#F00000").build());
        list.add(TemplateDataBuilder.builder().name("digest15").value(newHot.getDigest15()).color("#F00000").build());

        return list;
    }


    private static List<WxMpTemplateData> buildData(Friend friend) {
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(getAdcCode(friend.getProvince(), friend.getCity()));
        RandomAncientPoetry.AncientPoetry ancientPoetry = RandomAncientPoetry.getNext();
        ArrayList<WxMpTemplateData> list = new ArrayList<>();


        //你叫{{friendName.DATA}}
        list.add(TemplateDataBuilder.builder().name("friendName").value(friend.getFullName()).color("#F00000").build());
        //今年{{howOld.DATA}}
        list.add(TemplateDataBuilder.builder().name("howOld").value(friend.getHowOld().toString()).color("#99CC33").build());
        //距离下一次生日{{nextBirthday.DATA}}天
        list.add(TemplateDataBuilder.builder().name("nextBirthday").value(friend.getNextBirthdayDays()).color("#FF6600").build());
        //宝宝我们已经认识{{nextMemorialDay.DATA}}天了
        list.add(TemplateDataBuilder.builder().name("nextMemorialDay").value(friend.getNextMemorialDay()).color("#990033").build());
        //今天的{{province.DATA}}{{city.DATA}}天气
        list.add(TemplateDataBuilder.builder().name("province").value(friend.getProvince()).color("#6699CC").build());
        list.add(TemplateDataBuilder.builder().name("city").value(friend.getCity()).color("#99CCFF").build());
        //当前天气{{weather.DATA}}
        list.add(TemplateDataBuilder.builder().name("weather").value(weather.getWeather()).color("#00B42A").build());
        //当前气温{{temperature.DATA}}
        list.add(TemplateDataBuilder.builder().name("temperature").value(weather.getTemperature()).color("#722ED1").build());
        //风力描述{{winddirection.DATA}}
        list.add(TemplateDataBuilder.builder().name("winddirection").value(weather.getWinddirection()).color("#F5319D").build());
        //风力级别{{windpower.DATA}}
        list.add(TemplateDataBuilder.builder().name("windpower").value(weather.getWindpower()).color("#3491FA").build());
        //空气湿度{{windpower.DATA}}
        list.add(TemplateDataBuilder.builder().name("humidity").value(weather.getHumidity()).color("#66CC00").build());

        //双子座今日各个运势
        //幸运数字 {luckyNumber}
        list.add(TemplateDataBuilder.builder().name("luckyNumber").value(friend.getLuckyNumber()).color("#CD0000").build());
        //幸运星座 {luckyFriend}
        list.add(TemplateDataBuilder.builder().name("luckyFriend").value(friend.getLuckyFriend()).color("#33CC99").build());
        //幸运颜色 {luckyColor}

        String luckyColor = friend.getLuckyColor();
        String color = "";
        color = eqColor(luckyColor, color);
        list.add(TemplateDataBuilder.builder().name("luckyColor").value(friend.getLuckyColor()).color(color).build());
        //财运  {money}
        list.add(TemplateDataBuilder.builder().name("money").value(friend.getMoney()).color("#EEEE00").build());
        //工作幸运指数 {luckyWork}
        list.add(TemplateDataBuilder.builder().name("luckyWork").value(friend.getLuckyWork()).color("#663305").build());
        //运势 {summary}
        list.add(TemplateDataBuilder.builder().name("summary").value(friend.getSummary()).color("#9933CC").build());


        //古诗
        list.add(TemplateDataBuilder.builder().name("author").value(ancientPoetry.getAuthor()).color("#009966").build());
        list.add(TemplateDataBuilder.builder().name("origin").value(ancientPoetry.getOrigin()).color("#009966").build());
        list.add(TemplateDataBuilder.builder().name("content").value(ancientPoetry.getContent()).color("#009966").build());
        //和宝宝说油腻腻的话鸭{}
        list.add(TemplateDataBuilder.builder().name("loveTalk").value(friend.getLoveTalk()).color("ff6699").build());
        return list;
    }

    private static String eqColor(String luckyColor, String color) {
        if (luckyColor.contains("红")) {
            color = "#FF3030";
        } else if (luckyColor.contains("蓝")) {
            color = "#0000FF";
        } else if (luckyColor.contains("黄")) {
            color = "#FFFF00";
        } else if (luckyColor.contains("绿")) {
            color = "#00FF33";
        } else if (luckyColor.contains("杏")) {
            color = "#FFFACD";
        } else if (luckyColor.contains("青")) {
            color = "#97FFFF";
        } else if (luckyColor.contains("黑")) {
            color = "#C000000";
        } else if (luckyColor.contains("白")) {
            color = "#FFFAFA";
        } else if (luckyColor.contains("紫")) {
            color = "#871F78";
        }
        return color;
    }

    static class TemplateDataBuilder {
        private String name;
        private String value;
        private String color;

        public static TemplateDataBuilder builder() {
            return new TemplateDataBuilder();
        }

        public TemplateDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TemplateDataBuilder value(String value) {
            this.value = value;
            return this;
        }

        public TemplateDataBuilder color(String color) {
            this.color = color;
            return this;
        }

        public WxMpTemplateData build() {
            if (StrUtil.hasEmpty(name, value)) {
                throw new IllegalArgumentException("参数不正确");
            }
            WxMpTemplateData data = new WxMpTemplateData();
            data.setName(name);
            data.setValue(value);
            data.setColor(color);
            return data;
        }
    }

}
