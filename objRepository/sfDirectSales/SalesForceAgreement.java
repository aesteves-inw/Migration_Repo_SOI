package sfDirectSales;

public class SalesForceAgreement {
	
	
	//   ..:: Agreements Details Page ::..
	
	public static String editButton="//div[@title='Edit']";
	
	public static String headerAgreementPage="//h1[contains(.,'Agreement')]";
	
	//public static String detailsAgreement="/html/body/div[5]/div[1]/section/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/div/div";
	public static String detailsAgreement="//div[@class='slds-tabs_default']";
	
	public static String nameAgreement="//span[contains(.,'Agreement Name')]";
	
	
	
	//Agreement Related Menu
	
	public static String filesContainer="//article[contains(.,'Files')]";
	
	public static String uploadFilesBtn="(//span[contains(.,'Upload Files')])[2]";
	
	public static String showMoreActionsBtn="//article[contains(.,'Files')]//span[contains(.,'Show more actions')]";
	
	public static String selectFilesScreen="//div[@data-aura-class='forceContentFilePicker']";
	
	public static String uploadFilesSelectScreen="//button[text()='Upload Files']";
	
	
	//   ..:: Edit Agreement Page
	
	public static String headerEditAgreementPage="//h2[contains(.,'Edit')]";
	
	public static String agreementFields="/html/body/div[5]/div[2]/div/div[2]/div/div[2]";
	
	public static String inputAgreementName="//article/div[3]/div/div[1]/div/div/div[1]/div[1]/div/div/div/input";
	
	public static String selectStatus="//article/div[3]/div/div[1]/div/div/div[3]/div[1]/div/div/div/div/div[1]/div/div/a";
	
	public static String selectDocumentType="//article/div[3]/div/div[1]/div/div/div[3]/div[2]/div/div/div/div/div[1]/div/div/a";
	
	public static String saveButton="/html/body/div[5]/div[2]/div/div[2]/div/div[3]/div/button[3]/span";
	
	
	
	// Upload Files Screen
	
	public static String uploadFilesHeader ="//h2[contains(.,'Upload Files')]";
	
	public static String doneButton="//button[contains(.,'Done')]";
	
	
	
	// Upload Messages
	
	public static String successMessage="//div[contains(.,'1 file was added to Agreement.')]";
	
	public static String errorMessage="//div[contains(.,'1 file is already in Agreement.')]";

}
