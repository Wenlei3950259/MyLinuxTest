package com.demo.config.wx;

/**
 * 你可以new一个女朋友
 *
 * @author DokiYolo
 * Date 2022-08-22
 */
public class GirlFriend extends Friend {
//luckyNumber;
//luckyFriend;
//luckyColor;
//money;
//luckyWork;
//summary;
    public GirlFriend(String fullName, String province, String city, String birthday, String loveTime, String userId,
                      String loveTalk, String luckyNumber, String luckyFriend, String luckyColor, String money, String luckyWork, String summary) {
        super(fullName, province, city, userId, birthday, loveTime, "女",
                loveTalk,luckyNumber,luckyFriend,luckyColor,money,luckyWork,summary);
    }

}
