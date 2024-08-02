package com.xiaogong.demo02;

import org.junit.Test;

import java.util.concurrent.atomic.LongAdder;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-04
 */
public class LongAdderTest {

    protected static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        Thread thread1 = new Thread(new Task());

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();

        System.out.println(longAdder.sum());
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                // 累加并返回
                longAdder.increment();
            }
        }
    }

    @Test
    public void test() {
        String str = "123_abd";
        String[] s = str.split("_");
        System.out.println(s[0]);
        System.out.println(s[1]);
    }
}
