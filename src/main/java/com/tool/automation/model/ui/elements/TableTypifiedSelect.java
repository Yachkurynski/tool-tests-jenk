package com.tool.automation.model.ui.elements;

import static java.lang.String.format;

import com.tool.automation.core.exceptions.ATToolRuntimeException;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

public class TableTypifiedSelect extends TableSelect {

  @FindBy(xpath = ".//input[contains(@class, 'dropdown-select-input')]")
  private TextInput nameInput;

  public TableTypifiedSelect(WebElement wrappedElement) {
    super(wrappedElement);
  }

  public void typeAndSelect(String value) {
    getExpandButton().click();
    nameInput.sendKeys(value);
    List<WebElement> options = findElements(By.xpath(getOptionXpath()));

    if (options.isEmpty()) {
      findElement(By.xpath(format(".//div[@role='list']/div[.='add \"%s\"']", value))).click();
    } else {
      options.stream().filter(o -> o.getText().equals(value)).findFirst().orElseThrow(
          ATToolRuntimeException::new).click();
    }
  }

  public List<String> getSuggestions(String value) {
    getExpandButton().click();
    nameInput.clear();
    nameInput.sendKeys(value);

    List<String> suggestions = findElements(By.xpath(getOptionXpath())).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());

    getExpandButton().click();
    return suggestions;
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
