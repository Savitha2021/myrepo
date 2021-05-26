package applicationUtils;

import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDCompositionUtils {

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	private RMPrerequisiteUtils rmPrerequisiteUtils;
	public static String RMID = null;
	public static String selectedoption = null;
	static String percentage1 ="Percentage (%w/w)";
	static String percentage2 ="Percentage (%w/v)";
	static String weight = "Weight(mg)";
	static final String EDIT ="Edit";
	static final String VIEW = "View";
	public static String selectedtradename="";

	// CONSTRUCTOR
	public PDCompositionUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
		applicationUtils = new ApplicationUtils(driver);
		rmPrerequisiteUtils = new RMPrerequisiteUtils(driver, elementProperties);
	}

	// METHODS
	public void searchForRawmaterial(String rmId) throws InterruptedException
	{
		applicationUtils.enterText(properties.getProperty("RawMaterialSearchBox"), rmId);
		applicationUtils.moveToElementClick(properties.getProperty("RawMaterialSearchIcon"));
		Thread.sleep(9000);
	}

	public boolean verifySaveAsButton()
	{
		applicationUtils.waitForLoadingImageDisappear();
		return applicationUtils.isElementDisplayed(properties.getProperty("SaveAsButton"));
	}

	public void clickAddButtonOnRawMaterial() throws InterruptedException 
	{
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("(//div[@id='raw-scroll-div']//li)[1]"));
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		WebElement ele1 = ele.findElement(By.xpath("(.//span[contains(text(),'Add')]/parent::div[@class='add-btn'])[1]"));
		Thread.sleep(2000);
		action.moveToElement(ele1).click().perform();
		applicationUtils.moveToElementClick("//div[@id='fmlCompositionRawMaterialPage']//span[@class='close-icon-tab']");
		Thread.sleep(2000);
	}

	public void setQSPercentage() throws InterruptedException
	{
		applicationUtils.scrollPagetoEnd();
		Thread.sleep(1000);
		applicationUtils.scrollToElement(properties.getProperty("percentagefield"));
		Thread.sleep(1000);
		applicationUtils.moveToElement(properties.getProperty("percentagefield"));
		Thread.sleep(1000);
		applicationUtils.moveandClickonButton(properties.getProperty("percentage_arrow"));
		applicationUtils.moveToElement(properties.getProperty("percentage_set"));
		Thread.sleep(2000);
		applicationUtils.moveToElement(properties.getProperty("percentagefield"));
		Thread.sleep(1000);
		applicationUtils.moveandClickonButton(properties.getProperty("percentage_arrow"));		
		Thread.sleep(1000);
		applicationUtils.clickOnElement(properties.getProperty("percentage_set"));
	}

	public String getFormulaId() 
	{
		String fmlId="";
		String tempFmlId=applicationUtils.getText(properties.getProperty("FormulaIdText"));
		fmlId=tempFmlId.split(" ")[tempFmlId.split(" ").length-1].trim();
		return fmlId;
	}

	public boolean formulaFormat()
	{	
		applicationUtils.waitForLoadingImageDisappear();
		String FML = driver.findElement(By.xpath(properties.getProperty("FormulaID"))).getAttribute("title");
		String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		String year1 = year.substring(year.length() - 2,	
				year.length() - 0);

		return (FML.substring(0, 3).equals("FML")|(FML.substring(0, 3).equals("PTB")  |(FML.substring(0, 3).equals("TAB") |(FML.substring(0, 3).equals("PED") && 
				FML.substring(FML.length() - 12,
						FML.length() - 10).contentEquals(year1) &&
				FML.substring(FML.length() - 5,
						FML.length() - 4).equals("A") &&
				FML.substring(FML.length() - 4,
						FML.length() - 0).equals("-001")))));
	}

	public boolean verifyRMID() throws InterruptedException 
	{
		applicationUtils.waitForLoadingImageDisappear();		
		applicationUtils.moveToElementClick("//i[@id='fontDirection']/span");
		applicationUtils.waitForLoadingImageDisappear();	
		applicationUtils.moveToElementClick("//span[text()='Total 1 Items']");
		Actions actions = new Actions(driver);
		int i = 0;
		while (i < 30)
		{
			actions.sendKeys(Keys.RIGHT).build().perform();;
			Thread.sleep(2000);
			++i;
		}

		applicationUtils.waitForLoadingImageDisappear();	
		applicationUtils.scrollToElement(properties.getProperty("CASNumber"));
		applicationUtils.scrollPagetoHome();
		System.out.println("CHECK THIS IS MINE"+rmPrerequisiteUtils.RMID);
		boolean flag = applicationUtils.isElementPresent("//div[text()='"+rmPrerequisiteUtils.RMID+"']");		
		RMPrerequisiteUtils.RMID=null;
		return flag;
	}

	public boolean verifyCompositionScreen()
	{
		return applicationUtils.isElementDisplayed(properties.getProperty("CompositionTabHeaderName"));
	}

	public boolean compositioncolumndataverification(String value,String columnname)
	{
		if(columnname.equals(percentage1))
		{
			if(applicationUtils.isElementPresent(String.format(properties.getProperty("Percentage1Value"),value)))
			{
				applicationUtils.scrollToElement(String.format(properties.getProperty("Percentage1Value"),value));
				return true;
			}
		}
		else if(columnname.equals(percentage2))
		{
			if(applicationUtils.isElementPresent(String.format(properties.getProperty("Percentage2Value"),value)))
			{
				applicationUtils.scrollToElement(String.format(properties.getProperty("Percentage2Value"),value));
				return true;
			}			
		}
		else if(columnname.equals(weight))
		{
			boolean flag=applicationUtils.isElementPresent(String.format(properties.getProperty("WeightValue"),PDCompositionUtils.selectedtradename,weight,value));
			if(flag)
			{
				applicationUtils.scrollToElement(String.format(properties.getProperty("WeightValue"),PDCompositionUtils.selectedtradename,weight,value));
				return true;
			}	
		}

		return false;
	}

	public boolean verifyFormulaStatus(String status) {
		return applicationUtils.isElementPresent(String.format(properties.getProperty("ButtonContainsText"),status));
	}
}