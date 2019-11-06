@PDiff
Feature: PDIFF related Hybris API for PLP
	 

Scenario Outline: PDIFF - Validate PLP sort
	Given User validates "<Category>" detail with PDIFF Grouping "true" for "<Locale>"
Examples:
|Category||Locale|
|levi_clothing_men||US|



Scenario Outline: PDIFF - Validate PLP sort
	Given User validates search with free text "<Query>" having PDIFF Grouping "true" for "<Locale>"
Examples:
|Query||Locale|
|Jeans||US|


