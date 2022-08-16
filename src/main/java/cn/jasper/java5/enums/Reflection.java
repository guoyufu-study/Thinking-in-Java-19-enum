package cn.jasper.java5.enums;

import cn.jasper.java5.utils.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.System.out;

/**
 * 19.4 values() 是由编译器添加的 static 方法
 */
public class Reflection {
    static Set<String> analyze(Class<?> enumClass) {
        out.printf("----- Analyzing %s -----%n", enumClass);
        // 接口
        out.println("Interface:");
        for (Type t : enumClass.getGenericInterfaces()) out.println(t);
        // 超类
        out.printf("Base: %s%n", enumClass.getGenericSuperclass());
        // 方法
        out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) methods.add(m.getName());
        out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        out.printf("Explore.containsAll(Enum)? %s%n", exploreMethods.containsAll(enumMethods));
        out.println("Explore.removeAll(Enum)： ");
        exploreMethods.removeAll(enumMethods);
        out.println(exploreMethods);

        // 反编译：记得修改运行配置，并设置工作目录
        OSExecute.command("javap Explore");
    }
}

enum Explore {
    HERE, THERE
}