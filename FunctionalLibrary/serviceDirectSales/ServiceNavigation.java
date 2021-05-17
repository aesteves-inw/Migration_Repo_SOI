package serviceDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesOrder;
import objectMap.sfDirectSales.DirSalesService;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class ServiceNavigation 
{
	public static void navigateToOrder(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception 
	{
		String actionName="navigateToOrder";

		boolean validation = false;

		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Navigate to Order ";

		String stepNameMin="navigateToOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		

		try
		{

			WebElement orderLink = driver.findElement(By.xpath("//a[contains(.,'New')]"));

			orderLink.click();

			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesOrder.orderHeader)));

			Thread.sleep(1000);
			
			validation = driver.findElement(By.xpath(DirSalesOrder.orderHeader)).isDisplayed();

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


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}

	
}
