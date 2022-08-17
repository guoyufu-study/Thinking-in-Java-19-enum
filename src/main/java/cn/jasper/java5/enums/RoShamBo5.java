package cn.jasper.java5.enums;

import java.util.Arrays;
import java.util.EnumMap;

import static cn.jasper.java5.enums.Outcome.*;

/**
 * 19.11.3 使用 EnumMap 实现两路分发
 */
public enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSOR, ROCK;

    private static final EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<>(RoShamBo5.class);

    static {
        Arrays.stream(RoShamBo5.values())
                .forEach(it -> table.put(it, new EnumMap<>(RoShamBo5.class)));
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSOR, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }

    private static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(PAPER, vPAPER);
        row.put(SCISSOR, vSCISSORS);
        row.put(ROCK, vROCK);
    }
    @Override
    public Outcome compete(RoShamBo5 it) {
        return table.get(this).get(it);
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }
}
