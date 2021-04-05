package delivery03;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import agreementDirectSales.AgreementStep;
import agreementPartCom.AgreementPCStep;
import companyDirectSales.CompanyStep;
import companyPartCom.CompanyPCStep;
import executionTools.BrowserActions;
import fetchDataFromExcelFiles.ExcelDataFetch;
import homePageDirectSales.HomePageStep;
import homePagePartCom.HomePagePCStep;
import loginPageDirectSales.LoginPageStep;
import loginPagePartCom.LoginPagePCStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import objectMap.sfDirectSales.DirSalesService;
import opportunityDirectSales.OpportunityStep;
import opportunityPartCom.OpportunityPCStep;
import orderDirectSales.OrderStep;
import orderPartCom.OrderPCStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceAction;
import serviceDirectSales.ServiceStep;
import servicePartCom.ServicePCAction;
import servicePartCom.ServicePCStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3568 
{

	public static void SOI_3568_TC01_DS_BillingAccountServiceLevel(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		String productName ="Phone Line";

		String configurationIndex="configurationByDefault";

		String nonQuotableProduct="PABX";

		String userProfile="salesUser";

		String provContactPerson="First User";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;

		List<String> servicesURL=new ArrayList<String>();



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

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, nonQuotableProduct);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.addFileToAgreement(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			// 14/01 - Workaround for Opportunity Page Refresh after Close Won and before going to OrderScreen

			Thread.sleep(10000);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			// 14/01 - End Of Workaround for Opportunity Page Refresh after Close Won and before going to OrderScreen 


			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			orderURL=driver.getCurrentUrl();

			List<WebElement> listOfServices=driver.findElements(By.xpath("//table/tbody/tr/td/span/lightning-formatted-url/a"));

			int counterServices;

			System.out.println("Debug of listOfServices: "+listOfServices.size());

			counterServices=listOfServices.size();

			for(int i=0;counterServices>i;i++)
			{

				serviceName=listOfServices.get(i).getText().toString();

				serviceURL=listOfServices.get(i).getAttribute("href");

				servicesURL.add(serviceURL);

				//System.out.println("Debug of serviceName: "+serviceName+" - URL: "+serviceURL);

				TestLogger.logDebug(logStream, "serviceName", "serviceName: "+serviceName+" - URL: "+serviceURL);

				//System.out.println("Debug of listOfServices: End of the loop: "+i);

			}

			for(String sURL : servicesURL)
			{
				OrderStep.goToServiceScreenByURL(testExecStructure, logStream, driver, testName, sURL);

				ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, provContactPerson);

				if(BrowserActions.isElementPresent(driver, DirSalesService.fieldContractType))
				{
					ServiceAction.fillContractTypeServiceLevel(logStream, driver, counterServices, "New");
				}

				NavigationStep.goToOrderByURL(testExecStructure, logStream, driver, testName, orderURL);

				Thread.sleep(5000);
			}

			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3568_TC02_DS_BillingAccountServiceLevel_Negative(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Phone Line";

		String configurationIndex="configurationByDefault";

		String nonQuotableProduct="PABX";

		String userProfile="salesUser";

		String provContactPerson="First User";

		String optyURL, orderURL, serviceURL;

		String productBasketName, serviceName;

		List<String> servicesURL=new ArrayList<String>();



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

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			D02Models.AddAndConfigureNewProduct(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, nonQuotableProduct);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreen(testExecStructure, logStream, driver, testName);

			AgreementStep.addFileToAgreement(testExecStructure, logStream, driver, testName);

			AgreementStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			// 14/01 - Workaround for Opportunity Page Refresh after Close Won and before going to OrderScreen

			Thread.sleep(10000);

			NavigationStep.goToOpportunityByURL(testExecStructure, logStream, driver, testName, optyURL);

			// 14/01 - End Of Workaround for Opportunity Page Refresh after Close Won and before going to OrderScreen 


			OpportunityStep.goToOrderScreen(testExecStructure, logStream, driver, testName, productBasketName);

			orderURL=driver.getCurrentUrl();

			List<WebElement> listOfServices=driver.findElements(By.xpath("//table/tbody/tr/td/span/lightning-formatted-url/a"));

			int counterServices;

			System.out.println("Debug of listOfServices: "+listOfServices.size());

			counterServices=listOfServices.size();

			for(int i=0;counterServices>i;i++)
			{

				serviceName=listOfServices.get(i).getText().toString();

				serviceURL=listOfServices.get(i).getAttribute("href");

				servicesURL.add(serviceURL);

				//System.out.println("Debug of serviceName: "+serviceName+" - URL: "+serviceURL);

				TestLogger.logDebug(logStream, "serviceName", "serviceName: "+serviceName+" - URL: "+serviceURL);

				//System.out.println("Debug of listOfServices: End of the loop: "+i);

			}

			for(String sURL : servicesURL)
			{
				OrderStep.goToServiceScreenByURL(testExecStructure, logStream, driver, testName, sURL);

				ServiceStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, provContactPerson);

				NavigationStep.goToOrderByURL(testExecStructure, logStream, driver, testName, orderURL);

				Thread.sleep(5000);
			}

			OrderStep.submitOrderNegativeValBillingAddress(testExecStructure, logStream, driver, testName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3568_TC03_PC_BillingAccountServiceLevel(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{

		String user="farmerUser";

		String productName="Phone Line";

		String configurationIndex="configurationByDefault";

		String productD03="PABX";

		String provContactPerson="First User";



		String optyURL, productBasketName, orderURL, serviceName, serviceURL, serviceID;

		List<String> servicesURL=new ArrayList<String>();



		int counterServices;

		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, productD03);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);

			AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			orderURL=driver.getCurrentUrl();

			List<WebElement> listOfServices = driver.findElements(By.xpath("//a[@title='Name']"));

			counterServices=listOfServices.size();

			for(int i=0;counterServices>i;i++)
			{

				serviceName=listOfServices.get(i).getText().toString();

				serviceID=listOfServices.get(i).getAttribute("data-recordid");

				serviceURL=ExcelDataFetch.searchDT(0, "PartnersCommunity")+"/"+serviceID;

				servicesURL.add(serviceURL);

				//System.out.println("Debug of serviceName: "+serviceName+" - URL: "+serviceURL);

				TestLogger.logDebug(logStream, "serviceName", "serviceName: "+serviceName+" - URL: "+serviceURL);

				//System.out.println("Debug of listOfServices: End of the loop: "+i);

			}

			for(String sURL : servicesURL)
			{
				OrderPCStep.goToServiceScreenByURL(testExecStructure, logStream, driver, testName, sURL);

				ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, provContactPerson);

				ServicePCStep.fillBillingAccountID(testExecStructure, logStream, driver, testName);

				if(BrowserActions.isElementPresent(driver, DirSalesService.fieldContractType))
				{
					ServicePCAction.fillContractTypeServiceLevel(logStream, driver, counterServices, "New");
				}

				NavigationStep.goToOrderByURLInPC(testExecStructure, logStream, driver, testName, orderURL);

				Thread.sleep(5000);
			}

			OrderPCStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName); 

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3568_TC04_PC_BillingAccountServiceLevel_Negative(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String user="farmerUser";

		String productName="Phone Line";

		String configurationIndex="configurationByDefault";

		String productD03="PABX";

		String provContactPerson="First User";



		String optyURL, productBasketName, orderURL, serviceName, serviceURL, serviceID;

		List<String> servicesURL=new ArrayList<String>();



		int counterServices;

		try
		{
			LoginPagePCStep.LoginPartnersCommunity(testExecStructure, logStream, driver, testName, user);

			HomePagePCStep.NavigateToCompanyPage(testExecStructure, logStream, driver, testName);

			CompanyPCStep.createQuickSaleOPTY(testExecStructure, logStream, driver, testName);

			optyURL = driver.getCurrentUrl();

			OpportunityPCStep.createProductBasket(testExecStructure, logStream, driver, testName);

			productBasketName=driver.findElement(By.xpath(DirSalesProductBasket.inputProductBasketName)).getAttribute("value");

			ProductBasketStep.fillExistingBillingAccountIdField(testExecStructure, logStream, driver, testName);

			D02Models.AddAndConfigureNewProductInPC(testExecStructure, logStream, driver, testName, productName, configurationIndex);

			D03Models.AddNonQuotableProductToProductBasket(testExecStructure, logStream, driver, testName, productD03);

			ProductBasketStep.syncProductBasket(testExecStructure, logStream, driver, testName);

			ProductBasketStep.goToAgreementScreenInPC(testExecStructure, logStream, driver, testName);

			AgreementPCStep.generateDocumentProposal(testExecStructure, logStream, driver, testName);

			NavigationStep.goToOpportunityByURLInPC(testExecStructure, logStream, driver, testName, optyURL);

			OpportunityStep.closeWinOPTY(testExecStructure, logStream, driver, testName);

			OpportunityPCStep.goToOrderScreenList(testExecStructure, logStream, driver, testName, productBasketName);

			orderURL=driver.getCurrentUrl();

			List<WebElement> listOfServices = driver.findElements(By.xpath("//a[@title='Name']"));

			counterServices=listOfServices.size();

			for(int i=0;counterServices>i;i++)
			{

				serviceName=listOfServices.get(i).getText().toString();

				serviceID=listOfServices.get(i).getAttribute("data-recordid");

				serviceURL=ExcelDataFetch.searchDT(0, "PartnersCommunity")+"/"+serviceID;

				servicesURL.add(serviceURL);

				//	System.out.println("Debug of serviceName: "+serviceName+" - URL: "+serviceURL);

				TestLogger.logDebug(logStream, "serviceName", "serviceName: "+serviceName+" - URL: "+serviceURL);

				//	System.out.println("Debug of listOfServices: End of the loop: "+i);

			}

			for(String sURL : servicesURL)
			{
				OrderPCStep.goToServiceScreenByURL(testExecStructure, logStream, driver, testName, sURL);

				ServicePCStep.fillProvisioningContactPerson(testExecStructure, logStream, driver, testName, provContactPerson);

				NavigationStep.goToOrderByURLInPC(testExecStructure, logStream, driver, testName, orderURL);

				Thread.sleep(5000);
			}

			OrderPCStep.submitOrderNegativeValBillingAddress(testExecStructure, logStream, driver, testName);


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}	
	}



}

