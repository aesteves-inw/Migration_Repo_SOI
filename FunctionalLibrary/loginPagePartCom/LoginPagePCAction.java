package loginPagePartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import loginPageDirectSales.LoginPageAction;
import objectMap.sfDirectSales.DirSalesLoginPage;
import objectMap.sfPartnersCommunity.PartComHomePage;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class LoginPagePCAction 
{

	public static void loginPartnersCommunity(List<TestLog> logStream, WebDriver driver, int stepID,
			String userProfile) throws Exception 
	{
		 String actionName="loginPartnersCommunity";


			try
			{
				goToLoginPage(logStream, driver);
				
				LoginPageAction.fillcredentials(logStream, driver, userProfile);
				
				pressLoginButton(logStream, driver);
				

				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}

		
	}
	
	private static void goToLoginPage(List<TestLog> logStream, WebDriver driver) throws Exception 
	{
		String componentName="goToLoginPage";
		
		String loginURL=ExcelDataFetch.searchDT(0, "PartnersCommunity");
		
		try
		{
			BrowserActions.goToByURL(driver, loginURL);
			
			TestLogger.logTrace(logStream, componentName, TestLogger.logInfo);
			
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}
		
	}
	
	private static void pressLoginButton(List<TestLog> logStream, WebDriver driver) throws Exception 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String componentName="pressLoginButton";
		
		try
		{
			driver.findElement(By.xpath(DirSalesLoginPage.loginbtn)).click();	
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComHomePage.headerNavigationBar)));
			
			
			TestLogger.logTrace(logStream, componentName, TestLogger.logInfo);
			
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}
		
	}

}
