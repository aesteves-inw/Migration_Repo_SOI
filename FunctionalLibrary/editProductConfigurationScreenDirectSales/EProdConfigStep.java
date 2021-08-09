package editProductConfigurationScreenDirectSales;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import executionTools.BrowserActions;
import executionTools.TestExecutionReport;
import objectMap.sfDirectSales.DirSalesEditProductConfiguration;
import productBasketDirectSales.ProductBasketAction;
import productBasketPartCom.ProductBasketPCAction;
import productConfigurationCloudSense.ECS_FullFiberExtended;
import productConfigurationCloudSense.EnterpriseVoice;
import productConfigurationCloudSense.NonQuotableProducts;
import productConfigurationCloudSense.PhoneLine;
import productConfigurationCloudSense.ProfessionalInternet;
import productConfigurationCloudSense.VoiceContinuity;
import testExecutionData.ProductConfigurationD02;
import testLogBuilder.TestLog;
import testLogger.TestLogger;
import testReportComposition.ReportStructure;
import testReportComposition.TestStepReportStructure;
import testReporter.TestReporter;

public class EProdConfigStep 
{
	// D02 Products
	public static void configureVoiceContinuity(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureVoiceContinuity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			VoiceContinuity.configurationOfVoiceContinuity(logStream, driver, stepID, configuration, testName);

			validation = VoiceContinuity.validationOfVCConfiguration(logStream, driver, stepID, configuration);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	public static void finsihConfiguration(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{

		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);		

		String stepName="Edit Product Configuration 'Screen': Finish Configuration";

		String stepNameMin="finsihConfiguration";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			EProdConfigAction.finishConfiguration(logStream, driver, stepID);

			validation = ProductBasketAction.productBasketScreenValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}

	public static void finsihConfigurationInPC(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception
	{

		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);		

		String stepName="Edit Product Configuration 'Screen': Finish Configuration";

		String stepNameMin="finsihConfiguration";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	

		boolean validation;

		try
		{
			EProdConfigAction.finishConfiguration(logStream, driver, stepID);

			validation = ProductBasketPCAction.validateProductBasketScreen(logStream, stepID, driver);


			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}

	public static void configurePhoneLine(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configurePhoneLine";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		

		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			PhoneLine.configurationOfPhoneLine(logStream, driver, stepID, configuration, testName);

			validation = PhoneLine.validationOfPLConfiguration(logStream, driver, stepID, configuration);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	public static void OCK_CheckInternetECS_Pro(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="OCK Check: "+productName;

		String stepNameMin="OCK_CheckInternetECS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		

		boolean validation;

		//String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{	
			ProductBasketAction.selectAddressEditProduct(logStream, driver, stepID, "Rue J Besme,20, Koekelberg, 1081, Belgium");

			ProductBasketAction.technologyValidationOCK(logStream, driver, stepID, "COPPER");
			
			BrowserActions.screenShotTaking(driver, testName, "firstValidation");
			
			ProductBasketAction.selectAddressEditProduct(logStream, driver, stepID, "Zandstraat,40, Brecht, 2960, Belgium");
			
			ProductBasketAction.technologyValidationOCK(logStream, driver, stepID, "COPPER");

			BrowserActions.screenShotTaking(driver, testName, "secondValidation");
			
			ProductBasketAction.selectAddressEditProduct(logStream, driver, stepID, "Rue J Besme,20, Koekelberg, 1081, Belgium");
			
			ProductBasketAction.technologyValidationOCK(logStream, driver, stepID, "FIBER");

			BrowserActions.screenShotTaking(driver, testName, "thirdValidation");

			//validation = PhoneLine.validationOfPLConfiguration(logStream, driver, stepID, configuration);

			validation = true;

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	public static void configurePhoneLinePC(List<TestStepReportStructure> testExecStructure, List<TestLog> logStream,
			WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configurePhoneLine";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			PhoneLine.configurationOfPhoneLinePC(logStream, driver, stepID, configuration, testName);

			validation = PhoneLine.validationOfPLConfiguration(logStream, driver, stepID, configuration);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	public static void configureProfessionalInternet(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureProfessionalInternet";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		System.out.println(configuration);

		try
		{
			ProfessionalInternet.configurationOfProfessionalInternet(logStream, driver, stepID, configuration, testName);

			validation = ProfessionalInternet.validationOfPIConfiguration(logStream, driver, stepID, configuration);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}
	
	public static void configureECSInternet(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureECS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		System.out.println(configuration);

		try
		{
			ECS_FullFiberExtended.configurationOfECSInternet(logStream, driver, stepID, configuration, testName);

			validation = ECS_FullFiberExtended.validationOfPIConfiguration(logStream, driver, stepID, configuration);
			
			

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	public static void configureEnterpriseVoice(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureEnterpriseVoice";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			EnterpriseVoice.configurationOfEnterpriseVoice(logStream, driver, stepID, configuration, testName);

			validation = EnterpriseVoice.validationOfEVConfiguration(logStream, driver, stepID, configuration);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}
	
	public static void configureECSEnterpriseVoice(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureECSEnterpriseVoice";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			ECS_FullFiberExtended.configurationOfECSEnterpriseVoice(logStream, driver, stepID, configuration, testName);

			validation = ECS_FullFiberExtended.validationOfEVConfiguration(logStream, driver, stepID, configuration);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}
	
	public static void configureECSBusinessContinuity(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="configureECSBusinessContinuity";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		String[] configuration=ProductConfigurationD02.getD02ConfigurationToApply(productName, configurationIndex);

		try
		{
			ECS_FullFiberExtended.configurationOfECSBusinessContinuity(logStream, driver, stepID, configuration, testName);

			validation = ECS_FullFiberExtended.validationOfBCConfiguration(logStream, driver, stepID, configuration);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}
	
	public static void selectAddress(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String address) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Select Address ";

		String stepNameMin="selectAddress";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			EProdConfigAction.selectAddress(logStream, driver, stepID, address);

			validation = EProdConfigAction.selectAddressValidation(logStream, driver, stepID, address);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}
	
	public static void selectAddressECS(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String address) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Select Address ECS";

		String stepNameMin="selectAddressECS";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			EProdConfigAction.selectAddressECS(logStream, driver, stepID, address);

			validation = EProdConfigAction.selectAddressValidation(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}
	
	public static void selectTechnologyNOK(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Select Technology NOK ";

		String stepNameMin="selectTechnologyNOK";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			EProdConfigAction.selectTechnologyNOK(logStream, driver, stepID, "VDSL2");

			validation = EProdConfigAction.selectTechnologyValidationNOK(logStream, driver, stepID);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	public static void maxVoiceChannelsOCKValidation(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="maxVoiceChannelsOCKValidation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		boolean validation = false;

		try
		{

			int i = 0;

			int n = 1;

			String voicechannels;

			String[] maxVoiceChannels = new String[3];

			for( i = 0; i<=2; i++ ) {

				if(productName.equals("Enterprise Voice")) {

					driver.findElement(By.id("s2id_Details:Installation_Address___OCK_Check:accessTechnology_0")).click();

				}

				else {

					driver.findElement(By.id("s2id_Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:accessTechnology_0")).click();

				}

				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li["+ n +"]")).click();

				Thread.sleep(3000);

				if(productName.equals("Enterprise Voice")) {

					voicechannels = driver.findElement(By.xpath("//*[@id=\"Details:Installation_Address___OCK_Check:OCKMaxNumberChannels_0\"]")).getText();

				}
				else {

					voicechannels = driver.findElement(By.id("Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:OCKmaxNumberChannels_0")).getText();

				}

				System.out.println(voicechannels);

				maxVoiceChannels[i]=voicechannels;

				n++;
			}

			if(maxVoiceChannels[0] != "" && maxVoiceChannels[1] != "" && maxVoiceChannels[2] != "") {

				validation = true;
			}

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}
	
	

	public static void OCK_Check_PhoneLine(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String address) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="OCK Check Config: "+productName;

		String stepNameMin="OCK_Check_PhoneLine";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		boolean validation = false;

		try
		{

			driver.findElement(By.xpath("//*[@id=\"select2-chosen-3\"]")).click();

			driver.findElement(By.linkText("//div[contains(text(),"+address+")]")).click();

			int i = 0;

			int n = 1;

			String voicechannels;

			String[] maxVoiceChannels = new String[3];

			for( i = 0; i<=2; i++ ) {

				if(productName.equals("Enterprise Voice")) {

					driver.findElement(By.id("s2id_Details:Installation_Address___OCK_Check:accessTechnology_0")).click();

				}

				else {

					driver.findElement(By.id("s2id_Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:accessTechnology_0")).click();

				}

				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li["+ n +"]")).click();

				Thread.sleep(3000);

				if(productName.equals("Enterprise Voice")) {

					voicechannels = driver.findElement(By.xpath("//*[@id=\"Details:Installation_Address___OCK_Check:OCKMaxNumberChannels_0\"]")).getText();

				}
				else {

					voicechannels = driver.findElement(By.id("Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:OCKmaxNumberChannels_0")).getText();

				}

				System.out.println(voicechannels);

				maxVoiceChannels[i]=voicechannels;

				n++;
			}

			if(maxVoiceChannels[0] != "" && maxVoiceChannels[1] != "" && maxVoiceChannels[2] != "") {

				validation = true;
			}

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	public static void maxVoiceChannelsOCKValidationPC(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName, String configurationIndex) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Product Configuration: "+productName;

		String stepNameMin="maxVoiceChannelsOCKValidation";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);

		boolean validation = false;

		if(productName.equals("Enterprise Voice")) {

			driver.findElement(By.xpath("//*[@id=\"select2-chosen-5\"]")).click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"select2-results-5\"]/li[1]")).click();
		}
		else {

			driver.findElement(By.xpath("//*[@id=\"select2-chosen-3\"]")).click();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"select2-results-3\"]/li[1]")).click();

		}



		try
		{

			int i = 0;

			int n = 1;

			String voicechannels;

			String[] maxVoiceChannels = new String[3];

			for( i = 0; i<=2; i++ ) {

				if(productName.equals("Enterprise Voice")) {

					driver.findElement(By.id("s2id_Details:Installation_Address___OCK_Check:accessTechnology_0")).click();

				}

				else {

					driver.findElement(By.id("s2id_Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:accessTechnology_0")).click();

				}

				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]/li["+ n +"]")).click();

				Thread.sleep(3000);

				if(productName.equals("Enterprise Voice")) {

					voicechannels = driver.findElement(By.xpath("//*[@id=\"Details:Installation_Address___OCK_Check:OCKMaxNumberChannels_0\"]")).getText();

				}
				else {

					voicechannels = driver.findElement(By.id("Enterprise_Call___Surf_Internet:ECS_Pack_Installation_Address___OCK_Check:OCKmaxNumberChannels_0")).getText();

				}

				System.out.println(voicechannels);

				maxVoiceChannels[i]=voicechannels;

				n++;
			}

			if(maxVoiceChannels[0] != "" && maxVoiceChannels[1] != "" && maxVoiceChannels[2] != "") {

				validation = true;
			}

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}


	}

	// D03 Products
	public static void configureNonQuotableProduct(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String configurationProduct) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);

		String stepName="Configure Non Quotable Product: "+configurationProduct;

		String stepNameMin="configureNonQuotableProductStep";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{
			NonQuotableProducts.configurationOfNonQuotableProduct(logStream, driver, stepID, configurationProduct);

			validation = NonQuotableProducts.validationOfNQPConfiguration(logStream, driver, stepID, configurationProduct);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}


	public static void validateD03ProductConfiguration(List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName, String productName) throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);


		String stepName="Product Configuration: D03 Product Validation";

		String stepNameMin="validateD03ProductConfiguration";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);		


		boolean validation;

		try
		{

			validation = NonQuotableProducts.validationOfNQPConfiguration(logStream, driver, stepID, productName);

			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			}
			else
			{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}


		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}

	}
	
	public static void validateAccessTechnologyOptions (List<TestStepReportStructure> testExecStructure,
			List<TestLog> logStream, WebDriver driver, String testName)throws Exception 
	{
		int stepID=TestExecutionReport.stepOfTestStep(testExecStructure);


		String stepName="Product Configuration: Validate Access Tenochnology Field Options";

		String stepNameMin="validateAccessTechnologyOptions";

		String evidenceName=ReportStructure.evidenceName(stepID, stepNameMin);	
		
		boolean validation;

		
		try
		{
			validation = EProdConfigAction.validateAccessTechnologyOptions(logStream, driver, stepID);

			System.out.println(validation);
			
			if(validation==true)
			{
				TestLogger.logInfo(logStream, stepNameMin, TestLogger.logInfo);
				
				TestReporter.stepPassed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
				
				Thread.sleep(2000);
				
				driver.findElement(
						By.xpath("("+DirSalesEditProductConfiguration.dropDownListAccessTechologyField
								+ "//li//div[@class='rTableRow'])[2]")).click();
				
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[contains(@id,'Installation_Address___OCK_check:accessTechnology_0') or contains(@id,'Installation_Address___OCK_Check:accessTechnology_0')] /a/abbr")).click();
				
				
			}else{
				throw new Exception (stepName+" - Failed in Step: "+stepID);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			TestLogger.logError(logStream, stepNameMin, TestLogger.logError, e.toString());
			TestReporter.stepFailed(testExecStructure, driver, testName, stepID, stepName, evidenceName);
			throw new Exception (stepName+" - Failed in Step: "+stepID);
		}
	}


}
