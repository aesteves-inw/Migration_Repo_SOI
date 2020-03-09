package sfDirectSales;

public class SalesforceCase {
	
	public static String keyDetailsArticle="//div[@class='VIEW slds-card']";
	
	public static String filesContainer="//article[contains(.,'Files')]";
	
	public static String servicesContainer="(//a[contains(@href,'PRX_SOI_Services__r')])[2]";
	
	
	
	//06-03-2020 - Cases Detail Page
	
	public static String detailsBtn="//a[@id='detailTab__item']";
	
	public static String servicelinkRelatedMenu="//article[contains(.,'Services')]//a[starts-with(.,'Mobile')]";
	
	public static String editCaseStatusBtn="//article[contains(.,'Key Details')]//button[@title='Edit Status']/lightning-primitive-icon";
	
	public static String statusComboBox="//lightning-combobox/div/lightning-base-combobox/div/div[1]/input";
	
	public static String statusListElements="//div[@role='listbox']";
	
	public static String caseStatusLabel="//article/div/div[2]/div/div/div[2]/div/section/div[1]/div/div/div/div/div[4]/div[1]/div/div[2]/span";
	
	//public static String saveBtn="//span[@class=' label bBody'][contains(.,'Save')]";
	
	public static String saveBtn="//button[@title='Save']";
	
	
	
	//06-03-2020 - Cases List View Page - SOI-795
	
	public static String newBtn="//li/a[@title='New']";
	
	public static String changeOwner="//li/a[@title='Change Owner']";
	
	public static String showQuickFilters="//button[@title='Show quick filters']";
	
	public static String refreshBtn="//button[@title='Refresh']";
	
	public static String listViewControlsBtn="//button[@title='List View Controls']";
	
	public static String casesTable="//table/tbody";
	
	public static String firstTableCaseLink="//table/tbody/tr[1]/th/span/a";
	
	public static String editCaseBtn="//li/a[@title='Edit']";
	
	public static String editHeaderWindow="//h2[starts-with(.,'Edit')]";
	
	
	//06-03-2020 - Case Page validation - SOI-880
	
	public static String caseOwnerFieldLabel="//article/div/div[2]/div/div/div[2]/div/section/div[1]/div/div/div/div/div[3]/div[1]/div/div[2]/span/span";

}
