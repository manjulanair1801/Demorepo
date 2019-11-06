Feature: Gift card Validaion
 
@HEAD-1223_1 @Regression
Scenario Outline: Validate schema for EGC
Given User validates the schema for EGC for locale "<Locale>"
Examples:
|Locale|
|US|


@HEAD-1223_2 @Regression
Scenario Outline: Validate schema for PGC
Given User validates the schema for PGC for locale "<Locale>"
Examples:
|Locale|
|US|
