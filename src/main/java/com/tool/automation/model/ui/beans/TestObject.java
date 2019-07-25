package com.tool.automation.model.ui.beans;

import com.tool.automation.model.enums.TestObjectsType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class TestObject {

  @Getter
  private String name;
  @Getter
  private TestObjectsType type;
}
