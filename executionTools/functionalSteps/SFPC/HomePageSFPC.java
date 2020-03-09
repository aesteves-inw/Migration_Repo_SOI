package functionalSteps.SFPC;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import actions.BrowserActions;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfPartnersCommunity.SFPC_Company;
import sfPartnersCommunity.SFPC_HomePage;
import sfPartnersCommunity.SFPC_LoginPage;

public class HomePageSFPC {
	
	public static TestStepReportStructure loginSFPC(WebDriver driver, int stepID, String testName) throws Exception
	{
		TestStepReportStructure loginSFPC;
		
		
		String stepName="Login in Partners Community";
		
		String stepNameMin="loginSFPC";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		
		
		
		
		String envURL=TestData.searchDT(1, "environmentITTQA");
	
		String username=TestData.searchDT(1, "envUserNameITTQA");
	
		String password=TestData.searchDT(1, "envPasswordITTQA");
	
		try
		{
			driver.get(envURL);
	
			driver.findElement(By.xpath(SFPC_LoginPage.inputUserame)).sendKeys(username);
	
			driver.findElement(By.xpath(SFPC_LoginPage.inputPassword)).sendKeys(password);
	
			driver.findElement(By.xpath(SFPC_LoginPage.loginButton)).click();
	
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
			if(BrowserActions.isElementPresent(driver, SFPC_HomePage.headerNavigationBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.quickCreateButton) && BrowserActions.isElementPresent(driver, SFPC_HomePage.inputSearchBar) && BrowserActions.isElementPresent(driver, SFPC_HomePage.dashboard))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				loginSFPC = new TestStepReportStructure(stepID, stepName, "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return loginSFPC;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
	
	
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			loginSFPC = new TestStepReportStructure(stepID, stepName, "Login with success", "Login in Salesforce with success", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return loginSFPC;
	
		}
	
	}

	public static TestStepReportStructure navigate2SpecificCompanyDetails(WebDriver driver, String testName, int stepID, String companyUS) throws Exception
	{
		TestStepReportStructure navigate2SpecificCompanyDetails;
		
		
		String stepName="Navigate into Specific Company Details Page";
		
		String stepNameMin="navigate2SpecificCompanyDetails";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		String companyURL=(TestData.searchDT(1, "environmentITTQA")).concat(TestData.searchDT(1, "CompanyDetails")).concat(TestData.tdCompanyID(companyUS));
		
		
		try
		{
			driver.get(companyURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SFPC_Company.buttonFollow) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonNewMACDOrder) && BrowserActions.isElementPresent(driver, SFPC_Company.buttonEdit) && BrowserActions.isElementPresent(driver, SFPC_Company.relListNewOPTYButton) && BrowserActions.isElementPresent(driver, SFPC_Company.relListAgreementsLink) && BrowserActions.isElementPresent(driver, SFPC_Company.companyDetails) && BrowserActions.isElementPresent(driver, SFPC_Company.headerCompany))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2SpecificCompanyDetails=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return navigate2SpecificCompanyDetails;
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			navigate2SpecificCompanyDetails=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return navigate2SpecificCompanyDetails;
	
		}
	}

}
