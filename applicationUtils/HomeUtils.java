package applicationUtils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeUtils {

	// CONSTANTS
	static final String PDHOMEPAGETITLE = "Product Development";
	static final String APPROVEBUTTON = "Approve";
	static final String IAGREEBUTTON = "I Agree";
	static final String FORMULAOPTION = "Formula";
	static final String NEWBUTTON = "New";
	static final String ROUTEFORAPPROVAL ="Route for Approval";
	static final String APPROVALREQUIRED="Atleast one Approval is required to launch the WorkFlow";

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;

	// CONSTRUCTOR
	public HomeUtils(WebDriver driver, Properties properties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		this.properties = properties;
		applicationUtils = new ApplicationUtils(driver);
	}

	// METHODS
	public boolean verifyHomePageNavigation(String title) 
	{
		if (title.equals(PDHOMEPAGETITLE)) 
		{
			return applicationUtils.isElementPresent(properties.getProperty("PDHomePageTitle"));
		}

		return false;
	}

	public void userClicksOnButton(String buttonName)
	{
		applicationUtils.idleTime(2000);
		if (buttonName.equals(APPROVEBUTTON) || buttonName.equals(IAGREEBUTTON)||buttonName.equals(ROUTEFORAPPROVAL)) 
		{
		    applicationUtils.idleTime(2000);
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ButtonContainsText"), buttonName));
			applicationUtils.waitForLoadingImageDisappear();
		}
		else if(buttonName.equals("Submit"))
		{
			applicationUtils.moveToElementClick(properties.getProperty("SubmitButton"));       
		}
		else if(buttonName.equals("OK") && applicationUtils.isElementDisplayed(String.format(properties.getProperty("ButtonSecondText"), buttonName))) {
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ButtonSecondText"), buttonName));
		}
		else if(buttonName.equals("OK") && applicationUtils.isElementDisplayed(String.format(properties.getProperty("ButtonFirstText"), buttonName))) {
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ButtonFirstText"), buttonName));
		}             
		else
		{
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ButtonText"), buttonName)); 
		}
	}


	public void userSelectsOptionFromMenuHomePage(String buttonName, String optionType)
	{
		if (buttonName.equals(NEWBUTTON))
		{
			applicationUtils.moveToElementClick(properties.getProperty("NewButton"));
		}

		if (optionType.equals(FORMULAOPTION))
		{
			applicationUtils.moveToElementClick(properties.getProperty("ListItemFormula"));
		}
	}

	public boolean verifyTheSucessPopup(String message)
	{
		applicationUtils.waitForLoadingImageDisappear();
		if(applicationUtils.isElementDisplayed(String.format(properties.getProperty("LabelFirstText"), message))||
				applicationUtils.isElementDisplayed(String.format(properties.getProperty("LabelSecondText"), message))) {
			return true;
		}else {
			return false;
		}
	}
	

  
  }
 