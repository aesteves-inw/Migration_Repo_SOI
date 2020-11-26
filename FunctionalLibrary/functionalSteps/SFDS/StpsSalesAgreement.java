package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import actions.FunctionalActionsSFDS;
import executionTools.BrowserActions;
import executionTools.ExecStructure;
import functionalActions.SFDS.ActsSalesAgreement;
import sfDirectSales.SalesForceAgreement;
import sfDirectSales.SalesForceOpportunity;
import sfSikuli.SalesForceSikuli;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;

public class StpsSalesAgreement {
	
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
	
	
	
	//Operational Steps
	
	
	public static TestStepReportStructure addDiferentFile2Agreement(WebDriver driver, WebDriverWait wait, String testName, int stepID) throws Exception
	{
		TestStepReportStructure addDiferentFile2Agreement;


		String stepName="Agreement: Add Different File To Agreement";

		String stepNameMin="addDiferentFile2Agreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		String file2Upload="SimpleOrdering_Dummy_File_01";
		
		String agreementFileTestData=ExecStructure.workingDir+"\\testData\\"+file2Upload+".pdf";
		
		String filesLink;
		
		Screen screen = new Screen();

		try
		{
			WebElement filesLinkElement = driver.findElement(By.xpath("//article[contains(.,'Files')]//a[starts-with(.,'Files')]"));
			
			filesLink=filesLinkElement.getAttribute("href");
			
			driver.get(filesLink);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			driver.findElement(By.linkText("Add Files")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceAgreement.selectFilesScreen)));
			
			driver.findElement(By.xpath(SalesForceAgreement.uploadFilesSelectScreen)).click();
			
			screen.wait(SalesForceSikuli.uploadBarFilePathOpenCancel, 20);

			screen.find(SalesForceSikuli.filePath);

			screen.paste(agreementFileTestData);

			screen.click(SalesForceSikuli.openButton);

			screen.wait(SalesForceSikuli.uploadFilesDoneSalesforce, 20);

			screen.wait(SalesForceSikuli.doneButton, 20);

			screen.click(SalesForceSikuli.doneButton);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceAgreement.successMessage)));
			
			if(BrowserActions.isElementPresent(driver, SalesForceAgreement.successMessage) && driver.findElements(By.xpath("//span[contains(@title,'SimpleOrdering_Dummy_File')]")).size()>1)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				addDiferentFile2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return addDiferentFile2Agreement;
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
			addDiferentFile2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return addDiferentFile2Agreement;
		}
	}
	
	public static TestStepReportStructure addSameFile2Agreement(WebDriver driver, WebDriverWait wait, String testName, int stepID) throws Exception
	{
		TestStepReportStructure addSameFile2Agreement;


		String stepName="Agreement: Add already uploaded file to Agreement";

		String stepNameMin="addSameFile2Agreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		String filesLink;
		

		try
		{
			WebElement filesLinkElement = driver.findElement(By.xpath("//article[contains(.,'Files')]//a[starts-with(.,'Files')]"));
			
			filesLink=filesLinkElement.getAttribute("href");
			
			driver.get(filesLink);
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			driver.findElement(By.linkText("Add Files")).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceAgreement.selectFilesScreen)));
			
			driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div[4]/div/div/div[2]/div[2]/div/div[2]/div[1]/ul/li[1]/a/div/div[2]/div[2]")).click();
			
			driver.findElement(By.xpath("//button/span[starts-with(.,'Add')]")).click();
			
			
			if(BrowserActions.isElementPresent(driver, SalesForceAgreement.errorMessage) && driver.findElements(By.xpath("//span[contains(@title,'SimpleOrdering_Dummy_File')]")).size()>=1)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				addSameFile2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return addSameFile2Agreement;
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
			addSameFile2Agreement=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return addSameFile2Agreement;
		}
	}

	public static TestStepReportStructure editAgreement(WebDriver driver, WebDriverWait wait, String testName, int stepID, String testExecutionString) throws Exception
	{
		TestStepReportStructure editAgreement;


		String stepName="Agreement: Edit Agreement";

		String stepNameMin="editAgreement";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		boolean validation;

		try
		{
			ActsSalesAgreement.editAgreement(driver, wait, stepID, testExecutionString);
			
			validation=ActsSalesAgreement.validateAgreementAfterEdition(driver, wait, stepID, testExecutionString);
				
			if(validation == true)
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

