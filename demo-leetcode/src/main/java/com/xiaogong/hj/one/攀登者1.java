package com.xiaogong.hj.one;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-08
 */
public class 攀登者1 {
    public static void main(String[] args) {
        int[] heights = {0, 1, 2, 4, 3, 1, 0, 0, 1, 2, 3, 1, 2, 1, 0};
        List<Integer> peaks = findPeaks(heights);
        System.out.println("Total Peaks: " + peaks.size());
        for (int peak : peaks) {
            System.out.println("Peak at Index: " + peak);
        }
    }

    private static List<Integer> findPeaks(int[] heights) {
        List<Integer> peaks = new ArrayList<>();
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // Check if current position is a peak
            if ((i == 0 || heights[i] > heights[i - 1]) &&
                    (i == n - 1 || heights[i] > heights[i + 1])) {
                peaks.add(i);
            }
        }

        return peaks;
    }
}
