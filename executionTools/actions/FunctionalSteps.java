package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import execReport.ReportStructure;
import execReport.TestStepReportStructure;
import execStructure.ExecStructure;
import execStructure.TestData;
import functionalActions.SFDS.Order;
import sfDirectSales.SalesForceCompany;
import sfDirectSales.SalesForceHomePage;
import sfDirectSales.SalesForceNewMACDOrderScreen;
import sfDirectSales.SalesForceOpportunity;
import sfDirectSales.SalesForceOrders;
import sfDirectSales.SalesForceProducts;
import actions.BrowserActions;

	public class FunctionalSteps {

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

		

		
		// Salesforce Partners Community
		
		



		
		




	}

	





