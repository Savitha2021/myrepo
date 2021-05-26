@AAWO-4388
Feature: Formula Composition screen for common approval module - Formula/ Formula-Custom WF/PED/PED Tablet/Tablet

	Background:
		#@AAWO-4318
		Given Test environment is initialized
		

	#Tests As an authorized approver , I can access the Formula Composition page of Common Approval Module so that I can view the formula information
	@AAWO-7640 @FullAutomation @Sprint-38
	Scenario Outline: Test Formula Composition screen for common approval module - Formula/ Formula-Custom WF/PED/PED Tablet/Tablet
		Given The User is logged into "Common Approval Module" application with "ToxicologyApprover" role 
		When The User selects "Formula" under search criteria dropdown 
		And The User enters the FML ID for "<FormulaType>" Formula Type in the Global search bar and click on Search icon 
		When The User click on the available FML ID link in "Common Approvals" module 
		And The User click on "Composition" tab on the GXP Approval Module page 
		Then The User verifies data cannot be modified in the "Composition" tab on the GXP Approval Module page 
		And The User verifies data cannot be Deleted in the "Composition" tab on the GXP Approval Module page 
		When The User click on "Attributes" tab on the GXP Approval Module page 
		Then The User verifies data cannot be modified in the "Attributes" tab on the GXP Approval Module page 
		And The User verifies data cannot be Deleted in the "Attributes" tab on the GXP Approval Module page 
		When The User click on "Properties" tab on the GXP Approval Module page 
		Then The User verifies data cannot be modified in the "Properties" tab on the GXP Approval Module page 
		And The User verifies data cannot be Deleted in the "Properties" tab on the GXP Approval Module page 
		When The User click on "Completed Approvals" tab on the GXP Approval Module page 
		Then The User verifies data cannot be modified in the "Completed Approvals" tab on the GXP Approval Module page 
		And The User verifies data cannot be Deleted in the "Completed Approvals" tab on the GXP Approval Module page 
		When The User click on "Chemical Composition" tab on the GXP Approval Module page 
		Then The User verifies data cannot be modified in the "Chemical Composition" tab on the GXP Approval Module page 
		And The User verifies data cannot be Deleted in the "Chemical Composition" tab on the GXP Approval Module page 
		And The User logout from the "Common Approval Module" application 
			
		Examples: 
			| FormulaType            	| 
			| Formula					|
			| Formula - Custom Workflow |
			| Tablet                    |
			| PED Formula				|
			| PED Tablet				| 