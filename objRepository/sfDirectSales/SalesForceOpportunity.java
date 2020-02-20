package sfDirectSales;

public class SalesForceOpportunity {

	//	public static String

	//OPTY Related Menu
	
	public static String productContainer="//article[contains(.,'Products')]";
	
	public static String agreementsContainer="//article[contains(.,'Agreements')]";
	
	public static String ordersContainer="//article[contains(.,'Orders')]";

	// New Opportunity Screen
	
	public static String inputCompanyName="//input[@title='Search Company']";

	public static String newOpportunityHeader="//h2[contains(.,'New Opportunity')]";

	public static String inputCloseDate="/html/body/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[1]/div[2]/div/div/div/div/input";

	public static String inputOpportunityName="/html/body/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/div/input";

	public static String selectStage="/html/body/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a";

	public static String listState="/html/body/div[10]/div/ul";
	
	public static String closeWonOptyStage="//*/div/ul/li[8]/a";

	public static String selectForecastCategory="/html/body/div[4]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[5]/div[2]/div/div/div/div/div[1]/div/div/a";

	public static String listForecastCategory="/html/body/div[11]/div/ul";

	public static String nosCancelButton="//button[@title='Cancel']";

	public static String nosSaveButton="//button[@title='Save']";
	
	public static String additionalInformationTab="//h3[contains(.,'Additional Information')]";
	
	public static String termsAndConditionsComboBox="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[2]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a";
	
	public static String termAndConditionsOption="//a[@title='Proximus standard T&C are applicable']";
	
	
	
	
	//Edit Opportunity Screen
	
	public static String editHeader="//h2[contains(.,'Edit')]";
	
	


	//OPTY Details

	public static String followButton = "//button[.='Follow']";

	public static String editButton = "//div[@title='Edit']";

	public static String deleteButton = "//a[@title='Delete']";

	public static String cloneButton = "//a[@title='Clone']";

	public static String showMoreButton = "//a[contains(@title,'Show one more action')]";

	public static String optyHeader = "//h1[contains(.,'Opportunity')]";

	public static String optyDetails = "//div[@class='slds-tabs_default']";

	public static String productBasketLink = "//div[@data-component-id='flexipage_tabset2']/div//h2/a/span[.='Product Baskets']";

	public static String pBShowMoreButton = "(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[3]";

	public static String pbSMBNewOption = "//a[@title='New']";
	
	public static String stageClosedWonDetails="//*/div/div[2]/div[2]/div/div[2]/span/span[.='Closed Won']";
	
	public static String closeOPTYHeaderButton = "(//span[@class='title slds-path__title'][contains(.,'Closed')])[2]";
	
	public static String selectCloseMenu="//span[.='Select Closed Stage']";
	
	
	//Close This Opportunity Menu
	
	public static String ctomHeader="//h2[contains(.,'Close This Opportunity')]";
	
	public static String ctomStageSelect="//select";
	
	public static String ctomCloseWon="//option[@value='Closed Won']";
	
	public static String ctomCloseLost="//option[@value='Closed Lost']";
	
	
	//OPTY Pool Screen
	public static String optysHeader = "//div[@class='slds-page-header--object-home slds-page-header_joined slds-page-header_bleed slds-page-header slds-shrink-none test-headerRegion forceListViewManagerHeader']";
	
	public static String refreshButton = "//button[@name='refreshButton']";
	
	public static String newButton = "//a[@title='New']/div[@title='New']";
	
	public static String optyTablePool = "//table[@role='grid']";
	
	public static String optyTableResults = "//th[1]/span/a";
	

}
