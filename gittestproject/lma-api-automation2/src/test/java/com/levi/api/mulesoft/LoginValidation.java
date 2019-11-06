package com.levi.api.mulesoft;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

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
import com.cucumber.listener.Reporter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.levi.api.utils.CommonUtils;

import net.minidev.json.JSONObject;

public class LoginValidation {


	public ExtentHtmlReporter htmlReporter;

	public ExtentReports report;

	public ExtentTest testInfo;

	public Response resp;


	public BaseSetUp baseSetUp;

	public LoginValidation(String locale)
	{
		baseSetUp = new BaseSetUp(locale);
	}

	public Response authToken() {		
		/*
		 * AUTH TOKEN		
		 */
		Response resp;
		Map<String,String> params = new HashMap<String,String>();
		params.put("client_id", "headless_rest_client");
		params.put("client_secret", "Levis1234");
		params.put("grant_type", "client_credentials");

		resp = given().parameters(params).
				expect().statusCode(200).contentType(ContentType.JSON).
				when().
				post(baseSetUp.authToken);
		return resp;


	}
	
	
	public Response muleAuthToken() {		
		/*
		 * MULE AUTH TOKEN		
		 */
		resp = given()
             .auth()
             .preemptive()
             .basic("0oampy2lbp7qNqI3L0h7", "cpXO_2VqZigvwvCdJVWHso13yLCtuPDCrc1E9ufo")
             .headers(
                       "Content-Type", "application/x-www-form-urlencoded",
                       "Accept","application/json")
             .urlEncodingEnabled(true)
             .param("grant_type","client_credentials")
             .param("scope", "READ")
             .when().log().all().expect().statusCode(200)
             .post("https://levi.oktapreview.com/oauth2/ausgprvmuwQSxyuyP0h7/v1/token").then()
             .extract().response();
		
		return resp;
				
	}

	public Response regAuthToken(String UID, String PWD) {		
		/*
		 * AUTH TOKEN		
		 */
		Response resp;
		Map<String,String> params = new HashMap<String,String>();
		params.put("client_id", "headless_rest_client");
		params.put("client_secret", "Levis1234");
		params.put("grant_type", "client_credentials");
		params.put("username", UID);
		params.put("password", PWD);

		resp = given().parameters(params).
				expect().statusCode(200).contentType(ContentType.JSON).
				when().
				post(baseSetUp.authToken);
		return resp;


	}
	
	public Response muleSoftAuthToken() {		
		/*
		 * AUTH TOKEN		
		 */
		Response resp;
		Map<String,String> params = new HashMap<String,String>();
		params.put("client_id", "mulesoft_rest_client");
		params.put("client_secret", "mule1234");
		params.put("grant_type", "client_credentials");

		resp = given().parameters(params).
				expect().statusCode(200).contentType(ContentType.JSON).
				when().
				post(baseSetUp.authToken);
		return resp;


	}

	public Response createRegUser(String locale, String generatedToken, String option) {		
		/*
		 * CREATE REG USER		
		 */
		Response resp;
		String mailID;
		if(locale.equalsIgnoreCase("us"))
		{
			BaseSetUp.newRegisteredEmail = CommonUtils.GenerateRandomEmail();
			Map<String,Object> params = new HashMap<String,Object>();
			if(option.equalsIgnoreCase("invalidmailid"))
			{
				params.put("login", "invalid@levi");
			}
			else
			{
				params.put("login", BaseSetUp.newRegisteredEmail);
			}
			if(option.equalsIgnoreCase("idpwdsame"))
			{
				params.put("password", BaseSetUp.newRegisteredEmail);
			}
			else
			{
				params.put("password", baseSetUp.PWD);
			}
			params.put("firstName", baseSetUp.firstName);
			params.put("lastName", baseSetUp.lastName);
			params.put("personalizedOffer", true);
			params.put("optIn", true);
			params.put("leviID", CommonUtils.GenerateRandomString());

			resp = given().parameters(params).
					header("Authorization", "bearer "+generatedToken).
					when().
					post(baseSetUp.createUser);
			
			Reporter.addStepLog("User Registration Successful with mail " + BaseSetUp.newRegisteredEmail);
			return resp;

		}
		else if(locale.equalsIgnoreCase("gb"))
		{
			BaseSetUp.newRegisteredEmail = CommonUtils.GenerateRandomEmail();
			JSONObject mainBody = new JSONObject();
			if(option.equalsIgnoreCase("invalidmailid"))
			{
				mainBody.put("uid", "invalid@levi");
			}
			else
			{
				mainBody.put("uid", BaseSetUp.newRegisteredEmail);
			}
			if(option.equalsIgnoreCase("idpwdsame"))
			{
				mainBody.put("password", BaseSetUp.newRegisteredEmail);
			}
			else
			{
				mainBody.put("password", baseSetUp.PWD);
			}
			mainBody.put("firstName", baseSetUp.firstName);
			mainBody.put("lastName", baseSetUp.lastName);			
			mainBody.put("personalizedOffer", false);
			mainBody.put("leviID", CommonUtils.GenerateRandomString());
			mainBody.put("optIn", true);

			resp = given().body(mainBody).contentType(ContentType.JSON).
					header("Authorization", "bearer "+generatedToken).
					when().
					post(baseSetUp.createUser);

			Reporter.addStepLog("User Registration Successful with mail " + BaseSetUp.newRegisteredEmail);
			return resp;


		}

		return null;

	}



	public Response loginUsingRegisteredMail(String locale, String generatedToken) {		
		/*
		 * AUTH TOKEN		
		 */
		Response resp;

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("newLogin", BaseSetUp.newValidRegisteredEmail);
        params.put("password", baseSetUp.PWD);
		params.put("leviID", CommonUtils.GenerateRandomString());

		resp = given().parameters(params).
				header("Authorization", "bearer "+generatedToken).
				pathParam("UID", BaseSetUp.newValidRegisteredEmail).
				expect().statusCode(200).
				when().
				put(baseSetUp.loginUser);
		Reporter.addStepLog("User Login Successful with mail " + BaseSetUp.newValidRegisteredEmail);
		return resp;


	}

	
	public Response empLogin(String locale, String generatedToken) {		
		/*
		 * AUTH TOKEN		
		 */
		Response resp;

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("secretKey","Valencia1906");
		resp = given().parameters(params).
				header("Authorization", "bearer "+generatedToken).
				expect().statusCode(200).
				when().
				post(baseSetUp.loginEmployee);
		Reporter.addStepLog("User Login Successful with mail " + BaseSetUp.newRegisteredEmail);
return resp;


	}

	
	
	
	public Response updatePasswordforREGUser(String option,String generatedToken, String mailID) {		
		/*
		 * Update PWD		
		 */
		Response resp;

		Map<String,Object> params = new HashMap<String,Object>();


		if(option.equalsIgnoreCase("valid"))
		{
			params.put("oldPassword", baseSetUp.PWD);
			params.put("newPassword", baseSetUp.newPWD);
			params.put("confirmedNewPassword",baseSetUp.newPWD );
		}
		else if(option.equalsIgnoreCase("invalid"))
		{
			params.put("oldPassword", baseSetUp.newPWD);
			params.put("newPassword", baseSetUp.newPWD);
			params.put("confirmedNewPassword",baseSetUp.newPWD );
		}
		else if(option.equalsIgnoreCase("existing"))
		{
			params.put("oldPassword", baseSetUp.PWD);
			params.put("newPassword", baseSetUp.PWD);
			params.put("confirmedNewPassword",baseSetUp.PWD );
		}
		else if(option.equalsIgnoreCase("mismatch"))
		{
			params.put("oldPassword", baseSetUp.PWD);
			params.put("newPassword", baseSetUp.newPWD);
			params.put("confirmedNewPassword","Pass@3214" );
		}

		resp = given().parameters(params).
				header("Authorization", "bearer "+generatedToken).
				pathParam("UID", mailID).
				when().
				put(baseSetUp.updateRegPassword);
		return resp;
	}

	public Response validateIfUserExists(String locale, String generatedToken, String userID) {		

		Response resp;
		System.out.println("validateUser: "+baseSetUp.validateUser);
		resp = given().
				header("Authorization", "bearer "+generatedToken).
				pathParam("UID", userID).
				expect().statusCode(200).
				when().
				post(baseSetUp.validateUser);
		return resp;


	}
}
