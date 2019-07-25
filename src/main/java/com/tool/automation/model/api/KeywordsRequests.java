package com.tool.automation.model.api;

import com.tool.automation.model.enums.TestObjectsType;
import com.tool.automation.model.api.beans.WSObjectAction;
import com.tool.automation.model.api.beans.WSTestObject;
import com.google.common.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class KeywordsRequests {

  public KeywordsRequests() {
    RestAssured.baseURI = "http://10.6.220.15:8090/tool-0.1/api/v1/model";
  }

  public void addTestObject(String name, String parent) {

    WSTestObject testObject = new WSTestObject();
    testObject.setName(name);
    testObject.setParentId(StringUtils.isBlank(parent) ? null : TestObjectsType.getId(parent));

    RestAssured.given().contentType(ContentType.JSON).body(testObject).post("/object");
  }

  public List<WSTestObject> getTestObjects() {
    return RestAssured.get("/objects").as(new TypeToken<List<WSTestObject>>(){}.getType());
  }

  public List<WSObjectAction> getObjectActions(String name) {
    return RestAssured.get("actions/" + TestObjectsType.getId(name))
        .as(new TypeToken<List<WSObjectAction>>(){}.getType());
  }
}
