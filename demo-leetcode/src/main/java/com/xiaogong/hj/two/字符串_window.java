package com.xiaogong.hj.two;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-08
 */
public class 字符串_window {

    public static void main(String[] args) {
        String string = "abC124ACb";
        System.out.println(findLongestValidSubstring(string));
    }

    public static int findLongestValidSubstring(String s) {
        int left = 0, right = 0, maxLength = -1, sCount = 0, nCount = 0;
        while (right < s.length()) {
            char charAt = s.charAt(right);
            if (Character.isLetter(charAt)) {
                sCount++;
            } else if (Character.isDigit(charAt)) {
                nCount++;
            }

            while (sCount > 1) {
                char sChar = s.charAt(left);
                if (Character.isLetter(sChar)) {
                    sCount--;
                }
                left++;
            }

            if (sCount==1 && nCount>=1){
                maxLength=Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;
    }


}
