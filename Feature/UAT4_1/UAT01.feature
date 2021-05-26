@AAWO-7205
Feature: Ability to create New Formula with Type Formula - Custom workflow, Tablet, PED Tablet

	Background:
		#@AAWO-7397
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Preferred" RMC status
		Then The User logout from the "RAW Materials Module" application
		

	#h2. UAT scenario 1:
	#
	# Verify the creation of a Formula - Custom workflow by a Formulator and saving the created formula as a PED Formula by a PED Formulator. Verify the transition of the PED formula from Experimental to Approval for Scale up to Approval for Launch and approvals.
	#
	#Impacted Features AAWO-7205, AAWO-7389 and AAWO-6734
	# * AAWO-4280 – Create a New Formula
	# * AAWO-4289 – Formula Approval for Scale up request
	# * AAWO-4295 – Formula Approval for Launch Request
	# * AAWO-4377 – Save as from Formula Custom Workflow to PED Formula 
	#
	#High-Level Steps (to verify the above related US): 
	#
	#*+Pre-requisites:+* 
	# * <RM1> raw material in full composition status and Not in Prohibited RMC status 
	#
	#*+High-Level Design Steps:+* 
	#
	#*AAWO-4280 – Create New Formula* 
	# # Create new Custom FML - <FML1>, add <RM1> to composition and Save the Formula
	# # Verify Formula is in Experimental status ** 
	#
	#*AAWO-4377 – Save as from Formula Custom Workflow to PED Formula*
	# # Perform Save As from <FML1> to PED formula <FML2>
	# # Verify the following tabs details are same as <FML1> in <FML2>: Composition, Properties, Attributes and Technical comments ** 
	#
	#*AAWO-4289 – Formula Approval for Scale up request* ** 
	# # Select Approval Request type as Approval or Scale Up and verify the approvers displayed in Required approvers and approvals needed section
	# # Verify InProgress tab details
	# # Complete all approvals
	# # Verify Completed Review tab details
	# # Verify status is displayed as *Approved for Scale Up* ** 
	#
	#*AAWO-4295 – Formula Approval for Launch request* 
	# # Select Approval Request type as Approval or Scale Up and verify the approvers displayed in Required approvers and approvals needed section
	# # Launch the workflow to Approval for Scale Up by selecting at least one approver
	#
	# # Verify InProgress tab details
	# # Complete all approvals
	# # Verify Completed Review tab details
	#
	#Verify status is displayed as *Approved for Launch* 
	@AAWO-7979 @FullAutomation @UAT4.1
	Scenario: R4.1-Auto-UAT-1001
		Given The User is logged into "Product Development" application with "Formulator" role 
		When The User selects "Formula" option from the "New" menu on the Home page 
		And The User selects "Formula - Custom Workflow" for "Formula Type*" field on Create New Formula page 
		And The User enters value for "Lab Notebook No.*" field on Create New Formula page 
		And The User enters value for "Description*" field on Create New Formula page 
		And The User clicks on "Create Formula" button on Create New Formula page 
		And The User enters created RMID in Search box and click on Search icon on the Composition tab 
		And The User sets QS percentage 
		And The User clicks on "Save" button 
		Then The User verifies the success popup "Save was successful." 
		When The User clicks on "OK" button 
		And The User navigates to "Attributes" tab 
		And The User populates the values for all fields in Attributes tab 
		And The User navigates to "Properties" tab 
		And The User populates the fields on Properties tab 
		And The User clicks on "Save" button 
		Then The User verifies the success popup "Save was successful."
		When The User clicks on "OK" button 
		And The User clicks on "Exit" button 
		And The User clicks on "Comments" header icon 
		And The User navigates to Technical Comments tab 
		And The User enters "Test Comments" in Technical Comments text box 
		And The User clicks on "Submit" button 
		Then The User verifies that the entered Technical Comment is submitted for the formula
		And The User logout from the "Product Development" application
		When The User is logged into "Product Development" application with "PEDFormulator" role 
		Then The User is on "Product Development" Home page 
		And The User enters the FML ID in the Global search bar and click on Search icon 
		When The User selects the FML ID available link
		Then The User verifies that the "Save as..." button is enabled in Formula Composition screen 
		When The User clicks on "Save as..." button 
		Then The User verifies that "Create New Formula" page is displayed 
		When The User selects "PED Formula" for "Formula Type*" field on Create New Formula page 
		Then The User verifies the fieldname "Copy from Formula"  is displayed
		When The User fills all the mandatory fields with values 
		And The User clicks on "Create Formula" button on Create New Formula page 
		Then The User verifies that the Formula Composition screen is loaded  
		And The User verifies the Formula ID 
		And The User verifies the Composition tab has the same RM as the source formula
		When The User navigates to "Attributes" tab 
		Then The User verifies the Attributes tab has the same values as the source formula 
		When The User navigates to "Properties" tab 
		Then The User verifies the Properties tab has the same values as the source formula 
		When The User clicks on "Exit" button 
		And The User clicks on "Comments" header icon 
		And The User navigates to Technical Comments tab 
		Then The User verifies the Technical Comments tab has the same values as the source formula 
		When The User clicks on "Status" option on the PD Composition page 
		Then The User verifies the Formula is in "Experimental" status 
		When The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		Then The User verifies "Toxicology/Clinical Safety Preliminary*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "R&D Preliminary*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "APAC Regulatory Preliminary *" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User selects "Toxicology/Clinical Safety Preliminary*" Approver on Request Approvals tab 
		And The User selects "R&D Preliminary*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Preliminary *" Approver on Request Approvals tab 
		Then The User verify selected approvers are listed under Approvals Needed in the right pane of the "Request Approvals" screen 
		When The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "R&D Preliminary" Approver function in the In Progress tab 
		And The User logout from the "Product Development" application 
		When The User is logged into "Common Approval Module" application with "ToxicologyApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		When The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		And The User clicks on "OK" button 
		And The User logout from the "Common Approval Module" application 
		When The User is logged into "Common Approval Module" application with "RDApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		When The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		And The User clicks on "OK" button 
		And The User logout from the "Common Approval Module" application 
		When The User is logged into "Common Approval Module" application with "APACRegulatoryApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		And The User clicks on "OK" button 
		And The User logout from the "Common Approval Module" application 
		When The User is logged into "Product Development" application with "PEDFormulator" role 
		Then The User is on "Product Development" Home page 
		When The User enters the FML ID in the Global search bar and click on Search icon 
		And The User selects the FML ID available link 
		And The User clicks on "Status" option on the PD Composition page 
		And The User clicks on "Completed Reviews" tab 
		Then The User verify the information for "Toxicology/Clinical Safety Preliminary" Approval in the Completed Reviews tab 
		And The User verify the information for "APAC Regulatory Preliminary" Approval in the Completed Reviews tab 
		And The User verify the information for "R&D Preliminary" Approval in the Completed Reviews tab 
		And The User verifies the Formula is in "Approved for Scale-Up" status 
		When The User clicks on "Formula" option on the PD Composition page 
		And The User clicks on "Route for Approval" button 
		And The User selects "Approval for Launch" Request Type on Request Approvals tab 
		Then The User verifies "Toxicology/Clinical Safety Full*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "R&D Full*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "APAC Regulatory Full *" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "Legal*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "Environmental Assessment*" mandatory field on Required Approvers subsection on Request Approvals tab 
		When The User selects "Legal*" Approver on Request Approvals tab 
		And The User selects "Environmental Assessment*" Approver on Request Approvals tab 
		Then The User verify selected approvers are listed under Approvals Needed in the right pane of the "Request Approvals" screen 
		When The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Full" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Full" Approver function in the In Progress tab 
		And The User verify the information for "R&D Full" Approver function in the In Progress tab 
		And The User verify the information for "Legal" Approver function in the In Progress tab 
		And The User verify the information for "Environmental Assessment" Approver function in the In Progress tab 
		Then The User logout from the "Product Development" application 
		When The User is logged into "Common Approval Module" application with "ToxicologyApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		And The User clicks on "OK" button 
		And The User logout from the "Common Approval Module" application 
		When The User is logged into "Common Approval Module" application with "RDApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		And The User clicks on "OK" button 
		And The User logout from the "Common Approval Module" application 
		When The User is logged into "Common Approval Module" application with "APACRegulatoryApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		And The User clicks on "OK" button 
		And The User logout from the "Common Approval Module" application 
		When The User is logged into "Common Approval Module" application with "LegalApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		When The User enters the FML ID to be approved in the Global search bar and click on Search icon 
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
		When The User enters the FML ID to be approved in the Global search bar and click on Search icon 
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
		When The User clicks on "Completed Reviews" tab 
		Then The User verify the information for "Toxicology/Clinical Safety Full" Approval in the Completed Reviews tab 
		And The User verify the information for "APAC Regulatory Full" Approval in the Completed Reviews tab 
		And The User verify the information for "R&D Full" Approval in the Completed Reviews tab 
		And The User verify the information for "Legal" Approval in the Completed Reviews tab 
		And The User verify the information for "Environmental Assessment" Approval in the Completed Reviews tab 
		And The User verifies the Formula is in "Approved for Launch" status 
		And The User logout from the "Product Development" application 