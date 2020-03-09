package sfDirectSales;

public class SalesForceCompany {
	
	
	//Company's Pool
	
	public static String companyPoolHeader = "//*[@class='slds-page-header--object-home slds-page-header_joined slds-page-header_bleed slds-page-header slds-shrink-none test-headerRegion forceListViewManagerHeader']";
	
	public static String newButton = "//div[.='New']";
	
	public static String importButton = "//div[.='Import']";
	
	public static String companyTable ="//table";
	
	
	
	// Company details
	
	public static String followBtn ="//span[@title='Follow']";
	
	public static String quickSaleOPTYBtn = "//div[@title='Quick Sale']";
	
	public static String newMACDOrderButton="//a[@title='New MACD Order']";
	
	public static String editBtn = "//div[@title='Edit']";
	
	public static String changeOwner = "//div[@title='Change Owner']";
	
	public static String showMoreBtn = "//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']";
	
	public static String companyHeader="//h1[contains(.,'Company')]";
	
	public static String companyDetailsHeader ="//div[@class='slds-tabs_default']";
	
	//public static String companyName ="//*[contains(@id,'brandBand_')]/div/div[1]/div/div[1]/div/div[1]/div/header/div[2]/div/div[1]/div[2]/h1/div/span";
	public static String companyName="//h1/div/span";
	
	public static String companyDetailsInfo ="//div[@class='slds-tabs_card']";
	
	
	// Company Related Menu
	
	//..:: Opportunities Area :...
	public static String rmOpportunitieslink="//article[contains(.,'Opportunities')]//h2/a";
	
	public static String showActionsButton="//article[contains(.,'Opportunities')]//a[@role='button'][contains(.,'Show actions for this object')]";
	
	public static String newOpportunityButton="//a[@title='New']";
	
	//..:: Orders Area :...
	
	public static String articleOrders="//article[contains(.,'Orders')]";
	
	public static String linkOrders="/html/body/div[5]/div[1]/section/div/div/div[1]/div[3]/div/div[1]/div/div[2]/div[2]/div[3]/div/div/div[2]/article/a/div/span";
	
	
	// ..:: Company Contact Person ::..
	
	public static String companyContactPerson="//article[contains(.,'Company contact person')]//a[starts-with(.,'Simple')]";
	
	// ..:: Case Area ::..
	
	public static String caseHeader="//article[contains(.,'Case')]//h2/a";
	
	// New Company Form
	
	public static String newCompanyHeader = "//h2[.='New Company']";
	
	//public static String companyNameInput = "//input[@class='input uiInput uiInputText uiInput--default uiInput--input']";
	public static String companyNameInput="/html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/div/input";
	
	public static String serviceLevelSelect ="/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[4]/div[2]/div/div/div/div/div[1]/div/div/a";
	
	public static String typeSelect = "/html/body/div[5]/div[1]/div[2]/div[2]/div/div[2]/div/section/div/div[2]/div/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[5]/div[2]/div/div/div/div/div[1]/div/div/a";
	
	public static String saveButton = "//span[.='Save']";
	
	public static String addressInformationHeader = "/html/body/div[5]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[2]/h3";
	
	public static String addressStreet = "//textarea[@class='street compoundTLRadius compoundTRRadius compoundBorderBottom textarea']";
	
	public static String addressCity = "//input[@class='city compoundBorderBottom compoundBorderRight input']";
	
	public static String addressState = "//input[@class='state compoundBorderBottom input']";
	
	public static String addressPostalCode = "//input[@class='postalCode compoundBLRadius compoundBorderRight input']";
	
	public static String addressCountry = "//input[@class='country compoundBRRadius input']";
	
	// New Company Form
	
	public static String opportunitiesLink = "//span[contains(@title,'Opportunities')]";
	
	
	
	// Orders Section
	public static String firstOrderLink="(//article[contains(.,'Orders')]//h3/div/a)[1]";
	
	public static String viewAllOrdersLink="//article[contains(.,'Orders')]//span[contains(.,'View All')]";

	// public static String
	
	

}
