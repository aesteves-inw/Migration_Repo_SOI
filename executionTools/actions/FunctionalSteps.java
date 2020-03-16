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
import functionalActions.SFDS.Case;
import functionalActions.SFDS.Opportunity;
import functionalActions.SFDS.Order;
import functionalActions.SFDS.Service;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceHomePage;
import sfDirectSales.SalesForceNewMACDOrderScreen;
import actions.BrowserActions;

	public class FunctionalSteps {

		
		// GENERAL FUNCTIONAL ACTIONS
		
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

				validation = Opportunity.opportunityScreenValidation(driver, stepID);

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

				validation = Order.orderPageValidation(driver, stepID);

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

				validation = Service.validationServicePage(driver, stepID);

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

				validation = Case.validationCasePage(driver, stepID);

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

	





