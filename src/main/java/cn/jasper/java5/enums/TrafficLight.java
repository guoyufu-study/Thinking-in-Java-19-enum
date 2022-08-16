package cn.jasper.java5.enums;

import static cn.jasper.java5.enums.Signal.*;

/**
 * 19.3 在 switch 中使用 enum
 */
public class TrafficLight {

    Signal color = RED;

    public void change() {
        switch (color) {
            case RED: color = GREEN; break;
            case GREEN: color = YELLOW; break;
            case YELLOW: color = RED; break;
        }
    }

    @Override
    public String toString() {
        return "the traffic light is "+ color;
    }

    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(trafficLight);
            trafficLight.change();
        }
    }
}

enum Signal {
    GREEN, YELLOW, RED
}
