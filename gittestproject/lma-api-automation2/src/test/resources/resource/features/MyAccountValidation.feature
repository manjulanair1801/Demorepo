Feature: My Account Hybris API
	 
@HEAD-144 @Regression
Scenario Outline: HEAD-144 - Make shipping address default
	Given User generates registered auth token for "<Locale>"
	Given User pulls first non default shipping address for "<Locale>"
	Given User marks one address as default for "<Locale>"
Examples:
|Locale|
|GB|

@HEAD-767 @Regression
Scenario Outline: HEAD-767 - REG User Shipping address related scenarios
	Given User generates registered auth token for "<Locale>"
	Given User add address to registered user "<MailID>" for "<Locale>"
	Then User removes added address of user "<MailID>" for "<Locale>"
	Given User add address to registered user "<MailID>" for "<AnotherLocale>"
	Then User removes added address of user "<MailID>" for "<Locale>"
	Given User add address to registered user "<MailID>" for "<Locale>"
	Then User pulls first non default shipping address for "<Locale>"
	And User marks one address as default for "<Locale>"
	Given User pulls first non default shipping address for "<AnotherLocale>"
	Then User marks one address as default for "<Locale>"
	
Examples:
|Locale||MailID||AnotherLocale|
|US||somemail@gmail.com||GB|
|GB||somemail@gmail.com||US|



@HEAD-125 @HEAD-790 @Regression
Scenario Outline: HEAD-125 - Make Payment detail default
	Given User generates registered auth token of savedpayment user for "<Locale>"
	Given User pulls first non default payment method for "<Locale>"
	Given User marks one payment as default for "<Locale>"
	Then User checks if required payment id is marked default for "<Locale>"
Examples:
|Locale|
|GB|
|US|

@HEAD-100 @Regression
Scenario Outline: HEAD-100 - Fetch List of Consents
	Given User generates registered auth token for "<Locale>"
	Given User adds consents for "<Locale>"
	Given User pulls list of consents used by Customer "<Locale>"
	Then User pulls specific consent "<consentTemplateId>" for customer in "<Locale>"
	Given User Delete consent "<consentTemplateId>" for customer in "<Locale>"
Examples:
|Locale|consentTemplateId|
|GB|TERMS_OF_USE|

@HEAD-170
Scenario Outline: HEAD-170 - Track Order service to match email and order number
	Given User generates anon auth token for "<Locale>"
	Then Track Order service to match "valid" email and order number for "<Locale>"
	Then Track Order service to match "invalid" email and order number for "<Locale>"
Examples:
|Locale|
|US|
|GB|

@HEAD-77 @Regression
Scenario Outline: HEAD-77 - Validate profile update related scenarios.
	Given User generates anon auth token for "<Locale>"
	Given User creates registered user with optin for "<Locale>"
	Then User updates registered user with "valid" data for "<Locale>"
	And User views and validates if profile update is successful for "<Locale>"
	Then User updates registered user with "invalid" data for "<Locale>"
	Then User updates registered user with "existing" data for "<Locale>"
Examples:
|Locale|
|US|
|GB|

@HEAD-347 @Regression
Scenario Outline: HEAD-347 - Validate update with valid password scenario.
	Given User generates anon auth token for "<Locale>"
	Given User creates registered user with optin for "<Locale>"
	Then User updates the password with "Valid" data for registered user for "<Locale>"
	
Examples:
|Locale|
|US|
|GB|

@HEAD-347 @Regression
Scenario Outline: HEAD-347 - Validate update with invalid password scenario.
	Given User generates anon auth token for "<Locale>"
	Given User creates registered user with optin for "<Locale>"
	Then User updates the password with "InValid" data for registered user for "<Locale>"
	Then User updates the password with "Existing" data for registered user for "<Locale>"
	Then User updates the password with "Mismatch" data for registered user for "<Locale>"
	
Examples:
|Locale|
|US|
|GB|