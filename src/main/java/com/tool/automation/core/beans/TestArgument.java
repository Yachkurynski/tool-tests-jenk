package com.tool.automation.core.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class TestArgument {

  private TestActionParameter actionParameter;
  private String value;

  public TestArgument(String name, String value) {
    actionParameter = new TestActionParameter(name);
    this.value = value;
  }

  public String getName() {
    return actionParameter.getName();
  }

  @AllArgsConstructor
  private class TestActionParameter {
    @Getter
    private String name;
  }
}
