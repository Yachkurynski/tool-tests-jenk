package com.tool.automation.core.beans;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SingleTest {

  private String object;
  private String locationName;
  private String action;
  private List<TestArgument> arguments;

  @Override
  public String toString() {
    return String.format("{%s[%s]}--(%s)", object, locationName, action);
  }

  public Map<String, String> getArguments() {
    return arguments.stream().collect(Collectors.toMap(TestArgument::getName, TestArgument::getValue));
  }
}
