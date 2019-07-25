
package com.tool.automation.generated.keywords;

import com.google.inject.name.Named;
import com.tool.automation.generated.base.CommonTestObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CasesTab
    extends CommonTestObject
{


    @Test
    @Parameters({
        "suitesList"
    })
    public void hasSuitesList(
        @Named("List.String")
        String suitesList_JsonListOfString) {
        getCasesTabActions().hasSuitesList(jsonToList(suitesList_JsonListOfString, String.class));
    }

    @Test
    @Parameters({
        "suiteName"
    })
    public void addSuite(String suiteName) {
        getCasesTabActions().addSuite(suiteName);
    }

    @Test
    @Parameters({
        "suiteName"
    })
    public void openSuite(String suiteName) {
        getCasesTabActions().openSuite(suiteName);
    }

}
