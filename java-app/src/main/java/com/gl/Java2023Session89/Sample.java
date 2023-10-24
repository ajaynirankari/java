package com.gl.Java2023Session89;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) throws Exception {

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> downloadData(5));
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> downloadData(7));
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> downloadData(9));
        CompletableFuture<Integer> cf4 = CompletableFuture.supplyAsync(() -> downloadData(11));

        CompletableFuture[] tasks = {cf1, cf2, cf3, cf4};
        var anyOfFuture = CompletableFuture.anyOf(tasks);
        System.out.println("anyOfFuture.join() = " + anyOfFuture.join());

        System.out.println("------------------------------------------------------------");

        CompletableFuture.allOf(tasks)
                .thenApply(v -> {
                    var results = Stream.of(tasks).map(CompletableFuture::join).toList();
                    System.out.println("All results = " + results + " " + Thread.currentThread().getName());
                    int sum = results.stream().mapToInt(e -> (int) e).sum();
                    System.out.println("sum = " + sum + " " + Thread.currentThread().getName());
                    return sum;
                }).thenAccept(input -> {
                    System.out.println("Going to double the sum.... " + (2 * input) + " .." + Thread.currentThread().getName());
                })
                .thenRun(() -> {
                    System.out.println("Going to continue the next work.... " + Thread.currentThread().getName());
                });

        ThreadSleep.sleep(Duration.ofSeconds(20));
        System.out.println("------------------------------------------------------------");
    }

    static int downloadData(int x) {
        System.out.println(x + " downloadData is started by: " + Thread.currentThread().getName());
        ThreadSleep.sleep(Duration.ofSeconds(new Random().nextInt(5)));
        System.out.println(x + " downloadData is completed by: " + Thread.currentThread().getName());
        return x;
    }
}
