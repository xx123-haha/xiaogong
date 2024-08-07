package com.xiaogong.hw;

import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description: 查找两个字符串a, b中的最长公共子串
 * @Author: xiongke
 * @Create: 2024-07-27
 */
public class HJ65 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            if (str1.length()< str2.length()){
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            int m = str1.length(), n = str2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                char c1 = str1.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    char c2 = str2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            // 截取最大公共子串
            System.out.println();
        }
    }

}
