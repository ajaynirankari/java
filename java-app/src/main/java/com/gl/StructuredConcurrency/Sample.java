package com.gl.StructuredConcurrency;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.StructuredTaskScope;

public class Sample {
    public static void main(String[] args) throws Exception {
        // --enable-preview --add-modules jdk.incubator.concurrent

        int productId = 101;

        String products = getProducts(productId);
        String productReviews = getProductReviews(productId);
        String productBestPrice = getProductBestPrice(productId);

        String output = products + " : " + productReviews + " : " + productBestPrice;
        System.out.println("######## output = " + output);


        try (var scope = new StructuredTaskScope<String>()) {

            StructuredTaskScope.Subtask<String> products_ = scope.fork(() -> getProducts(productId));
            StructuredTaskScope.Subtask<String> productReviews_ = scope.fork(() -> getProductReviews(productId));
            StructuredTaskScope.Subtask<String> productBestPrice_ = scope.fork(() -> getProductBestPrice(productId));

            scope.join();

            output = products_.get() + " : " + productReviews_.get() + " : " + productBestPrice_.get();
            System.out.println("######## output = " + output);
        }


        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
            scope.fork(() -> getProductReviewsA(productId));
            scope.fork(() -> getProductReviewsB(productId));
            scope.fork(() -> getProductReviewsC(productId));

            scope.join();

            System.out.println("######## output = " + scope.result());
        }

    }

    static String getProducts(int productId) {
        try {
            Random random = new Random();
            int processingTime = random.nextInt(10);
            System.out.println("getProducts() productId = " + productId + ", processingTime = " + processingTime + " " + Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(processingTime));

        } catch (Exception _) {

        }
        System.out.println("Return getProducts() productId = " + productId + " " + Thread.currentThread());
        return "getProducts()::AbcProduct";
    }

    static String getProductReviews(int productId) {
        try {
            Random random = new Random();
            int processingTime = random.nextInt(10);
            System.out.println("getProductReviews() productId = " + productId + ", processingTime = " + processingTime + " " + Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(processingTime));

        } catch (Exception _) {

        }
        System.out.println("Return getProductReviews() productId = " + productId + " " + Thread.currentThread());
        return "getProductReviews()::AbcProduct";
    }


    static String getProductReviewsA(int productId) {
        try {
            Random random = new Random();
            int processingTime = random.nextInt(10);
            System.out.println("getProductReviewsA() productId = " + productId + ", processingTime = " + processingTime + " " + Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(processingTime));

        } catch (Exception _) {

        }
        System.out.println("Return getProductReviewsA() productId = " + productId + " " + Thread.currentThread());
        return "getProductReviewsA()::AbcProduct";
    }

    static String getProductReviewsC(int productId) {
        try {
            Random random = new Random();
            int processingTime = random.nextInt(10);
            System.out.println("getProductReviewsC() productId = " + productId + ", processingTime = " + processingTime + " " + Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(processingTime));

        } catch (Exception _) {

        }
        System.out.println("Return getProductReviewsC() productId = " + productId + " " + Thread.currentThread());
        return "getProductReviewsA()::AbcProduct";
    }

    static String getProductReviewsB(int productId) {
        try {
            Random random = new Random();
            int processingTime = random.nextInt(10);
            System.out.println("getProductReviewsB() productId = " + productId + ", processingTime = " + processingTime + " " + Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(processingTime));

        } catch (Exception _) {

        }
        System.out.println("Return getProductReviewsA() productId = " + productId + " " + Thread.currentThread());
        return "getProductReviewsB()::AbcProduct";
    }

    static String getProductBestPrice(int productId) {
        try {
            Random random = new Random();
            int processingTime = random.nextInt(10);
            System.out.println("getProductBestPrice() productId = " + productId + ", processingTime = " + processingTime + " " + Thread.currentThread());
            Thread.sleep(Duration.ofSeconds(processingTime));

        } catch (Exception _) {

        }
        System.out.println("Return getProductBestPrice() productId = " + productId + " " + Thread.currentThread());
        return "getProductBestPrice()::AbcProduct";
    }
}
