package objectMap.sfDirectSales;

public class DirSalesOpportunity {

	//	public static String


	// New Opportunity Screen - D01

	public static String inputCompanyName="//input[@title='Search Company']";

	public static String newOpportunityHeader="//h2[contains(.,'New Opportunity')]";

	public static String inputCloseDate="//article/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/input";

	public static String inputOpportunityName="//article/div[3]/div/div[1]/div/div/div[1]/div[1]/div/div/div/input";

	public static String selectStage="//article/div[3]/div/div[1]/div/div/div[3]/div[2]/div/div/div/div/div[1]/div/div/a";

	public static String listState="/html/body/div[9]/div/ul";

	public static String closeWonOptyStage="//*/div/ul/li[8]/a";

	public static String selectForecastCategory="//article/div[3]/div/div[1]/div/div/div[4]/div[2]/div/div/div/div/div[1]/div/div/a";

	public static String listForecastCategory="/html/body/div[11]/div/ul";

	public static String nosCancelButton="//button[@name='CancelEdit']";

	public static String nosSaveButton="//button[@name='SaveEdit']";

	public static String additionalInformationTab="//h3[contains(.,'Additional Information')]";

	public static String termsAndConditionsComboBox="//article/div[3]/div/div[1]/div/div/div[7]/div[1]/div/div/div/div/div[1]/div/div/a";

	public static String termAndConditionsOption="//a[@title='Proximus standard T&C are applicable']";
	
	
	
	
	//New Quick Sale Opportunity - D02
	public static String quickSaleHeader = "//h2[. = 'Quick Sale']";
	
	public static String optyNameinput = "//input[@maxlength=120][@type='text']";
	
	public static String quickSaleOptyForm = "//div[@class='slds-form slds-form_stacked slds-is-editing']";
	
	public static String companyName = "//span[contains(@class,'uiOutputText forceOutputLookup')]";
	
	public static String forecastCategoryMenu = "//div[@class='slds-form slds-form_stacked slds-is-editing']/div[3]";
	
	public static String forecastCategoryText ="//section/div/div/div/div/div/div[3]/div/div/div/div/div/div[1]/div/div/a";
	
	public static String closeDateInput = "//div[@class='form-element']/input";
	
	public static String stageMenu = "//*[@class='slds-grid slds-col slds-is-editing slds-has-flexi-truncate pageBlockItemEditWithTooltip mdp forcePageBlockItem forcePageBlockItemEdit']/div/div/div/div/div/div/div/a";
	
	public static String stageText = "//section/div/section/div/div/div/div/div/div[5]/div/div/div/div/div/div[1]/div/div/a"; 
	
	public static String totalContractValueInput = "//div[@class='slds-form slds-form_stacked slds-is-editing']/div[6]";
	
	public static String cancelButton = "//*[@class='modal-footer slds-modal__footer']/button[1]";
	
	public static String saveButton = "//*[@class='modal-footer slds-modal__footer']/button[2]";
	
	public static String datePicker = "//a[@class='datePicker-openIcon display']";
	
	public static String todayCalendarLink = "//table/tbody/tr[7]/td/button";
	


	//OPTY Related Menu

	public static String showAllRelatedLinks="//a[contains(.,'Show All')]";

	public static String agreementsLink="//ul//span[@title='Agreements']";

	public static String productBasketsLink="//ul//span[@title='Product Baskets']";

	public static String productsLink="//ul//span[@title='Products']";






	//OPTY Details

	public static String followButton = "//button[.='Follow']";

	public static String editButton = "//div[@title='Edit']";

	public static String deleteButton = "//a[@title='Delete']";

	public static String cloneButton = "//a[@title='Clone']";

	public static String showMoreButton = "//a[contains(@title,'Show one more action')]";

	public static String optyHeader = "//h1[contains(.,'Opportunity')]";

	//public static String optyDetails = "//div[@class='slds-tabs_default']";
	
	public static String optyDetails="//flexipage-component2/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-record-layout-event-broker/slot/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___0123m0000000s3sqau___full___view___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]";
	
	public static String optyEdit = "//a[@title='Edit']";
	
	public static String editSelectStage ="//div[@class='uiMenu uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']";
	
	public static String noCloseWonHeader ="//span[contains(.,'Review the errors on this page.')]";
	
	public static String noCloseWonText ="//li[contains(.,'Please select a contact person first.')]";


	//Edit Opportunity Screen

	public static String editHeader="//h2[contains(.,'Edit')]";

	public static String editOpportunityErrors="//div[@class='pageLevelErrors']";
	
	public static String saveEditButton="//button[@name='SaveEdit']";

	public static String cancelEditButton="//button[@name='CancelEdit']";
	
	public static String editConfirmationMessage="//span[@class='toastMessage slds-text-heading--small forceActionsText'][contains(.,'was saved')]";

	public static String editInputSelectStage="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-record-layout-event-broker/slot/records-lwc-record-layout/forcegenerated-detailpanel_opportunity___012000000000000aaa___full___edit___recordlayout2/force-record-layout-block/slot/force-record-layout-section[1]/div/div/div/slot/force-record-layout-row[3]/slot/force-record-layout-item[2]/div/span/slot/slot/sfa-input-stage-name/force-record-picklist/force-form-picklist/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/input";

	//Close This Opportunity Menu


	//OPTY Pool Screen
	public static String optysHeader = "//div[@class='slds-page-header--object-home slds-page-header_joined slds-page-header_bleed slds-page-header slds-shrink-none test-headerRegion forceListViewManagerHeader']";

	public static String refreshButton = "//button[@name='refreshButton']";

	public static String newButton = "//a[@title='New']";

	public static String optyTablePool = "//table[@role='grid']";

	public static String optyTableResults = "//th[1]/span/a";


	
	// 19-02-2021 - New Mandatory Opportunity Fields
	public static String textareaDescription="//textarea[@maxlength='32000']";
	
	public static String selectLevelOfConfidence="(//input[@lightning-basecombobox_basecombobox])[4]";
	
	public static String inputNextStep="//input[@name='NextStep']";
	
	public static String inputNextStepDueDate="//input[@name='PRX_Next_Step_Due_Date__c']";
	
	public static String selectProductFamily="(//input[@lightning-basecombobox_basecombobox])[9]";
	
	public static String nomeCompetitorName="//span[@title='None']";
	
	public static String buttonAddToChosen="//button[@title='Move selection to Chosen']";
	
	public static String selectStageEditScreen="(//input[@lightning-basecombobox_basecombobox])[3]";
}
