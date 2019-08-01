package com.tool.automation.core.runner;

import com.tool.automation.core.utils.PropertyUtils;
import com.tool.automation.model.ui.pages.PageFactory;
import com.tool.automation.model.ui.services.WebDriverService;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.tool.automation.generated.base.IAddStepFormActions;
import com.tool.automation.generated.base.ICasesTabActions;
import com.tool.automation.generated.base.ICommonActions;
import com.tool.automation.generated.base.ISuiteActions;
import com.tool.automation.generated.base.ITemplateActions;
import com.tool.automation.generated.base.ITestActions;
import com.tool.automation.generated.base.IToolActions;
import com.tool.automation.implementation.api.APIAddStepFormActions;
import com.tool.automation.implementation.api.APICasesTabActions;
import com.tool.automation.implementation.api.APICommonActions;
import com.tool.automation.implementation.api.APISuiteActions;
import com.tool.automation.implementation.api.APITemplateActions;
import com.tool.automation.implementation.api.APITestActions;
import com.tool.automation.implementation.api.APIToolActions;
import com.tool.automation.implementation.ui.UIAddStepFormActions;
import com.tool.automation.implementation.ui.UICasesTabActions;
import com.tool.automation.implementation.ui.UICommonActions;
import com.tool.automation.implementation.ui.UISuiteActions;
import com.tool.automation.implementation.ui.UITemplateActions;
import com.tool.automation.implementation.ui.UITestActions;
import com.tool.automation.implementation.ui.UIToolActions;

public class ToolActionsModule extends AbstractModule {

  private static final String API_PROP = "api";

  @Override
  protected void configure() {
    Config config = new Config();

    PropertyUtils.bindProperties(binder());

    if (Boolean.valueOf(System.getProperty(API_PROP))) {
      bind(IAddStepFormActions.class).to(APIAddStepFormActions.class);
      bind(ICasesTabActions.class).to(APICasesTabActions.class);
      bind(ICommonActions.class).to(APICommonActions.class);
      bind(ISuiteActions.class).to(APISuiteActions.class);
      bind(ITemplateActions.class).to(APITemplateActions.class);
      bind(ITestActions.class).to(APITestActions.class);
      bind(IToolActions.class).to(APIToolActions.class);
    } else {
      bind(IAddStepFormActions.class).to(UIAddStepFormActions.class);
      bind(ICasesTabActions.class).to(UICasesTabActions.class);
      bind(ICommonActions.class).to(UICommonActions.class);
      bind(ISuiteActions.class).to(UISuiteActions.class);
      bind(ITemplateActions.class).to(UITemplateActions.class);
      bind(ITestActions.class).to(UITestActions.class);
      bind(IToolActions.class).to(UIToolActions.class);
    }

    bind(Config.class).toInstance(config);
    bind(WebDriverService.class).in(Scopes.SINGLETON);
    bind(PageFactory.class).in(Scopes.SINGLETON);
  }
}
