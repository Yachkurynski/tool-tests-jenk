package com.tool.automation.model.ui.elements;

import static java.lang.String.format;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class TableTypifiedSelect extends TypifiedElement {

  private static final String OPTION_XPATH = ".//span[@role='option']";
  private static final String OPTION_BY_NAME_XPATH = OPTION_XPATH + "[.='%s']";

  @FindBy(xpath = ".//input[contains(@class, 'dropdown-select-input')]")
  private TextInput nameInput;
  @FindBy(xpath = ".//svg[@viewBox]")
  private WebElement expandButton;

  public TableTypifiedSelect(WebElement wrappedElement) {
    super(wrappedElement);
  }

  public void select(String value) {
    click();
    findElement(By.xpath(format(OPTION_BY_NAME_XPATH, value))).click();
  }

  public void typeAndSelect(String value) {
    nameInput.sendKeys(value);
    findElement(By.xpath(format(".//div[@role='list']/div[.='add \"%s\"']", value))).click();
  }

  public List<String> getOptions() {
    expandButton.click();

    List<String> options = findElements(By.xpath(OPTION_XPATH)).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());

    expandButton.click();

    return options;
  }
}
