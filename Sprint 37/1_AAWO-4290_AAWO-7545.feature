@AAWO-4290
Feature: Formula Approval For Scale Up Request (Formula Custom WF) - Required Approvers Selection

	Background:
		#@AAWO-7396
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
		And The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized user (Formulator/PED Formulator or RMC), I can access the Formula Module - Request Approvals tab, so that I can launch the Approval For Scale up workflow for Formula created using Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet) Custom Work Flow and select required approvers
	@AAWO-7545 @FullAutomation @Sprint-37
	Scenario Outline: Test Formula Approval For Scale Up Request (Formula Custom WF) - Required Approvers Selection
		Given The User is logged into "Product Development" application with "<User>" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "Formula - Custom Workflow" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Scale Up" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "North America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Latin America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "RMC Admin*" Approver on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Preliminary*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Preliminary *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "NA Regulatory Preliminary *" Approver on Request Approvals tab 
		And The User selects "LATAM Regulatory Preliminary *" Approver on Request Approvals tab 
		Then The User verify Comment/Rationale is "Not Mandatory" on Request Approval tab 
		When The User deselect the checkbox of the "Toxicology/Clinical Safety Full/HUT*" Approver on the Request Approval tab 
		And The User selects "External Approval Acquired " option for "Toxicology/Clinical Safety Full/HUT*" Approver on the Request Approval tab 
		Then The User verify Comment/Rationale is "Mandatory" on Request Approval tab 
		And The User verify "R&D Preliminary*" Approver is selected on Request Approval tab 
		When The User deselect the checkbox of the "APAC Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User selects "Historical Approval Granted " option for "APAC Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User deselect the checkbox of the "EMEA Regulatory Preliminary/HUT *" Approver on the Request Approval tab 
		And The User selects "Approval not required per local process " option for "EMEA Regulatory Preliminary/HUT *" Approver on the Request Approval tab 
		And The User deselect the checkbox of the "NA Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User selects "Approval not required per local process " option for "NA Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User deselect the checkbox of the "LATAM Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User selects "Approval not required per local process " option for "LATAM Regulatory Preliminary *" Approver on the Request Approval tab 
		And The User deselect the checkbox of the "R&D Preliminary*" Approver on the Request Approval tab 
		And The User selects "Approval not required per local process " option for "R&D Preliminary*" Approver on the Request Approval tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Atleast one Approval is required to launch the WorkFlow" 
		When The User clicks on "OK" button 
		And The User selects "R&D Preliminary*" Approver checkbox on Request Approval tab 
		Then The User verify "R&D Preliminary" in the Right Pane on the Request Approval tab 
		And The User verify "RMC Formula Exception" in the Right Pane on the Request Approval tab 
		And The User logout from the "Product Development" application 
			
		Examples: 
			| User			| 
			| Formulator	| 
			| RMCuser		|
			| PEDFormulator	|