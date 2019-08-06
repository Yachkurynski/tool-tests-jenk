
package com.tool.automation.generated.base;

import java.util.List;

public interface ITestActions
    extends ICommonActions
{


    void hasTotalSteps(Double numberOfSteps);

    void addStep(String object, String name, String action, String arguments);

    void addStepAbove(String object, String name, String action, String arguments, Double row);

    void addStepBelow(String object, String name, String action, String arguments, Double row);

    void hasLocationNames(List<String> names);

    void hasTestObjects(List<String> objects);

    void hasObjectActions(List<String> actions);

    void hasArguments(List<String> arguments);

}
