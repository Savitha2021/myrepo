@Preferences-001 
Feature: CAPRI Preferences-001 test case 
Background: 
#@AAWO-4318
	Given Test environment is initialized 
	
@Preferences-001 
Scenario: CAPRI Home-001 test case 
	Given The "Coordinator" is logged into CAPRI system 
	When User navigates to preferences page 
	Then The following filters are displayed 
		|Date|
		|Brand|
		|Category|
		|ProdType|
		|Region|
		|Status|
		|MfgSite|
		|APRType|
	When User selects one Brand value, two or more categories and statuses In progress and Approved 
	And clicks Apply Filter button and then clicks Save button 
	Then The selected filters are displayed with x icon 
	And The Tile and List mode are displayed 
	And My APRs, My Favorites and All APRs views are displayed 
	When User selects "ListMode" Mode and "AllAPRs" view and Save 
	And User Navigates to Home page 
	Then The "List" mode and "All APRs" view and selected filters are displayed 
	
	Then User logs out of CAPRI system 
	When The "Coordinator" is logged into CAPRI system 
	Then The "List" mode and "All APRs" view and selected filters are displayed 
	When User navigates to preferences page 
	And User clicks x icon for Approved status and clicks Apply filters button 
	Then Approved status is removed from Filters section 
	When User selects "TileMode" Mode and "MyAPRs" view and Save 
	And User Navigates to Home page 
	Then The "Tile" mode and "My APRs" view and remaining filters are displayed 
	When User navigates to preferences page 
	And Click Clear Filters button and Save 
	Then user verifies that all the applied filters are removed 
	When User Navigates to Home page 
	Then user verifies that all the applied filters are removed 
	Then User logs out of CAPRI system 
	
	
	
	
	
	
	
	
	
	
