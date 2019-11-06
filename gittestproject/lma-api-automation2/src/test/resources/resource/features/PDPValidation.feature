@Regression
Feature: PDP related Hybris API

@PDP @Regression
Scenario Outline: Validate product details
	Given User validates product detail for "<Locale>"
	And User checks the swatch data for "<Locale>"
Examples:
|Locale|
|GB|
|US|

@HEAD-69
Scenario Outline: Validate SEO deatils in product
	Given User validates SEO detail for "<Locale>" in PDP page where field is "<Field>"
Examples:
|Locale||Field|
|GB||FULL|
|GB||DEFAULT|
|GB||BASIC|
|GB||PDP|
|US||FULL|
|US||DEFAULT|
|US||BASIC|
|US||PDP|


@LMA @LMA-196
Scenario Outline: Validate Product Swatches API - Mulesoft
	Given User generates Mulesoft Auth Token for "<Locale>"
	#Given User validates product detail for "<Locale>"
	#And User checks the swatch data for "<Locale>"
Examples:
|Locale|
|US|
