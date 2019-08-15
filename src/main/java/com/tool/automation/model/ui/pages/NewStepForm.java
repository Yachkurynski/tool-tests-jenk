package com.tool.automation.model.ui.pages;

import com.tool.automation.model.ui.elements.ActionSelect;
import com.tool.automation.model.ui.elements.TableTypifiedSelect;
import com.tool.automation.model.ui.utils.DriverUtils;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;

public class NewStepForm extends HtmlElement {

  private static final String DEFAULT_OBJECT_OPTION = "Select Object";

  private static final String ARGUMENT_INPUT_XPATH = ".//table//td[label[text()='%s']]/input[@type='text']";
  private static final String ARGUMENT_NAME_XPATH = ".//table//label";
  private static final String OBJECT_SELECT = "./select[1]";
  private static final String NAME_SELECT = "./div[1]/div";
  private static final String ACTION_SELECT = "./div[contains(@class, 'dropdown')]";

  @FindBy(xpath = "./button[@type='submit']")
  private Button addButton;

  public void selectObject(String object) {
    Select objSelect = new Select(findElement(By.xpath(OBJECT_SELECT)));

    //workaround for cases when the value stayed in select
    if (object.equals(objSelect.getFirstSelectedOption().getText())) {
      objSelect.selectByVisibleText(DEFAULT_OBJECT_OPTION);
    }
    objSelect.selectByVisibleText(object);

    DriverUtils.waitUntilVisible(this, NAME_SELECT);
  }

  public void selectName(String name) {
    new TableTypifiedSelect(findElement(By.xpath(NAME_SELECT))).select(name);
  }

  public void typeAndSelectName(String name) {
    new TableTypifiedSelect(findElement(By.xpath(NAME_SELECT))).typeAndSelect(name);
  }

  public List<String> getNames() {
    return new TableTypifiedSelect(findElement(By.xpath(NAME_SELECT))).getOptions();
  }

  public void selectAction(String action) {
    new ActionSelect(findElement(By.xpath(ACTION_SELECT))).select(action);
  }

  public void clickAddStep() {
    addButton.click();
  }

  public void typeArgument(String name, String value) {
    String argInputXpath = String.format(ARGUMENT_INPUT_XPATH, name);

    DriverUtils.waitUntilVisible(this, argInputXpath);
    findElement(By.xpath(argInputXpath)).sendKeys(value);
  }

  public List<String> getArguments() {
    return findElements(By.xpath(ARGUMENT_NAME_XPATH)).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

}
