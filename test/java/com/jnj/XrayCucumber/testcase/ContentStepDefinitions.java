package com.jnj.XrayCucumber.testcase;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jnj.XrayCucumber.libraries.ReportScreenshots;
import com.jnj.XrayCucumber.libraries.SharedState;
import com.jnj.XrayCucumber.runner.TestRunner;

import applicationUtils.ApplicationUtils;
import applicationUtils.CAPRIContentUtils;
import applicationUtils.CAPRIHomepageUtils;
import applicationUtils.CAPRILoginUtils;
import applicationUtils.CAPRIPreferencesUtils;
import applicationUtils.LoginLogoutUtils;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ContentStepDefinitions extends TestRunner {
	// CONSTANTS

	static final String CAPRIDEV = "CAPRIDev";
	static final String CAPRIQA = "CAPRIQa";
	// VARIABLE-OBJECT DECLARATION
	public RemoteWebDriver driver;
	private SharedState sharedState;
	static WebDriverWait wait;
	CAPRILoginUtils CAPRIloginUtils;
	ApplicationUtils applicationUtils;
	LoginLogoutUtils loginLogoutUtils;
	CAPRIHomepageUtils CAPRIHomepageUtils;
	CAPRIPreferencesUtils capriPreferencesUtils;
	CAPRIContentUtils capriContentUtils;
	public static String _userName = "";
	public static String _password = "";
	public static String _userFullName = "";
	public static String _userRole = "";

	// CONSTRUCTOR
	public ContentStepDefinitions(SharedState sharedState, Properties properties) {
		this.driver = sharedState.driver;
		this.sharedState = sharedState;
		wait = new WebDriverWait(driver, 60);
		CAPRIloginUtils = new CAPRILoginUtils(driver, elementProperties);
		applicationUtils = new ApplicationUtils(driver);
		loginLogoutUtils = new LoginLogoutUtils(driver, elementProperties);
		capriPreferencesUtils = new CAPRIPreferencesUtils(driver, elementProperties);
		capriContentUtils= new CAPRIContentUtils(driver, elementProperties, sharedState);
		// loginLogoutUtils = new LoginLogoutUtils(driver, elementProperties);
		// applicationUtils = new ApplicationUtils(driver);
		 CAPRIHomepageUtils = new CAPRIHomepageUtils(driver, elementProperties,sharedState);
	}
	
	

	
	@When("^The User searches \"([^\"]*)\" APR$")
	public void the_User_searches_APR(String APRID) throws Throwable {
	    
		CAPRIHomepageUtils.searchAPR(APRID);
		ReportScreenshots.getScreenshot(sharedState);
	}
	
@When("^User opens APR \"([^\"]*)\" and navigates to Content tab$")
public void user_opens_it_and_navigates_to_Content_tab(String APRID) throws Throwable {
   
	
	Thread.sleep(3000);
	applicationUtils.clickOnElement(String.format(elementProperties.getProperty("APRTileImage"),elementProperties.getProperty(APRID)));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.clickOnElement(elementProperties.getProperty("ContentTab"));
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);
}


@When("^The User clicks on Action icon for \"([^\"]*)\" document in Content tab$")
public void the_User_clicks_on_Action_icon_for_document_in_Content_tab(String docName) throws Throwable {
	Thread.sleep(3000);
	
	applicationUtils.clickOnElement(String.format(elementProperties.getProperty("ActionsDropdown"),docName));
	
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);


}

@When("^For \"([^\"]*)\" document click on Map Documents option$")
public void for_document_click_on_Map_Documents_option(String docName) throws Throwable {
	Thread.sleep(3000);
	applicationUtils.clickonElementusingJSE(String.format(elementProperties.getProperty("ActionsMapDocumentsOption"),docName));
	//applicationUtils.clickOnElement(String.format(elementProperties.getProperty("ActionsDropdown"),docName,buttonName));
	//MapDocErrorPopupMessageExpected
	Thread.sleep(3000);
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}


@Then("^No uploaded files were found error message pop-up is displayed with OK button$")
public void no_uploaded_files_were_found_error_message_pop_up_is_displayed_with_OK_button() throws Throwable {
	
	

	String actual= applicationUtils.getText(elementProperties.getProperty("MapDocErrorPopupMessage"));
	System.out.println(actual);
	Assert.assertEquals("Message not matching", "No uploaded files were found", applicationUtils.getText(elementProperties.getProperty("MapDocErrorPopupMessage")));
	
	
	
}


	
@When("^The User clicks OK button$")
public void the_User_clicks_OK_button() throws Throwable {
	applicationUtils.clickOnElement(elementProperties.getProperty("MapDocErrorOKButton"));
	Thread.sleep(3000);
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}


@When("^For \"([^\"]*)\" document click on Upload option$")
public void for_document_click_on_Upload_option(String docName) throws Throwable {
	Thread.sleep(3000);
	applicationUtils.clickonElementusingJSE(String.format(elementProperties.getProperty("ActionsUploadOption"),docName));
	//applicationUtils.clickOnElement(String.format(elementProperties.getProperty("ActionsDropdown"),docName,buttonName));
	//MapDocErrorPopupMessageExpected
	Thread.sleep(3000);
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}
@When("^User uploads specified types of files$")
public void User_uploads_specified_types_of_files() throws Throwable {
	applicationUtils.uploadFile("sample2.css");
	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

/*	applicationUtils.uploadFile("sample2.rtf");
	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.uploadFile("sample3.xlsx");
	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.uploadFile("sample3.docx");
	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.uploadFile("sample_5184×3456.tiff");
	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.uploadFile("sample_640×426.bmp");
	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.uploadFile("sample_640×426.gif");
*/	
}

@Then ("^User verifies that Map Documents window is displayed$")
public void user_verifies_that_Map_Documents_window_is_displayed() throws Throwable {
   Assert.assertTrue("Window not displayed", applicationUtils.isElementDisplayed(elementProperties.getProperty("MapFilesWindow")));
}

@Then("^Verify following sections and columns are displayed in Map Files to Documents:$")
public void verify_following_sections_and_columns_are_displayed_in_Map_Files_to_Documents(DataTable fields) throws Throwable {
	List<String> _fields = fields.asList(String.class);
	boolean flag = false;
	for (int i = 0; i < _fields.size(); i++) {

		if (applicationUtils
				.isElementPresent(String.format(elementProperties.getProperty("MapFilesFields"), _fields.get(i)))) {

			flag = true;
			// System.out.println("filter value present");

		} else {
			flag = false;
		}

	}
	ReportScreenshots.getScreenshot(sharedState);

}



@Then("^Verify files uploaded are displayed in Available for Map section$")
public void verify_files_uploaded_are_displayed_in_Available_for_Map_section() throws Throwable {
	Assert.assertTrue("Uploaded File not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample2.css")));
	Assert.assertTrue("Uploaded File not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample2.rtf")));
	Assert.assertTrue("Uploaded File not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample3.docx")));
	Assert.assertTrue("Uploaded File not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample3.xlsx")));
	Assert.assertTrue("Uploaded File not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample_5184×3456.tiff")));
	Assert.assertTrue("Uploaded File not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample_640×426.bmp")));
	Assert.assertTrue("Uploaded File not displayed", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample_640×426.gif")));
	

}


@Then("^Verify user can map only one file using drag and drop from Available for Map section to Mandatory placeholder of \"([^\"]*)\" document$")
public void verify_user_can_map_only_one_file_using_drag_and_drop_from_Available_for_Map_section_to_Mandatory_placeholder_of_document(String docName) throws Throwable {
	applicationUtils.clickOnElement(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample2.css"));
	applicationUtils.clickonButton(elementProperties.getProperty("MandatoryAddFileButton"));
	Assert.assertTrue("File not mapped", applicationUtils.isElementDisplayed(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"sample_640×426.gif")));
	
}
/*
@Then("^Verify user can map multiple files by clicking on plus icon from Available for Map section to Supporting placeholder of \"([^\"]*)\" document$")
public void verify_user_can_map_multiple_files_by_clicking_on_icon_from_Available_for_Map_section_to_Supporting_placeholder_of_document(String arg1) throws Throwable {
    
}

@When("^User Clicks on Cancel button$")
public void user_Clicks_on_Cancel_button() throws Throwable {
    
}

@Then("^Verify the Map Files to Documents window is closed$")
public void verify_the_Map_Files_to_Documents_window_is_closed() throws Throwable {
   
}

@Then("^Content page is displayed$")
public void content_page_is_displayed() throws Throwable {
    
}

@Then("^Files added are not displayed in Content page$")
public void files_added_are_not_displayed_in_Content_page() throws Throwable {
   
}
*/

@When("^The User clicks on Other Actions icon and select \"([^\"]*)\" option$")
public void the_User_clicks_on_Other_Actions_icon_and_select_Create_Related_APR_option(String option) throws Throwable {
	Thread.sleep(3000);
	applicationUtils.clickonElementusingJSE(elementProperties.getProperty("OtherActionsButton"));
    
    Thread.sleep(2000);
    applicationUtils.clickOnElement(String.format(elementProperties.getProperty("OtherActionsOption"),option));
    applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

	
}

@Then("^Sibling or Child popup window opens$")
public void sibling_or_Child_popup_window_opens() throws Throwable {
	Assert.assertTrue("Popup not displayed", applicationUtils.isElementPresent(elementProperties.getProperty("SiblingOrChildPopup")));
	

}
@When("^User populates below fields:$")
public void user_populates_below_fields(DataTable fields) throws Throwable {
	List<String> _fields = fields.asList(String.class);
	String APRTitle = _fields.get(0);
	String Country = _fields.get(1);
	Thread.sleep(3000);
	System.out.println(APRTitle);
	System.out.println(Country);
	capriContentUtils._user_populates_APR_Title_Region_and_Country(APRTitle, Country);
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

	
}


@When("^clicks Cancel button$")
public void clicks_Cancel_button() throws Throwable {
	applicationUtils.clickOnElement(elementProperties.getProperty("CancelButton"));
	

}

@Then("^The Content page is displayed$")
public void the_Content_page_is_displayed() throws Throwable {
	Thread.sleep(3000);
	boolean  b=applicationUtils.isElementDisplayed(elementProperties.getProperty("ContentTabSelected"));
	System.out.println(b);
Assert.assertTrue("Content page not displayed", applicationUtils.isElementDisplayed(elementProperties.getProperty("ContentTabSelected")));
applicationUtils.waitForLoadingImageDisappear();
ReportScreenshots.getScreenshot(sharedState);

}



@When("^User clicks Create button$")
public void user_clicks_Create_button() throws Throwable {
	applicationUtils.clickOnElement(elementProperties.getProperty("CreateButton"));
	applicationUtils.waitForLoadingImageDisappear();
	Thread.sleep(3000);
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@Then("^New APR is created and Profile page is displayed$")
public void new_APR_is_created_and_Profile_page_is_displayed() throws Throwable {
   Assert.assertTrue("Sibling not created", applicationUtils.isElementPresent(elementProperties.getProperty("ProfileTabSelected")));
   Assert.assertTrue("Sibling not created", applicationUtils.isElementPresent(elementProperties.getProperty("APRNewStatus")));
   applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@When("^The User navigates to Content tab$")
public void the_User_navigates_to_Content_tab() throws Throwable {
	Thread.sleep(3000);
	applicationUtils.clickOnElement(elementProperties.getProperty("ContentTab"));
	applicationUtils.waitForLoadingImageDisappear();
	
	ReportScreenshots.getScreenshot(sharedState);

}

@When("^The User clicks Expand/Collapse button$")
public void the_User_clicks_Expand_Collapse_button() throws Throwable {
	Thread.sleep(2000);
	applicationUtils.clickOnElement(elementProperties.getProperty("ExpandCollapseIcon"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@Then("^The User verifies that the header is collapsed$")
public void the_User_verifies_that_the_header_is_collapsed() throws Throwable {
    Assert.assertTrue("Header not collapsed", applicationUtils.isElementDisplayed(elementProperties.getProperty("HeaderCollapsed")));
    applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}


@Then("^The User verifies that the header is expanded$")
public void the_User_verifies_that_the_header_is_expanded() throws Throwable {
	 Assert.assertTrue("Header not expanded", applicationUtils.isElementDisplayed(elementProperties.getProperty("HeaderExpanded")));
	 applicationUtils.waitForLoadingImageDisappear();
		ReportScreenshots.getScreenshot(sharedState);

	
}

@When("^The User scrolls down to end of the page$")
public void the_User_scrolls_down_to_end_of_the_page() throws Throwable {
	applicationUtils.scrollPagetoEnd();
	applicationUtils.waitForLoadingImageDisappear();
	
	ReportScreenshots.getScreenshot(sharedState);

 
}


@When("^The User scrolls up to top of the page$")
public void the_User_scrolls_up_to_top_of_the_page() throws Throwable {
	applicationUtils.scrollPagetoHome();
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@When("^User uploads zero size file$")
public void user_uploads_zero_size_file() throws Throwable {
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.uploadFileUsingAutoIT("zero_file.txt");

//	applicationUtils.uploadFile("sample2.css");
	//applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.clickOnElement(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"zero_file.txt"));
	applicationUtils.clickonButton(String.format(elementProperties.getProperty("MandatoryAddFileButton"),"DEVELOPMENT PLAN"));
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);


}

@When("^The user clicks Refresh link$")
public void the_user_clicks_Refresh_link() throws Throwable {
	Thread.sleep(3000);
	while(applicationUtils.isElementPresent(elementProperties.getProperty("ContentRefreshLink")))
	{
	applicationUtils.clickOnElement(elementProperties.getProperty("ContentRefreshLink"));
	//Thread.sleep(3000);
	applicationUtils.waitForLoadingImageDisappear();
	}
	Thread.sleep(3000);
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@Then("^User verifies document row on Content is highlighted in red outline$")
public void user_verifies_document_row_on_Content_is_highlighted_in_red_outline() throws Throwable {
	Thread.sleep(3000);
	Assert.assertTrue("Red border not displayed", applicationUtils.isElementPresent(elementProperties.getProperty("ContentRedBorder")));
	Assert.assertTrue("File Name not displayed", applicationUtils.isElementPresent(String.format(elementProperties.getProperty("ContentFileName"),"zero_file.txt")));
	Assert.assertTrue("Source not displayed", applicationUtils.isElementPresent(String.format(elementProperties.getProperty("ContentSource"),"Processing")));
	Assert.assertTrue("Size not displayed", applicationUtils.isElementPresent(String.format(elementProperties.getProperty("ContentSize"),"0.0")));
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@When("^User uploads non zero size file$")
public void user_uploads_non_zero_size_file() throws Throwable {
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.uploadFileUsingAutoIT("1.jpeg");

//	applicationUtils.uploadFile("sample2.css");
	//applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	applicationUtils.clickOnElement(String.format(elementProperties.getProperty("MapFilesUploadedFile"),"1.jpeg"));
	applicationUtils.clickonButton(String.format(elementProperties.getProperty("MandatoryAddFileButton"),"DEVELOPMENT PLAN"));
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

	applicationUtils.clickOnElement(elementProperties.getProperty("MapFilesSaveButton"));
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@Then("^User verifies document row on Content is not highlighted in red outline$")
public void user_verifies_document_row_on_Content_is_not_highlighted_in_red_outline() throws Throwable {
	Thread.sleep(3000);
	Assert.assertFalse("Red border displayed", applicationUtils.isElementPresent(elementProperties.getProperty("ContentRedBorder")));
	Assert.assertTrue("File Name not displayed", applicationUtils.isElementPresent(String.format(elementProperties.getProperty("ContentFileNameLink"),"1.jpeg")));
	Assert.assertTrue("Source not displayed", applicationUtils.isElementPresent(String.format(elementProperties.getProperty("ContentSource"),"Local Drive")));
	Assert.assertTrue("Size not displayed", applicationUtils.isElementPresent(String.format(elementProperties.getProperty("ContentSize"),"")));
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);

}

@Then("^The User records the below details for \"([^\"]*)\" document$")
public List the_User_records_the_below_details_for_the_Document(DataTable fields, String docName) throws Throwable {
	List<String> _fields = fields.asList(String.class);
	String APRTitle = _fields.get(0);
	String Country = _fields.get(1);
	Thread.sleep(3000);
	System.out.println(APRTitle);
	System.out.println(Country);
	capriContentUtils._user_populates_APR_Title_Region_and_Country(APRTitle, Country);
	applicationUtils.waitForLoadingImageDisappear();
	ReportScreenshots.getScreenshot(sharedState);
	return _fields;
}

@When("^The User clicks \"([^\"]*)\" in Total APRs section$")
public void the_User_clicks_in_Total_APRs_section(String APRID) throws Throwable {
	applicationUtils.clickOnElement(elementProperties.getProperty("TotalAPRsPlusIcon"));
	
	//applicationUtils.waitUntilVisibilityofElement((String.format(elementProperties.getProperty("TotalAPRsSectionAPRID"), elementProperties.getProperty(APRID))));
	applicationUtils.clickOnElement((String.format(elementProperties.getProperty("TotalAPRsSectionAPRID"), elementProperties.getProperty(APRID))));
	applicationUtils.waitForLoadingImageDisappear();
}

@Then("^The User verifies that the following documents are enabled$")
public void the_User_verifies_checkbox_is_selected_for_the_following_documents(DataTable docs) throws Throwable {
	List<String> _docs = docs.asList(String.class);
	boolean flag = false;
	
	//System.out.println("check box result"+applicationUtils.isElementSelected(String.format(elementProperties.getProperty("DocCheckbox"), _docs.get(0))));
for (int i = 0; i <_docs.size(); i++) {

		Assert.assertTrue(applicationUtils.isElementEnabled(String.format(elementProperties.getProperty("DocCheckbox"), _docs.get(i))));

			
		}
		
}

@Then("^The User verifies that the following documents are disabled$")
public void the_User_verifies_that_checkbox_is_not_selected_for_the_following_documents(DataTable docs) throws Throwable {
	List<String> _docs = docs.asList(String.class);
	boolean flag = false;
	for (int i = 0; i <_docs.size(); i++) {

		Assert.assertFalse(applicationUtils.isElementEnabled(String.format(elementProperties.getProperty("DocCheckbox"), _docs.get(i))));
	}
}


@When("^The User clicks Import button$")
public void the_User_clicks_Import_button() throws Throwable {
   
}

@When("^The User verifies that imported document \"([^\"]*)\" is displayed with the below details are same as recorded values$")
public void the_User_verifies_that_imported_document_is_displayed_with_the_below_details_are_same_as_recorded_values(String arg1, DataTable arg2) throws Throwable {
    
}

@Then("^The User records the below details for documents \"([^\"]*)\" and \"([^\"]*)\"$")
public void the_User_records_the_below_details_for_documents(DataTable expectedData, String doc1,String doc2) throws Throwable {
	List<List<String>> actualList= new ArrayList<List<String>>();
	actualList.add(Arrays.asList("Document Name", "File Name","Size (MB)","Status","Author","Reviewer"));
		actualList.add(Arrays.asList(doc1, applicationUtils.getText(String.format(elementProperties.getProperty("ContentFileName"), doc1)),
				applicationUtils.getText(String.format(elementProperties.getProperty("ContentSize"), doc1)),
				applicationUtils.getText(String.format(elementProperties.getProperty("ContentStatus"), doc1)),
				applicationUtils.getText(String.format(elementProperties.getProperty("ContentAuthor"), doc1)),
				applicationUtils.getText(String.format(elementProperties.getProperty("ContentReviewer"), doc1))
				));
System.out.println(actualList);
	DataTable actual = DataTable.create(actualList);
	expectedData.diff(actual);
}





@When("^The User unchecks the checkbox on the column header and select the document \"([^\"]*)\"$")
public void the_User_unchecks_the_checkbox_on_the_column_header_and_select_the_document(String docName) throws Throwable {
   
}



}





