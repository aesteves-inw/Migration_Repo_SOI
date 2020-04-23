package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import actions.BrowserActions;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import functionalActions.SFDS.ActsSalesHomePage;
import sfDirectSales.SalesForceCompany;

public class StpsSalesHomePage {
	
	
	// 14-03-2020: Example/Template for steps
				/*
				public static TestStepReportStructure step(WebDriver driver, int stepID, String testName) throws Exception
				{
					TestStepReportStructure step;


					String stepName="step";

					String stepNameMin="step";

					String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


					boolean validation;

					try
					{
						<FUNCTIONAL STEPS>
						
						<FUNCTIONAL STEPS>
						
						<FUNCTIONAL STEPS>

						validation = <FUNCTIONAL STEP FOR VALIDATION>

						if(validation==true)
						{
							ExecStructure.screenShotTaking(driver, testName, evidenceName);
							step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
							return step;
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
						step=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
						return step;
					}

				}

			*/
	
	
	
	
	// Navigation Steps
	public static TestStepReportStructure navigate2SpecificCompanyDetails(WebDriver driver, int stepID, String testName, String companyUS) throws Exception
	{
		TestStepReportStructure navigate2SpecificCompanyDetails;
		
		
		String stepName="Home Page: Navigate into Specific Company Details Page";
		
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

	public static TestStepReportStructure navigate2CompanyDetails(WebDriver driver, int stepID, String testName) throws Exception
	{
		
		TestStepReportStructure nav2ComDet;


		String stepName="Home Page: Navigate to Company Details (Test Data Company)";

		String stepNameMin="nav2ComDet";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		

		String companyURL = TestData.searchDT(0, "environmentITTQA").concat(TestData.searchDT(0, "accountView")).concat(TestData.tdCompanyID(testName)).concat("/view");

		try
		{

			driver.get(companyURL);

			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if (BrowserActions.isElementPresent(driver, SalesForceCompany.followBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.quickSaleOPTYBtn) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsHeader) && BrowserActions.isElementPresent(driver, SalesForceCompany.companyDetailsInfo))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				nav2ComDet=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return nav2ComDet;
			}
			else
			{
				throw new Exception("Test Failed on Step: "+stepID+" - Navigation to Company Details");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			ExecStructure.screenShotTaking(driver, testName, evidenceName);
			nav2ComDet=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return nav2ComDet;
		}


	}

	
	
	// Operational Steps
	public static TestStepReportStructure loginSFDS(WebDriver driver, String testName, int stepID, String userProfile) throws Exception
	{
		TestStepReportStructure loginSFDS;

		String stepName="Login in Salesforce (Direct Sales)";

		String stepNameMin="loginSFDS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;
			
		
		try
		{
			ActsSalesHomePage.login(driver, stepID, userProfile);
			
			validation=ActsSalesHomePage.loginValidation(driver, stepID);
			
			if (validation==true) 
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				loginSFDS=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
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

	
	






}


/*
TestStepReportStructure <stepNameMin>;


String stepName="Login in Partners Community";

String stepNameMin="loginSFPC";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);


throw new Exception (stepName+" - Failed in Step: "+stepID);
 */

