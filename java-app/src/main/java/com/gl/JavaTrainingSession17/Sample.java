package com.gl.JavaTrainingSession17;

public class Sample {
    public static void main(String[] args) {
        System.out.println("Statement1 ... ");
        System.out.println("Statement2 ... ");
        System.out.println("Statement3 ... ");
        Test test = null;
        int a = 10;
        int b = 0;
        int c = 0;
        try {
            c = a / b;
            test.show();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException occurred ...");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred ...");
            //System.exit(0);
        } catch (Exception ex) {
            System.out.println("Exception occurred ...");
        } catch (Throwable ex) {
            System.out.println("Throwable occurred ...");
        } finally {
            System.out.println("finally{} always exe");
        }

        System.out.println("c = " + c);
        System.out.println("Statement4 ... ");
        System.out.println("Statement5 ... ");
        System.out.println("Completed ... ");
    }
}

class Test {
    void show() {
        System.out.println("show()");
    }
}
