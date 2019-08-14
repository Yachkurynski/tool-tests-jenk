package com.tool.automation.model.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class ActionSelect extends TypifiedElement {

  private static final String OPTION_BY_NAME = "./div/a[text()='%s']";

  @FindBy(xpath = "./input")
  private WebElement input;

  public ActionSelect(WebElement wrappedElement) {
    super(wrappedElement);
    HtmlElementLoader.populatePageObject(this, wrappedElement);
  }

  public void select(String value) {
    input.click();
    findElement(By.xpath(String.format(OPTION_BY_NAME, value))).click();
  }
}
