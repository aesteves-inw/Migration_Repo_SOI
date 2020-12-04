package companyDirectSales;

import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import executionTools.TestObjectTools;

public class CompanyNavigation {
	
	public void goToOpportunityPage(WebDriver driver, String testName, String opportunityName)
	{
		String optyURL, optyRecordID;
		
		goToOpportunityRelatedMenuonCompany(driver, testName);
		
		optyRecordID= TestObjectTools.getDataRecordID(driver, opportunityName);
		
		optyURL="https://proximus--prxitt.lightning.force.com/lightning/r/Opportunity/"+optyRecordID+"/view";
		
		BrowserActions.goToByURL(driver, optyURL);
		
	}

	private void goToOpportunityRelatedMenuonCompany(WebDriver driver, String testName) 
	{
		
		
	}

}
