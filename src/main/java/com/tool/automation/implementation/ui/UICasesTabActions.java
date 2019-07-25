package com.tool.automation.implementation.ui;

import com.tool.automation.generated.base.ICasesTabActions;
import java.util.List;
import org.testng.Assert;

public class UICasesTabActions extends UICommonActions implements ICasesTabActions {

  @Override
  public void hasSuitesList(List<String> suitesList) {
    Assert.assertEquals(getFactory().getCasesPage().getSuitesList(), suitesList);
  }

  @Override
  public void addSuite(String suiteName) {
    getFactory().getCasesPage().addSuite(suiteName);
  }

  @Override
  public void openSuite(String suiteName) {
    getFactory().getCasesPage().openSuite(suiteName);
  }
}
