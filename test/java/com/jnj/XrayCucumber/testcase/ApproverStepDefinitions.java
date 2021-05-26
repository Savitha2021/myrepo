package com.jnj.XrayCucumber.testcase;

import javax.ws.rs.NotSupportedException;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import applicationUtils.ApplicationUtils;
import applicationUtils.CreateNewFormulaUtils;
import applicationUtils.HomeUtils;
import applicationUtils.LoginLogoutUtils;
import applicationUtils.PDRequestApprovalsUtils;

public class ApproverStepDefinitions extends TestRunner
{
	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	public static String RMID = null;
	public static String fmlid=null;
	static WebDriverWait wait;
	HomeUtils homeUtils;
	ApplicationUtils applicationUtils;
	CreateNewFormulaUtils createNewFormulaUtils;
	PDRequestApprovalsUtils pdRequestApprovalsUtils;
	public static String selectedoption=null;
	public static String rmcadmin=null;
	public static String requestedbydate=null;
	public static String toxicologyapprover=null;
	public static String regulatoryapprover=null;

	// CONSTRUCTOR
	public ApproverStepDefinitions(SharedState sharedState) 
	{
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		createNewFormulaUtils = new CreateNewFormulaUtils(driver, elementProperties);
		pdRequestApprovalsUtils= new PDRequestApprovalsUtils(driver, elementProperties);
	}

	// STEP DEFINITIONS
	@When("^The User selects \"([^\"]*)\" under search criteria dropdown$")
	public void userSelectsUnderSearchCriteriaDropdown(String option) throws Throwable 
	{
		applicationUtils.selectbyValue(elementProperties.getProperty("SearchCategory_CAM"), option);
		Thread.sleep(3000);
	}

	@When("^The User enters the FML ID to be approved in the Global search bar and click on Search icon$")
	public void userEntersTheFMLIDToBeApprovedInTheGlobalSearchBarAndClickOnSearchIcon() throws Throwable 
	{
		if(PDCompositionPageStepDefinitions.FMLID!=null)
		{
			fmlid=PDCompositionPageStepDefinitions.FMLID;
		}
		else
		{
			fmlid=CreateNewFormulaStepDefinations.FORMULAID;
		}
		pdRequestApprovalsUtils.searchforFMLIDCommonApprovals(fmlid);
	}

	@When("^The User selects the FML ID available link in \"([^\"]*)\" module$")
	public void userSelectsTheFMLIDAvailableLinkInModule(String window) throws Throwable 
	{
		if(window.equalsIgnoreCase("Common Approvals"))
		{
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
			Assert.assertTrue("Searched Result", applicationUtils.getText(elementProperties.getProperty("SearchedResult_RawIDLink")).trim().equals(fmlid));
			applicationUtils.moveToElementClick(elementProperties.getProperty("SearchedResult_RawIDLink"));
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
			ReportScreenshots.getScreenshot(sharedState);
		}
	}

	@When("^The User clicks on \"([^\"]*)\" button on the \"([^\"]*)\" page$")
	public void userClicksOnButtonOnThePage(String button, String page)	throws Throwable 
	{
		if(page.equalsIgnoreCase("GXP Approval Module"))
		{
			switch(button)
			{
			case "Approve":
			case "Complete":
			case "Request Revision":
			case "Resolve Revision":
				applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("ButtonContainsText"),button));
				applicationUtils.waitForLoadingImageDisappear();
				break;
			default:
				throw new NotSupportedException(button+" is not available");
			}
		}

		// WHY ELSE CASE IS NOT IMPLEMENTED
	}

	@Then("^The User verifies the e-Signature window is displayed$")
	public void userVerifiesTheESignatureWindowIsDisplayed() throws Throwable {
		Assert.assertTrue("E-Signature window is not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("ButtonContainsText"),"I Agree")));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enter the Username and Password on the e-Signature window$")
	public void the_User_enter_the_Username_and_Password_on_the_e_Signature_window() throws Throwable {
		applicationUtils.enterText(elementProperties.getProperty("Esign_UsernameTextField"),LoginLogoutUtils.userName);
		applicationUtils.enterText(elementProperties.getProperty("Esign_PasswordTextField"),LoginLogoutUtils.password);
	}

	@When("^The User clicks on \"([^\"]*)\" button on the e-Signature window$")
	public void userClicksOnButtonOnTheESignatureWindow(String button) throws Throwable {
		applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("ButtonContainsText"),button));
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(2000);
	}

	@When("^The User enters the FML ID for \"([^\"]*)\" Formula Type in the Global search bar and click on Search icon$")
	public void userEntersTheFMLIDForFormulaTypeInTheGlobalSearchBarAndClickOnSearchIcon(String type) throws Throwable 
	{
		pdRequestApprovalsUtils.searchforexistingFMLIDInCommonApprovals(type);
	}
	
	@When("^The User click on the available FML ID link in \"([^\"]*)\" module$")
	public void userclickOnTheFMLIDAvailableLinkInModule(String window) throws Throwable 
	{
		if(window.equalsIgnoreCase("Common Approvals"))
		{
			applicationUtils.waitforajaxQueryToProcess();
			applicationUtils.clickOnElement(elementProperties.getProperty("FMLidlink"));
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
			ReportScreenshots.getScreenshot(sharedState);
		}
	}
	
	@Then("^The User verifies data cannot be modified in the \"([^\"]*)\" tab on the GXP Approval Module page$")
	public void theUserVerifyDatCannotBeModified(String tabname)
	{
		Assert.assertTrue(tabname+"can be editable",pdRequestApprovalsUtils.verifyDatacannotbeModified(tabname));
		ReportScreenshots.getScreenshot(sharedState);
	}
	
	@Then("^The User verifies data cannot be Deleted in the \"([^\"]*)\" tab on the GXP Approval Module page$")
	public void theUserDataCannotBeDeleted(String tabname)
	{
		Assert.assertTrue(tabname+"can be Deleted",pdRequestApprovalsUtils.verifyDatacannotbeDeleted(tabname));
		ReportScreenshots.getScreenshot(sharedState);
	}
	
	@When("^The User click on \"([^\"]*)\" tab on the GXP Approval Module page$")
	public void theUserClickOnTabInGXPApprovalPage(String tabname)
	{
		pdRequestApprovalsUtils.clickonTabInGXPApproval(tabname);
		ReportScreenshots.getScreenshot(sharedState);
	}
	
	
	@Then("^The User verifies \"([^\"]*)\" is displayed on the GXP Approval Module page$")
	public void theUserVerifyWindowIsDisplayed(String windowname)
	{
		Assert.assertTrue(windowname +" window not dispalyed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("ButtonContainsText"),windowname)));
		ReportScreenshots.getScreenshot(sharedState);
	}
	
	@When("^The User enters value on \"([^\"]*)\" window$")
	public void theUserEnterValueOnWindow(String revisionname)
	{
		pdRequestApprovalsUtils.entervalueOnRevisionWindow(revisionname);
		ReportScreenshots.getScreenshot(sharedState);
	}
}