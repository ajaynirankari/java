package com.gl.jdk19;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyDemo {
    public static void main(String[] args) throws Exception {
        Instant begin = Instant.now();
        Weather weather = getWeather();
        Instant end = Instant.now();
        System.out.println("weather = " + weather);
        System.out.println("Time = " + Duration.between(begin, end).toMillis() + " ms");
    }

    record Weather(String server, String weather) {
    }

    static Weather getWeather() throws Exception {
        //try (var scope = new StructuredTaskScope<Weather>()) {
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<Weather>()) {
            StructuredTaskScope.Subtask<Weather> forkA = scope.fork(StructuredConcurrencyDemo::readWeatherFromRemoteAPICallA);
            StructuredTaskScope.Subtask<Weather> forkB = scope.fork(StructuredConcurrencyDemo::readWeatherFromRemoteAPICallB);
            StructuredTaskScope.Subtask<Weather> forkC = scope.fork(StructuredConcurrencyDemo::readWeatherFromRemoteAPICallC);
            scope.join();

            System.out.println("forkA.state() = " + forkA.state());
            System.out.println("forkB.state() = " + forkB.state());
            System.out.println("forkC.state() = " + forkC.state());

            return scope.result();
        }
        //return readWeatherFromRemoteAPICall();
    }

    static Weather readWeatherFromRemoteAPICallA() {
        System.out.println(" readWeatherFromRemoteAPICallA() called ... ");
        Random random = new Random();
        int nextInt = random.nextInt(10);
        try {
            Thread.sleep(Duration.ofSeconds(nextInt));
        } catch (Exception _) {
        }
        System.out.println(" return from readWeatherFromRemoteAPICallA() call ");
        return new Weather("serverA:" + nextInt, "weather:" + nextInt);
    }

    static Weather readWeatherFromRemoteAPICallC() {
        System.out.println(" readWeatherFromRemoteAPICallC() called ... ");
        Random random = new Random();
        int nextInt = random.nextInt(10);
        try {
            Thread.sleep(Duration.ofSeconds(nextInt));
        } catch (Exception _) {
        }
        System.out.println(" return from readWeatherFromRemoteAPICallC() call ");
        return new Weather("serverC:" + nextInt, "weather:" + nextInt);
    }

    static Weather readWeatherFromRemoteAPICallB() {
        System.out.println(" readWeatherFromRemoteAPICallB() called ... ");
        Random random = new Random();
        int nextInt = random.nextInt(10);
        try {
            Thread.sleep(Duration.ofSeconds(nextInt));
        } catch (Exception _) {
        }
        System.out.println(" return from readWeatherFromRemoteAPICallB() call ");
        return new Weather("serverB:" + nextInt, "weather:" + nextInt);
    }
}
