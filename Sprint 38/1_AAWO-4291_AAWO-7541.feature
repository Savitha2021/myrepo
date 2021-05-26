@AAWO-4291
Feature: Formula Custom Workflow - View Information under Formula Workflow page - In Progress Tab when Approval For Scale Up workflow is launched

	Background:
		#@AAWO-7397
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Preferred" RMC status
		Then The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized system user, I can access the Formula Module – Formula Workflow page, In Progress Tab to view pending activities for a Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet) created using Formula Custom Workflow when Approval For Scale Up workflow is launched so that I can send the formula for approval.
	@AAWO-7541 @FullAutomation @Sprint-38
	Scenario Outline: Test Formula Custom Workflow - View Information under Formula Workflow page - In Progress Tab when Approval For Scale Up workflow is launched 02
		Given The User is logged into "Product Development" application with "PEDFormulator" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "<FormulaType>" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Scale Up" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		When The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "North America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Latin America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Preliminary*" Approver on Request Approvals tab 
		And The User selects "R&D Preliminary*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Preliminary *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Preliminary *" Approver on Request Approvals tab 
		And The User selects "NA Regulatory Preliminary *" Approver on Request Approvals tab 
		And The User selects "LATAM Regulatory Preliminary *" Approver on Request Approvals tab
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "EMEA Regulatory Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "NA Regulatory Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "LATAM Regulatory Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "R&D Preliminary" Approver function in the In Progress tab 
		And The User logout from the "Product Development" application 
			
		Examples: 
			| FormulaType				| 
			| Formula - Custom Workflow |
			| Tablet                    |
			| PED Formula				|
			| PED Tablet				|