package com.xiaogong.hw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Program: xiaogong
 * @Description: 字符个数统计
 * @Author: xiongke
 * @Create: 2024-07-24
 */
public class HJ10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        if (input == null || input.isEmpty()) {
            System.out.println();
        }
        Set<Character> set = new HashSet<>();
        if (input != null) {
            for (char c : input.toCharArray()) {
                set.add(c);
            }
        }
        System.out.println(set.size());
    }

}
