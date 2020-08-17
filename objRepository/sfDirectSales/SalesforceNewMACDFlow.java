package sfDirectSales;

public class SalesforceNewMACDFlow {
	
	//New MACD ORDER main itens
	
	public static String headerNewMACDOrder="//h2[.='New MACD Order']";
	
	public static String nextButton="//button[contains(.,'Next')]";
	
	public static String submitOrderButton="//button[contains(.,'Submit Order')]";
	
	public static String newMACDOrderScreen="//form[@class='slds-form']";
	
	
	//First Screen fields
	public static String inputDomain="//input[@name='PRX_SOI_Domain__c']";
	
	public static String inputType="//input[@name='PRX_SOI_Type__c']";
	
	public static String inputDetail="//input[@name='PRX_SOI_Detail__c']";
	
	public static String dropdownList="//div[@role='listbox']";
	
	public static String adminValueType="//span[@title='Administration']";
	
	public static String changeAddressDetailValue="//span[@title='Change address']";
	
	
	// Second Screen fields
	public static String secondScreen="//div[contains(@id, 'content_')]";
	
	public static String inputCompanyContactPerson="//input[@placeholder='Search Company contact person name...']";
	
	public static String liCompanyContactPerson="//li[1]/span[1]/span[2]/span[1]";
	
	public static String orderOwnerClearSelection="(//button[@title='Clear Selection'])[1]";
	
	public static String salesforceIDClearSelection="(//button[@title='Clear Selection'])[2]";
	
	public static String inputServiceRequestDate="//input[@name='Service_Request_Date']";
	
	public static String calendarButton="//lightning-button-icon/button[@title='Select a date']";
	
	public static String calendarTable="//table[@class='slds-datepicker__month']";
	
	public static String todayCalendarButton="//button[@name='today']";
	
	public static String inputQuoteID="//input[@name='Quote_Id']";
	
	public static String inputComments="//textarea";
	
	public static String uploadFilesButton="//span[contains(.,'Upload Files')]";
	
	public static String inputUploadFiles="//lightning-file-upload/lightning-input/div/div/lightning-primitive-file-droppable-zone/slot/input";
}
