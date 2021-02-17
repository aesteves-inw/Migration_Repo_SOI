package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import agreementDirectSales.AgreementStep;
import agreementPartCom.AgreementPCStep;
import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import orderDirectSales.OrderStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3649 
{

	public static void SOI_3649_TC01_DS_LinkDocumentsFromAgreementToOrder_NonQuotable_ExternalFile(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String product = "PABX";
		
		String userProfile="salesUser";
		
		String fileName="SimpleOrdering_Dummy_File";
		
		
		String optyURL;

		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			//variable storage
			String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.addFileToAgreement(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			OrderStep.validateFileOnOrderRelatedMenu(testExecStructure, logStream, driver, testName, fileName);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
	}

	public static void SOI_3649_TC02_DS_LinkDocumentsFromAgreementToOrder_NonQuotableAndQuotable_ExternalFileAndAgreement(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		try
		{
			String product = "PABX";
			
			String userProfile="salesUser";
			
			String fileName="SimpleOrdering_Dummy_File";
			
			String productName="Phone Line";
			
			String configurationIndex="configurationByDefault";
			
			
			String optyURL;

			try
			{
				LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

				HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

				CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
				
				optyURL=driver.getCurrentUrl();

				OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
				
				//variable storage
				String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
				TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
				//end of variable storage
				
				D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

				D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

				AgreementStep.addFileAndGenerateFileToAgreement(testExecStructure, logStream, driver, testName);

				NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
				
				OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

				OrderStep.validateFileOnOrderRelatedMenu(testExecStructure, logStream, driver, testName, fileName);

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, testName, "Test Failed", e.toString());
				throw new Exception(testName+" - Test Case Failed");
			}



		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
	}

	public static void SOI_3649_TC03_PC_LinkDocumentsFromAgreementToOrder_NonQuotable_ExternalFile(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
			String product = "PABX";
			
			String fileName="SimpleOrdering_Dummy_File";
			
			String optyURL;
			
			try
			{

				String userProfile="salesUser";

				LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

				HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

				CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
				
				optyURL=driver.getCurrentUrl();

				OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
				
				//variable storage
				String productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
				TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
				//end of variable storage
				
				D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

				ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

				ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);
				
				AgreementPCStep.addFileToAgreement(testExecStructure, logStream, driver, testName);
				
				NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
				
				OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
				
				OrderPCStep.validateFileOnOrderRelatedMenu(testExecStructure, logStream, driver, testName, fileName);
				
				

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
	}

	public static void SOI_3649_TC04_PC_LinkDocumentsFromAgreementToOrder_NonQuotableAndQuotable_ExternalFileAndAgreement(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{
		String product = "PABX";
		
		String userProfile="salesUser";
		
		String fileName="SimpleOrdering_Dummy_File";
		
		String productName="Phone Line";
		
		String configurationIndex="configurationByDefault";
		
		
		String optyURL, productBasketName;
		
		try
		{
			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);
			
			AgreementPCStep.addFileAndGenerateFileToAgreement(testExecStructure, logStream, driver, testName);
			
			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.validateFileOnOrderRelatedMenu(testExecStructure, logStream, driver, testName, fileName);
			

	}
	catch(Exception e)
	{
		System.out.println(e);
		TestLogger.logError(logStream, testName, "Test Failed", e.toString());
		throw new Exception(testName+" - Test Case Failed");
	}
	}

	
}


