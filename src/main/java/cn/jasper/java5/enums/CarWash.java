package cn.jasper.java5.enums;

import java.util.EnumSet;

import static cn.jasper.java5.enums.Cycle.*;
import static cn.jasper.java5.utils.Print.print;

public class CarWash {

    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);

    public void add(Cycle cycle) {
        cycles.add(cycle);
    }

    public void washCar() {
        cycles.forEach(Cycle::action);
    }

    @Override
    public String toString() {
        return cycles.toString();
    }

    public static void main(String[] args) {
        // 基本洗车操作
        CarWash wash = new CarWash();
        print(wash);
        wash.washCar();

        // 定制洗车操作
        wash.add(BLOWDRY);
        wash.add(BLOWDRY);
        wash.add(RINSE);
        wash.add(HOTWAX);
        print(wash);
        wash.washCar();
    }
}

enum Cycle {
    UNDERBOY {
        @Override
        void action() {
            print("Spraying the underbody");
        }
    },
    WHEELWASH {
        @Override
        void action() {
            print("Washing the wheels");
        }
    },
    PREWASH {
        @Override
        void action() {
            print("Loosening the dirt");
        }
    },
    BASIC {
        @Override
        void action() {
            print("The basic wash");
        }
    },
    HOTWAX {
        @Override
        void action() {
            print("Applying hot wax");
        }
    },
    RINSE {
        @Override
        void action() {
            print("Rinsing");
        }
    },
    BLOWDRY {
        @Override
        void action() {
            print("Blowing dry");
        }
    };

    abstract void action();
}
