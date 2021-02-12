package objectMap.sfDirectSales;

public class DirSalesCompanyContactPerson 
{
	/* 12/02/2021
	 * New Company Contact Person
	 * Divided into 2 major blocks: FirstScreen, FillMandatoryDetails Screen
	 */
	
	
	// New Company Contact Person - FirstScreen
	
	public static String headerNewCompanyContactPerson="//h2[text()='New Company contact person']";
	
	public static String radioButtonContactPerson="(//input[@type='radio'])[1]";
	
	public static String radioButtonContactGroup="(//input[@type='radio'])[2]";
	
	public static String buttonCancel="//button/span[text()='Cancel']";
	
	public static String buttonNext="//button/span[text()='Next']";
	
	
	// FillMandatoryDetails Screen
	
	public static String inputFirstName="//input[@class='firstName compoundBorderBottom form-element__row input']";
	
	public static String inputLastName="//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']";
	
	public static String inputSelectCompany="//input[@title='Search Company']";
	
	public static String selectCompanyOption="//div[@title='companyName']";
	
	public static String inputEmail="//input[@inputmode='email']";
	
	public static String selectDepartment="//article/div[3]/div/div[1]/div/div/div[7]/div[1]/div/div/div/div/div/div/div/a";
	
	public static String optionDepartmentAdministration="//*[text()='Administration']";
	
	public static String selectTitle="//article/div[3]/div/div[1]/div/div/div[8]/div[1]/div/div/div/div/div[1]/div/div/a";
	
	public static String optionTitleAssistant="(//*[text()='Assistant'])[2]";
	
	
	//Roles Part
	
	public static String availableRolesList="//article/div[3]/div/div[1]/div/div/div[9]/div[1]/div/div/lightning-picklist/lightning-dual-listbox/div/div[2]/div/div[3]/div/ul";
	
	public static String buttonMoveSelectionToChosen="//button[@title='Move selection to Chosen']";
	
	public static String roleDecisionMaker="//span[@title='Decision Maker (sales)']";
	
	public static String buttonMoveSelectionToAvailable="//button[@title='Move selection to Available']";
	
	public static String chosenRolesList="//article/div[3]/div/div[1]/div/div/div[9]/div[1]/div/div/lightning-picklist/lightning-dual-listbox/div/div[2]/div/div[5]/div/ul";
	
	//End Of Roles Part
	
	
	public static String selectGender="//article/div[3]/div/div[1]/div/div/div[10]/div[1]/div/div/div/div/div[1]/div/div/a";
	
	public static String optionGenderUnspecified="//*[text()='Unspecified']";
	
	public static String selectLanguage="//article/div[3]/div/div[1]/div/div/div[10]/div[2]/div/div/div/div/div[1]/div/div/a";
	
	public static String optionLanguageEnglish="//*[text()='English']";
	
	public static String buttonSave="//button[@title='Save']";
	
	
	
}
