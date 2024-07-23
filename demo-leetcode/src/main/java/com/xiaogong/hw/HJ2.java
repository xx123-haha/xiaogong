package com.xiaogong.hw;

import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description: 计算某字符出现次数
 * @Author: xiongke
 * @Create: 2024-07-23
 */
public class HJ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine().toUpperCase();
        String str2 = sc.nextLine().toUpperCase();
        int count = 0;
        for(int i=0;i<str1.length();i++){
            char c = str1.charAt(i);
            if (c == str2.charAt(0)){
                count++;
            }
        }
        System.out.println(count);
    }
}
