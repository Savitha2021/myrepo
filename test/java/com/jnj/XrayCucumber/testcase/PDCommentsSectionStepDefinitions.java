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
import applicationUtils.PDCommentsUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PDCommentsSectionStepDefinitions extends TestRunner {

	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	public static String Formula_ID = null;
	HomeUtils homeUtils;
	ApplicationUtils applicationUtils;
	PDCommentsUtils pDCommentsUtils;

	// CONSTRUCTOR
	public PDCommentsSectionStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		pDCommentsUtils = new PDCommentsUtils(driver,elementProperties);
	}

	// STEP DEFINITIONS
	@When("^The User navigates to Technical Comments tab$")
	public void the_user_navigates_to_technical_comments_tab() throws Throwable {
		pDCommentsUtils.navigateToTechnicalCommentsTab();
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies that the entered Technical Comment is submitted for the formula$")
	public void the_user_verifies_that_the_entered_technical_comment_is_submitted_for_the_formula() throws Throwable {
		Assert.assertTrue("Technical Comment is not submitted for the formula",pDCommentsUtils.verifySubmittedTechnicalComments());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters \"([^\"]*)\" in Technical Comments text box$")
	public void the_User_enters_in_Technical_Comments_text_box(String technicalComments) throws Throwable {
		pDCommentsUtils.enterTechnicalComments(technicalComments);
	}

	@Then("^The User verifies the Technical Comments tab has the same values as the source formula$")
	public void the_user_verifies_the_technical_comments_tab_has_the_same_values_as_the_source_formula() throws Throwable {
		Assert.assertTrue("Technical Comments tab does not have the same values as the source formula",pDCommentsUtils.verifySubmittedTechnicalComments());
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User clicks on Submit button$")
	public void the_user_clicks_on_submit_button() throws Throwable {
		pDCommentsUtils.submitTechnicalComments();
	}
}