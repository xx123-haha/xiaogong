package com.xiaogong.hj.one;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-08
 */
public class 攀登者1 {
    public static int countPeaks(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int peakCount = 0;

        for (int i = 0; i < heights.length; i++) {
            // 左边界
            if (i == 0) {
                if (heights[i] > heights[i + 1]) {
                    peakCount++;
                }
            }
            // 右边界
            else if (i == heights.length - 1) {
                if (heights[i] > heights[i - 1]) {
                    peakCount++;
                }
            }
            // 中间位置
            else {
                if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                    peakCount++;
                }
            }
        }

        return peakCount;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 4, 3, 1, 0, 0, 1, 2, 3, 1, 2, 1, 0};
        int peakCount = countPeaks(heights);
        System.out.println("山峰数量: " + peakCount);
    }
}
