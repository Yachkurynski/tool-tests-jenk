package com.tool.automation.core.beans;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SingleTest {

  private Class<?> testClass;
  private String name;
  private String testMethod;
  private Map<String, String> parameters;

  @Override
  public String toString() {
    return String.format("{%s[%s]}--(%s)", testClass.getSimpleName(), name, testMethod);
  }
}
