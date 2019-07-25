package com.tool.automation.model.ui.elements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.Select;

public class Dropdown extends Select {

  public Dropdown(WebElement wrappedElement) {
    super(wrappedElement);
  }

  @Override
  public void selectByVisibleText(String text) {
    click();

    List<WebElement> options = findElements(By.xpath(String.format("./option[.='%s']", text)));

    if (options.isEmpty()) {
      throw new NoSuchElementException(String.format("[%s] not found", text));
    } else {
      options.get(0).click();
    }
  }
}
