package com.tool.automation.core.utils;

import io.restassured.RestAssured;

public class TestApiClient {

  private TestApiClient() {}

  public static String getCase(String sourcePath, int caseNumber) {
    String path = String.format("%s/api/v1/execution/get/case/%s", sourcePath, caseNumber);

    return RestAssured.get(path).getBody().asString();
  }
}
