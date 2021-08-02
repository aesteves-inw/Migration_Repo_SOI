package productConfigurationCloudSense;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import editProductConfigurationScreenDirectSales.EProdConfigAction;
import executionTools.BrowserActions;
import executionTools.ExecStructure;
import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import testExecutionData.TestCasesData;
import testLogBuilder.TestLog;
import testLogger.TestLogger;

public class ECS_FullFiberExtended {

	//07-07-2021 - Methods to retrieve attributes for configuration of ECS FullFiberExtended.

	private static String getContractType(String[] configuration)
	{
		String ContractType=configuration[0];

		return ContractType;
	}

	private static String getInstallationType(String[] configuration)
	{
		String InstallationType=configuration[1];

		return InstallationType;
	}

	private static String getAccessTechnology(String[] configuration)
	{
		String AccessTechnology=configuration[2];

		return AccessTechnology;
	}

	private static String getWifiAccess(String[] configuration)
	{
		String WifiAccess=configuration[3];

		return WifiAccess;
	}

	private static String getImplementationType(String[] configuration)
	{
		String ImplementationType=configuration[0];

		return ImplementationType;
	}

	private static String getConnectivityType(String[] configuration)
	{
		String ImplementationType=configuration[1];

		return ImplementationType;
	}

	private static String getVoiceChannels(String[] configuration)
	{
		String VoiceChannels=configuration[2];

		return VoiceChannels;
	}

	private static String getProductSelection(String[] configuration)
	{
		String ProductSelection=configuration[3];

		return ProductSelection;
	}

	private static String getNumberRanges(String[] configuration)
	{
		String VoiceChannels=configuration[4];

		return VoiceChannels;
	}

	private static String getInstallationTypeBC(String[] configuration)
	{
		String installationType=configuration[0];

		return installationType;
	}

	private static String getProductBC(String[] configuration)
	{
		String ProductBC=configuration[1];

		return ProductBC;
	}

	private static String getTotalVcNumbers(String[] configuration)
	{
		String totalVcNumbers=configuration[2];

		return totalVcNumbers;
	}

	// OVERALL CONFIGURATION OF PRODUCT
	public static void configurationOfECSInternet(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="configurationOfECSInternet";


		try
		{
			contractInformationFields(logStream, driver, stepID, configuration, testName);

			accessTechnology(logStream, driver, stepID, configuration);

			Thread.sleep(2000);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void configurationOfECSEnterpriseVoice(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="configurationOfECSEnterpriseVoice";


		try
		{
			fieldImplementationType(logStream, driver, stepID, configuration, testName);

			connectivityType(logStream, driver, stepID, configuration);
			
			Thread.sleep(1000);

			voiceChannels(logStream, driver, stepID, configuration);

			numberRanges(logStream, driver, stepID, configuration);

			Thread.sleep(2000);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	public static void configurationOfECSBusinessContinuity(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String actionName="configurationOfECSBusinessContinuity";


		try
		{
			installationTypeBC(logStream, driver, stepID, configuration);
			
			productSelectionBC(logStream, driver, stepID, configuration);

			Thread.sleep(2000);

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

			fieldInstallationType(logStream, driver, stepID, configuration);

			fieldRequestedInstallationDate(logStream, driver, stepID, configuration);

			fieldInternalComments(logStream, driver, stepID, configuration, testName);


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
			Select comboContractType = new Select(driver.findElement(By.id("Enterprise_Call___Surf_Internet:ECS_Pack_Contract_Information:contractType_0")));

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

	private static void fieldImplementationType(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String implementationType = getImplementationType(configuration);

		String actionName="EV Implementation Type - Config: "+implementationType;


		try
		{
			Select comboContractType = new Select(driver.findElement(By.id("Details:Contract_Information:implementationType_0")));

			comboContractType.selectByVisibleText(implementationType);



			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldLineReference(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) 
	{
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).clear();
		driver.findElement(By.xpath("")).sendKeys("12345");

	}

	private static void fieldExistingConnectivity(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) 
	{


	}

	private static void fieldInstallationType(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String InstallationType = getInstallationType(configuration);

		String actionName="ECS Internet Installation Type - Config: "+InstallationType;


		try
		{
			Select comboContractType = new Select(driver.findElement(By.id("Enterprise_Call___Surf_Internet:ECS_Pack_Contract_Information:installationType_0")));

			comboContractType.selectByVisibleText(InstallationType);

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
			WebElement inputRequestDate=new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Enterprise_Call___Surf_Internet:ECS_Pack_Contract_Information:serviceRequestDate_0")));

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

	private static void fieldInternalComments(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration, String testName) throws Exception 
	{
		String remarksText=TestCasesData.getOPTYName(testName);

		String actionName="PI Internal Comments - Config: "+remarksText;


		try
		{
			WebElement inputInternalComments = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Enterprise_Call___Surf_Internet:ECS_Pack_Contract_Information:internalComments_0")));

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
//			EProdConfigAction.selectAddressECS(logStream, driver, stepID, "Rue J Besme,20, Koekelberg, 1081, Belgium");

			driver.findElement(By.id("s2id_Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:accessTechnology_0")).click();;

			switch(accessTechnology) {

			case "GPON":
				driver.findElement(By.xpath("//div[contains(text(),'GPON')]")).click();
				break;
			case "VDSL2":
				//driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li[2]")).click();
				driver.findElement(By.xpath("//div[contains(text(),'VDSL2')]")).click();
				break;
			case "ADSL2+E":
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

	private static void connectivityType(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String connectivityType = getConnectivityType(configuration);

		String actionName="EV Connectivity Type Field - Config: "+connectivityType;

		try
		{
			driver.findElement(By.id("s2id_Details:Enterprise_Voice_Configuration:PBX_0")).click();;

			switch(connectivityType) {

			case "Bizz IP Box ISDNoIP-2":
				driver.findElement(By.xpath("//div[contains(text(),'Bizz IP Box ISDNoIP-2')]")).click();
				break;
			case "Bizz IP Box Other IPBX":
				driver.findElement(By.xpath("//div[contains(text(),'Bizz IP Box Other IPBX')]")).click();
				break;
			case "FORUM 500 IP":
				driver.findElement(By.xpath("//div[contains(text(),'FORUM 500 IP')]")).click();
				break;
			case "Forum 5000":
				driver.findElement(By.xpath("//div[contains(text(),'Forum 5000')]")).click();
				break;
			case "Forum 700 IP":
				driver.findElement(By.xpath("//div[contains(text(),'Forum 700 IP')]")).click();
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

	private static void voiceChannels(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String voiceChannels = getVoiceChannels(configuration);

		String actionName="EV Voice Channels Field - Config: "+voiceChannels;

		try
		{
			driver.findElement(By.id("select2-chosen-3")).click();

			driver.findElement(By.xpath("//div[contains(text(),'"+voiceChannels+"')]")).click();


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void numberRanges(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String productSelection = getProductSelection(configuration);

		String numberRanges = getNumberRanges(configuration);

		String actionName="EV Voice Channels Field - Config: "+numberRanges;

		try
		{

			BrowserActions.ScrollByElement(driver, "xpath", "//button[contains(text(),'Add addons')]");	

			driver.findElement(By.xpath("//button[contains(text(),'New NumberRanges')]")).click();

			WebElement productSelectionField = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.id("NumberRanges_0:productSelection_0")));

			productSelectionField.click();
			
			//WebElement productSelectionOption = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(By.id("//*[@id=\"NumberRanges_0:productSelection_0\"]/option[2]")));

			//Thread.sleep(3000);

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

			driver.findElement(By.id("NumberRanges_0:Quantity_0")).click();

			driver.findElement(By.id("NumberRanges_0:Quantity_0")).sendKeys(numberRanges);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void installationTypeBC(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String InstallationTypeBC = getInstallationTypeBC(configuration);

		String actionName="BC Installation Type Field - Config: "+InstallationTypeBC;

		try
		{

			driver.findElement(By.id("ECS___Business_Continuity:Product_Configuration:installationType_0")).click();

			switch(InstallationTypeBC) {
			case "New":
				driver.findElement(By.xpath("//*[@id=\"ECS___Business_Continuity:Product_Configuration:installationType_0\"]/option[1]")).click();
				break;
			case "Existing":
				driver.findElement(By.xpath("//*[@id=\"ECS___Business_Continuity:Product_Configuration:installationType_0\"]/option[2]")).click();
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
	
	
	private static void productSelectionBC(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String productSelectionBC = getProductBC(configuration);
		
		String numbersQuantity = getTotalVcNumbers(configuration);

		String actionName="BC Product Selection Field - Config: "+productSelectionBC;

		try
		{

			driver.findElement(By.id("select2-chosen-1")).click();

			switch(productSelectionBC) {
			case "Enterprise Office Switch 2 numbers":
				driver.findElement(By.xpath("//*[contains(@title,'Enterprise Office Switch 2 numbers')]")).click();
				break;
			case "Voice Continuity 10 numbers":
				driver.findElement(By.xpath("//*[contains(@title,'Voice Continuity 10 numbers')]")).click();
				break;
			case "Enterprise Office Switch 1 number":
				driver.findElement(By.xpath("//*[contains(@title,'Enterprise Office Switch 1 number')]")).click();
				break;
			case "Voice Continuity 5 numbers":
				driver.findElement(By.xpath("//*[contains(@title,'Voice Continuity 5 numbers')]")).click();
				break;
			}
			
			switch(productSelectionBC) {
			case "Enterprise Office Switch 2 numbers":
				driver.findElement(By.id("ECS___Business_Continuity:Product_Configuration:EOSquantity_0")).click();
				//driver.findElement(By.id("ECS___Business_Continuity:Product_Configuration:EOSquantity_0")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("ECS___Business_Continuity:Product_Configuration:EOSquantity_0")).sendKeys(numbersQuantity);
				break;
			case "Voice Continuity 10 numbers":
				driver.findElement(By.id("select2-chosen-2")).click();
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[1]")).click();
				break;
			case "Enterprise Office Switch 1 number":
				driver.findElement(By.id("ECS___Business_Continuity:Product_Configuration:EOSquantity_0")).click();
				//driver.findElement(By.id("ECS___Business_Continuity:Product_Configuration:EOSquantity_0")).clear();
				Thread.sleep(3000);
				driver.findElement(By.id("ECS___Business_Continuity:Product_Configuration:EOSquantity_0")).sendKeys(numbersQuantity);
				break;
			case "Voice Continuity 5 numbers":
				driver.findElement(By.id("select2-chosen-2")).click();
				driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[1]")).click();
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

	// SUBSCRIPTION SELECTION

	private static void fieldWifiAccess(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		String wifiAccess = getWifiAccess(configuration);

		String actionName="PI Wi-Fi Access - Config: "+wifiAccess;

		try
		{
			if(wifiAccess.contains("y") || wifiAccess.contains("Y"))
			{
				WebElement wiFiCheckBox = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Enterprise_Call___Surf_Internet:Subscription_Selection:WifiAccess_0")));

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

			if(i >= 3)
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
	
	public static boolean validationOfBCConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{

		String actionName="Validation of Business Continuity configuration";

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
