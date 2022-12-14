package com.gl.SealedClasses;

public class Sample {
    public static void main(String[] args) {
    }

    static String check(IBase obj) {
        return switch (obj) {
            case IBaseImp1 ob -> "IBaseImp1";
            case IBaseImp2 ob -> "IBaseImp2";
            case IBaseImp3 ob -> "IBaseImp3";
            //default -> "oh";
        };
    }
}

sealed interface IBase permits IBaseImp1, IBaseImp2, IBaseImp3 {
}

final class IBaseImp1 implements IBase {
}

final class IBaseImp2 implements IBase {
}

final class IBaseImp3 implements IBase {
}

sealed class A permits B, C, E {

}

final class B extends A {
}

non-sealed class C extends A {
}

sealed class E extends A {
}

final class F extends E {
}

//class D extends A {}