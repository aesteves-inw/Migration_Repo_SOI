package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementStep;
import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import opportunityDirectSales.OpportunityStep;
import orderDirectSales.OrderStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceStep;
import servicePartCom.ServicePCStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3513 
{

	public static void SOI_3513_TC01_DS_NonQuotable_ContractType_ServiceLevel(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{
		String orderURL;

		String productD03="PABX";

		String productD02="Phone Line";

		String prodConfigD02="configurationByDefault";
		
		String userProfile="salesUser";


		String contractType="New";
		
		String optyURL, productBasketName;
		
		String textExistingTechnicalContact="First User";

		try
		{
			D03Models.E2EFlowUntilGoToOrder(testExecStructure, logStream, driver, testName, productD03, productD02, prodConfigD02);  

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
			
			orderURL=driver.getCurrentUrl();

			OrderStep.submitOrderNegativeValContractType(testExecStructure, logStream, driver, testName);

			OrderStep.goToServiceScreen(testExecStructure, logStream, driver, testName, productD03);

			ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, contractType);

			NavigationStep.goToOrderByURL(testExecStructure, logStream, driver, testName, orderURL);

			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);			

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3513_TC02_PC_NonQuotable_ContractType_ServiceLevel(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception
	{

		String orderURL;

		String productD03="PABX";

		String productD02="Phone Line";

		String prodConfigD02="configurationByDefault";


		String contractType="New";


		try
		{
			
			D03Models.E2EFlowUntilGoToOrderInPC(testExecStructure, logStream, driver, testName, productD03, productD02, prodConfigD02);           

			orderURL=driver.getCurrentUrl();

			OrderPCStep.submitOrderNegativeValContractType(testExecStructure, logStream, driver, testName);
			
			OrderPCStep.goToServiceScreenByServiceName(testExecStructure, logStream, driver, testName, productD03);
			
			ServicePCStep.fillContractType(testExecStructure, logStream, driver, testName, contractType);
			
			NavigationStep.goToOrderByURLInPC(testExecStructure, logStream, driver, testName, orderURL);

			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			/*
			
			ServiceStep.fillContractType(testExecStructure, logStream, driver, testName, contractType);

			NavigationStep.goToOrderByURL(testExecStructure, logStream, driver, testName, orderURL);

			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);			
			*/

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}



}
