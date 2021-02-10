package objectMap.sfPartnersCommunity;

public class PartComService {
	
	// ..:: Services Page ::..
	
	// --- Related Menu ---
	public static String filesContainer="//article[contains(.,'Files')]";
	
	// --- Page Header ---
	public static String headerServicesPage="//h1[contains(.,'Service')]";
	
	// --- Page Details ---
	public static String detailsServicePage="//div/div/article/div[2]/div";
	
	public static String fieldServiceName="//span[.='Service Name']";
	
	public static String fieldQuote ="//span[.='Quote']";
	
	public static String fieldCase ="//span[.='Case']";
	
	public static String fieldDomain ="//span[.='Domain']";
	
	public static String fieldType="//span[.='Type']";
	
	public static String fieldDetail="//span[.='Detail']";
	
	public static String fieldServiceRequestDate="//span[.='Service Request Date']";
	
	public static String fieldEnd2EndRequestOwner="//span[.='End2End Request Owner']";
	
	public static String fieldStatus="//span[.='Status']";
	
	public static String caseLink="//a[contains(@href,'case')][contains(.,'0')]";
	

	// --- D03 Test Automation ---
	public static String saveDetailsButton="//button[@type='submit']";
	
	public static String saveServiceSuccessMessage="//span[@data-aura-class='forceActionsText'][text()='The record has been updated successfully.']";


}
