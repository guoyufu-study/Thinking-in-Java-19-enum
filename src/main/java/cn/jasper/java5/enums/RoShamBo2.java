package cn.jasper.java5.enums;

import cn.jasper.java5.utils.Enums;

import static cn.jasper.java5.enums.Outcome.*;

/**
 * 19.11.1 使用 enum 实现多路分发：使用构造器初始化每个 enum 实例，并以一组结果作为参数。
 */
public enum RoShamBo2 {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);

    private final Outcome vPAPER, vSCISSORS, vROCK;
    RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }

    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER: return vPAPER;
            case SCISSORS: return vSCISSORS;
            case ROCK: return vROCK;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            RoShamBo2 a = Enums.random(RoShamBo2.class);
            RoShamBo2 b = Enums.random(RoShamBo2.class);
            System.out.printf("%s vs. %s: %s%n", a, b, a.compete(b));
        }
    }
}
