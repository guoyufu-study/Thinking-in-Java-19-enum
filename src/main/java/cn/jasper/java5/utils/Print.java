package cn.jasper.java5.utils;
import java.io.*;

/**
 * 使用 Java SE5 静态导入可以在没有限定符的情况下使用的打印方法：
 */
public class Print {

  /**
   * 用换行符打印：
   */
  public static void print(Object obj) {
    System.out.println(obj);
  }

  /**
   * 自己打印一个换行符：
   */
  public static void print() {
    System.out.println();
  }

  /**
   * 打印不换行：
   */
  public static void printnb(Object obj) {
    System.out.print(obj);
  }

  /**
   * 新的 Java SE5 printf()（来自 C）：
   */
  public static PrintStream
  printf(String format, Object... args) {
    return System.out.printf(format, args);
  }
} ///:~
