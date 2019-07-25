package com.tool.automation.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ToolTabs {
  KEYWORDS("Keywords", 1),
  CASES("Cases", 2),
  TEMPLATES("Templates", 3);

  private String name;
  private int id;
}
