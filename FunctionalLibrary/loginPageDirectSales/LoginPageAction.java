package loginPageDirectSales;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesLoginPage;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class LoginPageAction {
	
	public void loginDirectSales(List<TestLog> logStream, WebDriver driver, String user) throws Exception
	{
		String componentName="loginDirectSales";
		
		try
		{
			goToLoginPage(logStream, driver);
			
			fillcredentials(logStream, driver, user);
			
			pressLoginButton(logStream, driver);
			
			
			TestLogger.logInfo(logStream, componentName, TestLogger.logInfo);
			
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}
	}

	private void goToLoginPage(List<TestLog> logStream, WebDriver driver) throws Exception 
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

	private void fillcredentials(List<TestLog> logStream, WebDriver driver, String user) throws Exception 
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

	private void pressLoginButton(List<TestLog> logStream, WebDriver driver) throws Exception 
	{
		String componentName="pressLoginButton";
		
		try
		{
			driver.findElement(By.xpath(DirSalesLoginPage.loginbtn)).click();
			
			//07-12-2020 - To Review after first execution.
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			
			
			TestLogger.logTrace(logStream, componentName, TestLogger.logInfo);
			
		}
		catch(Exception e)
		{
			TestLogger.logError(logStream, componentName, TestLogger.logError, e.toString());
			throw new Exception(componentName+" - "+TestLogger.logError, e);
		}
		
	}

	
	
}
