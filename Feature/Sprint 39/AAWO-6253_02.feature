@AAWO-6253
Feature: Formula HUT Request (Formula Custom WF)

  Background: 
    #@AAWO-7397
    Given Test environment is initialized
    When The User is logged into "RAW Materials Module" application with "RMCuser" role
    And  The User creates raw material for "Custom Workflow" with "Preferred" RMC status
    Then The User logout from the "RAW Materials Module" application      
      
   @AAWO-7429 @FullAutomation @Sprint-39
  Scenario Outline: Test Formula HUT Request (Formula Custom WF)  02
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
    Then The User verifies all the mandatory fields on the "Request Approvals" tab
    And The User verifies all the non mandatory fields on the "Request Approvals" tab
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the "Input all the required Fields." validation message is displayed on Request Approvals tab
    And The User clicks on "OK" button
    When The User selects "No" radio button for "Unsupervised HUT for Claim Support (excluding patch tests)?*" field under "HUT" subsection on Request Approvals tab 
    When The User enters all mandatory fields on "Request Approvals" tab for "HUT" Approval Request Type
    And The User clicks on "Save" button on Request Approvals tab
    Then The User verifies the success popup "Workflow Data Saved Successfully"
    And The User clicks on "OK" button
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message should be displayed  
    And The User clicks on "OK" button
    When The User checks the "Not Applicable" checkbox
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the success popup "Workflow launched successfully"
	  When The User clicks on "OK" button
    Then The User verifies the system navigates to "In Progress" tab 
    And The User logout from the "Product Development" application

    Examples: 
      | User          | FormulaType               |
      | Formulator    | Formula - Custom Workflow |
      | Formulator    | Tablet                    |
      | RMCuser       | Formula - Custom Workflow |
      | RMCuser       | Tablet                    |
      | PEDFormulator | Formula - Custom Workflow |
      | PEDFormulator | Tablet                    |
      | PEDFormulator | PED Formula               |
      | PEDFormulator | PED Tablet                |