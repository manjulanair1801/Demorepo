package com.levi.api.mulesoft;

import static com.jayway.restassured.RestAssured.given;
//import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;
import cucumber.api.CucumberOptions;






import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.jayway.restassured.response.ValidatableResponse;
import com.levi.api.utils.CommonUtils;

import net.minidev.json.JSONObject;

public class CartValidation {


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

	public BaseSetUp baseSetUp;

	public CartValidation(String locale)
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

	public Response createAnonCartID(String generatedToken) {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		Response resp = given().
				parameter("Authorization", "bearer "+generatedToken).expect().statusCode(201).
				when().
				post(baseSetUp.anonCartID);
		
		return resp;

	}

	public Response convertAnonCartToGuest(String generatedToken, String generatedCartID) {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		Response resp = given().
				pathParam("UID", "anoncart@levi.com" ).contentType(ContentType.JSON).
				pathParam("guid", generatedCartID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).				
				when().
				put(baseSetUp.anonCartToGuest);
		return resp;

	}

	public Response createRegCartID(String generatedToken) {
		/*
		 * GUID AND ALLOCATED ORDER NUMBER
		 */
		Response resp = given().
				pathParam("UID", baseSetUp.UID).contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).//expect().statusCode(201).
				when().
				post(baseSetUp.regCartID);
		return resp;

	}

	public String validatePC9()
	{
		/*
		 * PRODUCTDATA + Select PC13
		 */
		resp = given().pathParam("PC9", baseSetUp.PC9).
				expect().statusCode(200).
				contentType(ContentType.JSON).
				when().get(baseSetUp.productData);
		
		String itemPrice = resp. 
				then().
				extract().
				path("price.formattedValue");
		Reporter.addStepLog("Price : " + itemPrice);

		String selectedpc9 = resp. 
				then(). 
				extract(). 
				path("code");


		selectedPC9 = selectedpc9;
		resp = given().pathParam("SelectedPC9", selectedpc9). 
				expect().statusCode(200).contentType(ContentType.JSON). 
				when().get(baseSetUp.selectPC13);
		
		
		String pc13 = selectedPC9 + "0" + baseSetUp.SIZE;
		SelectedPC13 = pc13;

		return pc13;

	}

	public Response addToAnonCart(String SelectedPC13, String generatedCartID)
	{

		/*
		 * ADD TO CART
		 */

		JSONObject childBody = new JSONObject();
		childBody.put("code", SelectedPC13); 
		childBody.put("qty", baseSetUp.QTY);
		JSONObject mainBody = new JSONObject();
		mainBody.put("product", childBody);

		resp = given().body(mainBody).
				pathParam("guid", generatedCartID).contentType(ContentType.JSON).
				//expect().statusCode(200).
				when().post(baseSetUp.addToAnonCart);

		return resp;


	}
	
	
	
	public Response addToAnonCartWithGift(String SelectedPC13, String generatedCartID,String generatedAccessToken,String locale)
	{

		/*
		 * ADD TO CART
		 */
		BaseSetUp baseSetUp=new BaseSetUp(locale);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("refreshCart","false");
		params.put("fields","FULL");
		JSONObject childBody = new JSONObject();
		childBody.put("code", SelectedPC13); 
		childBody.put("qty", baseSetUp.QTY);
		JSONObject mainBody = new JSONObject();
		mainBody.put("product", childBody);
		mainBody.put("quantity", 1);
		JSONObject egiftCardExtraInfo = new JSONObject();
		egiftCardExtraInfo.put("toName", baseSetUp.toName);
		egiftCardExtraInfo.put("fromName", baseSetUp.fromName);
		egiftCardExtraInfo.put("message", baseSetUp.message);
		egiftCardExtraInfo.put("recipientEmail", baseSetUp.recipientEmail);
		egiftCardExtraInfo.put("checkRecipientEmail", baseSetUp.recipientEmail);
		mainBody.put("egiftCardExtraInfo", egiftCardExtraInfo);

		resp = given().body(mainBody).queryParams(params).
				pathParam("guid", generatedCartID).contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedAccessToken).expect().statusCode(200).
				when().post(baseSetUp.addToAnonCart);

		return resp;

	}
	
	
	public Response editGiftInfo(String generatedCartID,String generatedAccessToken)
	{

		/*
		 * ADD TO CART
		 */
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("refreshCart","false");
		JSONObject childBody = new JSONObject();
	
		JSONObject mainBody = new JSONObject();
		mainBody.put("customerEmail", baseSetUp.fromNameChanged+"@gmail.com");
		mainBody.put("estimatedDeliveryDate", "2019-02-25T00:00:00+0000");
		JSONObject egiftCardExtraInfo = new JSONObject();
		egiftCardExtraInfo.put("toName",baseSetUp.toNameChanged);
		egiftCardExtraInfo.put("fromName",baseSetUp.fromNameChanged);
		egiftCardExtraInfo.put("message", baseSetUp.messageChanged);
		egiftCardExtraInfo.put("recipientEmail", baseSetUp.recipientEmailChanged);
		egiftCardExtraInfo.put("checkRecipientEmail",  baseSetUp.toNameChanged+"@gmail.com");
		ArrayList<Object>arrayList=new ArrayList<>();
		childBody.put("egiftCardExtraInfo", egiftCardExtraInfo);
		arrayList.add(childBody);
		mainBody.put("entries", arrayList);
		resp = given().body(mainBody).queryParams(params).
				pathParam("GUID", generatedCartID).contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedAccessToken).expect().statusCode(200).
				when().post(baseSetUp.updateAnnoCart);

		return resp;


	}
	

	public Response addToRegCart(String SelectedPC13, String generatedCartID, String generatedToken)
	{
		//testInfo = report.createTest("Test Scenario : Product");

		/*
		 * ADD TO CART
		 */

		JSONObject childBody = new JSONObject();
		childBody.put("code", SelectedPC13); 
		childBody.put("qty", baseSetUp.QTY);
		JSONObject mainBody = new JSONObject();
		mainBody.put("product", childBody);

		resp = given().body(mainBody).
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().post(baseSetUp.addToRegCart);

		return resp;


	}

	public Response addShippingAddressToGuestCart(String generatedCartID, String generatedToken, String locale)
	{
		/*
		 * ADD ADDRESS TO CART
		 */

		BaseSetUp.guestEmail = CommonUtils.GenerateRandomEmail();

		JSONObject mainBody = new JSONObject();
		mainBody.put("firstName", baseSetUp.firstName);
		mainBody.put("lastName", baseSetUp.lastName);
		mainBody.put("line1", baseSetUp.addrLine1);
		mainBody.put("line2", baseSetUp.addrLine2);
		mainBody.put("town", baseSetUp.town);

		JSONObject countryBody = new JSONObject();		
		countryBody.put("isocode", baseSetUp.isocode);
		mainBody.put("country", countryBody);

		if(locale.equalsIgnoreCase("us"))
		{
			JSONObject regionBody = new JSONObject();		
			regionBody.put("countryIso", baseSetUp.isocode);
			regionBody.put("isocode", baseSetUp.regionIsocode);
			regionBody.put("isocodeShort", baseSetUp.regionIsocodeShort);
			regionBody.put("name", baseSetUp.regionName);
			mainBody.put("region", regionBody);
		}
		mainBody.put("postalCode", baseSetUp.postalCode);
		mainBody.put("phone", baseSetUp.phone);
		mainBody.put("email", BaseSetUp.guestEmail);

		resp = given().body(mainBody).
				pathParam("guid", generatedCartID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(201).
				when().post(baseSetUp.createGuestShipAddress);				
		return resp;
	}

	public Response addBillingAddressToGuestCart(String generatedCartID, String locale)
	{
		/*
		 * ADD ADDRESS TO CART
		 */

		JSONObject mainBody = new JSONObject();
		mainBody.put("firstName", baseSetUp.firstName + " bill");
		mainBody.put("lastName", baseSetUp.lastName);
		mainBody.put("line1", baseSetUp.addrLine1+" bill");
		mainBody.put("line2", baseSetUp.addrLine2);
		mainBody.put("town", baseSetUp.town);

		JSONObject countryBody = new JSONObject();		
		countryBody.put("isocode", baseSetUp.isocode);
		mainBody.put("country", countryBody);

		if(locale.equalsIgnoreCase("us"))
		{
			JSONObject regionBody = new JSONObject();		
			regionBody.put("countryIso", baseSetUp.isocode);
			regionBody.put("isocode", baseSetUp.regionIsocode);
			regionBody.put("isocodeShort", baseSetUp.regionIsocodeShort);
			regionBody.put("name", baseSetUp.regionName);
			mainBody.put("region", regionBody);
		}
		mainBody.put("postalCode", baseSetUp.postalCode);

		resp = given().body(mainBody).
				pathParam("guid", generatedCartID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+BaseSetUp.generatedAnonToken).expect().statusCode(200).
				when().post(baseSetUp.createGuestBillAddress);				

		return resp;
	}

	public Response addBillingAddressToRegCart(String generatedCartID, String locale)
	{
		/*
		 * ADD ADDRESS TO CART
		 */

		JSONObject mainBody = new JSONObject();
		mainBody.put("firstName", baseSetUp.firstName + " bill");
		mainBody.put("lastName", baseSetUp.lastName);
		mainBody.put("line1", baseSetUp.addrLine1+" bill");
		mainBody.put("line2", baseSetUp.addrLine2);
		mainBody.put("town", baseSetUp.town);

		JSONObject countryBody = new JSONObject();		
		countryBody.put("isocode", baseSetUp.isocode);
		mainBody.put("country", countryBody);

		if(locale.equalsIgnoreCase("us"))
		{
			JSONObject regionBody = new JSONObject();		
			regionBody.put("countryIso", baseSetUp.isocode);
			regionBody.put("isocode", baseSetUp.regionIsocode);
			regionBody.put("isocodeShort", baseSetUp.regionIsocodeShort);
			regionBody.put("name", baseSetUp.regionName);
			mainBody.put("region", regionBody);
		}
		mainBody.put("postalCode", baseSetUp.postalCode);

		resp = given().body(mainBody).
				pathParam("guid", generatedCartID).
				pathParam("UID", baseSetUp.UID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+BaseSetUp.generatedToken).expect().statusCode(200).
				when().post(baseSetUp.createBillingAddress);				

		return resp;
	}

	public Response addAddressToRegUser(String UID)
	{
		/*
		 * ADD ADDRESS TO CART
		 */
		JSONObject mainBody = new JSONObject();
		mainBody.put("lastName", baseSetUp.firstName);
		mainBody.put("firstName", baseSetUp.lastName);
		mainBody.put("line1", baseSetUp.addrLine1);
		mainBody.put("line2", baseSetUp.addrLine2);
		mainBody.put("town", baseSetUp.town);

		JSONObject childBody = new JSONObject();		
		childBody.put("isocode", baseSetUp.isocode);
		mainBody.put("country", childBody);

		mainBody.put("postalCode", baseSetUp.postalCode);
		mainBody.put("phone", baseSetUp.phone);

		resp = given().body(mainBody).
				pathParam("UID", UID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+BaseSetUp.generatedToken).expect().statusCode(201).
				when().post(baseSetUp.createRegAddress);				

		return resp;
	}



	public Response setAddressToRegCart(String generatedCartID, String addressID)
	{
		/*
		 * SET ADDRESS TO CART
		 */
		JSONObject mainBody = new JSONObject();
		mainBody.put("", "");

		resp = given().body(mainBody).
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				pathParam("addressID", addressID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+BaseSetUp.generatedToken).expect().statusCode(200).
				when().put(baseSetUp.setRegAddress);				
		return resp;
	}
	public Response addInvalidAddressToRegCart(String generatedCartID, String locale)
	{
		/*
		 * ADD ADDRESS TO CART
		 */
		JSONObject mainBody = new JSONObject();
		mainBody.put("lastName", baseSetUp.firstName);
		mainBody.put("firstName", baseSetUp.lastName);
		mainBody.put("line1", baseSetUp.addrLine1);
		mainBody.put("line2", baseSetUp.addrLine2);
		mainBody.put("town", baseSetUp.town);

		JSONObject childBody = new JSONObject();		
		childBody.put("isocode", "XZ");
		mainBody.put("country", childBody);

		mainBody.put("postalCode", baseSetUp.postalCode);
		mainBody.put("phone", baseSetUp.phone);

		resp = given().body(mainBody).
				pathParam("UID", baseSetUp.UID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+BaseSetUp.generatedToken).expect().statusCode(400).
				when().post(baseSetUp.createRegAddress);				

		return resp;
	}
	public Response updateAddressToRegCart( String generatedCartID, String date, String email){
		JSONObject updateBody = new JSONObject();
		updateBody.put("estimatedDeliveryDate", date);
		updateBody.put("customerEmail", email);
		resp = given().body(updateBody).
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+BaseSetUp.generatedToken).//expect().
				when().post(baseSetUp.updateCart);
		return resp;
	}

	

	public Response addDeliveryToGuestCart(String generatedToken, String generatedCartID) {
		/*
		 * Add Delivery Method
		 */
		Response resp = given().
				pathParam("guid", generatedCartID).
				pathParam("dMode", baseSetUp.deliveryMode).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().
				put(baseSetUp.addGuestDelivery);

		return resp;

	}

	public Response addDeliveryToRegCart(String generatedToken, String generatedCartID) {
		/*
		 * Add Delivery Method
		 */
		Response resp = given().
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				pathParam("dMode", baseSetUp.deliveryMode).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().
				put(baseSetUp.addRegDelivery);

		return resp;

	}
	
	public Response viewCart(String generatedToken, String generatedCartID)
	{
		Response resp = given().
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().
				put(baseSetUp.viewRegCart);

		return resp;
	}

	public Response verifyDeliveryToRegCart(String generatedToken, String generatedCartID) {
		/*
		 * Verify Delivery Method
		 */
		Response resp = given().
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().
				get(baseSetUp.getRegDelivery);

		return resp;

	}
	public Response verifyDeliveryToRegCartForInvalidUID(String generatedToken, String generatedCartID) {
		/*
		 * Verify Delivery Method-- Invalid UID
		 */
		Response resp = given().
				pathParam("UID", "somail@gmail.com").
				pathParam("guid", generatedCartID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(400).
				when().
				get(baseSetUp.getRegDelivery);

		return resp;

	}
	public Response verifyDeliveryToRegCartForInvalidGUID(String generatedToken, String generatedCartID) {
		/*
		 * Add Delivery Method--Invalid GUID
		 */
		Response resp = given().
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(400).
				when().
				get(baseSetUp.getRegDelivery);

		return resp;

	}

	public Response addPaymentToRegCart(String paymentMethod, String generatedToken, String generatedCartID)
	{
		/*
		 * ADD ADDRESS TO CART
		 */
		JSONObject paymentDetails = new JSONObject();
		JSONObject cardType = new JSONObject();
		paymentDetails.put("accountHolderName", baseSetUp.accountHolderName);
		switch(paymentMethod.toLowerCase())
		{
		case "visa":
			paymentDetails.put("cardNumber", baseSetUp.visaCardNumber);
			cardType.put("code", "visa");
			paymentDetails.put("cardType", cardType);
			break;
		case "master":
			paymentDetails.put("cardNumber", baseSetUp.masterCardNumber);
			cardType.put("code", "mc");
			paymentDetails.put("cardType", cardType);
			break;
		case "amex":
			paymentDetails.put("cardNumber", baseSetUp.amexCardNumber);
			cardType.put("code", "amex");
			paymentDetails.put("cardType", cardType);
			break;
		case "maestro":
			paymentDetails.put("cardNumber", baseSetUp.maestroCardNumber);
			cardType.put("code", "maestro");
			paymentDetails.put("cardType", cardType);
			break;
		case "discover":
			paymentDetails.put("cardNumber", baseSetUp.discoverCardNumber);
			cardType.put("code", "discover");
			paymentDetails.put("cardType", cardType);
			break;
		case "diners":
			paymentDetails.put("cardNumber", baseSetUp.dinersCardNumber);
			cardType.put("code", "diners");
			paymentDetails.put("cardType", cardType);
			break;
		default:
			Reporter.addStepLog("Wrong Card type selected: "+paymentMethod);
		}		

		paymentDetails.put("expiryMonth", baseSetUp.expiryMonth);
		paymentDetails.put("expiryYear", baseSetUp.expiryYear);


		JSONObject billingAddress = new JSONObject();
		billingAddress.put("firstName", baseSetUp.firstName);
		billingAddress.put("lastName", baseSetUp.lastName);		
		billingAddress.put("line1", baseSetUp.addrLine1);
		billingAddress.put("line2", baseSetUp.addrLine2);
		billingAddress.put("postalCode", baseSetUp.postalCode);
		billingAddress.put("town", baseSetUp.town);

		JSONObject country = new JSONObject();		
		country.put("isocode", baseSetUp.isocode);
		billingAddress.put("country", country);
		paymentDetails.put("billingAddress", billingAddress);

		paymentDetails.put("saved", true);
		paymentDetails.put("adyenPaymentMethod", baseSetUp.adyenPaymentMethod);
		paymentDetails.put("defaultPayment", false);

		resp = given().body(paymentDetails).
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				contentType(ContentType.JSON).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(201).
				when().post(baseSetUp.addPaymentRegCart);				
		return resp;
	}

	public Response viewAndValidateCart(String generatedCartID)
	{/*
	 * VIEW ANON CART
	 */

		resp = given().
				pathParameter("guid", generatedCartID).
				when().get(baseSetUp.viewCart);
		return resp;	

	}

	public Response viewAndValidateCartREG(String generatedCartID)
	{/*
	 * VIEW REG CART
	 */

		resp = given().
				pathParameter("guid", generatedCartID).expect().statusCode(200).
				when().get(baseSetUp.viewCart);
		return resp;	

	}
	
	
	
	
	public Response viewAndValidateCartWithGiftWrap(String generatedCartID)
	{/*
	 * VIEW ANON CART
	 */
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("refreshCart","false");
		params.put("fields","FULL");
		resp = given().queryParams(params).
				pathParameter("guid", generatedCartID).
				when().get(baseSetUp.viewCart);
		return resp;	

	}

	public Response createGuestCyberSourceHOPForm(String generatedToken, String generatedCartID)
	{

		String mainBody = "receiptUrl="+baseSetUp.baseURL+"&merchantPostUrl="+"leviUSSite/checkout/payment/cybersource/merchantpost";


		Response resp = given().
				body(mainBody).contentType(ContentType.URLENC).
				pathParam("guid", generatedCartID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().
				post(baseSetUp.createGuestCybHOPForm);
		
		return resp;
	}

	public Response createRegCyberSourceHOPForm(String generatedToken, String generatedCartID)
	{

		String mainBody = "receiptUrl="+baseSetUp.baseURL+"&merchantPostUrl="+"leviUSSite/checkout/payment/cybersource/merchantpost";

		Response resp = given().
				body(mainBody).contentType(ContentType.URLENC).
				pathParam("UID", baseSetUp.UID).
				pathParam("guid", generatedCartID).
				header("Authorization", "bearer "+generatedToken).expect().statusCode(200).
				when().
				post(baseSetUp.createRegCybHOPForm);

		return resp;
	}
	
	public Response deleteHybrisCartUsingMuleSoftAuth(String generatedMuleSoftToken, String OrderID)
	{
		Response resp = given().
				pathParam("allocatedOrderNumber", OrderID).
				header("Authorization", "bearer "+generatedMuleSoftToken).//expect().statusCode(200).
				when().
				delete(baseSetUp.deleteHybrisCartUsingMuleSoft);
		return resp;
	}

}

