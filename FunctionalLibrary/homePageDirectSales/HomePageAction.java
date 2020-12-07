package homePageDirectSales;

import java.util.List;

import org.openqa.selenium.WebDriver;

import fetchDataFromExcelFiles.ExcelDataFetch;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class HomePageAction {

	public static boolean homePageValidation(List<TestLog> logStream, WebDriver driver) throws Exception
	{
		String componentName="homePageValidation";

		String homePageURLValidation, homePageURL, homePageTitle, homePageTitleValidation;

		homePageURLValidation=driver.getCurrentUrl();

		homePageTitleValidation=driver.getTitle();

		homePageURL=ExcelDataFetch.searchDT(0, "DirectSalesHomePage");

		homePageTitle=ExcelDataFetch.searchDT(0, "DirectSalesHomePageTitle");

		try
		{
			if(homePageURL.equalsIgnoreCase(homePageURLValidation) && homePageTitle.equalsIgnoreCase(homePageTitleValidation))
			{
				TestLogger.logTrace(logStream, componentName, TestLogger.logInfo);
				return true;
			}
			else
			{
				return false;
			}

		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}

	}

	
}
