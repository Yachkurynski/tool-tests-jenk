package com.tool.automation.implementation.ui;

import com.tool.automation.generated.base.ISuiteActions;
import java.util.List;
import org.testng.Assert;

public class UISuiteActions extends UICommonActions implements ISuiteActions {

  @Override
  public void hasTestsList(List<String> testsList) {
    Assert.assertEquals(getFactory().getCasesPage().getTestsList(), testsList);
  }

  @Override
  public void addTest(String testName) {
    getFactory().getCasesPage().addTest(testName);
  }

  @Override
  public void openTest(String testName) {
    getFactory().getCasesPage().openTest(testName);
  }
}
