package sfDirectSales;

public class SalesForceService {
	
	// ..:: Services Page ::..
	
	// --- Related Menu ---
	public static String filesContainer="//article[contains(.,'Files')]";
	
	// --- Page Header ---
	public static String headerServicesPage="//h1[contains(.,'Service')]";
	
	// --- Page Details ---
	public static String detailsServicePage="//div/div/article/div[2]/div";
	
	public static String fieldServiceName="//span[contains(.,'Service Name')]";
	
	public static String fieldQuote ="//span[contains(.,'Quote')]";
	
	public static String fieldCase ="//span[contains(.,'Case')]";
	
	public static String fieldDomain ="//span[contains(.,'Domain')]";
	
	public static String fieldType="//span[contains(.,'Type')]";
	
	public static String fieldDetail="//span[contains(.,'Detail')]";
	
	public static String fieldServiceRequestDate="//span[contains(.,'Service Request Date')]";
	
	public static String fieldfilledServiceRequestDate="//div[contains(.,'Service Request Date')]/div[3]/div[2]/div";
	
	public static String fieldEnd2EndRequestOwner="//span[contains(.,'End2End Request Owner')]";
	
	public static String fieldStatus="//span[contains(.,'Status')]";
	
	public static String fieldfilledCompanyContactPerson="//article/div[2]/div/div[1]/div/div/div[4]/div[2]/div";
	
	public static String caseLink="//force-hoverable-link/div/a[contains(.,'00')]";
	
	public static String serviceStatus="(//force-record-layout-item[1]/div/div/div[2]/span/slot[1]/slot/lightning-formatted-text)[28]";
	
	
	// --- Edit Buttons ---
	
	public static String editCompanyContactPersonBtn ="(//button[@title='Edit Company Contact Person'])";
	
	public static String editServiceRequestDate="(//button[contains(.,'Edit Service Request Date')])";
	
	public static String serviceReqDateCalendarButton="//a[@class='datePicker-openIcon display']";
	
	public static String serviceReqDateTodayButton="//span[contains(.,'Today')]";
	
	
	// --- Service Edition: input boxes ---
	
	public static String inputServiceRequestDate = "/html/body/div[5]/div[1]/section/div/div/div[1]/div[5]/div/div[1]/div/div[2]/div[1]/div/div/section/div/div/article/div[3]/div/div[1]/div/div[1]/div/div/div[3]/div[2]/div/div/div/div/input";
	
	public static String inputCompanyContactPerson="//input[@title='Search Company contact person']";

	public static String companyContactPersonList="//div[@class='listContent']/ul/li";
	
	public static String inputComments="//textarea";
	
	
	// --- Edit Details Page 
	
	public static String saveBtn="//button[@title='Save']";
	
}
