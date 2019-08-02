
package com.tool.automation.generated.base;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.inject.Inject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;

@Guice(moduleFactory = ModuleFactory.class)
public abstract class CommonTestObject {

    private Gson gson;
    private Type type;
    private TypeToken typeToken;
    private String locationName;
    @Inject
    private ITemplateActions templateActions;

    @BeforeClass
    @Parameters({
        "objectName"
    })
    public void parseTestArgs(String locationName) {
        this.locationName = locationName;
    }

    protected<T >List<T> jsonToList(String jsonSource, Class<T> listItemType) {
                Type dataType = new TypeToken<List<T>>() {}.getType();

        return new Gson().fromJson(jsonSource, dataType);

    }

    protected<T >Map<String, T> jsonToMap(String jsonSource, Class<T> mapItemType) {
                Type dataType = new TypeToken<Map<String, T>>() {}.getType();

        return new Gson().fromJson(jsonSource, dataType);

    }

    protected ITemplateActions getTemplateActions() {
        templateActions.setLocationName(locationName);
        return templateActions;
    }

}
