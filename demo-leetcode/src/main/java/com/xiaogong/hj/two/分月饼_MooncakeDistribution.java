package com.xiaogong.hj.two;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-09
 */
public class 分月饼_MooncakeDistribution {

    private static int count = 0;

    // 递归生成所有可能的分配方案
    public static void distribute(int m, int n, int maxPrev, int[] distribution, int index) {
        if (index == m) {
            if (n == 0) {
                // 检查分配是否符合条件
                if (isValidDistribution(distribution)) {
                    count++;
                }
            }
            return;
        }

        int start = (index == 0) ? 1 : Math.max(1, distribution[index - 1] - 3);
        int end = Math.min(n, maxPrev);

        for (int i = start; i <= end; i++) {
            distribution[index] = i;
            distribute(m, n - i, i, distribution, index + 1);
        }
    }

    // 检查分配是否符合条件
    private static boolean isValidDistribution(int[] distribution) {
        int[] counts = new int[distribution.length];
        System.arraycopy(distribution, 0, counts, 0, distribution.length);
        java.util.Arrays.sort(counts);

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] - counts[i - 1] > 3) {
                return false;
            }
        }
        return true;
    }

    public static int distributeMooncakes(int m, int n) {
        if (m > n) {
            return 0;
        }
        count = 0;
        int[] distribution = new int[m];
        distribute(m, n, n, distribution, 0);
        return count;
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(distributeMooncakes(3, 5)); // 应输出 6
    }
}



