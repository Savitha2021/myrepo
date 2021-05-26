@AAWO-4280 
Feature: Create a New Formula 

Background: 
#@AAWO-4318
	Given Test environment is initialized 
	
	
	#Tests As an authorized user (Formulator/PED Formulator or RMC user), I want to access the new formula creation screen so that I can create a New Formula / Formula - Custom Workflow/ PED Formula / Tablet/ PED Tablet/ Chassis/ Premix
@AAWO-6762 @FullAutomation @Sprint-37 
Scenario Outline: Test Create a New Formula 
	Given The User is logged into "Product Development" application with "<User>" role 
	Then The User is on "Product Development" Home page 
	When The User selects "Formula" option from the "New" menu on the Home page 
	Then The User verifies Formula is the default value of Formula Type field 
	And The User verifies Formula Type options for "<User>" role 
	When The User selects "<FormulaType>" for "Formula Type*" field on Create New Formula page 
	Then The User verifies mandatory fields for "<FormulaType>" type on Create New Formula page 
	And The User verifies non mandatory fields for "<FormulaType>" type on Create New Formula page 
	And The User verifies "Copy from Formula" field is disabled on Create New Formula page 
	When The User enters mandatory fields for "<FormulaType>" type on Create New Formula page 
	And The User clicks on "Cancel" button on Create New Formula page 
	Then The User is on "Product Development" Home page 
	When The User selects "Formula" option from the "New" menu on the Home page 
	And The User selects "<FormulaType>" for "Formula Type*" field on Create New Formula page 
	And The User enters mandatory fields for "<FormulaType>" type on Create New Formula page 
	And The User clicks on "Create Formula" button on Create New Formula page 
	Then The User verifies "Composition" page is displayed 
	And The User logout from the "Product Development" application 
	
	Examples: 
		|User	      |FormulaType              |
		|Formulator   |Formula					|
		|Formulator   |Formula - Custom Workflow|
		|Formulator   |Tablet					|
		|Formulator   |Premix					|
		|Formulator   |Chassis					|
		|RMCuser      |Formula					|
		|RMCuser      |Formula - Custom Workflow|
		|RMCuser      |Tablet					|
		|RMCuser      |Premix					|
		|RMCuser      |Chassis					|
		|PEDFormulator|Formula					|
		|PEDFormulator|Formula - Custom Workflow|
		|PEDFormulator|Tablet					|
		|PEDFormulator|Premix					|
		|PEDFormulator|Chassis					|
		|PEDFormulator|PED Formula				|	
		|PEDFormulator|PED Tablet				|