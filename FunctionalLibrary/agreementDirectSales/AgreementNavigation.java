package agreementDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import navigation.NavigationAction;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AgreementNavigation 
{
	// Navigation Steps from Agreement to Other Objects/Screens
	
	public static void goToOpportunityPage(List<TestLog> logStream, WebDriver driver, int stepID, String testName) throws Exception
    {
        String actionName="Agreement - Navigation to Opportunity Page";
        
        String optyName=TestCasesData.getOPTYName(testName);


				try
				{
					driver.findElement(By.linkText(optyName)).click();
					
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

					TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

				}
				catch(Exception e)
				{
					System.out.println(e);
					TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}

    }

	public static void goToFilesRelatedListView(List<TestLog> logStream, WebDriver driver, int stepID,
			String agreementID) throws Exception 
	{
		String actionName="goToFilesRelatedListView";

		String agreementFilesRelatedListViewURL=ExcelDataFetch.searchDT(0, "DirectSales")+ExcelDataFetch.searchDT(0, "DirectSalesFiles")+agreementID+ExcelDataFetch.searchDT(0, "DirectSalesFilesRelatedView");

		try
		{
			NavigationAction.goToByURL(logStream, driver, stepID, agreementFilesRelatedListViewURL);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

		
	}

	
	public static void downloadProposal(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="goToProposalByURL";

		String agreementURL, proposalURL;
		
		try
		{
			agreementURL=driver.getCurrentUrl();
			
			WebElement generatedProposal =driver.findElement(By.xpath("//a[contains(@title,'Agreement')][contains(@title,'.pdf')][contains(@title,'"+TestCasesData.getIDByURL(driver.getCurrentUrl())+"')]"));
			
			proposalURL=generatedProposal.getAttribute("href");
			
			BrowserActions.goToByURL(driver, proposalURL);
			
			System.out.println("goToProposalByURL - Passa Aqui antes de clickar no botão Download");
			
			WebElement downloadButton = new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='Download']")));

			Thread.sleep(5000);
			
			BrowserActions.jsClick(driver, downloadButton);
			
			BrowserActions.goToByURL(driver, agreementURL);
			
			Thread.sleep(5000);
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}		
	}
	
}
