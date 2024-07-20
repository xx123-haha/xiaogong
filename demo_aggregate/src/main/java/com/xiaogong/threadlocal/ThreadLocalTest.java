package com.xiaogong.threadlocal;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-04  
 */
public class ThreadLocalTest {

    private final static ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(10,
            20, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            EXECUTOR.execute(() -> System.out.println(SIMPLE_DATE_FORMAT.format(new Date(finalI * 1000))));
        }

        EXECUTOR.shutdown();
    }
}
