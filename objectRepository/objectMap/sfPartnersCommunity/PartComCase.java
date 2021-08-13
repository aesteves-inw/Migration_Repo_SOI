package objectMap.sfPartnersCommunity;

public class PartComCase {
	
	public static String caseInformation="//span[contains(.,'Case Information')]";
	
	public static String caseCategorization="//span[contains(.,'Case Categorization')]";
	
	public static String additionalInformation="//span[contains(.,'Additional Information')]";
	
	public static String linkRelated ="//span[contains(.,'Related')]";
	
	
	
	public static String headerCase="//h1[contains(.,'Case')]";
	
	public static String detailsCase="/html/body/div[3]/div[2]/div/div[2]/div[1]";
	
	
	// 06-03-2020 - Case Fields: - SOI-880
	
	public static String caseStatusLabel="//article/div[2]/div/div[1]/div/div/div[1]/div[2]/div/div[2]/span/span";
			
	public static String caseOwnerFieldLabel="//article/div[2]/div/div[1]/div/div/div[3]/div[1]/div/div[2]/span/div/div/div/span";
	
	// 13-08-2021 - Case fields: - SOI- 4025
	
	public static String serviceRequestDate = "//span[contains(text(),'Service Request Date')]/parent::div/following-sibling::div//*[@class='uiOutputDate']";

}
