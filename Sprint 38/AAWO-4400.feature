@AAWO-4400
Feature: Save As From Tablet to Tablet

  Background: 
    #@AAWO-7398
    Given Test environment is initialized
    When The User is logged into "RAW Materials Module" application with "RMCuser" role
    Then The User creates raw material for "Custom Workflow"
    Then The User logout from the "RAW Materials Module" application

  #Tests As an authorized system user (Formulator/PED Formulator/RMC), I can access the Formula Module – Formula Composition page so that I will be able to click on Save As button from Tablet to create Tablet 
  @AAWO-7513 @PartialAutomation @Sprint38
  Scenario Outline: Test Save As From Tablet to Tablet
    Given The User is logged into "Product Development" application with "<Users>" role
    When The User selects "Formula" option from the "New" menu on the Home page
    And The User selects "Tablet" for "Formula Type*" field on Create New Formula page
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
    When The User clicks on "Formula" header icon
    Then The User verifies that the "Save as..." button is enabled in Formula Composition screen
    When The User clicks on "Save as..." button
    Then The User verifies that "Create New Formula" page is displayed
    And The User verifies the fieldname "Formula Type*"  is displayed
    When The User selects "Tablet" for "Formula Type*" field on Create New Formula page
    Then The User verifies the fieldname "Lab Notebook No.*"  is displayed
    And The User verifies the fieldname "Description*"  is displayed
    And The User verifies the fieldname "Associate to Project"  is displayed
    And The User verifies the fieldname "Associate to Chassis"  is displayed
    And The User verifies the fieldname "Copy from Formula"  is displayed
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
    And The User logout from the "Product Development" application

    Examples: 
      | Users         |
      | RMCuser       |
      | Formulator    |
      | PEDFormulator |
