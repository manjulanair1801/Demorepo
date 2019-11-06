package com.levi.api.mulesoft;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GiftCardValidation {

	public ExtentHtmlReporter htmlReporter;

	public ExtentReports report;

	public ExtentTest testInfo;

	public Response resp;

	String generatedUid;
	String selectedPC9;
	String SelectedPC13;
	String AddedCartValue;
	String QuantityAdded;
	String AllocatedOrderNumber;
	String ViewCartValue;
	File resourceDir;

	public BaseSetUp baseSetUp;

	public GiftCardValidation(String locale) {
		baseSetUp = new BaseSetUp(locale);

	}

	public void getGiftCardDetailsEgc() {

		resourceDir = new File("src/test/resource/json-schema/giftSchema.json");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("giftCardType", "ELECTRONIC_GIFTCARD");

		resp = given().queryParams(params).contentType(ContentType.JSON).expect().statusCode(200).when()
				.post(baseSetUp.giftCardDetail);
		String filepath = resourceDir.getAbsolutePath();
		resp.then().assertThat().body(matchesJsonSchema(new File(filepath)));
       

	}

	public void  getGiftCardDetailsPgc() {
		resourceDir = new File("src/test/resource/json-schema/giftSchema.json");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("giftCardType", "PHYSICAL_GIFTCARD");

		resp = given().queryParams(params).contentType(ContentType.JSON).expect().statusCode(200).when()
				.post(baseSetUp.giftCardDetail);
		String filepath = resourceDir.getAbsolutePath();
		resp.then().assertThat().body(matchesJsonSchema(new File(filepath)));
	

	}

}
