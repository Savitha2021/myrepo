package applicationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDPropertiesUtils {

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	public static String RMID = null;
	public static String selectedoption = null;
	public List<WebElement> fields;
	public ArrayList<String> _fieldValues;
	public ArrayList<String> _SaveAsfieldValues;

	// CONSTRUCTOR
	public PDPropertiesUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
	}

	// METHODS
	public ArrayList<String> populateFields() 
	{
		Random random = new Random();
		_fieldValues = new ArrayList<String>();
		fields = driver.findElements(By.xpath("//input[@type='text' and contains(@class,'ng-untouched ng-valid') or @placeholder='Type your comments']"));
		for (int input = 0; input < fields.size(); input++) {
			try {
				int num = random.nextInt(900) + 100;
				fields.get(input).clear();
				fields.get(input).sendKeys(Integer.toString(num));
				Thread.sleep(2000);
				_fieldValues.add(Integer.toString(num));
			} catch (Exception e) {
				System.out.println("Exception occured: "+e.getMessage());
			}
		}
		
		return _fieldValues;
	}

	public ArrayList<String> getSaveAsPropertyValues()
	{
		_SaveAsfieldValues = new ArrayList<String>();
		List<WebElement> inputBoxesElements = driver.findElements(By.xpath(properties.getProperty("SaveAsPropertyValues")));
		for (int i = 0; i < inputBoxesElements.size(); i++) 
		{
			inputBoxesElements = driver.findElements(By.xpath(properties.getProperty("SaveAsPropertyValues")));
			_SaveAsfieldValues.add(inputBoxesElements.get(i).getAttribute("value").trim());
		}
		
		return _SaveAsfieldValues;
	}

	public boolean comparetheSourcewithSaved(ArrayList<String> source, ArrayList<String> saved)
	{
		for(int i=0;i<source.size();i++)
		{
			if(!source.get(i).contentEquals(saved.get(i)))
			{
				System.out.println("Data Mismatch: Index "+i+" Source: "+source.get(i)+" Saved: "+saved.get(i));
				return false;
			}
		}

		return true;
	}
}