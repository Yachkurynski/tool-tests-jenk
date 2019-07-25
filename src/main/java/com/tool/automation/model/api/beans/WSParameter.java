package com.tool.automation.model.api.beans;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WSParameter {

  private int id;
  private String name;
  private int objectActionId;
  private int parameterTypeId;
}
