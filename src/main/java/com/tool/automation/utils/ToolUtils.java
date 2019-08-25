package com.tool.automation.utils;

import java.net.URI;
import java.util.Arrays;

public class ToolUtils {

    public static String buildUrl(String first, String... more) {
        URI[] result = {URI.create(first)};
        Arrays.stream(more)
                .map(URI::create)
                .forEach(uri -> result[0] = result[0].resolve(uri));

        return result[0].toString();
    }
}
