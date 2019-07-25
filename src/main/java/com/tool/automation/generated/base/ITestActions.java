
package com.tool.automation.generated.base;

import java.util.List;

public interface ITestActions
    extends ICommonActions
{


    void hasTotalSteps(Double numberOfSteps);

    void addStep(String object, String name, String action, String arguments);

    void addStepAbove(Double row, String object, String name, String action, String arguments);

    void addStepBelow(Double row, String object, String name, String action, String arguments);

    void hasLocationNames(List<String> names);

    void hasTestObjects(List<String> objects);

    void hasObjectActions(List<String> actions);

    void hasArguments(Double row, List<String> arguments);

}
