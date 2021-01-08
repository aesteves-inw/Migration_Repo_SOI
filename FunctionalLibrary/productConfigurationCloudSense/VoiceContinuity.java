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

public class VoiceContinuity 
{	

	//07-01-2021 - Methods to retrieve attributes for configuration of Voice Continuity.

	static String getContractType(String[] configuration)
	{
		String contractType=configuration[0];

		return contractType;
	}

	static String getVoiceInstallationStatus(String[] configuration)
	{
		String voiceInstallationStatus=configuration[1];

		return voiceInstallationStatus;
	}

	static String getVoiceProductSelection(String[] configuration)
	{
		String voiceProductSelection=configuration[2];

		return voiceProductSelection;
	}

	static String getLineIdentifier(String[] configuration)
	{
		String lineIdentifier=configuration[3];

		return lineIdentifier;
	}

	static String getNewProductReference(String[] configuration)
	{
		String newProductReference = configuration[4];

		return newProductReference;
	}

	static String getDSIDForBusinessTrunking(String[] configuration)
	{
		String dsidForBusinessTrunking=configuration[5];

		return dsidForBusinessTrunking;
	}

	static String getVoiceContinuityFlavour(String[] configuration)
	{
		String voiceContinuityFlavour=configuration[6];

		return voiceContinuityFlavour;
	}

	
	
	
	// OVERALL CONFIGURATION OF PRODUCT
	public static void configurationOfVoiceContinuity(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration, String testName) throws Exception
	{
		String actionName="configurationOfVoiceContinuity";


		try
		{
			contractInformationFields(logStream, driver, stepID, configuration, testName);

			productConfigurationFields(logStream, driver, stepID, configuration);


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
		String actionName="Contract Information On VoiceContinuity";


		try
		{
			fieldContractType(logStream, driver, stepID, configuration);

			fieldRequestedInstallationDate(logStream, driver, stepID, configuration);

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

		String actionName="VC Contract Type - Config: "+contractType;


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

		String actionName="VC Desired Installation Date - Config: "+dateToInput;


		try
		{
			WebElement inputDesiredInstallationDate = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:serviceRequestDate_0")));

			inputDesiredInstallationDate.clear();
			
			inputDesiredInstallationDate.sendKeys(dateToInput);


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
		String actionName="VC - Internal Comments Field";

		String internalComment=TestCasesData.getOPTYName(testName);

		try
		{
			WebElement inputInternalComments = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:internalComments_0")));
			
			inputInternalComments.clear();
			
			inputInternalComments.sendKeys(internalComment);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	
	//PRODUCT CONFIGURATION
	private static void productConfigurationFields(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String actionName="ProductConfiguration On VoiceContinuity";
		
		String voiceInstallationStatus = getVoiceInstallationStatus(configuration);


		try
		{
			fieldVoiceInstallationStatus(logStream, driver, stepID, configuration);

			if(voiceInstallationStatus.equalsIgnoreCase("existing"))
			{
				fieldLineIdentifier(logStream, driver, stepID, configuration);
			}
			else if(voiceInstallationStatus.equalsIgnoreCase("new"))
			{
				fieldNewProductReference(logStream, driver, stepID, configuration);
			}
			else
			{
				throw new Exception(actionName+" - Invalid Configuration Verified. Test Case Failed");
			}

			fieldVoiceProductSelection(logStream, driver, stepID, configuration);

			fieldVoiceContinuityFlavour(logStream, driver, stepID, configuration);


			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldVoiceInstallationStatus(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String voiceInstallationStatus = getVoiceInstallationStatus(configuration);

		String actionName="VC Voice Installation Status Config: "+voiceInstallationStatus;


		try
		{
			Select comboVoiceInstallationStatus = new Select(driver.findElement(By.xpath("//*[@id='Details:Product_Configuration:voiceInstallationStatus_0']")));

			comboVoiceInstallationStatus.selectByValue(voiceInstallationStatus);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldLineIdentifier(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception {
		String lineIdentifier = getLineIdentifier(configuration);

		String actionName="VC - Line Identifier Config: "+lineIdentifier;

		try
		{
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("Details:Product_Configuration:lineIdentifier_0")));

			driver.findElement(By.id("Details:Product_Configuration:lineIdentifier_0")).sendKeys(lineIdentifier);

			TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
			throw new Exception (actionName+" - Failed in Step "+stepID,e);
		}

	}

	private static void fieldNewProductReference(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		
			String newProductReference=getNewProductReference(configuration);
		
			String actionName="VC - New Product Reference Config: "+newProductReference;
		
		 
			
			try
			{
				driver.findElement(By.xpath(DirSalesEditProductConfiguration.comboNewProductReference)).click();
				
				new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesEditProductConfiguration.listNewProductReference)));
				
				driver.findElement(By.xpath("//div[@title='"+newProductReference+"']")).click();

				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
		

	}

	private static void fieldVoiceProductSelection(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String voiceProductSelection=getVoiceProductSelection(configuration);
		
		String actionName="VC - Voice Product Selection Config: "+voiceProductSelection;
		
		
			
			try
			{
				Select comboVoiceProductSelection = new Select(driver.findElement(By.id("Details:Product_Configuration:voiceProductSelection_0")));
				
				comboVoiceProductSelection.selectByValue(voiceProductSelection);
				
				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);
				
				
				if(voiceProductSelection.toLowerCase().contains("trunking"))
				{
					fieldbusinessTrunkingDSIDConfig(logStream, driver, stepID, configuration);
				}
				

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}

	}

	private static void fieldbusinessTrunkingDSIDConfig(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
	{
		 String actionName="VC - Business Trunking Config";
		 
		 String businessTrunking = getDSIDForBusinessTrunking(configuration);
			
			
			try
			{
				WebElement businessTrunkingDSID = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("Details:Product_Configuration:DSIDforBilling_0")));
				
				businessTrunkingDSID.sendKeys(businessTrunking);

				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}
		
	}

	private static void fieldVoiceContinuityFlavour(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		 String actionName="VC - Voice Continuity Flavour Config";
		 
		 String voiceContinuityFlavour = getVoiceContinuityFlavour(configuration);
			
			
			try
			{
				driver.findElement(By.xpath(DirSalesEditProductConfiguration.comboVoiceContinuityFlavour)).click();
				
				new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DirSalesEditProductConfiguration.listVoiceContinuityFlavours)));
				
				driver.findElement(By.xpath("//div[@title='"+voiceContinuityFlavour+"']")).click();

				TestLogger.logTrace(logStream, actionName, "Succeeded in Step "+stepID);

			}
			catch(Exception e)
			{
				System.out.println(e);
				TestLogger.logError(logStream, actionName, "Failed in Step "+stepID, e.toString());
				throw new Exception (actionName+" - Failed in Step "+stepID,e);
			}

	}

	
	// VALIDATION OF VOICE CONTINUITY CONFIGURATION JOURNEY
	public static boolean validationOfVCConfiguration(List<TestLog> logStream, WebDriver driver, int stepID,
			String[] configuration) throws Exception 
	{
		String actionName="Validation of Voice Continuity configuration (By Default Test Data)";
				
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
			
			if(i >= 4)
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
