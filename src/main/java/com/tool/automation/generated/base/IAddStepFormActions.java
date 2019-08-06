
package com.tool.automation.generated.base;

import java.util.List;

public interface IAddStepFormActions
    extends ICommonActions
{


    void selectObject(String object);

    void hasLocationNames(List<String> names);

    void selectAction(String action);

    void hasParameters(List<String> parameters);

    void addAndSelectNewName(String name);

    void selectExistingName(String name);

}
