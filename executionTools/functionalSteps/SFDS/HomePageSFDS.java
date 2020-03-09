package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actions.BrowserActions;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceHomePage;

public class HomePageSFDS {
	
	public static TestStepReportStructure loginSFDS(WebDriver driver, String testName, int stepID, String user[]) throws Exception
	{
		TestStepReportStructure loginSFDS;

		String stepName="Login in Salesforce (Direct Sales)";

		String stepNameMin="loginSFDS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		String loginUserName=user[0];
		
		String loginPassWord=user[1];
		
		
		try
		{
			
			WebElement usernameBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.userName));
			WebElement passwordBox = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.passWord));
			WebElement loginBtn = driver.findElement(By.xpath(sfDirectSales.SalesForceLoginPage.loginbtn));

			if (usernameBox.isDisplayed() == true && passwordBox.isDisplayed() == true && loginBtn.isDisplayed() == true) {
				usernameBox.sendKeys(loginUserName);
				passwordBox.sendKeys(loginPassWord);
				loginBtn.click();
			} 
			else
			{
				throw new Exception("Test Failed on Step"+stepID);
			}

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if (BrowserActions.isElementPresent(driver, SalesForceHomePage.header) && BrowserActions.isElementPresent(driver, SalesForceHomePage.headerIcons)) 
			{
				ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
				loginSFDS = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
				return loginSFDS;
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
			loginSFDS=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return loginSFDS;
		}
	}
	
	public static TestStepReportStructure navigate2SpecificCompanyDetails(WebDriver driver, int stepID, String testName, String companyUS) throws Exception
	{
		TestStepReportStructure navigate2SpecificCompanyDetails;
		
		
		String stepName="Navigate into Specific Company Details Page";
		
		String stepNameMin="navigate2SpecificCompanyDetails";
		
		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		String companyURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "accountView")).concat(TestData.tdCompanyID(companyUS)).concat("/view");
		
		try
		{
			driver.get(companyURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if (BrowserActions.isElementPresent(driver, SalesForceCompany.followBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.quickSaleOPTYBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsHeader) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsInfo))
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


/*
TestStepReportStructure <stepNameMin>;


String stepName="Login in Partners Community";

String stepNameMin="loginSFPC";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);


throw new Exception (stepName+" - Failed in Step: "+stepID);
 */

