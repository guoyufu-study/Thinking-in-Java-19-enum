package cn.jasper.java5.enums;

import static cn.jasper.java5.enums.Spiciness.*;

/**
 * 静态导入
 */
public class Burrito {// 卷饼

    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
