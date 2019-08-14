package com.tool.automation.model.ui.pages;

import com.tool.automation.model.ui.elements.AddElementForm;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasesPage extends Page {

  private static final String TAB_XPATH = "//a[@role='tab']";
  private static final String NEW_ELEMENT_FORM = "//div[@class='form-group']";

  private static final String SUITES_FORM = "//div[@aria-hidden='false']/div/div[@class='col-sm-2']";
  private static final String TESTS_FORM = "//div[@title and @aria-hidden='false']/div[@id='container']";


  @FindBy(xpath = SUITES_FORM + TAB_XPATH)
  private List<WebElement> suitesList;
  @FindBy(xpath = SUITES_FORM + NEW_ELEMENT_FORM)
  private AddElementForm newSuite;

  @FindBy(xpath = TESTS_FORM + TAB_XPATH)
  private List<WebElement> testsList;
  @FindBy(xpath = TESTS_FORM + NEW_ELEMENT_FORM)
  private AddElementForm newTest;

  @Getter
  @FindBy(xpath = TESTS_FORM + "//table[@class='table table-sm table-bordered table-hover']")
  private TestStepsTable stepsTable;
  
  public void addSuite(String suite) {
    newSuite.typeName(suite);
    newSuite.clickAdd();
  }

  public void addTest(String test) {
    newTest.typeName(test);
    newTest.clickAdd();
  }

  public void openSuite(String suite) {
    open(suite, suitesList);
  }

  public void openTest(String test) {
    open(test, testsList);
  }

  public List<String> getSuitesList() {
    return getNames(suitesList);
  }

  public List<String> getTestsList() {
    return getNames(testsList);
  }


  private List<String> getNames(List<WebElement> elements) {
    return elements.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  private void open(String what, List<WebElement> allElements) {
    allElements.stream().filter(elem->what.equals(elem.getText())).findFirst().get().click();
  }

}
