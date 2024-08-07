package com.xiaogong.hj.one;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Program: xiaogong
 * @Description: [数组, 排序]
 * @Author: xiongke
 * @Create: 2024-08-07
 */
public class 数组排序 {

    public static int maxMinSum(int[] nums, int N) {
        // 去重
        Set<Integer> uniqueNumsSet = new HashSet<>();
        for (int num : nums) {
            uniqueNumsSet.add(num);
        }
        Integer[] uniqueNums = uniqueNumsSet.toArray(new Integer[0]);

        // 检查数组长度是否至少为2N
        if (uniqueNums.length < 2 * N) {
            return -1;
        }

        // 排序
        Arrays.sort(uniqueNums);

        // 找出最小N个数和最大N个数
        int[] minN = new int[N];
        int[] maxN = new int[N];

        for (int i = 0; i < N; i++) {
            minN[i] = uniqueNums[i];
            maxN[i] = uniqueNums[uniqueNums.length - 1 - i];
        }

        // 检查最大N个数和最小N个数是否有重叠
        Set<Integer> minNSet = new HashSet<>();
        for (int num : minN) {
            minNSet.add(num);
        }

        for (int num : maxN) {
            if (minNSet.contains(num)) {
                return -1;
            }
        }

        // 计算最大N个数与最小N个数的和
        int sum = 0;
        for (int num : minN) {
            sum += num;
        }
        for (int num : maxN) {
            sum += num;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] num3 = new int[m];
        for (int i = 0; i < m; i++) {
            num3[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        System.out.println(maxMinSum(num3, n));
        // int[] nums = {95, 88, 83, 64, 100};
        // int[] nums2 = {3, 2, 3, 4, 2};
        // int N = 2;
        // System.out.println(maxMinSum(nums2, N));  // 输出：96
    }
}
