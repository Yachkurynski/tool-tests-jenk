package com.tool.automation.model.ui.elements;

import static java.lang.String.format;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class TableTypifiedSelect extends TableSelect {

  @FindBy(xpath = ".//input[contains(@class, 'dropdown-select-input')]")
  private TextInput nameInput;

  public TableTypifiedSelect(WebElement wrappedElement) {
    super(wrappedElement);
  }

  public void typeAndSelect(String value) {
    getExpandButton().click();
    nameInput.sendKeys(value);
    findElement(By.xpath(format(".//div[@role='list']/div[.='add \"%s\"']", value))).click();
  }

  @Override
  protected String getExpandButtonXpath() {
    return ".//*[@viewBox]";
  }

  @Override
  protected String getOptionXpath() {
    return ".//span[@role='option']";
  }
}
