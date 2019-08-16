package com.tool.automation.model.ui.pages;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.tool.automation.model.enums.StepsTableColumns;
import com.tool.automation.model.ui.elements.TableSelect;
import com.tool.automation.model.ui.utils.DriverUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
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

  @FindBy(xpath = ".//tbody/tr/td/form")
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

  public Map<String, String> getArgumentsColumnValues(int row) {
    String args = findElement(getCellLocator(row, StepsTableColumns.ACTION_AND_ARGS, "/div"))
        .getText();

    return StringUtils.isBlank(args) ? new HashMap<>() : parseArguments(convertToJSONFormat(args));
  }

  private List<String> getColumnValues(String columnXpath) {
    return findElements(xpath(columnXpath)).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  private void addNewStep(String object, String name, String action, String arguments) {
    int initialSize = getObjectsColumnValues().size();

    newStep.selectObject(object);
    newStep.typeAndSelectName(name);
    newStep.selectAction(action);

    if (StringUtils.isNotBlank(arguments)) {
      parseArguments(arguments).forEach(newStep::typeArgument);
    }
    newStep.clickAddStep();

    DriverUtils.waitUntil(this, t -> initialSize < getObjectsColumnValues().size());
  }

  private Map<String, String> parseArguments(String arguments) {
    Type dataType = new TypeToken<Map<String, String>>() {}.getType();

    return new Gson().fromJson(arguments, dataType);
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
    newStep.selectObject(object);
  }

  public List<String> getLocationNames() {
    return newStep.getNames();
  }

  public void selectAction(String action) {
    newStep.selectAction(action);
  }

  public List<String> getParameters() {
    return newStep.getArguments();
  }

  public void typeAndSelectName(String name) {
    newStep.typeAndSelectName(name);
  }

  public void selectName(String name) {
    newStep.selectName(name);
  }

  public void clickAddStep() {
    newStep.clickAddStep();
  }

  private String convertToJSONFormat(String source) {
    return String.format("{%s}", source.replace(" = ", ":").replace(" |", ","));
  }

  public List<String> getNamesStartWith(String name) {
    return newStep.getNamesStartWith(name);
  }
}
