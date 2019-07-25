package com.tool.automation.model.ui.pages;

import com.tool.automation.core.runner.Config;
import com.tool.automation.model.enums.ToolTabs;
import com.tool.automation.model.ui.services.WebDriverService;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public abstract class Page {

  private static final String TAB_XPATH = "//nav[@role='tablist']/a[@data-rb-event-key='%d']";

  @Inject private WebDriverService service;
  @Inject private Config config;

  public void openTab(ToolTabs tab) {
    getDriver().findElement(By.xpath(String.format(TAB_XPATH, tab.getId()))).click();
  }

  WebDriver getDriver() {
    return service.getDriver();
  }

  void initialize() {
    HtmlElementLoader.populatePageObject(this, getDriver());
  }
}
