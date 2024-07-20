package com.xiaogong.leetcode.top150.day05;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-03
 */
public class LeetCode392 {

    public static void main(String[] args) {
        boolean subsequence = new LeetCode392().isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }

    public boolean isSubsequence(String s, String t) {
        int one = 0, two = 0;
        while (one < s.length() && two < t.length()) {
            if (s.charAt(one)==t.charAt(two)) {
                one++;
            }
            two++;
        }
        return one== s.length();
    }
}
