package com.tool.automation.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StepsTableColumns {
  ROW("#", 1),
  OBJECT("Object", 2),
  NAME("Name", 3),
  ACTION_AND_ARGS("Action + Arguments", 4),
  OTHER("...", 5);

  private String name;
  private int column;
}
