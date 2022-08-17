package cn.jasper.java5.enums;

import static cn.jasper.java5.enums.Outcome.*;

/**
 * 19.11.4 使用二维数组简化两路分发
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;

    private static final Outcome[][] table = {
            {DRAW, LOSE, WIN},// PAPER
            {WIN, DRAW, LOSE},// SCISSORS
            {LOSE, WIN, DRAW} // ROCK
    };

    @Override
    public Outcome compete(RoShamBo6 it) {
        return table[this.ordinal()][it.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
