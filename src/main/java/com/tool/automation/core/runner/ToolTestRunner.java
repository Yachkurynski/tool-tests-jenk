package com.tool.automation.core.runner;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tool.automation.core.beans.SingleTest;
import com.tool.automation.core.exceptions.ATToolRuntimeException;
import com.tool.automation.core.parsers.TestParser;
import com.tool.automation.core.parsers.TestParserResolver;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.testng.TestNG;

public class ToolTestRunner {

  private static final String TESTS_PATH_1 = "com.tool.automation.generated.keywords.";

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new StartupPropertiesModule());
    TestNGBuilder builder = new TestNGBuilder();

    builder.withListener(injector.getInstance(ATToolListener.class));
    builder.withParentModule(ToolActionsModule.class);

    TestParser testParser = TestParserResolver.getTestParser(injector.getInstance(Config.class));

    AtomicInteger fileCounter = new AtomicInteger(1);
    Map<String, SingleTest> testFlow = getTestFlow(fileCounter.getAndIncrement(), testParser.get());

    testFlow.forEach((testName, test)->{
      builder.withTestClass(testName, getTestClass(test.getObject()));
      builder.withTestParameter(testName, "objectName", test.getLocationName());
      builder.withTestMethod(testName, test.getAction(), test.getArguments());
    });

    TestNG testng = builder.build();

    testng.run();

    System.exit(testng.getStatus());
  }

  private static Map<String, SingleTest> getTestFlow(int fileCounter, List<SingleTest> tests) {
    Map<String, SingleTest> testFlow = new LinkedHashMap<>();
    AtomicInteger counter = new AtomicInteger(1);

    tests.forEach(test->testFlow.put(
        String.format("%d.%d %s", fileCounter, counter.getAndIncrement(), test.toString()),
        test));

    return testFlow;
  }

  private static Class<?> getTestClass(String className) {
    try {
      return ClassLoader.getSystemClassLoader().loadClass(TESTS_PATH_1 + className);
    } catch (ClassNotFoundException e) {
      throw new ATToolRuntimeException(e);
    }
  }
}
