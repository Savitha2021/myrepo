@testAPR 
Feature: CAPRI Home-006 

Background: 
	Given Test environment is initialized 
	
Scenario: APR creation 
	Given The "Coordinator" is logged into CAPRI system 
	Then Click Parent APR button 
	Then Populate the below fields 
	#   | APR Title  | Product Type            | APR region | Country |
		| test APR1  | Other (Non Standard)	   |       AP   | India |
	Then Click Create button 
	Then User logs out of CAPRI system 
	
	
	
	
