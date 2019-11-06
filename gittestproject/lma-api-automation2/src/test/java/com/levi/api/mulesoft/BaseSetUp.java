package com.levi.api.mulesoft;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.levi.api.utils.PropertyReader;

public class BaseSetUp {
	
	public static HashMap<String, Integer> testRailStatus = new HashMap<String, Integer>();
	
	public static final String BASEURL = "https://{env}.levi-site.com/rest/v2/levi{locale}Site";
	public static final String BASEURL2 = "https://{env}.levi-site.com/rest/v2";
	public static final String BASEAUTH = "https://{env}.levi-site.com";
	public static final String MULEBASEAUTH = "https://mule-test.levi.com";
	//Mulesoft API Base URL: https://mule-test.levi.com/omni-ecom-mobile-exp-api-test/v1
	public static final String SCAN = "/leviGBSite/products/scan?code={EAN}&fields=FULL";
	public static final String ANONCARTID = "/users/anonymous/carts";
	public static final String ANONCARTTOGUEST = "/users/anonymous/carts/{guid}/email?email={UID}&refreshCart=false";
	public static final String REGCARTID = "/users/{UID}/carts";
	public static final String AUTHTOKEN = "/authorizationserver/oauth/token";
	public static final String MULEAUTHTOKEN = "/authorizationserver/oauth/token";
	public static final String PRODUCTDATA = "/products/{PC9}";
	public static final String PRODUCTSEODATA = "/products/{PC9}?fields={field}";
	public static final String LISTOFCONSENTSDATA = "/users/{UID}/consenttemplates";
	public static final String SPECIFICCONSENTDATA = "/users/{UID}/consenttemplates/{consentTemplateId}";
	public static final String DELETECONSENTDATA = "/users/{UID}/consents/{consentCode}";
	public static final String ADDCONSENT = "/users/{UID}/consents";
	public static final String SWATCHDATA = "/products/{PC9}/swatches";
	public static final String SELECTEDPC13 = "/products/{SelectedPC9}/swatches";
	public static final String ADDTOANONCART = "/users/anonymous/carts/{guid}/entries?refreshCart=false&calculateTaxesExternally=true";
	public static final String ADDTOREGCART = "/users/{UID}/carts/{guid}/entries?refreshCart=false&calculateTaxesExternally=true";
	public static final String VIEWCART = "/users/anonymous/carts/{guid}/?refreshCart=false&fields=FULL&recalculateCart=true";
	public static final String VIEWREGCART = "/users/{UID}/carts/{guid}/?refreshCart=false&fields=FULL&recalculateCart=true";	
	public static final String CHECKOUT = "/users/anonymous/carts";	
	public static final String CREATEGUESTSHIPADDRESS = "/users/anonymous/carts/{guid}/addresses/delivery/?refreshCart=false&calculateTaxesExternally=true";
	public static final String CREATEGUESTBILLADDRESS = "/users/anonymous/carts/{guid}/checkout/payment/cybersource/billing-address?refreshCart=false&savePaymentDetails=false&calculateTaxesExternally=true";
	public static final String CREATEREGADDRESS = "/users/{UID}/addresses";
	public static final String SETREGADDRESS = "/users/{UID}/carts/{guid}/addresses/delivery?addressId={addressID}&calculateTaxesExternally=true";
	public static final String DELETEREGADDRESS = "/users/{UID}/addresses/{addressID}";
	public static final String CREATEREGBILLADDRESS = "/users/{UID}/carts/{guid}/checkout/payment/cybersource/billing-address?refreshCart=false&savePaymentDetails=false&calculateTaxesExternally=true";
	public static final String ADDGUESTDELIVERY = "/users/anonymous/carts/{guid}/deliverymode?deliveryModeId={dMode}&refreshCart=false&calculateTaxesExternally=true";
	public static final String ADDREGDELIVERY = "/users/{UID}/carts/{guid}/deliverymode?deliveryModeId={dMode}&refreshCart=false&calculateTaxesExternally=true";
	public static final String GETREGDELIVERY = "/users/{UID}/carts/{guid}/deliverymodes"; 
	public static final String ADDPAYMENTREGCART = "/users/{UID}/carts/{guid}/paymentdetails/?calculateTaxesExternally=true";
	public static final String CHECKOUTREGORDER ="/users/{UID}/orders?cartId={guid}&refreshCart=false";
	public static final String CATEGORYSORT = "/categories/{category}/products?query={queryData}sort={sortType}&fields=FULL";
	public static final String CATEGORYPDIFF = "/categories/{category}/products?enableGrouping={groupingFlag}&fields=FULL";
	public static final String SEARCHWITHPDIFF = "/products/search?query={query}&enableGrouping={groupingFlag}&fields=FULL";
	public static final String SEARCHWITHFACET="/products/search";
	public static final String CATEGORYDETAILS = "/categories/{category}/products?fields=FULL";
	public static final String CATEGORYPAGE = "/categories/{category}/products?fields={field}";
	public static final String GETSAVEDADDR = "/users/{UID}/addresses";
	public static final String MARKADDRDEFAULT = "/users/{UID}/addresses/{ADDRID}";
	public static final String GETSAVEDPAYMENT = "/users/{UID}/paymentdetails";
	public static final String MARKPAYMENTDEFAULT = "/users/{UID}/paymentdetails/{PAYMENTID}";//?defaultPaymentInfo=true";
	public static final String CREATEUSER ="/users";
	public static final String LOGINUSER ="/users/{UID}/login";
	public static final String VALIDATEUSER ="/users/userExists?userId={UID}";
	public static final String BASESTOREDETAILS = "/basestores/{baseStoreUid}?fields=FULL";
	public static final String COUNTRYDETAILS = "/countries";
	public static final String REGIONDETAILS = "/countries/{countyIsoCode}/regions";
	public static final String UPDATECART = "/users/{UID}/carts/{guid}/updateCart?refreshCart=false&calculateTaxesExternally=true";
	public static final String CREATEGUESTCYBHOPFORM = "/users/anonymous/carts/{guid}/checkout/payment/cybersource/sa/hop?refreshCart=false&calculateTaxesExternally=true";
	public static final String CREATEREGCYBHOPFORM = "/users/{UID}/carts/{guid}/checkout/payment/cybersource/sa/hop?refreshCart=false&calculateTaxesExternally=true";
	public static final String TRACKORDERBYEMAIL = "/checkOrder?email={UID}&code={ORDERID}";
	public static final String UPDATEREGUSERPROFILE = "/users/{UID}";
	public static final String UPDATEREGUSERPASSWORD = "/users/{UID}/password";
	public static final String VIEWREGUSERPROFILE = "/users/{UID}";
	public static final String STOREBYGEOLOCATION = "/stores?latitude={latitude}&longitude={longitude}&radius={radius}&fields=FULL";
	public static final String STOREBYCOUNTRY = "/stores?query={country}&radius={radius}&fields=FULL";
	public static final String DELETECARTBYMULESOFTAUTH = "/mulesoft/carts/{allocatedOrderNumber}";
    public static final String EMP = "/employees/425615/validate";
    public static final String UPDATEANOCART = "/users/anonymous/carts/{GUID}/updateCart";
    public static final String GIFTCARDETAIL = "/products/getGiftCardDetail";
    public static final String PRODUCTDETAIL = "/products/19627007602630?fields=FULL";
    public static final String STOREDIRECTORY="/stores/directory";
	public String baseURL;
	public String baseURL2;
	public String baseAUTH;
	public String PC9;
	public String SIZE;
	public String QTY;
	
	//public static final String DELIVERYMETHOD;
	//public static final String SELECTDELIVERYMETHOD;
	//public static final String RESERVEINVENTORY;	
	//public static final String STOREIDASSOID;
	//public static final String PAYMENT;
	//public static final String STOCKAVAILABILITY;
	//public static final String PROMO;
	//public static final String PLACEORDER;
	
	
	/********** End points **********/
	public String authToken;
	public String muleauthToken;
	public String anonCartID;
	public String anonCartToGuest;
	public String regCartID;
	public String productData;
	public String productSEOData;
	public String listOfConsentdata;
	public String specificConsentData;
	public String deleteConsentdata;
	public String addConsent;
	public String selectPC13;
	public String addToAnonCart;
	public String addToRegCart;
	public String viewCart;
	public String viewRegCart;
	public String updateCart;
	public String checkOut;
	public String createGuestShipAddress;
	public String createGuestBillAddress;
	public String createRegAddress;
	public String deleteRegAddress;
	public String setRegAddress;
	public String createBillingAddress;
	public String getRegDelivery;
	public String addGuestDelivery;
	public String addRegDelivery;
	public String addPaymentRegCart;
	public String checkoutRegOrder;
	public String swatchData;
	public String categorySort;
	public String categoryPDIFF;
	public String searchWithPDIFF;
	public String searchWithFacet;
	public String categoryPage;
	public String getSavedAddress;
	public String markAddressDefault;
	public String getSavedPayment;
	public String markPaymentDefault;
	public String createUser;
	public String loginUser;
	public String validateUser;
	public String categoryDetails;
	public String baseStoreDetails;
	public String countryDetails;
	public String regionDetails;
	public String createGuestCybHOPForm;
	public String createRegCybHOPForm;
	public String trackOrderByMailandID;
	public String updateRegProfile;
	public String updateRegPassword;
	public String viewRegProfile;
	public String storeByLocation;
	public String storeByGeoLocation;
	public String deleteHybrisCartUsingMuleSoft;
	public String deleteHybrisCartUsingMuleSoftReg;
	public String loginEmployee;
	public String updateAnnoCart;
	public String giftCardDetail;
	public String storeDirectory;
	
	/********** Variable **********/
	public String firstName;
	public String lastName;
	public String addrLine1;
	public String addrLine2;
	public String town;
	public String isocode;
	public String regionIsocode;
	public String regionIsocodeShort;
	public String regionName;
	public String postalCode;
	public String phone;
	public String deliveryMode;
	public String accountHolderName;
	public String visaCardNumber;
	public String masterCardNumber;
	public String amexCardNumber;
	public String maestroCardNumber;
	public String discoverCardNumber;
	public String dinersCardNumber;
	public String expiryMonth;
	public String expiryYear;
	public String adyenPaymentMethod;
	public String baseStoreID;
	public String estimatedDeliveryDate;
	public String trackOrderEmail;
	public String trackOrderID;
	public String UID;
	public String SAVEDPAYUID;
	public String PWD;
	public String newPWD;
	public String CONSENTTEMPLATEID;
	public String CONSENTTEMPLATEVERSION;
	public String toName;
	public String fromName;
	public String message;
	public String recipientEmail;
	public String toNameChanged;
	public String fromNameChanged;
	public String messageChanged;
	public String recipientEmailChanged;
	public String productDetails;
	
	/********** Static Variable **********/
	
	public static String generatedToken;
	public static String generatedTokenSavedPayment;
	public static String generatedAnonToken;
	public static String generatedMuleSoftToken;
	public static String generatedCartID;
	public static String guestEmail;
	public static String newRegisteredEmail;
	public static String newValidRegisteredEmail;
	public static String newAddedAddressID;
	public static String allocatedOrderNumber;
	
	
	
	public BaseSetUp(String locale)
	{
		//String testData = System.getProperty("testData").toLowerCase();
		String path = "src/test/resource/testdata/";
		String filePathVariable, filePathStatic = null;
		
		filePathVariable = System.getProperty("testEnv").trim()+"-test-data.properties";
		//File file =new File(filePathVariable);
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+file.getAbsolutePath());
		filePathStatic = "test-data.properties";
		
		PropertyReader readerVariable = new PropertyReader(path.concat(filePathVariable));
		PropertyReader readerStatic = new PropertyReader(path.concat(filePathStatic));
		List<Map<String, String>> testDataMap = new LinkedList<Map<String,String>>();
		
		//SCAN = reader.getData("scanBarCode");
		if(locale.equalsIgnoreCase("us"))
		{
			UID = readerVariable.getData("usUID");
			SAVEDPAYUID = readerVariable.getData("usSAVEDPAYUID");
			PWD = readerVariable.getData("usPWD");
			PC9 = readerVariable.getData("usPC9");
			SIZE = readerVariable.getData("usSize");
			QTY = readerVariable.getData("usQty");
			town = readerStatic.getData("ustown");
			isocode = readerStatic.getData("usisocode");
			regionIsocode = readerStatic.getData("usRegionIsocode");
			regionIsocodeShort = readerStatic.getData("usRegionIsocodeShort");
			regionName = readerStatic.getData("usRegionName");
			postalCode = readerStatic.getData("uspostalCode");
			phone = readerStatic.getData("usphone");
			deliveryMode = readerStatic.getData("usDeliveryMode");
			trackOrderEmail = readerStatic.getData("usOrderEmail");
			trackOrderID = readerStatic.getData("usOrderID");
			baseStoreID = readerStatic.getData("usBaseStoreID");
			baseURL = BASEURL.replace("{locale}", locale).replace("{env}",System.getProperty("testEnv"));
			toName=readerVariable.getData("toName");
			fromName= readerVariable.getData("fromName");
			message=readerVariable.getData("message");
			recipientEmail=readerVariable.getData("recipientEmail");
			toNameChanged=readerVariable.getData("toNameChanged");
			fromNameChanged=readerVariable.getData("fromNameChanged");
			messageChanged=readerVariable.getData("messageChanged");
			recipientEmailChanged=readerVariable.getData("recipientEmailChanged");	
			
		}
		else if(locale.equalsIgnoreCase("gb"))
		{
			UID = readerVariable.getData("gbUID");
			SAVEDPAYUID = readerVariable.getData("gbSAVEDPAYUID");
			PWD = readerVariable.getData("gbPWD");
			PC9 = readerVariable.getData("gbPC9");
			SIZE = readerVariable.getData("gbSize");
			QTY = readerVariable.getData("gbQty");
			town = readerStatic.getData("gbTown");
			isocode = readerStatic.getData("gbIsocode");
			postalCode = readerStatic.getData("gbPostalCode");
			phone = readerStatic.getData("gbPhone");
			deliveryMode = readerStatic.getData("gbDeliveryMode");
			trackOrderEmail = readerStatic.getData("gbOrderEmail");
			trackOrderID = readerStatic.getData("gbOrderID");
			baseStoreID = readerStatic.getData("gbBaseStoreID");
			baseURL = BASEURL.replace("{locale}", "GB").replace("{env}",System.getProperty("testEnv"));
		}
		else if(locale.equalsIgnoreCase("pl"))
		{
			UID = readerVariable.getData("plUID");
			PWD = readerVariable.getData("plPWD");
			PC9 = readerVariable.getData("plPC9");
			SIZE = readerVariable.getData("plSize");
			QTY = readerVariable.getData("plQty");
			town = readerStatic.getData("plTown");
			isocode = readerStatic.getData("plIsocode");
			postalCode = readerStatic.getData("plPostalCode");
			phone = readerStatic.getData("plPhone");
			deliveryMode = readerStatic.getData("plDeliveryMode");
			baseStoreID = readerStatic.getData("plBaseStoreID");
			baseURL = BASEURL.replace("{locale}", "PL").replace("{env}",System.getProperty("testEnv"));
		}
		
		baseAUTH= BASEAUTH.replace("{env}",System.getProperty("testEnv"));
		authToken = baseAUTH+AUTHTOKEN;
		muleauthToken = baseAUTH+MULEAUTHTOKEN;
		anonCartID = baseURL+ANONCARTID;
		anonCartToGuest = baseURL+ANONCARTTOGUEST;
		regCartID = baseURL+REGCARTID;
		productData = baseURL+PRODUCTDATA;
		productSEOData = baseURL+PRODUCTSEODATA;
		listOfConsentdata = baseURL+LISTOFCONSENTSDATA;
		specificConsentData = baseURL+SPECIFICCONSENTDATA;
		deleteConsentdata = baseURL+DELETECONSENTDATA;
		CONSENTTEMPLATEID = readerStatic.getData("consentTemplateId");
		CONSENTTEMPLATEVERSION = readerStatic.getData("consentTemplateVersion");
		addConsent = baseURL+ADDCONSENT;
		selectPC13 = baseURL+SELECTEDPC13;
		addToAnonCart = baseURL+ADDTOANONCART;
		addToRegCart = baseURL+ADDTOREGCART;
		viewCart = baseURL+VIEWCART;
		viewRegCart = baseURL+VIEWREGCART;
		updateCart = baseURL+UPDATECART;
		checkOut = baseURL+CHECKOUT;	
		createGuestShipAddress = baseURL+CREATEGUESTSHIPADDRESS;
		createGuestBillAddress = baseURL+CREATEGUESTBILLADDRESS;
		createRegAddress = baseURL+CREATEREGADDRESS;
		setRegAddress = baseURL+SETREGADDRESS;
		deleteRegAddress = baseURL+DELETEREGADDRESS;
		createBillingAddress = baseURL+CREATEREGBILLADDRESS;
		getRegDelivery = baseURL+GETREGDELIVERY;
		addGuestDelivery = baseURL+ADDGUESTDELIVERY;
		addRegDelivery = baseURL+ADDREGDELIVERY;
		addPaymentRegCart = baseURL+ADDPAYMENTREGCART;
		checkoutRegOrder = baseURL+CHECKOUTREGORDER;
		swatchData = baseURL+SWATCHDATA;
		categorySort = baseURL+CATEGORYSORT;
		categoryPDIFF = baseURL+CATEGORYPDIFF;
		searchWithPDIFF = baseURL+SEARCHWITHPDIFF;
		searchWithFacet=baseURL+SEARCHWITHFACET;
		categoryPage = baseURL+CATEGORYPAGE;
		getSavedAddress = baseURL+GETSAVEDADDR;
		markAddressDefault = baseURL+MARKADDRDEFAULT;
		getSavedPayment = baseURL+GETSAVEDPAYMENT;
		markPaymentDefault = baseURL+MARKPAYMENTDEFAULT;
		createUser = baseURL+CREATEUSER;
		loginUser = baseURL+LOGINUSER;
		validateUser = baseURL+VALIDATEUSER;
		categoryDetails = baseURL+CATEGORYDETAILS;
		baseStoreDetails = baseURL+BASESTOREDETAILS;
		countryDetails = baseURL+COUNTRYDETAILS;
		regionDetails = baseURL+REGIONDETAILS;
		createGuestCybHOPForm = baseURL+CREATEGUESTCYBHOPFORM;
		createRegCybHOPForm = baseURL+CREATEREGCYBHOPFORM;
		trackOrderByMailandID = baseURL+TRACKORDERBYEMAIL;
		updateRegProfile =  baseURL+UPDATEREGUSERPROFILE;
		updateRegPassword =  baseURL+UPDATEREGUSERPASSWORD;
		viewRegProfile = baseURL+VIEWREGUSERPROFILE;
		storeByLocation = baseURL+STOREBYCOUNTRY;
		storeByGeoLocation = baseURL+STOREBYGEOLOCATION;
		deleteHybrisCartUsingMuleSoft = baseURL2+DELETECARTBYMULESOFTAUTH;
		deleteHybrisCartUsingMuleSoftReg = baseURL+DELETECARTBYMULESOFTAUTH;
		loginEmployee=baseURL+EMP;
		updateAnnoCart=baseURL+UPDATEANOCART;
		giftCardDetail=baseURL+GIFTCARDETAIL;
		productDetails=baseURL+PRODUCTDETAIL;
		storeDirectory = baseURL+STOREDIRECTORY;
		firstName = readerStatic.getData("firstName");
		estimatedDeliveryDate = readerStatic.getData("estimatedDeliveryDate");
		lastName = readerStatic.getData("lastName");
		addrLine1 = readerStatic.getData("line1");
		addrLine2 = readerStatic.getData("line2");
		accountHolderName = readerStatic.getData("accountHolderName");
		visaCardNumber = readerStatic.getData("visaCardNumber");
		masterCardNumber = readerStatic.getData("masterCardNumber");
		amexCardNumber = readerStatic.getData("amexCardNumber");
		maestroCardNumber = readerStatic.getData("maestroCardNumber");
		discoverCardNumber = readerStatic.getData("discoverCardNumber");
		dinersCardNumber = readerStatic.getData("dinersCardNumber");
		expiryMonth = readerStatic.getData("expiryMonth");
		expiryYear = readerStatic.getData("expiryYear");
		adyenPaymentMethod = readerStatic.getData("adyenPaymentMethod");
		newPWD = readerStatic.getData("newPassword");
		baseURL2=BASEURL2.replace("{env}",System.getProperty("testEnv"));
		
	}

}
