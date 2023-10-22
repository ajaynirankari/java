package com.gl.Java2023Session88;

import com.gl.util.ThreadSleep;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Sample {
    public static void main(String[] args) throws Exception {

        // CompletableFuture is support Non-blocking Async programming model
        //    Async programming model
        //    Non-blocking Async programming model
        //    Multi-threading programming model
        //    Concurrent programming model
        // Thread call can be
        //                Non-blocking, No waiting for response, continue own work
        //                Blocking, just waiting for response, not doing other things


        // Runnable Vs Callable;
        Runnable runnable;
        Callable callable;

        new Thread(Sample::methodNoTakeInputAndNoReturnValue).start();
        System.out.println("----------------------------------------------");

        FutureTask futureTask = new FutureTask(Sample::methodNoTakeInputAndReturnValue);
        new Thread(futureTask).start();
        System.out.println("futureTask.get() = " + futureTask.get());
        System.out.println("----------------------------------------------");

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            Future<Integer> future = executorService.submit(Sample::methodNoTakeInputAndReturnValue);
            System.out.println("future.get() = " + future.get());
        }
        System.out.println("----------------------------------------------");

        Supplier<Integer> supplier = () -> methodTakeInputAndReturnValue(10);
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("integerCompletableFuture.get() = " + integerCompletableFuture.get());
        System.out.println("----------------------------------------------");

        CompletableFuture<Integer> completableFuture =
                CompletableFuture
                        .supplyAsync(() -> methodTakeInputAndReturnValue(101));
        System.out.println("completableFuture.get() = " + completableFuture.get());
        System.out.println("----------------------------------------------");

        CompletableFuture
                .supplyAsync(() -> methodTakeInputAndReturnValue(201))
                .thenAccept(result -> System.out.println("result =  " + result + " by: " + Thread.currentThread().getName()));

        System.out.println("----------------------------------------------");

        CompletableFuture
                .supplyAsync(() -> methodTakeInputAndReturnValue(99))
                .thenApply(result -> methodTakeInputAndReturnValue(result))
                .thenAccept(result -> System.out.println(result));

        List<Integer> numbers = generateNumbers();
        List<Integer> doubleIts = doubleIts(numbers);
        int sumIt = sumIt(doubleIts);
        System.out.println("sumIt = " + sumIt + " output print by: " + Thread.currentThread().getName());

        System.out.println("----------------------------------------------");

        CompletableFuture
                .supplyAsync(() -> generateNumbers())
                .thenApply(resultNumbers -> doubleIts(resultNumbers))
                .thenApply(resultDoubleIts -> sumIt(resultDoubleIts))
                .thenAccept(result -> System.out.println(result + " output print by: " + Thread.currentThread().getName()));

        System.out.println("----------------------------------------------");

        System.out.println("main doing own work 1 by: " + Thread.currentThread().getName());
        System.out.println("main doing own work 2 by: " + Thread.currentThread().getName());
        System.out.println("main doing own work 3 by: " + Thread.currentThread().getName());
        ThreadSleep.sleep(Duration.ofSeconds(3));
    }

    static List<Integer> generateNumbers() {
        System.out.println("generateNumbers() by: " + Thread.currentThread().getName());
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().toList();
        System.out.println("generateNumbers() list = " + list + "  by: " + Thread.currentThread().getName());
        return list;
    }

    static List<Integer> doubleIts(List<Integer> list) {
        System.out.println("doubleIts() by: " + Thread.currentThread().getName());
        List<Integer> list1 = list.stream()
                .map(e -> e * 2)
                .toList();
        System.out.println("doubleIts() list = " + list1 + "  by: " + Thread.currentThread().getName());
        return list1;
    }

    static int sumIt(List<Integer> list) {
        System.out.println("sumIt() by: " + Thread.currentThread().getName());
        int sum = list.stream().mapToInt(e -> e).sum();
        System.out.println("sumIt() sum = " + sum + "  by: " + Thread.currentThread().getName());
        return sum;
    }


    static void methodNoTakeInputAndNoReturnValue() {
        System.out.println("methodNoTakeInputAndNoReturnValue by: " + Thread.currentThread().getName());
        int c = 10;
        System.out.println("output " + c + ", methodNoTakeInputAndNoReturnValue by: " + Thread.currentThread().getName());
    }

    static int methodNoTakeInputAndReturnValue() {
        System.out.println("methodNoTakeInputAndReturnValue by: " + Thread.currentThread().getName());
        int c = 10;
        System.out.println("return " + c + ", methodNoTakeInputAndReturnValue by: " + Thread.currentThread().getName());
        return c;
    }

    static int methodTakeInputAndReturnValue(int x) {
        System.out.println("input " + x + ", methodTakeInputAndReturnValue by: " + Thread.currentThread().getName());
        int c = x + 10;
        System.out.println("return " + c + ", methodTakeInputAndReturnValue by: " + Thread.currentThread().getName());
        return c;
    }
}
