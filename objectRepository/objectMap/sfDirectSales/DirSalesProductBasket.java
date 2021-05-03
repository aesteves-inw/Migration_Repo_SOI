package objectMap.sfDirectSales;

public class DirSalesProductBasket {
	
	// Product Basket related view List
	
	public static String newProductBasketButton="//a[@title='New Product Basket']";
	
	
	
	// Product Basket Screen
		//Simple Quoting Legacy
		
		public static String iframeProductBasket = "//*[starts-with(@id,'brandBand_')]/div/div/div[3]/div/force-aloha-page/div/iframe";
		
		public static String iframeProductBasketPC = "/html/body/div[3]/div[2]/div/div[2]/div/div/div/div/iframe";
			
		public static String iframeProductBasketSynched ="/html/body/div[5]/div[1]/section/div/div/div[1]/div/div/force-aloha-page/div/iframe";
		
		public static String cloneBasketButton="/html/body/div[1]/span/div/div[2]/div/div[2]/div[1]/button/span[2]";
		
		//public static String syncButton="/html/body/div[1]/span/div/div[2]/div/div[2]/div[2]/button/span[2]";
		
		public static String syncButton="//button[@aria-label='Sync']";
		
		public static String cancelButton="//span[text()='Cancel']";
		
		public static String saveButton="//span[text()='Save']";
		
		public static String productBasketHeader = "/html/body/div[1]/span/div/div[2]/div/div[1]/h1";
		
		public static String productBasketName = "//*[@id='basket-details']/div/div/div/div[1]/div[1]/div/div[2]/div/input";
		
		public static String opportunityName = "//*[@id='select2-chosen-2']";
												
		public static String addProductButton = "/html/body/div[1]/span/div/div[3]/div[2]/div[2]/div/div[1]/div/div[2]/div/button/span[2]";	
		
		
		//Simple Ordering Intake mapping
		//Product Basket Screen
		public static String productBasketiFrame="/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/force-aloha-page/div/iframe";
		
		public static String productBasketLabel="//span[text()='Product basket']";
		
		public static String productBasketTable="//*[@id='basket-table']/div[2]/div/ul";
		
		public static String singleLineItemProduct="//*[@id='basket-table']/div[2]/div/ul/li/div/div/div/div/div[2]/div";
		
		public static String editProductConfigurationButton="//button[@aria-label='Edit configuration']";
		
		public static String errorMessagePB="//div[@class='toast ng-scope toast-error']";
		
		public static String successMessageSyncPB="//div[@class='toast ng-scope toast-success']";
		
		public static String syncWithPBFlag="//input[@aria-labelledby='csbb__Synchronised_With_Opportunity__c']";
		
		public static String selectLineItemCheckBox="//button[@type='button'][@class='bt-btn btn-checkbox ng-scope']";
		
		public static String expandPackageButton="//button[@aria-label='Expand package']";
		
		public static String buttonGoToAgreement="//button[@aria-label='Go to Agreement']";
		
		public static String inputProductBasketName="//input[@aria-labelledby='Name'][@type='text']";

		
		public static String buttonDiscountManagement="//button[@aria-label='Discount Management']";
		
		public static String buttonOrderEnrichment="//button[@aria-label='Order Enrichment']";
		
		public static String lineItemsProductBasketTable="//*[@role='gridcell']";
		
		
		
		//04-02-2021 - D03 Changes Regarding Product Basket Object:
		
		public static String inputExistingBillingAccountId = "//input[@aria-labelledby='PRX_SOI_Billing_Account_ID__c']";
		
		public static String inputProvisioningContactPerson="//input[@aria-labelledby='PRX_SOI_Provisioning_Contact_Person__c']";
		
		public static String searchResultsForProvisioningContactPerson="//ul[@role='listbox']";
		
		
		public static String inputNewBillingAccountAddress ="//input[@aria-labelledby='PRX_SOI_New_Billing_Account_Address__c']";
		
		public static String errorMessageBillingConfiguration="//li[@class='error-msg ng-scope']";
}
