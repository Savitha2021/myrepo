@AAWO-6271
Feature: Formula HUT Request (Formula Custom WF) - Required Approvers Selection

  Background: 
    #@AAWO-7397
    Given Test environment is initialized
    When The User is logged into "RAW Materials Module" application with "RMCuser" role
    Then The User creates raw material for "Custom Workflow" with "Preferred" RMC status
    Then The User logout from the "RAW Materials Module" application

  @AAWO-7633 @FullAutomation @Sprint-39
  Scenario Outline: Test Formula HUT Request (Formula Custom WF) - Required Approvers Selection 02
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
    And The User selects "No" radio button for "Unsupervised HUT for Claim Support (excluding patch tests)?*" field under "HUT" subsection on Request Approvals tab
    And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab
    And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User clicks on "Add Additional HUT Region/Legal Product Category" icon on HUT subsection on Request Approvals tab
    And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User clicks on "Add Additional HUT Region/Legal Product Category" icon on HUT subsection on Request Approvals tab
    And The User selects "Latin America" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User clicks on "Add Additional HUT Region/Legal Product Category" icon on HUT subsection on Request Approvals tab
    And The User selects "North America" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    Then The User verify selected approvers are listed under Approvals Needed in the right pane of the "Request Approvals" screen
    When The User enters all mandatory fields under "Data Required" subsection on Request Approvals tab for "HUT" Approval Request Type
    When The User enters all mandatory fields under "Inputs" subsection on Request Approvals tab for "HUT" Approval Request Type
    When The User selects "Toxicology/Clinical Safety Preliminary/HUT*" Approver on Request Approvals tab
    When The User selects "APAC Regulatory Preliminary/HUT *" Approver on Request Approvals tab
    When The User selects "EMEA Regulatory Preliminary/HUT *" Approver on Request Approvals tab
    When The User selects "LATAM Regulatory Preliminary/HUT *" Approver on Request Approvals tab
    When The User selects "NA Regulatory Preliminary/HUT *" Approver on Request Approvals tab
    And The User clicks on "Save" button on Request Approvals tab
    Then The User verifies the success popup "Workflow Data Saved Successfully"
    And The User clicks on "OK" button
    When The User checks the "Not Applicable" checkbox
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the success popup "Workflow launched successfully"
    And The User clicks on "OK" button
    Then The User verifies the system navigates to "In Progress" tab
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
    And The User selects "No" radio button for "Unsupervised HUT for Claim Support (excluding patch tests)?*" field under "HUT" subsection on Request Approvals tab
    And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab
    And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User clicks on "Add Additional HUT Region/Legal Product Category" icon on HUT subsection on Request Approvals tab
    And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User clicks on "Add Additional HUT Region/Legal Product Category" icon on HUT subsection on Request Approvals tab
    And The User selects "Latin America" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User clicks on "Add Additional HUT Region/Legal Product Category" icon on HUT subsection on Request Approvals tab
    And The User selects "North America" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters all mandatory fields under "Data Required" subsection on Request Approvals tab for "HUT" Approval Request Type
    And The User enters all mandatory fields under "Inputs" subsection on Request Approvals tab for "HUT" Approval Request Type
    And The User deselect the checkbox of "Toxicology/Clinical Safety Preliminary/HUT*" Approver on Request Approvals tab
    And The User deselect the checkbox of "APAC Regulatory Preliminary/HUT*" Approver on Request Approvals tab
    And The User deselect the checkbox of "EMEA Regulatory Preliminary/HUT*" Approver on Request Approvals tab
    When The User selects "External Approval Acquired " value for "Toxicology/Clinical Safety Preliminary/HUT*" Approver on Request Approvals tab
    And The User selects "Historical Approval Granted " value for "APAC Regulatory Preliminary/HUT*" Approver on Request Approvals tab
    And The User selects "Approval not required per local process " value for "EMEA Regulatory Preliminary/HUT*" Approver on Request Approvals tab
    And The User selects "LATAM Regulatory Preliminary/HUT *" Approver on Request Approvals tab
    And The User selects "NA Regulatory Preliminary/HUT *" Approver on Request Approvals tab
    Then The User verify selected approvers are listed under Approvals Needed in the right pane of the "Request Approvals" screen
    And The User clicks on "Save" button on Request Approvals tab
    Then The User verifies the success popup "Workflow Data Saved Successfully"
    And The User clicks on "OK" button
    When The User checks the "Not Applicable" checkbox
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the "Input all the required Fields." validation message is displayed on Request Approvals tab
    And The User clicks on "OK" button
    Then The User enters the "Comment/Rationale" field under Required Approvers subsection on Request Approvals tab
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the success popup "Workflow launched successfully"
    And The User clicks on "OK" button
    Then The User verifies the system navigates to "In Progress" tab
    And The User logout from the "Product Development" application

    Examples: 
      | User          | FormulaType               |
      | Formulator    | Formula - Custom Workflow |
      | Formulator    | Tablet                    |
      | RMCuser       | Formula - Custom Workflow |
      | RMCuser       | Tablet                    |
      | PEDFormulator | PED Formula               |
      | PEDFormulator | PED Tablet                |