package com.tool.automation.core.utils;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import com.tool.automation.core.exceptions.ATToolRuntimeException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

  private static final String PROP_FILE = "default.properties";

  private PropertyUtils() {}

  public static void bindProperties(Binder binder) {
    Properties props = new Properties();

    try {
      props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROP_FILE));

      System.getProperties().entrySet().stream()
          .filter(e-> props.containsKey(e.getKey()))
          .forEach(e->props.put(e.getKey(), e.getValue()));

      Names.bindProperties(binder, props);
    } catch (IOException e) {
      throw new ATToolRuntimeException("Can't load properties.");
    }
  }

}
