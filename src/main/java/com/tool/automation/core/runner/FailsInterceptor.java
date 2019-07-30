package com.tool.automation.core.runner;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class FailsInterceptor extends TestListenerAdapter {

  public static boolean failed;

  public void onTestFailure(ITestResult result) {

    if (!FailsInterceptor.failed) {
      FailsInterceptor.failed = true;
    }
    super.onTestFailure(result);
  }

}
