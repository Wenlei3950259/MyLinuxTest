package com.demo.util;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.math3.util.Precision.EPSILON;

/**
 * @Author : wenL
 * @create 2023/10/19 15:22
 */
public class ifTest {
    private static final String FTCL = "高胆固醇血症";
    private static final String FSC = "高甘油三酯血症";
    private static final String GXZZ = "高血脂症";


    public static Float str2Num(String num) {
        if (StringUtil.isEmpty(num) || !StringUtil.isNumber(num)) {
            return null;
        }
        Float f = Float.valueOf(num);
        return f;
    }

    public static boolean istotalCholesterol2(Float f, Float f2) {
        if (null == f && null == f2) {
            return false;
        }
        if (null != f) {
            return f > 6.1f;
        } else {
            return f2 > 3.1f;
        }
    }

    public static boolean istotalCholesterol(Float f) {
        if (null == f) {
            return false;
        }
        return f >= 5.1f;
    }

    public static boolean istriglycerides(Float f) {
        if (null == f) {
            return false;
        }
        return f > 1.7f;
    }

    public static boolean istotalCholesterol4(Float f) {
        if (null == f) {
            return false;
        }
        return f >= 3.3f;
    }

    public static void main(String[] args) {
        Float ftcl = str2Num("");
        Float ftl = str2Num("");
            Float ldlCholesterolNumber = str2Num("3.3");
        List<String> exception = new ArrayList<>();

        if (null != ftcl || null != ftl || null != ldlCholesterolNumber) {
            if (checkHypertension(ftcl, ftl, ldlCholesterolNumber)) {
                //有高脂血症 取重
                exception.remove(FTCL);
                exception.remove(FSC);
                exception.add(GXZZ);
            }
            for (String s : exception) {
                System.out.println(s);
            }
        }

    }

    public static boolean checkHypertension(Float f1, Float f2, Float f3) {
        if (f1 != null && f1 >= 5.1f) {
            return true;
        } else if (f2 != null && f2 >= 1.7f) {
            return true;
        } else if (f3 != null && f3 >= 3.3f) {
            return true;
        } else {
            return false;
        }
    }
}
