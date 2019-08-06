package com.tool.automation.model.ui.pages;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.tool.automation.model.enums.StepsTableColumns;
import com.tool.automation.model.ui.elements.TableSelect;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class TestStepsTable extends HtmlElement {

  private static final String COLUMN_DATA = "./tbody/tr/td[%d]";
  private static final String ROW = "./tbody/tr[%d]";
  private static final String CELL_DATA = ROW + "/td[%d]";

  @FindBy(xpath = ".//tbody/tr[td[input[@type='button']]]")
  private NewStepForm newStep;

  public List<String> getActionsColumnValues() {
    return getColumnValues(format(COLUMN_DATA, StepsTableColumns.ACTION_AND_ARGS.getColumn()) + "/b");
  }

  public void addStep(String object, String name, String action, String arguments) {
    addNewStep(object, name, action, arguments);
  }

  public void addStepAbove(int row, String object, String name, String action, String arguments) {
    selectOtherOption(row,"Add above");
    addNewStep(object, name, action, arguments);
  }

  public void addStepBelow(int row, String object, String name, String action, String arguments) {
    selectOtherOption(row, "Add below");
    addNewStep(object, name, action, arguments);
  }

  public List<String> getNameColumnValues() {
    return getColumnValues(format(COLUMN_DATA, StepsTableColumns.NAME.getColumn()));
  }

  public List<String> getObjectsColumnValues() {
    return getColumnValues(format(COLUMN_DATA, StepsTableColumns.OBJECT.getColumn()) + "/b");
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

  private void addNewStep(String object, String name, String action, String arguments) {

    newStep.selectObject(object);
    newStep.typeAndSelectName(name);
    newStep.selectAction(action);

    if (StringUtils.isNotBlank(arguments)) {
      Map<String, String> argsMap = parseArguments(arguments);
      argsMap.forEach(newStep::typeArgument);
    }
    newStep.clickAddStep();
  }

  private Map<String, String> parseArguments(String arguments) {
    Type dataType = new TypeToken<Map<String, String>>() {}.getType();

    return new Gson().fromJson(String.format("{%s}", arguments), dataType);
  }

  private By getCellLocator(int row, StepsTableColumns column, String xpath) {
    return xpath(format(CELL_DATA, row, column.getColumn()) + xpath);
  }

  private void selectOtherOption(int row, String option) {
    new TableSelect(findElement(
        getCellLocator(row, StepsTableColumns.OTHER, "//div[@class='show dropdown']")))
        .select(option);
  }

  public void selectObject(String object) {
    new NewStepForm().selectObject(object);
  }

  public List<String> getLocationNames() {
    return new NewStepForm().getNames();
  }

  public void selectAction(String action) {
    new NewStepForm().selectAction(action);
  }

  public List<String> getParameters() {
    return new NewStepForm().getArguments();
  }

  public void typeAndSelectName(String name) {
    new NewStepForm().typeAndSelectName(name);
  }

  public void selectName(String name) {
    new NewStepForm().selectName(name);
  }
}
