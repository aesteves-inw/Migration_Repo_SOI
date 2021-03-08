package testFrameworkLibrary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementStep;
import agreementPartCom.AgreementPCStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import productBasketDirectSales.ProductBasketStep;
import testDataFiles.TestDataFiles;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class D03Models 
{

	public static void E2FFlowForD03(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName) throws Exception 
	{
		String product = "PABX";
		
		String textExistingTechnicalContact ="First User";
		
		try
		{

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillExistingTechnicalContact(testExecStructure, logStream, driver, testName, textExistingTechnicalContact);
			
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, product);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
			
			AgreementStep.addFileToAgreement(testExecStructure, logStream, driver, testName);	
			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - E2FFlowForD03");
		}
		
	}

	public static void AddNonQuotableProductToProductBasket(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String product) throws Exception
	{
		String actionName="AddNonQuotableProductToProductBasket";
		
		try
		{
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, product);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Model: "+actionName, e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model: "+actionName);
		}
	}

	public static void E2EFlowUntilGoToOrder(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productD03, String productD02, String prodConfigD02) throws Exception
	{
		String optyURL, productBasketName;
		
		String textExistingTechnicalContact="First User";
		
		try
		{

			String userProfile="salesUser";

			LoginPageStep.loginSFDS(testExecStructure, logStream, driver, testName, userProfile);

			HomePageStep.navigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyStep.createQuickSaleOpportunity(testExecStructure, logStream, driver, testName);
			
			optyURL=driver.getCurrentUrl();

			OpportunityStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillExistingTechnicalContact(testExecStructure, logStream, driver, testName, textExistingTechnicalContact);
		
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productD03);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productD02, prodConfigD02);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);
			
			AgreementStep.addFileToAgreement(testExecStructure, logStream, driver, testName);
		
			//AgreementStep.generateDocumentProposal(testReportStream, logStream, driver, testName);
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);		
			
			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - E2EFlowUntilCloseWinOPTY");
		}
	}
	
	public static void E2EFlowUntilGoToOrderInPC(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productD03, String productD02, String prodConfigD02) throws Exception
	{
		String optyURL, productBasketName;
		
		String user="farmerUser";
		
		String textExistingTechnicalContact="First User";
		
		String filePath=TestDataFiles.fileNameD01;
				
		String fileName=TestDataFiles.fileFinalNameD01;
		
		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL=driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);
			
			//variable storage
			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");
			TestLogger.logDebug(logStream, "productBasketName", "productBasketName value: "+productBasketName);
			//end of variable storage
			
			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.fillExistingTechnicalContact(testExecStructure, logStream, driver, testName, textExistingTechnicalContact);
		
			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);
			
			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, productD03);
			
			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productD02, prodConfigD02);
			
			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);
			
			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);
			
			AgreementPCStep.addFileToAgreement(testExecStructure, logStream, driver, testName, filePath, fileName);
			
			//AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);
			
			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed on Pre Conditions Setup", e.toString());
			throw new Exception(testName+": Test Case Failed on Test Model - E2EFlowUntilCloseWinOPTY");
		}
	}

	
	
}
