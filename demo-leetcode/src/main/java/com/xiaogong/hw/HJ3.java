package com.xiaogong.hw;

import java.util.*;

/**
 * @Program: xiaogong
 * @Description: 明明的随机数
 * @Author: xiongke
 * @Create: 2024-07-24
 */
public class HJ3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            set.add(sc.nextInt());
        }
        // set.stream().sorted().forEach(System.out::println);
        set.forEach(System.out::println);
    }

    private void sortMethod(){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] array = new int[count];

        for (int i = 0; i < count; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i]==array[i-1]){
                continue;
            }
            System.out.println(array[i]);
        }
    }

}
