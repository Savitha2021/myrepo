@AAWO-6253
Feature: Formula HUT Request (Formula Custom WF)

  Background: 
    #@AAWO-7396
    Given Test environment is initialized
    When The User is logged into "RAW Materials Module" application with "RMCuser" role
    Then  The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
    Then The User logout from the "RAW Materials Module" application      
      
  @AAWO-7644 @FullAutomation @Sprint-39
  Scenario Outline: Test Formula HUT Request (Formula Custom WF) 04
    Given The User creates the formula of "<FormulaType>" type with "<User>" role in "Approved for Scale Up" status
    Given The User is logged into "Product Development" application with "<User>" role
    Then The User is on "Product Development" Home page
    When The User enters the FML ID in the Global search bar and click on Search icon
    Then The User selects the FML ID available link    
    And The User clicks on "Route for Approval" button
    When The User selects "HUT" option for "Approval Request Type" field on Request Approvals tab
    Then The User verifies the Formula Status on the left pane is displayed on the "Request Approvals" tab
    And The User verifies the mandatory subsections is displayed in the "Request Approvals" tab
    Then The User verifies the Formula is in "Approved for Scale-Up" status  
    Then The User verifies all the mandatory fields on the "Request Approvals" tab
    And The User verifies all the non mandatory fields on the "Request Approvals" tab
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the "Input all the required Fields." validation message is displayed on Request Approvals tab
    And The User clicks on "OK" button
    When The User selects "Yes" radio button for "Unsupervised HUT for Claim Support (excluding patch tests)?*" field under "HUT" subsection on Request Approvals tab
    When The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab
    When The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab
    When The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    When The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab
    When The User selects "APAC Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
    And The User clicks on "Save" button on Request Approvals tab
    Then The User verifies the success popup "Workflow Data Saved Successfully"
    And The User clicks on "OK" button
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab
    And The User clicks on "X" icon
    Then The User verifies the success popup "Workflow launched successfully"
	  When The User clicks on "OK" button
    Then The User verifies the system navigates to "In Progress" tab 
    Then The User logout from the "Product Development" application

    Examples: 
      | User       | FormulaType               | 
      | Formulator | Formula - Custom Workflow |
      | RMCuser    | Tablet                    |
      | RMCuser    | Formula - Custom Workflow |
      | Formulator | Tablet                    |