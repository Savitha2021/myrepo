@Content-003 
Feature: CAPRI Content-003 test case 
Background: 
#@AAWO-4318
	Given Test environment is initialized 
	
@Content-003
Scenario: CAPRI Content-003 test case 

	Given The "Author" is logged into CAPRI system 
	When User navigates to preferences page 
	Then The following filters are displayed 
		|Date|
		|Brand|
		|Category|
		|ProdType|
		|Region|
		|Status|