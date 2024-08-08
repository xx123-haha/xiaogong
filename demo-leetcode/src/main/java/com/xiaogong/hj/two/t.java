package com.xiaogong.hj.two;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-08
 */
public class t {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 会议室座位总数
        int seatNum  = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        int[] seatOrLeave = Arrays.stream(str.substring(1, str.length() - 1).split(","))
                .mapToInt(Integer::parseInt).toArray();
        int result = getLastIndex(seatOrLeave, seatNum);
        System.out.println(result);
    }

    private static int getLastIndex(int[] arr, int n) {
        // 一个员工，则直接0号位置
        if (arr.length == 1) {
            return 0;
        }
        // 两个员工，则最后一个员工n-1号位置
        if (arr.length == 2) {
            return n-1;
        }
        // 记录占用的位置
        Set<Integer> set = new TreeSet<>();
        for (int i=0; i<arr.length; i++) {
            // 小于0则删除对应的位置
            if (arr[i] < 0) {
                set.remove(-arr[i]);
                continue;
            }
            // 已占用的位置总数
            int count = set.size();
            // 位置都没有占用则第一个选0位置
            if (count == 0) {
                set.add(0);
            }else if (count == 1) {
                // 第二个则选n-1号位置
                set.add(n-1);
            }else if (count > 1 && count < n) {
                // 获取占用的位置
                int[] seatedArr = new int[count];
                int p = 0;
                for (Integer item : set) {
                    seatedArr[p++] = item;
                }
                // 记录当前距离最大的两个位置的差
                int maxDis = 0;
                int left = 0;
                for (int j=0; j<seatedArr.length-1; j++) {
                    int dis = seatedArr[j+1] - seatedArr[j];
                    if (dis / 2 > maxDis) {
                        maxDis = dis / 2;
                        left = seatedArr[j];
                    }
                }
                // 当前员工占用的位置
                set.add(left + maxDis);
                // 如果是最后一个员工则返回其占用的位置
                if (i == arr.length-1) {
                    return left + maxDis;
                }
            }else if (count == n) {
                // 满位置时则返回-1
                return -1;
            }
        }
        return -1;
    }

}
