package sfPartnersCommunity;

public class SFPC_Orders {
	
	// public static String
	
	//Order Page
	public static String filesContainer ="//article[contains(.,'Files')]";
	
	public static String servicesContainer="//article[contains(.,'Services')]";
	
	public static String changeRecordTypeButton="//li/a/div[@title='Change Record Type']";
	
	public static String changeOwnerButton="//li/a/div[@title='Change Owner']";
	
	public static String headerOrder="//h1[contains(.,'Order')]";
	
	public static String headerOrderDetail="//h3[contains(.,'Order')]";
	
	public static String orderDetails="//div[@role='list']";
	
	public static String addServiceBtn ="//div[@title='Add Service']";
			
	public static String submitOrderBtn="//div[@title='Submit Order']";
	
	
	//Details Page Elements
	public static String orderTypeLabel="//span[@class='test-id__field-label'][text()='Order Type']";
	
	public static String orderTypeMACD="//span[@class='uiOutputText'][text()='MACD']";
	
	
	//Add Service Screen
	
	public static String addServiceConfigScreen="//section/lightning-record-form/lightning-record-edit-form/form/slot/div/div[1]";
	
	public static String labelDomain="//label[contains(.,'Domain')]";
	
	public static String labelType="//label[contains(.,'Type')]";
	
	public static String labelDetail="//label[contains(.,'Detail')]";
	
	public static String inputDomain="//input[@name='PRX_SOI_Domain__c']";
	
	public static String inputDetail="//input[@name='PRX_SOI_Detail__c']";
	
	public static String inputType="//input[@name='PRX_SOI_Type__c']";
	
	public static String saveBtnAS2O = "//button[contains(.,'Save')]";
	
	public static String inputDetailExtra="//span[@title='Extra Products & Services']";
	
	public static String inputDetailRenewal="//span[@title='Renewal']";
	
	public static String inputDetailWinback="//span[@title='Winback']";
	
	public static String nextBtn="//button[contains(.,'Next')]";
	
	public static String firstScreenFlow="//div[@class='cPRX_SOI_MACD_Picklist']";
	
	public static String secondScreenFlow="//article[@class='cPRX_SOI_MACD_FORMS']";
	
	
	

	public static String firstServiceLink="//article[contains(.,'Services')]//tr/td/a";
	
	//Messages
	public static String successMessage="//div[contains(.,'Your Order has been successfully submited')]";
	
	
	//06-03-2020: SOI-721
	
	public static String ordersTable="//table/tbody";
	
	public static String macdOrders="//table/tbody//a[contains(@title,'Mobile')]";
	
	public static String inputSearchOrders="//input[@name='csord__Order__c-search-input']";
	
	public static String displayAsTableBtn="//button[@title='Display as Table']";
	
	public static String listViewControlsBtn="//button[@title='List View Controls']";
	
	public static String selectListViewButton="//a[@title='Select List View']";
	
	public static String refreshButton="//button[@title='Refresh']";
	
	public static String bannerHeader="//div[@role='banner']";
	
	public static String ordersFilterLabel="//h1/div/div/span[2]";
	
	
	// NOT EXISTING
	public static String newOrderButton="//*[contains(.,'New')]";
	

}
