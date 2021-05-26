package applicationUtils;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationUtils {

	// VARIABLES
	WebDriver driver;
	WebDriverWait wait;

	// CONSTRUCTOR
	public ApplicationUtils(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, 360);
	}

	// METHODS
	public WebElement getElementById(String id)
	{
		return driver.findElement(By.id(id));
	}

	public List<WebElement> getWebElements(String xpath)
	{
		if(xpath.contains("//"))
		{
			return driver.findElements(By.xpath(xpath));
		}
		else
		{
			return driver.findElements(By.id(xpath));
		}
	}

	public void clickOnElement(String path)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			element.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void waitUntilVisibilityofElement(String id)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	public void idleTime(int time)
	{
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickonElementusingJSE(String path)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			new Actions(driver).moveToElement(element).perform();
			getjavascritExecutor().executeScript("arguments[0].click();", element);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToElement(String path) {
		WebElement element;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			new Actions(driver).moveToElement(element).perform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void moveToElementClick(String path) {
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			new Actions(driver).moveToElement(element).click().perform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToElementClick(WebElement element) {
		new Actions(driver).moveToElement(element).click().perform();
	}

	public boolean isElementDisplayed(String path)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		if(element!=null && element.isDisplayed())
		{
			return true;
		}

		return false;
	}

	public boolean isElementEnabled(String id)
	{
		WebElement element=null;
		try
		{
			if (id.startsWith("//") || id.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(id));
			}
			else
			{
				element = driver.findElement(By.id(id));
			}

			return element.isEnabled();
		}
		catch(Exception ex)
		{
			return false;
		}		
	}

	public JavascriptExecutor getjavascritExecutor() {
		return (JavascriptExecutor) driver;
	}

	public void waitforajaxQueryToProcess() {
		wait = new WebDriverWait(driver, 30);
		wait.until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driverObject) {
				return (Boolean) (getjavascritExecutor().executeScript("return document.readyState")
						.equals("complete"));
			}
		});
	}

	public void waitForLoadingImageDisappear() {
		wait = new WebDriverWait(driver, 60);
		try {
			idleTime(3000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='processing']/img")));
			idleTime(3000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='processing']/img")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getText(String path)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			if(element!=null)
			{
				return element.getText().trim();
			}
		}
		catch (Exception e) {
			return "Element is not available";
		}

		return "Element is not available";
	}

	public void selectCheckBox(String path) {
		WebElement element = null;

		if (path.startsWith("//") || path.startsWith("(//")) 
		{
			element = driver.findElement(By.xpath(path));
		} 
		else 
		{
			element = driver.findElement(By.id(path));
		}

		if (isElementEnabled(path)) 
		{
			moveToElement(element);
			idleTime(2000);
			if (!element.isSelected()) 
			{
				getjavascritExecutor().executeScript("arguments[0].click();", element);
			}
		} 
		else
		{
			throw new ElementNotSelectableException("Web Element with the id " + path + " is not enabled to select");
		}
	}

	public void unSelectCheckBox(String path)
	{
		WebElement element = null;
		if (path.startsWith("//") || path.startsWith("(//")) 
		{
			element = driver.findElement(By.xpath(path));
		}
		else
		{
			element = driver.findElement(By.id(path));
		}

		if(element.isEnabled())
		{
			moveToElement(element);
			idleTime(2000);
			if(element.isSelected())
			{
				getjavascritExecutor().executeScript("arguments[0].click();", element);
			}
		}
		else
		{
			throw new ElementNotSelectableException("Web Element with the path "+path+" is not enabled to unselect");
		}
	}

	public void scrollPagetoEnd()
	{
		getjavascritExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollPagetoHome()
	{
		getjavascritExecutor().executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public void enterText(String path, String value)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			element.sendKeys(value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearandEnterText(String path, String value)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}
			element.click();
			element.clear();
			element.sendKeys(value);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clear(String path)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}
			element.sendKeys(Keys.CONTROL+"a");
			element.sendKeys(Keys.DELETE);
			Thread.sleep(2000);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterText(WebElement element, String value)
	{
		element.sendKeys(value);
	}

	public void clearandEnterText(WebElement element, String value)
	{
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public void pressTabKey()
	{
		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			System.out.println("Exception Occured while trying to press Tab key");
		}
	}

	public boolean isReadOnly(WebElement element)
	{
		try
		{
			element.sendKeys("Test");
			return false;
		}
		catch(Exception ex)
		{
			return true;
		}
	}

	public void clickonButton(String path)
	{
		
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}
		
		
		moveToElement(element);
		getjavascritExecutor().executeScript("arguments[0].click();", element);
		waitforajaxQueryToProcess();
		waitForLoadingImageDisappear();
		idleTime(2000);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}

	public void moveandClickonButton(String id)
	{
		moveToElement(id);
		moveToElementClick(id);
		waitforajaxQueryToProcess();
		waitForLoadingImageDisappear();
		idleTime(2000);
	}

	public void pressBackspaceKey()
	{
		try {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		} catch (AWTException e) {
			System.out.println("Exception occured while trying to press Backspace key");
		}
	}

	public void uploadFile(String docname) throws AWTException {		
		StringSelection sPath = new StringSelection(
				"" + System.getProperty("user.dir") + "\\TestFiles\\" + docname);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sPath, null);
		Robot robot = new Robot();
		robot.delay(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		idleTime(3000);
	}

	public String getFutureDate(int days)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +days);
		Date date = cal.getTime();
		return dateFormat.format(date);
	}

	public String getPrevousDate(int days)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -days);
		Date date = cal.getTime();
		return dateFormat.format(date);
	}

	public void moveToElementSendKeys(String id, String value) {
		WebElement element = driver.findElement(By.id(id));
		new Actions(driver).moveToElement(element).sendKeys(value).perform();
	}

	public String getCurrentDateandTime() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh");
		Calendar cal = Calendar.getInstance();
		Date currentDate = dateFormat.parse(dateFormat.format(cal.getTime()));
		return dateFormat.format(currentDate);
	}

	public boolean isEditable(String id)
	{
		WebElement element = driver.findElement(By.id(id));
		boolean isEditableValue=true;
		try
		{
			element.click();
			element.sendKeys("Test");
			isEditableValue=true;
		}
		catch(Exception ex)
		{
			isEditableValue=false;
		}

		return isEditableValue;
	}

	public String getTitleText(String id)
	{
		return driver.findElement(By.id(id)).getAttribute("title").trim();
	}

	public String getValueText(String path)
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			if(element!=null)
			{
				return element.getAttribute("value").trim();
			}
		}
		catch (Exception e) {
			return "Element is not available";
		}

		return "Element is not available";
	}

	public String getCurrentDate(String formate)
	{
		DateFormat dateFormat = new SimpleDateFormat(formate);
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		return dateFormat.format(date);
	}

	public boolean isElementClickable(String firstElementId, String exepctedElementId)
	{
		try
		{
			driver.findElement(By.id(firstElementId));
			idleTime(1000);
			return isElementDisplayed(exepctedElementId);
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	public void pressEscKey()
	{
		try
		{
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		}
		catch (AWTException e) 
		{
			System.out.println("Exception Occured while trying to press Esc key");
		}
	}

	public void pressRightKey()
	{
		try 
		{
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
		}
		catch (AWTException e) 
		{
			System.out.println("Exception Occured while trying to press Esc key");
		}
	}

	public String getAttribute(String path, String attribute) 
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			if(element!=null)
			{
				return element.getAttribute(attribute).trim();
			}
		}
		catch (Exception e) 
		{
			return "Element is not available";
		}

		return "Element is not available";
	}

	public void scrollToElement(String path) 
	{
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
			idleTime(2000);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public String getCurrentDateHourMin() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
		Calendar cal = Calendar.getInstance();
		Date currentDate = dateFormat.parse(dateFormat.format(cal.getTime()));
		return dateFormat.format(currentDate);
	}

	public boolean isElementPresent(String Xpath) {		
		try
		{
			WebElement element = driver.findElement(By.xpath(Xpath));
			if(element!=null)
			{
				return true;
			}
		}
		catch(Exception ex)
		{
			return false;
		}

		return false;
	}

	public void selectbyVisibletext(String Xpath, String text)
	{
		WebElement element = driver.findElement(By.xpath(Xpath));
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public String getRandomName()
	{
		String RANDCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrst";
		StringBuilder name = new StringBuilder();
		Random rnd = new Random();
		while (name.length() < 7)
		{ 
			int index = (int) (rnd.nextFloat() * RANDCHARS.length());
			name.append(RANDCHARS.charAt(index));
		}

		String newStr = name.toString();
		return newStr;
	}

	public int getRandomNumber()
	{
		Random rand = new Random();  
		int numbergenerated = rand.nextInt(1000); 
		return numbergenerated;
	}

	public boolean isElementSelected(String xPath) {
		try 
		{
			return driver.findElement(By.xpath(xPath)).isSelected();
		} 
		catch (Exception ex) 
		{
			return false;
		}
	}

	public int getCurrentMonth(String monthName) throws ParseException 
	{
		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	public void selectbyValue(String Xpath, String text)
	{
		WebElement element = driver.findElement(By.xpath(Xpath));
		Select sel = new Select(element);
		sel.selectByValue(text);
	}

	public String getfirstselectedoption(String Xpath)
	{
		WebElement element = driver.findElement(By.xpath(Xpath));
		Select sel = new Select(element);
		return sel.getFirstSelectedOption().toString().trim();
	}

	public String[] convertListWebElementToString()
	{
		List<WebElement> fields = driver.findElements(By.xpath("PropertyFieldsTextBox"));
		String []linkText =new String[fields.size()];
		int i=0;

		//Storing List elements text into String array
		for(WebElement a: fields)
		{
			linkText[i]=a.getText();
			i++;
		}

		return linkText;
	}

	public boolean dropDownDataVerification(String obtainedlist, String expectedlist) {
		List<WebElement> actual_list = driver.findElements(By.xpath(obtainedlist));
		String[] expected_list = expectedlist.split(",");
		boolean flag = false;

		for (int i = 0; i < actual_list.size(); i++) 
		{
			if (!expected_list[i].trim().contains(actual_list.get(i).getText().trim())) 
			{
				flag = false;
			} 
			else
			{
				flag = true;
			}
		}

		return flag;
	}

	public boolean dataVerification(List<String> obtainedlist, List<WebElement> expectedlist) {
		boolean flag=true;
		for (int i = 0; i < obtainedlist.size(); i++) 
		{
			if (!obtainedlist.get(i).trim().contains(expectedlist.get(i).getText().trim())) 
			{
				flag = false;
			} 
		}

		return flag;
	}
	
	public boolean isElementHighlightedinRed(String path){
		
		WebElement element=null;
		try
		{
			if (path.startsWith("//") || path.startsWith("(//"))
			{
				element = driver.findElement(By.xpath(path));
			}
			else
			{
				element = driver.findElement(By.id(path));
			}
	} 
		catch(Exception e) {
			e.printStackTrace();
		}
	
	//	String colr = element.getCssValue("color");
	/*      //getting background color attribute with getCssValue()
	      String bckgclr = element.getCssValue("background-color");
	    //  System.out.println(colr);
	      System.out.println(bckgclr);
	    Color.fromString(bckgclr); 
	     System.out.println( Color.fromString(bckgclr));
	   */  
	     
		
		String color = element.getCssValue("background");
		System.out.println(color);
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);
		
	
	     if(hex=="#d92e2c")
  	  return true;
	     else return false;
   
}

	public void scrollToHorizontal(String Xpath){
		WebElement element = driver.findElement(By.xpath(Xpath));
		element.click();
		Actions actions = new Actions(driver);

		int i = 0;
		while (i < 15)
		{
			actions.sendKeys(Keys.RIGHT).build().perform();;
			++i;
		} 
	} 
	
	

}
