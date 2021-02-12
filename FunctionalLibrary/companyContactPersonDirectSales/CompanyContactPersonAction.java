package companyContactPersonDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.ExecStructure;
import fetchDataFromExcelFiles.ExcelDataFetch;
import objectMap.sfDirectSales.DirSalesCompanyContactPerson;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyContactPersonAction 
{

	// DirSalesCompanyContactPerson

	public static void createNewProvisioningContactPersonFromService(List<TestLog> logStream, WebDriver driver,
			int stepID) throws Exception 
	{
		String actionName="createNewProvisioningContactPersonFromService";


		try
		{
			inputFirstName(logStream, driver, stepID);

			inputLastName(logStream, driver, stepID);

			inputSelectCompany(logStream, driver, stepID);

			inputEmail(logStream, driver, stepID);

			Thread.sleep(1000);
			BrowserActions.verticalscrollByVisibleElement(driver, DirSalesCompanyContactPerson.selectDepartment);
			Thread.sleep(1000);

			selectDepartment(logStream, driver, stepID);

			selectTitle(logStream, driver, stepID);

			configureRole(logStream, driver, stepID);

			selectGender(logStream, driver, stepID);

			selectLanguage(logStream, driver, stepID);


			saveCompanyContactPersonConfiguration(logStream, driver, stepID);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}



	private static void inputFirstName(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="inputFirstName";


		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.inputFirstName)).sendKeys("Tomated Xripts");

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void inputLastName(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="inputLastName";

		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.inputLastName)).sendKeys("SOI "+ExecStructure.tomorrowFormattedDate("ddMMyyHHmmss"));

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void inputSelectCompany(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="inputSelectCompany";

		String companyName=ExcelDataFetch.searchDT(2, "testingCompanyD02Functional");


		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.inputSelectCompany)).sendKeys(companyName);

			WebElement company = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='"+companyName+"']")));

			company.click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void inputEmail(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="inputEmail";


		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.inputEmail)).clear();

			driver.findElement(By.xpath(DirSalesCompanyContactPerson.inputEmail)).sendKeys("soi.testing.crew@gmail.com");



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void selectDepartment(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="selectDepartment";


		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.selectDepartment)).click();

			WebElement department = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesCompanyContactPerson.optionDepartmentAdministration)));

			department.click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void selectTitle(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="selectTitle";


		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.selectTitle)).click();

			WebElement title = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesCompanyContactPerson.optionTitleAssistant)));

			title.click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void configureRole(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="configureRole";


		try
		{
			
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.roleDecisionMaker)).click();
			
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.buttonMoveSelectionToChosen)).click();
			
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void selectGender(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="selectGender";


		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.selectGender)).click();
			
			WebElement gender = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesCompanyContactPerson.optionGenderUnspecified)));

			gender.click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void selectLanguage(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="selectLanguage";


		try
		{
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.selectLanguage)).click();
			
			WebElement language = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesCompanyContactPerson.optionLanguageEnglish)));

			language.click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}


	private static void saveCompanyContactPersonConfiguration(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="saveCompanyContactPersonConfiguration";


		try
		{
			driver.findElement(By.xpath()).click();
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath()));


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

}
