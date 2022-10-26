package com.demo.config.wx;

import cn.hutool.core.util.StrUtil;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.ArrayList;
import java.util.List;


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

    /**
     *
     * {@code {{xxxx.DATA}}} xxxx就是一个变量名，消息中设置变量 然后传递时传递变量即可
     * <br/>
     * 色彩取值可以从这里挑选 https://arco.design/palette/list
     *
     *  <p>
     *      你叫{{friendName.DATA}}
     *      今年{{howOld.DATA}}
     *      距离下一次生日{{nextBirthday.DATA}}天
     *      具体我们的下一次纪念日{{nextMemorialDay.DATA}}天
     *      现在在{{province.DATA}}{{city.DATA}}
     *      当前天气{{weather.DATA}}
     *      当前气温{{temperature.DATA}}
     *      风力描述{{winddirection.DATA}}
     *      风力级别{{windpower.DATA}}
     *      空气湿度{{humidity.DATA}}
     *      {{author.DATA}}
     *      {{origin.DATA}}
     *      {{content.DATA}}
     *  </p>
     */
    private static List<WxMpTemplateData> buildData(Friend friend) {
        WeatherInfo weather = GaodeUtil.getNowWeatherInfo(GaodeUtil.getAdcCode(friend.getProvince(), friend.getCity()));
        RandomAncientPoetry.AncientPoetry ancientPoetry = RandomAncientPoetry.getNext();
        ArrayList<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();
        WxMpTemplateData friendName = TemplateDataBuilder.builder().name("friendName").value(friend.getFullName()).color("#FFC0CB").build();
        WxMpTemplateData howOld = TemplateDataBuilder.builder().name("howOld").value(friend.getHowOld().toString()).color("#FF00FF").build();
        WxMpTemplateData howLongLived = TemplateDataBuilder.builder().name("howLongLived").value(friend.getHowLongLived()).color("#437004").build();
        WxMpTemplateData nextBirthday = TemplateDataBuilder.builder().name("nextBirthday").value(friend.getNextBirthdayDays()).color("#ADFF2F").build();
        WxMpTemplateData nextMemorialDay = TemplateDataBuilder.builder().name("nextMemorialDay").value(friend.getNextMemorialDay()).color("#9400D3").build();
        WxMpTemplateData loveTalk = TemplateDataBuilder.builder().name("loveTalk").value(friend.getLoveTalk()).color("#1E90FF").build();
        WxMpTemplateData province = TemplateDataBuilder.builder().name("province").value(friend.getProvince()).color("#F53F3F").build();
        WxMpTemplateData today = TemplateDataBuilder.builder().name("today").value(friend.getToday()).color("#A0522D").build();
        WxMpTemplateData yima = TemplateDataBuilder.builder().name("yima").value(friend.getYima()).color("#FF0000").build();
        WxMpTemplateData city = TemplateDataBuilder.builder().name("city").value(friend.getCity()).color("#FADC19").build();
        WxMpTemplateData weather1 = TemplateDataBuilder.builder().name("weather").value(weather.getWeather()).color("#00B42A").build();
        WxMpTemplateData temperature = TemplateDataBuilder.builder().name("temperature").value(weather.getTemperature()).color("#722ED1").build();
        WxMpTemplateData winddirection = TemplateDataBuilder.builder().name("winddirection").value(weather.getWinddirection()).color("#F5319D").build();
        WxMpTemplateData windpower = TemplateDataBuilder.builder().name("windpower").value(weather.getWindpower()).color("#0000CD").build();
        WxMpTemplateData humidity = TemplateDataBuilder.builder().name("humidity").value(weather.getHumidity()).color("#D2691E").build();
        WxMpTemplateData author = TemplateDataBuilder.builder().name("author").value(ancientPoetry.getAuthor()).color("#F53F3F").build();
        WxMpTemplateData origin = TemplateDataBuilder.builder().name("origin").value(ancientPoetry.getOrigin()).color("#F53F3F").build();
        WxMpTemplateData content = TemplateDataBuilder.builder().name("content").value(ancientPoetry.getContent()).color("#F53F3F").build();
        wxMpTemplateData.add(friendName);
        wxMpTemplateData.add(howOld);
        wxMpTemplateData.add(howLongLived);
        wxMpTemplateData.add(nextBirthday);
        wxMpTemplateData.add(nextMemorialDay);
        wxMpTemplateData.add(loveTalk);
        wxMpTemplateData.add(province);
        wxMpTemplateData.add(today);
        wxMpTemplateData.add(yima);
        wxMpTemplateData.add(city);
        wxMpTemplateData.add(weather1);
        wxMpTemplateData.add(temperature);
        wxMpTemplateData.add(windpower);
        wxMpTemplateData.add(winddirection);
        wxMpTemplateData.add(author);
        wxMpTemplateData.add(humidity);
        wxMpTemplateData.add(origin);
        wxMpTemplateData.add(content);

        return wxMpTemplateData;
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
