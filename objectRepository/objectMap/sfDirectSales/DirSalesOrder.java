package objectMap.sfDirectSales;

public class DirSalesOrder {

	//Before 06-01-2020

	public static String filesContainer="//article[contains(.,'Files')]";

	public static String uploadFilesButton="/html/body/div[5]/div[1]/section/div/div/div[1]/div[4]/div/div[1]/div/div[2]/div[2]/div[2]/div/article/div[3]/div/div/div/div/div/div[2]/lightning-input/div/div/lightning-primitive-file-droppable-zone/slot/label/span[1]";

	public static String serviceContainer="//article[contains(.,'Services')]";


	//After 06-01-2020

	public static String addServiceButton="//button[@name='csord__Order__c.PRX_SOI_NEW_CONTRACT']";

	public static String submitOrderButton="//button[@name='csord__Order__c.PRX_SOI_SubmitOrder']";

	public static String servicesContainer="//article[contains(.,'Services')]";

	public static String orderDetailsTab="//div[@class='slds-tabs_default']";
	
	public static String orderDetails="//force-record-layout-section";

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
	
	public static String addServiceHeader="//h2[text()='Add Service']";

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
	
	public static String addServiceScreenCloseBtn="//button[@title='Close this window']/lightning-primitive-icon";
	
	public static String add2ndServiceErrorMessage="//span[text()='You can´t add more than one service.']";


	//SOI-721
	public static String orderTypeLabel="//span[@class='test-id__field-label'][text()='Order Type']";
	
	public static String orderTypeMACD="//div[@class='slds-form-element__control'][contains(.,'MACD')]";

	// Related List

	public static String firstServiceLink="(//article[contains(.,'Services')]//li//a)[2]";
	
	public static String serviceMobileLink="//article[contains(.,'Services')]//a[contains(.,'Mobile')]";


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
	
	
	//SOI-80 - 24-02-2020
	
	public static String listViewControlsBtn="//button[@title='List View Controls']//lightning-primitive-icon";
	
	public static String listControlsList="//ul[@class='dropdown__list']";
	
	public static String selectFieldsListOption="//li[@role='presentation']/a/span[text()='Select Fields to Display']";
	
	public static String successMessage="//div[contains(.,'List view updated')]";
	
	public static String headerTableColumnsOrder="//table/thead/tr/th/div/a/span[2]";
	

	
	
	//Select Fields to Display - Screen
	
	public static String move2VisibleFields="//button[@title='Move selection to Visible Fields']//lightning-primitive-icon";
	
	public static String move2AvailableFields="//button[@title='Move selection to Available Fields']//lightning-primitive-icon";
	
	public static String moveSelectionUp="//button[@title='Move selection up']//lightning-primitive-icon";
	
	//Options - Option
	public static String administrativeContactOption="//div[@data-value='PRX_Administrative_Contact__c']";
	public static String billingAccount="//div[@data-value='PRX_Billing_Account__r.Name']";
	public static String cancelSubmitterOption="//div[@data-value='PRX_Cancel_Submitter__c']";
	public static String cancelOrderStatusCodeOption="//div[@data-value='PRX_cancel_Order_statusCode__c']";
	public static String cancellationPONRReachedOption ="//div[@data-value='PRX_Cancellation_PONR_Reached__c']";
	public static String caseCategory="//div[@data-value='csord__Cease_Category__c']";
	
	public static String availableFieldsOptions="//lightning-dual-listbox/div/div[2]/div/div[3]/div/ul/li/div";
	
	public static String visiblefieldsOptions="//lightning-dual-listbox/div/div[2]/div/div[5]/div/ul/li/div";
	
	public static String secondVisiblefieldOption="//lightning-dual-listbox/div/div[2]/div/div[5]/div/ul/li/div[@data-index='1']";
	
	public static String selectFieldsSaveBtn="//button[@class='slds-button slds-button--neutral test-confirmButton uiButton--default uiButton--brand uiButton'][contains(.,'Save')]";

	
	//Order List View
	public static String selectFilterListViewBtn="//a[@title='Select List View']";
	
	public static String inputSearchBar="//input[@name='csord__Order__c-search-input']";
	
	public static String firstOrderNameLink="//table/tbody/tr[1]/td[2]/span/a";
	
	public static String ordersNameLink="//table/tbody/tr/td[2]/span/a";
	
	public static String ordersTable="//table/tbody";
	
	public static String pinBtn="//force-list-view-manager-pin-button/div/lightning-helptext/div/button";

	
	
	//09/02 - test Automation elements
	public static String orderSubmitionErrorBillingAccount="//span[starts-with(.,'Billing Account Id must be filled')]";
	
	public static String orderSubmitionErrorProvisioningContact ="//span[starts-with(.,'Provisioning contact must be filled')]";
	
	public static String orderStatusLabel="//*[contains(@id,'sectionContent-')]/div/slot/force-record-layout-row[5]/slot/force-record-layout-item[2]/div/div/div[2]/span/slot[1]/slot/lightning-formatted-text";

	

}
