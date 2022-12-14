package cn.jasper.java5.enums;

import cn.jasper.java5.utils.Enums;

public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.printf("%s ", Enums.random(Activity.class));
        }
    }
}

enum Activity {
    SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING
}
