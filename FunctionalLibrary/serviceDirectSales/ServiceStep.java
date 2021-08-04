package serviceDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesProductBasket;
import orderDirectSales.OrderAction;
import testExecutionData.ProductConfigurationD02;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class ServiceStep {

	public static void fillDetailsFields(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill Details Fields";

		String stepNameMin="fillMandatoryDetailsFields";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		String textExistingBillingAccountIdField=ExcelDataFetch.searchDT(12, "textExistingBillingAccountIdField"); 


		boolean validation;

		try
		{
			ServiceAction.fillDetailsSection(logStream, driver, stepID, provContactPerson, textExistingBillingAccountIdField, testName);

			validation = ServiceAction.serviceDetailsScreenValidation(logStream, driver, stepID, provContactPerson, textExistingBillingAccountIdField, testName);

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

	

	public static void fillProvisioningContactPerson(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill Provisioning Contact Person";

		String stepNameMin="fillProvisioningContactPerson";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceAction.fillProvisioningContactPersonSingleAction(logStream, driver, stepID, provContactPerson);

			ServiceAction.saveServiceChanges(logStream, driver, stepID);

			validation = ServiceAction.validateProvisioningContactPersonAfterSaving(logStream, driver, stepID, provContactPerson);

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

	public static void fillBillingAccountID(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill Billing Account ID";

		String stepNameMin="fillBillingAccountID";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceAction.fillBillingAccountIDSingleAction(logStream, driver, stepID, provContactPerson);

			ServiceAction.saveServiceChanges(logStream, driver, stepID);

			validation = ServiceAction.validateBillingAccountIDAfterSaving(logStream, driver, stepID, provContactPerson);

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

	public static void fillBillingAccountIDNegative(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill Billing Account ID";

		String stepNameMin="fillBillingAccountID";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceAction.fillBillingAccountIDSingleAction(logStream, driver, stepID, provContactPerson);

			ServiceAction.saveServiceChanges(logStream, driver, stepID);

			validation = ServiceAction.validateBillingAccountIDAfterSavingNegative(logStream, driver, stepID, provContactPerson);

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

	public static void fillNewBillingAccount(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String textExistingBillingAccountIdField) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill New Billing Account";

		String stepNameMin="fillNewBillingAccount";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceAction.fillNewBillingAccountSingleAction(logStream, driver, stepID, textExistingBillingAccountIdField);

			ServiceAction.saveServiceChanges(logStream, driver, stepID);

			validation = ServiceAction.validateNewBillingAccountAfterSaving(logStream, driver, stepID, textExistingBillingAccountIdField);

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

	public static void serviceCaseValidationAfterOrderSubmit(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);

		String stepName="Service: Case Validation After Order Submit";

		String stepNameMin="serviceCaseValidationAfterOrderSubmit";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{

			validation = ServiceAction.caseLinkOnServicePageValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
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
			TestReporter.stepFailed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}

	public static void fillWithNewProvisioningContactPerson(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: fill With New Provisioning Contact Person";

		String stepNameMin="fillWithNewProvisioningContactPerson";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;


		try
		{
			ServiceAction.createNewProvisioningContactPerson(logStream, driver, stepID);

			validation = ServiceAction.validateNewProvisioningContactPersonAfterSaving(logStream, driver, stepID);

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

	public static void validateProvisioningContactPerson(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String provContactPerson) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: validate Provisioning Contact Person";

		String stepNameMin="step";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			validation = ServiceAction.validateProvisioningContactPersonAfterSaving(logStream, driver, stepID, provContactPerson);

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

	public static void validateNewBillingAccount(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String newBillingAccount) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: validate New Billing Account Address";

		String stepNameMin="step";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		

		String newBillingAddress=ExcelDataFetch.searchDT(11, "newBillingAddress");

		boolean validation;

		try
		{
			validation = ServiceAction.validateNewBillingAccountAfterSaving(logStream, driver, stepID, newBillingAddress);

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

	public static void fillContractType(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String contractType) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Fill Contract Type - "+contractType;

		String stepNameMin="fillContractType";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			Thread.sleep(2000);
			
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.name("contractTypePicklist")));
			
			if (contractType==null)
			{
			Select selectContractType = new Select(driver.findElement(By.name("contractTypePicklist")));

			contractType = 	selectContractType.getOptions().get(1).getText();
			
			}
			
			ServiceAction.fillContractTypeServiceLevel(logStream, driver, stepID, contractType);

			ServiceAction.saveServiceChanges(logStream, driver, stepID);

			validation = ServiceAction.valContractType(logStream, driver, stepID, contractType);

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
	
	public static void navigateToInternetECS(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String product) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Navigate to Internet child service ";

		String stepNameMin="navigateToInternetECS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceAction.navigateToInternetECS(logStream, driver, stepID, product, testName);

			validation = ServiceAction.valServiceInternetECS(logStream, driver, stepID);

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
	
	public static void navigateToInternetECS_PC(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String product) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Navigate to Internet child service ";

		String stepNameMin="navigateToInternetECS_PC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceAction.navigateToInternetECS_PC(logStream, driver, stepID, product, testName);

			validation = ServiceAction.valServiceInternetECS_PC(logStream, driver, stepID);

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

	public static void navigateToOrder(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Service: Navigate to Order ";

		String stepNameMin="navigateToOrder";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ServiceNavigation.navigateToOrder(testExecStructure, logStream, driver, testName);

			validation = OrderAction.orderScreenValidation(logStream, driver, stepID);

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
