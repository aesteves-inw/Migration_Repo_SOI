package objectMap.sfDirectSales;

public class DirSalesProductBasket {
	
	// Product Basket related view List
	
	public static String newProductBasketButton="//a[@title='New Product Basket']";
	
	
	
	// Product Basket Screen
		//Simple Quoting Legacy
		
//		public static String iframeProductBasket = "//*[starts-with(@id,'brandBand_')]/div/div/div[3]/div/force-aloha-page/div/iframe";
		public static String iframeProductBasket = "//div[contains(@class,'windowViewMode-normal')]//iframe";
		
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
		
		public static String firstResultForProvisioningContactPerson="//ul[@role='listbox']/li";
		
		public static String inputNewBillingAccountAddress ="//input[@aria-labelledby='PRX_SOI_New_Billing_Account_Address__c']";
		
		public static String errorMessageBillingConfiguration="//li[@class='error-msg ng-scope']";
		
		//17-06-2021 - Add Offer to Basket Screen (Categories)
		
		public static String categoryECSPack="//*[@id='a0z3M0000008dUuQAI']";
		
		public static String categoryConvergedOfferrings="//*[@id='a0z3M0000008dUsQAI']";
		
		public static String categoryStandaloneOfferings="//*[@id='a0z3M0000008dUtQAI']";
		
		public static String categoryStandaloneOfferings_Internet=categoryStandaloneOfferings + "//*[@id='a0z3M0000008dUyQAI']";
		
		public static String categoryStandaloneOfferings_Voice=categoryStandaloneOfferings + "//*[@id='a0z3M0000008dUxQAI']";
		
		public static String categoryExternallyQuotedProducts="//*[@id='a0z3M0000008wGUQAY']";
		
		public static String categoryExternallyQuotedProducts_AdvTelcoSol=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wCAQAY']";
		
		public static String categoryExternallyQuotedProducts_AdvancedWorkplace=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wC8QAI']";
		
		public static String categoryExternallyQuotedProducts_ComputeStorage=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wCEQAY']";
		
		public static String categoryExternallyQuotedProducts_DNSWebhosting=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008ysfQAA']";
		
		public static String categoryExternallyQuotedProducts_EnterprisePackTogether=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008yskQAA']";
		
		public static String categoryExternallyQuotedProducts_IOTAnalytics=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wCFQAY']";
		
		public static String categoryExternallyQuotedProducts_MassMarket=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wC6QAI']";
		
		public static String categoryExternallyQuotedProducts_Mobile=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wCCQAY']";
		
		public static String categoryExternallyQuotedProducts_NetwConnServ=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wC7QAI']";
		
		public static String categoryExternallyQuotedProducts_NextGenComm=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008wCBQAY']";
		
		public static String categoryExternallyQuotedProducts_Voice=categoryExternallyQuotedProducts + "//*[@id='a0z3M0000008yslQAA']";
}
