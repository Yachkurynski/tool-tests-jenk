package com.tool.automation.model.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class ElementUtils {

  public static void waitUntilVisible(WebElement context, String xpath) {
    new FluentWait<>(context).until(elem -> !elem.findElements(By.xpath(xpath)).isEmpty());
  }
}
