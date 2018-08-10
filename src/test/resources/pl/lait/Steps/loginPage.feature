Feature: Login page test  

Scenario: Open main page and click in top bar links
	Given I open main page
	When I click SIGN-ON link
	Then I should see login page
