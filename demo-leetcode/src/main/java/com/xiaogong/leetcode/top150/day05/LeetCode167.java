package com.xiaogong.leetcode.top150.day05;

import java.util.Arrays;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-03
 */
public class LeetCode167 {

    public static void main(String[] args) {
        int[] ints = new LeetCode167().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0,right = numbers.length - 1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                res[0] = left+1;
                res[1] = right+1;
                break;
            }else if (sum > target){
                right--;
            }else {
                left++;
            }
        }
        return res;
    }
}
