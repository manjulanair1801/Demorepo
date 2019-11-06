Feature: Base Store related API

@HEAD-99 @HEAD-965 @HEAD-1018
Scenario Outline: HEAD-99, HEAD-965 HEAD-1018 HEAD-1077 - Validate Store Services
	Then User validates detail of BaseStore for "<Locale>"
	And validate SEO related tags in basestore detail for "<Locale>"
Examples:
|Locale|
|US|
|GB|


@HEAD-101 @Regression
Scenario Outline: HEAD-101 - Validate Store Services
	Then User validates country detail of BaseStore for "<Locale>"
Examples:
|Locale|
|GB|
|US|

@HEAD-101 @Regression
Scenario Outline: HEAD-101 - Validate Store Services
	Then User validates region detail of BaseStore for "<Locale>"
Examples:
|Locale|
|US|


@HEAD-449
Scenario Outline: HEAD-449 - Validate Find a Store Services
	Then User validates find a store service using Location "<Location>" with radius "<Radius>" for "<Locale>"
	And User validates find a store service using Latitude "<Latitude>" and Longitude "<Longitude>" with radius "<Radius>" for "<Locale>"
Examples:
|Location||Latitude||Longitude||Radius||Locale|
|London||52.369292||4.884013||5||GB|
|Amsterdam||52.369292||4.884013||20||GB|

@SEEU-438
Scenario Outline: SEEU-438 - Validate omsShipCode for the applicable regions
#This scenario will only work for the locales having value for omsShipCode configured in Hybris,currently not configured for SEEU
	Then User validates omsShipCode of BaseStore for applicable "<Locale>"
Examples:
|Locale|
|US|
|CA|
