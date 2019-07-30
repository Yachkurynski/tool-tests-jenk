package com.tool.automation.core.runner;


import com.tool.automation.core.beans.SingleTest;
import com.tool.automation.core.parsers.CmdLineParser;
import com.tool.automation.core.parsers.ExcelTestParser;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.testng.TestNG;

public class ToolTestRunner {

  private static Config config;
  private static final int FAILED_STATUS_CODE = 1;

  public static void main(String[] args) {
    config = new Config();
    CmdLineParser.parse(config, args);

    TestNGBuilder builder = new TestNGBuilder();

    builder.withListener(new ATToolListener());
    builder.withListener(new FailsInterceptor());
    builder.withParentModule(ToolActionsModule.class);

    Map<String, SingleTest> testFlow = new LinkedHashMap<>();
    File source = new File(config.getExcel());
    AtomicInteger fileCounter = new AtomicInteger(1);

    if(source.isDirectory()) {
      Arrays.asList(source.listFiles()).forEach(f->fillTestFlow(f, fileCounter.getAndIncrement(), testFlow));
    } else {
      fillTestFlow(source, fileCounter.getAndIncrement(), testFlow);
    }

    testFlow.forEach((testName, test)->{
      builder.withTestClass(testName, test.getTestClass());
      builder.withTestParameter(testName, "objectName", test.getName());
      builder.withTestMethod(testName, test.getTestMethod(), test.getParameters());
    });

    TestNG testng = builder.build();

    testng.run();

    if (FailsInterceptor.failed) {
      System.exit(FAILED_STATUS_CODE);
    }
  }

  private static void fillTestFlow(File source, int fileCounter, Map<String, SingleTest> testFlow) {
    AtomicInteger counter = new AtomicInteger(1);

    ExcelTestParser.of(source).get()
        .forEach(test->testFlow.put(String.format("%d.%d [%s] %s", fileCounter, counter.getAndIncrement(), source.getName(), test.toString()), test));
  }

  public static Config getConfig() {
    return config;
  }
}
