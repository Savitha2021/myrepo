@AAWO-7083
Feature: Ability to launch the workflow for the compiled formula (formula custom workflow/ Tab/PED Tab/ PED formula)

  Background: 
		#@AAWO-7397
		Given Test environment is initialized
		When The User is logged into "RAW Materials Module" application with "RMCuser" role
		Then The User creates raw material for "Custom Workflow" with "Preferred" RMC status
		Then The User logout from the "RAW Materials Module" application
		

	#UAT Scenario 3:
	#
	#Verify the transition of a formula (Tablet) from experimental to standalone HUT workflow with Unsupervised HUT for Claim Support selected as No, cancel the Formula and Relaunch and Approve the formula . Verify Approval for scaleup with HUT for a PED Tablet formula type by a PED Formulator. 
	#
	#Impacted Features: AAWO-7205, AAWO-7083, AAWO-7389 
	# * AAWO-6264 -Formula Custom Workflow- HUT Workflow selected
	#
	#*Pre-Requisites –*
	# * <RM1> Raw material with Full Composition or Partial composition
	# * Tablet formula <FML1> in Experimental status with <RM1>
	# * PED Tablet formula <FML2> in Experimental status with <RM1>
	#
	#*AAWO-6264 -Formula Custom Workflow- HUT Workflow selected* ** 
	# * Open the formula <FML1> and Select Approval Request type as HUT and verify the approvers displayed in Required Approvers and Approvals Needed section
	# * Launch the workflow to HUT with Unsupervised HUT for Claim support as No
	# * Verify the tasks in in progress tab
	# * Cancel the workflow
	# * Relaunch the workflow
	# * Verify Request Revision and Resolve Revision for one of the approvers
	# * Complete all approvals
	# * Verify details in Completed Reviews tab
	# *  ** Verify status circle displays *HUT*
	# *  ** Navigate to workflow page of <FML2> and select Approval Request type as Approval for Scale Up
	# *  ** Click on Add Additional Review and select HUT
	# * Verify the approvers displayed in Approvals Needed and Required Approvals section
	# * Populate all mandatory fields and launch the workflow
	# * Verify the InProgress tab details
	# * Complete all approvals
	# * Verify Completed Reviews tab details
	# * Verify the Status of formula <FML2> is displayed as *Approved for Scale Up* and *HUT* is displayed in the Status circle
	@AAWO-8003 @UAT4.1
	Scenario: R4.1-Auto-UAT-1003
		Given The User is logged into "Product Development" application with "Formulator" role 
		Then The User is on "Product Development" Home page 
		When The User selects "Formula" option from the "New" menu on the Home page 
		And The User selects "Tablet" for "Formula Type*" field on Create New Formula page 
		And The User enters value for "Lab Notebook No.*" field on Create New Formula page 
		And The User enters value for "Description*" field on Create New Formula page 
		And The User clicks on "Create Formula" button on Create New Formula page 
		And The User enters created RMID in Search box and click on Search icon on the Composition tab 
		Then The User sets QS percentage 
		When The User clicks on "Save" button 
		Then The User verifies the success popup "Save was successful." 
		When The User clicks on "OK" button 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "HUT" option for "Approval Request Type" field on Request Approvals tab 
		And The User selects "No" radio button for "Unsupervised HUT for Claim Support (excluding patch tests)?*" field under "HUT" subsection on Request Approvals tab 
		And The User enters all mandatory fields on "Request Approvals" tab for "HUT" Approval Request Type 
		And The User checks the "Not Applicable" checkbox 
		Then The User verifies "Toxicology/Clinical Safety Preliminary/HUT*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "APAC Regulatory Preliminary/HUT *" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verify selected approvers are listed under Approvals Needed in the right pane of the "Request Approvals" screen 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User verifies the information displayed in the "In Progress" tab for "Toxicology/Clinical Safety Preliminary/HUT" approval 
		And The User verifies the information displayed in the "In Progress" tab for "APAC Regulatory Preliminary/HUT" approval
		When The User click on "Cancel Workflow" link on In progress tab
		Then The User verifies "Are you sure you want to cancel the workflow?" message on the popup 
		When The User clicks on "Yes" button 
		Then The User verifies the success popup "Workflow Cancelled Successfully." 
		When The User clicks on "OK" button 
		And The User clicks on "Request Approvals" tab
		Then The User is on the Request Approvals tab 
		When The User selects "HUT" option for "Approval Request Type" field on Request Approvals tab 
		And The User selects "No" radio button for "Unsupervised HUT for Claim Support (excluding patch tests)?*" field under "HUT" subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Asia Pacific" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab
		And The User selects "Toxicology/Clinical Safety Preliminary/HUT*" Approver on Request Approvals tab
		And The User selects "APAC Regulatory Preliminary/HUT *" Approver on Request Approvals tab
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab
		Then The User logout from the "Product Development" application 
		When The User is logged into "Common Approval Module" application with "ToxicologyApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		Then The User verifies "Request Revision" is displayed on the GXP Approval Module page 
		When The User clicks on "Request Revision" button on the "GXP Approval Module" page 
		And The User enters value on "Request Revision" window 
		And The User clicks on "Send Request" button 
		Then The User verifies the success popup "Revision Request Sent" 
		When The User clicks on "OK" button 
		Then The User verifies "Resolve Revision" is displayed on the GXP Approval Module page 
		When The User clicks on "Resolve Revision" button on the "GXP Approval Module" page 
		And The User enters value on "Resolve Revision" window 
		And The User clicks on "Resolve" button 
		Then The User verifies the success popup "Revision Resolved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Approve" button 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		When The User clicks on "OK" button 
		Then The User logout from the "Common Approval Module" application 
		When The User is logged into "Common Approval Module" application with "APACRegulatoryApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		When The User clicks on "OK" button 
		Then The User logout from the "Common Approval Module" application 
		When The User is logged into "Product Development" application with "Formulator" role 
		Then The User is on "Product Development" Home page 
		When The User enters the FML ID in the Global search bar and click on Search icon 
		And The User selects the FML ID available link 
		And The User clicks on "Status" option on the PD Composition page 
		And The User clicks on "Completed Reviews" tab 
		Then The User verifies the information displayed in the "Completed Reviews" tab for "Toxicology/Clinical Safety Preliminary/HUT" approval 
		And The User verifies the information displayed in the "Completed Reviews" tab for "APAC Regulatory Preliminary/HUT" approval 
		And The User verifies the status circle displays "HUT"
		And The User logout from the "Product Development" application 
		When The User is logged into "Product Development" application with "PEDFormulator" role 
		Then The User is on "Product Development" Home page 
		When The User selects "Formula" option from the "New" menu on the Home page 
		And The User selects "PED Tablet" for "Formula Type*" field on Create New Formula page 
		And The User enters value for "Lab Notebook No.*" field on Create New Formula page 
		And The User enters value for "Description*" field on Create New Formula page 
		And The User clicks on "Create Formula" button on Create New Formula page 
		And The User enters created RMID in Search box and click on Search icon on the Composition tab 
		Then The User sets QS percentage 
		And The User clicks on "Save" button 
		Then The User verifies the success popup "Save was successful." 
		When The User clicks on "OK" button 
		And The User clicks on "Route for Approval" button 
		Then The User is on the Request Approvals tab 
		When The User selects "Approval for Scale Up" Request Type on Request Approvals tab 
		And The User clicks on "Add Additional Reviews" link on Request Approvals tab 
		And The User selects "HUT" check box on Request Approvals tab 
		And The User enters values for all mandatory fields for "Approval for Scale Up" on Data Required subsection on Request Approvals tab 
		And The User selects "Not Applicable" check box on Request Approvals tab 
		And The User selects "Asia Pacific" for "Region*" field on Inputs subsection on Request Approvals tab 
		And The User enters value for "Review Requested by*" field on Inputs subsection on Request Approvals tab 
		And The User selects "No" for "Unsupervised HUT for Claim Support (excluding patch tests)?*" mandatory field on HUT subsection on Request Approvals tab 
		And The User enters value for "HUT Description*" field on HUT subsection on Request Approvals tab 
		And The User selects "Europe, Middle East, Africa" for "HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User enters value for "Legal Product Category in HUT Region*" field on HUT subsection on Request Approvals tab 
		And The User selects "Toxicology/Clinical Safety Preliminary/HUT*" Approver on Request Approvals tab 
		And The User selects "R&D Preliminary*" Approver on Request Approvals tab 
		And The User selects "APAC Regulatory Preliminary *" Approver on Request Approvals tab 
		And The User selects "EMEA Regulatory Preliminary/HUT *" Approver on Request Approvals tab
		Then The User verifies "Toxicology/Clinical Safety Preliminary/HUT*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "APAC Regulatory Preliminary *" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "R&D Preliminary*" mandatory field on Required Approvers subsection on Request Approvals tab 
		And The User verifies "EMEA Regulatory Preliminary/HUT *" mandatory field on Required Approvers subsection on Request Approvals tab
		And The User verify selected approvers are listed under Approvals Needed in the right pane of the "Request Approvals" screen 
		And The User clicks on "Save" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow Data Saved Successfully" 
		When The User clicks on "OK" button 
		And The User clicks on "Launch Workflow" button on Request Approvals tab 
		Then The User verifies the success popup "Workflow launched successfully" 
		When The User clicks on "OK" button 
		Then The User verifies the system navigates to "In Progress" tab 
		And The User verify the information for "Toxicology/Clinical Safety Preliminary/HUT" Approver function in the In Progress tab 
		And The User verify the information for "APAC Regulatory Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "R&D Preliminary" Approver function in the In Progress tab 
		And The User verify the information for "EMEA Regulatory Preliminary/HUT" Approver function in the In Progress tab 
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
		When The User clicks on "OK" button 
		Then The User logout from the "Common Approval Module" application 
		When The User is logged into "Common Approval Module" application with "RDApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
		Then The User verifies the e-Signature window is displayed 
		When The User enter the Username and Password on the e-Signature window 
		And The User clicks on "I Agree" button on the e-Signature window 
		Then The User verifies the success popup "Task Approved Successfully" 
		When The User clicks on "OK" button 
		Then The User logout from the "Common Approval Module" application 
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
		Then The User logout from the "Common Approval Module" application
		When The User is logged into "Common Approval Module" application with "EMEARegulatoryApprover" role 
		And The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID to be approved in the Global search bar and click on Search icon 
		And The User selects the FML ID available link in "Common Approvals" module 
		And The User clicks on "Approve" button on the "GXP Approval Module" page 
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
		And The User clicks on "Completed Reviews" tab 
		Then The User verify the information for "Toxicology/Clinical Safety Preliminary/HUT" Approval in the Completed Reviews tab 
		And The User verify the information for "APAC Regulatory Preliminary" Approval in the Completed Reviews tab 
		And The User verify the information for "R&D Preliminary" Approval in the Completed Reviews tab 
		And The User verify the information for "EMEA Regulatory Preliminary/HUT" Approval in the Completed Reviews tab 
		And The User verifies the Formula is in "Approved for Scale-Up" status 
		And The User verifies the status circle displays "HUT"
		And The User logout from the "Product Development" application