




package applicationUtils;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;

public class CAPRIHomepageUtils {
	// CONSTANTS
	private final String IN_PROGRESS = "In-Progress";
	private final String NEW = "New";
	private final String REVIEWED = "Reviewed";
	private final String READY_FOR_APPROVAL = "Ready For Approval";
	private final String ROUTING_FOR_APPROVAL = "Routing For Approval";
	private final String APPROVED = "Approved";
	private final String PUBLISHED = "Published";

	private final String SETUP = "Set Up";
	private final String CONTENT = "Content";
	private final String COMPONENTS = "Components";
	private final String AGENCYBRIEF = "Agency Brief";
	private final String ARTWORK = "Artwork";

	// VARIABLES
	private Properties properties;
	WebDriver driver;
	static WebDriverWait wait;
	private ApplicationUtils applicationUtils;
	private SharedState sharedState;

	public static String _createdAssetId = "";
	public static List<String> _assetMetdada;
	public static String _assetGoLiveDate = "";
	public static String artworkId = "";
	public static String artworkName = "";
	public static String _assetType = "";
	public static String _searchCriteria = "";
	public static String artworkIdSaveAsNew = "";
	public static String APRId;
	

	// CONSTRUCTOR
	public CAPRIHomepageUtils(WebDriver driver, Properties properties, SharedState sharedState) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
		this.properties = properties;
		applicationUtils = new ApplicationUtils(driver);
		this.sharedState = sharedState;
	}

	// METHODS

	public void EnterSearchTextandSearch(String searchInput) throws TimeoutException {
		applicationUtils.clearandEnterText(properties.getProperty("GlobalSearch_inpFild"), searchInput);
		applicationUtils.clickonButton(properties.getProperty("GlobalSearch_btn"));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
		_searchCriteria = searchInput;

		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();

		if (applicationUtils.isElementPresent(properties.getProperty("ArtworktoHomeYespoup"))) {

			applicationUtils.moveToElementClick(properties.getProperty("ArtworktoHomeYespoup"));
			applicationUtils.waitforajaxQueryToProcess();
			applicationUtils.waitForLoadingImageDisappear();
		}
	}

	
	
	public void searchAPR(String APRID) throws TimeoutException, InterruptedException {
		applicationUtils.clearandEnterText(properties.getProperty("GlobalsearchTextbox"), APRID);
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(4000);
		applicationUtils.clickonButton(properties.getProperty("GlobalSearchButton"));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
		

	}

	public void OpenArtwork(String searchInput) throws TimeoutException, InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath(String.format(properties.getProperty("SearchedArtworkID"), searchInput)))));

		applicationUtils.clickonButton(String.format(properties.getProperty("SearchedArtworkID"), searchInput));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();

		Thread.sleep(5000);

	}

	public boolean NewArtwork(Map<String, String> _newArtworkoption) throws Exception {

		String Name = _newArtworkoption.get("Name");
		String Artwork = _newArtworkoption.get("Artwork");
		String type = _newArtworkoption.get("Type");
		String Phase = _newArtworkoption.get("Phase");
		String Selfcare = _newArtworkoption.get("Self Care");
		String Regions = _newArtworkoption.get("Regions");
		String Countries = _newArtworkoption.get("Countries");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("UserFullNameLabel"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("NewPlusIcon"))));

		applicationUtils.clickonButton(properties.getProperty("NewPlusIcon"));
		Thread.sleep(3000);
		applicationUtils.moveToElement(properties.getProperty("NewArtworkLink"));
		applicationUtils.moveToElementClick(properties.getProperty("NewArtworkLink"));
		applicationUtils.waitforajaxQueryToProcess();
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(3000);
		applicationUtils.enterText(properties.getProperty("ArtworkName"), Name);
		selectFromComboBox("ArtworkType", Artwork);
		applicationUtils.moveToElementClick(properties.getProperty("ArtworkType"));

		Thread.sleep(3000);
		try {
			applicationUtils.moveToElementClick(String.format(properties.getProperty("type"), type));

		} catch (Exception e) {

		}
		Thread.sleep(3000);
		try {
			applicationUtils.moveToElementClick(String.format(properties.getProperty("phase"), Phase));
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		try {
			applicationUtils.moveToElementClick(String.format(properties.getProperty("SelfCare"), Selfcare));
		} catch (Exception e) {

		}
		selectFromComboBox("Region", Regions);
		Thread.sleep(3000);
		selectFromComboBoxUl("Countries", "ValuesList", Countries);
		applicationUtils.moveToElementClick(properties.getProperty("ButtonContinue"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.waitforajaxQueryToProcess();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("ArtworkID_txt"))));

		artworkId = applicationUtils.getText(properties.getProperty("ArtworkID_txt"));
		artworkName = _newArtworkoption.get("Name");
		System.out.println("Artwork Id is created : " + artworkId);

		return applicationUtils.isElementDisplayed(properties.getProperty("ArtworkID_txt"));

	}

	public void selectFromComboBoxUl(String comboBoxPropertyName, String Values, String optionValue)
			throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(properties.getProperty(comboBoxPropertyName)));
		element.click();
		Thread.sleep(500);
		List<WebElement> options = driver.findElements(By.xpath(properties.getProperty(Values)));
		for (WebElement option : options) {
			String optionVal = option.getText();

			if (optionVal.contains(optionValue)) {
				Thread.sleep(400);
				option.click();
				break;
			}
		}

	}

	public void selectFromComboBox(String comboBoxPropertyName, String optionValue) throws Exception {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty(comboBoxPropertyName))));
		WebElement element = driver.findElement(By.xpath(properties.getProperty(comboBoxPropertyName)));
		element.click();
		List<WebElement> options = element.findElements(By.tagName("option"));
		for (WebElement option : options) {
			String optionVal = option.getText();

			if (optionVal.contains(optionValue)) {

				option.click();
				break;
			}
		}

	}

	public boolean VerifyTheStatus(String status) throws InterruptedException, TimeoutException {

		boolean Status = false;
		applicationUtils.scrollPagetoHome();
		Thread.sleep(2000);
		applicationUtils.scrollPagetoHome();
		switch (status) {

		case NEW:

			Status = applicationUtils
					.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus"), status));

		case IN_PROGRESS:

//                                                applicationUtils.MoveandClickonButton(properties
//                                                                                .getProperty("submit_btn"));
//                                                Thread.sleep(7000);
//                                                applicationUtils.waitforajaxQueryToProcess();
//                                                applicationUtils.waitForLoadingImageDisappear();
//
//                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By
//                                                                                .xpath(properties.getProperty("Ok_btn"))));
//                                                applicationUtils.MoveandClickonButton(properties
//                                                                                .getProperty("Ok_btn"));
			Thread.sleep(5000);
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(5000);

			Status = applicationUtils
					.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus"), status));
			break;
		case REVIEWED:

			Status = applicationUtils
					.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus"), status));
			break;
		case READY_FOR_APPROVAL:

			Status = applicationUtils.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus"), status))
					|| applicationUtils
							.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus1"), status));

			break;
		case ROUTING_FOR_APPROVAL:
			Status = applicationUtils.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus"), status)) ||

					applicationUtils.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus1"), status));

			break;
		case APPROVED:
			System.out.println(String.format(properties.getProperty("ArtworkStatus1"), status));

			Status = applicationUtils
					.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus1"), status));
			break;
		case PUBLISHED:
			System.out.println(String.format(properties.getProperty("ArtworkStatus1"), status));

			Status = applicationUtils
					.isElementDisplayed(String.format(properties.getProperty("ArtworkStatus1"), status));

		}

		return Status;

	}

	public boolean saveTabDetails(String tabName) throws TimeoutException, InterruptedException {

		applicationUtils.scrollPagetoHome();
		Thread.sleep(1000);
		boolean flag = false;

		switch (tabName) {

		case SETUP:
			applicationUtils.moveToElementClick(properties.getProperty("Save_btn"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Ok_btn"))));

			flag = applicationUtils.isElementDisplayed(properties.getProperty("Ok_btn"));
			applicationUtils.moveToElementClick(properties.getProperty("Ok_btn"));
			applicationUtils.waitforajaxQueryToProcess();
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(3000);
			break;

		case CONTENT:

			applicationUtils.moveToElementClick(properties.getProperty("ContentSaveButton"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Ok_btn"))));
			flag = applicationUtils.isElementDisplayed(properties.getProperty("Ok_btn"));
			applicationUtils.moveToElementClick(properties.getProperty("Ok_btn"));
			applicationUtils.waitforajaxQueryToProcess();
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(3000);
			break;

		case COMPONENTS:

			applicationUtils.moveToElementClick(properties.getProperty("CopSave_btn"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Ok_btn"))));
			flag = applicationUtils.isElementDisplayed(properties.getProperty("Ok_btn"));
			applicationUtils.moveToElementClick(properties.getProperty("Ok_btn"));
			applicationUtils.waitforajaxQueryToProcess();
			applicationUtils.waitForLoadingImageDisappear();
			Thread.sleep(3000);

			break;
		case AGENCYBRIEF:
			break;
		case ARTWORK:
			break;

		}
		return flag;
	}

	public void clickOnUsernameProfile() throws TimeoutException, InterruptedException {

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("UserFullNameLabel"))));

		applicationUtils.clickonButton(properties.getProperty("UserFullNameLabel"));
		Thread.sleep(2000);

	}

	public boolean verifyTheWebElement(String element) {

		return applicationUtils.isElementDisplayed(String.format(properties.getProperty("LinkText"), element));

	}

	public void clickOnWebElement(String element) throws TimeoutException {

		applicationUtils.clickonButton(String.format(properties.getProperty("LinkText"), element));
		applicationUtils.waitForLoadingImageDisappear();

	}

	public void navigateToChevron(String chevronName) throws InterruptedException {

		applicationUtils.scrollPagetoHome();
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(String.format(properties.getProperty("ArtworkChevron"), chevronName));
		applicationUtils.waitForLoadingImageDisappear();
	}

	public boolean saveAsCTE(Map<String, String> _saveAsCTEOptions) throws TimeoutException, InterruptedException {

		String task = _saveAsCTEOptions.get("Task");
		String name = _saveAsCTEOptions.get("Name");
		String reasonForChange = _saveAsCTEOptions.get("Reason For Change");

		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(3000);
		applicationUtils.scrollPagetoHome();
		applicationUtils.moveandClickonButton(properties.getProperty("ContentPageSaveAs"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(String.format(properties.getProperty("SaveAsTaskOpt"), task));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.enterText(properties.getProperty("SaveAsNameTxtbox"), name);
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("SaveAsReasonForChange"));
		Thread.sleep(3000);
		//applicationUtils.SelectDropDownValue(properties.getProperty("SaveAsReasonForChange"), reasonForChange);
		applicationUtils.waitForLoadingImageDisappear();
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.moveToElementClick(properties.getProperty("SaveAsContinue"));
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(8000);

		return applicationUtils.isElementDisplayed(properties.getProperty("ArtworkID_txt"));

	}

	public boolean saveAsNew(Map<String, String> _saveAsNewOptions) throws Exception {

		String task = _saveAsNewOptions.get("Task");
		String name = _saveAsNewOptions.get("Name");
		String artwork = _saveAsNewOptions.get("Artwork");
		String phase = _saveAsNewOptions.get("Phase");
		String selfcare = _saveAsNewOptions.get("Self Care");
		String regions = _saveAsNewOptions.get("Regions");
		String countries = _saveAsNewOptions.get("Countries");

		applicationUtils.scrollPagetoHome();
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(3000);
		applicationUtils.moveandClickonButton(properties.getProperty("ContentPageSaveAs"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(String.format(properties.getProperty("SaveAsTaskOpt"), task));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.enterText(properties.getProperty("SaveAsNameTxtbox"), name);
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElement(properties.getProperty("SaveAsArtworkDropdown"));
		Thread.sleep(3000);
		applicationUtils.selectbyValue(properties.getProperty("SaveAsArtworkDropdown"), artwork);
		Thread.sleep(3000);
		applicationUtils.moveToElementClick(String.format(properties.getProperty("phase"), phase));
		Thread.sleep(3000);
		applicationUtils.moveToElementClick(String.format(properties.getProperty("SelfCare"), selfcare));
		Thread.sleep(3000);
		selectFromComboBox("Region", regions);
		Thread.sleep(3000);
		selectFromComboBoxUl("Countries", "ValuesList", countries);
		applicationUtils.waitForLoadingImageDisappear();
		ReportScreenshots.getScreenshot(sharedState);
		applicationUtils.moveToElementClick(properties.getProperty("SaveAsContinue"));
		applicationUtils.waitForLoadingImageDisappear();
		Thread.sleep(5000);
		artworkIdSaveAsNew = applicationUtils.getText(properties.getProperty("ArtworkID_txt"));
		return applicationUtils.isElementDisplayed(properties.getProperty("ArtworkID_txt"));

	}

	public boolean verifySaveAsPopup(String saveAsType, List<String> _saveAsPopupFields) throws TimeoutException {
		boolean flag = false;

		if (saveAsType.equalsIgnoreCase("Change To Existing")) {

			applicationUtils.moveandClickonButton(properties.getProperty("ContentPageSaveAs"));
			applicationUtils.waitForLoadingImageDisappear();
			applicationUtils.moveToElementClick(String.format(properties.getProperty("SaveAsTaskOpt"), saveAsType));
			applicationUtils.waitForLoadingImageDisappear();

			for (int labelName = 1; labelName < _saveAsPopupFields.size(); labelName++) {

				if (applicationUtils.isElementDisplayed(String.format(properties.getProperty("LabelNameSaveAsPop"),
						_saveAsPopupFields.get(labelName)))) {
					flag = true;
				} else {
					flag = false;
					return flag;
				}

			}
			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.moveandClickonButton(properties.getProperty("SaveAsCancel"));
			applicationUtils.waitForLoadingImageDisappear();

		} else if (saveAsType.equalsIgnoreCase("New")) {

			applicationUtils.moveandClickonButton(properties.getProperty("ContentPageSaveAs"));
			applicationUtils.waitForLoadingImageDisappear();
			applicationUtils.moveToElementClick(String.format(properties.getProperty("SaveAsTaskOpt"), saveAsType));
			applicationUtils.waitForLoadingImageDisappear();

			if (applicationUtils.isElementDisplayed(
					String.format(properties.getProperty("LabelNameSaveAsPop"), _saveAsPopupFields.get(0)))
					&& applicationUtils.isElementDisplayed(
							String.format(properties.getProperty("LabelNameSaveAsPop"), _saveAsPopupFields.get(1)))
					&& applicationUtils.isElementDisplayed(
							String.format(properties.getProperty("LabelNameSaveAsPop"), _saveAsPopupFields.get(2)))
					&& applicationUtils.isElementDisplayed(
							String.format(properties.getProperty("LabelNameSaveAsPop"), _saveAsPopupFields.get(3)))
					&& applicationUtils.isElementDisplayed(
							String.format(properties.getProperty("SaveAsCountrieslabel"), _saveAsPopupFields.get(4)))
					&& applicationUtils.isElementDisplayed(
							String.format(properties.getProperty("LabelNameSaveAsPop"), _saveAsPopupFields.get(5)))) {

				flag = true;
			} else {
				flag = false;
				return flag;
			}

			ReportScreenshots.getScreenshot(sharedState);
			applicationUtils.moveandClickonButton(properties.getProperty("SaveAsCancel"));
			applicationUtils.waitForLoadingImageDisappear();

		}

		return flag;

	}

	public boolean openAndCopyReferenceArtFile() {

		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("LegacyArtworkTile"));
		applicationUtils.waitForLoadingImageDisappear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(String.format(properties.getProperty("ArtworkChevron"), "Artwork"))));
		applicationUtils.moveToElementClick(String.format(properties.getProperty("ArtworkChevron"), "Artwork"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("ReferenceArtCopyToClipboard"));
		applicationUtils.waitForLoadingImageDisappear();
		return applicationUtils.isElementDisplayed("//span[text()='OK']");

	}

	public void searchCoconLegacyV6() {

		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("SourceSystemFilter"));
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick("//span[text()='Cocoon-Original Version (V6)']");
		applicationUtils.waitForLoadingImageDisappear();
		applicationUtils.moveToElementClick(properties.getProperty("ApplyFilterBtn"));
		applicationUtils.waitForLoadingImageDisappear();

	}
	public boolean VerifyMode() { 
		if
		  (applicationUtils.isElementDisplayed(properties
		  .getProperty("ListMode")) &&
		  applicationUtils.isElementDisplayed(properties
		  .getProperty("TileMode")) &&
		  applicationUtils.isElementSelected(properties.getProperty("TileMode")))
		 
		  
		  return true;
		  
	else 
	{
		return false;
	}
}
	public boolean VerifyView() { 
		if
		  (applicationUtils.isElementDisplayed(properties
		  .getProperty("MyAPRs")) &&
		  applicationUtils.isElementDisplayed(properties
		  .getProperty("MyFavorites")) &&
		  applicationUtils.isElementDisplayed(properties
				  .getProperty("AllAPRs")) &&
		  applicationUtils.isElementSelected(properties.getProperty("MyAPRs")))
		 
		  
		  return true;
		  
	else 
	{
		return false;
	}
}
}
		  
	/* public boolean VerifyView() { switch (_viewType) { case MYASSETSVIEW: return
		  VerifyTilescount("MyAssetsHeaderCount"); case MYFAVORITESVIEW: return
		  VerifyTilescount("MyFavoritesHeaderCount"); case MYRECENTASSETSVIEW: return
		  VerifyTilescount("MyRecentAssetsHeaderCount"); case ALLASSETSVIEW: return
		  VerifyTilescount("AllAssetsHeaderCount"); default: return false; } }
		 

	
	  // METHODS public void ClickonTab(String tabName) throws TimeoutException {
	/*  switch (tabName) { case ASSETTAB: ClickonTabButton("AssetTab"); break; case
	  TASKSTAB: ClickonTabButton("TasksTab"); break; case SERVICEMAPTAB:
	  ClickonTabButton("ServiceMapTab"); break; default: throw new
	  java.lang.UnsupportedOperationException(tabName + " - is not available"); } }
	  
	  public void ClickonTabButton(String tabProperty) throws TimeoutException {
	  applicationUtils.MoveToElement(properties.getProperty(tabProperty));
	  applicationUtils.getjavascritExecutor() .executeScript(
	  "arguments[0].click();", driver.findElement(By.xpath(properties
	  .getProperty(tabProperty)))); applicationUtils.waitforajaxQueryToProcess();
	  applicationUtils.waitForLoadingImageDisappear();
	  applicationUtils.ThreadSleep(5000); }
	  
	  public boolean TabPageDisplayed(String tab) { switch (tab) { case ASSETTAB:
	  return applicationUtils.isElementDisplayed(properties
	  .getProperty("MyAssetsView")); case TASKSTAB: return
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("TasksWorksLabel")); case SERVICEMAPTAB: return false; default:
	  throw new java.lang.UnsupportedOperationException(tab +
	  " - page is not available"); } }
	  
	  public void ClickonView(String view) throws TimeoutException { _viewType =
	  view; switch (view) { case MYASSETSVIEW:
	  applicationUtils.ClickonButton(properties .getProperty("MyAssetsView"));
	  break; case MYFAVORITESVIEW: applicationUtils.ClickonButton(properties
	  .getProperty("MyFavoritesView")); break; case MYRECENTASSETSVIEW:
	  applicationUtils.ClickonButton(properties
	  .getProperty("MyRecentAssetsView")); break; case ALLASSETSVIEW:
	  applicationUtils.ClickonButton(properties .getProperty("AllAssetsView"));
	  break; default: throw new java.lang.UnsupportedOperationException(view +
	  " - is not available"); } }
	  
	  public void ClickOnMode(String mode) { _mode = mode; if (mode.equals("List"))
	  { applicationUtils.getjavascritExecutor().executeScript(
	  "arguments[0].click();", driver.findElement(By.xpath(properties
	  .getProperty("ListMode")))); } else {
	  applicationUtils.getjavascritExecutor().executeScript(
	  "arguments[0].click();", driver.findElement(By.xpath(properties
	  .getProperty("TileMode")))); } }
	  
	  p 
	  public boolean VerifyTilescount(String viewName) { String _getCountText =
	  applicationUtils.GetText(properties .getProperty(viewName)); int value =
	  Integer.parseInt(_getCountText.replaceAll("[^0-9]", "")); List<WebElement>
	  _assetOwner = driver.findElements(By.xpath(properties
	  .getProperty("TileAssetOwner"))); boolean _assetOwnerVerify = true; for (int
	  i = 0; i < _assetOwner.size(); i++) { if
	  (!_assetOwner.get(i).getText().toUpperCase()
	  .contains(LoginLogoutUtils._userName.toUpperCase())) { _assetOwnerVerify =
	  false; } }
	  
	  if (value < 0) { _assetOwnerVerify = false; }
	  
	  return _assetOwnerVerify; }
	  
	  public void ClickOnTileinHomePage() throws TimeoutException {
	  applicationUtils.MoveToElement(properties
	  .getProperty("TileAssetsNameLinks"));
	  applicationUtils.getjavascritExecutor().executeScript(
	  "arguments[0].click();", driver.findElement(By.xpath(properties
	  .getProperty("TileAssetsNameLinks"))));
	  applicationUtils.waitforajaxQueryToProcess();
	  applicationUtils.waitForLoadingImageDisappear();
	  applicationUtils.ThreadSleep(5000); }
	  
	  public boolean VerifyAssetisDisplayedbasedonStatus() { String _assetStatus =
	  applicationUtils.GetText(properties .getProperty("AssetStatus"));
	  
	  switch (_assetStatus) { case INITIATINGSTATUS: return
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetInitiateTabactive")); case PLANNINGSTATUS: return
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetPlanandReadinessTabactive")); case INDEVSTATUS: return
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetDevelopmentandTestingTabactive")); case DEPLOYINGSTATUS:
	  return applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetDeployandReleaseTabactive")); case INOPERATIONSTATUS:
	  return applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetOperateTabactive")); case ARCHIVEDSTATUS: return
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetArchiveTabactive")); case ONHOLDSTATUS: // TODO: ON HOLD
	  Status is not implemented yet return false; case CANCELLEDSTATUS: // TODO:
	  CANCELLED Status is not implemented yet return false; default: throw new
	  java.lang.UnsupportedOperationException("" + " - is not available"); } }
	  
	  public void ClickonArrowMarkButton() throws TimeoutException {
	  applicationUtils.MoveToElement(properties
	  .getProperty("FilterCollapseArrow"));
	  applicationUtils.getjavascritExecutor().executeScript(
	  "arguments[0].click();", driver.findElement(By.xpath(properties
	  .getProperty("FilterCollapseArrow"))));
	  applicationUtils.waitforajaxQueryToProcess();
	  applicationUtils.waitForLoadingImageDisappear();
	  applicationUtils.ThreadSleep(2000); }
	  
	  public boolean VerifyFilterCollapsed() { boolean _filterCollapsedVerify =
	  false;
	  
	  if (!applicationUtils.isElementDisplayed(properties
	  .getProperty("MyAssetsView")) &&
	  !applicationUtils.isElementDisplayed(properties
	  .getProperty("MyFavoritesView")) &&
	  !applicationUtils.isElementDisplayed(properties .getProperty("TileMode")) &&
	  !applicationUtils.isElementDisplayed(properties .getProperty("ListMode")) &&
	  !applicationUtils.isElementDisplayed(properties .getProperty("StatusFilter"))
	  && !applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetTypeFilter")) &&
	  !applicationUtils.isElementDisplayed(properties .getProperty("GxpFilter"))) {
	  _filterCollapsedVerify = true; }
	  
	  return _filterCollapsedVerify; }
	  
	  public boolean VerifyFilterExpanded() { boolean _filterExpandedVerify =
	  false;
	  
	  if (applicationUtils.isElementDisplayed(properties
	  .getProperty("MyAssetsView")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("MyFavoritesView")) &&
	  applicationUtils.isElementDisplayed(properties .getProperty("TileMode")) &&
	  applicationUtils.isElementDisplayed(properties .getProperty("ListMode")) &&
	  applicationUtils.isElementDisplayed(properties .getProperty("StatusFilter"))
	  && applicationUtils.isElementDisplayed(properties
	  .getProperty("AssetTypeFilter")) &&
	  applicationUtils.isElementDisplayed(properties .getProperty("GxpFilter"))) {
	  _filterExpandedVerify = true; }
	  
	  return _filterExpandedVerify; }
	  
	  public void ClickonSortByButton() throws TimeoutException {
	  applicationUtils.MoveToElement(properties.getProperty("SortByLabel"));
	  applicationUtils.MoveToElementClick(properties .getProperty("SortByLabel"));
	  applicationUtils.waitforajaxQueryToProcess();
	  applicationUtils.waitForLoadingImageDisappear();
	  applicationUtils.ThreadSleep(2000); }
	  
	  public void SortByOption(String sortByOption, String sortOrder) throws
	  TimeoutException { _sortOrder = sortOrder; _sortByOption = sortByOption;
	  
	  switch (sortByOption) { case CMDBIDSORT:
	  applicationUtils.MoveandClickonButton(properties
	  .getProperty("SortCMDBIDOption")); break; case STATUSSORT:
	  applicationUtils.MoveandClickonButton(properties
	  .getProperty("SortStatusOption")); break; case CRITICALITYSORT:
	  applicationUtils.MoveandClickonButton(properties
	  .getProperty("SortCriticalityOption")); break; case AMIDSORT:
	  applicationUtils.MoveandClickonButton(properties
	  .getProperty("SortAMIDOption")); break; case CREATIONDATESORT:
	  applicationUtils.MoveandClickonButton(properties
	  .getProperty("SortCreationDateOption")); break; default: throw new
	  java.lang.UnsupportedOperationException(sortByOption +
	  " - is not available"); }
	  
	  SortByOrder(sortOrder); }
	  
	  public void SortByOrder(String order) throws TimeoutException { if
	  (order.equals("ASC")) { if (applicationUtils.isElementDisplayed(properties
	  .getProperty("SortDownArrow"))) { applicationUtils.ClickonButton(properties
	  .getProperty("SortDownArrow")); } } else { if
	  (applicationUtils.isElementDisplayed(properties .getProperty("SortUpArrow")))
	  { applicationUtils.ClickonButton(properties .getProperty("SortUpArrow")); } }
	  }
	  
	  public boolean AscDscOrder(String xpath, String order) { boolean _flag =
	  true; List<WebElement> _elements = driver.findElements(By.xpath(xpath));
	  
	  if (_elements.size() < 2) { throw new
	  java.lang.UnsupportedOperationException(
	  "Tiles size is small. Sorting cannot be done"); }
	  
	  ArrayList<String> _data = new ArrayList<String>();
	  
	  for (int i = 0; i < _elements.size(); i++) {
	  _data.add(_elements.get(i).getText().trim()); }
	  
	  if (order.equals("ASC")) { Collections.sort(_data); } else {
	  Collections.sort(_data, Collections.reverseOrder()); }
	  
	  for (int j = 0; j < _elements.size(); j++) { if
	  (!_elements.get(j).getText().trim().equals(_data.get(j))) { _flag = false; }
	  }
	  
	  return _flag; }
	  
	  public boolean AscDscOrderCritical(String xpath, String order) throws
	  ParseException { boolean _flag = true; List<WebElement> _elements =
	  driver.findElements(By.xpath(xpath));
	  
	  if (_elements.size() < 2) { throw new
	  java.lang.UnsupportedOperationException(
	  "Tiles size is small. Sorting cannot be done"); }
	  
	  ArrayList<String> _data = new ArrayList<String>(); ArrayList<String> _data1 =
	  new ArrayList<String>();
	  
	  for (int i = 0; i < _elements.size(); i++) { if
	  (!_elements.get(i).getText().trim().equals("")) {
	  _data.add(_elements.get(i).getText().trim()); } } _data1 = _data; if
	  (order.equals("ASC")) {
	  
	  Collections.sort(_data); } else { Collections.sort(_data,
	  Collections.reverseOrder()); }
	  
	  for (int j = 0; j < _data1.size(); j++) {
	  
	  if (!_data1.get(j).equals(_data.get(j))) { _flag = false; } }
	  
	  return _flag; }
	  
	  public boolean AscDscOrderStatus(String xpath, String order) throws
	  ParseException { boolean _flag = true; List<WebElement> _elements =
	  driver.findElements(By.xpath(xpath));
	  
	  if (_elements.size() < 2) { throw new
	  java.lang.UnsupportedOperationException(
	  "Tiles size is small. Sorting cannot be done"); }
	  
	  ArrayList<String> _data = new ArrayList<String>(); ArrayList<String>
	  _dataWithoutSpace = new ArrayList<String>(); for (int i = 0; i <
	  _elements.size(); i++) { try { String[] s =
	  _elements.get(i).getText().split(" "); _dataWithoutSpace.add(s[0] +
	  s[1].toLowerCase()); } catch (Exception e) {
	  _dataWithoutSpace.add(_elements.get(i).getText().toLowerCase()); } _data =
	  _dataWithoutSpace;
	  
	  }
	  
	  if (order.equals("ASC")) {
	  
	  Collections.sort(_data); System.out.println(_data); } else {
	  Collections.sort(_data, Collections.reverseOrder()); }
	  
	  for (int j = 0; j < _dataWithoutSpace.size(); j++) { if
	  (!_dataWithoutSpace.get(j).equals(_data.get(j))) { _flag = false; } }
	  
	  return _flag; }
	  
	  public boolean AscDscOrderCreationDate(String xpath, String order) throws
	  ParseException, TimeoutException, InterruptedException { List<WebElement>
	  _elements = driver.findElements(By.xpath(xpath)); if (_elements.size() < 2) {
	  throw new java.lang.UnsupportedOperationException(
	  "Tiles size is small. Sorting cannot be done"); } ArrayList<String> _AMID =
	  new ArrayList<String>(); for (int k = 0; k < 14; k++) {
	  _AMID.add(_elements.get(k).getText());
	  
	  } System.out.println(_AMID); applicationUtils.MoveandClickonButton(properties
	  .getProperty("ListMode")); ArrayList<String> _data = new ArrayList<String>();
	  boolean _flag = true; if (order.equals("ASC")) {
	  
	  if (applicationUtils.isElementDisplayed(properties
	  .getProperty("ListCreationDateDecendingarrow"))) {
	  applicationUtils.ClickonButton(properties
	  .getProperty("ListCreationDateDecendingarrow")); } } else { if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("ListCreationDateAcendingarrow"))) {
	  applicationUtils.ClickonButton(properties
	  .getProperty("ListCreationDateAcendingarrow")); } } Thread.sleep(5000);
	  ArrayList<String> _CreationData = new ArrayList<String>();
	  applicationUtils.ThreadSleep(2000);
	  
	  for (int i = 0; i < 14; i++) { _CreationData .add(applicationUtils
	  .GetTitleText("//div[@role='presentation']//div[@row-index='" + i +
	  "']//div[@col-id='createdDate'][@role='gridcell']//div"));
	  
	  }
	  
	  ArrayList<String> _dataSorted = new ArrayList<String>(_data);
	  
	  if (order.equals("ASC")) { Collections.sort(_dataSorted); } else {
	  Collections.sort(_dataSorted, Collections.reverseOrder()); }
	  
	  if (_dataSorted.equals(_CreationData)) {
	  
	  for (int i = 0; i < 14; i++) { applicationUtils
	  .MoveToElement("//div[@role='presentation']//div[@row-index='" + i +
	  "']//div[@col-id='elementData.assetDisplayId'][@role='gridcell']");
	  _data.add(applicationUtils
	  .GetTitleText("//div[@role='presentation']//div[@row-index='" + i +
	  "']//div[@col-id='elementData.assetDisplayId'][@role='gridcell']")); }
	  System.out.println(_data); if (_AMID.equals(_data)) { _flag = true;
	  
	  } }
	  
	  return _flag; }
	  
	  public boolean VerifySorting() throws TimeoutException, ParseException,
	  InterruptedException { switch (_sortByOption) { case CMDBIDSORT: // TODO:
	  CMDB ID SORT is not implemeted yet return false; case STATUSSORT: return
	  AscDscOrderStatus(properties.getProperty("TileAssetStatus"), _sortOrder);
	  case CRITICALITYSORT: return AscDscOrderCritical(
	  properties.getProperty("TileAssetCriticality"), _sortOrder); case AMIDSORT:
	  return AscDscOrder(properties.getProperty("TileAssetAMID"), _sortOrder); case
	  CREATIONDATESORT: return AscDscOrderCreationDate(
	  properties.getProperty("TileAssetAMID"), _sortOrder);
	  
	  default: throw new java.lang.UnsupportedOperationException(_sortByOption +
	  " - is not available"); } }
	  
	  public void MarkTileAsFavorite() throws TimeoutException { if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("TileNonFavorite"))) { applicationUtils.ClickonButton(properties
	  .getProperty("TileNonFavorite")); } }
	  
	  public void DeMarkTileAsFavorite() throws TimeoutException { if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("TileFavorite"))) { applicationUtils.ClickonButton(properties
	  .getProperty("TileFavorite")); } }
	  
	  public void MarkListAsFavorite() throws TimeoutException {
	  applicationUtils.MoveToElement(properties .getProperty("ListNonFavorite"));
	  applicationUtils.ThreadSleep(2000); if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("ListNonFavorite"))) { applicationUtils.ClickonButton(properties
	  .getProperty("ListNonFavorite")); } }
	  
	  public boolean VerifyListMarkedAsFavorite() throws TimeoutException {
	  applicationUtils.MoveToElement(properties.getProperty("ListFavorite"));
	  applicationUtils.ThreadSleep(2000); if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("ListFavorite"))) { return true; }
	  
	  return false; }
	  
	  public void DeMarkListAsFavorite() throws TimeoutException {
	  applicationUtils.MoveToElement(properties.getProperty("ListFavorite"));
	  applicationUtils.ThreadSleep(2000); if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("ListFavorite"))) { applicationUtils.ClickonButton(properties
	  .getProperty("ListFavorite")); } }
	  
	  public boolean VerifyListMarkedAsDeFavorite() throws TimeoutException {
	  applicationUtils.MoveToElement(properties .getProperty("ListNonFavorite"));
	  applicationUtils.ThreadSleep(2000); if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("ListNonFavorite"))) { return true; }
	  
	  return false; }
	  
	  public void ClickonColumnandSortinOrder(String ColumnName, String order) {
	  _listColumnName = ColumnName; _listsortByOption = order;
	  
	  switch (ColumnName) { case ASSETNAMELISTCOLUMN:
	  ClickonListColumnHeaderAscDscOrder("ListColumnAssetName", order); break; case
	  CRITICALITYLISTCOLUMN: // TODO: Criticality is not implemeted yet break; case
	  STATUSLISTCOLUMN: ClickonListColumnHeaderAscDscOrder("ListColumnStatus",
	  order); break; case PERMITLISTCOLUMN: // TODO: Permit is not implemeted yet
	  break; case AMIDLISTCOLUMN:
	  ClickonListColumnHeaderAscDscOrder("ListColumnAMID", order); break; case
	  CMDBIDLISTCOLUMN: // TODO: CMDB ID is not implemeted yet break; case
	  TYPELISTCOLUMN: ClickonListColumnHeaderAscDscOrder("ListColumnType", order);
	  break; case ASSETOWNERLISTCOLUMN:
	  ClickonListColumnHeaderAscDscOrder("ListColumnAssetOwner", order); break;
	  case GOLIVEDATELISTCOLUMN:
	  ClickonListColumnHeaderAscDscOrder("ListColumnGoLiveDate", order); break;
	  case CREATIONDATELISTCOLUMN:
	  ClickonListColumnHeaderAscDscOrder("ListColumnCreatioDate", order); break;
	  default: throw new java.lang.UnsupportedOperationException(ColumnName +
	  " - is not available"); } }
	  
	  public void ClickonListColumnHeaderAscDscOrder(String xpath, String order) {
	  applicationUtils.MoveToElement(properties.getProperty(xpath));
	  applicationUtils.MoveToElementClick(properties.getProperty(xpath));
	  
	  if (order.equals("ASC")) { String _ascPath = properties.getProperty(xpath) +
	  "/..//span[@ref='eSortAsc']";
	  
	  while (!applicationUtils.isElementDisplayed(_ascPath)) {
	  applicationUtils.MoveToElement(properties.getProperty(xpath));
	  applicationUtils.MoveToElementClick(properties .getProperty(xpath)); } } else
	  { String _descPath = properties.getProperty(xpath) +
	  "/..//span[@ref='eSortDesc']";
	  
	  while (!applicationUtils.isElementDisplayed(_descPath)) {
	  applicationUtils.MoveToElement(properties.getProperty(xpath));
	  applicationUtils.MoveToElementClick(properties .getProperty(xpath)); } } }
	  
	  public boolean VerifyListSorting() { switch (_listColumnName) { case
	  ASSETNAMELISTCOLUMN: return AscDscOrderByAttribute(
	  properties.getProperty("ListColumnAsssetData"), _listsortByOption,
	  properties.getProperty("AssetNameColumnID")); // return //
	  AscDscOrderByAttribute
	  (properties.getProperty("ListColumnAsssetData"),_listsortByOption ,"title");
	  case CRITICALITYLISTCOLUMN: // TODO: Criticality is not implemeted yet break;
	  case STATUSLISTCOLUMN: return AscDscOrderByAttribute(
	  properties.getProperty("ListColumnStatusData"), _listsortByOption,
	  properties.getProperty("StatusColumnID")); case PERMITLISTCOLUMN: // TODO:
	  Permit is not implemeted yet break; case AMIDLISTCOLUMN: return
	  AscDscOrderByAttribute( properties.getProperty("ListColumnAMIDData"),
	  _listsortByOption, properties.getProperty("AMIDColumnID")); case
	  CMDBIDLISTCOLUMN: // TODO: CMDB ID is not implemeted yet break; case
	  TYPELISTCOLUMN: return AscDscOrderByAttribute(
	  properties.getProperty("ListColumnTypeData"), _listsortByOption,
	  properties.getProperty("TypeColumnID")); case ASSETOWNERLISTCOLUMN: return
	  AscDscOrderByAttribute( properties.getProperty("ListColumnAssetOwnerData"),
	  _listsortByOption, properties.getProperty("AssetOwnerColumnID")); case
	  GOLIVEDATELISTCOLUMN: return AscDscOrderByAttribute(
	  properties.getProperty("ListColumnGoLiveDateData"), _listsortByOption,
	  properties.getProperty("GoLiveDateColumnID")); case CREATIONDATELISTCOLUMN:
	  return AscDscOrderByAttribute(
	  properties.getProperty("ListColumnCreationDateData"), _listsortByOption,
	  properties.getProperty("CreationDateColumnID")); default: throw new
	  java.lang.UnsupportedOperationException(_listColumnName +
	  " - is not available"); }
	  
	  return false; }
	  
	  public boolean AscDscOrderByAttribute(String xpath, String order, String
	  ColumnIDName) { List<WebElement> _elements =
	  driver.findElements(By.xpath(xpath));
	  
	  if (_elements.size() < 2) { throw new
	  java.lang.UnsupportedOperationException(
	  "Tiles size is small. Sorting cannot be done"); }
	  
	  ArrayList<String> _data = new ArrayList<String>();
	  applicationUtils.ThreadSleep(2000);
	  
	  for (int i = 0; i <= 20; i++) { if
	  (ColumnIDName.equals("elementData.plannedGoLiveDate") ||
	  ColumnIDName.equals("createdDate")) { _data.add(applicationUtils
	  .GetTitleText("//div[@role='presentation']//div[@row-index='" + i +
	  "']//div[@col-id='" + ColumnIDName + "'][@role='gridcell']//div")); } else {
	  _data.add(applicationUtils
	  .GetTitleText("//div[@role='presentation']//div[@row-index='" + i +
	  "']//div[@col-id='" + ColumnIDName + "'][@role='gridcell']")); } }
	  
	  ArrayList<String> _dataSorted = new ArrayList<String>(_data);
	  
	  if (order.equals("ASC")) { Collections.sort(_dataSorted); } else {
	  Collections.sort(_dataSorted, Collections.reverseOrder()); }
	  
	  if (_dataSorted.equals(_data)) { return true; }
	  
	  return false; }
	  
	  public void ClickonEditColumnButton() throws TimeoutException {
	  applicationUtils.MoveToElement(properties
	  .getProperty("EditColumnsDropDown"));
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("EditColumnsDropDown"));
	  applicationUtils.waitforajaxQueryToProcess();
	  applicationUtils.waitForLoadingImageDisappear();
	  applicationUtils.ThreadSleep(2000); }
	  
	  public boolean ValidateEditColumnOptionsDisplayed( List<String>
	  editColumnOptions) { List<WebElement> _uiColumnOptionsList;
	  
	  _uiColumnOptionsList = driver.findElements(By.xpath(properties
	  .getProperty("EditColumnOptionsList")));
	  
	  boolean _validateOptions = true; for (int i = 0; i <
	  editColumnOptions.size(); i++) { if
	  (!editColumnOptions.get(i).toString().trim()
	  .equals(_uiColumnOptionsList.get(i).getText().trim())) { _validateOptions =
	  false; } }
	  
	  return _validateOptions; }
	  
	  public void SelectColumnHeaderCheckbox(String columnName) throws
	  TimeoutException { String _xpath =
	  properties.getProperty("EditColumnCheckboxList"); _columnName = columnName;
	  applicationUtils.ScrollPagetoEnd();
	  
	  switch (columnName) { case FAVORITESCOLUMNHEADER: throw new
	  java.lang.UnsupportedOperationException(columnName +
	  " - is default coulmn, cannot be checked or unchecked"); case
	  ASSETNAMECOLUMNHEADER: throw new
	  java.lang.UnsupportedOperationException(columnName +
	  " - is default coulmn, cannot be checked or unchecked"); case
	  CRITICALITYCOLUMNHEADER: applicationUtils.SelectCheckBox("(" + _xpath +
	  ")[3]"); break; case STATUSCOLUMNHEADER: applicationUtils.SelectCheckBox("("
	  + _xpath + ")[4]"); break; case PERMITCOLUMNHEADER:
	  applicationUtils.SelectCheckBox("(" + _xpath + ")[5]"); break; case
	  AMIDCOLUMNHEADER: applicationUtils.SelectCheckBox("(" + _xpath + ")[6]");
	  break; case CMDBIDCOLUMNHEADER: applicationUtils.SelectCheckBox("(" + _xpath
	  + ")[7]"); break; case TYPECOLUMNHEADER: applicationUtils.SelectCheckBox("("
	  + _xpath + ")[8]"); break; case ASSETOWNERCOLUMNHEADER:
	  applicationUtils.SelectCheckBox("(" + _xpath + ")[9]"); break; case
	  GOLIVEDATECOLUMNHEADER: applicationUtils.SelectCheckBox("(" + _xpath +
	  ")[10]"); break; case CREATIONDATECOLUMNHEADER:
	  applicationUtils.SelectCheckBox("(" + _xpath + ")[11]"); break; case
	  PRIVACYCLASSIFICATIONCOLUMNHEADER: applicationUtils.SelectCheckBox("(" +
	  _xpath + ")[12]"); break; case GXPCOLUMNHEADER:
	  applicationUtils.SelectCheckBox("(" + _xpath + ")[13]"); break; case
	  SOXCOLUMNHEADER: applicationUtils.SelectCheckBox("(" + _xpath + ")[14]");
	  break; case LEGALHOLDCOLUMNHEADER: applicationUtils.SelectCheckBox("(" +
	  _xpath + ")[15]"); break; case PRODUCTLINECOLUMNHEADER:
	  applicationUtils.SelectCheckBox("(" + _xpath + ")[16]"); break; default:
	  throw new java.lang.UnsupportedOperationException(columnName +
	  " - is not available"); }
	  
	  ClickonEditColumnButton(); }
	  
	  public void UnSelectColumnHeaderCheckbox(String columnName) throws
	  TimeoutException { String _xpath =
	  properties.getProperty("EditColumnCheckboxList"); _columnName = columnName;
	  applicationUtils.ScrollPagetoEnd();
	  
	  switch (columnName) { case FAVORITESCOLUMNHEADER: throw new
	  java.lang.UnsupportedOperationException(columnName +
	  " - is default coulmn, cannot be checked or unchecked"); case
	  ASSETNAMECOLUMNHEADER: throw new
	  java.lang.UnsupportedOperationException(columnName +
	  " - is default coulmn, cannot be checked or unchecked"); case
	  CRITICALITYCOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath +
	  ")[3]"); break; case STATUSCOLUMNHEADER:
	  applicationUtils.UnSelectCheckBox("(" + _xpath + ")[4]"); break; case
	  PERMITCOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath + ")[5]");
	  break; case AMIDCOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath
	  + ")[6]"); break; case CMDBIDCOLUMNHEADER:
	  applicationUtils.UnSelectCheckBox("(" + _xpath + ")[7]"); break; case
	  TYPECOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath + ")[8]");
	  break; case ASSETOWNERCOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" +
	  _xpath + ")[9]"); break; case GOLIVEDATECOLUMNHEADER:
	  applicationUtils.UnSelectCheckBox("(" + _xpath + ")[10]"); break; case
	  CREATIONDATECOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath +
	  ")[11]"); break; case PRIVACYCLASSIFICATIONCOLUMNHEADER:
	  applicationUtils.UnSelectCheckBox("(" + _xpath + ")[12]"); break; case
	  GXPCOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath + ")[13]");
	  break; case SOXCOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath +
	  ")[14]"); break; case LEGALHOLDCOLUMNHEADER:
	  applicationUtils.UnSelectCheckBox("(" + _xpath + ")[15]"); break; case
	  PRODUCTLINECOLUMNHEADER: applicationUtils.UnSelectCheckBox("(" + _xpath +
	  ")[16]"); break; default: throw new
	  java.lang.UnsupportedOperationException(columnName + " - is not available");
	  }
	  
	  ClickonEditColumnButton(); }
	  
	  public boolean VerifyColumnDisplayedinListHeader() { List<WebElement>
	  _columnList = driver.findElements(By.xpath(properties
	  .getProperty("ListColumnAll")));
	  
	  boolean _displayed = false; for (int i = 0; i < _columnList.size(); i++) { if
	  (_columnName.equals(_columnList.get(i).getText().trim())) { _displayed =
	  true; break; } }
	  
	  return _displayed; }
	  
	  public boolean VerifyCreateNewAssetPopupFields() { if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupHeadingLabel")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupAssetNameText")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupAssetTypeText")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupSector")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupGoLivedateDate")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupExpectedLifeofAssetInput")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupCancelButton")) &&
	  !applicationUtils.isElementDisplayed(properties .getProperty("")) &&
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupContinueButton"))) { return true; }
	  
	  return false; }
	  
	  public void CreateAsset(List<String> assetData) throws ParseException {
	  _assetMetdada = assetData;
	  
	  if (!assetData.get(0).toString().isEmpty()) { applicationUtils.EnterText(
	  properties.getProperty("NewAssetPopupAssetNameText"),
	  assetData.get(0).toString()); }
	  
	  if (!assetData.get(1).toString().isEmpty()) {
	  SelectTypeOfAsset(assetData.get(1).toString()); }
	  
	  if (!assetData.get(2).toString().isEmpty()) {
	  SelectAssetSector(assetData.get(2).toString()); }
	  
	  if (!assetData.get(3).toString().isEmpty()) {
	  SelectDateinCalender(assetData.get(3).toString()); }
	  
	  if (!assetData.get(4).toString().isEmpty()) {
	  applicationUtils.EnterText(properties
	  .getProperty("NewAssetPopupExpectedLifeofAssetInput"),
	  assetData.get(4).toString()); } }
	  
	  public void SelectTypeOfAsset(String assetType) {
	  applicationUtils.MoveToElement(properties
	  .getProperty("NewAssetPopupClearIcon"));
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("NewAssetPopupClearIcon"));
	  applicationUtils.MoveToElement(properties
	  .getProperty("NewAssetPopupAssetTypeText"));
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("NewAssetPopupAssetTypeText"));
	  
	  if (assetType.equals("Service")) {
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("ServiceAssetType")); } else if
	  (assetType.equals("Application")) {
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("ApplicationAssetType")); } else if
	  (assetType.equals("Infrastructure")) {
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("InfrastructureAssetType")); } else { throw new
	  java.lang.UnsupportedOperationException(assetType + " - is not available"); }
	  
	  _assetType = assetType;
	  
	  applicationUtils.PressTabKey(); }
	  
	  public void SelectAssetSector(String sector) {
	  applicationUtils.MoveToElement(properties
	  .getProperty("NewAssetPopupSector"));
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("NewAssetPopupSector"));
	  
	  switch (sector) { case ASSETCONSUMERSECTOR:
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("ConsumerAssetSector")); break; case
	  ASSETCONSUMERMEDICALDEVICESSECTOR:
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("ConsumerMedicalDevicesAssetSector")); break; case
	  ASSETCORPORATESECTOR: applicationUtils.MoveToElementClick(properties
	  .getProperty("CorporateAssetSector")); break; case ASSETMEDICALDEVICESSECTOR:
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("MedicalDevicesAssetSector")); break; case ASSETPHARMASECTOR:
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("PharmaAssetSector")); break; case ASSETSUPPLYCHAINSECTOR:
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("SupplyChainAssetSector")); break; case ASSETENTERPRISESECTOR:
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("EnterpriseAssetSector")); break; default: throw new
	  java.lang.UnsupportedOperationException(sector + " - is not available"); }
	  
	  applicationUtils.PressTabKey(); }
	  
	  public void SelectDateinCalender(String datetobeSelected) throws
	  ParseException { SimpleDateFormat dateFormat = new
	  SimpleDateFormat("dd MMM yyyy"); Calendar cal = Calendar.getInstance(); Date
	  currentDate = new SimpleDateFormat("dd MMM yyyy").parse(dateFormat
	  .format(cal.getTime()));
	  
	  if (datetobeSelected.equals("6 months from Current Date")) { datetobeSelected
	  = applicationUtils.GetFutureDate(183);
	  System.out.println("6 months date from today is: " + datetobeSelected);
	  _assetGoLiveDate = datetobeSelected; } else { Date dateProvided = new
	  SimpleDateFormat("dd MMM yyyy") .parse(datetobeSelected); if
	  (!(dateProvided.compareTo(currentDate) > 0) ||
	  (dateProvided.compareTo(currentDate) == 0)) { System.out
	  .println("User provided date: " + datetobeSelected +
	  " is less than the Current Date. Hence changing the provided date to Current Date"
	  ); datetobeSelected = dateFormat.format(currentDate); _assetGoLiveDate =
	  datetobeSelected; } }
	  
	  if (!applicationUtils.isElementDisplayed(properties
	  .getProperty("ChooseMonthandYearButton"))) {
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("DatePopupButton")); }
	  
	  String[] _dateArray = datetobeSelected.toString().split(" "); char c =
	  _dateArray[0].charAt(0); if (c == '0') { _dateArray[0] =
	  _dateArray[0].substring(1); }
	  
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("ChooseMonthandYearButton"));
	  
	  boolean _flag = true; while (_flag) { applicationUtils.ThreadSleep(1000);
	  List<WebElement> _yearsList = driver.findElements(By
	  .xpath(properties.getProperty("YearandMonthGrid")));
	  
	  int _firstYear = Integer.parseInt(_yearsList.get(0).getText()); int _lastYear
	  = Integer.parseInt(_yearsList.get( _yearsList.size() - 1).getText());
	  
	  if (Integer.parseInt(_dateArray[2]) > _lastYear) {
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("Next20YearsButton")); } else if
	  (Integer.parseInt(_dateArray[2]) < _firstYear) {
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("Previous20YearsButton")); } else { _flag = false; } }
	  
	  applicationUtils.MoveToElementClick("//div[text()='" + _dateArray[2] + "']");
	  applicationUtils.ThreadSleep(1000);
	  applicationUtils.MoveToElementClick("//div[text()='" +
	  _dateArray[1].toUpperCase() + "']"); applicationUtils.ThreadSleep(1000);
	  applicationUtils.MoveToElementClick("//div[text()='" + _dateArray[0] + "']");
	  applicationUtils.ThreadSleep(1000); }
	  
	  public void ClickPopupButton(String buttonName) throws TimeoutException { if
	  (buttonName.equals("Continue")) { applicationUtils.MoveToElement(properties
	  .getProperty("NewAssetPopupContinueButton"));
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("NewAssetPopupContinueButton"));
	  applicationUtils.waitforajaxQueryToProcess();
	  applicationUtils.waitForLoadingImageDisappear();
	  applicationUtils.ThreadSleep(2000);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By
	  .xpath(properties.getProperty("AssetInitiateTabactive"))))); _createdAssetId
	  = applicationUtils.GetText(properties .getProperty("AssetIDLabel"));
	  System.out.println("Asset Created: " + _createdAssetId); } else {
	  applicationUtils.MoveToElement(properties
	  .getProperty("NewAssetPopupCancelButton"));
	  applicationUtils.MoveToElementClick(properties
	  .getProperty("NewAssetPopupCancelButton"));
	  applicationUtils.waitforajaxQueryToProcess(); } }
	  
	  public boolean CancelAssetCreation() { if
	  (!applicationUtils.isElementDisplayed(properties
	  .getProperty("NewAssetPopupHeadingLabel")) &&
	  applicationUtils.isElementDisplayed(properties .getProperty("AssetTab"))) {
	  return true; }
	  
	  return false; }
	  
	  public boolean VerifyTabisDisplayed(String tabName) throws TimeoutException {
	  switch (tabName) { case ASSETTAB: return
	  applicationUtils.isElementDisplayed(properties .getProperty("AssetTab"));
	  case TASKSTAB: return applicationUtils.isElementDisplayed(properties
	  .getProperty("TasksTab")); case SERVICEMAPTAB: return
	  applicationUtils.isElementDisplayed(properties
	  .getProperty("ServiceMapTab")); default: throw new
	  java.lang.UnsupportedOperationException(tabName + " - is not available"); } }
	  
	  public void SelectSearchOption(String searchOption) throws TimeoutException {
	  applicationUtils.ClickonButton(properties
	  .getProperty("SearchOptionDropDown"));
	  
	  switch (searchOption) { case ASSETSEARCHOPTION:
	  applicationUtils.ClickonButton(properties .getProperty("SearchAssetOption"));
	  break; case TASKSEARCHOPTION: applicationUtils.ClickonButton(properties
	  .getProperty("SearchTaskOption")); break; case CONTENTSEARCHOPTION:
	  applicationUtils.ClickonButton(properties
	  .getProperty("SearchContentOption")); break; default: throw new
	  java.lang.UnsupportedOperationException(searchOption +
	  " - is not available"); } }
	  
	  public void ClearSearch() throws TimeoutException {
	  applicationUtils.ClickonButton(properties .getProperty("SearchClearIcon")); }
	  
	  
	  
	  public boolean SearchCriteriaisCleared() { if (driver .findElement(
	  By.xpath(properties.getProperty("SearchInputText")))
	  .getAttribute("value").equals("") &&
	  !applicationUtils.isElementDisplayed(properties
	  .getProperty("SearchClearIcon"))) { return true; }
	  
	  return false; }
	  
	  public void SearchTypeAhead(String searchInput) { if (searchInput.isEmpty())
	  { searchInput = _searchCriteria; } applicationUtils.ClearandEnterText(
	  properties.getProperty("SearchInputText"), searchInput);
	  applicationUtils.ThreadSleep(2000);
	  
	  boolean _searchTypeAheadDisplayed = true;
	  
	  while (_searchTypeAheadDisplayed) { applicationUtils.PressBackspaceKey();
	  applicationUtils.ThreadSleep(3000); if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("SearchAutoSuggestedOptionList"))) { _searchTypeAheadDisplayed =
	  false; break; } else { applicationUtils.ClearandEnterText(
	  properties.getProperty("SearchInputText"), searchInput); } } }
	  
	  public void statusFilter(String filter, String filterOption) throws
	  TimeoutException { if (applicationUtils.isElementDisplayed(properties
	  .getProperty("ClearFilterButton"))) {
	  applicationUtils.ClickonButton(properties .getProperty("ClearFilterButton"));
	  } applicationUtils.ClickonButton(String.format(
	  properties.getProperty("HomePageFilter"), filter));
	  applicationUtils.ClickonButton(String.format(
	  properties.getProperty("HistoryView"), filterOption));
	  applicationUtils.ClickonButton(properties .getProperty("ApplyFilterButton"));
	  }
	  
	  public boolean ListisSortedinCreationDateDescByDefault() { if
	  (applicationUtils.isElementDisplayed(properties
	  .getProperty("DefaultSortDisplayOption"))) { return AscDscOrderByAttribute(
	  properties.getProperty("ListColumnCreationDateData"), "Desc",
	  properties.getProperty("CreationDateColumnID")); } else { return false; } }
	  
	  public boolean VerifyMyFavorites() { boolean myFavorites = false; String
	  _getCountText = applicationUtils.GetText(properties
	  .getProperty("MyFavoritesHeaderCount")); int value =
	  Integer.parseInt(_getCountText.replaceAll("[^0-9]", "")); if
	  (applicationUtils.isElementDisplayed(String.format(
	  properties.getProperty("ActiveListMode"), "Tile"))) { List<WebElement>
	  _assetFavorite = driver.findElements(By
	  .xpath(properties.getProperty("TileFavorite"))); List<WebElement> _assetOwner
	  = driver.findElements(By .xpath(properties.getProperty("TileAssetOwner")));
	  if (_assetOwner.size() == 0) { if (_getCountText.contains("My Favorites") &&
	  _assetFavorite.size() == value) { myFavorites = true; } } else { for (int i =
	  0; i < _assetOwner.size(); i++) { if (_getCountText.contains("My Favorites")
	  && _assetOwner .get(i) .getText() .toUpperCase() .contains(
	  LoginLogoutUtils._userName .toUpperCase())) { myFavorites = false; if
	  (applicationUtils .isElementDisplayed("(" + properties
	  .getProperty("TileAssetOwner") + ")[" + i +
	  "]/../../../../..//img[@class='star fav-on ng-star-inserted']")) {
	  myFavorites = true; } } } } } else { List<WebElement> _assetFavorite =
	  driver.findElements(By .xpath(properties.getProperty("ListFavorite")));
	  List<WebElement> _assetOwner = driver.findElements(By
	  .xpath(properties.getProperty("ListAssetOwner"))); if (_assetOwner.size() ==
	  0) { if (_getCountText.contains("My Favorites") && value ==
	  _assetFavorite.size()) { myFavorites = true; } } else { for (int i = 0; i <
	  _assetOwner.size(); i++) { if (_getCountText.contains("My Favorites") &&
	  _assetOwner .get(i) .getText() .toUpperCase() .contains(
	  LoginLogoutUtils._userName .toUpperCase())) { myFavorites = false; if
	  (applicationUtils .isElementDisplayed("(" + properties
	  .getProperty("ListAssetOwner") + ")[" + i +
	  "]/..//img[@class='fav-on ng-star-inserted']")) { myFavorites = true; }
	  
	  } } }
	  
	  } return myFavorites;
	  
	  }
	 
}
*/
