package com.tool.automation.core.utils;

import com.tool.automation.utils.ToolUtils;
import io.restassured.RestAssured;

import java.net.URI;
import java.nio.file.Path;

public class TestApiClient {

  private TestApiClient() {}

  public static String getCase(String sourcePath, int caseNumber) {
    String path = ToolUtils.buildUrl(sourcePath, "api/v1/execution/get/case", String.valueOf(caseNumber));

    return RestAssured.get(path).getBody().asString();
  }
}
