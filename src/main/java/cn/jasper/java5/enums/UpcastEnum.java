package cn.jasper.java5.enums;

import java.util.Arrays;

public class UpcastEnum {

    public static void main(String[] args) {
        Arrays.stream(Search.class.getEnumConstants()).forEach(System.out::println);
        Arrays.stream(Search.HITHER.getClass().getEnumConstants()).forEach(System.out::println);
    }
}

enum Search {
    HITHER, YOU
}