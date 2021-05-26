package com.jnj.XrayCucumber.testcase;

import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import applicationUtils.ApplicationUtils;
import applicationUtils.HomeUtils;
import applicationUtils.PDCommentsUtils;
import cucumber.api.java.en.When;

public class PDHeaderIconsStepDefinitions extends TestRunner {

	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	static WebDriverWait wait;
	public static String Formula_ID = null;
	HomeUtils homeUtils;
	ApplicationUtils applicationUtils;
	public String RawMaterilID = RMPreRequisiteStepDefinitions.RMID;
	PDCommentsUtils pDCommentsUtils;

	// CONSTRUCTOR
	public PDHeaderIconsStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		pDCommentsUtils = new PDCommentsUtils(driver,elementProperties);
	}

	// STEP DEFINITIONS
	@When("^The User clicks on \"([^\"]*)\" header icon$")
	public void the_User_clicks_on_header_icon(String headerIcon) throws Throwable {
		pDCommentsUtils.clickOnHeaderIcon(headerIcon);
	}
}