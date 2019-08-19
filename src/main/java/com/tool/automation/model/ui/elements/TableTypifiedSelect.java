package com.tool.automation.model.ui.elements;

import static java.lang.String.format;

import com.tool.automation.core.exceptions.ATToolRuntimeException;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

public class TableTypifiedSelect extends TableSelect {

  @FindBy(xpath = "./input")
  private TextInput nameInput;

  public TableTypifiedSelect(WebElement wrappedElement) {
    super(wrappedElement);
  }

  public void typeAndSelect(String value) {
    expand();
    nameInput.sendKeys(value);
    List<WebElement> options = findElements(By.xpath(getOptionXpath()));

    if (options.isEmpty()) {
      nameInput.sendKeys(Keys.ENTER);
    } else {
      options.stream().filter(o -> o.getText().equals(value)).findFirst().orElseThrow(
          ATToolRuntimeException::new).click();
    }
  }

  public List<String> getSuggestions(String value) {
    expand();

    nameInput.clear();
    nameInput.sendKeys(value);

    List<String> suggestions = findElements(By.xpath(getOptionXpath())).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());

    expand();
    return suggestions;
  }

  @Override
  protected void expand() {
    nameInput.click();
  }

  @Override
  protected String getExpandButtonXpath() {
    return ".//*[@viewBox]";
  }

  @Override
  protected String getOptionXpath() {
    return ".//a[@href]";
  }
}
