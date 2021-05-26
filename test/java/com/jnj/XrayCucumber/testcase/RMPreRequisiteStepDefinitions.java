package com.jnj.XrayCucumber.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import applicationUtils.ApplicationUtils;
import applicationUtils.RMPrerequisiteUtils;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import cucumber.api.java.en.Given;

public class RMPreRequisiteStepDefinitions extends TestRunner
{

	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	ApplicationUtils applicationUtils;
	RMPrerequisiteUtils rmprerequisiteUtils;
	public static List<String> RMid = new ArrayList<>();
	public static List<String> Tradename = new ArrayList<>();
	public static String RMID=null;


	// CONSTRUCTOR
	public RMPreRequisiteStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		applicationUtils= new ApplicationUtils(driver);
		rmprerequisiteUtils= new RMPrerequisiteUtils(driver, elementProperties);
	}

	// STEP DEFINITIONS
	@Given("^The User creates raw material for \"([^\"]*)\"$")
	public void theUserCreatesRawMaterialFor(String option) throws Throwable 
	{
		if(RMID==null)
		{	
			RMID = rmprerequisiteUtils.createrawmaterial(option);
			Assert.assertTrue("Raw Material is not created", !RMID.isEmpty());
			ReportScreenshots.getScreenshot(sharedState);
		}
		else{
			rmprerequisiteUtils.enterRMIDandclickonSearchIcon(RMID);
			rmprerequisiteUtils.selectRMIDAvailableLink();
			Assert.assertTrue("RM ID not selected",applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("RawIDComposition"),RMID.trim())));
			ReportScreenshots.getScreenshot(sharedState);
		}
	}

	@Given("^The User creates raw material for \"([^\"]*)\" with \"([^\"]*)\" RMC status$")
	public void theUserCreatesRawMaterialForWithRMCStatus(String option,final String rmcstatus) throws Throwable 
	{
		if(RMID==null)
		{
			RMID = rmprerequisiteUtils.createrawmaterial(option);
			Assert.assertTrue("RM ID not present", !RMID.isEmpty());
			// VALIDATE RMC STATUS
			RMPrerequisiteUtils.RMCStatus=rmcstatus;
			boolean launch_flag=rmprerequisiteUtils.launchRMWorkflow(option, rmcstatus);
			Assert.assertTrue("RM is not launched", launch_flag);
			ReportScreenshots.getScreenshot(sharedState);
		}
		else
		{
			rmprerequisiteUtils.enterRMIDandclickonSearchIcon(RMID);
			rmprerequisiteUtils.selectRMIDAvailableLink();
			Assert.assertTrue("RM ID not selected",applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("RawIDComposition"),RMID.trim())));
			ReportScreenshots.getScreenshot(sharedState);
		}
	}
	

	@Given("^The User creates \"([^\"]*)\" raw material for \"([^\"]*)\"$")
	public void theUserCreatesRawMaterialFor(String count, String option)
			throws Throwable {

		
		
		
		if(RMid.size()<Integer.parseInt(count))
		{
			if(Integer.parseInt(count)>1)
			{
				for(int i=0;i<Integer.parseInt(count);i++)
				{
					RMID = rmprerequisiteUtils.createrawmaterial(option);
					Assert.assertTrue("RM ID not present", !RMID.isEmpty());
					RMid.add(RMID);
					Tradename.add(RMPrerequisiteUtils.tradename);
					ReportScreenshots.getScreenshot(sharedState);
				}
			}
		}
		else{
			for(int j=0;j<RMid.size();j++)
			{
				rmprerequisiteUtils.enterRMIDandclickonSearchIcon(RMid.get(j));
				rmprerequisiteUtils.selectRMIDAvailableLink();
				Assert.assertTrue("RM ID not selected",applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("RawIDComposition"),RMid.get(j).trim())));
				ReportScreenshots.getScreenshot(sharedState);
				applicationUtils.idleTime(3000);
				applicationUtils.moveToElementClick(elementProperties.getProperty("HomeIcon"));	
				applicationUtils.idleTime(6000);
			}
		}			
	}
}