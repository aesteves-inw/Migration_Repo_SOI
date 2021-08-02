package delivery03;

import java.util.List;

import org.openqa.selenium.WebDriver;

import addOfferToBasketDirectSales.AddOfferToBasketStep;
import agreementDirectSales.AgreementStep;
import agreementPartCom.AgreementPCStep;
import productBasketDirectSales.ProductBasketStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3507 
{

	public static void SOI_3507_TC01_DS_NonQuotableProductsIgnoredFromAgreement(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String product="PABX";

		String productName="Voice Continuity";

		String configurationIndex="configurationByDefault";

		try
		{	

			D02Models.ToHaveAProductBasket(testExecStructure, logStream, driver, testName);

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			AgreementStep.validateProposalForNonQuotableProducts(testExecStructure, logStream, driver, testName, product);	

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3507_TC02_PC_NonQuotableProductsIgnoredFromAgreement(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String product="PABX";

		String productName="Voice Continuity";

		String configurationIndex="configurationByDefault";
		
		try
		{
			
			D02Models.ToHaveAProductBasketInPC(testExecStructure, logStream, driver, testName);

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			ProductBasketStep.goToAddOferToBasketScreen(testExecStructure, logStream, driver, testName);

			AddOfferToBasketStep.addProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);

			AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			AgreementPCStep.validateProposalForNonQuotableProductsInPC(testExecStructure, logStream, driver, testName, product,"EN");


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}



}
