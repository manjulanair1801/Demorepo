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

public class PDPValidation {


	public ExtentHtmlReporter htmlReporter;

	public ExtentReports report;

	public ExtentTest testInfo;

	public Response resp;

	
	public BaseSetUp baseSetUp;
	
	public PDPValidation(String locale)
	{
		baseSetUp = new BaseSetUp(locale);
	}

	
	public Response getProductDetails() {		
		/*
		 * PRODUCT DATA		
		 */
		Response resp;
		resp = given().
				pathParam("PC9", baseSetUp.PC9).contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.productData);
		return resp;
		

	}
	public Response getSEODetails(String field) {		
		/*
		 * PRODUCT DATA		
		 */
		Response resp;
		resp = given().
				pathParam("PC9", baseSetUp.PC9).pathParam("field", field).contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.productSEOData);
		return resp;
		

	}
	
	public Response validateSwatchData() {		
		/*
		 * SWATCH DATA		
		 */
		Response resp;
		resp = given().
				pathParam("PC9", baseSetUp.PC9).contentType(ContentType.JSON).
				expect().statusCode(200).
				when().
				get(baseSetUp.swatchData);
		
		return resp;
		

	}

}
