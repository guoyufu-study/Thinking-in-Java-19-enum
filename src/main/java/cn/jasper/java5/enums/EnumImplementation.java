package cn.jasper.java5.enums;

import java.util.Random;

/**
 * static next 实现：需要提供实例参数
 */
public class EnumImplementation {

    public static void printNext(CartoonCharacter cc) {
        System.out.printf("%s, ", CartoonCharacter.next(cc));
    }

    public static void main(String[] args) {
        // 选择任何实例
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private final Random rand = new Random(47);

    public static CartoonCharacter next(CartoonCharacter cc) {
        return values()[cc.rand.nextInt(values().length)];
    }
}