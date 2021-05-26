package com.jnj.XrayCucumber.testcase;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import applicationUtils.ApplicationUtils;
import applicationUtils.CreateNewFormulaUtils;
import applicationUtils.HomeUtils;
import applicationUtils.PDCompositionUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewFormulaStepDefinations extends TestRunner {

	// CONSTANTS
	static final String chassisformula = "Chassis";
	static final String premixformula = "Premix";
	static final String ENABLED = "Enabled";
	static final String DISABLED = "Disabled";
	
	// VARIABLES
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	ApplicationUtils applicationUtils;
	HomeUtils homeUtils;
	CreateNewFormulaUtils createNewFormulaUtils;
	PDCompositionUtils pDCompositionUtils;
	public static String rmid = RMPreRequisiteStepDefinitions.RMID;
	public static String FORMULAID="";

	// CONSRUCTOR
	public CreateNewFormulaStepDefinations(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		createNewFormulaUtils=new CreateNewFormulaUtils(driver, elementProperties);
		homeUtils=new HomeUtils(driver, elementProperties);
		pDCompositionUtils=new PDCompositionUtils(driver, elementProperties);
	}

	// STEP DEFINITIONS
	@When("^The User clicks on \"([^\"]*)\" button on Create New Formula page$")
	public void userClicksOnButtononCreatenewFormulaPage(String button) throws Throwable {
		createNewFormulaUtils.clickButtonCreateNewFormulaPage(button);
	}

	@When("^The User enters value for \"([^\"]*)\" field on Create New Formula page$")
	public void user_enters_values_for_field_on_CreatenewFormula_page(String field) throws Throwable {
		createNewFormulaUtils.enterRandomValueforFields(field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters mandatory fields for \"([^\"]*)\" type on Create New Formula page$")
	public void userEntersMandatoryfieldCreateNewFormulaPage(String fmlType) throws Throwable {
		createNewFormulaUtils.enterValuesforMandatoryFields(fmlType);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" for \"([^\"]*)\" field on Create New Formula page$")
	public void user_selects_value_for_field_on_CreatenewFormula_page(String value, String field) throws Throwable {
		createNewFormulaUtils.selectValueforFields(field,value);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User creates Formula of \"([^\"]*)\" type and adds Raw Material in Composition tab$")
	public void user_creates_Formula_Of_Type(String formulaType) throws Throwable {
		homeUtils.userSelectsOptionFromMenuHomePage("New", "Formula");
		createNewFormulaUtils.selectValueforFields("Formula Type*", formulaType);
		createNewFormulaUtils.enterRandomValueforFields("Lab Notebook No.*");
		createNewFormulaUtils.enterRandomValueforFields("Description*");
		if (formulaType.equals(chassisformula)) {
			createNewFormulaUtils.selectValueforFields("Chassis Region*:", "Asia Pacific");
		} else if (formulaType.equals(premixformula)) {
			createNewFormulaUtils.selectValueforFields("Premix Region*", "Asia Pacific");
		}
		
		createNewFormulaUtils.clickButtonCreateNewFormulaPage("Create Formula");
		FORMULAID=pDCompositionUtils.getFormulaId();
		System.out.println("Formula ID:"+FORMULAID);
		pDCompositionUtils.searchForRawmaterial(rmid);
		ReportScreenshots.getScreenshot(sharedState);
		pDCompositionUtils.clickAddButtonOnRawMaterial();
		Thread.sleep(4000);
		ReportScreenshots.getScreenshot(sharedState);
		pDCompositionUtils.setQSPercentage();
		homeUtils.userClicksOnButton("Save");
		applicationUtils.waitForLoadingImageDisappear();
		homeUtils.userClicksOnButton("OK");
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies that \"([^\"]*)\" page is displayed$")
	public void the_User_verifies_that_page_is_displayed(String arg1) throws Throwable {
		boolean result = createNewFormulaUtils.verifyCreateNewFormulaPageHeader();
		Assert.assertTrue("Create New Formula page is not displayed",result );
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the fieldname \"([^\"]*)\"  is displayed$")
	public void the_User_verifies_the_fieldname_is_displayed(String fieldNames) throws Throwable {
		boolean result =createNewFormulaUtils.verifyTheFieldNames(fieldNames);
		Assert.assertTrue("Filed name is not displayed",result );
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User fills all the mandatory fields with values$")
	public void the_user_fills_all_the_mandatory_fields_with_values() throws Throwable {
		createNewFormulaUtils.fillAllMandetoryFieldsForCustomWorkflow();
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies Formula Type options for \"([^\"]*)\" role$")
	public void userVerifiesFormulaTypesForUser(String userRole) throws Throwable {
		Assert.assertTrue("Formula Type Options are not displayed",
				createNewFormulaUtils.userVerifiesFormulaTypesForUserRole(userRole));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies Formula is the default value of Formula Type field$")
	public void userVerifiesFormulaSelectedDefaultforFormulaTypes() throws Throwable {
		Assert.assertTrue("Formula is not the default selected Option",
				createNewFormulaUtils.userVerifyValueOfFormulaType());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies mandatory fields for \"([^\"]*)\" type on Create New Formula page$")
	public void userVerifiesMandatoryFieldsForonCreatenewFormulaPage(String fmlType) throws Throwable {
		Assert.assertTrue("Mandatory fields not matching", createNewFormulaUtils.userVerifiesMandatoryFields(fmlType));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies non mandatory fields for \"([^\"]*)\" type on Create New Formula page$")
	public void userVerifiesNonMandatoryFieldsForonCreatenewFormulaPage(String fmlType) throws Throwable {
		Assert.assertTrue("Non mandatory fields not matching",
				createNewFormulaUtils.userVerifiesNonMandatoryFields(fmlType));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" field is disabled on Create New Formula page$")
	public void userVerifiesFieldIsDisabledonCreatenewFormulaPage(String field) throws Throwable {
		Assert.assertTrue("'" + field + "' field is not Disabled", createNewFormulaUtils.verifyFieldStatusCreateNewFormula(field,"Disabled"));
		ReportScreenshots.getScreenshot(sharedState);
	}
}