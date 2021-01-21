package loginPageDirectSales;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesHomePage;
import objectMap.sfDirectSales.DirSalesLoginPage;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class LoginPageAction {
	
	public static void loginDirectSales(List<TestLog> logStream, WebDriver driver, int stepID, String user) throws Exception
	{
		String componentName="loginDirectSales";
		
		String locatedcomponentName=componentName+" on Step "+stepID;
		
		try
		{
			goToLoginPage(logStream, driver);
			
			fillcredentials(logStream, driver, user);
			
			pressLoginButton(logStream, driver);
			
			
			TestLogger.logInfo(logStream, locatedcomponentName, TestLogger.logInfo);
			
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, locatedcomponentName, TestLogger.logError, e.toString());
			throw new Exception(locatedcomponentName+" - "+TestLogger.logError, e);
		}
	}

	private static void goToLoginPage(List<TestLog> logStream, WebDriver driver) throws Exception 
	{
		String componentName="goToLoginPage";
		
		String loginURL=ExcelDataFetch.searchDT(0, "DirectSales");
		
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

	public static void fillcredentials(List<TestLog> logStream, WebDriver driver, String user) throws Exception 
	{
		String componentName="fillcredentials";
		
		String[] userCredentials=TestCasesData.getSalesforceUser(user);
		
		
		try
		{
			driver.findElement(By.xpath(DirSalesLoginPage.userName)).sendKeys(userCredentials[0]);
			
			driver.findElement(By.xpath(DirSalesLoginPage.passWord)).sendKeys(userCredentials[1]);
			
			
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
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesHomePage.header)));
			
			
			TestLogger.logTrace(logStream, componentName, TestLogger.logInfo);
			
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}
		
	}
	

	
	
}
