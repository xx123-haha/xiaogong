package com.xiaogong.arrayList;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-28
 */
public class etst implements Runnable{

    public static void main(String[] args) {
    new etst().run();
    new Thread(new etst()).run();
    new Thread(new etst()).start();
    }

    @Override
    public void run() {
        System.out.println(1);
    }
}
