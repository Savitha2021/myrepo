package applicationUtils;

import java.text.ParseException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDAttributesUtils {

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	private HomeUtils homeUtils;
	private RMPrerequisiteUtils rMPrerequisiteUtils;

	// VARIABLES OF PROJECT SUBTAB
	static String projectID="";
	static String projectName="";
	static String eDRATProjectID="";
	static String projectDescription="";
	static String projectStatus="";
	static String projectLeader="";
	static String shipToTrade="";

	// VARIABLES OF PRODUCT SUBTAB
	static String productFunction="";
	static String deliverySystem="";
	static String keyClaims="";
	static String endUse="";
	static String endUser="";
	static String specificIntendedUserAge="";
	static String useCondition="";
	static String productType="";
	static String intendedDosagPerUnit="";
	static String frequencyOfUse="";

	// VARIABLES OF ASSOCIATED PRODUCTS
	static String productName="";
	static String brand="";
	static String region="";
	static String country="";
	static String legalProductCategory="";

	// VARIABLES OF FORMULA SUBTAB
	static String legacyFormula="";
	static String developmentSite="";
	static String manufacturingSite="";
	static String formulaDeviceSpecNo="";
	static String productSpec="";
	static String mfgWorkInstructionSpecNo="";
	static String sAPMaterialNumber="";
	static boolean associateToChassis=false;

	// CONSTRUCTOR
	public PDAttributesUtils(WebDriver driver, Properties elementProperties) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		properties = elementProperties;
		applicationUtils = new ApplicationUtils(driver);
		rMPrerequisiteUtils = new RMPrerequisiteUtils(driver,elementProperties);
		homeUtils = new HomeUtils(driver,elementProperties);
	}

	// METHODS
	public void navigatingToTabs(String tabName)
	{
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(String.format(properties.getProperty("TabNameOfFML"),tabName));
		applicationUtils.waitForLoadingImageDisappear();
	}

	public void enterTheValuesInProjectSubTabOfAttributesTab() throws ParseException
	{
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("ProjectSubTab"));
		applicationUtils.enterText(properties.getProperty("ProjectIDTextBox"), "123");
		applicationUtils.enterText(properties.getProperty("eDRATProjectNoTextBox"), "789");
		applicationUtils.enterText(properties.getProperty("ProjectNameTextBox"), "Test Project Name");
		applicationUtils.enterText(properties.getProperty("ProjectDescriptionTextBox"), "Test Project Description");
		applicationUtils.selectbyValue(properties.getProperty("ProjectStatusDropDown"), "Proposed".toUpperCase());
		applicationUtils.enterText(properties.getProperty("ProjectLeaderTextBox"), "Tese Project Leader");
		rMPrerequisiteUtils.selectDateRMWorkFlow(properties.getProperty("ShipToTradeCalenderButton"), properties.getProperty("ShipToTradeDateToBeSelected"));
		applicationUtils.waitForLoadingImageDisappear();
		homeUtils.userClicksOnButton("Save");
		applicationUtils.idleTime(1000);
		homeUtils.userClicksOnButton("OK");
	}

	public void enterTheValuesInProductSubTabOfAttributesTab()
	{
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("ProductSubTab"));
		applicationUtils.moveToElementClick(properties.getProperty("ProductfunctionDropdown"));
		applicationUtils.moveToElementClick(properties.getProperty("ProductFunctionDropDownSelectOption"));
		applicationUtils.moveToElementClick(properties.getProperty("DeliverysystemDropdown"));
		applicationUtils.moveToElementClick(properties.getProperty("DeliverySystemDropDownSelectOption"));
		applicationUtils.enterText(properties.getProperty("KeyclaimsTextBox"), "Test Key Claims");
		System.out.println("PLEASE CHECK "+properties.getProperty("ENDuseDropdown"));
		System.out.println(properties.getProperty("ENDuserDropdown"));
		applicationUtils.moveToElementClick(properties.getProperty("ENDuseDropdown"));
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("ENDuseDropDownSelectOption"));
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("ENDuserDropdown"));
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("ENDuserDropDownSelectOption"));
		applicationUtils.enterText(properties.getProperty("SpecificIntendedUserageTextBox"), "20");
		applicationUtils.selectbyVisibletext(properties.getProperty("UseconditionDropdown"), "Compromised");
		applicationUtils.selectbyVisibletext(properties.getProperty("ProducttypeDropdown"), "Rinse Off");
		applicationUtils.enterText(properties.getProperty("IntendedDosagperUnitTextBox"), "3");
		applicationUtils.selectbyVisibletext(properties.getProperty("FrequencyofUseDropDown"), "2/Day");
		homeUtils.userClicksOnButton("Save");
		homeUtils.userClicksOnButton("OK");
		applicationUtils.idleTime(2000);
	}

	public void enterTheValuesInAssocaitedProductSectionOfAttributesTab()
	{
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("AddProductsPlusIcon"));
		applicationUtils.moveToElementClick(properties.getProperty("ProductnameTextBox"));
		applicationUtils.enterText(properties.getProperty("ProductnameTextBox"), "Test Product Name");
		applicationUtils.moveToElementClick(properties.getProperty("BrandDropDown"));
		applicationUtils.enterText(properties.getProperty("BrandInput"), "Acuvue");
		applicationUtils.moveToElementClick(properties.getProperty("HighlightedValue"));
		applicationUtils.moveToElementClick(properties.getProperty("RegionDropDown"));
		applicationUtils.enterText(properties.getProperty("RegionInput"), "Latin America");
		applicationUtils.moveToElementClick(properties.getProperty("HighlightedValue"));
		applicationUtils.moveToElementClick(properties.getProperty("CountryDropDown"));
		applicationUtils.enterText(properties.getProperty("CountryInput"), "Andean Community");
		applicationUtils.moveToElementClick(properties.getProperty("HighlightedValue"));
		applicationUtils.moveToElementClick(properties.getProperty("LegalproductCategoryDropDown"));
		applicationUtils.enterText(properties.getProperty("LegalProductCategoryInput"), "Drug");
		applicationUtils.moveToElementClick(properties.getProperty("HighlightedValue"));
		homeUtils.userClicksOnButton("Save");
		homeUtils.userClicksOnButton("OK");
		applicationUtils.idleTime(2000);
	}

	public void enterTheValuesInFormulaSubTabOfAttributesTab()
	{
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("FormulaSubTab"));
		applicationUtils.enterText(properties.getProperty("LegacyFormulaNumberTextBox"), "Test Legacy 123");
		applicationUtils.moveToElementClick(properties.getProperty("DevelopmentSiteDropDownClick"));
		applicationUtils.enterText(properties.getProperty("DevelopmentSiteDropDownInput"), "India");
		applicationUtils.moveToElementClick(properties.getProperty("HighlightedValue"));
		applicationUtils.moveToElementClick(properties.getProperty("ManufacturingSiteDropDownClick"));
		applicationUtils.enterText(properties.getProperty("ManufacturingSiteDropDownInput"), "Pilar");
		applicationUtils.moveToElementClick(properties.getProperty("HighlightedValue"));
		applicationUtils.enterText(properties.getProperty("FormulaDeviceSpecNoTextBox"), "123");
		applicationUtils.enterText(properties.getProperty("ProductSpecTextBox"), "456");
		applicationUtils.enterText(properties.getProperty("MfgWorkInstructionSpecNoTextBox"), "789");
		applicationUtils.enterText(properties.getProperty("SAPMaterialNumberTextBox"), "012345");
		applicationUtils.moveToElementClick(properties.getProperty("AssociateToChassisCheckBox"));
		applicationUtils.idleTime(2000);
		homeUtils.userClicksOnButton("Save");
		homeUtils.userClicksOnButton("OK");
		applicationUtils.idleTime(2000);
	}

	public void storingTheValuesInProjectSubTabOfAttributesTab()
	{
		projectID=applicationUtils.getAttribute(properties.getProperty("ProjectIDTextBox"),"value");
		eDRATProjectID=applicationUtils.getAttribute(properties.getProperty("eDRATProjectNoTextBox"),"value");
		projectName=applicationUtils.getAttribute(properties.getProperty("ProjectNameTextBox"),"value");
		projectDescription=applicationUtils.getAttribute(properties.getProperty("ProjectDescriptionTextBox"),"value");
		projectStatus= applicationUtils.getfirstselectedoption(properties.getProperty("ProjectStatusDropDown"));
		projectLeader=applicationUtils.getAttribute(properties.getProperty("ProjectLeaderTextBox"),"value");
		shipToTrade=applicationUtils.getAttribute(properties.getProperty("ShipToTradeDate"),"value");
		System.out.println("Check this:--------------------------------------------------------");
		System.out.println(projectID+""+eDRATProjectID+""+projectName+""+projectDescription+""+endUser+""+projectStatus
				+""+projectLeader+""+shipToTrade);
	}

	public boolean compareTheProjectValuesInAttributesTab()
	{
		applicationUtils.idleTime(2000);
		System.out.println(projectID.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectIDTextBox"),"value"))
				+"" + eDRATProjectID.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("eDRATProjectNoTextBox"),"value"))
				+"" + projectName.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectNameTextBox"),"value"))
				+"" + projectDescription.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectDescriptionTextBox"),"value"))
				+"" + projectStatus.equalsIgnoreCase(applicationUtils.getfirstselectedoption(properties.getProperty("ProjectStatusDropDown")))
				+"" + projectLeader.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectLeaderTextBox"),"value"))
				+"" + shipToTrade.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ShipToTradeDate"),"value")));
		return projectID.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectIDTextBox"),"value"))
				&& eDRATProjectID.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("eDRATProjectNoTextBox"),"value"))
				&& projectName.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectNameTextBox"),"value"))
				&& projectDescription.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectDescriptionTextBox"),"value"))
				&& projectStatus.equalsIgnoreCase(applicationUtils.getfirstselectedoption(properties.getProperty("ProjectStatusDropDown")))
				&& projectLeader.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProjectLeaderTextBox"),"value"))
				&& shipToTrade.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ShipToTradeDate"),"value"));
	}

	public void storingTheValuesInProductSubTabOfAttributesTab()
	{
		applicationUtils.idleTime(2000);
		productFunction = applicationUtils.getText(properties.getProperty("ProductFunctionDropdownObtained"));
		deliverySystem= applicationUtils.getText(properties.getProperty("DeliverySystemsDropdownObtained"));
		keyClaims=applicationUtils.getAttribute(properties.getProperty("KeyclaimsTextBox"),"value");
		endUse=applicationUtils.getText(properties.getProperty("ENDuseDropdownObtained"));
		endUser=applicationUtils.getText(properties.getProperty("ENDuserDropdownObtained"));
		specificIntendedUserAge=applicationUtils.getAttribute(properties.getProperty("SpecificIntendedUserageTextBox"),"value");
		useCondition= applicationUtils.getfirstselectedoption(properties.getProperty("UseconditionDropdown"));
		System.out.println(properties.getProperty("UseconditionDropdown"));
		productType=applicationUtils.getfirstselectedoption(properties.getProperty("ProducttypeDropdown"));
		intendedDosagPerUnit=applicationUtils.getAttribute(properties.getProperty("IntendedDosagperUnitTextBox"),"value");
		System.out.println(properties.getProperty("FrequencyofUseDropDown"));
		frequencyOfUse=applicationUtils.getfirstselectedoption(properties.getProperty("FrequencyofUseDropDown"));
		productName=applicationUtils.getAttribute(properties.getProperty("ProductnameTextBox"),"value");
		brand=applicationUtils.getAttribute(properties.getProperty("BrandObtained"),"value");
		region=applicationUtils.getText(properties.getProperty("RegionObtained"));
		country=applicationUtils.getText(properties.getProperty("CountriesDropdownObtained"));
		legalProductCategory= applicationUtils.getText(properties.getProperty("LegalProductCategoryObtained"));
		System.out.println(productFunction+""+deliverySystem+""+keyClaims+""+endUse+""+endUser+""+specificIntendedUserAge+""+useCondition+""+productType+""+intendedDosagPerUnit+""+frequencyOfUse+""+productName+""+brand+""+region+""+ country+""+legalProductCategory);
	}

	public boolean compareTheProductValuesInAttributesTab()
	{
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("ProductSubTab"));	
		applicationUtils.idleTime(2000);
		return productFunction.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("ProductFunctionDropdownObtained")))
				&& deliverySystem.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("DeliverySystemsDropdownObtained")))
				&& keyClaims.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("KeyclaimsTextBox"),"value"))
				&& endUse.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("ENDuseDropdownObtained")))
				&& endUser.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("ENDuserDropdownObtained")))
				&& specificIntendedUserAge.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("SpecificIntendedUserageTextBox"),"value"))
				&& useCondition.equalsIgnoreCase(applicationUtils.getfirstselectedoption(properties.getProperty("UseconditionDropdown")))
				&& productType.equalsIgnoreCase(applicationUtils.getfirstselectedoption(properties.getProperty("ProducttypeDropdown")))
				&& intendedDosagPerUnit.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("IntendedDosagperUnitTextBox"),"value"))
				&& frequencyOfUse.equalsIgnoreCase(applicationUtils.getfirstselectedoption(properties.getProperty("FrequencyofUseDropDown")))
				&& productName.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProductnameTextBox"),"value"))
				&& brand.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("BrandObtained"),"value"))
				&& region.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("RegionObtained")))
				&& country.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("CountriesDropdownObtained")))
				&& legalProductCategory.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("LegalProductCategoryObtained")));
	}

	public void storingTheValueInFormulaSubTabOfAttributesTab()
	{
		legacyFormula=applicationUtils.getAttribute(properties.getProperty("LegacyFormulaNumberTextBox"),"value");
		developmentSite=applicationUtils.getText(properties.getProperty("DevelopmentSiteObtained"));
		manufacturingSite=applicationUtils.getText(properties.getProperty("ManufacturingSiteObtained"));
		formulaDeviceSpecNo=applicationUtils.getAttribute(properties.getProperty("FormulaDeviceSpecNoTextBox"),"value");
		productSpec=applicationUtils.getAttribute(properties.getProperty("ProductSpecTextBox"),"value");
		mfgWorkInstructionSpecNo=applicationUtils.getAttribute(properties.getProperty("MfgWorkInstructionSpecNoTextBox"),"value");
		sAPMaterialNumber=applicationUtils.getAttribute(properties.getProperty("SAPMaterialNumberTextBox"),"value");
		associateToChassis=applicationUtils.isElementSelected(properties.getProperty("AssociateToChassisCheckBox"));
		System.out.println(legacyFormula+""+developmentSite+""+manufacturingSite+""+formulaDeviceSpecNo+""+productSpec
				+""+mfgWorkInstructionSpecNo+""+sAPMaterialNumber+""+associateToChassis);
	}

	public boolean compareTheFormulaValuesInAttributesTab()
	{
		applicationUtils.idleTime(2000);
		applicationUtils.moveToElementClick(properties.getProperty("FormulaSubTab"));
		applicationUtils.idleTime(2000);
		return legacyFormula.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("LegacyFormulaNumberTextBox"),"value"))
				&& developmentSite.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("DevelopmentSiteObtained")))
				&& manufacturingSite.equalsIgnoreCase(applicationUtils.getText(properties.getProperty("ManufacturingSiteObtained")))
				&& formulaDeviceSpecNo.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("FormulaDeviceSpecNoTextBox"),"value"))
				&& productSpec.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("ProductSpecTextBox"),"value"))
				&& mfgWorkInstructionSpecNo.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("MfgWorkInstructionSpecNoTextBox"),"value"))
				&& sAPMaterialNumber.equalsIgnoreCase(applicationUtils.getAttribute(properties.getProperty("SAPMaterialNumberTextBox"),"value"))
				&& applicationUtils.isElementSelected(properties.getProperty("AssociateToChassisCheckBox"));		
	}
}