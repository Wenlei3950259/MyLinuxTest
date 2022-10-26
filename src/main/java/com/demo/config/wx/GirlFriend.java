package com.demo.config.wx;

/**
 * 你可以new一个女朋友
 *
 * @author DokiYolo
 * Date 2022-08-22
 */
public class GirlFriend extends Friend {

    public GirlFriend(String fullName, String province, String city,String today ,String yima,String birthday, String meetTime,String loveTalk, String userId) {
        super(fullName, province, today,yima,city, userId, birthday, meetTime,loveTalk, "女");
    }
}
