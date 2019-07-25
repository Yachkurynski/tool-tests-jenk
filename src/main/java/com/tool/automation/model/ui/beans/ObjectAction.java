package com.tool.automation.model.ui.beans;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ObjectAction {

  private String name;
  private List<Parameter> parameters;
}
