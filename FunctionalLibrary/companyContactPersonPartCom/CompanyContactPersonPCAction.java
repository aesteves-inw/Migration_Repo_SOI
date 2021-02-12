package companyContactPersonPartCom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import companyContactPersonDirectSales.CompanyContactPersonAction;
import objectMap.sfDirectSales.DirSalesCompanyContactPerson;
import objectMap.sfPartnersCommunity.PartComCompanyContactPerson;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class CompanyContactPersonPCAction {

	public static void fillNewProvisioningContactPerson(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="fillNewProvisioningContactPerson";


		try
		{
			CompanyContactPersonAction.inputFirstName(logStream, driver, stepID);
			
			CompanyContactPersonAction.inputLastName(logStream, driver, stepID);
			
			CompanyContactPersonAction.inputEmail(logStream, driver, stepID);
			
			CompanyContactPersonAction.inputSelectCompany(logStream, driver, stepID);
			
			selectDepartment(logStream, driver, stepID);
			
			selectTitle(logStream, driver, stepID);
			
			saveNewContactPerson(logStream, driver, stepID);
			
			configureRole(logStream, driver, stepID);
			
			selectGender(logStream, driver, stepID);
			
			selectLanguage(logStream, driver, stepID);

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
			driver.findElement(By.xpath(PartComCompanyContactPerson.selectDepartment)).click();

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
			driver.findElement(By.xpath(PartComCompanyContactPerson.selectTitle)).click();

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
			driver.findElement(By.xpath(PartComCompanyContactPerson.selectGender)).click();
			
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
			driver.findElement(By.xpath(PartComCompanyContactPerson.selectLanguage)).click();
			
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

	private static void saveNewContactPerson(List<TestLog> logStream, WebDriver driver, int stepID) throws Exception 
	{
		String actionName="saveNewContactPerson";


		try
		{
			
			driver.findElement(By.xpath(DirSalesCompanyContactPerson.buttonSave)).click();
			
			new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DirSalesCompanyContactPerson.buttonSave)));

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
