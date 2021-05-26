@AAWO-4295
Feature: Formula Approval For Launch Request (Formula Custom WF)

	Background:
		#@AAWO-7396
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
		And The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized user (Formulator/PED Formulator or RMC), I can access the Formula Module - Request Approvals tab, so that I can launch the Approval For Launch workflow for Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet) created using Formula Custom Work Flow with RMC Exception
	@AAWO-7407 @FullAutomation @Sprint-38
	Scenario: Test Formula Approval For Launch Request (Formula Custom WF)
		Given The User is logged into "Product Development" application with "Formulator" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "Formula - Custom Workflow" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		Then The User verifies "RMC Exception Reason*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		When The User creates Formula of "Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab
		Then The User verifies "RMC Exception Reason*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		And The User logout from the "Product Development" application 
		When The User is logged into "Product Development" application with "RMCuser" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "Formula - Custom Workflow" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		Then The User verifies "RMC Exception Reason*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		When The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		When The User creates Formula of "Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		Then The User verifies "RMC Exception Reason*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		And The User logout from the "Product Development" application 
		When The User is logged into "Product Development" application with "PEDFormulator" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "Formula - Custom Workflow" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab
		When The User selects "Approval for Launch" Request Type on Request Approvals tab  
		Then The User verifies "RMC Exception Reason*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		When The User creates Formula of "Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab
		When The User selects "Approval for Launch" Request Type on Request Approvals tab  
		Then The User verifies "RMC Exception Reason*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button  
		Then The User is on the In Progress tab 
		When The User creates Formula of "PED Formula" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab
		When The User selects "Approval for Launch" Request Type on Request Approvals tab  
		Then The User verifies "RMC Exception Reason*" not displayed on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" not displayed on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button  
		Then The User is on the In Progress tab 
		When The User creates Formula of "PED Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		Then The User verifies "RMC Exception Reason*" not displayed on Data Required subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" not displayed on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User enters values for all mandatory fields for "Approval for Launch" on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon
		Then The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button  
		Then The User is on the In Progress tab 
		And The User logout from the "Product Development" application 