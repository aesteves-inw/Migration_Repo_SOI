package sfPartnersCommunity;

public class SFPC_Opportunity {
	
	//public static String
	
	
	//   ..:: New Opportunity Screen ::..
	
	public static String newOpportunityHeader="//h2[contains(.,'New Opportunity')]";
	
	public static String inputOpportunityName="/html/body/div[8]/div/div[2]/div/div[2]/div/div/article/div[3]/div/div[1]/div/div/div[2]/div[1]/div/div/div/input";
	
	public static String inputCloseDate="/html/body/div[8]/div/div[2]/div/div[2]/div/div/article/div[3]/div/div[1]/div/div/div[1]/div[2]/div/div/div/div/input";
	
	public static String selectStage="/html/body/div[8]/div/div[2]/div/div[2]/div/div/article/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a";
	
	public static String selectForecastCategory="/html/body/div[8]/div/div[2]/div/div[2]/div/div/article/div[3]/div/div[1]/div/div/div[6]/div[2]/div/div/div/div/div[1]/div/div/a";
	
	public static String saveButton="//button[@title='Save']";
	
	public static String cancelButton="//button[@title='Cancel']";
	
	
	
	// ..:: Opportunity Status Bar ::..
	
	public static String nextBtn="//button[.='Next']";
	
	public static String closeOptyBtn="//a[@title='Closed']";
	
	public static String selectClosedStageBtn="//button[contains(.,'Select Closed Stage')]";
	

	// ..:: Close This Opportunity - Screen ::..
	
	public static String ctoHeader ="//h2[contains(.,'Close This Opportunity')]";
	
	public static String ctoSelectStage="//select";
	
	public static String ctoCloseWon="//option[@value='Closed Won']";
	
	public static String ctoCloseLost="//option[@value='Closed Lost']";
	
	
	
	//   ..:: Opportunity Details Screen ::..
	
	public static String optyHeader="/html/body/div[4]/div[2]/div/div[2]/div[1]/div/div[1]/header/div[2]";
	
	public static String optyDetails="//div[@role='list']";
	
	public static String followButton="//span[@title='Follow']";
	
	public static String newMACDOrderButton="//li/a/div[@title='Clone']";
	
	public static String editButton="//li/a/div[@title='Edit']";
	
	
	
	
	
	//   ..:: Opportunity Related Menu ::..
	
	//   --- Agreements ---
	public static String agreementsArea="//article[contains(.,'Agreements')]";
	
	public static String viewAllAgreementsLink="//article[contains(.,'Agreements')]/a/div/span";
	
	public static String newAgreementButton="//article[contains(.,'Agreements')]/div[2]/div/div/ul/li/a/div";
	
	
	//  --- Products ---

	public static String productsArea="//article[contains(.,'Products')]";
	
	public static String addProductsButton="//article[contains(.,'Products')]//li/a/div[@title='Add Products']";
	
	public static String editProductsButton="//article[contains(.,'Products')]//li/a/div[@title='Edit Products']";
	
	public static String productsTable="//article[contains(.,'Products')]//table";
	

	
	
}
