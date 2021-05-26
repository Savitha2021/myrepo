@AAWO-4294
Feature: Approval for scale up and Approval for Launch for Formula using Custom WF - Submit Workflow Button - Exception task confirmation window

	Background:
		#@AAWO-7396
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
		And The User logout from the "RAW Materials Module" application
		

	#Tests As a Formulator/PED Formulator/RMC Admin, I want to launch approval workflow for a formula containing at least one Exception required RM, so that I can see the popup window confirming the RMC exception task generated and RM information.
	@AAWO-7678 @FullAutomation @Sprint-39
	Scenario Outline: Test Approval for scale up and Approval for Launch for Formula using Custom WF - Submit Workflow Button - Exception task confirmation window
		Given The User is logged into "Product Development" application with "<User>" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "<FormulaType>" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Scale Up" with Hut on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "RMC Formula Exception" Approver function in the In Progress tab 
		When The User clicks on "Formula" option on the PD Composition page 
		Then The User verifies Formula is in "View" mode 
		And The User logout from the "Product Development" application 
			
		Examples: 
			|User	   		|FormulaType			  |
			|Formulator		|Formula - Custom Workflow|
			|Formulator		|Tablet					  |
			|PEDFormulator	|Formula - Custom Workflow|
			|PEDFormulator	|Tablet					  |
			|RMCuser		|Formula - Custom Workflow|
			|RMCuser		|Tablet					  |	