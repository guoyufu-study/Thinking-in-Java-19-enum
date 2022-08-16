package cn.jasper.java5.enums;

import java.util.EnumMap;

import static cn.jasper.java5.enums.AlarmPoints.*;
import static cn.jasper.java5.utils.Print.print;

public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);
        em.put(KITCHEN, () -> System.out.println("Kitchen fire!"));
        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));

        em.forEach((key, value) -> {
            System.out.printf("%s: ", key);
            value.action();
        });

        try {
            em.get(UTILITY).action();
        } catch (Exception ex) {
            print(ex);
        }

    }
}

interface Command {
    void action();
}
