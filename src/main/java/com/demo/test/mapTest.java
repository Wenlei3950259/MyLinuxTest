package com.demo.test;

import java.util.*;

public class mapTest {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> existString = new HashSet<>();

        if (s.length() <= 10) {
            return result;
        }
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (existString.contains(temp) && !result.contains(temp)) {
                result.add(temp);
            }
            existString.add(temp);
        }
        return result;
    }
    public static void main(String[] args) {

        mapTest mapTest =  new mapTest();
        List<String> a = mapTest.findRepeatedDnaSequences("ACTG");
        System.out.println(a);


    }
}
