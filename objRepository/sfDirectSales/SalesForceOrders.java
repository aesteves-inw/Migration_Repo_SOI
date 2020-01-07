package sfDirectSales;

public class SalesForceOrders {
	
	//Before 06-01-2020
	
	public static String filesContainer="//article[contains(.,'Files')]";
	
	public static String uploadFilesButton="/html/body/div[5]/div[1]/section/div/div/div[1]/div[4]/div/div[1]/div/div[2]/div[2]/div[2]/div/article/div[3]/div/div/div/div/div/div[2]/lightning-input/div/div/lightning-primitive-file-droppable-zone/slot/label/span[1]";

	//public static String orderDetails="/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/div/div/section/div/div/article/div[2]/div/div/div/div";
	
	
	
	//After 06-01-2020
	
	public static String addServiceButton="//a[@title='Add Service']";
	
	public static String submitOrderButton="//a[@title='Submit Order']";
	
	public static String servicesContainer="//article[contains(.,'Services')]";
	
	public static String orderDetails="//div[@class='tabset slds-tabs_card uiTabset--base uiTabset--default uiTabset--dense uiTabset flexipageTabset']//section[contains(@class,'tabs__content active uiTab')]";
	
	public static String orderHeader="//h1[contains(.,'Order')]";
	
	
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
	
	

}
