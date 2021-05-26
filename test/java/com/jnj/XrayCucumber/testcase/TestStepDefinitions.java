package com.jnj.XrayCucumber.testcase;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import applicationUtils.ApplicationUtils;
import applicationUtils.CAPRIHomepageUtils;
import applicationUtils.LoginLogoutUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class TestStepDefinitions extends TestRunner {

	static final String CAPRIDEV = "CAPRIDev";
	static final String CAPRIQA = "CAPRIQa";
	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	LoginLogoutUtils loginLogoutUtils;
	ApplicationUtils applicationUtils;
	CAPRIHomepageUtils CAPRIHomepageUtils;

	// CONSTRUCTOR
	public TestStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		loginLogoutUtils = new LoginLogoutUtils(driver, elementProperties);
		applicationUtils = new ApplicationUtils(driver);
		CAPRIHomepageUtils = new CAPRIHomepageUtils(driver, elementProperties, sharedState);
	}

	@Then("^Click Parent APR button$")
	public void click_Parent_APR_button() throws Throwable {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(elementProperties.getProperty("ParentAPRButton"))));
		applicationUtils.clickonElementusingJSE(elementProperties.getProperty("ParentAPRButton"));
		Thread.sleep(3000);
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^Populate the below fields$")
	public void populate_the_below_fields(DataTable APRpopupFields) throws Throwable {
	//applicationUtils.waitUntilVisibilityofElement("//h1[contains(text(),'Create APR')]");
		applicationUtils.idleTime(3000);
		List<List<String>> fields = APRpopupFields.raw();
		String APRTitle = fields.get(0).get(0);
		String ProductType = fields.get(0).get(1);
		String APRRegion = fields.get(0).get(2);
		String Country = fields.get(0).get(3);
		//Thread.sleep(3000);
		applicationUtils.clickonElementusingJSE(elementProperties.getProperty("APRTitle"));
		//applicationUtils.moveToElementClick(elementProperties.getProperty("APRTitle"));
		applicationUtils.enterText(elementProperties.getProperty("APRTitle"), APRTitle);
		applicationUtils.idleTime(3000);
		applicationUtils.clickOnElement(elementProperties.getProperty("ProductType"));
		applicationUtils.idleTime(1000);
		applicationUtils.enterText(elementProperties.getProperty("ProductType"), ProductType);
		applicationUtils.idleTime(1000);
		applicationUtils.clickonElementusingJSE(elementProperties.getProperty("OtherNonStandard"));
		//applicationUtils.moveToElementClick(elementProperties.getProperty("ProductType"));
		applicationUtils.idleTime(3000);
		applicationUtils.clickonElementusingJSE(elementProperties.getProperty("APRRegion"));
		applicationUtils.idleTime(1000);
		applicationUtils.enterText(elementProperties.getProperty("APRRegion"), APRRegion);
		applicationUtils.idleTime(1000);
		applicationUtils.clickonElementusingJSE(elementProperties.getProperty("APRegion"));
		applicationUtils.idleTime(3000);
		applicationUtils.clickOnElement(elementProperties.getProperty("Country"));
		applicationUtils.idleTime(1000);
		applicationUtils.enterText(elementProperties.getProperty("Country"), Country);
		applicationUtils.idleTime(1000);
		applicationUtils.clickonElementusingJSE(elementProperties.getProperty("SelectedCountry"));
		applicationUtils.idleTime(3000);
		//applicationUtils.selectbyVisibletext(elementProperties.getProperty("APRRegion"), APRRegion);
		//applicationUtils.idleTime(3000);
		//applicationUtils.selectbyVisibletext(elementProperties.getProperty("Country"), Country);
		//applicationUtils.idleTime(3000);

	}

	@Then("^Click Create button$")
	public void click_Create_button() throws Throwable {
		applicationUtils.clickonButton(elementProperties.getProperty("CreateButton"));
		Thread.sleep(3000);
		ReportScreenshots.getScreenshot(sharedState);
	}			

}
