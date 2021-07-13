package agreementPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class AgreementPCNavigation 
{
	public static void goToFilesRelatedList(List<TestLog> logStream, WebDriver driver, int stepID, String agreementID) throws Exception
	{
		String actionName="goToFilesRelatedList";

		//PartnersCommunity+PartnersCommunityRelatedList+agreementID+PartnersCommunityRelatedListFiles
		
		try
		{
			
			String urlForFilesRelatedList=ExcelDataFetch.searchDT(0,"PartnersCommunity")+ExcelDataFetch.searchDT(0,"PartnersCommunityRelatedList")+agreementID+ExcelDataFetch.searchDT(0,"PartnersCommunityRelatedListFiles");

			BrowserActions.goToByURL(driver, urlForFilesRelatedList);
			
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void downloadfile(List<TestLog> logStream, WebDriver driver, int stepID, String agreementID) throws Exception 
	{
		String actionName="downloadfile";
		
		WebDriverWait driverWait = new WebDriverWait(driver, 30);


		try
		{
			Thread.sleep(5000);
		
			WebElement newBasketAgreementDocs = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'View All')]/ancestor::a")));
			String newBasketAgreementDocsURL=newBasketAgreementDocs.getAttribute("href");
			
			System.out.println(newBasketAgreementDocsURL);
			
			BrowserActions.goToByURL(driver, newBasketAgreementDocsURL);
			
			WebElement buttonShowMoreOptions = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@title,'"+agreementID+".pdf')]/ancestor::tr/td//a[@role='button']")));
			
			BrowserActions.jsClick(driver, buttonShowMoreOptions);
			
			Thread.sleep(3000);
			
			BrowserActions.jsClickByXpath(driver, "//a[@title='Download']");
			
			Thread.sleep(10000);
			

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
