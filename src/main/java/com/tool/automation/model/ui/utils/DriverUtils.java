package com.tool.automation.model.ui.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.ui.FluentWait;

public class DriverUtils {

  private DriverUtils() {}

  private static final long TIMEOUT_MILLIS = 500;

  public static void waitUntilVisible(SearchContext context, String xpath) {
    waitUntilVisible(context, By.xpath(xpath));
  }

  public static void waitUntilVisible(SearchContext context, By by) {
    new FluentWait<>(context)
        .withTimeout(Duration.ofMillis(TIMEOUT_MILLIS))
        .until(c -> !c.findElements(by).isEmpty());
  }
}
