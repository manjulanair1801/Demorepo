package com.levi.api.mulesoft;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;




import java.util.HashMap;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;

public class PLPValidation {


	public ExtentHtmlReporter htmlReporter;

	public ExtentReports report;

	public ExtentTest testInfo;

	public Response resp;

	
	public BaseSetUp baseSetUp;
	
	public PLPValidation(String locale)
	{
		baseSetUp = new BaseSetUp(locale);
	}

	
	public Response getCategorySortedDetails(String category, String sortType) {		
		/*
		 * PRODUCT DATA		
		 */
		
		Response resp;
		resp = given().
				pathParam("sortType", sortType).
				pathParam("category", category).
				pathParam("queryData", "511 slim:relevance\\:productItemType:Jeans").
				contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.categorySort);
		return resp;
		

	}
	
	public Response getCategoryPDIFFGrouping(String category, String groupingFlag) {		
		/*
		 * CATEGORY DATA		
		 */
		
		Response resp;
		resp = given().
				pathParam("category", category).
				pathParam("groupingFlag", groupingFlag).
				contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.categoryPDIFF);
		return resp;

	}
	
	public Response getSearchDataWithPDIFFGrouping(String query, String groupingFlag) {		
		/*
		 * SEARCH DATA		
		 */
		Response resp;
		resp = given().
				pathParam("query", query).
				pathParam("groupingFlag", groupingFlag).
				contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.searchWithPDIFF);
		return resp;

	}
	
	
	
	public Response validateCategoryData(String category) {		
		/*
		 * PRODUCT DATA		
		 */
		Response resp;
		resp = given().
				pathParam("category", category).contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.categoryDetails);

		return resp;
		

	}
	
	
	
	public Response validatefacet(String category) {		
		/*
		 * PRODUCT DATA		
		 */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("query", category);
		params.put("fields", "FULL");
		Response resp;
		resp = given().
				queryParams(params).contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.searchWithFacet);

		return resp;
		

	}
	
	public Response getCategoryBreadCrumbDetails(String category ,String field) {		
		/*
		 * PRODUCT DATA		
		 */
		Response resp;
		resp = given().
				pathParam("category", category).pathParam("field", field).contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.categoryPage);
		return resp;
		

	}
	public Response getCategorySEODetails(String category, String field) {		
		/*
		 * PRODUCT DATA		
		 */
		Response resp;
		resp = given().
				pathParam("category", category).pathParam("field", field).contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.categoryPage);
		return resp;
		
	}

}
