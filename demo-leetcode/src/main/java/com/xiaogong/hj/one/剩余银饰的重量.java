package com.xiaogong.hj.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-13
 */
public class 剩余银饰的重量 {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        //
        // // 读取银饰数组长度
        // int n = scanner.nextInt();
        //
        // // 读取银饰重量数组
        List<Integer> weights = new ArrayList<>();
        // for (int i = 0; i < n; i++) {
        //     weights.add(scanner.nextInt());
        // }

        weights.add(6);
        weights.add(10);
        weights.add(20);
        // 计算熔化后剩余的银饰重量
        int result = meltSilver(weights);

        // 输出结果
        System.out.println(result);
    }

    public static int meltSilver(List<Integer> weights) {
        // 当数组中银饰数量大于等于3时，继续熔化过程
        while (weights.size() >= 3) {
            // 将银饰按重量排序
            Collections.sort(weights);

            // 选出最重的三块银饰
            int x = weights.get(weights.size() - 3);
            int y = weights.get(weights.size() - 2);
            int z = weights.get(weights.size() - 1);

            // 移除选中的三块银饰
            weights.remove(weights.size() - 1);
            weights.remove(weights.size() - 1);
            weights.remove(weights.size() - 1);

            // 计算新的重量
            int remaining = (y - x) - (z - y);

            // 如果计算的结果不为零，添加回列表
            if (remaining != 0) {
                weights.add(Math.abs(remaining));
            }
        }

        // 最后根据剩下的银饰数量返回结果
        if (weights.size() == 2) {
            return Math.max(weights.get(0), weights.get(1));
        } else if (weights.size() == 1) {
            return weights.get(0);
        } else {
            return 0;
        }
    }
}
