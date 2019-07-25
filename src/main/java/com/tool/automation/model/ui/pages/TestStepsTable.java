package com.tool.automation.model.ui.pages;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

import com.tool.automation.model.enums.StepsTableColumns;
import com.tool.automation.model.ui.elements.TableSelect;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//table[@class='table table-sm table-bordered table-hover']")
public class TestStepsTable extends HtmlElement {

  private static final String COLUMN_DATA = "./tbody/tr/td[%d]";
  private static final String ROW = "./tbody/tr[%d]";
  private static final String CELL_DATA = ROW + "/td[%d]";

  public List<String> getActionsColumnValues() {
    return getColumnValues(format(COLUMN_DATA + "/b", StepsTableColumns.ACTION_AND_ARGS.getColumn()));
  }

  public void addStep(String object, String name, String action, String arguments) {
    addStep(getActionsColumnValues().size() + 1, object, name, action, arguments);
  }

  public void addStepAbove(int row, String object, String name, String action, String arguments) {
    selectOtherOption(row,"Add above");
    addStep(row, object, name, action, arguments);
  }

  public void addStepBelow(int row, String object, String name, String action, String arguments) {
    selectOtherOption(row, "Add below");
    addStep(row + 1, object, name, action, arguments);
  }

  public List<String> getNameColumnValues() {
    return getColumnValues(format(COLUMN_DATA, StepsTableColumns.NAME.getColumn()));
  }

  public List<String> getObjectsColumnValues() {
    return getColumnValues(format(COLUMN_DATA + "/b", StepsTableColumns.OBJECT.getColumn()));
  }

  public List<String> getArgumentsColumnValues(int row) {
    return Arrays.asList(findElement(getCellLocator(row, StepsTableColumns.ACTION_AND_ARGS, "/div"))
        .getText().split(","));
  }

  private List<String> getColumnValues(String columnXpath) {
    return findElements(xpath(columnXpath)).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  private void addStep(int row, String object, String name, String action, String arguments) {
    NewStepForm newStep = new NewStepForm(row);

    newStep.selectObject(object);
    newStep.selectName(name);
    newStep.selectAction(action);

    if (StringUtils.isNotBlank(arguments)) {
      newStep.typeArgument(arguments);
    }
    newStep.clickAddStep();
  }

  private By getCellLocator(int row, StepsTableColumns column, String xpath) {
    return xpath(format(CELL_DATA, row, column.getColumn()) + xpath);
  }

  private void selectOtherOption(int row, String option) {
    new TableSelect(findElement(
        getCellLocator(row, StepsTableColumns.OTHER, "//div[@class='show dropdown']")))
        .selectValue(option);
  }

  public void selectObject(String object) {
    new NewStepForm(getObjectsColumnValues().size() + 1).selectObject(object);
  }

  public List<String> getLocationNames() {
    return new NewStepForm(getObjectsColumnValues().size() + 1).getNames();
  }

  public void selectAction(String action) {
    new NewStepForm(getObjectsColumnValues().size() + 1).selectAction(action);
  }

  public List<String> getParameters() {
    return new NewStepForm(getObjectsColumnValues().size() + 1).getArguments();
  }

  public void typeAndSelectName(String name) {
    new NewStepForm(getObjectsColumnValues().size() + 1).typeAndSelectName(name);
  }

  public void selectName(String name) {
    new NewStepForm(getObjectsColumnValues().size() + 1).selectName(name);
  }
}
