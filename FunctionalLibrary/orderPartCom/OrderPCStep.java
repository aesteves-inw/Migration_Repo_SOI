package orderPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import fetchDataFromExcelFiles.ExcelDataFetch;
import navigation.NavigationAction;
import orderDirectSales.OrderAction;
import servicePartCom.ServicePCAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class OrderPCStep {

	public static void goToServiceScreenByURL(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String sURL) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: go To Service Screen By URL";

		String stepNameMin="goToServiceScreenByURL";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			BrowserActions.goToByURL(driver, sURL);

			validation = ServicePCAction.serviceScreenValidation(logStream, driver, stepID);

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

	public static void submitOrderPositiveValidation(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: Submit Order (Positive) Validation";

		String stepNameMin="submitOrderPositiveValidation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.submitOrder(logStream, driver, stepID);

			validation = OrderPCAction.orderSubmissionPositiveValidation(logStream, driver, stepID);

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

	public static void submitOrderNegativeValBillingAddress(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: submit Order - Negative Val BillingAddress";

		String stepNameMin="submitOrderNegativeValBillingAddress";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.submitOrder(logStream, driver, stepID);

			validation = OrderPCAction.orderSubmissionNegativeValBillingAddress(logStream, driver, stepID);

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

	public static void submitOrderNegativeValProvisioningContact(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: submit Order (Negative Val - ProvisioningContact)";

		String stepNameMin="submitOrderNegativeValProvisioningContact";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.submitOrder(logStream, driver, stepID);

			validation = OrderPCAction.negativeValProvisioningContact(logStream, driver, stepID);

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


	public static void validateFileOnOrderRelatedMenu(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String fileName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: validate File On Order Related Menu (In PC)";

		String stepNameMin="validateFileOnOrderRelatedMenuInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			validation = BrowserActions.isElementPresent(driver, "//a[contains(@title, '"+fileName+"')]");

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
	
	
	public static void addFileToOrder(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String filePath, String fileName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: add File To Order (In PC)";

		String stepNameMin="addFileToOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.addFileToOrder(logStream, driver, stepID, filePath);

			validation = OrderPCAction.validateFileInOrderScreen(logStream, driver, stepID, fileName);

			

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

	public static void submitOrderNegativeValContractType(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="step";

		String stepNameMin="step";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderPCAction.submitOrder(logStream, driver, stepID);

			validation = OrderAction.submitOrderNegativeValContractType(logStream, driver, stepID);

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
	
	public static void submitOrderNegativeValPC(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{ 
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: Submit Order (Negative)";

		String stepNameMin="submitOrderNegativeVal";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			OrderAction.submitOrderPC(logStream, driver, stepID);
			
			validation = OrderAction.submitOrderNegativeValPC(logStream, driver, stepID);

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

	public static void goToServiceScreenByServiceName(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String serviceName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: go To Service Screen By Service Name";

		String stepNameMin="goToServiceScreenByServiceName";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	
		
		
		String serviceID, serviceURL;


		boolean validation;

		try
		{
			//WebElement serviceLink = driver.findElement(By.xpath("//a[@title='"+serviceName+"']"));
			
			WebElement serviceLink = driver.findElement(By.xpath("//a[contains(.,'"+serviceName+"')]"));
			
			serviceID=serviceLink.getAttribute("data-recordid");
			
			serviceURL=ExcelDataFetch.searchDT(0, "PartnersCommunity")+"/"+serviceID;
			
			NavigationAction.goToByURL(logStream, driver, stepID, serviceURL);

			validation = ServicePCAction.serviceScreenValidation(logStream, driver, stepID);

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
	
	public static void validateContractTypeColumnPC(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String contractType) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Order: validate Contract Type Column";

		String stepNameMin="validateContractTypeColumnPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			validation = OrderAction.validateContractTypeColumnPC(logStream, driver, stepID, contractType);

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
