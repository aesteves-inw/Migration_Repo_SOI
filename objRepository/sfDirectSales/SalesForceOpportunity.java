package sfDirectSales;

public class SalesForceOpportunity {

	//	public static String

	//OPTY Related Menu
	
	public static String productContainer="//article[contains(.,'Products')]";
	
	public static String agreementsContainer="//article[contains(.,'Agreements')]";

	// New Opportunity Screen

	public static String newOpportunityHeader="//h2[contains(.,'New Opportunity')]";

	public static String inputCloseDate="/html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[1]/div[2]/div/div/div/div/input";

	public static String inputOpportunityName="/html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/div/input";

	public static String selectStage="/html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a";

	public static String listState="/html/body/div[10]/div/ul";

	public static String selectForecastCategory="/html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[5]/div[2]/div/div/div/div/div[1]/div/div/a";

	public static String listForecastCategory="/html/body/div[11]/div/ul";

	public static String nosCancelButton="//button[@title='Cancel']";

	public static String nosSaveButton="//button[@title='Save']";


	//OPTY Details

	public static String followButton = "//button[.='Follow']";

	public static String editButton = "//a[@title='Edit']";

	public static String deleteButton = "//a[@title='Delete']";

	public static String cloneButton = "//a[@title='Clone']";

	public static String showMoreButton = "//a[contains(@title,'Show one more action')]";

	public static String optyHeader = "//ul[@role='list']";

	public static String optyDetails = "//div[@class='slds-grid slds-gutters_small full cols-2 forcePageBlockSectionRow']";

	public static String productBasketLink = "//div[@data-component-id='flexipage_tabset2']/div//h2/a/span[.='Product Baskets']";

	public static String pBShowMoreButton = "(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[3]";

	public static String pbSMBNewOption = "//a[@title='New']";
	
	
	//OPTY Pool Screen
	public static String optysHeader = "//div[@class='slds-page-header--object-home slds-page-header_joined slds-page-header_bleed slds-page-header slds-shrink-none test-headerRegion forceListViewManagerHeader']";
	
	public static String refreshButton = "//button[@name='refreshButton']";
	
	public static String newButton = "//a[@title='New']/div[@title='New']";
	
	public static String optyTablePool = "//table[@role='grid']";
	
	public static String optyTableResults = "//th[1]/span/a";
	

}
