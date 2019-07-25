package com.tool.automation.core.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ColumnNames {
  TEST_OBJECT("Test Object"),
  NAME("Name"),
  ACTION("Action"),
  PARAMETERS("Parameters");

  @Getter
  private String name;

  public static ColumnNames getValue(String value) {
    return Arrays.stream(values()).filter(n -> value.equals(n.getName())).findFirst().get();
  }
}
