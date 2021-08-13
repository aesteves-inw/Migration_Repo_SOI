package objectMap.sfDirectSales;

public class DirSalesCase {
	
	public static String keyDetailsArticle="//div[@class='VIEW slds-card']";
	
	public static String filesContainer="//article[contains(.,'Files')]";
	
	
	
	
	
	//06-03-2020 - Cases Detail Page
	
		
	public static String servicelinkRelatedMenu="//article[contains(.,'Services')]//a[starts-with(.,'Mobile')]";
	
	public static String editCaseStatusBtn="//article[contains(.,'Key Details')]//button[@title='Edit Status']/lightning-primitive-icon";
	
	public static String statusComboBox="//lightning-combobox/div/lightning-base-combobox/div/div[1]/input";
	
	public static String statusListElements="//div[@role='listbox']";
	
	public static String caseStatusLabel="//article/div/div[2]/div/div/div[2]/div/section/div[1]/div/div/div/div/div[4]/div[1]/div/div[2]/span";
	
	public static String saveBtn="//button[@title='Save']";
	
	public static String serviceRequestDate = "//span[contains(text(),'Service Request Date')]/parent::div/following-sibling::div//*[@data-output-element-id='output-field']";
	
	public static String iconSRDflag= "//span[contains(text(),'SRD Flag')]/parent::div/following-sibling::div//img[@alt='Green']";
	
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
	
	public static String caseStatusFieldLabel="//article/div/div[2]/div/div/div[2]/div/section/div[1]/div/div/div/div/div[4]/div[1]/div/div[2]/span/span";
	
	public static String caseOwnerFieldLabel="//article/div/div[2]/div/div/div[2]/div/section/div[1]/div/div/div/div/div[3]/div[1]/div/div[2]/span/span";

	public static String itemsKeyDetails="//article[contains(.,'Key Details')]";

	public static String itemSubCategoryKeyDetails="(//span[@class='test-id__field-value slds-form-element__static slds-grow'])[13]";
	
	public static String caseNumberField="//slot[@name='header']//div[contains(text(),'Case')]";
	
	//23-06-2021 - D03 test Automation
	
	public static String caseMainTableDetailsTab="//ul[@role='tablist']/li[@title='Details' and @class='slds-tabs_default__item']";
	
	public static String sectionCaseCategorizationDetailsTab = "(//div[@class=\"test-id__section-content slds-section__content section__content slds-p-horizontal_small\"])[2]";

	public static String sectionAdditonalInfoDetailsTab = "//span[contains(text(),'Additional Information')]/ancestor::div[contains(@class,'test-id__section')]";
	
	public static String sectionDescriptionInfoDetailsTab = "//span[contains(text(),'Description Information')]/ancestor::div[contains(@class,'test-id__section')]";

}
