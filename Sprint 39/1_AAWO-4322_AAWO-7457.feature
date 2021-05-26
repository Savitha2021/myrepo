@AAWO-4322
Feature: Formula Custom Workflow - View Information under Formula Workflow page - In Progress Tab when Approval For Launch workflow is launched

	Background:
		#@AAWO-7396
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		And The User creates raw material for "Custom Workflow" with "Exception Required" RMC status
		And The User logout from the "RAW Materials Module" application
		

	#Tests As an authorized system user (Formulator/PED Formulator or RMC), I can access the Formula Module – Formula Workflow page, In Progress Tab so that I can view pending activities for a Formula (Formula-Custom Workflow/PED Formula/Tablet/PED Tablet) created using Formula Custom Workflow when Approval For Launch workflow is launched
	@AAWO-7457 @FullAutomation @Sprint-39
	Scenario: Test Formula Custom Workflow - View Information under Formula Workflow page - In Progress Tab when Approval For Launch workflow is launched
		Given The User is logged into "Product Development" application with "PEDFormulator" role 
		And The User is on "Product Development" Home page 
		When The User creates Formula of "PED Formula" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		And The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button
		And The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "EMEA Regulatory Preliminary/HUT" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		When The User creates Formula of "PED Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full/HUT *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		And The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button
		And The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		When The User creates Formula of "Formula - Custom Workflow" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "North America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Latin America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "RMC Admin*" Approver on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "NA Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "LATAM Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		And The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon 
		And The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button
		And The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "RMC Formula Exception" Approver function in the In Progress tab 
		And The User logout from the "Product Development" application 
		When The User is logged into "Product Development" application with "RMCAdmin" role 
		And The User is on "Product Development" Home page 
		When The User enters the FML ID in the Global search bar and click on Search icon 
		And The User selects the FML ID available link 
		And The User clicks on "Confirm" button for RMC Formula Exception on Composition Page 
		And The User enters value in "Comments *: " textarea on RMC Formula Exception popup
		And The User clicks on "Submit" button 
		And The User verifies the success popup "Task approved successfully" 
		When The User clicks on "OK" button 
		And The User logout from the "Product Development" application 
		When The User is logged into "Product Development" application with "PEDFormulator" role 
		And The User is on "Product Development" Home page 
		When The User enters the FML ID in the Global search bar and click on Search icon 
		And The User selects the FML ID available link 
		And The User clicks on "Status" option on the PD Composition page 
		And The User clicks on "In Progress" tab  
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Preliminary/HUT" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "NA Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "LATAM Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		When The User creates Formula of "Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "North America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Latin America" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "RMC Admin*" Approver on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "NA Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "LATAM Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		And The User verifies the popup "This Formula contains Exception Required RAW(s). A Formula Exception task has been created for the RMC." is displayed on Request Approvals tab 
		When The User clicks on "X" icon 
		And The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button
		And The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "RMC Formula Exception" Approver function in the In Progress tab 
		And The User logout from the "Product Development" application 
		When The User is logged into "Product Development" application with "RMCAdmin" role 
		And The User is on "Product Development" Home page 
		When The User enters the FML ID in the Global search bar and click on Search icon 
		And The User selects the FML ID available link 
		And The User clicks on "Confirm" button for RMC Formula Exception on Composition Page 
		And The User enters value in "Comments *: " textarea on RMC Formula Exception popup
		And The User clicks on "Submit" button 
		And The User verifies the success popup "Task approved successfully" 
		When The User clicks on "OK" button 
		And The User logout from the "Product Development" application 
		When The User is logged into "Product Development" application with "PEDFormulator" role 
		And The User is on "Product Development" Home page 
		When The User enters the FML ID in the Global search bar and click on Search icon 
		And The User selects the FML ID available link 
		And The User clicks on "Status" option on the PD Composition page 
		And The User clicks on "In Progress" tab  
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Preliminary/HUT" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "NA Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "LATAM Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		When The User creates Formula of "PED Tablet" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		And The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button
		And The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "EMEA Regulatory Preliminary/HUT" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab
		When The User creates Formula of "PED Formula" type and adds Raw Material in Composition tab 
		And The User clicks on "Route for Approval" button 
		And The User is on the Request Approvals tab 
		When The User selects "Approval for Launch" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Launch" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "Yes" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Full/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Full*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Full *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Preliminary/HUT *" Approver on Request Approvals tab 
		And The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		When The User clicks on "Launch Workflow" button on Request Approvals tab 
		And The User verifies the success popup "Workflow launched successfully"
		When The User clicks on "OK" button
		And The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Full/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "EMEA Regulatory Preliminary/HUT" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab
		And The User logout from the "Product Development" application