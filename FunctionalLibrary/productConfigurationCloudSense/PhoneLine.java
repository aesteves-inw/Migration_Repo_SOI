package productConfigurationCloudSense;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.ExecStructure;
import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class PhoneLine {


	//07-01-2021 - Methods to retrieve attributes for configuration of Phone Line.
	static String getContractType(String[] configuration)
	{
		String contractType=configuration[0];

		return contractType;
	}

	static String getExistingLine(String[] configuration)
	{
		String existingLine=configuration[1];

		return existingLine;
	}

	static String getOCKID(String[] configuration)
	{
		String OCKID=configuration[2];

		return OCKID;
	}

	static String getOCKResult(String[] configuration)
	{
		String OCKResult=configuration[3];

		return OCKResult;
	}

	static String getInternetInstallationType(String[] configuration)
	{
		String InternetInstallationType=configuration[4];

		return InternetInstallationType;
	}

	static String getSelectInternetSubscription(String[] configuration)
	{
		String SelectInternetSubscription=configuration[5];

		return SelectInternetSubscription;
	}

	static String getExistingConnectivityID(String[] configuration)
	{
		String ExistingConnectivityID=configuration[6];

		return ExistingConnectivityID;
	}

	static String getTechnology(String[] configuration)
	{
		String Technology=configuration[7];

		return Technology;
	}



	// OVERALL CONFIGURATION OF PRODUCT
	public static void configurationOfPhoneLine(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration, String testName) throws Exception
	{
		String actionName="configurationOfPhoneLine";


		try
		{
			contractInformationFields(logStream, driver, stepID, configuration, testName);

			installationAddressOCKCheckFields(logStream, driver, stepID, configuration, testName);

			includedInternetFields(logStream, driver, stepID, configuration, testName);

			productSelectionFields(logStream, driver, stepID, configuration, testName);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	
	//CONTRACT INFORMATION
	private static void contractInformationFields(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="Contract Information On Phone Line";

		String contractType = getContractType(configuration);

		try
		{
			fieldRequestedInstallationDate(logStream, driver, stepID, configuration);
			
			
			if(contractType.equalsIgnoreCase("new"))
			{
				fieldContractType(logStream, driver, stepID, configuration);
			}
			else
			{
				fieldContractType(logStream, driver, stepID, configuration);
				
				fieldExistingLine(logStream, driver, stepID, configuration);
			}

			

			fieldRemarks(logStream, driver, stepID, configuration, testName);
			
			Thread.sleep(1000);

			fieldInternalComments(logStream, driver, stepID, configuration, testName);



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldContractType(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String contractType = getContractType(configuration);

		String actionName="PL Contract Type - Config: "+contractType;


		try
		{
			Select comboContractType = new Select(driver.findElement(By.id("Details:Contract_Information:contractType_0")));

			comboContractType.selectByVisibleText(contractType);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldRequestedInstallationDate(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String dateToInput=ExecStructure.tomorrowFormattedDate();
		
		String actionName="PL Desired Installation Date - Config: "+dateToInput;
		
		


		try
		{
			WebElement inputRequestdate = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:serviceRequestDate_0")));

			inputRequestdate.click();
			
			inputRequestdate.clear();
			
			inputRequestdate.sendKeys(dateToInput);	
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldExistingLine(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String existingLine=getExistingLine(configuration);

		String actionName="PL Existing Line - Config: "+existingLine;


		try
		{
			WebElement inputExistingLine = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:existingLine_0")));

			inputExistingLine.clear();

			inputExistingLine.sendKeys(existingLine);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldRemarks(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration, String testName) throws Exception 
	{
		String remarksText=TestCasesData.getOPTYName(testName);

		String actionName="PL Remarks - Config: "+remarksText;


		try
		{
			WebElement inputRemarks = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:remarks_0")));
			
			inputRemarks.click();
			
			inputRemarks.clear();

			inputRemarks.sendKeys(remarksText);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldInternalComments(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String remarksText=TestCasesData.getOPTYName(testName);

		String actionName="PL Internal Comments - Config: "+remarksText;


		try
		{
			WebElement inputInternalComments = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:internalComments_0")));

			inputInternalComments.click();
			
			inputInternalComments.clear();

			inputInternalComments.sendKeys(remarksText);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}


	// INSTALLATION ADDRESS & OCK CHECK
	private static void installationAddressOCKCheckFields(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="Installation Address & OCKCheck On Phone Line";


		try
		{
					
			fieldOCKId(logStream, driver, stepID, configuration);

			fieldOCKResult(logStream, driver, stepID, configuration);



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldOCKId(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String ockID = getOCKID(configuration);

		String actionName="PL OCK Id field - Config: "+ockID;


		try
		{
			WebElement inputOCKID = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Installation_Address___OCK_check:OCKID_0")));
			
			inputOCKID.click();
			
			inputOCKID.clear();

			inputOCKID.sendKeys(ockID);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldOCKResult(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String OCKResult = getOCKResult(configuration);

		String actionName="PL OCK Result Field - Config: "+OCKResult;


		try
		{
			Select comboContractType = new Select(driver.findElement(By.id("Details:Installation_Address___OCK_check:ockResult_0")));

			comboContractType.selectByVisibleText(OCKResult);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	
	// INCLUDED INTERNET
	private static void includedInternetFields(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="Included Internet On Phone Line";

		String internetInstallationType = getInternetInstallationType(configuration);

		try
		{			
			if(internetInstallationType.equalsIgnoreCase("existing"))
			{
				fieldInternetInstallationType(logStream, driver, stepID, configuration);
				
				fieldExistingConnectivityID(logStream, driver, stepID, configuration);
			}
			else if(internetInstallationType.equalsIgnoreCase("new"))
			{
				fieldInternetInstallationType(logStream, driver, stepID, configuration);
				
				fieldSelectInternetSubscription(logStream, driver, stepID, configuration);
			}


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldInternetInstallationType(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String internetInstallationType = getInternetInstallationType(configuration);

		String actionName="PL Internet Installation Type - Config: "+internetInstallationType;


		try
		{
			Select comboInternetInstallationType = new Select(driver.findElement(By.id("Details:Included_Internet:internet_Installation_Type_0")));

			comboInternetInstallationType.selectByVisibleText(internetInstallationType);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldSelectInternetSubscription(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String selectInternetSubscription = getSelectInternetSubscription(configuration);

		String actionName="PL Select Internet Subscription - Config: "+selectInternetSubscription;


		try
		{
			WebElement selectBoxInternetSubscription = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_Details:Included_Internet:internetSelection_0")));
			
			selectBoxInternetSubscription.click();
			
			WebElement listOfSubscriptionsInProductBasket = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='select2-results']/ul[1]")));
			
			listOfSubscriptionsInProductBasket.findElement(By.xpath("//div[@title="+selectInternetSubscription+"]")).click();
			
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldExistingConnectivityID(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String existingConnectivityID = getExistingConnectivityID(configuration);

		String actionName="PL Existing Connectivity ID - Config: "+existingConnectivityID;


		try
		{
			WebElement inputExistingConnectivityID = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Installation_Address___OCK_check:OCKID_0")));

			inputExistingConnectivityID.clear();

			inputExistingConnectivityID.sendKeys(existingConnectivityID);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	
	//PRODUCT SELECTION
	private static void productSelectionFields(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="Product Selection Fields On Phone Line";


		try
		{
			//fieldTechnology(logStream, driver, stepID, configuration);



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldTechnology(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String technology = getTechnology(configuration);

		String actionName="PL Technology - Config: "+technology;


		try
		{
			String technologyVal=driver.findElement(By.id("s2id_Details:Product_Selection:PriceItem_0")).getAttribute("value");
			
			System.out.println("Debug of technologyVal.contains(technology)"+technologyVal.contains(technology));
			
			if (technologyVal.contains(technology))
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
			}
			else
			{
				throw new Exception (actionName+" - Failed in Step "+stepID);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
	}

	
	
	// VALIDATION OF PHONE LINE CONFIGURATION JOURNEY
	
	public static boolean validationOfPLConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String actionName="Validation of Phone Line configuration (By Default Test Data)";
		
		int i=0;
		
		try
		{
			WebElement editProductConfigScreenVal = driver.findElement(By.xpath(DirSalesEditProductConfiguration.editProductScreenContainer));
			
			String editProductConfigScreenValText=editProductConfigScreenVal.getText().toString();
			
			
			for(String par:configuration)
			{
				if(editProductConfigScreenValText.contains(par))
				{
					++i;
				}
				
			}
			
			if(i >= 2)
			{
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step: "+stepID);
				return true;
			}
			else
			{
				return false;
			}
	
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step: "+stepID,e);
		}
	}





}
