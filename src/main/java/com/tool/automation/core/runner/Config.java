package com.tool.automation.core.runner;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import lombok.Getter;

@Getter
public class Config {

  @Inject
  @Named("url")
  private String url;

  @Inject
  @Named("excel")
  private String excel;

  @Inject
  @Named("api")
  private boolean api;

  @Inject
  @Named("caseNumber")
  private int caseNumber;

  @Inject
  @Named("tool.url")
  private String toolUrl;
}
