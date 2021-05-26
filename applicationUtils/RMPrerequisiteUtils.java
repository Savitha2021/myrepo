package applicationUtils;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.NotSupportedException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("serial")
public class RMPrerequisiteUtils {

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	public static String selectedoption=null;
	static final String createrawpage = "Create New Raw Material";
	static final String customworklow = "Custom Workflow";
	static final String qs = "QS";
	static final String externaldata= "External System Data";
	static final String requesttab ="Request Approvals";
	static final String confirmrawwindow= "Confirm RAW Data Qualification";
	static final String editwindow = "Edit RMC Status";
	public static String tradename=null;
	public static String RMID = "";  
 	public static String RMCStatus=null;
	public static String RawID=null;

	// CONSTRUCTOR
	public RMPrerequisiteUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
		applicationUtils = new ApplicationUtils(driver);
	}

	// METHODS
	public void userSelectsTheOptionFromTheMenuOnTheHomePage(String tyOfRM, String buttonName)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(properties.getProperty("LabelText"), buttonName))));
		applicationUtils.moveToElementClick(String.format(properties.getProperty("LabelText"), buttonName));
		applicationUtils.moveToElementClick(String.format(properties.getProperty("ListItemContainsText"), tyOfRM));
	}

	public void userSelectsOptionOnThePage(String workflowType, String page)
	{
		if(page.equals(createrawpage))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("standardWrokflowDefaultRadioButton"))));
			if (applicationUtils.isElementPresent(properties.getProperty("standardWrokflowDefaultRadioButton"))) 
			{
				String[] _option=workflowType.split(" ");
				applicationUtils.moveToElementClick(String.format(properties.getProperty("InputWithValue"), _option[0].toLowerCase().trim()));
				applicationUtils.waitforajaxQueryToProcess();
				applicationUtils.waitForLoadingImageDisappear();
			}
		}
	}

	public void userEntersTheBelowMandatoryFieldsForOnThePage(String workflow,String page, Map<String, String> fields) throws InterruptedException
	{
		tradename=applicationUtils.getRandomName();
		if (workflow.equals(customworklow ) && page.equals(createrawpage)) 
		{
			applicationUtils.moveToElementClick(String.format(properties.getProperty("LabelWithDiv"), "Raw Usage*"));
			Thread.sleep(2000);
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ListItemText"), fields.get("Raw Usage")));
			applicationUtils.enterText(String.format(properties.getProperty("LabelWithInput"), "Trade Name*"),tradename);
			Thread.sleep(2000);
			applicationUtils.enterText(String.format(properties.getProperty("LabelWithInput"), "Manufacturer*"),"testSupplier");
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
			applicationUtils.moveToElementClick(String.format(properties.getProperty("StrongTagText"), fields.get("Manufacturer")));
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(2000);
			applicationUtils.selectbyVisibletext(String.format(properties.getProperty("LabelWithSelect"), "Development Region*"),fields.get("Development Region"));
			applicationUtils.waitForLoadingImageDisappear();
		} 
	}

	public void userclicksonbutton(String buttonName) throws InterruptedException
	{
		applicationUtils.moveToElementClick(String.format(properties.getProperty("ButtonText"),buttonName));
		Thread.sleep(5000);
		applicationUtils.waitForLoadingImageDisappear();
	}

	public void userclicksonNewConstituentsicononthecompositionpage() 
	{
		applicationUtils.moveToElementClick(properties.getProperty("NewConstituentsAdd"));
	}

	public void entercondata()
	{
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), "Common Name*"),"CON123");
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), "CAS Number*"),"CAS-001");
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), "US INCI"),"US-001");
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), "EU INCI"),"EU-001");
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), "USP Name"),"USP-001");
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), "Ph Eur Name"),"PH-001");
		applicationUtils.enterText(String.format(properties.getProperty("SpanWithInput"), "INN Name"),"Inn name");
	}

	public void userclickson(String name) 
	{
		applicationUtils.moveToElementClick(String.format(properties.getProperty("SpanText"), name));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
	}

	public void userSetsThePercentage(String QS) throws InterruptedException
	{
		if(QS.equals(qs))
		{
			applicationUtils.moveToElement(properties.getProperty("Percentage00"));
			applicationUtils.moveToElement(properties.getProperty("Percentage_Button_link"));
			Thread.sleep(3000);
			applicationUtils.clickonElementusingJSE(properties.getProperty("Percentage_Button_link"));
			Thread.sleep(3000);
			applicationUtils.moveToElement(properties.getProperty("Percentage_Qsset"));
			Thread.sleep(3000);
			Actions action=new Actions(driver);
			WebElement element=driver.findElement(By.xpath(properties.getProperty("Percentage_Qsset")));
			action.moveToElement(element).click().perform();
		}
	}

	public String getRawMaterialID()
	{
		String rawMaterilID = applicationUtils.getText(properties.getProperty("RawMaterilID"));
		String[] rawMaterilIDArray = rawMaterilID.split(" ");
		for (String rmId : rawMaterilIDArray)
		{
			if (rmId.contains("RAW")) 
			{
				System.out.println("RMID=" + rmId);
				RMID = rmId.trim();
				break;
			}
		}

		return RMID;
	}

	public void userclicksontabinEditmode(String buttoName)
	{
		applicationUtils.moveToElementClick(String.format(properties.getProperty("ListItemText"), buttoName));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
	}

	public void userClicksOnFromAttributeTabInEditMode(String option) throws InterruptedException
	{
		if(option.equals(externaldata))
		{
			applicationUtils.moveToElement(properties.getProperty("ExternalSystemData_Button"));
			driver.findElement(By.xpath(properties.getProperty("ExternalSystemData_Button"))).click();
			Thread.sleep(2000);
		}
	}

	public void userclicksonsubmenuoption(String buttonName)
	{
		applicationUtils.moveToElementClick(String.format(properties.getProperty("SpanlastText"), buttonName));
	}

	public void userEntersTheBelowFieldsInTheSpecSubMenuOption(Map<String, String> fields)
	{	
		applicationUtils.scrollToElement(properties.getProperty("SpecNumber_TextBox"));
		applicationUtils.enterText(properties.getProperty("SpecNumber_TextBox"), fields.get("SpecNumber"));
		applicationUtils.selectbyVisibletext(properties.getProperty("SpecStage_Select"),fields.get("SpecStage"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.selectbyVisibletext(properties.getProperty("SpecStatus_Select"),fields.get("SpecStatus"));
		applicationUtils.waitForLoadingImageDisappear();
	}

	public boolean userverifiesthesuccesspopup(String name) throws InterruptedException
	{
		Thread.sleep(3000);
		if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("LabelFirstText"), name)))
		{
			return true;
		}

		return false;
	}

	public boolean userSelectsForRMCSupportField(String option) throws InterruptedException
	{
		selectedoption=option;
		applicationUtils.moveToElementClick(String.format(properties.getProperty("RMSupportRadioButton"),option));
		Thread.sleep(3000);
		if(applicationUtils.isElementSelected(String.format(properties.getProperty("RMSupportRadioButton"),option)))
		{
			return true;
		}

		return false;
	}

	public void userSelectsForQualificationTypeField(String option) 
	{
		applicationUtils.selectbyVisibletext(properties.getProperty("ApprovalTypeDropDown_Select"), option);
	}

	public void selectDateRMWorkFlow(String calenderPropName,String datetobeSelected) throws ParseException
	{
		String currentdate=null;
		applicationUtils.moveToElementClick(calenderPropName);
		if(datetobeSelected.equals("Current Date"))
		{
			currentdate=applicationUtils.getCurrentDate("dd-MMMM-yyyy");
		}

		String[] dateArray = currentdate.split("-");
		char c = dateArray[0].charAt(0);
		if (c == '0') 
		{
			dateArray[0] = dateArray[0].substring(1);
		}

		String month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().trim();
		String year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().trim();
		System.out.println(year+"and  "+dateArray[2].trim());
		int newmonth=applicationUtils.getCurrentMonth(month);
		if(!year.equals(dateArray[2].trim()))
		{
			do
			{				
				driver.findElement(By.xpath("(//span[text()='Next'])[1]")).click();
			}
			while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year']")).getText().equals(dateArray[2].trim()));
		}

		// SELECT DESIRED MONTH AFTER SELECTING DESIRED YEAR
		int javaMonthInt= applicationUtils.getCurrentMonth(dateArray[1].trim());

		if(!month.equalsIgnoreCase(dateArray[1].trim()))
		{
			if(javaMonthInt>newmonth)
			{
				do
				{
					driver.findElement(By.xpath("(//span[text()='Next'])[1]")).click();
				}
				while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[1]")).getText().trim().equalsIgnoreCase(dateArray[1].trim()));

			}
			else
			{
				do
				{
					driver.findElement(By.xpath("(//span[text()='Prev'])[1]")).click();
				}
				while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[1]")).getText().trim().equalsIgnoreCase(dateArray[1].trim()));		
			}
		}

		// FIND DATES OF DESIRED MONTH ONLY			
		List<WebElement> allDateOfDesiredMonth= driver.findElements(By.xpath("//table//tbody[1]//td[(@class=' ' or @class=' ui-datepicker-week-end ' or contains(@class,'ui-datepicker-today'))and @data-month='"+javaMonthInt+"']"));
		for(WebElement d:allDateOfDesiredMonth )
		{
			if(d.getText().trim().equals(dateArray[0].trim()))
			{
				d.click();
				break;
			}
		}
	}

	public void userEntersTheMandatoryFieldsOnTheTab(String page, Map<String, String> fields) throws ParseException 
	{
		switch(selectedoption)
		{
		case "Yes":
			if (page.equalsIgnoreCase(requesttab))
			{
				applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"),"Reason for Qualification*"),fields.get("Reason for Qualification"));
				applicationUtils.enterText(String.format(properties.getProperty("SpanContainsTextWithInput"), "Selling Regions*"),fields.get("Selling Regions"));
				applicationUtils.waitForLoadingImageDisappear();
				applicationUtils.idleTime(3000);
				applicationUtils.moveToElementClick("//li[contains(@class,'active-result')]");
				applicationUtils.waitForLoadingImageDisappear();
				applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), "RMC Admin*"),fields.get("RMC Admin"));
				applicationUtils.waitForLoadingImageDisappear();
				selectDateRMWorkFlow(properties.getProperty("RequestedBy_CalenderButton"), fields.get("Requested By"));
				applicationUtils.selectbyVisibletext(String.format(properties.getProperty("SpanWithSelect"), "HUT planned*"),fields.get("HUT planned"));
				applicationUtils.moveToElementClick(String.format(properties.getProperty("COAQuestionButton"),fields.get("Have you obtained (as applicable) Certificates of Analysis (COA), Material Safety Data Sheet (MSDS), supplier's related test method(s) and supplier information?")));
			}
			break;
		case "No":
			// CASE NO WHY THERE IS NO ACTION
			break;
		default:
			throw new NotSupportedException(selectedoption+" is not available");
		}
	}

	public void userClicksOnButtonOnTheRequestApprovalsTab(String button) throws InterruptedException
	{
		switch(button)
		{
		case "Save":
		case "Launch Workflow":
			applicationUtils.moveToElementClick(String.format(properties.getProperty("SpanContainsText"),button));
			Thread.sleep(3000);
			break;
		default: 
			throw new NotSupportedException(button+" is not available");
		}
	}

	public void userEntersTheMandatoryFieldsOnTheWindow(String window,Map<String, String> fields)
	{
		if(window.equals(confirmrawwindow))
		{
			if(!fields.get("Composition Status").isEmpty())
			{
				applicationUtils.selectbyVisibletext(
						String.format(properties.getProperty("SpanWithSelect"), "Composition Status*:"),
						fields.get("Composition Status"));
				applicationUtils.waitForLoadingImageDisappear();
			}
			else
			{
				// WHY ELSE CASE IS NOT IMPLEMENTED
			}
		}
	}

	public void userClicksOnButtonOnTheWindow(String button, String window)
	{
		if(window.equals(confirmrawwindow))
		{
			switch(button)
			{
			case "Submit":
			case "Cancel":
				applicationUtils.moveToElementClick(String.format(properties.getProperty("RAWDataQualificationButton"), button));
				applicationUtils.waitForLoadingImageDisappear();
				break;
			default: 
				throw new NotSupportedException(confirmrawwindow+" is not available");
			}
		}
		else if(window.equals(editwindow))
		{
			switch(button)
			{
			case "Submit":
			case "Cancel":
				applicationUtils.moveToElementClick(String.format(properties.getProperty("EditRMCStatusButton"), button));
				applicationUtils.waitForLoadingImageDisappear();
				break;
			default: 
				throw new NotSupportedException(editwindow+" is not available");
			}
		}
	}

	public void userClicksOnHeaderIcon(String option)
	{
		applicationUtils.moveToElementClick(String.format(properties.getProperty("SpanText"), option));
		applicationUtils.waitForLoadingImageDisappear();
	}

	public void userClicksOnButtonOfDevelopmentRAWDataConfirmationInTheCompositionPage(String button)
	{
		applicationUtils.moveToElementClick(String.format(properties.getProperty("ButtonText"), button));
		applicationUtils.waitForLoadingImageDisappear();
	}

	public void userClicksOnTab(String tab)
	{
		applicationUtils.moveToElementClick(String.format(properties.getProperty("SpanText"),tab));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.idleTime(2000);
	}

	public void userClicksOnRMCStatusWithOptionInTheRequestApprovalsTabUnderStatus(String rmcstatus, String mode, String rmstatus) throws InterruptedException 
	{
		if(rmstatus.equals("Development Qualified"))
		{
			applicationUtils.moveToElementClick(String.format(properties.getProperty("SpanContainsTextWithSpan"),rmcstatus,mode));
			Thread.sleep(4000);
		}

		// WHY ELSE CASE IS NOT IMPLEMEMNTED
	}

	public void userEntersTheFieldsOnTheWindow(String window, Map<String, String> fields)
	{
		if(window.equals(editwindow))
		{
			applicationUtils.moveToElement(properties.getProperty("EditRMCStatus"));
			driver.findElement(By.xpath(properties.getProperty("EditRMCStatus"))).click();
			applicationUtils.selectbyVisibletext(properties.getProperty("EditRMCStatus"),fields.get("RMC Status:"));
			applicationUtils.waitForLoadingImageDisappear();
			applicationUtils.enterText(properties.getProperty("EditRMCStatusComments"),fields.get("Comments:"));
			applicationUtils.waitForLoadingImageDisappear();
		}
	}

	public String createrawmaterial(String option) throws InterruptedException
	{
		String rMID=null;
		userSelectsTheOptionFromTheMenuOnTheHomePage("New Chemical RAW", "New");
		userSelectsOptionOnThePage(option, createrawpage);
		Map<String, String> map = new HashMap<String, String>() {
			{
				put("Raw Usage", "Self Care");
				put("Trade Name", "Random Name");
				put("Manufacturer", "testSupplier");
				put("Development Region", "Asia Pacific");
			}
		};
		userEntersTheBelowMandatoryFieldsForOnThePage(option,createrawpage, map);
		userclicksonbutton("Create Raw Material");
		userclicksonNewConstituentsicononthecompositionpage();
		entercondata();
		userclickson("Save Constituent");
		userclicksonbutton("OK");
		userSetsThePercentage(qs);
		userclicksonbutton("Save");
		userclicksonbutton("OK");
		rMID=getRawMaterialID();
		userclicksontabinEditmode("Attributes");
		userClicksOnFromAttributeTabInEditMode(externaldata);
		userclicksonsubmenuoption("Spec");
		Map<String, String> specmap = new HashMap<String, String>() {
			{
				put("SpecNumber", "1234");
				put("SpecStage", "Permanent");
				put("SpecStatus", "Issued");
			}
		};
		userEntersTheBelowFieldsInTheSpecSubMenuOption(specmap);
		userclicksonbutton("Save");
		boolean messageflag=userverifiesthesuccesspopup("Raw Material Saved Successfully.");
		Assert.assertTrue("Sucess message not displayed",messageflag);
		userclicksonbutton("OK");
		userclicksonbutton("Exit");
		return rMID;
	}

	public boolean launchRMWorkflow(String option, final String rmcstatus) throws InterruptedException, ParseException
	{
		userclicksonbutton("Request Qualification");
		userSelectsForRMCSupportField("Yes");
		userSelectsForQualificationTypeField("Development Qualification");
		Map<String,String> data= new HashMap<String,String>()
				{
			{
				put("Reason for Qualification", "Testing");
				put("Selling Regions", "Asia Pacific");
				put("RMC Admin","Iris TEST235");
				put("Requested By", "Current Date");
				put("HUT planned", "None");
				put("Have you obtained (as applicable) Certificates of Analysis (COA), Material Safety Data Sheet (MSDS), supplier's related test method(s) and supplier information?", "Yes");
			}
				};
				userEntersTheMandatoryFieldsOnTheTab(requesttab,data);
				userClicksOnButtonOnTheRequestApprovalsTab("Launch Workflow");
				boolean messageflag=userverifiesthesuccesspopup("Workflow launched Successfully.");
				Assert.assertTrue("Sucess message not displayed",messageflag);
				userclicksonbutton("OK");
				userClicksOnHeaderIcon("Raw Material");
				userClicksOnButtonOfDevelopmentRAWDataConfirmationInTheCompositionPage("Confirm");
				Map<String,String> popdata= new HashMap<String,String>()
						{
					{
						put("Composition Status", "Full");
					}
						};
						userEntersTheMandatoryFieldsOnTheWindow(confirmrawwindow, popdata);
						userClicksOnButtonOnTheWindow("Submit", confirmrawwindow);
						messageflag=userverifiesthesuccesspopup("Task Approved Successfully.");
						Assert.assertTrue("Sucess message not displayed",messageflag);
						userclicksonbutton("OK");
						userClicksOnTab(requesttab);
						userClicksOnRMCStatusWithOptionInTheRequestApprovalsTabUnderStatus("RaMPS Restricted", "Edit", "Development Qualified");
						Map<String,String> confirmdata= new HashMap<String,String>()
								{
							{
								put("RMC Status:", rmcstatus);
								put("Comments:", "Testing");
							}
								};			
								userEntersTheFieldsOnTheWindow(editwindow, confirmdata);
								userClicksOnButtonOnTheWindow("Submit", editwindow);
								boolean rmcflag=userverifiesthesuccesspopup("RMC Status Updated Successfully.");
								Assert.assertTrue("Sucess message not displayed",rmcflag);
								userclicksonbutton("OK");
								boolean rmcstatusflag=applicationUtils.isElementDisplayed(String.format(properties.getProperty("SpanContainsTextWithSpan"),rmcstatus,"Edit"));
								userClicksOnHeaderIcon("Raw Material");
								return rmcstatusflag;
	}

	public void enterRMIDandclickonSearchIcon(String RMID) throws Throwable {
		Thread.sleep(6000);
		applicationUtils.clear(properties.getProperty("RMGlobbalsearchTextbox"));
		applicationUtils.enterText(properties.getProperty("RMGlobbalsearchTextbox"),RMID.trim());
		Thread.sleep(2000);	
		applicationUtils.moveToElementClick(properties.getProperty("RMGlobalSearchButton"));
		Thread.sleep(2000);	
	}
	
	public void selectRMIDAvailableLink() throws Throwable 
	{
		applicationUtils.moveToElementClick(properties.getProperty("TileTradenameLink"));
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(4000);	
	}

}