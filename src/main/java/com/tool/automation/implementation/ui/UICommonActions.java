package com.tool.automation.implementation.ui;

import com.tool.automation.core.runner.Config;
import com.tool.automation.model.ui.pages.PageFactory;
import com.tool.automation.model.ui.services.WebDriverService;
import com.google.inject.Inject;
import com.tool.automation.generated.base.ICommonActions;
import lombok.Getter;
import lombok.Setter;

@Getter
public class UICommonActions implements ICommonActions {

  @Inject private PageFactory factory;
  @Inject private WebDriverService service;
  @Inject private Config config;

  @Setter
  private String locationName;

  public void startIfNotStarted() {
    if (!service.isDriverStarted()) {
      service.startDriver(config.getUrl());
    }
  }
}
