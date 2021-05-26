package com.jnj.XrayCucumber.testcase;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import applicationUtils.ApplicationUtils;
import applicationUtils.HomeUtils;
import applicationUtils.PDAttributesUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDAttributesTabStepDefinitions extends TestRunner {

	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	public static String Formula_ID = null;
	HomeUtils homeUtils;
	ApplicationUtils applicationUtils;
	PDAttributesUtils pDAttributesUtils;
	public String RawMaterilID = RMPreRequisiteStepDefinitions.RMID;

	// CONSTRUCTOR
	public PDAttributesTabStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		pDAttributesUtils = new PDAttributesUtils(driver, elementProperties );
	}

	// STEP DEFINITIONS	
	@When("^The User navigates to \"([^\"]*)\" tab$")
	public void the_User_navigates_to_tab(String tabName) throws Throwable {
		pDAttributesUtils.navigatingToTabs(tabName);
	}

	@When("^The User populates the values for all fields in Attributes tab$")
	public void the_user_populates_the_values_for_all_fields_in_attributes_tab() throws Throwable {
		pDAttributesUtils.enterTheValuesInProjectSubTabOfAttributesTab();
		pDAttributesUtils.storingTheValuesInProjectSubTabOfAttributesTab();
		applicationUtils.scrollPagetoEnd();
		ReportScreenshots.getScreenshot(sharedState);
		pDAttributesUtils.enterTheValuesInProductSubTabOfAttributesTab();
		pDAttributesUtils.enterTheValuesInAssocaitedProductSectionOfAttributesTab();
		pDAttributesUtils.storingTheValuesInProductSubTabOfAttributesTab();
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollPagetoEnd();
		ReportScreenshots.getScreenshot(sharedState);
		pDAttributesUtils.enterTheValuesInFormulaSubTabOfAttributesTab();
		pDAttributesUtils.storingTheValueInFormulaSubTabOfAttributesTab();
		applicationUtils.scrollPagetoEnd();
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the Attributes tab has the same values as the source formula$")
	public void the_user_verifies_the_attributes_tab_has_the_same_values_as_the_source_formula() throws Throwable {
		applicationUtils.scrollPagetoEnd();
		Assert.assertTrue("Project tab does not have the same values as the source formula", pDAttributesUtils.compareTheProjectValuesInAttributesTab());
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.clickOnElement(properties.getProperty("ProductSubTab"));
		Assert.assertTrue("Product tab does not have the same values as the source formula", pDAttributesUtils.compareTheProductValuesInAttributesTab());
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollPagetoEnd();
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.clickOnElement(properties.getProperty("FormulaSubTab"));
		applicationUtils.scrollPagetoEnd();
		Assert.assertTrue("Formula tab does not have the same values as the source formula", pDAttributesUtils.compareTheFormulaValuesInAttributesTab());
		ReportScreenshots.getScreenshot(sharedState);
	}
}