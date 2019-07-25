package com.tool.automation.model.ui.pages;

import com.google.inject.Inject;

public class PageFactory {

  @Inject private KeywordsPage keywordsPage;
  @Inject private CasesPage casesPage;

  public KeywordsPage getKeywordsPage() {
    return initPage(keywordsPage);
  }

  public CasesPage getCasesPage() {
    return initPage(casesPage);
  }

  private <P extends Page>  P initPage(P page) {
    page.initialize();

    return page;
  }
}
