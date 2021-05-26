package com.jnj.XrayCucumber.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import applicationUtils.ApplicationUtils;
import applicationUtils.PDPropertiesUtils;

public class PDPropertiesTabStepDefinitions extends TestRunner{

	// VARIABLES
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	ApplicationUtils applicationUtils;
	PDPropertiesUtils propertiesTabUtils;
	static List<WebElement> obtaineddatafields;
	public static ArrayList<String> sourceFMLPropertyValues;
	public static ArrayList<String> saveAsFMLPropertyValues;

	//CONSTRUCTOR
	public PDPropertiesTabStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState=sharedState;
		wait = new WebDriverWait(driver, 60);
		applicationUtils = new ApplicationUtils(driver);
		propertiesTabUtils= new PDPropertiesUtils(driver, elementProperties);
	}

	// STEP DEFINITIONS
	@When("^The User populates the fields on Properties tab$")
	public void the_User_populates_the_fields_on_Properties_tab() throws Throwable 
	{	
		sourceFMLPropertyValues=propertiesTabUtils.populateFields();
		ReportScreenshots.getScreenshot(sharedState);
	}

	@Then("^The User verifies the Properties tab has the same values as the source formula$")
	public void the_User_verifies_the_Properties_tab_has_the_same_values_as_the_source_formula() throws Throwable {
		saveAsFMLPropertyValues=propertiesTabUtils.getSaveAsPropertyValues();		
		Assert.assertTrue("Entered Data is not matching with Saved data", propertiesTabUtils.comparetheSourcewithSaved(sourceFMLPropertyValues,saveAsFMLPropertyValues));
		ReportScreenshots.getScreenshot(sharedState);
	}
}