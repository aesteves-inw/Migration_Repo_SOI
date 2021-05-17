package productConfigurationCloudSense;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.ExecStructure;
import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ProfessionalInternet 
{
	//08-01-2021 - Methods to retrieve attributes for configuration of ProfessionalInternet.
	
	private static String getContractType(String[] configuration)
	{
		String ContractType=configuration[0];

		return ContractType;
	}
	
	private static String getContractDuration(String[] configuration)
	{
		String ContractDuration=configuration[1];

		return ContractDuration;
	}
	
	/*private static String getOCKID(String[] configuration)
	{
		String OCKID=configuration[2];

		return OCKID;
	}*/
	
	private static String getAccessTechnology(String[] configuration)
	{
		String OCKID=configuration[2];

		return OCKID;
	}
	
	/*private static String getOCKResult(String[] configuration)
	{
		String OCKResult=configuration[3];

		return OCKResult;
	}*/
	
	private static String getPhoneLineInstallationType(String[] configuration)
	{
		String PhoneLineInstallationType=configuration[3];

		return PhoneLineInstallationType;
	}
	
	private static String getPhoneLineConfiguration(String[] configuration)
	{
		String PhoneLineConfiguration=configuration[4];

		return PhoneLineConfiguration;
	}
	
	private static String getExistingPhoneLineID(String[] configuration)
	{
		String ExistingPhoneLineID=configuration[5];

		return ExistingPhoneLineID;
	}
	
	private static String getInternetSubscription(String[] configuration)
	{
		String InternetSubscription=configuration[6];

		return InternetSubscription;
	}
	
	private static String getWifiAccess(String[] configuration)
	{
		String WifiAccess=configuration[7];

		return WifiAccess;
	}
	
	
	
	
	
	
	// OVERALL CONFIGURATION OF PRODUCT
	public static void configurationOfProfessionalInternet(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="configurationOfProfessionalInternet";


		try
		{
			contractInformationFields(logStream, driver, stepID, configuration, testName);

			accessTechnology(logStream, driver, stepID, configuration);

			includedPhoneLineFields(logStream, driver, stepID, configuration, testName);
			
			Thread.sleep(2000);

			subscriptionSelectionFields(logStream, driver, stepID, configuration, testName);
			


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
		String actionName="Contract Information On Professional Internet";


		try
		{
			fieldContractType(logStream, driver, stepID, configuration);

			fieldRequestedInstallationDate(logStream, driver, stepID, configuration);

			fieldContractDuration(logStream, driver, stepID, configuration);

			fieldRemarks(logStream, driver, stepID, configuration, testName);
			
			
			if(getContractType(configuration).equalsIgnoreCase("new") == false)
			{
				fieldExistingConnectivity(logStream, driver, stepID, configuration, testName);
			}

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

		String actionName="PI Contract Type - Config: "+contractType;


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

		String actionName="PI Desired Installation Date - Config: "+dateToInput;


		try
		{
			WebElement inputRequestDate=new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:serviceRequestDate_0")));
			
			inputRequestDate.click();
			
			inputRequestDate.clear();
			
			inputRequestDate.sendKeys(dateToInput);
			
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fieldContractDuration(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String contractDuration = getContractDuration(configuration);

		String actionName="PI Contract Type - Config: "+contractDuration;


		try
		{
			Select comboContractType = new Select(driver.findElement(By.id("Details:Contract_Information:contractDuration_0")));

			comboContractType.selectByVisibleText(contractDuration);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fieldRemarks(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration,
			String testName) throws Exception 
	{
		String remarksText=TestCasesData.getOPTYName(testName);

		String actionName="PI Remarks - Config: "+remarksText;


		try
		{
			WebElement inputRemarks = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:remarks_0")));

			inputRemarks.click();
			
			inputRemarks.clear();

			inputRemarks.sendKeys(remarksText);
			
			inputRemarks.sendKeys(Keys.ENTER);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fieldExistingConnectivity(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) 
	{
		
		
	}

	private static void fieldInternalComments(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String remarksText=TestCasesData.getOPTYName(testName);

		String actionName="PI Internal Comments - Config: "+remarksText;


		try
		{
			WebElement inputInternalComments = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:internalComments_0")));

			inputInternalComments.click();
			
			inputInternalComments.clear();

			inputInternalComments.sendKeys(remarksText);
			
			inputInternalComments.sendKeys(Keys.ENTER);


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
	
	
	private static void accessTechnology(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String accessTechnology = getAccessTechnology(configuration);

		String actionName="PI Access Technology Field - Config: "+accessTechnology;


		try
		{
			driver.findElement(By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:accessTechnology_0\"]")).click();;

			switch(accessTechnology) {

			case "GPON":
				driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[1]")).click();
				break;
			case "VDSL2":
				driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[2]")).click();
				break;
			case "ADSL2+E":
				driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[3]")).click();
				break;
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

	/*private static void fieldOCKId(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String ockID = getOCKID(configuration);

		String actionName="PI OCK Id field - Config: "+ockID;


		try
		{
			WebElement inputOCKID = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Details:Installation_Address___OCK_Check:OCKID_0']")));

			inputOCKID.click();
			
			inputOCKID.clear();

			inputOCKID.sendKeys(ockID);
			
			//inputOCKID.sendKeys(Keys.ENTER);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}*/

	private static void fieldOCKResult(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String OCKResult = getOCKResult(configuration);

		String actionName="PI OCK Result Field - Config: "+OCKResult;


		try
		{
			Select comboContractType = new Select(driver.findElement(By.xpath("//select[@id='Details:Installation_Address___OCK_Check:OCK_Result_0']")));

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



	// INCLUDED PHONE LINE
	private static void includedPhoneLineFields(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="Included Phone Line on Professional Internet";

		String phoneLineInstallationType=getPhoneLineInstallationType(configuration);

		try
		{
			fieldPhoneLineInstallationType(logStream, driver, stepID, configuration);
			
			if(phoneLineInstallationType.equalsIgnoreCase("new"))
			{
				fieldPhoneLineConfiguration(logStream, driver, stepID, configuration);
			}
			else if(phoneLineInstallationType.equalsIgnoreCase("existing"))
			{
				fieldExistingPhoneLineID(logStream, driver, stepID, configuration);
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
	
	private static void fieldPhoneLineInstallationType(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String phoneLineInstallationType = getPhoneLineInstallationType(configuration);

		String actionName="PI Phone Line Installation Type - Config: "+phoneLineInstallationType;


		try
		{
			Select comboInternetInstallationType = new Select(driver.findElement(By.id("Details:Included_Phone_Line:installationType_0")));

			comboInternetInstallationType.selectByVisibleText(phoneLineInstallationType);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fieldPhoneLineConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String selectInternetSubscription = getPhoneLineConfiguration(configuration);

		String actionName="PI Phone Line Configuration - Config: "+selectInternetSubscription;


		try
		{
			WebElement selectBoxInternetSubscription = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_Details:Included_Phone_Line:phoneLineSelection_0")));
			
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

	private static void fieldExistingPhoneLineID(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String existingPhoneLineID = getExistingPhoneLineID(configuration);

		String actionName="PI Existing Phone Line ID - Config: "+existingPhoneLineID;


		try
		{
			WebElement inputExistingPhoneLineID = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Included_Phone_Line:phoneLineId_0")));

			inputExistingPhoneLineID.clear();

			inputExistingPhoneLineID.sendKeys(existingPhoneLineID);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}


	
	// SUBSCRIPTION SELECTION
	private static void subscriptionSelectionFields(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="Subscription Selection On Professional Internet";


		try
		{
			fieldInternetSubscription(logStream, driver, stepID, configuration);
			
			fieldWifiAccess(logStream, driver, stepID, configuration);
			

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}

	private static void fieldInternetSubscription(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String selectInternetSubscription = getInternetSubscription(configuration);

		String actionName="PI Internet Subscription - Config: "+selectInternetSubscription;


		try
		{
			WebElement selectBoxInternetSubscription = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_Details:Subscription_Selection:PriceItem_0")));
			
			BrowserActions.ScrollByElement(driver, "xpath", "//*[@id=\"s2id_Details:Installation_Address___OCK_Check:accessTechnology_0\"]");
			
			selectBoxInternetSubscription.click();
			
			Thread.sleep(3000);
			
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"select2-drop\"]")));
			
			WebElement internetSubscription = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='"+selectInternetSubscription+"']")));
			
			internetSubscription.click();
			
			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}
		
	}
	
	private static void fieldWifiAccess(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String wifiAccess = getWifiAccess(configuration);

		String actionName="PI Wi-Fi Access - Config: "+wifiAccess;
		
		try
		{
			if(wifiAccess.contains("y") || wifiAccess.contains("Y"))
			{
				WebElement wiFiCheckBox = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Subscription_Selection:WifiAccess_0")));
			
				WebElement checkBox = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(wiFiCheckBox.findElement(By.xpath("//span[@class='checkbox-style']"))));
			
				checkBox.click();
				
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
	
	
	
	// VALIDATION OF PROFESSIONAL INTERNET CONFIGURATION JOURNEY

	public static boolean validationOfPIConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{

		String actionName="Validation of Professional Internet configuration";

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

			if(i >= 5)
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
