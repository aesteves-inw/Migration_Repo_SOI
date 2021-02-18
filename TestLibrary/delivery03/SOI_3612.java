package delivery03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
import orderDirectSales.OrderStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import testDataFiles.TestDataFiles;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3612 
{

	public static void SOI_3612_TC01_DS_NonQuotable_UploadFles_OrderLevel(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		try
		{
			String product = "PABX";
			
			String userProfile="salesUser";
			
			String productName="Phone Line";
			
			String configurationIndex="configurationByDefault";
			
			
			String filePath=TestDataFiles.fileNameD01;
			
			String fileName=TestDataFiles.fileFinalNameD01;
			
			
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

				NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);
				
				OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);
				
				OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);
				
				OrderStep.addFileToOrder(testExecStructure, logStream, driver, testName, filePath, fileName);

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

	public static void SOI_3612_TC02_PC_NonQuotable_UploadFles_OrderLevel(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		
		String product = "PABX";
		
		String user="farmerUser";
		
		String filePath=TestDataFiles.fileNameD01;
		
		String fileName=TestDataFiles.fileFinalNameD01;
		
		String productName="Phone Line";
		
		String configurationIndex="configurationByDefault";
		
		
		String optyURL, productBasketName;
		
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
						
			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);
			
			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, product);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);
			
			AgreementPCStep.addFileAndGenerateFileToAgreement(testExecStructure, logStream, driver, testName, filePath, fileName);
			
			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);
			
			OpportunityPCStep.closeWinOpportunityInPC(testExecStructure, logStream, driver, testName);
			
			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);
			
			OrderPCStep.addFileToOrder(testExecStructure, logStream, driver, testName, filePath, fileName);
			

	}
	catch(Exception e)
	{
		System.out.println(e);
		TestLogger.logError(logStream, testName, "Test Failed", e.toString());
		throw new Exception(testName+" - Test Case Failed");
	}
		
	}

}
