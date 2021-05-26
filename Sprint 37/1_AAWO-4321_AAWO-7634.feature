@AAWO-4321
Feature: Formula Approval For Launch Request (Formula Custom WF) - Required Approvers Selection

	Background:
		#@AAWO-7397
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Preferred" RMC status
		Then The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized user (Formulator/PED Formulator or RMC), I can access the Formula Module - Request Approvals tab, so that I can launch the Approval For Launch workflow for Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet) created using Formula Custom Work Flow and select required approvers
	@AAWO-7634 @FullAutomation @Sprint-37
	Scenario Outline: Test Formula Approval For Launch Request (Formula Custom WF) - Required Approvers Selection
		Given The User is logged into "Product Development" application with "<User>" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "<FormulaType>" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User selects "Approval for Launch" Request Type on Request Approvals tab
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
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
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Full/HUT *" Approver on Request Approvals tab
		And The User selects "NA Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "LATAM Regulatory Full *" Approver on Request Approvals tab
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab
		Then The User verify Comment/Rationale is "Not Mandatory" on Request Approval tab
		When The User deselect the checkbox of the "Toxicology/Clinical Safety Full/HUT*" Approver on the Request Approval tab
		And The User selects "External Approval Acquired " option for "Toxicology/Clinical Safety Full/HUT*" Approver on the Request Approval tab 
		Then The User verify Comment/Rationale is "Mandatory" on Request Approval tab
		And The User verify "R&D Full*" Approver is selected on Request Approval tab
		When The User deselect the checkbox of the "APAC Regulatory Full *" Approver on the Request Approval tab
		And The User selects "Historical Approval Granted " option for "APAC Regulatory Full *" Approver on the Request Approval tab
		And The User deselect the checkbox of the "EMEA Regulatory Full/HUT *" Approver on the Request Approval tab
		And The User selects "Approval not required per local processes " option for "EMEA Regulatory Full/HUT *" Approver on the Request Approval tab
		And The User deselect the checkbox of the "NA Regulatory Full *" Approver on the Request Approval tab
		And The User selects "Approval not required per local processes " option for "NA Regulatory Full *" Approver on the Request Approval tab
		And The User deselect the checkbox of the "LATAM Regulatory Full *" Approver on the Request Approval tab
		And The User selects "Approval not required per local processes " option for "LATAM Regulatory Full *" Approver on the Request Approval tab
		And The User deselect the checkbox of the "R&D Full*" Approver on the Request Approval tab
		And The User selects "Approval not required per local processes " option for "R&D Full*" Approver on the Request Approval tab
		And The User deselect the checkbox of the "Legal*" Approver on the Request Approval tab
		And The User selects "Approval not required per local processes " option for "Legal*" Approver on the Request Approval tab
		And The User deselect the checkbox of the "Environmental Assessment*" Approver on the Request Approval tab
		And The User selects "Approval not required per local processes " option for "Environmental Assessment*" Approver on the Request Approval tab
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Atleast one Approval is required to launch the WorkFlow" 
		When The User clicks on "OK" button
		And The User selects "R&D Full*" Approver checkbox on Request Approval tab	
		Then The User verify "R&D Full" in the Right Pane on the Request Approval tab
		And The User logout from the "Product Development" application 
			
		Examples: 
		  | User         |FormulaType                | 
		  | Formulator   | Formula - Custom Workflow |
		  | Formulator   | Tablet                    |
		  | RMCuser      | Formula - Custom Workflow |
		  | RMCuser      | Tablet                    |
		  |	PEDFormulator| Formula - Custom Workflow |
		  |	PEDFormulator| Tablet                    |
		  |	PEDFormulator| PED Formula               |
		  |	PEDFormulator| PED Tablet                |