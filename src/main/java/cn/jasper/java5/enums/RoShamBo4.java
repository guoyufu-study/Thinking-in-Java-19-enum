package cn.jasper.java5.enums;

import static cn.jasper.java5.enums.Outcome.*;

/**
 * 19.11.2 使用常量相关方法：简化一下
 */
public enum RoShamBo4 implements Competitor<RoShamBo4>{
    PAPER {
        @Override
        public Outcome compete(RoShamBo4 it) {
            return compete(ROCK, it);
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo4 it) {
            return compete(PAPER, it);
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo4 it) {
            return compete(SCISSORS, it);
        }
    };

    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return opponent == this ? DRAW : loser == opponent ? WIN : LOSE;
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
