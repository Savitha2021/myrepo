package applicationUtils;


import static org.junit.Assert.fail;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;



public class CAPRIPreferencesUtils {

	
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	static String technicalComments="";

	// CONSTRUCTOR
	public CAPRIPreferencesUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
		applicationUtils = new ApplicationUtils(driver);
}
	
	public void _user_navigates_to_preferences_page() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("UsernameDropdown"))));
		applicationUtils.clickonElementusingJSE(properties.getProperty("UsernameDropdown"));

		//Thread.sleep(3000);
		applicationUtils.moveToElementClick(properties.getProperty("Preferences"));
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("PreferencesLabel"))));

	}
	
		public void _user_selects_one_Brand_value_two_or_more_categories_and_statuses_In_progress_and_Approved() throws Throwable {
		if(applicationUtils.isElementPresent(properties.getProperty("ClearFiltersButton")))
			applicationUtils.clickonElementusingJSE((properties.getProperty("ClearFiltersButton")));
		Thread.sleep(2000);
		
	applicationUtils.clickOnElement((properties.getProperty("Brand")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("BrandFilterval1"))));
		applicationUtils.clickonElementusingJSE(properties.getProperty("BrandFilterval1"));
		applicationUtils.pressEscKey();
		//driver.findElementByXPath("//input[@name='autoComplete']").sendKeys(Keys.ESCAPE);

		Thread.sleep(3000);
		
applicationUtils.clickOnElement((properties.getProperty("APRStatus")));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("StatusFilterval1"))));

applicationUtils.clickonElementusingJSE(properties.getProperty("StatusFilterval1"));
applicationUtils.clickonElementusingJSE(properties.getProperty("StatusFilterval2"));
Thread.sleep(3000);
applicationUtils.pressEscKey();
//driver.findElementByXPath("//input[@name='autoComplete']").sendKeys(Keys.ESCAPE);


applicationUtils.clickOnElement((properties.getProperty("Category")));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("CategoryFilterval1"))));
	
		applicationUtils.clickonElementusingJSE(properties.getProperty("CategoryFilterval1"));
		applicationUtils.clickonElementusingJSE(properties.getProperty("CategoryFilterval2"));
		applicationUtils.pressEscKey();
		//driver.findElementByXPath("//input[@name='autoComplete']").sendKeys(Keys.ESCAPE);
				

	}
		
		public  void assertElementNotPresent123(String path) throws NoSuchElementException {
		    try {
		    	//Assert.assertFalse("element "+path+" is present", applicationUtils.isElementPresent(path));
		    driver.findElement(By.xpath(path));
		    	fail("Element <" + path + "> is present");
		    	//driver.wait(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));		    	
		    } catch (NoSuchElementException ex) { 
		        /* do nothing, link is not present, assert is passed */ 
		    	//ex.printStackTrace();
		    }
		   // catch(StaleElementReferenceException ex) {}
		    
		}
		
		public boolean assertElementPresent(String FieldPath) {
			
			return applicationUtils.isElementPresent(FieldPath);
		}

}
