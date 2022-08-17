package cn.jasper.java5.enums;

import java.util.Random;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        int amount() {// Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        @Override
        int amount() {// Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    private int value;// In cents

    Input() {
    }

    Input(int value) {
        this.value = value;
    }

    int amount() {
        return value;
    }

    static final Random rand = new Random(47);

    public static Input randomSelection() {
        // 不包括 STOP.
        return values()[rand.nextInt(values().length-1)];
    }
}
