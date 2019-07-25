package com.tool.automation.implementation.ui;

import com.tool.automation.model.ui.pages.TestStepsTable;
import com.tool.automation.generated.base.ITestActions;
import java.util.List;
import org.testng.Assert;

public class UITestActions extends UICommonActions implements ITestActions {

  @Override
  public void hasTotalSteps(Double numberOfSteps) {
    Assert.assertEquals(table().getObjectsColumnValues().size(), numberOfSteps.intValue());
  }

  @Override
  public void addStep(String object, String name, String action, String arguments) {
    table().addStep(object, name, action, arguments);
  }

  @Override
  public void addStepAbove(Double row, String object, String name, String action, String arguments) {
    table().addStepAbove(row.intValue(), object, name, action, arguments);
  }

  @Override
  public void addStepBelow(Double row, String object, String name, String action, String arguments) {
    table().addStepBelow(row.intValue(), object, name, action, arguments);
  }

  @Override
  public void hasLocationNames(List<String> names) {
    Assert.assertEquals(table().getNameColumnValues(), names);
  }

  @Override
  public void hasTestObjects(List<String> objects) {
    Assert.assertEquals(table().getObjectsColumnValues(), objects);
  }

  @Override
  public void hasObjectActions(List<String> actions) {
    Assert.assertEquals(table().getActionsColumnValues(), actions);
  }

  @Override
  public void hasArguments(Double row, List<String> arguments) {
    Assert.assertEquals(table().getArgumentsColumnValues(row.intValue()), arguments);
  }

  private TestStepsTable table() {
    return getFactory().getCasesPage().getStepsTable();
  }
}
