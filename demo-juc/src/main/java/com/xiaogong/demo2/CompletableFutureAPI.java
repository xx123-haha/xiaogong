package com.xiaogong.demo2;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @Program: xiaogong
 * @Description:
 * @Author: xiongke
 * @Create: 2024-07-01
 */
public class CompletableFutureAPI {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 2;
        }).thenApply(f -> {
            return f + 3;
        }).thenAccept(System.out::println);
    }


    @Test
    public void threadTest() {
        System.out.println(CompletableFuture.supplyAsync(() -> "result").thenRun(() -> {
        }).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "result").thenAccept(System.out::println).join());
        System.out.println(CompletableFuture.supplyAsync(() -> "result").thenApply(r -> r + "---> result").join());
    }
}
