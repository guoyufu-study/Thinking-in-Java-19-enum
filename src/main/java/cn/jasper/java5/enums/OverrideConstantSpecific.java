package cn.jasper.java5.enums;

import java.util.Arrays;

import static cn.jasper.java5.utils.Print.print;
import static cn.jasper.java5.utils.Print.printf;

public enum OverrideConstantSpecific {

    NUT, BOLT,
    WASHER {
        void f() {
            print("Overridden method");
        }
    };

    void f() {
        print("default behavior");
    }

    public static void main(String[] args) {
        Arrays.stream(values()).forEach(ocs -> {
            printf("%s: ", ocs);
            ocs.f();
        });
    }
}
