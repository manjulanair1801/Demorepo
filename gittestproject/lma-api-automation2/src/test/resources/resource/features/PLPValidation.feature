@PLP
Feature: PLP related Hybris API
	 

Scenario Outline: HEAD-373 - Validate PLP sort
	Given User validates "<Category>" detail with sort "<SortType>" for "<Locale>"
Examples:
|Category||SortType||Locale|
|levi_clothing_women||price-asc||US|


Scenario Outline: HEAD-285 - Validate category breadcrumbs
	Given User validates breadcrumbs for "<Category>" service for "<Locale>"
Examples:
|Category||Locale|
|levi_clothing_women_jeans||US|
|levi_clothing_men_jeans||US|


Scenario Outline: HEAD-139,HEAD-383,HEAD-283 - Validate PLP category Services
	Given User validates "<Category>" detail for "<Locale>"
Examples:
|Category||Locale|
|levi_clothing_women_jeans||US|
|levi_clothing_men_jeans||US|


Scenario Outline: HEAD-69 - Validate SEO Details
	Given User validates SEO details for "<Category>" service for "<Locale>" where fields are "<Field>"
Examples:
|Category||Locale||Field|
|levi_clothing_women_jeans||US||FULL|
|levi_clothing_women_jeans||US||DEFAULT|
|levi_clothing_women_jeans||US||BASIC|



#MuleSoft - 
@SEEU-439
Scenario Outline: Validate different facets
	Given User validates facet "<facet>" detail for "<Locale>"
Examples:
|facet||Locale|
|jeans:relevance:feature-material:100% Cotton||US|

