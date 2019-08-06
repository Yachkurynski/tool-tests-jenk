package com.tool.automation.implementation.ui;

import com.tool.automation.model.enums.ToolTabs;
import com.tool.automation.generated.base.IToolActions;

public class UIToolActions extends UICommonActions implements IToolActions {

  @Override
  public void toCasesTab() {
    openTab(ToolTabs.CASES);
  }

  @Override
  public void toKeywordsTab() {
    openTab(ToolTabs.KEYWORDS);
  }

  @Override
  public void toTemplatesTab() {
    openTab(ToolTabs.TEMPLATES);
  }

  @Override
  public void importData(String fileName) {
    getFactory().getKeywordsPage().importData(fileName);
  }

  @Override
  public void clearData() {
    getFactory().getKeywordsPage().clearData();
  }

  private void openTab(ToolTabs tab) {
    startIfNotStarted();
    getFactory().getKeywordsPage().openTab(tab);
  }
}
