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
				EProdConfigAction.selectAddressECS(logStream, driver, stepID, "Rue J Besme,20, Koekelberg, 1081, Belgium");
				
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

		/*private static void fieldOCKResult(List<TestLog> logStream, WebDriver driver, int stepID, String[] configuration) throws Exception 
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
			
		}*/

		
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

		

}
