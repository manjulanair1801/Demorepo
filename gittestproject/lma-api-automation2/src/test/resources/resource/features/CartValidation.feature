Feature: Cart Page Hybris API
 
@AddCart @Regression
Scenario Outline: Validate add to cart feature
	Given User generates anon auth token for "<Locale>"
	Then User creates a anonymous cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to cart for "<Locale>"
	And User view the cart and validate for "<Locale>"
Examples:
|Locale|
|US|
#|GB|

@HEAD-656 @Regression 
Scenario Outline: HEAD-656 - Convert anon cart to Guest cart
	Given User generates anon auth token for "<Locale>"
	Then User creates a anonymous cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to cart for "<Locale>"
	Then User converts anon cart to guest cart for "<Locale>"
	Examples:
	|Locale|
#	|GB|

@HEAD-740 @HEAD-914 @Regression
Scenario Outline: HEAD-740, HEAD-665 Guest-Cybersource API-US Only
	Given User generates anon auth token for "<Locale>"
	Then User creates a anonymous cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to cart for "<Locale>"
	Then User converts anon cart to guest cart for "<Locale>"
	Then User adds shipping address to guest cart for "<Locale>"
	Then User sets billing address to guest cart for "<Locale>"
	Then User add delivery method to guest cart for "<Locale>"
	Then User creates Guest HOP form for cybersource for "<Locale>"
Examples:
|Locale|
|US|

@HEAD-665 @HEAD-914 @Regression
Scenario Outline: HEAD-740, HEAD-665 Registered-Cybersource API-US Only
	Given User generates registered auth token for "<Locale>"
	Then User creates a registered cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to registered cart for "<Locale>"
	And User add address to registered user for "<Locale>"
	And User sets address to registered cart for "<Locale>"
	Then User sets billing address to registered cart for "<Locale>"
	Then User add delivery method to registered cart for "<Locale>"
	Then User creates Registered HOP form for cybersource for "<Locale>"
Examples:
|Locale|
|US|
	
@HEAD-129 @HEAD-554 @HEAD-220 @Regression
Scenario Outline: HEAD-129, HEAD-554 - Validate registered user Delivery method feature
	Given User generates registered auth token for "<Locale>"
	Then User creates a registered cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to registered cart for "<Locale>"
	And User add address to registered user for "<Locale>"
	And User sets address to registered cart for "<Locale>"
	#Then User verifies delivery method to registered cart for "<Locale>"
	Then User verifies delivery method for invalid UID for "<Locale>"
	Then User verifies delivery method for invalid GUID for "<Locale>"
	Examples:
	|Locale|
#	|GB|
	
@HEAD-712 @Regression
Scenario Outline: HEAD-712 - Validate GUEST user cart customerEmail from shipping address
	Given User generates anon auth token for "<Locale>"
	Then User creates a anonymous cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to cart for "<Locale>"
	Then User converts anon cart to guest cart for "<Locale>"
	Then User adds shipping address to guest cart for "<Locale>"
	And User checks email in the Guest cart for "<Locale>"
	Examples:
	|Locale|
	|US|
	
@HEAD-261 @HEAD-678 @Regression
Scenario Outline: HEAD-261, HEAD-678- Validate update cart feature
	Given User generates registered auth token for "<Locale>"
	Then User creates a registered cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to registered cart for "<Locale>"
	And User add address to registered user for "<Locale>"
	And User sets address to registered cart for "<Locale>"
	Then User add delivery method to registered cart for "<Locale>"
	And User add "<Payment>" method to registered cart for "<Locale>"
	Then User update product to registered cart for "<Locale>"
	Examples:
	|Locale||Payment|
#	|GB||Visa|

@HEAD-655 @Regression 
Scenario Outline: HEAD-655 - Validate load cart feature for Annonymous User
	Given User generates anon auth token for "<Locale>"
	Then User creates a anonymous cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to cart for "<Locale>"
	Examples:
	|Locale|
#	|GB|
	
@HEAD-561 @Regression 
Scenario Outline: HEAD-561 - Validate registered user checkout feature
	Given User generates registered auth token for "<Locale>"
	Then User creates a registered cart for "<Locale>"
	And User validates PC9 with size for "<Locale>"
	Then User adds product to registered cart for "<Locale>"
	And User add invalid address to registered cart for "<Locale>"
	Examples:
	|Locale|
#	|GB|
	
@HEAD-1222 @Regression
Scenario Outline:[Hybris] - Add extra info to Cart while adding E-Gift Card to Cart and update extra info to Cart while checkout
	Given User generates anon auth token for "<Locale>"
	Then User creates a anonymous cart for "<Locale>"
	Then User adds product to cart for "<Locale>" using gift details
	Then user validates the gift attributes in the response for "<Locale>" 
	Then User edits gift wrap info for "<Locale>"
	Then user validates the gift attributes in the response for "<Locale>" after editing	
	Examples:
	|Locale|
	|US|
	