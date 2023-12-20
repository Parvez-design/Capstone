
Feature: Login feature

  Scenario Outline: Login and verify the Title
    Given Launch url and verify the title of the page
    When Enter multiple "<slNo>" username and password and submit
    Then verify the login is successful or not
    
    Examples:
    	|slNo|
			|1|
			|2|
			|3|
			|4|
			|5|
			|6|
			|7|