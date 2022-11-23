package com.gl.SwitchPatternMatch;

import java.util.Arrays;

public class SwitchPatternMatchDemo {
    public static void main(String[] args) {

        print(switchForAnyType(123));
        print(switchForAnyType(12.3));
        print(switchForAnyType("Name"));
        print(switchForAnyType(999L));
        print(switchForAnyType(null));
        print(switchForAnyType(new Circle()));
        print(switchForAnyType(new Triangle()));
        print(switchForAnyType(600));
        print(switchForAnyType(new Square()));
        print(switchForEnum(Color.BACK));
        print(switchForSealedType(new Coding("Java")));
        print(switchForSealedType(new Playing()));
        print(switchForSealedType(new Reading()));
        print(switchForAnyType(new int[]{4, 7, 2}));

    }

    static String switchForAnyType(Object object) {
        return switch (object) {
            case null -> "Got a null reference";
            //case Integer i && i.intValue() > 500 -> "Got Integer value > 500 -> " + i.intValue();
            case Integer i -> "Got Integer value - " + i.intValue();
            case Double d -> "Got Double value - " + d.doubleValue();
            case Long l -> "Got Long value - " + l.longValue();
            case String s -> "Got String value - " + s.toString();
            case Triangle triangle -> "Got Triangle object - " + triangle.shape();
            case Shape shape -> "Got Shape object - " + shape.shape();
            case int[] intArray -> "Got int[] array - " + Arrays.toString(intArray);
            default -> "default Unknown match object " + object;
        };
    }

    static String switchForEnum(Color color) {
        return switch (color) {
            case RED -> "Red";
            case BACK -> "Back";
            case GREEN -> "Green";
        };
    }

    static String switchForSealedType(Activity activity) {
        return switch (activity) {
            case Coding coding -> "Coding " + coding.whichLang;
            case Playing playing -> "Playing";
            case Sleeping sleeping -> "Sleeping";
            case Reading reading -> "record Reading";
        };
    }

    static void print(Object object) {
        System.out.println(object);
    }
}

sealed interface Activity permits Coding, Playing, Sleeping, Reading {

}

final class Coding implements Activity {
    String whichLang;

    Coding(String whichLang) {
        this.whichLang = whichLang;
    }
}

final class Playing implements Activity {
}

final class Sleeping implements Activity {
}

record Reading() implements Activity {
}

enum Color {
    RED, BACK, GREEN
}

interface Shape {
    String shape();
}

class Circle implements Shape {
    @Override
    public String shape() {
        return "Circle";
    }
}

class Triangle implements Shape {
    @Override
    public String shape() {
        return "Triangle";
    }
}

record Square() implements Shape {
    @Override
    public String shape() {
        return "record Square";
    }
}