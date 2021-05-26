@AAWO-4322
Feature: Formula Custom Workflow - View Information under Formula Workflow page - In Progress Tab when Approval For Launch workflow is launched

	Background:
		#@AAWO-7397
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Preferred" RMC status
		Then The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized system user (Formulator/PED Formulator or RMC), I can access the Formula Module – Formula Workflow page, In Progress Tab so that I can view pending activities for a Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet) created using Formula Custom Workflow when Approval For Launch workflow is launched
	@AAWO-7460 @FullAutomation @Sprint-39
	Scenario: Test Formula Custom Workflow - View Information under Formula Workflow page - In Progress Tab when Approval For Launch workflow is launched
		Given The User is logged into "Product Development" application with "PEDFormulator" role 
		Then The User is on "Product Development" Home page 
		When The User creates Formula of "PED Formula" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab
		And The User selects "North America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "No" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "NA Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "EMEA Regulatory Preliminary/HUT" Approver function in the In Progress tab 
		And The User verify the information for "NA Regulatory Full" Approver function in the In Progress tab
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		When The User creates Formula of "PED Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "No" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full/HUT *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		When The User creates Formula of "Formula - Custom Workflow" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab
		And The User selects "North America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "No" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "North America" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "NA Regulatory Full/HUT *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "NA Regulatory Full/HUT" Approver function in the In Progress tab
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		When The User creates Formula of "Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab
		And The User selects "Europe, Middle East, Africa" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "No" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "North America" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "NA Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User is on the In Progress tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "EMEA Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "NA Regulatory Preliminary/HUT" Approver function in the In Progress tab
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		And The User logout from the "Product Development" application	