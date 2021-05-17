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

public class EnterpriseVoice {

	//03-05-2021 - Methods to retrieve attributes for configuration of Enterprise Voice.

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

	private static String getAccessTechnology(String[] configuration)
	{
		String OCKID=configuration[2];

		return OCKID;
	}

	private static String getDataServiceType(String[] configuration)
	{
		String OCKResult=configuration[3];

		return OCKResult;
	}

	private static String getDataServiceStatus(String[] configuration)
	{
		String getDataServiceStatus=configuration[4];

		return getDataServiceStatus;
	}

	private static String getPBXConnectivityType(String[] configuration)
	{
		String getPBXConnectivityType=configuration[5];

		return getPBXConnectivityType;
	}

	private static String getVoiceChannels(String[] configuration)
	{
		String getVoiceChannels=configuration[6];

		return getVoiceChannels;
	}
	
	private static String getProductSelection(String[] configuration)
	{
		String getProductSelection=configuration[7];

		return getProductSelection;
	}
	
	private static String getQuantity(String[] configuration)
	{
		String getQuantity=configuration[8];

		return getQuantity;
	}






	// OVERALL CONFIGURATION OF PRODUCT
	public static void configurationOfEnterpriseVoice(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="configurationOfEnterpriseVoice";


		try
		{
			contractInformationFields(logStream, driver, stepID, configuration, testName);

			accessTechnology(logStream, driver, stepID, configuration);

			dataServiceTypeField(logStream, driver, stepID, configuration, testName);

			fieldDataServiceStatus(logStream, driver, stepID, configuration);
			
			PBXConnectivityTypeField(logStream, driver, stepID, configuration);
			
			numberChannelsField(logStream, driver, stepID, configuration);
			
			numberRangesField(logStream, driver, stepID, configuration);



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
		String actionName="Contract Information On Enterprise Voice";


		try
		{
			fieldContractType(logStream, driver, stepID, configuration);

			fieldRequestedInstallationDate(logStream, driver, stepID, configuration);

			fieldContractDuration(logStream, driver, stepID, configuration);

			fieldRemarks(logStream, driver, stepID, configuration, testName);


			if(getContractType(configuration).equalsIgnoreCase("new") == false)
			{
				driver.findElement(By.xpath("//*[@id=\"Details:Contract_Information:EVlineReference_0\"]")).sendKeys("909090");
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

		String actionName="EV Contract Type - Config: "+contractType;


		try
		{

			Select comboContractType = new Select(driver.findElement(By.id("Details:Contract_Information:implementationType_0")));

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

		String actionName="EV Desired Installation Date - Config: "+dateToInput;


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

		String actionName="EV Contract Type - Config: "+contractDuration;


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

		String actionName="EV Remarks - Config: "+remarksText;


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

	private static void fieldInternalComments(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String remarksText=TestCasesData.getOPTYName(testName);

		String actionName="EV Internal Comments - Config: "+remarksText;


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
	

	private static void fieldDataServiceStatus(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String dataServiceStatus = getDataServiceStatus(configuration);

		String dataServiceType = getDataServiceType(configuration);

		String actionName="EV Data Service Status field - Config: "+dataServiceStatus;




		try
		{
			BrowserActions.ScrollByElement(driver, "xpath", "//*[@id=\"Details:Enterprise_Voice_Configuration:dataServiceStatus_0\"]");

			if(dataServiceType.contains("High End Internet") || dataServiceType.contains("Low End Internet (BBOX)")) {
				Select comboContractType = new Select(driver.findElement(By.xpath("//*[@id=\"Details:Enterprise_Voice_Configuration:dataServiceStatus_0\"]")));

				comboContractType.selectByVisibleText(dataServiceStatus);

				Thread.sleep(3000);

				switch(dataServiceStatus) {
				case "New":
					driver.findElement(By.xpath("//*[@id=\"s2id_Details:Enterprise_Voice_Configuration:DataServiceSelection_0\"]")).click();
					driver.findElement(By.xpath("//*[@id=\"select2-results-6\"]/li")).click();
					break;
				case "Existing":
					driver.findElement(By.xpath("//*[@id=\"Details:Enterprise_Voice_Configuration:lineReference_0\"]")).sendKeys("123456789");
					break;
				}

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

	

	private static void accessTechnology(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String accessTechnology = getAccessTechnology(configuration);

		String actionName="EV Access Technology Field - Config: "+accessTechnology;


		try
		{
			driver.findElement(By.xpath("//*[@id=\"s2id_Details:Installation_Address___OCK_Check:accessTechnology_0\"]")).click();;

			switch(accessTechnology) {

			case "GPON":
				driver.findElement(By.xpath("//div[contains(text(),'GPON')]")).click();
				break;

			case "VDSL2":
				driver.findElement(By.xpath("//div[contains(text(),'VDSL2')]")).click();
				break;

			case "ADSL+E":
				driver.findElement(By.xpath("//div[contains(text(),'ADSL2+E')]")).click();
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

	private static void dataServiceTypeField(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="Data Service Type for Enterprise Voice";

		try
		{
			fieldDataServiceType(logStream, driver, stepID, configuration);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}


	}

	private static void fieldDataServiceType(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String dataServiceType = getDataServiceType(configuration);

		String actionName="EV Data Service Type - Config: "+dataServiceType;


		try
		{
			BrowserActions.ScrollByElement(driver, "xpath", "//*[@id=\"s2id_Details:Enterprise_Voice_Configuration:DataServices_0\"]");

			driver.findElement(By.id("s2id_Details:Enterprise_Voice_Configuration:DataServices_0")).click();

			Thread.sleep(3000);

			switch(dataServiceType) {

			case "Voice Only":
				driver.findElement(By.xpath("//*[@id=\"select2-results-4\"]/li[4]")).click();
				break;
			case "Explore":
				driver.findElement(By.xpath("//*[@id=\"select2-results-4\"]/li[1]")).click();
				break;
			case "High End Internet":
				driver.findElement(By.xpath("//*[@id=\"select2-results-4\"]/li[2]")).click();
				break;
			case "Low End Internet (BBOX)":
				driver.findElement(By.xpath("//*[@id=\"select2-results-4\"]/li[3]")).click();
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

	private static void PBXConnectivityTypeField(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String PBXConnectivityTypeField = getPBXConnectivityType(configuration);

		String actionName="EV PBX Connectivity Type - Config: "+PBXConnectivityTypeField;

		try
		{
			WebElement selectBoxPBXConnectivity = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_Details:Enterprise_Voice_Configuration:PBX_0")));

			selectBoxPBXConnectivity.click();
			
			Thread.sleep(3000);

			switch(PBXConnectivityTypeField) {

			case "Bizz IP Box ISDNoIP-2":
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[1]")).click();
				break;
			case "Bizz IP Box ISDNoIP-30":
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[2]")).click();
				break;
			case "Bizz IP Box Other IPBX":
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[3]")).click();
				break;
			case "FORUM 500 IP":
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[4]")).click();
				break;
			case "Forum 5000":
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[5]")).click();
				break;
			case "Forum 700 IP":
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[6]")).click();
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
	
	private static void numberChannelsField(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String numberChannels = getVoiceChannels(configuration);

		String actionName="EV Number of Channels - Config: "+numberChannels;

		try
		{
			WebElement numberChannelsField = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"s2id_Details:Enterprise_Voice_Configuration:NumberChannels_0\"]")));

			numberChannelsField.click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@title=\""+numberChannels+"\"]")).click();

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}
	
	private static void numberRangesField(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String productSelection = getProductSelection(configuration);
		
		String Quantity = getQuantity(configuration);

		String actionName="EV Number Ranges - Config";

		try
		{
			BrowserActions.ScrollByElement(driver, "xpath", "//*[@id=\"configurationContainer\"]/div/div/div[2]/div[7]/article/div/div/button");
			
			WebElement newNumberRanges = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"configurationContainer\"]/div/div/div[2]/div[7]/article/div/div/button")));
					
			newNumberRanges.click();
			
			WebElement productSelectionField = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NumberRanges_0:productSelection_0\"]")));

			productSelectionField.click();
			
			Thread.sleep(3000);
			
			switch(productSelection) {
			case "VoIP Individual number":
				driver.findElement(By.xpath("//*[@id=\"NumberRanges_0:productSelection_0\"]/option[2]")).click();
				break;
			case "VoIP Range of 10 numbers":
				driver.findElement(By.xpath("//*[@id=\"NumberRanges_0:productSelection_0\"]/option[3]")).click();
				break;
			case "VoIP Range of 100 numbers":
				driver.findElement(By.xpath("//*[@id=\"NumberRanges_0:productSelection_0\"]/option[4]")).click();
				break;
			case "VoIP Range of 1000 numbers":
				driver.findElement(By.xpath("//*[@id=\"NumberRanges_0:productSelection_0\"]/option[5]")).click();
				break;
			
			}
			
			WebElement QuantityField = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"NumberRanges_0:Quantity_0\"]")));
			
			QuantityField.sendKeys(Quantity);
			
			

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

	public static boolean validationOfEVConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{

		String actionName="Validation of Enterprise Voice configuration";

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
