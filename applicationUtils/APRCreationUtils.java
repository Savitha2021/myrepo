package applicationUtils;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;



public class APRCreationUtils {

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
	public APRCreationUtils(WebDriver driver, Properties properties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		this.properties = properties;
		applicationUtils = new ApplicationUtils(driver);
}
	
	public void createAPR() {
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(properties.getProperty("ParentAPRButton"))));
		applicationUtils.clickonElementusingJSE(properties.getProperty("ParentAPRButton"));
		
		applicationUtils.idleTime(3000);
		
		applicationUtils.clickonElementusingJSE(properties.getProperty("APRTitle"));
		//applicationUtils.moveToElementClick(elementProperties.getProperty("APRTitle"));
		applicationUtils.enterText(properties.getProperty("APRTitle"), "stn1 Automation APR1");
		applicationUtils.idleTime(3000);
		applicationUtils.clickOnElement(properties.getProperty("ProductType"));
		applicationUtils.idleTime(1000);
		applicationUtils.enterText(properties.getProperty("ProductType"), "Other (Non-Standard)");
		applicationUtils.idleTime(1000);
		applicationUtils.clickonElementusingJSE(properties.getProperty("OtherNonStandard"));
		//applicationUtils.moveToElementClick(elementProperties.getProperty("ProductType"));
		applicationUtils.idleTime(3000);
		applicationUtils.clickonElementusingJSE(properties.getProperty("APRRegion"));
		applicationUtils.idleTime(1000);
		applicationUtils.enterText(properties.getProperty("APRRegion"), "AP");
		applicationUtils.idleTime(1000);
		applicationUtils.clickonElementusingJSE(properties.getProperty("APRegion"));
		applicationUtils.idleTime(3000);
		applicationUtils.clickOnElement(properties.getProperty("Country"));
		applicationUtils.idleTime(1000);
		applicationUtils.enterText(properties.getProperty("Country"), "India");
		applicationUtils.idleTime(1000);
		applicationUtils.clickonElementusingJSE(properties.getProperty("SelectedCountry"));
		applicationUtils.idleTime(3000);
		applicationUtils.clickonButton(properties.getProperty("CreateButton"));
		
		
	}			

}

	
