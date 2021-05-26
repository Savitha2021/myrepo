package com.jnj.XrayCucumber.testcase;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import applicationUtils.ApplicationUtils;
import applicationUtils.PDCompositionUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDCompositionPageStepDefinitions extends TestRunner {

	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	ApplicationUtils applicationUtils;
	PDCompositionUtils pdcompositionUtils;
	static final String EDIT ="Edit";
	static final String VIEW = "View";
	public static String RMID_withException = null;
	public static String RMID_withOutException = null;
	public static String FMLID=null;

	// CONSTRUCTOR
	public PDCompositionPageStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		pdcompositionUtils = new PDCompositionUtils(driver, elementProperties);
		applicationUtils = new ApplicationUtils(driver);
	}

	// STEP DEFINITONS
	@When("^The User enters created RMID in Search box and click on Search icon on the Composition tab$")
	public void userEntersRMIDinSearchBoxAndClickonSearchIcononCompositionTab() throws Throwable {
		FMLID=pdcompositionUtils.getFormulaId();
		System.out.println("Formula ID:"+FMLID);
		if(RMPreRequisiteStepDefinitions.RMid.size()==0)
		{
			applicationUtils.waitForLoadingImageDisappear();
			String RMID=RMPreRequisiteStepDefinitions.RMID;
			pdcompositionUtils.searchForRawmaterial(RMID);
			pdcompositionUtils.clickAddButtonOnRawMaterial();}
		else
		{
			for(int i=0;i<RMPreRequisiteStepDefinitions.RMid.size();i++)
			{
				pdcompositionUtils.searchForRawmaterial(RMPreRequisiteStepDefinitions.RMid.get(i));
				pdcompositionUtils.clickAddButtonOnRawMaterial();
			}
		}
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User sets QS percentage$")
	public void user_sets_the_QS_percentage() throws Throwable {
		pdcompositionUtils.setQSPercentage();
	}

	@Then("^The User verifies \"([^\"]*)\" page is displayed$")
	public void theUserVerifiesPageIsDisplayed(String page) throws Throwable 
	{
		Assert.assertTrue("Composition Screen is not displayed", applicationUtils.isElementPresent(elementProperties.getProperty("CompositionTabHeaderName")));
		ReportScreenshots.getScreenshot(sharedState);
	}
	
	@When("^The User clicks on \"([^\"]*)\" dropdown on Composition tab$")
	public void theUserClicksOnDropdownOnCompositionTab(String type)throws Throwable 
	{
		applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("CompositionTabDropDown"), type));
		applicationUtils.idleTime(2000);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" option from Action dropdown on Composition tab$")
	public void theUserSelectsOptionFromActionDropdownOnCompositionTab(String option) throws Throwable 
	{
		applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("ActionDropDownOptions"), option));
		applicationUtils.moveToElementClick(elementProperties.getProperty("AngleArrow"));
	}

	@Then("^The User verify \"([^\"]*)\" value is displayed under \"([^\"]*)\" column for marked RAW$")
	public void theUserVerifyValueIsDisplayedUnderColumnForMarkedRAW(String value, String column) throws Throwable	{ 
		Assert.assertTrue(value+"value is not displayed under "+column+" column for marked RAW",pdcompositionUtils.compositioncolumndataverification(value, column));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User edit value under \"([^\"]*)\" column for marked RAW$")
	public void theUserEditValueUnderColumnForMarkedRAW(String column)throws Throwable 
	{
		applicationUtils.moveToElement(String.format(elementProperties.getProperty("WeightValueEdit"),PDCompositionUtils.selectedtradename,column));
		applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("WeightValueEdit"),PDCompositionUtils.selectedtradename,column));
		WebElement element=driver.findElement(By.xpath(String.format(elementProperties.getProperty("WeightValueEdit"),PDCompositionUtils.selectedtradename,column)));
		element.sendKeys(Keys.CONTROL+"a");
		element.sendKeys(Keys.DELETE);
		String data=elementProperties.getProperty("WeightEditData");
		element.sendKeys(data);
	}

	@Then("^The User verify edited value is displayed under \"([^\"]*)\" column for marked RAW$")
	public void theUserVerifyEditedValueIsDisplayedUnderColumnForMarkedRAW(String column) throws Throwable {
		Assert.assertTrue("Edited value is not displayed under "+column+" column for marked RAW",
				pdcompositionUtils.compositioncolumndataverification(elementProperties.getProperty("WeightEditData"), column));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verify selected RAW is not included from the total percentage calculation$")
	public void theUserVerifySelectedRAWIsNotIncludedFromTheTotalPercentageCalculation() throws Throwable {
		Assert.assertTrue("Selected RAW is included from the total percentage calculation",
				applicationUtils.getText(elementProperties.getProperty("TotalPercentage")).trim().equals(elementProperties.getProperty("TotalPercentageData")));
		applicationUtils.scrollToElement(elementProperties.getProperty("TotalPercentage"));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects the RAW added$")
	public void theUserSelectsTheRAWAdded() throws Throwable {
		applicationUtils.scrollPagetoHome();
		driver.navigate().refresh();
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElement("//button[text()='Edit']");
		applicationUtils.clickonElementusingJSE("//button[text()='Edit']");
		PDCompositionUtils.selectedtradename=RMPreRequisiteStepDefinitions.Tradename.get(1).trim();
		applicationUtils.clickonElementusingJSE(String.format(elementProperties.getProperty("RAWSelectCheckBox"),PDCompositionUtils.selectedtradename));
		applicationUtils.waitForLoadingImageDisappear();
	}

	@When("^The User clicks on \"([^\"]*)\" button for RMC Formula Exception on Composition Page$")
	public void theUserClicksOnButtonForRMCFormulaExceptionOnCompositionPage(String button) throws Throwable {
		applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("RMCExceptionConfirmButton"),button));
	}

	@When("^The User enters value in \"([^\"]*)\" textarea on RMC Formula Exception popup$")
	public void theUserEntersValueInTextareaOnRMCFormulaExceptionPopup(String field) throws Throwable {
		applicationUtils.enterText(String.format(elementProperties.getProperty("RMCExceptionComments"), field), elementProperties.getProperty("RMCExceptionCommentsData"));
	}

	@When("^The User clicks on \"([^\"]*)\" option on the PD Composition page$")
	public void userClicksOnOptionOnThePDCompositionPage(String option)	throws Throwable {
		applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("SpanText"), option));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
	}

	@Then("^The User verifies that the \"([^\"]*)\" button is enabled in Formula Composition screen$")
	public void the_User_verifies_that_the_button_is_enabled_in_Formula_Composition_screen(String arg1) throws Throwable {
		Assert.assertTrue("Save as buttion is not enabled in Formula Composition screen", pdcompositionUtils.verifySaveAsButton());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies that the Formula Composition screen is loaded$")
	public void the_user_verifies_that_the_formula_composition_screen_is_loaded() throws Throwable {
		Assert.assertTrue("Formula Composition screen is not loaded", pdcompositionUtils.verifyCompositionScreen());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the Formula ID$")
	public void the_User_verifies_the_Formula_ID() throws Throwable {
		FMLID=pdcompositionUtils.getFormulaId();
		System.out.println("Formula ID:"+FMLID);
		Assert.assertTrue("Formula ID verification is failed", pdcompositionUtils.formulaFormat());
		ReportScreenshots.getScreenshot(sharedState);
	}		

	@Then("^The User verifies the Composition tab has the same RM as the source formula$")
	public void the_user_verifies_the_composition_tab_has_the_same_rm_as_the_source_formula() throws Throwable {
		ReportScreenshots.getScreenshot(sharedState);
		Assert.assertTrue("Composition tab does not have the same RM as the source formula", pdcompositionUtils.verifyRMID());
		applicationUtils.scrollToHorizontal(elementProperties.getProperty("CASNumber"));
		ReportScreenshots.getScreenshot(sharedState);
	}
	
	@Then("^The User verifies Formula is in \"([^\"]*)\" mode$")
	public void the_user_verifies_Formula_status(String status) throws Throwable {
		if (status.equals(EDIT) || status.equals(VIEW)) {
			Assert.assertTrue("Formula is not in " + status + " mode", pdcompositionUtils.verifyFormulaStatus(status));
		} 
		ReportScreenshots.getScreenshot(sharedState);
	}
}