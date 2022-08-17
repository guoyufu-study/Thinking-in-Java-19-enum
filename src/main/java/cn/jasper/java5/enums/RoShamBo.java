package cn.jasper.java5.enums;

import cn.jasper.java5.utils.Enums;

public class RoShamBo {

    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.printf("%s vs. %s: %s%n", a, b, a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(rsbClass), Enums.random(rsbClass));
        }
    }

}
