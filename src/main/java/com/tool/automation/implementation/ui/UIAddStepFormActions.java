package com.tool.automation.implementation.ui;

import com.tool.automation.model.ui.pages.TestStepsTable;
import com.tool.automation.generated.base.IAddStepFormActions;
import java.util.List;
import org.testng.Assert;

public class UIAddStepFormActions extends UICommonActions implements IAddStepFormActions {

  @Override
  public void selectObject(String object) {
    table().selectObject(object);
  }

  @Override
  public void hasLocationNames(List<String> names) {
    Assert.assertEquals(table().getLocationNames(), names);
  }

  @Override
  public void selectAction(String action) {
    table().selectAction(action);
  }

  @Override
  public void hasParameters(List<String> parameters) {
    Assert.assertEquals(table().getParameters(), parameters);
  }

  @Override
  public void addAndSelectNewName(String name) {
    table().typeAndSelectName(name);
  }

  @Override
  public void selectExistingName(String name) {
    table().selectName(name);
  }

  private TestStepsTable table() {
    return getFactory().getCasesPage().getStepsTable();
  }
}
