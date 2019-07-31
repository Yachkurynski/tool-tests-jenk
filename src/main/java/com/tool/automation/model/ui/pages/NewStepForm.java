package com.tool.automation.model.ui.pages;

import static java.lang.String.format;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

import com.tool.automation.model.enums.StepsTableColumns;
import com.tool.automation.model.ui.elements.TableSelect;
import com.tool.automation.model.ui.elements.TableTypifiedSelect;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class NewStepForm extends HtmlElement {

  private static final String COLUMN = "./td[%d]";
  private static final String NAME_SELECT = "/div/div";

  public void selectObject(String object) {
    new TableSelect(findElement(id("dDObject"))).selectValue(object);
  }

  public void selectName(String name) {
    new TableTypifiedSelect(getElementInColumn(StepsTableColumns.NAME, NAME_SELECT)).select(name);
  }

  public void typeAndSelectName(String name) {
    new TableTypifiedSelect(getElementInColumn(StepsTableColumns.NAME, NAME_SELECT)).typeAndSelect(name);
  }

  public List<String> getNames() {
    return new TableTypifiedSelect(getElementInColumn(StepsTableColumns.NAME, NAME_SELECT)).getOptions();
  }

  public void selectAction(String action) {
    new TableSelect(findElement(id("dDAction"))).selectValue(action);
  }

  public void clickAddStep() {
    getElementInColumn(StepsTableColumns.OTHER, "/input[@type='button']").click();
  }

  public void typeArgument(String argument) {
    getElementInColumn(StepsTableColumns.ACTION_AND_ARGS, "//table//input[@type='text']")
        .sendKeys(argument);
  }

  public List<String> getArguments() {
    return getElementsInColumn(StepsTableColumns.ACTION_AND_ARGS, "//table//label")
        .stream().map(WebElement::getText).collect(Collectors.toList());
  }

  private WebElement getElementInColumn(StepsTableColumns column, String xpath) {
    return getElementsInColumn(column, xpath).get(0);
  }

  private List<WebElement> getElementsInColumn(StepsTableColumns column, String xpath) {
    return findElements(xpath(format(COLUMN, column.getColumn()) + xpath));
  }
}
