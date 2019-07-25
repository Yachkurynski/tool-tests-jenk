package com.tool.automation.core.runner;

import lombok.Getter;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.BooleanOptionHandler;

@Getter
public class Config {


  @Option(name = "-url")
  private String url;

  @Option(name = "-excel")
  private String excel;

  @Option(name = "-api", handler = BooleanOptionHandler.class)
  private boolean api;
}
