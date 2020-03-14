package functionalSteps.SFDS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.BrowserActions;
import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import sfDirectSales.SalesForceService;
import sfDirectSales.SalesforceCase;

public class CaseSFDS {

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
	public static TestStepReportStructure navigate2OpenCase(WebDriver driver, String testName, int stepID) throws Exception
	{

		TestStepReportStructure navigate2OpenCase;


		String stepName="Case: Navigate into an Open Case";

		String stepNameMin="navigate2OpenCase";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);


		try
		{
			driver.findElement(By.xpath(SalesforceCase.firstTableCaseLink)).click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			if(BrowserActions.isElementPresent(driver, SalesforceCase.keyDetailsArticle) && BrowserActions.isElementPresent(driver, SalesforceCase.filesContainer))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2OpenCase=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return navigate2OpenCase;
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
			navigate2OpenCase=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return navigate2OpenCase;
		}
	}

	public static TestStepReportStructure navigate2Service(WebDriver driver, String testName, int stepID) throws Exception
	{
		
		TestStepReportStructure navigate2Service;


		String stepName="Case: Navigate to Service Screen";

		String stepNameMin="navigate2Service";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		
		try
		{
			Actions action = new Actions(driver);
			
			WebElement serviceLink=driver.findElement(By.xpath(SalesforceCase.servicelinkRelatedMenu));
			
			action.moveToElement(serviceLink).build().perform();
			
			serviceLink.click();
			
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			
			if(BrowserActions.isElementPresent(driver, SalesForceService.filesContainer) && BrowserActions.isElementPresent(driver, SalesForceService.headerServicesPage) && BrowserActions.isElementPresent(driver, SalesForceService.detailsServicePage)  &&  BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceName)  && BrowserActions.isElementPresent(driver, SalesForceService.fieldCase) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDomain) && BrowserActions.isElementPresent(driver, SalesForceService.fieldType) && BrowserActions.isElementPresent(driver, SalesForceService.fieldDetail) && BrowserActions.isElementPresent(driver, SalesForceService.fieldServiceRequestDate) && BrowserActions.isElementPresent(driver, SalesForceService.fieldEnd2EndRequestOwner) && BrowserActions.isElementPresent(driver, SalesForceService.fieldStatus))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				navigate2Service=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return navigate2Service;
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
			navigate2Service=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return navigate2Service;
		}
	}

	
	// Operational Steps
	public static TestStepReportStructure changeCaseStatus(WebDriver driver, String testName, int stepID, String status) throws Exception
	{
		
		TestStepReportStructure changeCaseStatus;


		String stepName="Change Case Status to: "+status;

		String stepNameMin="changeCaseStatus";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		
		WebDriverWait waitChangeCaseStatus=new WebDriverWait(driver, 20);
		
		
		
		try
		{
			waitChangeCaseStatus.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(SalesforceCase.keyDetailsArticle), "Status"));
			
			String initialCaseState=driver.findElement(By.xpath(SalesforceCase.caseStatusLabel)).getText();
					
			// =============== Editing Case to Change Status ================
			
			driver.findElement(By.xpath(SalesforceCase.editCaseBtn)).click();
			
			waitChangeCaseStatus.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesforceCase.editHeaderWindow)));
			
			driver.findElement(By.xpath(SalesforceCase.statusComboBox)).click();
			
			driver.findElement(By.xpath("//lightning-base-combobox-item[contains(.,'"+status+"')]")).click();
			
			driver.findElement(By.xpath(SalesforceCase.saveBtn)).click();
			
			waitChangeCaseStatus.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SalesforceCase.editHeaderWindow)));
			
			//===============================================================
			
			String finalCaseState=driver.findElement(By.xpath(SalesforceCase.caseStatusLabel)).getText();
			
			if(initialCaseState != finalCaseState)
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				changeCaseStatus=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return changeCaseStatus;
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
			changeCaseStatus=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return changeCaseStatus;
		}
	}

	public static TestStepReportStructure caseValidationBySOI880(WebDriver driver, String testName, int stepID) throws Exception
	{
		TestStepReportStructure caseValidationBySOI880;


		String stepName="Case's Page Validation according with SOI-880";

		String stepNameMin="caseValidationBySOI880";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);
		
		WebDriverWait waitcaseValidationBySOI880=new WebDriverWait(driver, 15);
		
		try
		{
			
			
			waitcaseValidationBySOI880.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(SalesforceCase.keyDetailsArticle), TestData.tdCompanyName(testName)));
			
			String caseStatus=driver.findElement(By.xpath(SalesforceCase.caseStatusLabel)).getText();
			String caseOwner=driver.findElement(By.xpath(SalesforceCase.caseOwnerFieldLabel)).getText();
			
			System.out.println("caseValidationBySOI880 Debug 01: "+caseStatus.toLowerCase().contains("open"));
			System.out.println("caseOwner Debug 02: "+caseOwner.isEmpty());
			
			if(caseStatus.toLowerCase().contains("open") && (caseOwner.isEmpty()==false))
			{
				ExecStructure.screenShotTaking(driver, testName, evidenceName);
				caseValidationBySOI880=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return caseValidationBySOI880;
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
			caseValidationBySOI880=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
			return caseValidationBySOI880;
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