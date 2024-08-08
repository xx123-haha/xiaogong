package com.xiaogong.hj.two;

import java.util.*;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-08
 */
public class 田忌赛马 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] a = new int[n];
        // int[] b = new int[n];
        // for (int i = 0; i < n; i++) {
        //     a[i] = sc.nextInt();
        // }
        // for (int i = 0; i < n; i++) {
        //     b[i] = sc.nextInt();
        // }
        //
        // Scanner sc = new Scanner(System.in);
        // int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // int[] b = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //
        // System.out.println(countOptimalPermutations(a, b));
        // int result = countOptimalPermutations(a, b);

        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6};
        System.out.println(countOptimalPermutations(A, B));
    }

    private static int countOptimalPermutations(int[] a, int[] b) {
        int n = a.length;

        // 对数组a和b进行排序
        Arrays.sort(a);
        Arrays.sort(b);

        // dp[i][j]表示前i个a中，前j个b的最大a[i] > b[i]数量
        int[][] dp = new int[n + 1][n + 1];

        // 初始状态
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; // 前i个a和0个b的最大数量为0
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0; // 0个a和前j个b的最大数量为0
        }

        // 填充DP表
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (a[i - 1] > b[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 找到最大数量
        int maxCount = dp[n][n];

        // 计算所有达到最大数量的排列数
        int result = countPermutations(a, b, maxCount);
        return result;
    }

    // 计算所有达到最大数量的排列数
    private static int countPermutations(int[] a, int[] b, int maxCount) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Arrays a and b must have the same length.");
        }

        int n = a.length;

        // 计算所有a的排列
        List<List<Integer>> permutations = generatePermutations(a);

        int count = 0;
        for (List<Integer> perm : permutations) {
            int[] permArray = perm.stream().mapToInt(Integer::intValue).toArray();
            int validCount = 0;

            // 计算当前排列的a与b的比较
            for (int i = 0; i < n; i++) {
                if (permArray[i] > b[i]) {
                    validCount++;
                }
            }

            // 如果当前排列的有效数量等于最大数量，则计数
            if (validCount == maxCount) {
                count++;
            }
        }

        return count;
    }

    // 生成所有排列
    private static List<List<Integer>> generatePermutations(int[] array) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(array, 0, permutations);
        return permutations;
    }

    // 递归生成排列
    private static void permute(int[] array, int start, List<List<Integer>> permutations) {
        if (start == array.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int value : array) {
                permutation.add(value);
            }
            permutations.add(permutation);
        } else {
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                permute(array, start + 1, permutations);
                swap(array, start, i); // 回溯
            }
        }
    }

    // 交换数组中的元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
