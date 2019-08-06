
package com.tool.automation.generated.keywords;

import com.tool.automation.generated.base.CommonTestObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Tool
    extends CommonTestObject
{


    @Test
    public void toCasesTab() {
        getToolActions().toCasesTab();
    }

    @Test
    public void toKeywordsTab() {
        getToolActions().toKeywordsTab();
    }

    @Test
    public void toTemplatesTab() {
        getToolActions().toTemplatesTab();
    }

    @Test
    @Parameters({
        "fileName"
    })
    public void importData(String fileName) {
        getToolActions().importData(fileName);
    }

    @Test
    public void clearData() {
        getToolActions().clearData();
    }

}
