package com.xiaogong.demo2;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-17
 */
public class StringTest {

    public static void main(String[] args) {
        String str = "admin-WEB aqeq_dqhe qe";
        String method = method(str);
        System.out.println(method);
    }

    public static String method(String string){
        if (string==null||string.isEmpty()){
            return "";
        }
        if (!string.contains("-")&&!string.contains("_")&&!string.contains(" ")){
            return string;
        }
        String[] strings = string.split("[\\s\\-_]+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i==0){
                sb.append(strings[i]);
            }else {
                String firstChar = strings[i].substring(0, 1).toUpperCase();
                String lastChar = strings[i].substring(1).toLowerCase();
                sb.append(firstChar).append(lastChar);
            }
        }
        return sb.toString();
    }

}
