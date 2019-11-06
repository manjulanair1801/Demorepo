Feature: Login Related Hybris API
	 
@HEAD-103 @HEAD-785 @HEAD-356 @Regression
Scenario Outline: HEAD-103, HEAD-785 - Create registered user with optin
	Given User generates anon auth token for "<Locale>"
	Given User creates registered user with optin for "<Locale>"
	Given User creates registered user with invalid mailid for "<Locale>"
	Given User creates registered user with same mailid and password for "<Locale>"
	Then User login using the new registered mailID for "<Locale>"
Examples:
|Locale|
|US|
# |GB|


@HEAD-750 @Regression
Scenario Outline: [Hybris] - Employee Registration - Login and Post processor
	Given User generates anon auth token for "<Locale>"
	Then Validate successful Employee log in for "<Locale>"
Examples:
|Locale|
# |GB|
|US|

#@LMA-200 @Regression
Scenario Outline: LMA-200 - Validate if user account exists
	Given User generates anon auth token for "<Locale>"
	Then Validate if user exists for "valid" user id "<validID>" for "<Locale>"
	And Validate if user exists for "invalid" user id "<invalidID>" for "<Locale>"
Examples:
|Locale||validID||invalidID|
|US||somemail@gmail.com||invalidmail@mail.com|

