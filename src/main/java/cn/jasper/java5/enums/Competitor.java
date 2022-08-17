package cn.jasper.java5.enums;

public interface Competitor<T extends Competitor<T>> {

    Outcome compete(T competitor);
}
