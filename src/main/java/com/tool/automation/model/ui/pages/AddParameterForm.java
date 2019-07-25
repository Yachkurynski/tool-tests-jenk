package com.tool.automation.model.ui.pages;

import com.tool.automation.model.ui.elements.RadioButton;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class AddParameterForm extends HtmlElement {

  @FindBy(xpath = "./div[contains(@class, 'sm-4')]/input[@type='text']")
  private TextInput name;
  @FindBy(xpath = ".//input[@name='typeId']")
  private RadioButton type;
  @FindBy(xpath = ".//input[@name='formId']")
  private RadioButton form;
  @FindBy(xpath = ".//input[@name='paramOptional']")
  private CheckBox isOptional;
  @FindBy(xpath = "./div[contains(@class, 'sm-2')]/button[@type='button']")
  private Button addButton;

  public void typeName(String name) {
    this.name.sendKeys(name);
  }

  public void selectType(String type) {
    this.type.selectByValue(type);
  }

  public void selectForm(String form) {
    this.form.selectByValue(form);
  }

  public void checkIsOptional() {
    isOptional.set(true);
  }

  public void uncheckIsOptional() {
    isOptional.set(false);
  }

  public void clickAddButton() {
    addButton.click();
  }
}
