package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import functionalActions.SFDS.Order;
import sfDirectSales.SalesForceService;
import sfDirectSales.SalesforceCase;

public class ServiceSFDS {
	
	//Navigation Steps
	public static TestStepReportStructure navigate2CaseScreen(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure navigate2CaseScreen;


		String stepName="Service: Navigate to Case Screen";

		String stepNameMin="navigate2CaseScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			String caseLink=driver.findElement(By.xpath(SalesForceService.caseLink)).getAttribute("href");
			
			driver.get(caseLink);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesforceCase.keyDetailsArticle) && BrowserActions.isElementPresent(driver, SalesforceCase.filesContainer))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2CaseScreen=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return navigate2CaseScreen;
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
			navigate2CaseScreen=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return navigate2CaseScreen;
		}
	}

	public static TestStepReportStructure navigate2OrderScreen(WebDriver driver, WebDriverWait wait, String testName, int stepID, String orderURL) throws Exception
	{
		TestStepReportStructure navigate2OrderScreen;


		String stepName="Service: Navigate to Order Screen";

		String stepNameMin="navigate2OrderScreen";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;

		try
		{
			driver.get(orderURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
			
			validation=Order.orderPageValidation(driver, wait, stepID);
			
			if(validation==true)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2OrderScreen=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return navigate2OrderScreen;
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
			navigate2OrderScreen=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return navigate2OrderScreen;
		}
	}

	
	
	//Operational Steps
	public static TestStepReportStructure serviceStatusValidation(WebDriver driver, String testName, int stepID, String status) throws Exception
	{
		TestStepReportStructure serviceStatusValidation;


		String stepName="Service: Status Validation";

		String stepNameMin="serviceStatusValidation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		try
		{
			String serviceStatus=driver.findElement(By.xpath(SalesForceService.serviceStatus)).getText();
			
			if(serviceStatus==status)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				serviceStatusValidation=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return serviceStatusValidation;
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
			serviceStatusValidation=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return serviceStatusValidation;
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