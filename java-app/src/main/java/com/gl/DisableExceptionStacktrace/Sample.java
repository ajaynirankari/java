package com.gl.DisableExceptionStacktrace;

public class Sample {
    public static void main(String[] args) {
        try {
            Sample sample = new Sample();
            sample.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void test1() throws SuppressibleStackTraceException {
        test2();
    }

    void test2() throws SuppressibleStackTraceException {
        test3();
    }

    void test3() throws SuppressibleStackTraceException {
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            throw new SuppressibleStackTraceException(e);
        }
    }
}

class SuppressibleStackTraceException extends Exception {
    public SuppressibleStackTraceException(Throwable cause) {
        super(cause.getMessage(), null, true, false);
    }
}
