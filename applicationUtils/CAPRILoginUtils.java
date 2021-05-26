package applicationUtils;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CAPRILoginUtils {


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
	public CAPRILoginUtils(WebDriver driver, Properties properties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		this.properties = properties;
		applicationUtils = new ApplicationUtils(driver);
		
	}

	

	// METHODS
	public void EnterApplicationUrl(String url) throws InterruptedException 
	{
		driver.get(url);
	//	Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(properties.getProperty("LoginButton"))));
	}

	public boolean LoginToApplication(String Userrole) throws InterruptedException 
	{
		userRole = Userrole;
		String[] userDetails = properties.getProperty(Userrole).split(";;");
		userName = userDetails[0];
		password = userDetails[1];
		userFullName = userDetails[2];
		reassignRole = userDetails[3];
		applicationUtils.enterText(properties.getProperty("UsernameTextBox"), userName);
		applicationUtils.enterText(properties.getProperty("PasswordTextBox"), password);
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("LoginButton"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("LaunchpadARPTile"))));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
		//Thread.sleep(8000);
		return applicationUtils.isElementDisplayed(String.format(properties.getProperty("LaunchpadARPTile")));
	}
		
		
	
	public boolean LogoutFromCAPRI() throws InterruptedException 
	{
		System.out.println(properties.getProperty("UsernameDropdown"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("UsernameDropdown"))));
		applicationUtils.scrollPagetoHome();
		Thread.sleep(1000);
		applicationUtils.moveToElementClick(properties.getProperty("UsernameDropdown"));
		Thread.sleep(2000);
		
			applicationUtils.moveToElementClick(String.format(properties.getProperty("signout"), "Sign Out"));
		
		Thread.sleep(3000);
		return applicationUtils.isElementDisplayed(properties.getProperty("LoginButton"));
	}

	

}