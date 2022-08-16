package cn.jasper.java5.enums;

/**
 * 枚举的基本特性
 */
public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.printf("%s ordinal: %d%n", s, s.ordinal());
            System.out.printf("%d ", s.compareTo(Shrubbery.CRAWLING));
            System.out.printf("%b ", s.equals(Shrubbery.CRAWLING));
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("-------------------------------------------");
        }
    }

}

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}
