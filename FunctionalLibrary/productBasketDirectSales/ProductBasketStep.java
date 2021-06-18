package productBasketDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import addOfferToBasketDirectSales.AddOfferToBasketAction;
import agreementDirectSales.AgreementAction;
import agreementPartCom.AgreementPCAction;
import editProductConfigurationScreenDirectSales.EProdConfigAction;
import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import fetchDataFromExcelFiles.ExcelDataFetch;
import navigation.NavigationAction;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityAction;
import orderEnrichmentDirectSales.OrderEnrichmentAction;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class ProductBasketStep 
{
	public static void goToAddOferToBasketScreen(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Go To Add Offer to Basket Screen";

		String stepNameMin="goToAddOferToBasketScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.openAddProductMenu(logStream, driver, stepID);

			validation = AddOfferToBasketAction.addProductMenuValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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
	
	public static void categorieValidatationStep(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Go To Add Offer to Basket Screen and Categorie Validation";

		String stepNameMin="categorieValidatationStep";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.openAddProductMenu(logStream, driver, stepID);

			validation = AddOfferToBasketAction.categorieProductMenuValidation(logStream, driver, stepID,testName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName+"_Part1");
				BrowserActions.verticalscrollByVisibleElement(driver, DirSalesProductBasket.categoryExternallyQuotedProducts);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName+"_Part2");
				BrowserActions.verticalscrollByVisibleElement(driver, DirSalesProductBasket.categoryExternallyQuotedProducts_ComputeStorage);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName+"_Part3");
				BrowserActions.verticalscrollByVisibleElement(driver, DirSalesProductBasket.categoryExternallyQuotedProducts_MassMarket);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName+"_Part4");
				BrowserActions.verticalscrollByVisibleElement(driver, DirSalesProductBasket.categoryExternallyQuotedProducts_NetwConnServ);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName+"_Part5");
				BrowserActions.verticalscrollByVisibleElement(driver, DirSalesProductBasket.categoryExternallyQuotedProducts_Voice);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName+"_Part6");



			
			}
			else
			{
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
	
	public static void syncProductBasket(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Sync Product Basket (Positive Validation)";

		String stepNameMin="syncProductBasketPosVal";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.syncProductBasket(logStream, driver, stepID);

			validation = ProductBasketAction.syncProductBasketPosVal(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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
	
	public static void syncProductBasketNegVal(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, int newStepCounter, String testName) throws Exception 
	{
		String stepName="Sync Product Basket (Negative Validation)";

		String stepNameMin="syncProductBasketNegVal";

		String evidenceName=ReportStructure.evidenceName(newStepCounter, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.syncProductBasket(logStream, driver, newStepCounter);

			validation = ProductBasketAction.syncProductBasketNegVal(logStream, driver, newStepCounter);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
		}

		
	}

	public static void deletePBLineItem(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, int newStepCounter, String productName) throws Exception 
	{
		String stepName="Delete Product Basket Line Item";

		String stepNameMin="deletePBLineItem";

		String evidenceName=ReportStructure.evidenceName(newStepCounter, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.selectLineItem(logStream, driver, newStepCounter, productName);
			
			ProductBasketAction.deleteLineItem(logStream, driver, newStepCounter);
			
			validation = ProductBasketAction.productOnProductBasketNegativeValidation(logStream, driver, newStepCounter, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, newStepCounter, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+newStepCounter);
		}
		
	}

	public static void expandECSPackage(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception
	{
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Expanding ECS Package on Product Basket";

		String stepNameMin="expandECSPackage";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{	
			ProductBasketAction.expandingECS(logStream, driver, stepID, productName);
			
			validation = ProductBasketAction.expandedECSPackValidation(logStream, driver, stepID, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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
	
	public static void selectInternetECSPackage(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception
	{
		int stepID;
		
		stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Select Internet of an ECS Package on Product Basket";

		String stepNameMin="selectInternetECSPackage";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.expandingECS(logStream, driver, stepID, productName);
			
			WebElement internetEditButton = driver.findElement(By.xpath("//div[@id='basket-table']/div[2]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[7]/button[1]"));
			
			internetEditButton.click();
			
			validation = ProductBasketAction.internetEditConfigValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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

	public static void goToEditProductConfigurationScreen(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Go To Edit Product Configuration Screen - "+productName;

		String stepNameMin="goToEditProductConfigurationScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.goToEditProductConfiguration(logStream, driver, stepID, productName);
			
			EProdConfigAction.changeToEditProductConfigurationiFrame(logStream, driver, stepID);

			validation = EProdConfigAction.editProductConfiguration(logStream, driver, stepID, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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
	public static void goToEditProductConfigurationScreenECS(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Go To Edit Product Configuration Screen - "+productName;

		String stepNameMin="goToEditProductConfigurationScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.goToEditProductConfiguration(logStream, driver, stepID, productName);
			
			EProdConfigAction.changeToEditProductConfigurationiFrame(logStream, driver, stepID);

			validation = EProdConfigAction.editProductConfigurationECS(logStream, driver, stepID, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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
	
	public static void goToEditProductConfigurationScreenForD03(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Go To Edit Product Configuration Screen For D03 Product - "+productName;

		String stepNameMin="goToEditProductConfigurationScreenForD03";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.goToEditProductConfiguration(logStream, driver, stepID, productName);
			
			EProdConfigAction.changeToEditProductConfigurationiFrame(logStream, driver, stepID);

			validation = EProdConfigAction.editProductConfigurationForD03(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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
	
	public static void goToAgreementScreen(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Product Basket: Go To Agreement Screen (After Sync)";

		String stepNameMin="goToAgreementScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketNavigation.goToAgreement(logStream, driver, stepID);

			validation = AgreementAction.agreementScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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

	public static void goToAgreementScreenInPC(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		String stepName="Product Basket: Go To Agreement Screen (After Sync) in PartCom";

		String stepNameMin="goToAgreementScreenInPC";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketNavigation.goToAgreement(logStream, driver, stepID);

			validation = AgreementPCAction.agreementScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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
	
	public static void goToOpportunityScreenByURL(List<TestStepReportStructure> testReportStream, List<TestLog> logStream, WebDriver driver, String testName, String optyURL) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testReportStream);
		
		
		String stepName="Product Basket: Go To Opportunity Screen By URL";

		String stepNameMin="goToOpportunityScreenByURL";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.changeToDefaultiFrame(logStream, driver, stepID);
			
			NavigationAction.goToOPTYByURL(logStream, driver, stepID, optyURL);

			validation = OpportunityAction.opportunityScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testReportStream, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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

	public static void fillExistingBillingAccountIdField(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Product Basket: fill Existing Billing Account Id Field";

		String stepNameMin="fillExistingBillingAccountIdField";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;
		
		String textExistingBillingAccountIdField="04121986";

		try
		{
			ProductBasketAction.fillExistingBillingAccountIdField(logStream, driver, stepID, textExistingBillingAccountIdField);
			
			Thread.sleep(2000);

			validation = ProductBasketAction.checkExistingBillingAccountIdField(logStream, driver, stepID, textExistingBillingAccountIdField);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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

	public static void fillExistingTechnicalContact(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String textExistingTechnicalContact) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Product Basket: Existing Technical Contact: "+textExistingTechnicalContact;

		String stepNameMin="fillExistingTechnicalContact";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.fillExistingTechnicalContact(logStream, driver, stepID, textExistingTechnicalContact);

			validation = ProductBasketAction.checkExistingTechnicalContact(logStream, driver, stepID, textExistingTechnicalContact);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
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

	public static void goToOrderEnrichment(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="ProductBasket: go To Order Enrichment";

		String stepNameMin="step";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.goToOrderEnrichmentConsole(logStream, driver, stepID);
			
			Thread.sleep(5000);
			
			OrderEnrichmentAction.changeToOrderEnrichmentiFrame(logStream, driver, stepID);

			OrderEnrichmentAction.selectProductForOEConfig(logStream, driver, stepID, productName);
			
			validation=OrderEnrichmentAction.tabsforOEValidation(logStream, driver, stepID);

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

	public static void fillNewBillingAccountAddress(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String product) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Product Basket: Fill New Billing Account Address";

		String stepNameMin="fillNewBillingAccountAddress";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;
		
		String newBillingAddress=ExcelDataFetch.searchDT(11, "newBillingAddress");

		try
		{
			ProductBasketAction.fillNewBillingAccountAddress(logStream, driver, stepID, newBillingAddress);
			
			ProductBasketAction.saveProductBasketChanges(logStream, driver, stepID);
			
			validation = ProductBasketAction.fillNewBillingAccountAddressValidation(logStream, driver, stepID, newBillingAddress);

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

	public static void fillNewBillingAccountAddressNegVal(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String newBillingAddress) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Product Basket: fill New Billing Account Address with Negative Validation";

		String stepNameMin="fillNewBillingAccountAddressNegVal";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.fillNewBillingAccountAddress(logStream, driver, stepID, newBillingAddress);
			
			ProductBasketAction.saveProductBasketChanges(logStream, driver, stepID);
			
			validation = ProductBasketAction.validationNewBillingAccountAddressNegVal(logStream, driver, stepID);

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

	public static void cancelProductBasketEdition(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Product Basket: cancel Product Basket Edition";

		String stepNameMin="cancelProductBasketEdition";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			ProductBasketAction.cancelProductBasketChanges(logStream, driver, stepID);

			validation = ProductBasketAction.validateProductBasketScreen(logStream, driver, stepID);

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

	
	public static void fillNewAndExistingBillingDetails(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);
		
		String stepName="Product Basket: fill New And Existing Billing Details";

		String stepNameMin="fillNewAndExistingBillingDetails";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		String existingBillingAccountIdField=ExcelDataFetch.searchDT(11, "existingBillingAccountIdField");
		
		String newBillingAddress=ExcelDataFetch.searchDT(11, "newBillingAddress");

		boolean validation;

		try
		{
			ProductBasketAction.fillNewBillingAccountAddress(logStream, driver, stepID, newBillingAddress);
			
			ProductBasketAction.fillExistingBillingAccountIdFieldNoSave(logStream, driver, stepID, existingBillingAccountIdField);

			ProductBasketAction.saveEditProductBasketChanges(logStream, driver, stepID);
			
			validation = ProductBasketAction.validationNewBillingAccountAddressNegVal(logStream, driver, stepID);

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
	



