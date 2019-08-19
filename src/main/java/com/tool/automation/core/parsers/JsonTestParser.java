package com.tool.automation.core.parsers;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.tool.automation.core.beans.SingleTest;
import java.lang.reflect.Type;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class JsonTestParser implements TestParser {

  private final String source;

  @Override
  public List<SingleTest> get() {
    Type type = new TypeToken<List<SingleTest>>() {}.getType();

    return new Gson().fromJson(source, type);
  }
}
