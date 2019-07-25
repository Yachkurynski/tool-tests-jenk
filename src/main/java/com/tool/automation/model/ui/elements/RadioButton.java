package com.tool.automation.model.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.Radio;

public class RadioButton extends Radio {

  public RadioButton(WebElement wrappedElement) {
    super(wrappedElement);
  }

  @Override
  public void selectByValue(String value) {
    WebElement matchingButton = this.getButtons().stream()
        .filter(b->b.findElement(By.xpath("./following::label")).getText().equals("Number"))
        .findFirst().orElseThrow(() -> new NoSuchElementException(
            String.format("Cannot locate radio button with value: %s", value)));

    select(matchingButton);
  }

  private void select(WebElement button) {
    if (!button.isSelected()) {
      button.click();
    }

  }
}
