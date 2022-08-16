package cn.jasper.java5.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 运行操作系统命令并将输出发送到控制台
 */
public class OSExecute {
  public static void command(String command) {
    boolean err = false;
    try {
      Process process = new ProcessBuilder(command.split(" ")).start();
      BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
      results.lines().forEach(System.out::println);

      // 如果有问题，报告错误并返回非零值给调用进程：
      BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
      errors.lines().forEach(System.out::println);
      if (errors.lines().findAny().isPresent()) err = true;
    } catch(Exception e) {
      // 补偿 Windows 2000，它会为默认命令行引发异常：
      if(!command.startsWith("CMD /C")) command("CMD /C " + command);
      else throw new RuntimeException(e);
    }
    if(err) throw new OSExecuteException("Errors executing " + command);
  }
} ///:~
