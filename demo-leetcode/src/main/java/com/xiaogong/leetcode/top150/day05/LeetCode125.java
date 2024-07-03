package com.xiaogong.leetcode.top150.day05;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-03
 */
public class LeetCode125 {

    public static void main(String[] args) {
        boolean palindrome = new LeetCode125().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }

    public boolean isPalindrome(String s) {
        if (s.length()==1) {
            return true;
        }
        String regex = "[^a-zA-Z0-9]";
        String lowerCase = s.replaceAll(regex, "").toLowerCase();
        int left = 0,right = lowerCase.length()-1;
        while (left<right){
            if (lowerCase.charAt(left) != lowerCase.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
