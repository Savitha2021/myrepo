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
import applicationUtils.PDRequestApprovalsUtils;
import applicationUtils.RMPrerequisiteUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDRequestApprovalsPageStepDefinitions extends TestRunner {

	// VARIABLES
	public RemoteWebDriver driver;
	private SharedState sharedState;
	private Properties properties;
	static WebDriverWait wait;
	ApplicationUtils applicationUtils;
	PDRequestApprovalsUtils pdrequestapprovalsUtils;
	HomeUtils homeUtils;
	public static String approvaltype=null;
	public static String tab = "Request Approvals";
	public static String datarequiredsubsection="Data Required";
	public String save="Save";
	public String okbutton="OK";
	public String rmcstatus= "Exception Required";

	// CONSTRUCTOR
	public PDRequestApprovalsPageStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		this.properties = properties;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		homeUtils= new HomeUtils(driver, elementProperties);		
		pdrequestapprovalsUtils = new PDRequestApprovalsUtils(driver, elementProperties);
	}

	// STEP DEFINITIONS
	@When("^User enters value \"([^\"]*)\" for \"([^\"]*)\" field on Request Approvals tab$")
	public void user_enters_value_for_field_on_RequestApprovals_tab(String value, String field) throws Throwable {
		applicationUtils.waitForLoadingImageDisappear();
		switch (field) {
		case "PF Spec No.*":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(String.format(elementProperties.getProperty("SpanWithInput"), "PF Spec No.*"),
					value);
			break;
		case "PR Spec No.*":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(String.format(elementProperties.getProperty("SpanWithInput"), "PR Spec No.*"),
					value);
			break;
		case "Product Name (Proposed)*":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(
					String.format(elementProperties.getProperty("SpanWithInput"), "Product Name (Proposed)*"), value);
			break;
		case "pH*":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(String.format(elementProperties.getProperty("SpanWithInput"), "pH*"), value);
			break;
		case "Specific Gravity*":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(
					String.format(elementProperties.getProperty("SpanWithInput"), "Specific Gravity*"), value);
			break;
		case "Appearance*":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(String.format(elementProperties.getProperty("SpanWithInput"), "Appearance*"),
					value);
			break;
		case "HUT Description*":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(
					String.format(elementProperties.getProperty("SpanWithInput"), "HUT Description*"), value);
			break;
		case "Additional Information":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(
					String.format(elementProperties.getProperty("SpanContainsTextWithInput"), "Additional Information"),
					value);
			break;
		case "Comment/Rationale":
			if (value.equals("Random Name") | value.equals("Test")) {
				value = "LNB" + applicationUtils.getRandomName();
			}
			applicationUtils.enterText(
					String.format(elementProperties.getProperty("SpanContainsTextWithInput"), "Comment/Rationale"),
					value);
			break;
		default:
			Assert.fail("Invalid field name provided");
			break;
		}
	}

	@When("^User selects value \"([^\"]*)\" for \"([^\"]*)\" field on Request Approvals tab$")
	public void user_selects_value_for_field_on_RequestApprovals_tab(String value, String field) throws Throwable {
		applicationUtils.waitForLoadingImageDisappear();
		switch (field) {
		case "Unsupervised HUT for Claim Support (excluding patch tests)?*":
			if (value.equals("Yes")) {
				applicationUtils.enterText(
						String.format(elementProperties.getProperty("SpanWithInput"), "PF Spec No.*"), value);
				break;
			}
		}
	}

	@Then("^The User verifies the Formula Status on the left pane is displayed on the \"([^\"]*)\" tab$")
	public void the_User_verifies_the_Formula_Status_on_the_left_pane_is_displayed_on_the_tab(String tab) throws Throwable 
	{
		boolean formulastatus=pdrequestapprovalsUtils.formulastatudataverification(tab);
		Assert.assertTrue("Formula Status not displayed", formulastatus);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the mandatory subsections is displayed in the \"([^\"]*)\" tab$")
	public void the_User_verifies_the_mandatory_subsections_is_displayed_in_the_tab(String tab) throws Throwable 
	{
		boolean subsections=pdrequestapprovalsUtils.subsectionverification(tab);
		Assert.assertTrue("Subsections not displayed", subsections);
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("DeliverySystemDropDown"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("HUTSubsectionLabel"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("HUTRegionDropDownScreenshot"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("RequiredApproversSubsectionLabel"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("CommentRationaleTextBoxScreenshot"));
	}

	@Then("^The User verifies the Formula is in \"([^\"]*)\" status$")
	public void the_User_verifies_the_Formula_is_in_status(String status) throws Throwable {
		Assert.assertTrue("Status on header not dsiplayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("FormulaStatusHeader"),status)));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" option for \"([^\"]*)\" field on Request Approvals tab$")
	public void the_User_selects_option_for_field_on_Request_Approvals_tab(String approvalType, String field) throws Throwable {
		approvaltype=approvalType;
		applicationUtils.idleTime(2000);
		applicationUtils.selectbyVisibletext(String.format(elementProperties.getProperty("ApprovalRequestType"), field), approvalType);
		applicationUtils.waitForLoadingImageDisappear();
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies all the mandatory fields on the \"([^\"]*)\" tab$")
	public void the_User_verifies_all_the_mandatory_fields_on_the_tab(String tabname) throws Throwable {
		if(tabname.equals(tab))
		{
			Assert.assertTrue("Data not present",pdrequestapprovalsUtils.verifyHUTmandatoryfields(tabname)&&
					pdrequestapprovalsUtils.verifyHUTDataRequiredfields(tabname)&&
					pdrequestapprovalsUtils.verifyHUTInputfields(tabname));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("DeliverySystemDropDown"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("HUTSubsectionLabel"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("HUTRegionDropDownScreenshot"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("RequiredApproversSubsectionLabel"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("CommentRationaleTextBoxScreenshot"));
		}
	}

	@Then("^The User verifies all the non mandatory fields on the \"([^\"]*)\" tab$")
	public void the_User_verifies_all_the_non_mandatory_fields_on_the_tab(String tabname) throws Throwable {
		if(tabname.equals(tab))
		{
			Assert.assertTrue("Data not present",pdrequestapprovalsUtils.verifyHUTInputNonmandatoryfields(tabname)&&
					applicationUtils.isElementPresent(elementProperties.getProperty("ShowCompletedFieldsCheckbox"))&&
					applicationUtils.isElementPresent(elementProperties.getProperty("CommentRationaleTextBoxScreenshot")));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("DeliverySystemDropDown"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("HUTSubsectionLabel"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("HUTRegionDropDownScreenshot"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("RequiredApproversSubsectionLabel"));
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.scrollToElement(elementProperties.getProperty("CommentRationaleTextBoxScreenshot"));
		}
	}

	@Then("^The User verifies the \"([^\"]*)\" validation message is displayed on Request Approvals tab$")
	public void the_User_verifies_the_validation_message_is_displayed_on_Request_Approvals_tab(String message) throws Throwable {
		applicationUtils.scrollToElement(elementProperties.getProperty("HUTSubsectionLabel"));
		Assert.assertTrue("Message not displayed", applicationUtils.isElementPresent(String.format(elementProperties.getProperty("ValidationMessage"), message)));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" radio button for \"([^\"]*)\" field under \"([^\"]*)\" subsection on Request Approvals tab$")
	public void the_User_selects_radio_button_for_field_under_subsection_on_Request_Approvals_tab(String radiobutton, String fieldname, String subsection) throws Throwable {
		PDRequestApprovalsUtils.radioButton=radiobutton;
		PDRequestApprovalsUtils.hUTapprover=fieldname;
		switch(fieldname)
		{
		case "Unsupervised HUT for Claim Support (excluding patch tests)?*":
			pdrequestapprovalsUtils.selectHUTUnsupervisedradiobutton(radiobutton, fieldname, subsection);
			break;
		case "Regulatory":
			applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("RegulatoryRadioButton"), radiobutton.toLowerCase()));
			break;
		case "Toxicology/Clinical Safety":
			applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("ToxicologyRadioButton"), radiobutton.toLowerCase()));
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}
	}

	@When("^The User enters all mandatory fields on \"([^\"]*)\" tab for \"([^\"]*)\" Approval Request Type$")
	public void the_User_enters_all_mandatory_fields_on_tab_for_Approval_Request_Type(String tabname, String approvaltype) throws Throwable {
		if(tabname.equals(tab))
		{
			if(RMPrerequisiteUtils.RMCStatus.equals(rmcstatus))
			{
				pdrequestapprovalsUtils.enterRMCExceptionReason(approvaltype);
			}
			pdrequestapprovalsUtils.clickbuttonRequestApprovalstab(save);
			homeUtils.userClicksOnButton(okbutton);
			pdrequestapprovalsUtils.enterdatarequiredsubsection(approvaltype);
			pdrequestapprovalsUtils.enterHUTsubsection();
			pdrequestapprovalsUtils.enterinputssubsection(approvaltype);
			pdrequestapprovalsUtils.selectHUTRequiredApprovers(approvaltype);
		}

		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("DeliverySystemDropDown"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("HUTSubsectionLabel"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("HUTRegionDropDownScreenshot"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("RequiredApproversSubsectionLabel"));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(elementProperties.getProperty("CommentRationaleTextBoxScreenshot"));
	}

	@When("^The User unchecks the \"([^\"]*)\" checkbox$")
	public void the_User_unchecks_the_checkbox(String checkbox) throws Throwable {
		applicationUtils.moveToElementClick(elementProperties.getProperty("NotApplicableCheckbox"));
	}

	@When("^The User leaves blank for \"([^\"]*)\" field under \"([^\"]*)\" subsection on Request Approvals tab$")
	public void the_User_leaves_blank_for_field_under_subsection_on_Request_Approvals_tab(String field, String subsection) throws Throwable {
		if(subsection.equals(datarequiredsubsection))
		{
			applicationUtils.enterText(String.format(elementProperties.getProperty("AssociatetoChassisTextBox"), field), "");
		}
	}

	@Then("^The User verifies the \"([^\"]*)\" message should be displayed$")
	public void the_User_verifies_the_message_should_be_displayed(String message) throws Throwable {
		Assert.assertTrue("Message not displayed", applicationUtils.getAttribute(elementProperties.getProperty("ValidationMessage"), "title").equals(message));
		ReportScreenshots.getScreenshot(sharedState);
	}


	@When("^The User checks the \"([^\"]*)\" checkbox$")
	public void theUserChecksTheCheckbox(String checkbox) throws Throwable {
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElement(elementProperties.getProperty("NotApplicableCheckbox"));
		applicationUtils.moveToElementClick(elementProperties.getProperty("NotApplicableCheckbox"));
	}

	@And("^The User enters value for \"([^\"]*)\" field under \"([^\"]*)\" subsection on Request Approvals tab$")
	public void theUserEntersValueForFieldUnderSubsectionOnRequestApprovalsTab(
			String fieldname, String subsection) throws Throwable {
		if(subsection.equals(datarequiredsubsection))
		{
			applicationUtils.enterText(String.format(elementProperties.getProperty("AssociatetoChassisTextBox"), fieldname),properties.getProperty("AssociatetoChassisValue"));
		}
	}

	@And("^The User clicks on \"([^\"]*)\" icon$")
	public void theUserClicksOnIcon(String icon) throws Throwable 
	{
		applicationUtils.moveToElementClick(elementProperties.getProperty("PopUpCloseIcon"));
		if(applicationUtils.getWebElements(elementProperties.getProperty("PopUpCloseIcon")).size()>0)
		{
			applicationUtils.clickonElementusingJSE(elementProperties.getProperty("PopUpCloseIcon"));
		}
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
	}

	@Then("^The User verifies the system navigates to \"([^\"]*)\" tab$")
	public void theUserVerifiesTheSystemNavigatesToTab(String tab)
			throws Throwable {
		Assert.assertTrue("Data is not displayed", applicationUtils.isElementDisplayed(elementProperties.getProperty("InProgressTab")));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the information displayed within the \"([^\"]*)\" tab$")
	public void theUserVerifiesTheInformationDisplayedWithinTheTab(String tab)
			throws Throwable {
		boolean inprogressdata= pdrequestapprovalsUtils.verifyInProgresstabRMCExceptiondata();
		Assert.assertTrue("Data is not displayed", inprogressdata);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User clicks on \"([^\"]*)\" tab$")
	public void userClicksOnTab(String tab) throws Throwable 
	{
		if(tab.equals("Request Approvals"))
		{
			applicationUtils.clickonElementusingJSE(String.format(elementProperties.getProperty("SpanText"),tab));
		}
		else
		{
			applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("SpanText"),tab));
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(3000);
		}
	}

	@Then("^The User verifies the information displayed in the \"([^\"]*)\" tab for \"([^\"]*)\" approval$")
	public void theUserVerifiesTheInformationDisplayedInTheTabForApproval(String tab, String approval) throws Throwable 
	{
		if(tab.equalsIgnoreCase("In Progress"))
		{
			switch(approval)
			{
			case "Toxicology/Clinical Safety Full/HUT":
			case "APAC Regulatory Preliminary/HUT":
			case "RMC Formula Exception":
			case "Toxicology/Clinical Safety Preliminary/HUT":
				boolean flaginprogress=pdrequestapprovalsUtils.verifyInProgresstabApproverExceptiondata(approval);
				Assert.assertTrue("Data Incorrect", flaginprogress);
				ReportScreenshots.getScreenshot(sharedState);
				break;
			default:
				System.out.println("Invalid window option");
				break;
			}
		}
		else if(tab.equalsIgnoreCase("Completed Reviews"))
		{
			switch(approval)
			{
			case "Toxicology/Clinical Safety Full/HUT":
			case "APAC Regulatory Preliminary/HUT":
			case "RMC Formula Exception":
			case "Toxicology/Clinical Safety Preliminary/HUT":
				boolean flagcomplete=pdrequestapprovalsUtils.verifyCompletedReviewtabApproverExceptiondata(approval);
				Assert.assertTrue("Data Incorrect", flagcomplete);
				ReportScreenshots.getScreenshot(sharedState);
				break;
			default:
				System.out.println("Invalid window option");
				break;
			}

		}
	}

	@Then("^The User is on the Request Approvals tab$")
	public void userIsOnTherequestApprovalstab() throws Throwable {
		applicationUtils.waitForLoadingImageDisappear();
		Assert.assertTrue("Request Approvals tab not displayed",
				pdrequestapprovalsUtils.verifyUserOnRequestApprovalTab());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User is on the In Progress tab$")
	public void userIsOnTheInProgresstab() throws Throwable {
		applicationUtils.waitForLoadingImageDisappear();
		Assert.assertTrue("In Progress tab not displayed", pdrequestapprovalsUtils.verifyUserOnInProgressTab());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User is on the Completed Reviews tab$")
	public void userIsOnTheCompletedReviewsstab() throws Throwable {
		applicationUtils.waitForLoadingImageDisappear();
		Assert.assertTrue("Completed Reviews tab not displayed",
				pdrequestapprovalsUtils.verifyUserOnCompletedReviewsTab());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" status on left pane on Request Approvals tab$")
	public void userVerifiesStatusonLeftpaneOnrequestApprovalsTab(String leftPaneStatus) throws Throwable {
		Assert.assertTrue("'" + leftPaneStatus + "' is not displayed",
				pdrequestapprovalsUtils.verifyStatusonLeftpane(leftPaneStatus));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies chevron is active for \"([^\"]*)\" status on left pane on Request Approvals tab$")
	public void userVerifieschevronstatusonLeftpaneOnrequestApprovalsTab(String leftPaneStatus) throws Throwable {
		Assert.assertTrue("Chevron  is not displayed on '" + leftPaneStatus + "'",
				pdrequestapprovalsUtils.verifyChevronStatusonLeftpane(leftPaneStatus));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" Request Type on Request Approvals tab$")
	public void userSelectsApprovalRequestTypeOnRequestApprovalsTab(String reqType) throws Throwable {
		pdrequestapprovalsUtils.selectValueforRequestTypefield(reqType);
	}

	@Then("^The User verifies \"([^\"]*)\" mandatory subsection on Request Approvals tab$")
	public void userVerifiesmandatorySubsectionOnRequestApprovalsTab(String sectionName) throws Throwable {
		//applicationUtils.scrollToElement(elementProperties.getProperty("HUTSubsectionLabel"));
		//applicationUtils.idleTime(3000);
		switch(sectionName)
		{
		case "Data Required":
		Assert.assertTrue("'" + sectionName + "' mandatory subsection  is not displayed",
				pdrequestapprovalsUtils.verifyMandatorySubsection(sectionName));
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.scrollToElement(String.format(elementProperties.getProperty("SpanContainsText"), "Inputs"));
		ReportScreenshots.getScreenshot(sharedState);
		break;
		
		case "Inputs":
			Assert.assertTrue("'" + sectionName + "' mandatory subsection  is not displayed",
					pdrequestapprovalsUtils.verifyMandatorySubsection(sectionName));
			applicationUtils.scrollToElement(elementProperties.getProperty("RequiredApproversSubsectionLabel"));
			ReportScreenshots.getScreenshot(sharedState);
			break;
		case "HUT":
			Assert.assertTrue("'" + sectionName + "' mandatory subsection  is not displayed",
					pdrequestapprovalsUtils.verifyMandatorySubsection(sectionName));
			ReportScreenshots.getScreenshot(sharedState);
			break;
			
		case "Required Approvers":
			Assert.assertTrue("'" + sectionName + "' mandatory subsection  is not displayed",
					pdrequestapprovalsUtils.verifyMandatorySubsection(sectionName));
			ReportScreenshots.getScreenshot(sharedState);
			break;
			
			default:
				System.out.println("Invalid Data");
		}
			
			
	}

	@Then("^The User verifies \"([^\"]*)\" link on Request Approvals tab$")
	public void userVerifiesLinkOnRequestApprovalsTab(String linkName) throws Throwable {
		Assert.assertTrue("'" + linkName + "' link  is not displayed",
				pdrequestapprovalsUtils.verifyLinkOnRequestApproval(linkName));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User clicks on \"([^\"]*)\" link on Request Approvals tab$")
	public void userClicksOnLinkOnRequestApprovalsTab(String linkName) throws Throwable {
		pdrequestapprovalsUtils.clickLinkOnRequestApproval(linkName);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User \"([^\"]*)\" HUT Option on Request Approval tab$")
	public void userHUTOptionOnRequestApprovalsTab(String action) throws Throwable {
		pdrequestapprovalsUtils.takeActionOnCheckBoxOnRequestApprovalstab("HUT", action);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" check box on Request Approvals tab$")
	public void userselectsCheckBoxOnRequestApprovalsTab(String chkBox) throws Throwable {
		pdrequestapprovalsUtils.takeActionOnCheckBoxOnRequestApprovalstab(chkBox, "selects");
		
	}

	@Then("^The User verifies unchecked HUT Option in Request Approval tab$")
	public void userVerifiesUncheckedHUTOptionOnRequestApprovalsTab() throws Throwable {
		Assert.assertTrue("verify HUT Status",
				pdrequestapprovalsUtils.verifyCheckBoxStatusOnRequestApprovalsTab("HUT", "Unchecked"));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies Show Completed Fields selected by default on Request Approvals tab$")
	public void userVerifiesShowCompletedFieldsSelectedOnRequestApprovalsTab() throws Throwable {
	
		Assert.assertTrue("Show Completed Fields is not selected",
				pdrequestapprovalsUtils.verifyCheckBoxStatusOnRequestApprovalsTab("Show Completed Fields", "Checked"));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" mandatory field on Data Required subsection on Request Approvals tab$")
	public void userVerifiesMandatoryfieldDataRequiredSubsectionOnRequestApprovalsTab(String field) throws Throwable {
		Assert.assertTrue("'" + field + "' mandatory field is not displayed",
				pdrequestapprovalsUtils.verifyFieldDataRequiredSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" non mandatory field on Data Required subsection on Request Approvals tab$")
	public void userVerifiesnonMandatoryfieldDataRequiredSubsectionOnRequestApprovalsTab(String field)
			throws Throwable {
		Assert.assertTrue("'" + field + "' mandatory field is not displayed",
				pdrequestapprovalsUtils.verifyFieldDataRequiredSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" mandatory field on Inputs subsection on Request Approvals tab$")
	public void userVerifiesMandatoryfieldInputsSubsectionOnRequestApprovalsTab(String field) throws Throwable {
		Assert.assertTrue("'" + field + "' mandatory field is not displayed",
				pdrequestapprovalsUtils.verifyFieldInputsSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" non mandatory field on Inputs subsection on Request Approvals tab$")
	public void userVerifiesnonMandatoryfieldInputsSubsectionOnRequestApprovalsTab(String field) throws Throwable {
		Assert.assertTrue("'" + field + "' non mandatory field is not displayed",
				pdrequestapprovalsUtils.verifyFieldInputsSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" mandatory field on Required Approvers subsection on Request Approvals tab$")
	public void userVerifiesMandatoryfieldRequiredApprovalsSubsectionOnRequestApprovalsTab(String field)
			throws Throwable {
		Assert.assertTrue("'" + field + "' mandatory field is not displayed",
				pdrequestapprovalsUtils.verifyFieldRequiredApprovalsSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" non mandatory field on Required Approvers subsection on Request Approvals tab$")
	public void userVerifiesnonMandatoryfieldRequiredApprovalsSubsectionOnRequestApprovalsTab(String field)
			throws Throwable {
		Assert.assertTrue("'" + field + "' non mandatory field is not displayed",
				pdrequestapprovalsUtils.verifyFieldRequiredApprovalsSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" mandatory field on HUT subsection on Request Approvals tab$")
	public void userVerifiesMandatoryfieldHUTSubsectionOnRequestApprovalsTab(String field) throws Throwable {
		Assert.assertTrue("'" + field + "' mandatory field is not displayed",
				pdrequestapprovalsUtils.verifyFieldHUTSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" for \"([^\"]*)\" field on Required Approvers subsection on Request Approvals tab$")
	public void userselectsforfieldonRequiredApprovalsSubsectionOnRequestApprovalsTab(String value, String field)
			throws Throwable {
		pdrequestapprovalsUtils.userSelectsValueforFieldOnRequestApprovalsTab(value, field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" mandatory field with \"([^\"]*)\" options on HUT subsection on Request Approvals tab$")
	public void userVerifiessmandatoryfieldWithOptionsOnHUTSubsectionOnRequestApprovalsTab(String field, String options)
			throws Throwable {
		Assert.assertTrue("Radio Button Options are not diaplyed",
				pdrequestapprovalsUtils.userVerifiesRadioButtonOptionforFieldOnRequestApprovalsTab(field, options));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" for \"([^\"]*)\" Approver field on HUT subsection on Request Approvals tab$")
	public void userselectsforApproverfieldonHUTSubsectionOnRequestApprovalsTab(String value, String field)
			throws Throwable {
		pdrequestapprovalsUtils.userSelectsOptionforRadioButtonOnRequestApprovalsTab(value, field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" for \"([^\"]*)\" mandatory field on HUT subsection on Request Approvals tab$")
	public void userselectsforMandatoryfieldonHUTSubsectionOnRequestApprovalsTab(String value, String field)
			throws Throwable {
		pdrequestapprovalsUtils.userSelectsOptionforRadioButtonOnRequestApprovalsTab(value, field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" option is selected for \"([^\"]*)\" Approver field on HUT subsection on Request Approvals tab$")
	public void userVerifiesOptionSelectedforApproverHUTSubsectionOnRequestApprovalsTab(String option, String field)
			throws Throwable {
		Assert.assertTrue("'" + option + "' Radio Button Option is not selected",
				pdrequestapprovalsUtils.userVerifiesSelectedRadioButtonOptionOnRequestApprovalsTab(field, option));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User clicks on \"([^\"]*)\" button on Request Approvals tab$")
	public void userClicksButtonOnRequestApprovalsTabs(String btnName) throws Throwable {
		pdrequestapprovalsUtils.userClicksoButtonOnRequestApprovalsTab(btnName);
	}

	@When("^The User enters values for all mandatory fields for \"([^\"]*)\" on Request Approvals tab$")
	public void userEntersValuesForMandatoryFieldsSubsectionOnRequestApprovalsTab(String reqType) throws Throwable {
		if(reqType.equals("Approval for Scale Up")) {
			pdrequestapprovalsUtils.enterValuesForMandatoryFieldsInScaleupWithoutHUT(reqType);
		}
		else {
			pdrequestapprovalsUtils.enterValuesForMandatoryFieldsOnRequestApprovalsTab(reqType);
		}
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters values for all mandatory fields for \"([^\"]*)\" with HUT on Request Approvals tab$")
	public void userEntersValuesForMandatoryFieldsWithHUTOnRequestApprovalsTab(String reqType) throws Throwable {
		pdrequestapprovalsUtils.enterValuesForMandatoryFieldsWithHUTOnRequestApprovalsTab(reqType);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters values for all mandatory fields for \"([^\"]*)\" on Data Required subsection on Request Approvals tab$")
	public void userEntersValuesForMandatoryFieldsforDataRequiredSubsectionOnRequestApprovalsTab(String reqType)
			throws Throwable {
		pdrequestapprovalsUtils.enterValuesMandatoryFieldsDataRequired(reqType);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User unselects \"([^\"]*)\" values of \"([^\"]*)\" mandatory field on Inputs subsection on Request Approvals tab$")
	public void userUnselectsValuesofMandatoryFieldsInputsSubsectionOnRequestApprovalsTab(String options, String field)
			throws Throwable {
		pdrequestapprovalsUtils.unselectsValueForMultiSelect(options, field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" message on popup$")
	public void userVerifiesMessageonPopup(String msg) throws Throwable {
		Assert.assertTrue("Message not displayed", applicationUtils.getAttribute(elementProperties.getProperty("ErrorMessageFirstText"), "title").equals(msg));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" not displayed on Data Required subsection on Request Approvals tab$")
	public void userVerifiesfieldnotDisplayedDataRequiredSubsectionOnRequestApprovals(String field) throws Throwable {
		Assert.assertTrue("Verify'" + field + "' is displayed on Data Required subsection",
				!pdrequestapprovalsUtils.verifyFieldDataRequiredSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies \"([^\"]*)\" not displayed on Required Approvers subsection on Request Approvals tab$")
	public void userVerifiesfieldnotDisplayedRequiredApproversSubsectionOnRequestApprovals(String field)
			throws Throwable {
		Assert.assertTrue("'" + field + "' is displayed",
				!pdrequestapprovalsUtils.verifyFieldRequiredApprovalsSectionOnRequestApprovalsTab(field));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verify the information for \"([^\"]*)\" Approver function in the In Progress tab$")
	public void the_user_verify_the_unformation_in_the_inProgress_tab(String approverFunction) throws InterruptedException {
		Thread.sleep(6000);
		Assert.assertTrue(approverFunction + " task not displayed",
				pdrequestapprovalsUtils.verifyinformationforAprroverFunctioninInProgress(approverFunction));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verify the information for \"([^\"]*)\" Approval in the Completed Reviews tab$")
	public void the_user_verify_the_information_in_the_CompletedReviews_tab(String approvalType) throws InterruptedException {
		Thread.sleep(6000);
		Assert.assertTrue(approvalType + " Approval type is not displayed",
				pdrequestapprovalsUtils.verifyinformationforAprroverFunctioninCompletedReviews(approvalType));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters values for all mandatory fields for \"([^\"]*)\" with Hut on Request Approvals tab$")
	public void userntersvaluesformandatoryfieldswithhut(String reqType) throws Throwable {
		pdrequestapprovalsUtils.entervalueforMandatoryFieldswithHut(reqType);
	}

	@When("^The User selects \"([^\"]*)\" for \"([^\"]*)\" field on Inputs subsection on Request Approvals tab$")
	public void userSelectsValueForFieldOnInputsSubsectionOnRequestApprovalsTab(String value,String field)
			throws Throwable {
		pdrequestapprovalsUtils.enterFieldsOnInputsSectionOnRequestApprovalsTab(field,value);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters value for \"([^\"]*)\" field on Inputs subsection on Request Approvals tab$")
	public void userEntersValueForFieldOnInputsSubsectionOnRequestApprovalsTab(String field)
			throws Throwable {
		pdrequestapprovalsUtils.enterFieldsOnInputsSectionOnRequestApprovalsTab(field,"Current Date" );
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters value for \"([^\"]*)\" field on HUT subsection on Request Approvals tab$")
	public void userEntersValueForFieldOnHUTSubsectionOnRequestApprovalsTab(String field)
			throws Throwable {
		if(field.equals("HUT Description*")) {
			pdrequestapprovalsUtils.enterValuesFieldsOnHUT(field,"Auto Testing" );}
		else {
			pdrequestapprovalsUtils.enterValuesFieldsOnHUT(field,"Cosmetic");}
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects value for \"([^\"]*)\" field on HUT subsection on Request Approvals tab$")
	public void userSelectsValueForFieldOnHUTSubsectionOnRequestApprovalsTab(String field)
			throws Throwable {
		pdrequestapprovalsUtils.enterValuesFieldsOnHUT(field,"Cosmetic" );
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" for \"([^\"]*)\" field on HUT subsection on Request Approvals tab$")
	public void userSelectsForFieldOnHUTSubsectionOnRequestApprovalsTab(String value,String field)
			throws Throwable {
		pdrequestapprovalsUtils.enterValuesFieldsOnHUT(field,value );
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" Approver on Request Approvals tab$")
	public void userSelectsApproverOnRequestApprovalsTab(String field)
			throws Throwable {
		pdrequestapprovalsUtils.userSelectsApproverOnRequestApprovalsTab(field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the popup \"([^\"]*)\" is displayed on Request Approvals tab$")
	public void theUserVerifiesThePopupIsDisplayedOnRequestApprovalsTab(
			String popup) throws Throwable {
		boolean dataflag= pdrequestapprovalsUtils.verifyRMCExeceptionadded();
		Assert.assertTrue("Data is not displayed", dataflag);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verify Comment/Rationale is \"([^\"]*)\" on Request Approval tab$")
	public void theUserVerifyCommentrationaleOnRequestapprovalTab(String value){
		Assert.assertTrue("Comment/rationale field not present",pdrequestapprovalsUtils.verifyCommentrationalefield(value));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" option for \"([^\"]*)\" Approver on the Request Approval tab$")
	public void theUserSelectoptionForApprover(String value,String field){
		pdrequestapprovalsUtils.SelectOptionForapproverOnApproverrequest(field, value);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User deselect the checkbox of the \"([^\"]*)\" Approver on the Request Approval tab$")
	public void theUserSelectoptionByUnckeckingApprover(String field) {
		pdrequestapprovalsUtils.deselectApproverOnApproverrequest(field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verify \"([^\"]*)\" Approver is selected on Request Approval tab$")
	public void theUserVerifyapproverisSelected(String field) {
		Assert.assertTrue(field+ " not selcted",pdrequestapprovalsUtils.verifyUnselectedapprover(field));
	}

	@When("^The User selects \"([^\"]*)\" Approver checkbox on Request Approval tab$")
	public void theUserSelectsApprover(String field) {
		pdrequestapprovalsUtils.selectApproverCheckBox(field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verify \"([^\"]*)\" in the Right Pane on the Request Approval tab$")
	public void theUserVerifyRightPane(String field) {
		pdrequestapprovalsUtils.verifySelectedapproverOnRightPane(field);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters value for \"([^\"]*)\" in the Request Approval tab$")
	public void theUserEntersValueInRequestapproval(String field) {
		pdrequestapprovalsUtils.entervalue(field);
	}

	@Then("^The User verify selected approvers are listed under Approvals Needed in the right pane of the \"([^\"]*)\" screen$")
	public void theUserVerifySelectedApproversAreListedUnderApprovalsNeededInTheRightPaneOfTheScreen(
			String tab) throws Throwable {
		Assert.assertTrue("Verify'" + tab + "' is not displayed",
				pdrequestapprovalsUtils.verifySelectedApproverOnRightPane(RMPrerequisiteUtils.RMCStatus,tab));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User clicks on \"([^\"]*)\" icon on HUT subsection on Request Approvals tab$")
	public void theUserClicksOnIconOnHUTSubsectionOnRequestApprovalsTab(
			String icon) throws Throwable {
		applicationUtils.moveToElementClick(elementProperties.getProperty("AddAdditionalHUTIcon"));
		applicationUtils.idleTime(2000);

	}

	@When("^The User enters all mandatory fields under \"([^\"]*)\" subsection on Request Approvals tab for \"([^\"]*)\" Approval Request Type$")
	public void theUserEntersAllMandatoryFieldsUnderSubsectionOnRequestApprovalsTabForApprovalRequestType(
			String subsection, String approvaltype) throws Throwable {
		pdrequestapprovalsUtils.entersubsectiondata(subsection,approvaltype);
	}

	@When("^The User deselect the checkbox of \"([^\"]*)\" Approver on Request Approvals tab$")
	public void theUserDeselectTheCheckboxOfApproverOnRequestApprovalsTab(
			String approver) throws Throwable {
		pdrequestapprovalsUtils.uncheckrequiredapprovers(approver);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@And("^The User selects \"([^\"]*)\" value for \"([^\"]*)\" Approver on Request Approvals tab$")
	public void theUserSelectsValueForApproverOnRequestApprovalsTab(
			String value, String requiredapprover) throws Throwable {
		pdrequestapprovalsUtils.selectuncehckedapprovers(value, requiredapprover);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User enters the \"([^\"]*)\" field under Required Approvers subsection on Request Approvals tab$")
	public void theUserEntersTheFieldUnderRequiredApproversSubsectionOnRequestApprovalsTab(
			String fieldname) throws Throwable {
		applicationUtils.enterText(String.format(elementProperties.getProperty("CommentRationaleTextBoxMand"), fieldname), elementProperties.getProperty("CommentRationaleMand"));
		Thread.sleep(2000);
		Assert.assertTrue(fieldname+" field empty", 
				!applicationUtils.getAttribute(String.format(elementProperties.getProperty("CommentRationaleTextBoxMand"), fieldname),"value").trim()
				.isEmpty());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the status circle displays \"([^\"]*)\"$")
	public void the_User_verifies_the_status_circle(String status) throws Throwable 
	{
		Assert.assertTrue("Status on header not dsiplayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("SpanText"),status)));
		ReportScreenshots.getScreenshot(sharedState);
	} 

	@When("^The User click on \"([^\"]*)\" link on In progress tab$")
	public void theUserClickLink(String linkname)
	{
		applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("SpanText"), linkname));
	}

	@Then("^The User verifies \"([^\"]*)\" message on the popup$")
	public void theUserVerifyThePopup(String message)
	{
		Assert.assertTrue(message+" not dispalyed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("SpanText"), message)));
		ReportScreenshots.getScreenshot(sharedState);
	}
}
