package com.xiaogong.hj.one;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Program: xiaogong
 * @Description: 好朋友下标
 * @Author: xiongke
 * @Create: 2024-08-07
 */
public class 栈数组 {

    public static int[] findFriends(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }

        // 栈中剩余的元素没有找到比它高的元素
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = {150, 160, 170, 180, 140, 175, 165};
        int[] heights2 = {123, 124, 125, 121, 119, 122, 126, 123};
        int[] friends = findFriends(heights2);
        // 输出：[2, 3, 4, 0, 6, 0, 0]
        System.out.println(Arrays.toString(friends));
    }

}
