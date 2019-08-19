package com.tool.automation.model.ui.elements;

import static java.lang.String.format;

import com.tool.automation.model.ui.utils.DriverUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class TableSelect extends TypifiedElement {

  public TableSelect(WebElement wrappedElement) {
    super(wrappedElement);
    HtmlElementLoader.populatePageObject(this, wrappedElement);
  }

  public void select(String value) {
    expand();
    findElement(By.xpath(format(getOptionByNameXpath(), value))).click();
  }

  public List<String> getOptions() {
    expand();

    List<String> options = findElements(By.xpath(getOptionXpath())).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());

    expand();

    return options;
  }

  protected String getExpandButtonXpath() {
    return ".//button[@aria-haspopup='true']";
  }

  protected void expand() {
    DriverUtils.waitUntilVisible(getWrappedElement(), getExpandButtonXpath());

    findElement(By.xpath(getExpandButtonXpath())).click();
  }

  protected String getOptionXpath() {
    return ".//div[contains(@class, 'dropdown-menu')]/a";
  }

  protected String getOptionByNameXpath() {
    return getOptionXpath() + "[text()='%s']";
  }
}
