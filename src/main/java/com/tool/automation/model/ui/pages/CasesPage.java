package com.tool.automation.model.ui.pages;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CasesPage extends Page {

  private static final String TAB_XPATH = "//a[@role='tab']";
  private static final String NEW_ELEMENT = "//input[@id='addToForm']";
  private static final String NEW_ELEMENT_INPUT = NEW_ELEMENT + "[@type='text']";
  private static final String NEW_ELEMENT_BUTTON = NEW_ELEMENT + "[@type='button']";

  private static final String SUITES_FORM = "//div[@aria-hidden='false']/div/div[@class='col-sm-2']";
  private static final String TESTS_FORM = "//div[@title and @aria-hidden='false']/div[@id='container']";


  @FindBy(xpath = SUITES_FORM + TAB_XPATH)
  private List<WebElement> suitesList;
  @FindBy(xpath = SUITES_FORM + NEW_ELEMENT_INPUT)
  private TextInput newSuiteName;
  @FindBy(xpath = SUITES_FORM + NEW_ELEMENT_BUTTON)
  private Button addSuiteButton;

  @FindBy(xpath = TESTS_FORM + TAB_XPATH)
  private List<WebElement> testsList;
  @FindBy(xpath = TESTS_FORM + NEW_ELEMENT_INPUT)
  private TextInput newTestName;
  @FindBy(xpath = TESTS_FORM + NEW_ELEMENT_BUTTON)
  private Button addTestButton;

  @Getter
  private TestStepsTable stepsTable;
  
  public void addSuite(String suite) {
    newSuiteName.sendKeys(suite);
    addSuiteButton.click();
  }

  public void addTest(String test) {
    newTestName.sendKeys(test);
    addTestButton.click();
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
