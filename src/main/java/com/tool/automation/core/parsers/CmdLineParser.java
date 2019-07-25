package com.tool.automation.core.parsers;

import com.tool.automation.core.exceptions.ATToolRuntimeException;
import org.kohsuke.args4j.CmdLineException;

public class CmdLineParser {

  private CmdLineParser() {}

  public static <T> void parse(T bean, String...args) {
    try {
      new org.kohsuke.args4j.CmdLineParser(bean).parseArgument(args);
    } catch (CmdLineException e) {
      throw new ATToolRuntimeException(e);
    }
  }
}
