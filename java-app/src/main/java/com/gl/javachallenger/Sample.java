package com.gl.javachallenger;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

public class Sample {
    public static void main(String[] args) throws Exception {
/*
        List<String> crew = Arrays.asList("Kirk", "Spock", "Uhura");
        crew.stream()
                .peek(e -> System.out.println(e + ":peek"))
                .limit(2)
                .forEach(System.out::println);
---------------------------------------------------------------------

        int doorNumber = 0;
        List<String> doors = Arrays.asList("A", "B", "C");
        doors.forEach(e -> System.out.println(e + doorNumber++));
---------------------------------------------------------------------

        var var = new Var() {
            @Override
            public String collide(String c1, String c2) {
                return c1 + c2;
            }
        };
        var deLester = (Var) null;
        deLester = var;

        Var reliantMistake=(var s1, final var s2) -> String.join(";",s1,s2,"Darch Vader");

        var numbers= new ArrayList<>(Arrays.asList(3,2,1));
        numbers.remove(Integer.valueOf(1));

        System.out.println(var.collide("Kirk","Spock"));
        System.out.println(reliantMistake.collide("Khan","Borg"));
        System.out.println(deLester.getClass().getName());
        System.out.println(numbers);
---------------------------------------------------------------------

        Commander<String> commander = new Commander<>("V-ger", "Spock", "Vulcan");
        record NewShip(String name) {
        }
        System.out.println(commander.name);
        System.out.println(commander.equals(new Commander<>(new NewShip("V-ger"), "Worf", "Kronos")));
---------------------------------------------------------------------


        System.out.println("--------------");
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Thread.sleep(1000);
            executor.submit(() -> System.out.println("Spock: "+Thread.currentThread()));
            executor.submit(() -> System.out.println("Worf: "+Thread.currentThread()));
        }
        System.out.println("--------------");
---------------------------------------------------------------------

 */
        // --enable-preview --add-modules jdk.incubator.concurrent


        System.out.println("getBestCharacter() = " + getBestCharacter());
        System.out.println("getCharacter() = " + getCharacter());

    }

    static String getBestCharacter() throws ExecutionException {
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<String>()) {
            scope.fork(Sample::getData);
            scope.fork(Sample::getMcCoy);
            scope.join();
            return scope.result();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    static String getCharacter() {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            StructuredTaskScope.Subtask<String> f1 = scope.fork(Sample::getData);
            StructuredTaskScope.Subtask<String>  f2 = scope.fork(Sample::getMcCoy);
            scope.join();
            return f1.get() +"::"+ f2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    static String getData() throws InterruptedException {
        Thread.sleep(2000);
        return "Data";
    }

    static String getMcCoy() {
        return "McCoy";
    }

    static void command(Captain captain) {
        switch (captain) {
            case Saru saru -> System.out.println(saru.getClass().isSealed());
            case Janeway janeway -> System.out.println(janeway.getClass().getSimpleName());
            case Captain cap -> System.out.println(cap.getClass().isRecord());
        }
    }

    sealed interface Captain permits Saru, Spock, Janeway {
    }

    static non-sealed class Saru implements Captain {
    }

    record Spock(String named) implements Captain {
    }

    static final class Janeway implements Captain {
    }

    public record Commander<T>(T ship, String name, String planet) {
        public Commander {
            if (!(ship instanceof Serializable))
                throw new RuntimeException();
        }
    }

    private interface Var {
        String collide(String c1, String c2);
    }
}

