package com.xiaogong.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description: 字符串排序
 * @Author: xiongke
 * @Create: 2024-07-27
 */
public class HJ14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> list = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            list.add(sc.next());
        }
        list.stream().sorted().forEach(System.out::println);
    }

}
