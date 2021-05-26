@AEMQ-1111112
Feature: CAPRI Home-001 test case 
Background: 
#@AAWO-4318
	Given Test environment is initialized 
	
@AEMQ-1111112
Scenario: CAPRI Home-001 test case 
	Given The "Coordinator" is logged into CAPRI application 
	Then  The Capri Homepage is displayed with My APRs (selected by default), My Favorites and All APRs views 
	And Tile (Selected by default) and List modes are displayed 
	When The User searches "Prerequisite3" APR 
	Then searched APR is displayed on the home page 
	When The User searches "Prerequisite4" APR 
	Then searched APR is not displayed on the home page 	