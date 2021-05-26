@AAWO-7083
Feature: Ability to launch the workflow for the compiled formula (formula custom workflow/ Tab/PED Tab/ PED formula)

  Background: 
    #@AAWO-8009
    Given Test environment is initialized
    When The User is logged into "RAW Materials Module" application with "RMCuser" role
    Then The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
    And The User logout from the "RAW Materials Module" application
    When The User is logged into "Product Development" application with "RMCuser" role
    Then The User creates Formula of "Formula - Custom Workflow" type and adds Raw Material in Composition tab
    And The User logout from the "Product Development" application

  @AAWO-8007 @UAT4.1 
  Scenario: R4.1-Auto-UAT-1002
    Given The User is logged into "Product Development" application with "RMCuser" role
    Then The User is on "Product Development" Home page
    When The User enters the FML ID in the Global search bar and click on Search icon
    Then The User selects the FML ID available link
    When The User clicks on "Route for Approval" button
    Then The User verifies the Formula is in "Experimental" status
    When The User selects "Approval for Launch" Request Type on Request Approvals tab
    And The User verify "RMC Formula Exception" in the Right Pane on the Request Approval tab
    And The User clicks on "Add Additional Reviews" link on Request Approvals tab
    And The User selects "HUT" check box on Request Approvals tab
    And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab
    And The User selects "Not Applicable" check box on Request Approvals tab
    And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab
    And The User selects "Europe, Middle East, Africa" for "Region*" field on Inputs subsection on Request Approvals tab
    And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab
    And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab
    And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab
    And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User selects "RMC Admin*" Approver on Request Approvals tab
    And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab
    And The User selects "R&D Full*" Approver on Request Approvals tab
    And The User selects "APAC Regulatory Full/HUT *" Approver on Request Approvals tab
    And The User selects "EMEA Regulatory Full *" Approver on Request Approvals tab
    And The User selects "Legal*" Approver on Request Approvals tab
    And The User selects "Environmental Assessment*" Approver on Request Approvals tab
    And The User verify "Toxicology/Clinical Safety Full/HUT" in the Right Pane on the Request Approval tab
    And The User verify "R&D Full" in the Right Pane on the Request Approval tab
    And The User verify "EMEA Regulatory Full" in the Right Pane on the Request Approval tab
    And The User verify "APAC Regulatory Full/HUT" in the Right Pane on the Request Approval tab
    And The User verify "Legal" in the Right Pane on the Request Approval tab
    And The User verify "Environmental Assessment" in the Right Pane on the Request Approval tab
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab
    When The User clicks on "X" icon
    Then The User verifies the success popup "Workflow launched successfully"
    And The User clicks on "OK" button
    Then The User verifies the system navigates to "In Progress" tab
    And The User verify the information for "RMC Formula Exception" Approver function in the In Progress tab
    And The User logout from the "Product Development" application
    When The User is logged into "Product Development" application with "RMCAdmin" role
    Then The User is on "Product Development" Home page
    When The User enters the FML ID in the Global search bar and click on Search icon
    And The User selects the FML ID available link
    And The User clicks on "Confirm" button for RMC Formula Exception on Composition Page
    And The User enters value in "Comments *: " textarea on RMC Formula Exception popup
    And The User clicks on "Submit" button
    Then The User verifies the success popup "Task approved successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Product Development" application
    When The User is logged into "Product Development" application with "RMCuser" role
    Then The User is on "Product Development" Home page
    When The User enters the FML ID in the Global search bar and click on Search icon
    And The User selects the FML ID available link
    And The User clicks on "Status" option on the PD Composition page
    And The User clicks on "In Progress" tab
    Then The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab
    And The User verify the information for "R&D Full" Approver function in the In Progress tab
    And The User verify the information for "APAC Regulatory Full/HUT" Approver function in the In Progress tab
    And The User verify the information for "EMEA Regulatory Full" Approver function in the In Progress tab
    And The User verify the information for "Legal" Approver function in the In Progress tab
    And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab
    And The User logout from the "Product Development" application
    When The User is logged into "Common Approval Module" application with "ToxicologyApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "RDApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "APACRegulatoryApprover" role
    And The User selects "Formula" under search criteria dropdown
    When The User enters the FML ID to be approved in the Global search bar and click on Search icon
    When The User selects the FML ID available link in "Common Approvals" module
    When The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "EMEARegulatoryApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "LegalApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Complete" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "EnvironmentalAssessmentApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Complete" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Product Development" application with "PEDFormulator" role
    Then The User is on "Product Development" Home page
    When The User enters the FML ID in the Global search bar and click on Search icon
    And The User selects the FML ID available link
    And The User clicks on "Status" option on the PD Composition page
    And The User clicks on "Completed Reviews" tab
    Then The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approval in the Completed Reviews tab
    And The User verify the information for "APAC Regulatory Full/HUT" Approval in the Completed Reviews tab
    And The User verify the information for "R&D Full" Approval in the Completed Reviews tab
    And The User verify the information for "EMEA Regulatory Full" Approval in the Completed Reviews tab
    And The User verify the information for "Legal" Approval in the Completed Reviews tab
    And The User verify the information for "Environmental Assessment" Approval in the Completed Reviews tab
    And The User verify the information for "RMC Formula Exception" Approval in the Completed Reviews tab
    Then The User verifies the Formula is in "Approved for Launch" status
    And The User verifies the status circle displays "HUT"
    And The User logout from the "Product Development" application
    When The User is logged into "Product Development" application with "PEDFormulator" role
    Then The User creates Formula of "PED Tablet" type and adds Raw Material in Composition tab
    When The User clicks on "Route for Approval" button
    Then The User verifies the Formula is in "Experimental" status
    When The User selects "Approval for Launch" Request Type on Request Approvals tab
    And The User clicks on "Add Additional Reviews" link on Request Approvals tab
    And The User selects "HUT" check box on Request Approvals tab
    And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab
    And The User selects "Not Applicable" check box on Request Approvals tab
    And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab
    And The User selects "Europe, Middle East, Africa" for "Region*" field on Inputs subsection on Request Approvals tab
    And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab
    And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab
    And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab
    And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab
    And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
    And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab
    And The User selects "R&D Full*" Approver on Request Approvals tab
    And The User selects "APAC Regulatory Full/HUT *" Approver on Request Approvals tab
    And The User selects "EMEA Regulatory Full *" Approver on Request Approvals tab
    And The User selects "Legal*" Approver on Request Approvals tab
    And The User selects "Environmental Assessment*" Approver on Request Approvals tab
    And The User verify "Toxicology/Clinical Safety Full/HUT" in the Right Pane on the Request Approval tab
    And The User verify "R&D Full" in the Right Pane on the Request Approval tab
    And The User verify "EMEA Regulatory Full" in the Right Pane on the Request Approval tab
    And The User verify "APAC Regulatory Full/HUT" in the Right Pane on the Request Approval tab
    And The User verify "Legal" in the Right Pane on the Request Approval tab
    And The User verify "Environmental Assessment" in the Right Pane on the Request Approval tab
    And The User clicks on "Launch Workflow" button on Request Approvals tab
    Then The User verifies the success popup "Workflow launched successfully"
    And The User clicks on "OK" button
    Then The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab
    And The User verify the information for "R&D Full" Approver function in the In Progress tab
    And The User verify the information for "APAC Regulatory Full/HUT" Approver function in the In Progress tab
    And The User verify the information for "EMEA Regulatory Full" Approver function in the In Progress tab
    And The User verify the information for "Legal" Approver function in the In Progress tab
    And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab
    And The User logout from the "Product Development" application
    When The User is logged into "Common Approval Module" application with "ToxicologyApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "RDApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "APACRegulatoryApprover" role
    And The User selects "Formula" under search criteria dropdown
    When The User enters the FML ID to be approved in the Global search bar and click on Search icon
    When The User selects the FML ID available link in "Common Approvals" module
    When The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "EMEARegulatoryApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Approve" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "LegalApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Complete" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Common Approval Module" application with "EnvironmentalAssessmentApprover" role
    And The User selects "Formula" under search criteria dropdown
    And The User enters the FML ID to be approved in the Global search bar and click on Search icon
    And The User selects the FML ID available link in "Common Approvals" module
    And The User clicks on "Complete" button on the "GXP Approval Module" page
    Then The User verifies the e-Signature window is displayed
    When The User enter the Username and Password on the e-Signature window
    And The User clicks on "I Agree" button on the e-Signature window
    Then The User verifies the success popup "Task Approved Successfully"
    When The User clicks on "OK" button
    Then The User logout from the "Common Approval Module" application
    When The User is logged into "Product Development" application with "PEDFormulator" role
    Then The User is on "Product Development" Home page
    When The User enters the FML ID in the Global search bar and click on Search icon
    And The User selects the FML ID available link
    And The User clicks on "Status" option on the PD Composition page
    And The User clicks on "Completed Reviews" tab
    Then The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approval in the Completed Reviews tab
    And The User verify the information for "APAC Regulatory Full/HUT" Approval in the Completed Reviews tab
    And The User verify the information for "R&D Full" Approval in the Completed Reviews tab
    And The User verify the information for "EMEA Regulatory Full" Approval in the Completed Reviews tab
    And The User verify the information for "Legal" Approval in the Completed Reviews tab
    And The User verify the information for "Environmental Assessment" Approval in the Completed Reviews tab
    Then The User verifies the Formula is in "Approved for Launch" status
    And The User verifies the status circle displays "HUT"
    And The User logout from the "Product Development" application