package com.tool.automation.model.ui.pages;

import com.codeborne.selenide.Selenide;
import com.tool.automation.model.ui.beans.ObjectAction;
import com.tool.automation.model.enums.TestObjectsType;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimaps;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.yandex.qatools.htmlelements.element.Button;

public class KeywordsPage extends Page {

  private static final String ACTION_NAME_SEPARATOR = ". ";
  private static final String DATA_ACTION_BTN_XPATH = "//div[@role='group']//a[text()='%s']";

  @FindBy(xpath = ".//div[@class='col-sm-9']/div/div[@aria-hidden='false']")
  private ObjectActionsForm objectActionsForm;
  @FindBy(xpath = "//div[@class='nav-item']//a")
  private List<WebElement> testObjects;


  @FindBy(xpath = "//div[@role='group']/button[@aria-haspopup='true']")
  private Button manageDataBtn;

  private AddTestObjectCard addObjectCard;

  public void addTestObject(String name, String parent) {
    addObjectCard.clickAddObjectButton();
    Selenide.Wait().until((ExpectedCondition<Boolean>) driver -> addObjectCard.isExpanded());

    if (StringUtils.isNotBlank(parent)) {
      addObjectCard.selectObjectType(TestObjectsType.valueOf(parent));
    }
    addObjectCard.typeNewObjectName(name);
    addObjectCard.clickCreateObjectButton();
  }

  public void clickTestObject(String name) {
    testObjects.stream()
        .collect(Multimaps.toMultimap(obj-> getObjectName(obj.getText()), obj->obj, LinkedListMultimap::create))
        .get(name).get(0).click();
  }

  public List<String> getTestObjectsNames() {
    return testObjects.stream()
        .map(o->getObjectName(o.getText()))
        .collect(Collectors.toList());
  }

  public List<String> getActionsNames() {
    return objectActionsForm.getActions().stream().map(ObjectAction::getName).collect(Collectors.toList());
  }

  public void importData(String pathToFile) {
    manageDataBtn.click();
    findElement(By.id("dumpImport")).sendKeys(pathToFile);
    manageDataBtn.click();
  }

  public boolean isImportButtonPresent() {
    manageDataBtn.click();

    boolean present = !findElements(By.id("dumpImport")).isEmpty();

    manageDataBtn.click();
    return present;
  }

  public void clearData() {
    manageDataBtn.click();
    findElement(By.xpath(String.format(DATA_ACTION_BTN_XPATH, "Clear"))).click();
  }

  private String getObjectName(String action) {
    return StringUtils.substringAfter(action, ACTION_NAME_SEPARATOR);
  }
}
