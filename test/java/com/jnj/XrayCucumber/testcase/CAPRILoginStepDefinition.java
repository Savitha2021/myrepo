package com.jnj.XrayCucumber.testcase;

import java.util.Properties;

import javax.ws.rs.NotSupportedException;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import applicationUtils.ApplicationUtils;
import applicationUtils.CAPRIHomepageUtils;
import applicationUtils.LoginLogoutUtils;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CAPRILoginStepDefinition extends TestRunner {

	// CONSTANTS

	static final String CAPRIDEV = "CAPRIDev";
	static final String CAPRIQA = "CAPRIQa";
	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	LoginLogoutUtils loginLogoutUtils;
	ApplicationUtils applicationUtils;
	CAPRIHomepageUtils CAPRIHomepageUtils;
	/*
	 * public static String _userName = ""; public static String _password = "";
	 * public static String _userFullName = ""; public static String _userRole = "";
	 */

	// CONSTRUCTOR
	public CAPRILoginStepDefinition(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		loginLogoutUtils = new LoginLogoutUtils(driver, elementProperties);
		applicationUtils = new ApplicationUtils(driver);
		CAPRIHomepageUtils= new CAPRIHomepageUtils(driver, elementProperties, sharedState);
	}

	

	@Then("^The Capri Homepage is displayed with My APRs \\(selected by default\\), My Favorites and All APRs views$")
	public void the_Capri_Homepage_is_displayed_with_My_APRs_selected_by_default_My_Favorites_and_All_APRs_views() throws Throwable {
	    
		CAPRIHomepageUtils.VerifyView();
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^Tile \\(Selected by default\\) and List modes are displayed$")
	public void tile_Selected_by_default_and_List_modes_are_displayed() throws Throwable {
		
		CAPRIHomepageUtils.VerifyMode();
		ReportScreenshots.getScreenshot(sharedState);
	
	}

	@When("^The User searches \"([^\"]*)\" APR$")
	public void the_User_searches_APR(String APRID) throws Throwable {
	    
		CAPRIHomepageUtils.searchAPR(elementProperties.getProperty(APRID));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^searched APR is displayed on the home page$")
	public void searched_APR_is_displayed_on_the_home_page() throws Throwable {
	    
	}
	/*@When("^The User searches \"([^\"]*)\" APR$")
	public void the_User_searches_prerequisite4_APR() throws Throwable {
		
		CAPRIHomepageUtils.searchAPR(elementProperties.getProperty("Prerequisite3"));
		ReportScreenshots.getScreenshot(sharedState);
	}
	*/

	@Then("^searched APR is not displayed on the home page$")
	public void searched_APR_is_not_displayed_on_the_home_page() throws Throwable {
	    
	}
}