package cn.jasper.java5.enums;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum ConstantSpecificMethod {

    DATE_TIME {
        @Override
        String getInfo() {
            return DateTimeFormatter.ISO_DATE.format(LocalDate.now());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }
}
