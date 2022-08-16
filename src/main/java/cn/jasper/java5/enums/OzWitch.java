package cn.jasper.java5.enums;

import java.util.Random;

/**
 * 19.2 向枚举中添加新方法
 */
public enum OzWitch {
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");

    private final int age;
    private final String description;

    OzWitch(String description) {
        this.description = description;
        this.age = new Random().nextInt(100);
    }

    public int getAge() {
        return age;
    }
    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.printf("%s: %d %s%n", witch, witch.getAge(), witch.getDescription());
        }
    }
}
