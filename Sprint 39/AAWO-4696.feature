@AAWO-4696
Feature: Formula Composition Tab (Custom WF) - Actions dropdown - Select Mark As Trace/Text option

  Background: 
    #@AAWO-7399
    Given Test environment is initialized
    When The User is logged into "RAW Materials Module" application with "RMCuser" role
    Then The User creates "2" raw material for "Custom Workflow"
    Then The User logout from the "RAW Materials Module" application

  @AAWO-7427 @FullAutomation @Sprint-39
  Scenario Outline: Test Formula Composition Tab (Custom WF) - Actions dropdown - Select Mark As Trace/Text option
    Given The User is logged into "Product Development" application with "<User>" role
    Then The User is on "Product Development" Home page
    When The User selects "Formula" option from the "New" menu on the Home page
    And The User selects "<FormulaType>" for "Formula Type*" field on Create New Formula page
    And The User enters value for "Lab Notebook No.*" field on Create New Formula page
    And The User enters value for "Description*" field on Create New Formula page
    And The User clicks on "Create Formula" button on Create New Formula page
    When The User enters created RMID in Search box and click on Search icon on the Composition tab
    Then The User sets QS percentage
    And The User clicks on "Save" button
    Then The User verifies the success popup "Save was successful."
    And The User clicks on "OK" button
    When The User selects the RAW added
    And The User clicks on "Action" dropdown on Composition tab
    And The User selects "Mark as Trace/Text" option from Action dropdown on Composition tab
    Then The User verify "Not In Calc" value is displayed under "Percentage (%w/w)" column for marked RAW
    Then The User verify "Not In Calc" value is displayed under "Percentage (%w/v)" column for marked RAW
    And The User verify "Trace" value is displayed under "Weight(mg)" column for marked RAW
    And The User clicks on "Save" button
    Then The User verifies the success popup "Save was successful."
    And The User clicks on "OK" button
    When The User edit value under "Weight(mg)" column for marked RAW
    Then The User verify edited value is displayed under "Weight(mg)" column for marked RAW
    Then The User verify selected RAW is not included from the total percentage calculation
    And The User logout from the "Product Development" application

    Examples: 
      | User          | FormulaType               |
      | Formulator    | Formula - Custom Workflow |
      | Formulator    | Tablet                    |
      | RMCuser       | Formula - Custom Workflow |
      | RMCuser       | Tablet                    |
      | PEDFormulator | Formula - Custom Workflow |
      | PEDFormulator | Tablet                    |
      | PEDFormulator | PED Formula               |
      | PEDFormulator | PED Tablet                |
