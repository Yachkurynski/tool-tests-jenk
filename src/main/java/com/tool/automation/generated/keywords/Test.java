
package com.tool.automation.generated.keywords;

import com.google.inject.name.Named;
import com.tool.automation.generated.base.CommonTestObject;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Test
    extends CommonTestObject
{


    @org.testng.annotations.Test
    @Parameters({
        "numberOfSteps"
    })
    public void hasTotalSteps(Double numberOfSteps) {
        getTestActions().hasTotalSteps(numberOfSteps);
    }

    @org.testng.annotations.Test
    @Parameters({
        "object",
        "name",
        "action",
        "arguments"
    })
    public void addStep(String object, String name, String action,
        @Optional
        String arguments) {
        getTestActions().addStep(object, name, action, arguments);
    }

    @org.testng.annotations.Test
    @Parameters({
        "object",
        "name",
        "action",
        "arguments",
        "row"
    })
    public void addStepAbove(String object, String name, String action,
        @Optional
        String arguments, Double row) {
        getTestActions().addStepAbove(object, name, action, arguments, row);
    }

    @org.testng.annotations.Test
    @Parameters({
        "object",
        "name",
        "action",
        "arguments",
        "row"
    })
    public void addStepBelow(String object, String name, String action,
        @Optional
        String arguments, Double row) {
        getTestActions().addStepBelow(object, name, action, arguments, row);
    }

    @org.testng.annotations.Test
    @Parameters({
        "names"
    })
    public void hasLocationNames(
        @Named("List.String")
        String names_JsonListOfString) {
        getTestActions().hasLocationNames(jsonToList(names_JsonListOfString));
    }

    @org.testng.annotations.Test
    @Parameters({
        "objects"
    })
    public void hasTestObjects(
        @Named("List.String")
        String objects_JsonListOfString) {
        getTestActions().hasTestObjects(jsonToList(objects_JsonListOfString));
    }

    @org.testng.annotations.Test
    @Parameters({
        "actions"
    })
    public void hasObjectActions(
        @Named("List.String")
        String actions_JsonListOfString) {
        getTestActions().hasObjectActions(jsonToList(actions_JsonListOfString));
    }

    @org.testng.annotations.Test
    @Parameters({
        "row",
        "arguments"
    })
    public void hasArguments(Double row,
        @Named("Map.String")
        String arguments_JsonMapOfString) {
        getTestActions().hasArguments(row, jsonToMap(arguments_JsonMapOfString));
    }

}
