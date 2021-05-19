package objectMap.sfDirectSales;

public class DirSalesService {
	
	// ..:: Services Page ::..
	
	// --- Related Menu ---
	public static String filesContainer="//article[contains(.,'Files')]";
	
	// --- Page Header ---
	public static String headerServicesPage="//h1[contains(.,'Service')]";
	
	// --- Page Details ---
	public static String detailsServicePage="//div/div/article/div[2]/div";
	
	public static String fieldServiceName="//span[contains(.,'Service Name')]";
	
	public static String fieldQuote ="//span[contains(.,'Quote')]";
	
	public static String fieldCase ="//span[contains(.,'Case')]";
	
	public static String fieldDomain ="//span[contains(.,'Domain')]";
	
	public static String fieldType="//span[contains(.,'Type')]";
	
	public static String fieldDetail="//span[contains(.,'Detail')]";
	
	public static String fieldServiceRequestDate="//span[contains(.,'Service Request Date')]";
	
	public static String fieldfilledServiceRequestDate="//div[contains(.,'Service Request Date')]/div[3]/div[2]/div";
	
	public static String fieldEnd2EndRequestOwner="//span[contains(.,'End2End Request Owner')]";
	
	public static String fieldStatus="//span[contains(.,'Status')]";
	
	public static String serviceStatus="/html/body/div[4]/div[1]/section/div/div/div[1]/div[4]/div/one-record-home-flexipage2/forcegenerated-flexipage_service_record_page_csord__service__c__view_js/flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/force-progressive-renderer/slot/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2/slot/flexipage-component2/force-progressive-renderer/slot/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/records-record-layout-event-broker/slot/records-lwc-record-layout/forcegenerated-detailpanel_csord__service__c___0123e000000t2jmqai___full___view___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[2]/slot/force-record-layout-item[1]/div/div/div[2]/span/slot[1]/slot/lightning-formatted-text";
	
	public static String fieldQuoteRequestId="//div//span[contains(.,'Quote Request Id')]";
	
	public static String fieldfilledCompanyContactPerson="//article/div[2]/div/div[1]/div/div/div[4]/div[2]/div";
	
	public static String caseLink="//force-highlights-details-item[3]/div/p[2]/slot/force-lookup/div/force-hoverable-link/div/a";
	
	public static String caseLinkOnDetails="(//force-hoverable-link/div/a[contains(.,'00')])[3]";
	
	public static String tabDetails="//*[@id=\"brandBand_2\"]/div/div/div/div/one-record-home-flexipage2/forcegenerated-adgrollup_component___forcegenerated__flexipage_recordpage___service_record_page1___csord__service__c___view/forcegenerated-flexipage_service_record_page1_csord__service__c__view_js/record_flexipage-record-page-decorator/div/slot/flexipage-record-home-template-desktop2/div/div[2]/div[1]/slot/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/lightning-tab-bar/ul/li[2]";
	
	
	// --- Edit Buttons ---
	
	public static String editCompanyContactPersonBtn ="(//button[@title='Edit Company Contact Person'])";
	
	public static String editServiceRequestDate="(//button[contains(.,'Edit Service Request Date')])";
	
	public static String serviceReqDateCalendarButton="//a[@class='datePicker-openIcon display']";
	
	public static String serviceReqDateTodayButton="//span[contains(.,'Today')]";
	
	
	// --- Service Edition: input boxes ---
	
	public static String inputServiceRequestDate = "/html/body/div[5]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[2]/div[1]/div/div/section/div/div/article/div[3]/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div/div/div/div/input";
	
	public static String inputCompanyContactPerson="//input[@title='Search Company contact person']";

	public static String companyContactPersonList="//div[@class='listContent']/ul/li";
	
	public static String inputComments="//textarea";
	
	
	// --- Edit Details Page 
	
	public static String saveBtn="//button[@title='Save']";
	
	
	
	// --- 03-02-2020 - D03 Test Automation
	
	public static String buttonDetails="//button//span[@title='Details']";
	
	public static String buttonEditProvContact="//button[@title='Edit Provisioning Contact Person']";
	
	public static String buttonEditInternalComments="//button[@title='Edit Internal Comments']";
	
	public static String buttonEditBillingAccountID="//button[@title='Edit Billing Account ID']";
	

	
	// --- 08-02-2020 - D03 Test Automation - Service Details

	
	//Provisioning Contact Person
	public static String inputProvisioningContactPerson="//input[@placeholder='Search Company contact person...']";
	
	public static String searchResult="//ul[@role='group']";
	
	public static String searchValueToInput="//lightning-base-combobox-item[contains(@data-value,'0')]";
	
	public static String buttonCreateNewCompanyContact="//lightning-base-combobox-item[@data-value='actionCreateNew']";
	
	public static String newCompanyContactPersonLink="//span[@title='New Company contact person']";
	
	
	
	//Internal Comments
	public static String inputInternalComments="//input[@name='PRX_SOI_Internal_Comments__c']";
	
	
	
	// Billing Account ID
	public static String inputBillingAccountID="//input[@name='PRX_SOI_Billing_Account_ID__c']";
	
	// New billing Account
	
	public static String inputNewBillingAccount="//input[@name='PRX_SOI_NewBillingAccountAddress__c']";
	
	// Footer Buttons on Edit Frame
	
	public static String buttonSave ="//button[@name='update']";
	
	public static String buttonCancel="//button[@name='CancelEdit']";
	
	
	
	// Detail Fields for Validation
	
	public static String fieldProvisioningContactPerson="//*[contains(@id,'field-section-content-')]/slot/slot/flexipage-column2/div/slot/flexipage-field[1]/slot/record_flexipage-record-field/div/div/div[2]/span/slot[1]/slot/force-lookup/div/force-hoverable-link/div/a";
	
	public static String fieldInternalComments="//input[@name='PRX_SOI_Internal_Comments__c']";
	
	public static String fieldBillingAccountID="//input[@name='PRX_SOI_Billing_Account_ID__c']";
	
	public static String fieldNewBillingAccount="//input[@name='PRX_SOI_NewBillingAccountAddress__c']";
	
	public static String fieldContractType="//select[@name='contractTypePicklist']";
	
	//Fields after OrderSubmission
//	public static String caseFieldOnServicePage="//*[contains(@id, 'brandBand')]/div/div/div[5]/div/one-record-home-flexipage2/forcegenerated-adgrollup_component___forcegenerated__flexipage_recordpage___d02_service_layout___csord__service__c___view/forcegenerated-flexipage_d02_service_layout_csord__service__c__view_js/record_flexipage-record-page-decorator/div[1]/slot/flexipage-record-home-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_csord__service__c___0123m0000000fbfqae___compact___view___recordlayout2/force-highlights2/div[1]/div[2]/slot/slot/force-highlights-details-item[3]/div/p[2]/slot/force-lookup/div/force-hoverable-link/div/a";
	public static String caseFieldOnServicePage="//slot[@name='header']//*[@title='Case']/following-sibling::p//a";
	
	
	public static String secundaryHeaderFields="//div[@role='list'][@class='secondaryFields']";
	
}
