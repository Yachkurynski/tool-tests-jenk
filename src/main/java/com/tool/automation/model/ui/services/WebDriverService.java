package com.tool.automation.model.ui.services;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

public class WebDriverService {

  public void startDriver(String startURL) {
      Selenide.open(startURL);
      getDriver().manage().window().maximize();
  }

  public boolean isDriverStarted() {
    return WebDriverRunner.hasWebDriverStarted();
  }

  public WebDriver getDriver() {
    return WebDriverRunner.getWebDriver();
  }

  public  void closeWebDriver() {
    WebDriverRunner.closeWebDriver();
  }


}
