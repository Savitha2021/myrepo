@AAWO-4320
Feature: Formula Custom Workflow - Formula Workflow page, Information under Completed Reviews Tab when Any Approver is not selected when any workflow is launched

	Background:
		#@AAWO-7396
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
		And The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized system user, I can access the Formula Workflow page - Completed Reviews Tab so that I will be able to view Completed activities for a Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet) created using Formula Custom Workflow when any Approver is not selected for approving any workflow (Approval for Scale Up or Approval For Launch)
	@AAWO-7604 @FullAutomation @Sprint-38
	Scenario Outline: Test Formula Custom Workflow - Formula Workflow page, Information under Completed Reviews Tab when Any Approver is not selected when any workflow is launched 02
		Given The User is logged into "Product Development" application with "<User>" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "<FormulaType>" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Scale Up" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "North America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "RMC Admin*" Approver on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Preliminary*" Approver on Request Approvals tab 
		And The User deselect the checkbox of the "R&D Preliminary*" Approver on the Request Approval tab 
		And The User selects "Historical Approval Granted " option for "R&D Preliminary*" Approver on the Request Approval tab 
		And The User deselect the checkbox of the "NA Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User selects "Historical Approval Granted " option for "NA Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User enters value for "Comment/Rationale" in the Request Approval tab 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "RMC Formula Exception" Approver function in the In Progress tab 
		Then The User logout from the "Product Development" application 
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
		When The User is logged into "Product Development" application with "<User>" role 
		Then The User is on "Product Development" Home page 
		When The User enters the FML ID in the Global search bar and click on Search icon 
		And The User selects the FML ID available link 
		And The User clicks on "Status" option on the PD Composition page 
		And The User clicks on "Completed Reviews" tab 
		Then The User verify the information for "RMC Formula Exception" Approval in the Completed Reviews tab 
		And The User verify the information for "R&D Preliminary" Approval in the Completed Reviews tab 
		And The User verify the information for "NA Regulatory Preliminary" Approval in the Completed Reviews tab 
		And The User logout from the "Product Development" application 
			
		Examples: 
			|User         |FormulaType				|
			|Formulator   |Formula - Custom Workflow|
			|Formulator   |Tablet					|
			|RMCuser      |Formula - Custom Workflow|
			|RMCuser      |Tablet					|
			|PEDFormulator|Formula - Custom Workflow|
			|PEDFormulator|Tablet					|