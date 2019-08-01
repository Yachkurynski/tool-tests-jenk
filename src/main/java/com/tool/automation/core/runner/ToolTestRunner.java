package com.tool.automation.core.runner;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tool.automation.core.beans.SingleTest;
import com.tool.automation.core.parsers.ExcelTestParser;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.testng.TestNG;

public class ToolTestRunner {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new StartupPropertiesModule());
    Config config = injector.getInstance(Config.class);

    TestNGBuilder builder = new TestNGBuilder();

    builder.withListener(new ATToolListener(config));
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

    System.exit(testng.getStatus());
  }

  private static void fillTestFlow(File source, int fileCounter, Map<String, SingleTest> testFlow) {
    AtomicInteger counter = new AtomicInteger(1);

    ExcelTestParser.of(source).get()
        .forEach(test->testFlow.put(String.format("%d.%d [%s] %s", fileCounter, counter.getAndIncrement(), source.getName(), test.toString()), test));
  }
}
