package cn.jasper.java5.enums;

import cn.jasper.java5.utils.Generator;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class EnumImplementation {

    public static <T> void printNext(@NotNull Generator<T> rg) {
        System.out.printf("%s, ", rg.next());
    }

    public static void main(String[] args) {
        // 选择任何实例
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private final Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}