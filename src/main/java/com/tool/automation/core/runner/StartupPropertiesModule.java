package com.tool.automation.core.runner;

import com.google.inject.AbstractModule;
import com.tool.automation.core.utils.PropertyUtils;
public class StartupPropertiesModule extends AbstractModule {

  @Override
  protected void configure() {
    Config config = new Config();

    PropertyUtils.bindProperties(binder());

    bind(Config.class).toInstance(config);
  }

}
