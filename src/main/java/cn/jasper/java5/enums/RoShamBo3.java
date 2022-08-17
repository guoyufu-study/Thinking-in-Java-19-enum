package cn.jasper.java5.enums;

import static cn.jasper.java5.enums.Outcome.*;

/**
 * 19.11.2 使用常量相关方法：switch
 */
public enum RoShamBo3 implements Competitor<RoShamBo3>{
    PAPER {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default: // To placate the compiler
                case PAPER:return DRAW;
                case SCISSORS: return LOSE;
                case ROCK: return WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default: // To placate the compiler
                case PAPER:return WIN;
                case SCISSORS: return DRAW;
                case ROCK: return LOSE;
            }
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default: // To placate the compiler
                case PAPER:return LOSE;
                case SCISSORS: return WIN;
                case ROCK: return DRAW;
            }
        }
    };

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
}
