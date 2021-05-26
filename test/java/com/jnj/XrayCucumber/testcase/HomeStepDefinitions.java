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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeStepDefinitions extends TestRunner {

	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	public static String Formula_ID = null;
	HomeUtils homeUtils;
	ApplicationUtils applicationUtils;
	public String RawMaterilID = RMPreRequisiteStepDefinitions.RMID;

	// CONSTRUCTOR
	public HomeStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		homeUtils = new HomeUtils(driver, elementProperties);
		applicationUtils = new ApplicationUtils(driver);
	}

	// STEP DEFINITIONS
	@Then("^The User is on \"([^\"]*)\" Home page$")
	public void userIsOnTheModuleHomePage(String page) throws Throwable {
		applicationUtils.waitForLoadingImageDisappear();
		Assert.assertTrue("Home screen is not displayed", homeUtils.verifyHomePageNavigation(page));
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User selects \"([^\"]*)\" option from the \"([^\"]*)\" menu on the Home page$")
	public void userSelectsTheOptionFromTheMenuOnTheHomePage(String tyOfFML, String buttonName) throws Throwable {
		homeUtils.userSelectsOptionFromMenuHomePage(buttonName, tyOfFML);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User clicks on \"([^\"]*)\" button$")
	public void userclicksonButton(String buttonName) throws Throwable {
		homeUtils.userClicksOnButton(buttonName);
	}

	@Then("^The User verifies the success popup \"([^\"]*)\"$")
	public void userVerifiesTheSuccessPopup(String name) throws Throwable {
		boolean flag=homeUtils.verifyTheSucessPopup(name);
		Assert.assertTrue("popup is not dispalyed",flag); 
		ReportScreenshots.getScreenshot(sharedState);
	}

	@When("^The User enters the FML ID in the Global search bar and click on Search icon$")
	public void user_enters_the_FML_ID_in_the_Global_search_bar_and_click_on_Search_icon() throws Throwable {
		Thread.sleep(5000);
		if (PDCompositionPageStepDefinitions.FMLID != null) {
			applicationUtils.enterText(elementProperties.getProperty("GlobbalsearchTextbox"),
					PDCompositionPageStepDefinitions.FMLID.trim());
		} else {

			applicationUtils.enterText(elementProperties.getProperty("GlobbalsearchTextbox"),
					CreateNewFormulaStepDefinations.FORMULAID.trim());
		}
		applicationUtils.moveToElementClick(elementProperties.getProperty("GlobalSearchButton"));
	}
	
	@Then("^The User selects the FML ID available link$")
	public void userSelectsTheFMLIDAvailableLink() throws Throwable {
		if (PDCompositionPageStepDefinitions.FMLID != null) {
			applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("LinkText"),
					PDCompositionPageStepDefinitions.FMLID.trim()));
		} else {
			applicationUtils.moveToElementClick(String.format(elementProperties.getProperty("LinkText"),
					CreateNewFormulaStepDefinations.FORMULAID.trim()));
		}
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(3000);
		ReportScreenshots.getScreenshot(sharedState);
	}
	
}