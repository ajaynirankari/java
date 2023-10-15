package com.gl.util;

import java.time.Duration;

public class ThreadSleep {
    public static void sleep(Duration duration){
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
