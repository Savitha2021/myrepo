package applicationUtils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDCommentsUtils {

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	static String technicalComments="";

	// CONSTRUCTOR
	public PDCommentsUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
		applicationUtils = new ApplicationUtils(driver);
	}

	// METHODS
	public void clickOnHeaderIcon(String headerIcon)
	{
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.clickOnElement(String.format(properties.getProperty("CommentsHeaderIcon"),headerIcon));
	}

	public void navigateToTechnicalCommentsTab()
	{
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("TechnicalCommentsHeaderName"));
	}

	public void enterTechnicalComments(String technicalCommentsValue)
	{
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("TechnicalCommentsTextBox"));
		applicationUtils.enterText(properties.getProperty("TechnicalCommentsTextBox"), technicalCommentsValue);
		technicalComments=technicalCommentsValue;
	}

	public void submitTechnicalComments()
	{
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveandClickonButton(properties.getProperty("SubmitButton"));
		applicationUtils.waitForLoadingImageDisappear();
	}

	public boolean verifySubmittedTechnicalComments()
	{
		applicationUtils.waitForLoadingImageDisappear();
		boolean result = applicationUtils.getText(properties.getProperty("CommentEditMode")).equals("Test Comments");
		applicationUtils.waitForLoadingImageDisappear();
		return result;
	}

}