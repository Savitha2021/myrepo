package com.jnj.XrayCucumber.testcase;

import java.util.Properties;

import javax.ws.rs.NotSupportedException;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import applicationUtils.ApplicationUtils;
import applicationUtils.LoginLogoutUtils;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageStepDefinitions extends TestRunner{

	// CONSTANTS
	static final String LABENV="Lab";
	static final String DEVENV="ITDEV";
	static final String QAENV="QA";
	static final String RAWMATERIALSMODULEAPPLICATION="RAW Materials Module";
	static final String PRODUCTDEVELOPMENTAPPLICATION="Product Development";
	static final String COMMONAPPROVALMODULEAPPLICATION="Common Approval Module";

	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	LoginLogoutUtils loginLogoutUtils;
	ApplicationUtils applicationUtils;
/*	public static String _userName = "";
	public static String _password = "";
	public static String _userFullName = "";
	public static String _userRole = "";*/

	// CONSTRUCTOR
	public LoginPageStepDefinitions(SharedState sharedState,Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		loginLogoutUtils = new LoginLogoutUtils(driver, elementProperties);
		applicationUtils= new ApplicationUtils(driver);
	}

	// STEP DEFINITIONS
	@Given("^The User is logged into \"([^\"]*)\" application with \"([^\"]*)\" role$")
	public void theUserIsLoggedIntoApplicationWithRole(String module,String Userrole) throws Throwable {
		switch(module)
		{
		case RAWMATERIALSMODULEAPPLICATION:
			switch(elementProperties.getProperty("Envirnoment"))
			{
			case LABENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("LabApplicationUrl"));
				break;
			case DEVENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("ITDevApplicationUrl"));
				break;
			case QAENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("QAApplicationUrl"));
				break;
			default: 
				throw new NotSupportedException(elementProperties.getProperty("Envirnoment") + " envirnoment is not available for "+module);
			}

			boolean rmuserrole_flag= loginLogoutUtils.LoginToApplication(Userrole);
			Assert.assertTrue("Unsuccessful Login to RAW Materials Module", rmuserrole_flag);
			ReportScreenshots.getScreenshot(sharedState);
			break;
		case PRODUCTDEVELOPMENTAPPLICATION:
			switch(elementProperties.getProperty("Envirnoment"))
			{
			case LABENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("LabPDApplicationUrl"));
				break;
			case DEVENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("ITDevPDApplicationUrl"));
				break;
			case QAENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("QAPDApplicationUrl"));
				break;
			default: 
				throw new NotSupportedException(elementProperties.getProperty("Envirnoment") + " envirnoment is not available for "+module);
			}

			boolean pduserrole_flag= loginLogoutUtils.LoginToApplication(Userrole);
			Assert.assertTrue("Unsuccessful Login to Product Development", pduserrole_flag);
			break;
		case COMMONAPPROVALMODULEAPPLICATION:
			switch(elementProperties.getProperty("Envirnoment"))
			{
			case LABENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("LabCommonApproverApplicationUrl"));
				break;
			case DEVENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("ITDevCommonApproverApplicationUrl"));
				break;
			case QAENV:
				loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("QACommonApproverApplicationUrl"));
				break;
			default: 
				throw new NotSupportedException(elementProperties.getProperty("Envirnoment") + " envirnoment is not available for "+module);
			}

			boolean commomapprovaluserrole_flag= loginLogoutUtils.LoginToApplication(Userrole);
			Assert.assertTrue("Unsuccessful Login to Common Approval Module", commomapprovaluserrole_flag);
			break;
		default:
			throw new NotSupportedException(module + " is not available");			
		}
	}

	@Then("^The User logout from the \"([^\"]*)\" application$")
	public void theUserLogoutFromTheApplication(String module) throws Throwable 
	{
		switch(module)
		{
		case RAWMATERIALSMODULEAPPLICATION:
		case PRODUCTDEVELOPMENTAPPLICATION:
		case COMMONAPPROVALMODULEAPPLICATION:
			boolean logoutbutton_flag=loginLogoutUtils.LogoutFromApplication(module);
			Assert.assertTrue("Unsuccessful Log out", logoutbutton_flag);
			ReportScreenshots.getScreenshot(sharedState);
			break;
		default: 
			throw new NotSupportedException(module + " is not available");
		}
	}
}