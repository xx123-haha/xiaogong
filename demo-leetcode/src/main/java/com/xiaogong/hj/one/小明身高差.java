package com.xiaogong.hj.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-08-15
 */
public class 小明身高差 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int xiaoMing = scanner.nextInt();
        int two = scanner.nextInt();
        List<Integer> arrayList = new ArrayList<>(two);
        for (int i = 0; i < two; i++) {
            arrayList.add(scanner.nextInt());
        }
        arrayList.sort((a, b) -> {
            int aAbs = Math.abs(a - xiaoMing);
            int bAbs = Math.abs(b - xiaoMing);
            if (aAbs == bAbs) {
                return Integer.compare(a,b);
            }else {
                return Integer.compare(aAbs,bAbs);
            }
        });
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
    }
}

