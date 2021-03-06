package casePartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesCase;
import objectMap.sfDirectSales.DirSalesOrder;
import objectMap.sfDirectSales.DirSalesService;
import objectMap.sfPartnersCommunity.PartComCase;
import objectMap.sfPartnersCommunity.PartComService;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class CasePCNavigation {

	public static void goToCaseScreenByServiceName(List<TestStepReportStructure> testExecStructure,List<TestLog> logStream, WebDriver driver,String testName,
			String serviceName) throws Exception 
	{
		String actionName="goToCaseScreenByServiceName";
		
		boolean validation = false;

		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Navigate to Case ";

		String stepNameMin="navigateToCase";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	
		
		String serviceURL;

		try
		{
			Thread.sleep(1000);
			
			new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(By.xpath(DirSalesOrder.viewAllServices)));
			
			if(BrowserActions.isElementPresent(driver, DirSalesOrder.viewAllServices)==true) {
				BrowserActions.jsClick(driver, By.xpath(DirSalesOrder.viewAllServices));
			}
			
			Thread.sleep(2000);
			
			if(BrowserActions.isElementPresent(driver, "(//a[starts-with(text(),'"+serviceName+"')])[2]")==false) {
				serviceURL=driver.findElement(By.xpath("(//a[starts-with(text(),'"+serviceName+"')])[1]")).getAttribute("href");

			}
			else
			{
				serviceURL=driver.findElement(By.xpath("(//a[starts-with(text(),'"+serviceName+"')])[2]")).getAttribute("href");

			}
			
//			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[starts-with(text(),'"+serviceName+"')])[2]")));
			
			System.out.println("Debug - serviceURL: "+serviceURL);
			
			BrowserActions.goToByURL(driver, serviceURL);
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PartComService.headerServicesPage)));
			
//			driver.findElement(By.xpath(PartComService.caseLink)).click();
			
			BrowserActions.jsClick(driver, By.xpath(PartComService.caseLink));

			Thread.sleep(1000);
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(PartComCase.headerCase)));

			Thread.sleep(1000);

//			System.out.println(driver.findElement(By.xpath(PartComCase.headerCase)).isDisplayed());
			
			validation = driver.findElement(By.xpath(PartComCase.headerCase)).isDisplayed();
			
			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				TestLogger.logTrace(logStream, stepNameMin, "Failed in Step: "+stepID+". Validation: False");
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}

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
