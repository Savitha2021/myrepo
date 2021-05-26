@AAWO-6265
Feature: Formula Custom Workflow - View Information under Formula WF - Completed Reviews Tab when HUT workflow is launched and Approvers are selected

  Background: 
    #@AAWO-7396
    Given Test environment is initialized
    When The User is logged into "RAW Materials Module" application with "RMCuser" role
    Then  The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
    Then The User logout from the "RAW Materials Module" application      
      
  @AAWO-7434 @FullAutomation @Sprint-39
  Scenario Outline: Test Formula Custom Workflow - View Information under Formula WF - Completed Reviews Tab when HUT workflow is launched and Approvers are selected 01
    Given The User is logged into "Product Development" application with "<User>" role
    Then The User is on "Product Development" Home page
    When The User selects "Formula" option from the "New" menu on the Home page
    And The User selects "<FormulaType>" for "Formula Type*" field on Create New Formula page
    And The User enters value for "Lab Notebook No.*" field on Create New Formula page
    And The User enters value for "Description*" field on Create New Formula page
    And The User clicks on "Create Formula" button on Create New Formula page
    When The User enters created RMID in Search box and click on Search icon on the Composition tab
    Then The User sets QS percentage
    And The User clicks on "Save" button
    Then The User verifies the success popup "Save was successful."
    And The User clicks on "OK" button    
    And The User clicks on "Route for Approval" button
    When The User selects "HUT" option for "Approval Request Type" field on Request Approvals tab
    Then The User verifies the Formula Status on the left pane is displayed on the "Request Approvals" tab
    And The User verifies the mandatory subsections is displayed in the "Request Approvals" tab
    Then The User verifies the Formula is in "Experimental" status  
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the "Input all the required Fields." validation message is displayed on Request Approvals tab
    And The User clicks on "OK" button
    When The User selects "Yes" radio button for "Unsupervised HUT for Claim Support (excluding patch tests)?*" field under "HUT" subsection on Request Approvals tab 
    When The User enters all mandatory fields on "Request Approvals" tab for "HUT" Approval Request Type
    When The User checks the "Not Applicable" checkbox
    And The User clicks on "Save" button on Request Approvals tab
    Then The User verifies the success popup "Workflow Data Saved Successfully"
    And The User clicks on "OK" button
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab
    And The User clicks on "X" icon
    Then The User verifies the success popup "Workflow launched successfully"
	  When The User clicks on "OK" button
    Then The User verifies the system navigates to "In Progress" tab 
    Then The User verifies the information displayed within the "In Progress" tab
    Then The User logout from the "Product Development" application
    Given The User is logged into "Product Development" application with "RMCAdmin" role
    Then The User is on "Product Development" Home page
    And The User enters the FML ID in the Global search bar and click on Search icon
    Then The User selects the FML ID available link
    Then The User clicks on "Confirm" button for RMC Formula Exception on Composition Page
    Then The User enters value in "Comments *: " textarea on RMC Formula Exception popup
    And The User clicks on "Submit" button 
    Then The User verifies the success popup "Task approved successfully"
    And The User clicks on "OK" button
    Then The User logout from the "Product Development" application
    Given The User is logged into "Product Development" application with "<User>" role
    Then The User is on "Product Development" Home page
    And The User enters the FML ID in the Global search bar and click on Search icon
    Then The User selects the FML ID available link
    And The User clicks on "Status" option on the PD Composition page
    When The User clicks on "In Progress" tab
    Then The User verifies the information displayed in the "In Progress" tab for "Toxicology/Clinical Safety Full/HUT" approval
    Then The User verifies the information displayed in the "In Progress" tab for "APAC Regulatory Preliminary/HUT" approval
    Then The User logout from the "Product Development" application
    Given The User is logged into "Common Approval Module" application with "ToxicologyApprover" role
    And The User selects "Formula" under search criteria dropdown
    When The User enters the FML ID to be approved in the Global search bar and click on Search icon
    Then The User selects the FML ID available link in "Common Approvals" module
    When The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    And The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    Given The User is logged into "Common Approval Module" application with "APACRegulatoryApprover" role
    And The User selects "Formula" under search criteria dropdown
    When The User enters the FML ID to be approved in the Global search bar and click on Search icon
    Then The User selects the FML ID available link in "Common Approvals" module
    When The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    And The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    Given The User is logged into "Product Development" application with "<User>" role
    Then The User is on "Product Development" Home page
    And The User enters the FML ID in the Global search bar and click on Search icon
    Then The User selects the FML ID available link
    And The User clicks on "Status" option on the PD Composition page
    When The User clicks on "Completed Reviews" tab
    Then The User verifies the information displayed in the "Completed Reviews" tab for "RMC Formula Exception" approval
    And The User verifies the information displayed in the "Completed Reviews" tab for "Toxicology/Clinical Safety Full/HUT" approval
    And The User verifies the information displayed in the "Completed Reviews" tab for "APAC Regulatory Preliminary/HUT" approval
    And The User logout from the "Product Development" application
    
    Examples: 
      | User       | FormulaType               | 
      | Formulator | Formula - Custom Workflow |
      | RMCuser    | Tablet                    |
      | RMCuser    | Formula - Custom Workflow |
      | Formulator | Tablet                    |