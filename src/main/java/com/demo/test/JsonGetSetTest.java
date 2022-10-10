package com.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class JsonGetSetTest {

    public static void readFile() {
        try (
                InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\20210526\\bbb.txt"));
                BufferedReader reader = new BufferedReader(isr);
        ) {
            String line = null;
            String tableName = "phms_lis_doctor";
            while ((line = reader.readLine()) != null) {
                JSONObject lineJson = JSON.parseObject(line);
                String sql = sqlInsert(lineJson, tableName);
                System.out.println(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String sqlInsert(JSONObject lineJson, String tableName) {
        //先转成 insert into tableName (若干字段) 形式
        StringBuilder sb = new StringBuilder("INSERT INTO ")
                .append(tableName)
                .append(" (");

        for (String key : lineJson.keySet()) {
            if ("deleteField".equals(key)) {
                continue;
            }
            sb.append(key).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        // 转成 VALUES("内容"); 形式
        sb.append(") VALUES ( ");
        for (String key : lineJson.keySet()) {
            if ("deleteField".equals(key)) {
                continue;
            }
            sb.append("\"")
                    .append(lineJson.getString(key))
                    .append("\"");

            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")").append(";");

        return sb.toString();
    }

    public static void main(String[] args) {
        readFile();
    }
}
