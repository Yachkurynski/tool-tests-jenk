
package com.tool.automation.generated.keywords;

import com.google.inject.name.Named;
import com.tool.automation.generated.base.CommonTestObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddStepForm
    extends CommonTestObject
{


    @Test
    @Parameters({
        "object"
    })
    public void selectObject(String object) {
        getAddStepFormActions().selectObject(object);
    }

    @Test
    @Parameters({
        "names"
    })
    public void hasLocationNames(
        @Named("List.String")
        String names_JsonListOfString) {
        getAddStepFormActions().hasLocationNames(jsonToList(names_JsonListOfString, String.class));
    }

    @Test
    @Parameters({
        "action"
    })
    public void selectAction(String action) {
        getAddStepFormActions().selectAction(action);
    }

    @Test
    @Parameters({
        "parameters"
    })
    public void hasParameters(
        @Named("List.String")
        String parameters_JsonListOfString) {
        getAddStepFormActions().hasParameters(jsonToList(parameters_JsonListOfString, String.class));
    }

    @Test
    @Parameters({
        "name"
    })
    public void addAndSelectNewName(String name) {
        getAddStepFormActions().addAndSelectNewName(name);
    }

    @Test
    @Parameters({
        "name"
    })
    public void selectExistingName(String name) {
        getAddStepFormActions().selectExistingName(name);
    }

}
