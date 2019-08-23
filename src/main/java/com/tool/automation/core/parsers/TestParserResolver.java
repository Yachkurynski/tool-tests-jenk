package com.tool.automation.core.parsers;

import com.tool.automation.core.runner.Config;
import com.tool.automation.core.utils.TestApiClient;
import java.io.File;

public class TestParserResolver {

  private static final int DEFAULT_CASE = -1;

  private TestParserResolver() {}

  public static TestParser getTestParser(Config config) {
    return isUseCase(config) ?
        JsonTestParser.of(TestApiClient.getCase(config.getToolUrl(), config.getCaseNumber())) :
        ExcelTestParser.of(new File(config.getExcel()));
  }

  private static boolean isUseCase(Config config) {
    return config.getCaseNumber() != DEFAULT_CASE;
  }
}
