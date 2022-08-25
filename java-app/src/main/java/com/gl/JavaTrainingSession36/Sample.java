package com.gl.JavaTrainingSession36;

public class Sample {
    public static void main(String[] args) {//throws MyDivisionException, RuntimeException, Exception {

        Test test = new Test();
        int division = test.division(20, 5);
        System.out.println("division = " + division);

        //division = test.division1(20, 0);

        try {
        division = test.division1(20, 0);
        System.out.println("division = " + division);
        } catch (MyDivisionException e) {
          System.out.println("## e.getMessage() = " + e.getMessage());
        } catch (RuntimeException e) {

        } catch (Exception e) {
        }

        division = test.division(210, 15);
        System.out.println("division = " + division);

        System.out.println("###### Main DONE");
    }
}

class Test {

    public int division(int a, int b) {
        System.out.println("a = " + a + ", b=" + b);
        int c = 0;
        try {
            System.out.println("c1 = " + c);
            c = a / b;
            System.out.println("c2 = " + c);
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        }
        System.out.println("return = " + c);
        return c;
    }

    public int division1(int a, int b) throws MyDivisionRuntimeException, RuntimeException, Exception {
        System.out.println("a = " + a + ", b=" + b);
        int c = 0;
        System.out.println("c1 = " + c);

        try {
            c = a / b;
        } catch (Exception e) {
            //try {
            throw new MyDivisionRuntimeException("MyDivisionException exception occurred");
//            } catch (Exception ee) {            }

        }

        System.out.println("c2 = " + c);
        System.out.println("return = " + c);
        return c;
    }
}

// Checked Exception
class MyDivisionException extends Exception {
    MyDivisionException(String msg) {
        super(msg);
    }

}

// Unchecked Exception
class MyDivisionRuntimeException extends RuntimeException {
    MyDivisionRuntimeException(String msg) {
        super(msg);
    }
}
