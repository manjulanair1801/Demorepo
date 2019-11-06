package com.levi.api.mulesoft;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;

import net.minidev.json.JSONObject;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.levi.api.utils.CommonUtils;

public class MyAccountValidation {


	public ExtentHtmlReporter htmlReporter;
	public ExtentReports report;
	public ExtentTest testInfo;

	public Response resp;



	public BaseSetUp baseSetUp;

	public MyAccountValidation(String locale)
	{
		baseSetUp = new BaseSetUp(locale);
	}


	public void setup(String locale) throws Exception {

		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/target/AOSLSEHappyScenario.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extentReport-config.xml"));
		report=new ExtentReports();
		report.setSystemInfo("Environment", "Headless");
		report.attachReporter(htmlReporter);
	}



	public Response getSavedAddress(String generatedToken)
	{
		//testInfo = report.createTest("Test Scenario : Product");

		/*
		 * GET SAVED ADDRESS
		 */

		resp = given().
				pathParam("UID", baseSetUp.UID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().get(baseSetUp.getSavedAddress);

		return resp;


	}

	public Response markSavedAddressDefault(String generatedToken, String addressID)
	{
		//testInfo = report.createTest("Test Scenario : Product");

		/*
		 * MARK SAVED ADDRESS DEFAULT
		 */

		JSONObject body = new JSONObject();
		body.put("defaultAddress", "true"); 

		resp = given().
				body(body).
				pathParam("UID", baseSetUp.UID).
				pathParam("ADDRID", addressID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).				
				when().patch(baseSetUp.markAddressDefault);

		return resp;


	}
	
	public Response removeAddressFromRegCart(String mailID, String addressID)
	{
		resp = given().
				pathParam("UID", mailID).
				pathParam("addressID", addressID).
				header("Authorization", "bearer "+BaseSetUp.generatedToken).expect().statusCode(200).
				when().delete(baseSetUp.deleteRegAddress);	

		return resp;
	}

	public Response getSavedPayment(String generatedToken)
	{
		//testInfo = report.createTest("Test Scenario : Product");

		/*
		 * GET SAVED ADDRESS
		 */

		resp = given().
				pathParam("UID", baseSetUp.SAVEDPAYUID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().get(baseSetUp.getSavedPayment);
		
		return resp;


	}

	public Response markSavedPaymentDefault(String generatedToken, String paymentID)
	{

		JSONObject body = new JSONObject();
		body.put( "defaultPayment", "true"); 
		resp = given().
				body(body).
				pathParam("UID", baseSetUp.SAVEDPAYUID).
				pathParam("PAYMENTID", paymentID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).				
				when().patch(baseSetUp.markPaymentDefault);

		return resp;


	}

	public Response getListofConsents(String generatedToken)
	{
		JSONObject body = new JSONObject();
		body.put("", ""); 
		resp= given().
				body(body).
				pathParam("UID", baseSetUp.UID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200)
				.when().get(baseSetUp.listOfConsentdata);

		return resp;
	}
	public Response geSpecificofConsents(String consentTemplateId,String generatedToken)
	{
		JSONObject body = new JSONObject();
		body.put("", ""); 
		resp= given().
				body(body).
				pathParam("UID", baseSetUp.UID).
				pathParam("consentTemplateId", consentTemplateId).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200)
				.when().get(baseSetUp.specificConsentData);		
		return resp;
	}
	public Response checkWithdrawnConsent(String consentTemplateId,String generatedToken)
	{
		JSONObject body = new JSONObject();
		body.put("", ""); 
		resp= given().
				body(body).
				pathParam("UID", baseSetUp.UID).
				pathParam("consentTemplateId", consentTemplateId).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200)
				.when().get(baseSetUp.specificConsentData);

		return resp;
	}
	public Response addConsent(String generatedToken)
	{
		/*JSONObject body = new JSONObject();

		body.put("", ""); */

		resp= given().
				//body(body).
				pathParam("UID", baseSetUp.UID).
				contentType(ContentType.URLENC).
				formParam("consentTemplateId",baseSetUp.CONSENTTEMPLATEID).
				formParam("consentTemplateVersion",baseSetUp.CONSENTTEMPLATEVERSION).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(201)
				.when().post(baseSetUp.addConsent);

		return resp;
	}
	public Response deleteConsent(String consentId,String generatedToken){
		JSONObject body = new JSONObject();
		body.put("", ""); 
		resp= given().
				body(body).
				pathParam("UID", baseSetUp.UID).
				pathParam("consentCode", consentId).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200)
				.when().delete(baseSetUp.deleteConsentdata);

		return resp;
	}

	public Response trackOrderWithEmail(String option, String generatedToken)
	{
		if(option.equalsIgnoreCase("valid"))
		{
			resp= given().
					pathParam("UID", baseSetUp.trackOrderEmail).
					pathParam("ORDERID", baseSetUp.trackOrderID).
					header("Authorization", "bearer "+generatedToken).expect().statusCode(200)
					.when().post(baseSetUp.trackOrderByMailandID);
		}
		else if(option.equalsIgnoreCase("invalid"))
		{
			resp= given().
					pathParam("UID", "invalidmail@gmail.com").
					pathParam("ORDERID", baseSetUp.trackOrderID).
					header("Authorization", "bearer "+generatedToken).expect().statusCode(200)
					.when().post(baseSetUp.trackOrderByMailandID);
		}
		return resp;
	}

	public Response updateRegisteredProfile(String option, String generatedToken, String emailID)
	{	

		if(option.equalsIgnoreCase("valid"))
		{
			BaseSetUp.newRegisteredEmail = CommonUtils.GenerateRandomEmail();
			JSONObject body = new JSONObject();
			body.put("uid", BaseSetUp.newRegisteredEmail);
			body.put("firstName", baseSetUp.firstName +"_changed"); 
			body.put("lastName", baseSetUp.lastName+"_changed"); 

			resp = given().
					body(body).contentType(ContentType.JSON).
					pathParam("UID", emailID).					
					header("Authorization", "bearer "+generatedToken).expect().statusCode(200).				
					when().patch(baseSetUp.updateRegProfile);
			
		}
		else if(option.equalsIgnoreCase("invalid"))
		{
			JSONObject body = new JSONObject();
			body.put("uid", emailID);
			body.put("firstName", ""); 
			body.put("lastName", ""); 

			resp = given().
					body(body).contentType(ContentType.JSON).
					pathParam("UID", emailID).					
					header("Authorization", "bearer "+generatedToken).expect().statusCode(400).				
					when().patch(baseSetUp.updateRegProfile);
		}
		else if(option.equalsIgnoreCase("existing"))
		{
			JSONObject body = new JSONObject();
			body.put("uid", baseSetUp.UID);
			body.put("firstName", "firstname"); 
			body.put("lastName", "lastname"); 

			resp = given().
					body(body).contentType(ContentType.JSON).
					pathParam("UID", emailID).					
					header("Authorization", "bearer "+generatedToken).expect().statusCode(400).				
					when().patch(baseSetUp.updateRegProfile);
		}
		return resp;
	}

	public Response viewRegisteredProfile(String generatedToken, String emailID)
	{			

		resp = given().
				pathParam("UID", emailID).					
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).				
				when().get(baseSetUp.viewRegProfile);
		return resp;
	}


}
