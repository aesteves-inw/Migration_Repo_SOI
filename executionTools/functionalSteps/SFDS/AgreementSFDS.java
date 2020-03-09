package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import actions.FunctionalActionsSFDS;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;

public class AgreementSFDS {
	
	
	// Navigation Steps
	public static TestStepReportStructure navigate2Opportunity(WebDriver driver, String testName, int stepID, String optyURL) throws Exception
	{
		TestStepReportStructure step;


		String stepName="Agreement: Navigate to Opportunity";

		String stepNameMin="navigate2Opportunity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		try
		{
			driver.get(optyURL);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	
			
			if(BrowserActions.isElementPresent(driver, SalesForceOpportunity.optyHeader) && BrowserActions.isElementPresent(driver, SalesForceOpportunity.productContainer))
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
	
	
	//Operational Steps
	public static TestStepReportStructure add1stFileToAgreement(WebDriver driver, String testName, int stepID, String file2Upload) throws Exception
	{
		TestStepReportStructure add1stFileToAgreement;
		

		String stepName="Agreement: Add First File to Agreement";

		String stepNameMin="add1stFileToAgreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		
		try
		{
			
			FunctionalActionsSFDS.addFile2Agreement(driver, stepID, file2Upload);
			
			WebElement file = driver.findElement(By.xpath(SalesForceAgreement.filesContainer.concat("//a[contains(.,'"+file2Upload+"')]")));
			
			if (file.isDisplayed())
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				add1stFileToAgreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return add1stFileToAgreement;
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
			add1stFileToAgreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return add1stFileToAgreement;
		}
	}

	public static TestStepReportStructure editAgreement(WebDriver driver, WebDriverWait wait, String testName, int stepID, String editAgreementName) throws Exception
	{
		TestStepReportStructure editAgreement;


		String stepName="Agreement: Edit Agreement";

		String stepNameMin="editAgreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		try
		{
			driver.findElement(By.xpath("//button[@name='Edit'][contains(.,'Edit')]")).click();
			
			driver.findElement(By.xpath("//input[@class=' input']")).clear();
			
			driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(editAgreementName);
			
			driver.findElement(By.xpath("//button[@title='Save']/span[contains(.,'Save')]")).click();
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@title='Save']/span[contains(.,'Save')]")));
			
			String editVal=driver.findElement(By.xpath("//lightning-formatted-text[@data-output-element-id='output-field']")).getAttribute("value");
				
			if(editVal.contains(editAgreementName))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				editAgreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return editAgreement;
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
			editAgreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return editAgreement;
		}
	}




}


/*
TestStepReportStructure step;


String stepName="Agreement: Navigate to Opportunity";

String stepNameMin="navigate2Opportunity";

String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

try
{
	
	if()
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
*/

