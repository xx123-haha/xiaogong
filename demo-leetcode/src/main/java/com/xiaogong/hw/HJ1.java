package com.xiaogong.hw;

import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description: 字符串最后一个单词的长度
 * @Author: xiongke
 * @Create: 2024-07-23
 */
public class HJ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean b = sc.hasNextLine();
        while (b) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            System.out.println(split[split.length - 1].length());
            b = sc.hasNextLine();
        }
    }

}
