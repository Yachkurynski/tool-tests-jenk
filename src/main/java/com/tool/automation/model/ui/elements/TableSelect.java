package com.tool.automation.model.ui.elements;

import static java.lang.String.format;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class TableSelect extends TypifiedElement {

  private static final String OPTION_XPATH = ".//div[contains(@class, 'dropdown-menu')]/a";
  private static final String OPTION_BY_NAME_XPATH = OPTION_XPATH + "[.='%s']";

  @FindBy(xpath = ".//button[@aria-haspopup='true']")
  private WebElement expandButton;

  public TableSelect(WebElement wrappedElement) {
    super(wrappedElement);
    HtmlElementLoader.populatePageObject(this, wrappedElement);
  }

  public void selectValue(String value) {
    expandButton.click();
    findElement(By.xpath(format(OPTION_BY_NAME_XPATH, value))).click();
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
