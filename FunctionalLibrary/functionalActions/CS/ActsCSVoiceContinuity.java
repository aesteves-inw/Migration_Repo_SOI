		package functionalActions.CS;
		
		import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cloudSense.CloudSenseEditProductConfiguration;
import execStructure.TestDataManagement;
		
		public class ActsCSVoiceContinuity {
			
			//Voice Continuity TestData Manipulation
			
			private static String getContractType(ArrayList<String> prodConfiguration)
			{
				return prodConfiguration.get(0);
			}
			
			private static String getVoiceProductSelection(ArrayList<String> prodConfiguration)
			{
				return prodConfiguration.get(1);
			}
			
			private static String getVoiceInstallationStatus(ArrayList<String> prodConfiguration)
			{
				return prodConfiguration.get(2);
			}
			
			private static String getLineIdentifier(ArrayList<String> prodConfiguration)
			{
				return prodConfiguration.get(3);
			}
			
			private static String getNewProductReference(ArrayList<String> prodConfiguration)
			{
				return prodConfiguration.get(4);
			}
			
			private static String getDISDForBilling(ArrayList<String> prodConfiguration)
			{
				return prodConfiguration.get(5);
			}
			
			private static String getVoiceContinuityFlavour(ArrayList<String> prodConfiguration)
			{
				return prodConfiguration.get(6);
			}
		
		
		
			// Regular Actions
			/*02-03-2020:LMA
			 * sketch for every regular functions
			 *=====================================
						 public static void functionName()
						 {
						 String actionName="";
		
		
							try
							{
								<JAVA CODE>
		
								System.out.println(actionName+" - Succeeded in Step "+stepID);
		
							}
							catch(Exception e)
							{
								System.out.println(e);
								throw new Exception (actionName+" - Failed in Step "+stepID,e);
							}
							}
		
			 */
			
			//Voice Continuity types
			public static void configureVCByDefault(WebDriver driver, int stepID, String testName) throws Exception 
			{
				String actionName="Voice Continuity: Configuration By Default";
				
				ArrayList<String> prodConfigurationByDefault=TestDataManagement.getD02ConfigurationToApplyByDefault(TestDataManagement.getD02ProductToAdd(testName));
				
				try
				{
					configureVoiceContinuity(driver, stepID, prodConfigurationByDefault);

					System.out.println(actionName+" - Succeeded in Step "+stepID);

				}
				catch(Exception e)
				{
					System.out.println(e);
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}
				
			}
			
			
		
			//Voice Continuity Configuration
			private static void configureVoiceContinuity(WebDriver driver, int stepID, ArrayList<String> prodConfiguration) throws Exception
			{
				String actionName="Voice Continuity Configuration";
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
				try
				{
					contractInformationArea(driver, wait, stepID, prodConfiguration);
		
					productConfigurationArea(driver, wait, stepID, prodConfiguration);
		
		
		
					System.out.println(actionName+" - Succeeded in Step "+stepID);
		
				}
				catch(Exception e)
				{
					System.out.println(e);
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}
			}
		
		
		
			// Contract Information Area
			private static void contractInformationArea(WebDriver driver, WebDriverWait wait, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				String actionName="Configure VC: Contract Information Area";
		
		
				try
				{
					contractTypeConfig(driver, stepID, prodConfiguration);
		
					desiredInstallationDateConfig(driver, wait, stepID);
		
					System.out.println(actionName+" - Succeeded in Step "+stepID);
		
				}
				catch(Exception e)
				{
					System.out.println(e);
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}
		
			}
		
			private static void contractTypeConfig(WebDriver driver, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				
				String contractType = getContractType(prodConfiguration);
				
				String actionName="VC Contract Type: "+contractType+" - Configuration";
				
				
				try
				{
					Select comboContractType = new Select(driver.findElement(By.id("Details:Contract_Information:contractType_0")));
					
					comboContractType.selectByVisibleText(contractType);

					System.out.println(actionName+" - Succeeded in Step "+stepID);

				}
				catch(Exception e)
				{
					System.out.println(e);
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}
		
			}
		
			private static void desiredInstallationDateConfig(WebDriver driver, WebDriverWait wait, int stepID) throws Exception 
			{
				 String actionName="VC Desired Installation Date - Config ";
					
					
					try
					{
						WebElement inputDesiredInstallationDate = wait.until(ExpectedConditions.elementToBeClickable(By.id("Details:Contract_Information:serviceRequestDate_0")));
						
						inputDesiredInstallationDate.sendKeys(TestDataManagement.tomorrowFormattedDate());

						System.out.println(actionName+" - Succeeded in Step "+stepID);

					}
					catch(Exception e)
					{
						System.out.println(e);
						throw new Exception (actionName+" - Failed in Step "+stepID,e);
					}
		
			}
		
		
		
			// Product Configuration Area
			private static void productConfigurationArea(WebDriver driver, WebDriverWait wait, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				String actionName="Configure VC: Product Configuration Area";
		
				try
				{
					voiceInstallationStatusConfig(driver, wait, stepID, prodConfiguration);
		
					voiceProductSelectionConfig(driver, wait, stepID, prodConfiguration);

					voiceContinuityFlavourConfig(driver, wait, stepID, prodConfiguration);
					
		
					System.out.println(actionName+" - Succeeded in Step "+stepID);
		
				}
				catch(Exception e)
				{
					System.out.println(e);
					throw new Exception (actionName+" - Failed in Step "+stepID,e);
				}
		
			}
		
			private static void voiceInstallationStatusConfig(WebDriver driver, WebDriverWait wait, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				 String voiceInstallationStatus = getVoiceInstallationStatus(prodConfiguration);
				
				String actionName="VC Voice Installation Status Config";
					
					
					try
					{
						Select comboVoiceInstallationStatus = new Select(driver.findElement(By.id("Details:Product_Configuration:voiceInstallationStatus_0")));
						
						comboVoiceInstallationStatus.selectByValue(voiceInstallationStatus);
						
						System.out.println(actionName+" - Succeeded in Step "+stepID);
						
						if(voiceInstallationStatus.toLowerCase() == "existing")
						{
							lineIdentifierConfig(driver, stepID, prodConfiguration);
						}
						else if(voiceInstallationStatus.toLowerCase() == "new")
						{
							newProductReferenceConfig(driver, wait, stepID, prodConfiguration);
						}
						
					}
					catch(Exception e)
					{
						System.out.println(e);
						throw new Exception (actionName+" - Failed in Step "+stepID,e);
					}
		
			}
			
			private static void newProductReferenceConfig(WebDriver driver, WebDriverWait wait, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				 String actionName="VC - New Product Reference Config";
				
				 String newProductReference=getNewProductReference(prodConfiguration);
					
					try
					{
						driver.findElement(By.xpath(CloudSenseEditProductConfiguration.comboNewProductReference)).click();
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CloudSenseEditProductConfiguration.listNewProductReference)));
						
						driver.findElement(By.xpath("//div[@title='"+newProductReference+"']")).click();

						System.out.println(actionName+" - Succeeded in Step "+stepID);

					}
					catch(Exception e)
					{
						System.out.println(e);
						throw new Exception (actionName+" - Failed in Step "+stepID,e);
					}
				
			}
	
			private static void voiceProductSelectionConfig(WebDriver driver, WebDriverWait wait, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{ 
				String actionName="VC - Voice Product Selection Config";
				
				String voiceProductSelection=getVoiceProductSelection(prodConfiguration);
					
					
					try
					{
						Select comboVoiceProductSelection = new Select(driver.findElement(By.id("Details:Product_Configuration:voiceProductSelection_0")));
						
						comboVoiceProductSelection.selectByValue(voiceProductSelection);
						
						System.out.println(actionName+" - Succeeded in Step "+stepID);
						
						if(voiceProductSelection.toLowerCase().contains("trunking"))
						{
							businessTrunkingDSIDConfig(driver, wait, stepID, prodConfiguration);
						}

					}
					catch(Exception e)
					{
						System.out.println(e);
						throw new Exception (actionName+" - Failed in Step "+stepID,e);
					}
		
			}
				
			private static void lineIdentifierConfig(WebDriver driver, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				 String actionName="VC - Line Identifier Config";
				 
				 String lineIdentifier = getLineIdentifier(prodConfiguration);
					
					
					try
					{
						driver.findElement(By.id("Details:Product_Configuration:lineIdentifier_0")).sendKeys(lineIdentifier);

						System.out.println(actionName+" - Succeeded in Step "+stepID);

					}
					catch(Exception e)
					{
						System.out.println(e);
						throw new Exception (actionName+" - Failed in Step "+stepID,e);
					}
		
			}
			
			private static void businessTrunkingDSIDConfig(WebDriver driver, WebDriverWait wait, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				 String actionName="VC - Business Trunking Config";
				 
				 String businessTrunking = getDISDForBilling(prodConfiguration);
					
					
					try
					{
						WebElement businessTrunkingDSID = wait.until(ExpectedConditions.elementToBeClickable(By.id("Details:Product_Configuration:DSIDforBilling_0")));
						
						businessTrunkingDSID.sendKeys(businessTrunking);

						System.out.println(actionName+" - Succeeded in Step "+stepID);

					}
					catch(Exception e)
					{
						System.out.println(e);
						throw new Exception (actionName+" - Failed in Step "+stepID,e);
					}
		
			}
		
			private static void voiceContinuityFlavourConfig(WebDriver driver, WebDriverWait wait, int stepID, ArrayList<String> prodConfiguration) throws Exception 
			{
				 String actionName="VC - Voice Continuity Flavour Config";
				 
				 String voiceContinuityFlavour = getVoiceContinuityFlavour(prodConfiguration);
					
					
					try
					{
						driver.findElement(By.xpath(CloudSenseEditProductConfiguration.comboVoiceContinuityFlavour)).click();
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CloudSenseEditProductConfiguration.listVoiceContinuityFlavours)));
						
						driver.findElement(By.xpath("//div[@title='"+voiceContinuityFlavour+"']")).click();

						System.out.println(actionName+" - Succeeded in Step "+stepID);

					}
					catch(Exception e)
					{
						System.out.println(e);
						throw new Exception (actionName+" - Failed in Step "+stepID,e);
					}
		
			}

			
			
			
		
		
			
		
		
		
		// Validation Actions
		/*
		 * 02-03-2020:LMA
		
		 * sketch for every validation functions
		 *=====================================
					 	public static boolean functionName()
					 	{
		
							 String actionName="";
							 try
								{
								if()
								{
									System.out.println(actionName+" - Succeeded in Step: "+stepID);
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
									throw new Exception (actionName+" - Failed in Step: "+stepID,e);
								}
						}
		 */
		
		
		public static boolean validateVCByDefault(WebDriver driver, int stepID, String testName) throws Exception
		{
		
			String actionName="Validation of Voice Continuity configuration (By Default Test Data)";
			
			ArrayList<String> prodConfigurationByDefault=TestDataManagement.getD02ConfigurationToApplyByDefault(TestDataManagement.getD02ProductToAdd(testName));
			
			int i=0;
			
			try
			{
				WebElement editProductConfigScreenVal = driver.findElement(By.xpath(CloudSenseEditProductConfiguration.editProductScreenContainer));
				
				String editProductConfigScreenValText=editProductConfigScreenVal.getText().toString();
				
				for(String par:prodConfigurationByDefault)
				{
					if(editProductConfigScreenValText.contains(par))
					{
						i++;
					}
				}
				
				if(i >= 5)
				{
					System.out.println(actionName+" - Succeeded in Step: "+stepID);
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
				throw new Exception (actionName+" - Failed in Step: "+stepID,e);
			}
		}
		
		//
		
		}
