package com.jnj.XrayCucumber.testcase;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import applicationUtils.ApplicationUtils;
import applicationUtils.CreateNewFormulaUtils;
import applicationUtils.HomeUtils;
import applicationUtils.PDCompositionUtils;
import applicationUtils.PDRequestApprovalsUtils;
import applicationUtils.RMPrerequisiteUtils;
import cucumber.api.java.en.Given;

public class FormulaStatusStepdefinations extends TestRunner {
	
	// VARIABLES
	public RemoteWebDriver driver;
	static WebDriverWait wait;
	ApplicationUtils applicationUtils;
	HomeUtils homeUtils;
	LoginPageStepDefinitions loginPageStepDefinitions;
	CreateNewFormulaUtils createNewFormulaUtils;
	CreateNewFormulaStepDefinations createNewFormulaStepDefinations;
	PDCompositionUtils pDCompositionUtils;
	PDRequestApprovalsUtils pdrequestapprovalsUtils;
	PDRequestApprovalsPageStepDefinitions pdRequestApprovalsPageStepDefinitions;
	ApproverStepDefinitions approverStepDefinitions;
	PDCompositionPageStepDefinitions pdCompositionPageStepDefinitions;
	HomeStepDefinitions homeStepDefinitions;
	public static String fmlid = null;
	

	// CONSTRUCTOR
	public FormulaStatusStepdefinations(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		homeUtils = new HomeUtils(driver, elementProperties);
		loginPageStepDefinitions = new LoginPageStepDefinitions(sharedState, properties);
		createNewFormulaStepDefinations = new CreateNewFormulaStepDefinations(sharedState, properties);
		createNewFormulaUtils = new CreateNewFormulaUtils(driver, elementProperties);
		pDCompositionUtils = new PDCompositionUtils(driver, elementProperties);
		pdrequestapprovalsUtils = new PDRequestApprovalsUtils(driver, elementProperties);
		pdRequestApprovalsPageStepDefinitions = new PDRequestApprovalsPageStepDefinitions(sharedState, properties);
		approverStepDefinitions = new ApproverStepDefinitions(sharedState);
		pdCompositionPageStepDefinitions=new PDCompositionPageStepDefinitions(sharedState, properties);
		homeStepDefinitions=new HomeStepDefinitions(sharedState, properties);
	}

	// STEP DEFINITIONS
	@Given("^The User creates the formula of \"([^\"]*)\" type with \"([^\"]*)\" role in \"([^\"]*)\" status$")
	public void theUsercreatesTheFormulaStatus(String type,String user,String approvalType) throws Throwable {
		loginPageStepDefinitions.theUserIsLoggedIntoApplicationWithRole("Product Development", user);
		createNewFormulaStepDefinations.user_creates_Formula_Of_Type(type);
		homeUtils.userClicksOnButton("Route for Approval");
		pdrequestapprovalsUtils.enterValuesMandatoryFieldsDataRequired("Approval for Scale Up");
		pdRequestApprovalsPageStepDefinitions.theUserChecksTheCheckbox("Not Applicable");
		pdrequestapprovalsUtils.enterFieldsOnInputsSectionOnRequestApprovalsTab("Region*","Asia Pacific");
		pdrequestapprovalsUtils.enterFieldsOnInputsSectionOnRequestApprovalsTab("Review Requested by*","Current Date" );
		if(RMPrerequisiteUtils.RMCStatus.equals("Exception Required"))
		{
			pdrequestapprovalsUtils.userSelectsApproverOnRequestApprovalsTab("RMC Admin*");
		}
		pdrequestapprovalsUtils.userSelectsApproverOnRequestApprovalsTab("Toxicology/Clinical Safety Preliminary*");
		pdrequestapprovalsUtils.userSelectsApproverOnRequestApprovalsTab("R&D Preliminary*");
		pdrequestapprovalsUtils.userSelectsApproverOnRequestApprovalsTab("APAC Regulatory Preliminary *");
		pdRequestApprovalsPageStepDefinitions.userClicksButtonOnRequestApprovalsTabs("Save");
		boolean flag=homeUtils.verifyTheSucessPopup("Workflow Data Saved Successfully");
		Assert.assertTrue("popup is not dispalyed",flag);
		homeUtils.userClicksOnButton("OK");
		pdrequestapprovalsUtils.userClicksoButtonOnRequestApprovalsTab("Launch Workflow");
		if(RMPrerequisiteUtils.RMCStatus.equals("Exception Required"))
		{
			pdRequestApprovalsPageStepDefinitions.theUserClicksOnIcon("x");
		}
		boolean flag1 = homeUtils.verifyTheSucessPopup("Workflow launched successfully");
		Assert.assertTrue("popup is not dispalyed", flag1);
		homeUtils.userClicksOnButton("OK");
		loginPageStepDefinitions.theUserLogoutFromTheApplication("Product Development");
		if(RMPrerequisiteUtils.RMCStatus.equals("Exception Required")) 
		{
			loginPageStepDefinitions.theUserIsLoggedIntoApplicationWithRole("Product Development", "RMCAdmin");
			homeStepDefinitions.user_enters_the_FML_ID_in_the_Global_search_bar_and_click_on_Search_icon();
			homeStepDefinitions.userSelectsTheFMLIDAvailableLink();
			pdCompositionPageStepDefinitions.theUserClicksOnButtonForRMCFormulaExceptionOnCompositionPage("Confirm");
			pdCompositionPageStepDefinitions.theUserEntersValueInTextareaOnRMCFormulaExceptionPopup("Comments *: ");
			homeStepDefinitions.userclicksonButton("Submit");
			homeStepDefinitions.userVerifiesTheSuccessPopup("Task approved successfully");
			homeStepDefinitions.userclicksonButton("OK");
			loginPageStepDefinitions.theUserLogoutFromTheApplication("Product Development");
		}
		loginPageStepDefinitions.theUserIsLoggedIntoApplicationWithRole("Common Approval Module", "ToxicologyApprover");
		applicationUtils.selectbyValue(elementProperties.getProperty("SearchCategory_CAM"), "Formula");
		approverStepDefinitions.userEntersTheFMLIDToBeApprovedInTheGlobalSearchBarAndClickOnSearchIcon();
		approverStepDefinitions.userSelectsTheFMLIDAvailableLinkInModule("Common Approvals");
/*		if ("Common Approvals".equalsIgnoreCase("Common Approvals")) {
			Assert.assertTrue("Searched Result", applicationUtils
					.getText(elementProperties.getProperty("SearchedResult_RawIDLink")).trim().equals(fmlid));
			applicationUtils.moveToElementClick(elementProperties.getProperty("SearchedResult_RawIDLink"));
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
		}*/
		
		approverStepDefinitions.userClicksOnButtonOnThePage("Approve", "GXP Approval Module");
		Assert.assertTrue("e-signature window not displayed", applicationUtils
				.isElementDisplayed(String.format(elementProperties.getProperty("ButtonContainsText"), "I Agree")));
		approverStepDefinitions.the_User_enter_the_Username_and_Password_on_the_e_Signature_window();
		approverStepDefinitions.userClicksOnButtonOnTheESignatureWindow("I Agree");
		boolean flag2=homeUtils.verifyTheSucessPopup("Task Approved Successfully");
		Assert.assertTrue("popup is not dispalyed",flag2);
		homeUtils.userClicksOnButton("OK");
		loginPageStepDefinitions.theUserLogoutFromTheApplication("Common Approval Module");
		
		loginPageStepDefinitions.theUserIsLoggedIntoApplicationWithRole("Common Approval Module", "APACRegulatoryApprover");
		applicationUtils.selectbyValue(elementProperties.getProperty("SearchCategory_CAM"), "Formula");
		approverStepDefinitions.userEntersTheFMLIDToBeApprovedInTheGlobalSearchBarAndClickOnSearchIcon();
		approverStepDefinitions.userSelectsTheFMLIDAvailableLinkInModule("Common Approvals");
/*		if ("Common Approvals".equalsIgnoreCase("Common Approvals")) {
			Assert.assertTrue("Searched Result", applicationUtils
					.getText(elementProperties.getProperty("SearchedResult_RawIDLink")).trim().equals(fmlid));
			applicationUtils.moveToElementClick(elementProperties.getProperty("SearchedResult_RawIDLink"));
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
		}*/
		
		approverStepDefinitions.userClicksOnButtonOnThePage("Approve", "GXP Approval Module");
		Assert.assertTrue("e-signature window not displayed", applicationUtils
				.isElementDisplayed(String.format(elementProperties.getProperty("ButtonContainsText"), "I Agree")));
		approverStepDefinitions.the_User_enter_the_Username_and_Password_on_the_e_Signature_window();
		approverStepDefinitions.userClicksOnButtonOnTheESignatureWindow("I Agree");
		boolean flag3=homeUtils.verifyTheSucessPopup("Task Approved Successfully");
		Assert.assertTrue("popup is not dispalyed",flag3);
		homeUtils.userClicksOnButton("OK");
		loginPageStepDefinitions.theUserLogoutFromTheApplication("Common Approval Module");
		
		loginPageStepDefinitions.theUserIsLoggedIntoApplicationWithRole("Common Approval Module", "RDApprover");
		applicationUtils.selectbyValue(elementProperties.getProperty("SearchCategory_CAM"), "Formula");
		approverStepDefinitions.userEntersTheFMLIDToBeApprovedInTheGlobalSearchBarAndClickOnSearchIcon();
		approverStepDefinitions.userSelectsTheFMLIDAvailableLinkInModule("Common Approvals");
	/*	if ("Common Approvals".equalsIgnoreCase("Common Approvals")) {
			Assert.assertTrue("Searched Result", applicationUtils
					.getText(elementProperties.getProperty("SearchedResult_RawIDLink")).trim().equals(fmlid));
			applicationUtils.moveToElementClick(elementProperties.getProperty("SearchedResult_RawIDLink"));
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
		}*/
		
		approverStepDefinitions.userClicksOnButtonOnThePage("Approve", "GXP Approval Module");
		Assert.assertTrue("e-signature window not displayed", applicationUtils
				.isElementDisplayed(String.format(elementProperties.getProperty("ButtonContainsText"), "I Agree")));
		approverStepDefinitions.the_User_enter_the_Username_and_Password_on_the_e_Signature_window();
		approverStepDefinitions.userClicksOnButtonOnTheESignatureWindow("I Agree");
		boolean flag4=homeUtils.verifyTheSucessPopup("Task Approved Successfully");
		Assert.assertTrue("popup is not dispalyed",flag4);
		homeUtils.userClicksOnButton("OK");
		loginPageStepDefinitions.theUserLogoutFromTheApplication("Common Approval Module");
		
		loginPageStepDefinitions.theUserIsLoggedIntoApplicationWithRole("Product Development", user);
		homeStepDefinitions.user_enters_the_FML_ID_in_the_Global_search_bar_and_click_on_Search_icon();
		homeStepDefinitions.userSelectsTheFMLIDAvailableLink();
		pdCompositionPageStepDefinitions.userClicksOnOptionOnThePDCompositionPage("Status");
		loginPageStepDefinitions.theUserLogoutFromTheApplication("Product Development");
	}
}