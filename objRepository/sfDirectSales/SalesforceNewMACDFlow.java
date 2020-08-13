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
	
	public static String inputCompanyContactPerson="//article/div/div[2]/div/div/div[1]/div/div/div[2]/input";
	
	public static String inputServiceRequestDate="//input[@name='Service_Request_Date']";
	
	public static String calendarButton="//button[@title='Select a date']";
	
	public static String calendarTable="//table[@class='slds-datepicker__month']";
	
	public static String todayCalendarButton="//button[@name='today']";
	
	public static String inputComments="//textarea";
	
	public static String uploadFilesButton="//span[contains(.,'Upload Files')]";
}
