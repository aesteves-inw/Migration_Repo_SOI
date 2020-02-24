package sfDirectSales;

public class SalesForceOrders {

	//Before 06-01-2020

	public static String filesContainer="//article[contains(.,'Files')]";

	public static String uploadFilesButton="/html/body/div[5]/div[1]/section/div/div/div[1]/div[4]/div/div[1]/div/div[2]/div[2]/div[2]/div/article/div[3]/div/div/div/div/div/div[2]/lightning-input/div/div/lightning-primitive-file-droppable-zone/slot/label/span[1]";

	public static String serviceContainer="//article[contains(.,'Services')]";


	//After 06-01-2020

	public static String addServiceButton="//button[@name='csord__Order__c.PRX_SOI_NEW_CONTRACT']";

	public static String submitOrderButton="//button[@name='csord__Order__c.PRX_SOI_SubmitOrder']";

	public static String servicesContainer="//article[contains(.,'Services')]";

	public static String orderDetails="//div[@class='slds-tabs_default']";

	public static String orderHeader="//h1[contains(.,'Order')]";

	public static String orderError="/html/body/div[7]/div/div/div";


	//Submission Order Messages

	public static String orderSubmittedSuccess="//div[contains(.,'Your Order has been successfully submited')]";

	public static String orderAlreadySubmitted="//div[contains(.,'Order already submited!')]";


	//In Edit Mode
	public static String inputOrderName="//input[@maxlength='80']";

	public static String saveButton="//button[@title='Save']";



	public static String editOrderNameBtn ="//button[contains(@title, 'Edit Order Name')]";

	public static String editCompanyBtn ="//button[contains(@title, 'Edit Company')]";

	public static String editOpportunityBtn ="//button[@title='Edit Opportunity']";

	public static String editOrderTypeBtn ="//button[contains(@title, 'Edit Order Type')]";

	public static String editIdentificationBtn ="//button[contains(@title, 'Edit Identification')]]";

	public static String editSubmittedByBtn ="//button[contains(@title, 'Edit Submitted By')]";

	public static String editStatusBtn ="//button[contains(@title, 'Edit Status')]";

	public static String editSubmissionDateBtn="//button[contains(@title, 'Submission Date')]";



	// Add Service Screen - Config

	public static String inputDomain="//input[@name='PRX_SOI_Domain__c']";

	public static String inputType="//input[@name='PRX_SOI_Type__c']";

	public static String inputDetail="//input[@name='PRX_SOI_Detail__c']";

	public static String btnSaveASSC="//lightning-button[2]/button";

	public static String detailsASSC="//article[@class='slds-is-relative slds-p-around--medium']";

	public static String domainMobile="//span[@title='Mobile']";

	public static String typeNewContract="//span[@title='New Contract']";

	public static String domainExtra="//span[@title='Extra Products & Services']";

	public static String domainRenewal="//span[@title='Renewal']";

	public static String domainWinback="//span[@title='Winback']";

	public static String nextButton="//article/div/div[2]/div/div/div[2]/div[2]/button";




	// Related List

	public static String firstServiceLink="(//article[contains(.,'Services')]//li//a)[2]";


	//Orders List View
	public static String firstOrderLinkListView="//table/tbody/tr[1]/th/span/a";

	//Orders List View - SOI-80
	public static String ordersSearchBar="//div[contains(@class,'slds-form-element__control slds-grow')]//input[1]";

	public static String myOrdersOption="//span[text()='My Orders']";

	public static String allOrdersOption="(//span[text()='All Orders'])[2]";

	public static String validateMyOrders="(//span[text()='My Orders'])[1]";

	public static String validateAllOrders="(//span[text()='All Orders'])[1]";

	public static String listViewControls="//button[@title='List View Controls']";

	public static String selectFieldDisplay="//span[text()='Select Fields to Display']";

	public static String validateSelectDisplay="//h2[text()='Select Fields to Display']";

	public static String administrativeContactField="//span[@title='Administrative Contact']";

	public static String billingAccountField="//span[@title='Billing Account']";

	public static String cancelSubmitterContactField="//span[@title='Cancel Submitter']";

	public static String addButtonField="//button[@title='Move selection to Visible Fields']";

	public static String removeButtonField="//button[@title='Move selection to Available Fields']";

	public static String firstFieldAdded="//span[@title='Administrative Contact']";

	public static String secondFieldAdded="//span[@title='Billing Account']";

	public static String thirdFieldAdded="//span[@title='Cancel Submitter']";
	
	




}
