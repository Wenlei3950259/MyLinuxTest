package com.demo.config.util;

import java.util.ArrayList;
import java.util.Random;

public class ColorUtil {
    private static final ArrayList<String> list = new ArrayList<String>() {};

    static {
        list.add("#FF0000");
        list.add("#00FF00");
        list.add("#0000FF");
        list.add("#FF00FF");
        list.add("#00FFFF");
        list.add("#FFFF00");
        list.add("#000000");
        list.add("#70DB93");
        list.add("#5C3317");
        list.add("#9F5F9F");
        list.add("#B5A642");
        list.add("#D9D919");
        list.add("#A67D3D");
        list.add("#8C7853");
        list.add("#A67D3D");
        list.add("#5F9F9F");
        list.add("#D98719");
        list.add("#B87333");
        list.add("#FF7F00");
        list.add("#42426F");
        list.add("#5C4033");
        list.add("#2F4F2F");
        list.add("#4A766E");
        list.add("#4F4F2F");
        list.add("#9932CD");
        list.add("#871F78");
        list.add("#6B238E");
        list.add("#2F4F4F");
        list.add("#97694F");
        list.add("#7093DB");
        list.add("#855E42");
        list.add("#545454");
        list.add("#856363");
        list.add("#D19275");
        list.add("#8E2323");
        list.add("#238E23");
        list.add("#CD7F32");
        list.add("#DBDB70");
        list.add("#C0C0C0");
        list.add("#527F76");
        list.add("#93DB70");
        list.add("#215E21");
        list.add("#215E21");
        list.add("#4E2F2F");
        list.add("#9F9F5F");
        list.add("#C0D9D9");
        list.add("#A8A8A8");
        list.add("#8F8FBD");
        list.add("#E9C2A6");
        list.add("#32CD32");
        list.add("#E47833");
        list.add("#8E236B");
        list.add("#32CD99");
        list.add("#3232CD");
        list.add("#6B8E23");
        list.add("#EAEAAE");
        list.add("#9370DB");
        list.add("#426F42");
        list.add("#7F00FF");
        list.add("#7FFF00");
        list.add("#70DBDB");
        list.add("#DB7093");
        list.add("#A68064");
        list.add("#2F2F4F");
        list.add("#23238E");
        list.add("#4D4DFF");
        list.add("#FF6EC7");
        list.add("#00009C");
        list.add("#EBC79E");
        list.add("#CFB53B");
        list.add("#FF7F00");
        list.add("#FF2400");
        list.add("#DB70DB");
        list.add("#8FBC8F");
        list.add("#BC8F8F");
        list.add("#EAADEA");
        list.add("#D9D9F3");
        list.add("#5959AB");
        list.add("#6F4242");
        list.add("#BC1717");
        list.add("#238E68");
        list.add("#6B4226");
        list.add("#8E6B23");
        list.add("#E6E8FA");
        list.add("#3299CC");
        list.add("#007FFF");
        list.add("#FF1CAE");
        list.add("#00FF7F");
        list.add("#236B8E");
        list.add("#38B0DE");
        list.add("#DB9370");
        list.add("#D8BFD8");
        list.add("#ADEAEA");
        list.add("#5C4033");
        list.add("#CDCDCD");
        list.add("#4F2F4F");
        list.add("#CC3299");
        list.add("#D8D8BF");
        list.add("#D8D8BF");
        list.add("#99CC32");



    }

    public static String getColor() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

}
