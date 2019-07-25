package com.tool.automation.model.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TestObjectsType {
  TOOL(1, "Tool"),
  CASES_TAB(2, "CasesTab"),
  SUITE(3, "Suite"),
  TEST(4, "Test"),
  ADD_STEP_FORM(5, "AddStepForm");

  private int id;
  private String name;

  public static int getId(String name) {
    return Arrays.stream(values())
        .filter(v -> name.equals(v.getName()))
        .findFirst().get().getId();
  }

  public static int getName(int id) {
    return Arrays.stream(values())
        .filter(v -> id == v.getId())
        .findFirst().get().getId();
  }
}
