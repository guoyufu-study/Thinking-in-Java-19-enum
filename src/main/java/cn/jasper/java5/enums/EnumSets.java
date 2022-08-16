package cn.jasper.java5.enums;

import java.util.EnumSet;

import static cn.jasper.java5.enums.AlarmPoints.*;
import static cn.jasper.java5.utils.Print.print;

public class EnumSets {

    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        print(points);

        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);


        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);

        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);

        points = EnumSet.complementOf(points);
        print(points);

    }

}

enum AlarmPoints {
    STAIR1, STAIR2,
    LOBBY,
    OFFICE1, OFFICE2, OFFICE3, OFFICE4,
    BATHROOM, UTILITY, KITCHEN
}

