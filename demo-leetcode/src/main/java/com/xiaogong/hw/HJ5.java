package com.xiaogong.hw;

import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description: 进制转换
 * @Author: xiongke
 * @Create: 2024-07-24
 */
public class HJ5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String realInput = input.substring(2);
        int res = Integer.parseInt(realInput, 16);
        System.out.println(res);
    }

}
