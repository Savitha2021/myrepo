package applicationUtils;

import java.util.Properties;

import javax.ws.rs.NotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewFormulaUtils {

	// CONSTANTS
	static final String CREATEFORMULABUTTON = "Create Formula";
	static final String LABNOTEBOOKNO = "Lab Notebook No.*";
	static final String DESCRIPTION = "Description*";
	static final String FORMULATYPE = "Formula Type*";
	static final String CHASSISREGION = "Chassis Region*:";
	static final String PREMIXREGION = "Premix Region*";
	static final String CHASSIS = "Chassis";
	static final String PREMIX = "Premix";
	static final String ASSOCIATETOCHASSIS = "Associate to Chassis";
	static final String ASSOCIATETOPROJECT = "Associate to Project";
	static final String COPYFROMFORMULA = "Copy from Formula";
	static final String FORMULACUSTOMWORKFLOW = "Formula - Custom Workflow";
	static final String ENABLED = "Enabled";
	static final String DISABLED = "Disabled";

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	public static String RMID = "";
	public static String selectedoption = "";
	public static String FORMULAVALUE="";

	// CONSTRUCTOR
	public CreateNewFormulaUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
		applicationUtils = new ApplicationUtils(driver);
	}

	// METHODS
	public void clickButtonCreateNewFormulaPage(String btnName) 
	{
		if (btnName.equals(CREATEFORMULABUTTON))
		{
			applicationUtils.moveToElementClick(properties.getProperty("CreateFormulaButton"));
		}
		else if(btnName.equals("Cancel")) 
		{
			applicationUtils.moveToElementClick(String.format(properties.getProperty("ButtonText"),btnName));
		}

		applicationUtils.waitForLoadingImageDisappear();
	}

	public void fillAllMandetoryFieldsForCustomWorkflow() 
	{
		applicationUtils.enterText(properties.getProperty("LabNoteBookNumberTextBox"), "Automation LabnoteBook");
		applicationUtils.enterText(properties.getProperty("DescriptionTextBox"), "Automation Desc");		
	}

	public boolean verifyTheFieldNames(String fieldNames) 
	{
		boolean result = applicationUtils.getText(String.format(properties.getProperty("FieldsInCreateNewFMLPage"),fieldNames)).equals(fieldNames);
		applicationUtils.waitForLoadingImageDisappear();
		return result;
	}

	public boolean verifyCreateNewFormulaPageHeader() 
	{
		applicationUtils.waitForLoadingImageDisappear();
		return applicationUtils.isElementDisplayed(properties.getProperty("CreateNewFormulaPageHeader"));
	}

	public void enterRandomValueforFields(String field)
	{
		int value = applicationUtils.getRandomNumber();
		switch (field) {
		case LABNOTEBOOKNO:
			applicationUtils.enterText(properties.getProperty("LabNoteBookNumberTextBox"), Integer.toString(value));
			break;
		case DESCRIPTION:
			applicationUtils.enterText(properties.getProperty("DescriptionTextBox"), "Auto Testing");
			break;
		default:
			throw new NotSupportedException(field + " is not available");
		}
	}

	public boolean verifyTextFielddName(String fieldName) 
	{
		switch (fieldName) 
		{
		case LABNOTEBOOKNO:
			return applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), fieldName));
		case DESCRIPTION:
			return applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithTextArea"), fieldName));
		case ASSOCIATETOCHASSIS:
			return applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), fieldName));
		case ASSOCIATETOPROJECT:
			return applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), fieldName));
		case COPYFROMFORMULA:
			return applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithSelect"), fieldName));
		default:
			throw new NotSupportedException(fieldName + " is not available");
		}
	}

	public void selectValueforFields(String field, String value) 
	{		
		switch(field)
		{
		case FORMULATYPE:
			applicationUtils.selectbyVisibletext(properties.getProperty("FormulaType"), value);
			break;
		case CHASSISREGION:
			applicationUtils.selectbyVisibletext(properties.getProperty("ChassisRegion"), value);
			break;
		case PREMIXREGION:
			applicationUtils.selectbyVisibletext(properties.getProperty("PremixRegion"), value);
			break;
		default:
			throw new NotSupportedException(field + " is not available");
		}
	}

	public void enterValuesforMandatoryFields(String fmlType)
	{
		int value = applicationUtils.getRandomNumber();
		applicationUtils.enterText(properties.getProperty("LabNoteBookNumberTextBox"), Integer.toString(value));
		applicationUtils.enterText(properties.getProperty("DescriptionTextBox"), "Auto Testing");
		if (fmlType.equals(CHASSIS)) 
		{
			applicationUtils.selectbyVisibletext(properties.getProperty("ChassisRegion"),properties.getProperty("RegionVal"));
		}
		else if (fmlType.equals(PREMIX)) 
		{
			applicationUtils.selectbyVisibletext(properties.getProperty("PremixRegion"),properties.getProperty("RegionVal"));
		}
	}

	public boolean userVerifiesMandatoryFields(String fmlType) 
	{
		if (fmlType.equals(CHASSIS))
		{
			return applicationUtils.isElementPresent(properties.getProperty("FormulaType"))
					&& applicationUtils.isElementPresent(properties.getProperty("LabNoteBookNumberTextBox"))
					&& applicationUtils.isElementPresent(properties.getProperty("DescriptionTextBox"))
					&& applicationUtils.isElementPresent(properties.getProperty("ChassisRegion"));
		} 
		else if (fmlType.equals(PREMIX)) 
		{
			return applicationUtils.isElementPresent(properties.getProperty("FormulaType"))
					&& applicationUtils.isElementPresent(properties.getProperty("LabNoteBookNumberTextBox"))
					&& applicationUtils.isElementPresent(properties.getProperty("DescriptionTextBox"))
					&& applicationUtils.isElementPresent(properties.getProperty("PremixRegion"));
		}
		else
		{
			return applicationUtils.isElementPresent(properties.getProperty("FormulaType"))
					&& applicationUtils.isElementPresent(properties.getProperty("LabNoteBookNumberTextBox"))
					&& applicationUtils.isElementPresent(properties.getProperty("DescriptionTextBox"));
		}
	}

	public boolean userVerifiesNonMandatoryFields(String fmlType)
	{
		boolean flag = false;
		if (fmlType.equals(CHASSIS))
		{
			flag = applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), "Chassis Code"))
					&& applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithSelect"), "Chassis Category"))
					&& applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithSelect"), "Chassis Subcategory"))
					&& applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), "Copy from Formula"));
		}
		else if (fmlType.equals(PREMIX)) 
		{
			flag = applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), "Copy from Formula"));
		}
		else
		{
			flag = applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), "Associate to Project"))
					&& applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), "Associate to Chassis"))
					&& applicationUtils.isElementPresent(String.format(properties.getProperty("LabelWithInput"), "Copy from Formula"));
		}

		return flag && applicationUtils.isElementPresent(String.format(properties.getProperty("ButtonText"), "Cancel"))
				&& applicationUtils.isElementPresent(String.format(properties.getProperty("ButtonText"), "Create Formula"));
	}

	public boolean userVerifyValueOfFormulaType()
	{
		String formulaVal = applicationUtils.getValueText(String.format(properties.getProperty("LabelWithSelect"), "Formula Type*"));
		if(formulaVal.contentEquals("0"))
		{
			return true;
		}

		return false;
	}

	public boolean userVerifiesFormulaTypesForUserRole(String userRole)
	{
		if (userRole.equals("Formulator") || userRole.equals("RMCuser")) 
		{
			return applicationUtils.dropDownDataVerification(properties.getProperty("FormulaTypeDropdown_Option"),properties.getProperty("FormulaTypeOptions"));
		} 
		else if (userRole.equals("PEDFormulator")) 
		{
			return applicationUtils.dropDownDataVerification(properties.getProperty("FormulaTypeDropdown_Option"),properties.getProperty("PEDFormulaTypeOptions"));
		}
		else
		{
			return false;
		}
	}

	public boolean verifyFieldStatusCreateNewFormula(String field, String status)
	{
		switch(field) {
		case COPYFROMFORMULA:
			if(status.equals(ENABLED)) {
				return !applicationUtils.isElementPresent(properties.getProperty("CopyfromFormulaTextBox"));
			}else if(status.equals(DISABLED)){
				return applicationUtils.isElementPresent(properties.getProperty("CopyfromFormulaTextBox"));
			}
			break;
		default:
			throw new NotSupportedException(field+" field is Invalid");
		}
		return false;
	}
}