package com.demo.test;

import com.demo.util.StringUtil;

public class jsonTest {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean c= false;

        boolean b1 = atLeastTwo(a, b, c);
        System.out.println(b1);
    }



   static boolean atLeastTwo(boolean a, boolean b, boolean c) {
        if ((a) && (b) && ( c)) {
            return true;
        }
        else{
            return false;
        }
    }
}
