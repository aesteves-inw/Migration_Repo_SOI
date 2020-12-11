package homePageDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class HomePageNavigation {

	public static void goToDefaultCompanyDetailsPage(List<TestLog> logStream, WebDriver driver, int stepsExecuted) throws Exception
	{		
		String companyID, companyURL;
		
		String componentName="goToCompanyDetailsPage";
		
		companyID=ExcelDataFetch.searchDT(2, "idCompanyD02Functional");
		
		
		companyURL="https://proximus--prxitt.lightning.force.com/lightning/r/Account/"+companyID+"/view";

		try
		{
			BrowserActions.goToByURL(driver, companyURL);
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

			TestLogger.logTrace(logStream, componentName, TestLogger.logInfo);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}

	}



}

	
	