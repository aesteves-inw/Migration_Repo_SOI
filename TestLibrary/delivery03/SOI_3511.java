package delivery03;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import agreementDirectSales.AgreementStep;
import companyDirectSales.CompanyStep;
import homePageDirectSales.HomePageStep;
import loginPageDirectSales.LoginPageStep;
import navigation.NavigationStep;
import objectMap.sfDirectSales.DirSalesProductBasket;
import objectMap.sfDirectSales.DirSalesService;
import opportunityDirectSales.OpportunityStep;
import orderDirectSales.OrderStep;
import productBasketDirectSales.ProductBasketStep;
import serviceDirectSales.ServiceStep;
import testFrameworkLibrary.D02Models;
import testFrameworkLibrary.D03Models;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.TestStepReportStructure;

public class SOI_3511 
{

	public static void SOI_3511_TC01_DS_SingleCaseRecordForQuotableAndNonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{
		String productName ="Voice Continuity";

		String configurationIndex="configurationByDefault";

		String nonQuotableProduct="PABX";

		String userProfile="salesUser";
		
		String provContactPerson="First User";

		String optyURL, orderURL, serviceURL, caseURL, caseURLLink;

		String productBasketName, serviceName;
		
		List<String> servicesURL=new ArrayList<String>();
		
		List<String> caseURLValidation=new ArrayList<String>();

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
			
			OrderStep.submitOrderPositiveValidation(testExecStructure, logStream, driver, testName);
			
			for(String sURL : servicesURL)
			{
				OrderStep.goToServiceScreenByURL(testExecStructure, logStream, driver, testName, sURL);
				
				ServiceStep.serviceCaseValidationAfterOrderSubmit(testExecStructure, logStream, driver, testName);
				
				caseURL=driver.findElement(By.xpath(DirSalesService.caseFieldOnServicePage)).getAttribute("href");
				
				caseURLValidation.add(caseURL);
					
				NavigationStep.goToOrderByURL(testExecStructure, logStream, driver, testName, orderURL);
				
				Thread.sleep(5000);
			}
			
			/*
			 * 10/02 - A part from E2E Flow Process of navigation to Case.
			caseURLLink=caseURLValidation.get(0);
			
			NavigationStep.goToCasePageByURL(testExecStructure, logStream, driver, testName, caseURLLink);
			*/
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}

	}

	public static void SOI_3511_TC02_PC_SingleCaseRecordForQuotableAndNonQuotable(
			List<TestStepReportStructure> testExecStructure, List<TestLog> logStream, WebDriver driver,
			String testName) throws Exception 
	{

		try
		{


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, testName, "Test Failed", e.toString());
			throw new Exception(testName+" - Test Case Failed");
		}
	}

}
