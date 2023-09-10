package com.gl.Java2023Session60;

public class Sample {
    public static void main(String[] args) throws Exception {
        // Exception Handling
        // try{}
        // catch{}, catch{}, catch{}
        // finally{}

        // There are the following 4 ways to use try{} block

        // 1. try{} & catch{}
        // 2. try{} & finally{}
        // 3. try{} & catch{} & finally{}
        // 4. try{}        -> try with resources

        // Type of Exception or unwanted events or condition
        // There are 2 types

        // 1. Compile time   or Checked exception
        // 2. Runtime        or Unchecked exception

        // Compile-time exception is Exception or the subclass of Exception or Throwable class
        // Runtime exception is RuntimeException or the subclass of RuntimeException or Error class

        // throw   -> Developer can use to throw exception
        // throws  -> method signature say that method can throws exceptions


        System.out.println("main() stared ....");

        Test test = new Test();
        test.method1();

        try {
            test.method2(5);
        } catch (MySubCompileTimeException e) {
            System.out.println("Throwable e.getMessage() = " + e.getMessage());
        } catch (MyCompileTimeException e) {
            System.out.println("MyCompileTimeException e.getMessage() = " + e.getMessage());
        } catch (MyCompileTimeThrowableException e) {
            System.out.println("MyCompileTimeThrowableException e.getMessage() = " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception e.getMessage() = " + e.getMessage());
        } catch (Throwable e) {
            System.out.println("Throwable e.getMessage() = " + e.getMessage());
        } finally {
            System.out.println("finally{} block called ....");
            System.out.println("Opportunity for developer to write code here for clean up operation");
        }

        try {
            test.method3(15);
        } finally {
            System.out.println("finally{} block called ....");
            System.out.println("Opportunity for developer to write code here for clean up operation");
        }

        System.out.println("---------------1111--------------------");
        MyAutoCloseable autoCloseable = new MyAutoCloseable();
        autoCloseable.process();
        autoCloseable.close();
        System.out.println("----------------1111-------------------");

        System.out.println("----------------2222-------------------");

        try (MyAutoCloseable autoCloseable1 = new MyAutoCloseable()) {
            autoCloseable1.process();
        }
        System.out.println("----------------2222-------------------");

//        try (MyAutoCloseableSimple autoCloseable2 = new MyAutoCloseableSimple()) {   try is allowed only AutoCloseable objects
//            autoCloseable2.process();
//        }

        System.out.println("next business logic");

        try {
            test.generateErrorConditionTestError();
        } catch (Error e) {
            System.out.println("Handled the Error case also - " + e.getMessage());
        }

        System.out.println("main() still running ....");
        System.out.println("main() completed ....");
    }
}

class Test {
    void method1() {
        System.out.println("method1()");

        int[] a = {2, 5, 1, 7};

        System.out.println(a[2]);
        try {
            System.out.println(a[5]);
        } catch (Exception e) {
        }

        System.out.println(a[1]);
        System.out.println("method1() done");
    }

    void method2(int n) throws MyCompileTimeThrowableException, MyCompileTimeException, MySubCompileTimeException {
        System.out.println("method2() 1");
        if (n == 3) {
            throw new MyCompileTimeThrowableException("error for n == 3");
        }
        System.out.println("method2() 2");
        if (n == 5) {
            throw new MyCompileTimeException("error for n == 5");
        }

        System.out.println("method2() 3");
        if (n == 7) {
            throw new MySubCompileTimeException("error for n == 5");
        }

        System.out.println("method2() done");
    }

    void method3(int n) {
        System.out.println("method3() 1");
        if (n == 3) {
            throw new MyRuntimeException("error for n == 3");
        }
        System.out.println("method3() 2");
        if (n == 5) {
            throw new MySubRuntimeException("error for n == 5");
        }

        System.out.println("method2() done");
    }

    void generateErrorConditionTestError() {
        System.out.println(" recursive call errorCheck");
        generateErrorConditionTestError();
    }
}

class MyAutoCloseable implements AutoCloseable {
    void process() {
        System.out.println("processing....");
        System.out.println("processing....open some resource");
        System.out.println("processing....done");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoCloseable is close() all resources");
    }
}

class MyAutoCloseableSimple {
    void process() {
        System.out.println("processing....");
        System.out.println("processing....open some resource");
        System.out.println("processing....done");
    }
}

class MyRuntimeException extends RuntimeException {
    MyRuntimeException(String message) {
        super(message);  // call super class constructor
    }
}

class MySubRuntimeException extends MyRuntimeException {
    MySubRuntimeException(String message) {
        super(message);  // call super class constructor
    }
}

class MyCompileTimeThrowableException extends Throwable {
    MyCompileTimeThrowableException(String message) {
        super(message);  // call super class constructor
    }
}

class MyCompileTimeException extends Exception {
    MyCompileTimeException(String message) {
        super(message);  // call super class constructor
    }
}

class MySubCompileTimeException extends MyCompileTimeException {
    MySubCompileTimeException(String message) {
        super(message);  // call super class constructor
    }
}
