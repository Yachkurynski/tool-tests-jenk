package com.tool.automation.model.ui.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class AddElementForm extends HtmlElement {

  @FindBy(xpath = ".//input[@id='addToForm']")
  private TextInput nameField;
  @FindBy(xpath = ".//button[@type='submit']")
  private Button addButton;

  public void typeName(String name) {
    nameField.sendKeys(name);
  }

  public void clickAdd() {
    addButton.click();
  }
}
