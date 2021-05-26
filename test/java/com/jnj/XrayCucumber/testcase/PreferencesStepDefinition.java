
package com.jnj.XrayCucumber.testcase;

import java.util.Properties;
import java.awt.Color;
import java.util.*;
import javax.ws.rs.NotSupportedException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import applicationUtils.ApplicationUtils;
import applicationUtils.CAPRIHomepageUtils;
import applicationUtils.CAPRILoginUtils;
import applicationUtils.CAPRIPreferencesUtils;
//import applicationUtils.LoginLogoutUtils;
import applicationUtils.LoginLogoutUtils;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PreferencesStepDefinition extends TestRunner {
	// CONSTANTS

	static final String CAPRIDEV = "CAPRIDev";
	static final String CAPRIQA = "CAPRIQa";
	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	CAPRILoginUtils CAPRIloginUtils;
	ApplicationUtils applicationUtils;
	LoginLogoutUtils loginLogoutUtils;
	CAPRIHomepageUtils CAPRIHomepageUtils;
	CAPRIPreferencesUtils capriPreferencesUtils;
	public static String _userName = "";
	public static String _password = "";
	public static String _userFullName = "";
	public static String _userRole = "";

	// CONSTRUCTOR
	public PreferencesStepDefinition(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		CAPRIloginUtils = new CAPRILoginUtils(driver, elementProperties);
		applicationUtils = new ApplicationUtils(driver);
		loginLogoutUtils = new LoginLogoutUtils(driver, elementProperties);
		capriPreferencesUtils = new CAPRIPreferencesUtils(driver, elementProperties);
		// loginLogoutUtils = new LoginLogoutUtils(driver, elementProperties);
		// applicationUtils = new ApplicationUtils(driver);
		// CAPRIHomepageUtils = new CAPRIHomepageUtils(driver, elementProperties,
		// sharedState);
	}

	@Given("^The \"([^\"]*)\" is logged into CAPRI system$")
	public void the_is_logged_into_CAPRI_application(String Coordinator) throws Throwable {

	
		
		loginLogoutUtils.EnterApplicationUrl(elementProperties.getProperty("ITDevCAPRIApplicationUrl"));
		Assert.assertTrue("User is not logged in successfully", loginLogoutUtils.LoginToApplication("Coordinator1"));
		// System.out.println(elementProperties.getProperty("Coordinator1"));

	}

	@When("^User navigates to preferences page$")
	public void user_navigates_to_preferences_page() throws Throwable {
		capriPreferencesUtils._user_navigates_to_preferences_page();
	}

	@Then("^The following filters are displayed$")
	public void the_following_filters_are_displayed(DataTable filters) throws Throwable {
		List<String> _filters = filters.asList(String.class);
		boolean flag = false;
		for (int i = 0; i < _filters.size(); i++) {

			if (applicationUtils
					.isElementPresent(String.format(elementProperties.getProperty("Filters"), _filters.get(i)))) {

				flag = true;
				// System.out.println("filter value present");

			} else {
				flag = false;
			}

		}
		ReportScreenshots.getScreenshot(sharedState);

	}

	@When("^User selects one Brand value, two or more categories and statuses In progress and Approved$")
	public void user_selects_one_Brand_value_two_or_more_categories_and_statuses_In_progress_and_Approved()
			throws Throwable {
		capriPreferencesUtils
				._user_selects_one_Brand_value_two_or_more_categories_and_statuses_In_progress_and_Approved();
		applicationUtils.waitForLoadingImageDisappear();
		ReportScreenshots.getScreenshot(sharedState);

	}

	@When("^clicks Apply Filter button and then clicks Save button$")
	public void clicks_Apply_Filter_button_and_ten_clicks_Save_button() throws Throwable {
		applicationUtils.clickOnElement(elementProperties.getProperty("PrefApplyFiltersButton"));
		applicationUtils.scrollPagetoHome();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(elementProperties.getProperty("PrefSaveButton"))));

		applicationUtils.clickOnElement((elementProperties.getProperty("PrefSaveButton")));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.scrollToElement(elementProperties.getProperty("ClearFiltersButton"));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The selected filters are displayed with x icon$")
	public void the_selected_filters_are_displayed_with_x_icon() throws Throwable {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(elementProperties.getProperty("PreferencesLabel"))));

		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Actidue")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Approved")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"In Progress")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Allergy")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Baby")));
		ReportScreenshots.getScreenshot(sharedState);
	
	}

	@Then("^The Tile and List mode are displayed$")
	public void the_Tile_and_List_mode_are_displayed() throws Throwable {
		Assert.assertTrue("Tile not displayed",
				applicationUtils.isElementDisplayed(elementProperties.getProperty("TileMode")));
		Assert.assertTrue("List not displayed",
				applicationUtils.isElementDisplayed(elementProperties.getProperty("ListMode")));

	}

	@Then("^My APRs, My Favorites and All APRs views are displayed$")
	public void my_APRs_My_Favorites_and_All_APRs_views_are_displayed() throws Throwable {
		Assert.assertTrue("MyAPRs not displayed",
				applicationUtils.isElementDisplayed(elementProperties.getProperty("MyAPRs")));
		Assert.assertTrue("MyFavorites not displayed",
				applicationUtils.isElementDisplayed(elementProperties.getProperty("MyFavorites")));
		Assert.assertTrue("AllAPRs not displayed",
				applicationUtils.isElementDisplayed(elementProperties.getProperty("AllAPRs")));

	}

	@When("^User selects \"([^\"]*)\" Mode and \"([^\"]*)\" view and Save$")
	public void user_selects_Mode_and_view_and_Save(String mode, String view) throws Throwable {
		Thread.sleep(3000);
		applicationUtils.scrollToElement(elementProperties.getProperty("PrefApplyFiltersButton"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementProperties.getProperty(mode))));
		
		Thread.sleep(4000);
		applicationUtils.clickOnElement((elementProperties.getProperty(mode)));
		Thread.sleep(3000);
		System.out.println(elementProperties.getProperty(view));
		applicationUtils.clickonElementusingJSE((elementProperties.getProperty(view)));
		applicationUtils.scrollPagetoHome();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(elementProperties.getProperty("PrefSaveButton"))));

		applicationUtils.clickOnElement((elementProperties.getProperty("PrefSaveButton")));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.scrollToElement(elementProperties.getProperty("ClearFiltersButton"));
		
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^User Navigates to Home page$")
	public void user_Navigates_to_Home_page() throws Throwable {
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.clickOnElement((elementProperties.getProperty("HomeIcon")));

	}

	@Then("^The \"([^\"]*)\" mode and \"([^\"]*)\" view and selected filters are displayed$")
	public void The_mode_view_and_selected_filters_are_displayed(String mode, String view) throws Throwable {
		
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Actidue")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Approved")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"In Progress")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Allergy")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Baby")));
	
	
		Assert.assertTrue("Required Mode not selected",
				applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("HighlightedTab"), mode)));
		Assert.assertTrue("Required view not selected",
				applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("HighlightedTab"), view)));
		
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.scrollToElement(elementProperties.getProperty("ClearFiltersButton"));
		
		ReportScreenshots.getScreenshot(sharedState);
		
	}

	@Then("^The \"([^\"]*)\" mode and \"([^\"]*)\" view and remaining filters are displayed$")
	public void The_mode_view_and_remaining_filters_are_displayed(String mode, String view) throws Throwable {
	
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Actidue")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"In Progress")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Allergy")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Baby")));
	
		Assert.assertTrue("Required Mode not selected",
				applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("HighlightedTab"), mode)));
		Assert.assertTrue("Required view not selected",
				applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("HighlightedTab"), view)));
		Thread.sleep(2000);
		applicationUtils.scrollToElement(elementProperties.getProperty("ClearFiltersButton"));
		
		ReportScreenshots.getScreenshot(sharedState);
		
	}


	@Then("^User logs out of CAPRI system$")
	public void user_logs_out_of_CAPRI_system() throws Throwable {
		applicationUtils.scrollPagetoHome();
		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(elementProperties.getProperty("UsernameDropdown"))));
		// applicationUtils.scrollPagetoHome();
		// Thread.sleep(3000);
		applicationUtils.clickonElementusingJSE(elementProperties.getProperty("UsernameDropdown"));
		Thread.sleep(2000);

		applicationUtils.clickonElementusingJSE(String.format(elementProperties.getProperty("signout"), "Sign Out"));

		applicationUtils.waitForLoadingImageDisappear();
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^User clicks x icon for Approved status and clicks Apply filters button$")
	public void user_clicks_x_icon_for_Approved_status_and_clicks_Apply_filters_button() throws Throwable {
		applicationUtils.clickOnElement(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Approved"));
		applicationUtils.clickOnElement((elementProperties.getProperty("PrefApplyFiltersButton")));
		// applicationUtils.scrollPagetoHome();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementProperties.getProperty("PrefSaveButton"))));

		// applicationUtils.clickOnElement((elementProperties.getProperty("PrefSaveButton")));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.scrollToElement(elementProperties.getProperty("ClearFiltersButton"));
		
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^Approved status is removed from Filters section$")
	public void approved_status_is_removed_from_Filters_section() throws Throwable {
		// Assert.assertFalse("SelectedStatusFilterval1 not removed",
		// applicationUtils.isElementDisplayed(elementProperties.getProperty("SelectedStatusFilterval1")));
		Assert.assertFalse("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Approved")));
		Thread.sleep(2000);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^Tile mode, My APRs view and selected filters are displayed$")
	public void tile_mode_My_APRs_view_and_selected_filters_are_displayed() throws Throwable {
		
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Actidue")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Approved")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"In Progress")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Allergy")));
		Assert.assertTrue("Filter is not selected", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Baby")));
		applicationUtils.waitForLoadingImageDisappear();
		ReportScreenshots.getScreenshot(sharedState);
	
	}

	@When("^Click Clear Filters button and Save$")
	public void click_Clear_Filters_button_and_Save() throws Throwable {
		applicationUtils.scrollToElement(elementProperties.getProperty("ClearFiltersButton"));
		Thread.sleep(3000);
		applicationUtils.clickOnElement((elementProperties.getProperty("ClearFiltersButton")));
		Thread.sleep(2000);
		applicationUtils.scrollPagetoHome();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(elementProperties.getProperty("PrefSaveButton"))));

		applicationUtils.clickOnElement((elementProperties.getProperty("PrefSaveButton")));
		applicationUtils.waitForLoadingImageDisappear();
		
		
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^user verifies that all the applied filters are removed$")
	public void user_verifies_that_all_the_applied_filters_are_removed() throws Throwable {

		Assert.assertFalse("Filter is not removed", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Actidue")));
		Assert.assertFalse("Filter is not removed", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Approved")));
		Assert.assertFalse("Filter is not removed", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"In Progress")));
		Assert.assertFalse("Filter is not removed", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Allergy")));
		Assert.assertFalse("Filter is not removed", capriPreferencesUtils
				.assertElementPresent(String.format(elementProperties.getProperty("xMarkSelectedFilterval"),"Baby")));
		Thread.sleep(2000);
		
		ReportScreenshots.getScreenshot(sharedState);
	}
	
}