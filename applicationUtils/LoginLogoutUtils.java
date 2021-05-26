package applicationUtils;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLogoutUtils {

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	public static String userName = "";
	public static String userFullName = "";
	public static String userRole = "";
	public static String reassignRole = "";
	public static String password = "";

	// CONSTRUCTOR
	public LoginLogoutUtils(WebDriver driver, Properties properties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		this.properties = properties;
		applicationUtils = new ApplicationUtils(driver);
	}

	// METHODS
	public void EnterApplicationUrl(String url) throws InterruptedException 
	{
		driver.get(url);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(properties.getProperty("LoginButton"))));
	}

	public boolean LoginToApplication(String Userrole) throws InterruptedException 
	{
		userRole = Userrole;
		String[] userDetails = properties.getProperty(Userrole).split("--");
		userName = userDetails[0];
		password = userDetails[1];
		userFullName = userDetails[2];
		reassignRole = userDetails[3];
		applicationUtils.enterText(properties.getProperty("UsernameTextBox"), userName);
		applicationUtils.enterText(properties.getProperty("PasswordTextBox"), password);
//		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("LoginButton"));
		Thread.sleep(4000);
		
		if(applicationUtils.isElementPresent(properties.getProperty("LaunchpadText")))
		{
		applicationUtils.clickOnElement(properties.getProperty("LaunchpadAPR"));
		
		}
		
			//applicationUtils.clickOnElement(properties.getProperty("LaunchpadAPR"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(properties.getProperty("HomePageApplicationNameLabel"), "CAPRI"))));
				
//		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(10000);
		//applicationUtils.clickonElementusingJSE(properties.getProperty("ParentAPRButton"));
		//System.out.println(properties.getProperty("ParentAPRButton"));
		
		return applicationUtils.isElementDisplayed(String.format(properties.getProperty("HomePageApplicationNameLabel"), reassignRole));
		
	}

	public boolean LogoutFromApplication(String module) throws InterruptedException 
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("UserFullNameLabel"))));
		applicationUtils.scrollPagetoHome();
		Thread.sleep(1000);
		applicationUtils.moveToElementClick(properties.getProperty("UserFullNameLabel"));
		Thread.sleep(2000);
		if(module.equals("Common Approval Module"))
		{
			applicationUtils.moveToElementClick(String.format(properties.getProperty("LinkText"), "Sign Out"));
		}
		else 
		{
			applicationUtils.moveToElementClick(String.format(properties.getProperty("SpanText"), "Sign Out"));
		}
		Thread.sleep(5000);
		return applicationUtils.isElementDisplayed(properties.getProperty("LoginButton"));
	}
}