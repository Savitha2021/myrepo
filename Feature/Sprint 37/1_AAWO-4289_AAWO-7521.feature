@AAWO-4289
Feature: Formula Approval For Scale Up Request (Formula Custom WF)

	Background:
		#@AAWO-7396
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
		And The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized user (Formulator/PED Formulator or RMC), I can access the Formula Module - Request Approvals tab, so that I can launch the Approval For Scale up Qualification workflow for Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet)) created using Formula Custom Work Flow
	@AAWO-7521 @FullAutomation @Sprint-37
	Scenario Outline: Test Formula Approval For Scale Up Request (Formula Custom WF) 02
		Given The User is logged into "Product Development" application with "<User>" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "<FormulaType>" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		Then The User verifies the Formula is in "Experimental" status 
		And The User verifies "Approved for Scale Up" status on left pane on Request Approvals tab 
		And The User verifies "Approved for Launch" status on left pane on Request Approvals tab 
		And The User verifies "Commercial" status on left pane on Request Approvals tab 
		And The User verifies "Obsolete" status on left pane on Request Approvals tab 
		And The User verifies chevron is active for "Experimental" status on left pane on Request Approvals tab 
		When The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		Then The User verifies "Data Required" mandatory subsection on Request Approvals tab 
		And The User verifies "Inputs" mandatory subsection on Request Approvals tab 
		And The User verifies "Add Additional Reviews" link on Request Approvals tab 
		And The User verifies "Required Approvers" mandatory subsection on Request Approvals tab 
		And The User verifies Show Completed Fields selected by default on Request Approvals tab 
		And The User verifies "RMC Exception Reason*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "PF Spec No.*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "PR Spec No.*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Product Name (Proposed)*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Legal Product Category*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Development Site" non mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Product Function*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Delivery System*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "End Use*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "End User*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Use Condition*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Product Type*" mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Associate to Chassis" non mandatory field on Data Required subsection on Request Approvals tab 
		And The User verifies "Region*" mandatory field on Inputs subsection on Request Approvals tab 
		And The User verifies "Review Requested by*" mandatory field on Inputs subsection on Request Approvals tab 
		And The User verifies "Additional Information" non mandatory field on Inputs subsection on Request Approvals tab 
		And The User verifies "RMC Admin*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "Toxicology/Clinical Safety Preliminary*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "R&D Preliminary*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User selects "Asia Pacific" for "Region*" field on Required Approvers subsection on Request Approvals tab 
		Then The User verifies "APAC Regulatory Preliminary *" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User selects "Europe, Middle East, Africa" for "Region*" field on Required Approvers subsection on Request Approvals tab 
		Then The User verifies "EMEA Regulatory Preliminary *" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User selects "North America" for "Region*" field on Required Approvers subsection on Request Approvals tab 
		Then The User verifies "NA Regulatory Preliminary *" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User selects "Latin America" for "Region*" field on Required Approvers subsection on Request Approvals tab 
		Then The User verifies "LATAM Regulatory Preliminary *" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		Then The User verifies unchecked HUT Option in Request Approval tab 
		When The User selects "HUT" check box on Request Approvals tab 
		Then The User verifies "HUT Description*" mandatory field on HUT subsection on Request Approvals tab 
		And The User verifies "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field with "Yes,No" options on HUT subsection on Request Approvals tab 
		And The User verifies "Select Required Functional Approval(s)*" mandatory field on HUT subsection on Request Approvals tab 
		And The User verifies "Regulatory" mandatory field with "Preliminary,None" options on HUT subsection on Request Approvals tab 
		And The User verifies "Toxicology/Clinical Safety" mandatory field with "Preliminary,Full,None" options on HUT subsection on Request Approvals tab 
		When The User selects "No" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		Then The User verifies "Preliminary" option is selected for "Regulatory" Approver field on HUT subsection on Request Approvals tab 
		And The User verifies "Preliminary" option is selected for "Toxicology/Clinical Safety" Approver field on HUT subsection on Request Approvals tab 
		And The User verifies "HUT Region*" mandatory field on HUT subsection on Request Approvals tab 
		And The User verifies "Legal Product Category in HUT Region*" mandatory field on HUT subsection on Request Approvals tab 
		When The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		Then The User verifies "EMEA Regulatory Preliminary/HUT *" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Formula should have an Associated Chassis ID or Chassis ID 'Not Applicable' checkbox should be checked." message on popup 
		When The User clicks on "OK" button 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies "Input all the required Fields." message on popup 
		When The User clicks on "OK" button 
		And The User unselects "North America;Latin America;Asia Pacific;Europe, Middle East, Africa" values of "Region*" mandatory field on Inputs subsection on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Scale Up" with Hut on Request Approvals tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User logout from the "Product Development" application 
			
		Examples: 
			| User			| FormulaType             	| 
			| Formulator	| Formula - Custom Workflow |
			| Formulator	| Tablet                    |
			| RMCuser		| Formula - Custom Workflow |
			| RMCuser		| Tablet                    |
			| PEDFormulator	| Formula - Custom Workflow	|
			| PEDFormulator	| Tablet					|