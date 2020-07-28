package cloudSense;

public class CloudSenseProductBasket {
	
	
	// Product Basket Screen
	//Simple Quoting Legacy
	
	public static String iframeProductBasket = "//*[starts-with(@id,'brandBand_')]/div/div/div[5]/div/force-aloha-page/div/iframe";
		
	public static String iframeProductBasketSynched ="/html/body/div[5]/div[1]/section/div/div/div[1]/div/div/force-aloha-page/div/iframe";
	
	public static String cloneBasketButton="/html/body/div[1]/span/div/div[2]/div/div[2]/div[1]/button/span[2]";
	
	public static String syncButton="/html/body/div[1]/span/div/div[2]/div/div[2]/div[2]/button/span[2]";
	
	public static String cancelButton="//span[.='Cancel']";
	
	public static String saveButton="//span[.='Save']";
	
	public static String productBasketHeader = "/html/body/div[1]/span/div/div[2]/div/div[1]/h1";
	
	public static String productBasketName = "//*[@id='basket-details']/div/div/div/div[1]/div[1]/div/div[2]/div/input";
	
	public static String opportunityName = "//*[@id='select2-chosen-2']";
											
	public static String addProductButton = "/html/body/div[1]/span/div/div[3]/div[2]/div[2]/div/div[1]/div/div[2]/div/button/span[2]";
	
	
	//Add Offer to Basket
	
	
	
	public static String offerNameHeader ="/html/body/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]";
	
	public static String offerList ="/html/body/div[2]/div[2]/div/div/div[1]/div[2]";
	
	public static String add2OfferCancelButton = "/html/body/div[2]/div[2]/div/footer/div/button[1]/span";
	
	//public static String add2OfferButton ="/html/body/div[2]/div[2]/div/footer/div/button[2]/span";
	
	public static String add2OfferButton ="//button[@ng-click='addProductAndClose()']";
	
	//public static String summarySection = "/html/body/div[2]/div[2]/div/div/div[3]";
	
	public static String summarySection = "//section[@class='summary-section ng-scope']";
	
	public static String productCatalog="//div[@class='product-category']";
	
	
	//Simple Ordering Intake mapping
	public static String productBasketiFrame="/html/body/div[4]/div[1]/section/div/div/div[1]/div[5]/div/force-aloha-page/div/iframe";
	
	public static String productBasketLabel="//span[text()='Product basket']";
	
	public static String productBasketTable="//*[@id='basket-table']/div[2]/div/ul";
	
	public static String singleLineItemProduct="//*[@id='basket-table']/div[2]/div/ul/li/div/div/div/div/div[2]/div";

}



