package actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import functionalActions.SFDS.ActsSalesAgreement;
import functionalActions.SFDS.ActsSalesCase;
import functionalActions.SFDS.ActsSalesCompany;
import functionalActions.SFDS.ActsSalesOpportunity;
import functionalActions.SFDS.ActsSalesOrder;
import functionalActions.SFDS.ActsSalesService;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceHomePage;
import sfDirectSales.SalesForceNewMACDOrderScreen;
import sfDirectSales.SalesForceOpportunity;
import actions.BrowserActions;

	public class FunctionalSteps {

		
		// GENERAL FUNCTIONAL ACTIONS
		
		// Navigation Steps
		public static TestStepReportStructure goToOpportunity(WebDriver driver, int stepID, String testName, String objectURL) throws Exception
		{
			TestStepReportStructure goToOpportunity;


			String stepName="General: Go To Opportunity";

			String stepNameMin="goToOpportunity";

			String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


			boolean validation;

			try
			{
				FunctionalActionsSFDS.goToByURL(driver, stepID, "Opportunity", objectURL);

				validation = ActsSalesOpportunity.opportunityScreenValidation(driver, stepID);

				if(validation==true)
				{
					ExecStructure.screenShotTaking(driver, testName, evidenceName);
					goToOpportunity=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
					return goToOpportunity;
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
				goToOpportunity=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return goToOpportunity;
			}

		}
		
		public static TestStepReportStructure goToOrder(WebDriver driver, int stepID, String testName, String objectURL) throws Exception
		{
			TestStepReportStructure goToOrder;


			String stepName="General: Go To Order";

			String stepNameMin="goToOrder";

			String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


			boolean validation;

			try
			{
				FunctionalActionsSFDS.goToByURL(driver, stepID, "Order", objectURL);

				validation = ActsSalesOrder.orderPageValidation(driver, stepID);

				if(validation==true)
				{
					ExecStructure.screenShotTaking(driver, testName, evidenceName);
					goToOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
					return goToOrder;
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
				goToOrder=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return goToOrder;
			}

		}
		
		public static TestStepReportStructure goToService(WebDriver driver, int stepID, String testName, String objectURL) throws Exception
		{
			TestStepReportStructure goToService;


			String stepName="General: Go To Service";

			String stepNameMin="goToService";

			String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


			boolean validation;

			try
			{
				FunctionalActionsSFDS.goToByURL(driver, stepID, "Service", objectURL);

				validation = ActsSalesService.validationServicePage(driver, stepID);

				if(validation==true)
				{
					ExecStructure.screenShotTaking(driver, testName, evidenceName);
					goToService=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
					return goToService;
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
				goToService=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return goToService;
			}

		}
		
		public static TestStepReportStructure goToCase(WebDriver driver, int stepID, String testName, String objectURL) throws Exception
		{
			TestStepReportStructure goToCase;


			String stepName="General: Go To Case";

			String stepNameMin="goToCase";

			String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


			boolean validation;

			try
			{
				FunctionalActionsSFDS.goToByURL(driver, stepID, "Case", objectURL);

				validation = ActsSalesCase.validationCasePage(driver, stepID);

				if(validation==true)
				{
					ExecStructure.screenShotTaking(driver, testName, evidenceName);
					goToCase=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('p', 'e'), ReportStructure.testReportFinalElement('p', 'a'), ReportStructure.testReportFinalElement('p', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
					return goToCase;
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
				goToCase=new TestStepReportStructure(stepID, stepName, ReportStructure.testReportFinalElement('f', 'e'), ReportStructure.testReportFinalElement('f', 'a'), ReportStructure.testReportFinalElement('f', 's'), ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), evidenceName);
				return goToCase;
			}

		}
		
		
		//Operational Steps
		// Opportunity Creation and closure
		public static TestStepReportStructure createAndCloseMobileOpportunity(WebDriver driver, WebDriverWait wait, String testName, int stepID, String testExecutionString) throws Exception
		{
			TestStepReportStructure step;


			String stepName="step";

			String stepNameMin="createAndCloseMobileOpportunity";

			String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		

			
			String optyName="OPTY_"+testExecutionString;

			String optyElement="//a[@title='"+optyName+"']";

			String linkAgreementName=SalesForceOpportunity.agreementsContainer.concat("//a[contains(.,'"+optyName+"')]");
			
			String optyURL;
			
			
			String file2Upload="SimpleOrdering_Dummy_File";
			

			boolean validation;

			try
			{
				ActsSalesCompany.createNewStandardOpportunity(driver, stepID);

				ActsSalesOpportunity.inputOpportunityValues(driver, testExecutionString, testName);

				driver.findElement(By.xpath(SalesForceOpportunity.nosSaveButton)).click();

				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

				ActsSalesOpportunity.addProductToOppie(driver, stepID, "mobileVoice");

				ActsSalesOpportunity.editProductConfiguration(driver, 1, stepID);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.optyTablePool)));
				
				optyURL=driver.findElement(By.xpath(optyElement)).getAttribute("href");
				
				driver.get(optyURL);

				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	

				ActsSalesOpportunity.findAgreementOnOPTY(driver, stepID);

				driver.get(driver.findElement(By.xpath(linkAgreementName)).getAttribute("href"));

				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

				FunctionalActionsSFDS.addFile2Agreement(driver, stepID, file2Upload);

				driver.findElement(By.xpath("//a[text()='"+optyName+"']")).click();
				
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);	

				//added the following statement to control the appearance on opportunitys page of element.
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceOpportunity.optyHeader)));

				ActsSalesOpportunity.closeWonOppie(driver, stepID);

				validation = ActsSalesOpportunity.validationClosedWonOpty(driver, stepID, optyName);

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
		
		// LEGACY
		
		
		// Salesforce Direct Sales
		public static TestStepReportStructure loginSalesForce(WebDriver driver, int stepID, String sFEnvironment, String testName) throws Exception
		{
			String loginUserName;
			String loginPassWord;

			try
			{
				if(sFEnvironment == "DS")
				{
					loginUserName = TestData.searchDT(0, "envUserNameITTQA");
					loginPassWord=TestData.searchDT(0, "envPasswordITTQA");
				}
				else if (sFEnvironment == "PC")
				{
					loginUserName = TestData.searchDT(1, "envUserNameITTQA");
					loginPassWord=TestData.searchDT(1, "envPasswordITTQA");
				}
				else
				{
					throw new Exception("Test Failed on Step"+stepID);
				}

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
					TestStepReportStructure loginStep = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Login in Salesforce with success", "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
					return loginStep;
				}
				else
				{
					throw new Exception("Test Failed on Step: "+stepID);
				}

			}
			catch(Exception e)
			{
				System.out.println(e);
				ExecStructure.screenShotTaking(driver, testName, stepID+"_LoginScreen");
				TestStepReportStructure loginStep = new TestStepReportStructure(stepID, "Login into Salesforce", "Login with success", "Not possible to validate Login Page", "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_LoginScreen");
				return loginStep;
			}
		}

		//27-Fev: Deprecated with the entering of SOI-150 on Simple Ordering Project
		public static TestStepReportStructure createNewMACDOrder(WebDriver driver, int stepID, String testName, String testExecutionString) throws IOException
		{
			WebDriverWait waitNewMACDOrder = new WebDriverWait(driver, 10);

			String orderName="Order_"+testExecutionString;

			String newOrderCreated="//*[contains(.,'"+orderName+"')]";

			try
			{
				driver.findElement(By.xpath(SalesForceCompany.newMACDOrderButton)).click();

				waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SalesForceNewMACDOrderScreen.headerNewMACDOrder)));

				driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).clear();

				driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.inputOrderName)).sendKeys(orderName);

				driver.findElement(By.xpath(SalesForceNewMACDOrderScreen.nmoSaveButton)).click();

				waitNewMACDOrder.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(orderName))).click();

				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

				if (BrowserActions.isElementPresent(driver, newOrderCreated))
				{
					ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
					TestStepReportStructure newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Passed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
					return newMACDOrder;
				}
				else
				{
					throw new Exception("Validation Failed on Step: "+stepID);

				}

			}
			catch(Exception e)
			{
				System.out.println(e);
				ExecStructure.screenShotTaking(driver, testName, stepID+"_NewMACDOrder");
				TestStepReportStructure newMACDOrder = new TestStepReportStructure(stepID, "New MACD Order created with success", "New Order validated with success", "Validated with success. Order: "+orderName, "Failed", ExecStructure.formattedDate("dd-MM-yyyy HH:mm:ss"), stepID+"_NewMACDOrder");
				return newMACDOrder;
			}
		}

		
		



		
		




	}

	





