package com.levi.api.mulesoft;

import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class StoreValidation {


	//public ExtentHtmlReporter htmlReporter;

	//public ExtentReports report;

	//public ExtentTest testInfo;

	public Response resp;
	

	String generatedUid;
	String selectedPC9;
	String SelectedPC13;
	String AddedCartValue;
	String QuantityAdded;
	String AllocatedOrderNumber;
	String ViewCartValue;

	public BaseSetUp baseSetUp;
	
	public StoreValidation(String locale)
	{
		baseSetUp = new BaseSetUp(locale);
	}
	



	public Response getBaseStoreDetails() {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		Response resp = given().
				pathParam("baseStoreUid", baseSetUp.baseStoreID).
				expect().statusCode(200).
				when().
				get(baseSetUp.baseStoreDetails);
		
		return resp;

	}
	
	public Response getCountryDetails() {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		Response resp = given().
				expect().statusCode(200).
				when().
				get(baseSetUp.countryDetails);

		return resp;

	}
	
	public Response getRegionDetails() {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		
		Response resp = given().
				pathParam("countyIsoCode",baseSetUp.isocode).
				expect().statusCode(200).
				when().
				get(baseSetUp.regionDetails);
		return resp;

	}
	
	
	public Response getProductDetails() {
	
		Response resp =given().get(baseSetUp.productDetails);
		return resp;

	}
	
	
	public Response getstoreDirectory(String country,String query) {

Map<String,Object> params = new HashMap<String,Object>();
		params.put("countryIsoCode",query);
		params.put("fields","FULL");
		resp = given().queryParams(params).contentType(ContentType.JSON).expect().statusCode(200).
				when().get(baseSetUp.storeDirectory);

		return resp;

	}
	
	
	public Response getStoreDetailsByLocation(String location, String radius) {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		Response resp = given().
				pathParam("country",location).
				pathParam("radius",radius).
				expect().statusCode(200).
				when().
				get(baseSetUp.storeByLocation);
		return resp;

	}

	public Response getStoreDetailsByGeoLocation(String latitude,String longitude, String radius) {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		Response resp = given().
				pathParam("latitude",latitude).
				pathParam("longitude",longitude).
				pathParam("radius",radius).
				expect().statusCode(200).
				when().
				get(baseSetUp.storeByGeoLocation);
		return resp;
	}





}
