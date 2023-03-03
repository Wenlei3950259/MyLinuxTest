package com.demo.test;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class KK2 {
    public static void main(String[] args) {
        Apple apple = new Apple();
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();
        fruitArrayList.add(new Fruit("1","wen"));
        fruitArrayList.add(new Fruit("2","传"));

        apple.setFruits(fruitArrayList);
        String s = JSONObject.toJSONString(apple);
        System.out.println(s);

        apple.getFruits().removeAll(apple.getFruits());
        String s1 = JSONObject.toJSONString(apple);
        System.out.println(s1);
    }
}
