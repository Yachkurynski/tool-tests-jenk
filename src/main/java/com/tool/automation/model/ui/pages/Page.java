package com.tool.automation.model.ui.pages;

import com.tool.automation.core.runner.Config;
import com.tool.automation.model.enums.ToolTabs;
import com.tool.automation.model.ui.services.WebDriverService;
import com.google.inject.Inject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public abstract class Page {

  private static final String TAB_XPATH = "//nav[@role='tablist']/a[@data-rb-event-key='%d']";

  @Inject private WebDriverService service;
  @Inject private Config config;

  public void openTab(ToolTabs tab) {
    findElement(By.xpath(String.format(TAB_XPATH, tab.getId()))).click();
  }

  protected WebElement findElement(By by) {
    return getDriver().findElement(by);
  }

  protected List<WebElement> findElements(By by) {
    return getDriver().findElements(by);
  }

  WebDriver getDriver() {
    return service.getDriver();
  }

  void initialize() {
    HtmlElementLoader.populatePageObject(this, getDriver());
  }
}
