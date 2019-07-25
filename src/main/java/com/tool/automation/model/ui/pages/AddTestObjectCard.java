package com.tool.automation.model.ui.pages;

import com.tool.automation.model.ui.elements.Dropdown;
import com.tool.automation.model.enums.TestObjectsType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//div[@class='accordion']/div[@class='card']")
public class AddTestObjectCard extends HtmlElement {

  private static final String EXPANDED_CARD = "./div[contains(@class, 'collapse')]";
  private static final String ADD_TO_FORM_SELECT = EXPANDED_CARD + "//select[@id='addToForm']";
  private static final String ADD_TO_FORM_INPUT = EXPANDED_CARD + "//input[@id='addToForm']";

  @FindBy(xpath = "./div[contains(@class, 'header')]//button[contains(@class, 'link')]")
  private Button addTestObjectButton;
  @FindBy(xpath = EXPANDED_CARD + "//input[@id='addToForm' and @type='text']")
  private TextInput testObjectNameInput;
  @FindBy(xpath = ADD_TO_FORM_SELECT)
  private Dropdown testObjectTypeSelect;
  @FindBy(xpath = ADD_TO_FORM_INPUT + "[@type='button']")
  private TextInput createTestObjectButton;


  public void typeNewObjectName(String name) {
    testObjectNameInput.sendKeys(name);
  }

  public void clickCreateObjectButton() {
    createTestObjectButton.click();
  }

  public void selectObjectType(TestObjectsType type) {
    testObjectTypeSelect.selectByVisibleText(type.getName());
  }

  public void clickAddObjectButton() {
    addTestObjectButton.click();
  }

  public boolean isExpanded(){
    return !this.findElements(By.xpath(EXPANDED_CARD + "[contains(@class, 'show')]")).isEmpty();
  }
}
