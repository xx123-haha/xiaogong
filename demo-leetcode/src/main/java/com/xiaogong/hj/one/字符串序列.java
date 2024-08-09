package com.xiaogong.hj.one;

import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-09
 */
public class 字符串序列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String l = scanner.nextLine();

        int res = findLastValidPosition(s,l);

        System.out.println(res);
    }

    private static int findLastValidPosition(String s, String l) {
        int lastPosition = -1;
        int sIndex = 0; // 记录 S 中当前正在查找的字符的位置

        for (int i = 0; i < l.length() && sIndex < s.length(); i++) {
            char lChar = l.charAt(i);
            char sChar = s.charAt(sIndex);

            if (lChar == sChar) {
                sIndex++; // 移动到下一个字符
                lastPosition = i; // 更新最后的位置
            }
        }

        return lastPosition;
    }

}
