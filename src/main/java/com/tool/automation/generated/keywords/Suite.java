
package com.tool.automation.generated.keywords;

import com.google.inject.name.Named;
import com.tool.automation.generated.base.CommonTestObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Suite
    extends CommonTestObject
{


    @Test
    @Parameters({
        "testsList"
    })
    public void hasTestsList(
        @Named("List.String")
        String testsList_JsonListOfString) {
        getSuiteActions().hasTestsList(jsonToList(testsList_JsonListOfString));
    }

    @Test
    @Parameters({
        "testName"
    })
    public void addTest(String testName) {
        getSuiteActions().addTest(testName);
    }

    @Test
    @Parameters({
        "testName"
    })
    public void openTest(String testName) {
        getSuiteActions().openTest(testName);
    }

}
