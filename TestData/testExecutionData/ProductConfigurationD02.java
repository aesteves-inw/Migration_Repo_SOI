package testExecutionData;

import java.util.ArrayList;

import fetchDataFromExcelFiles.ExcelDataFetch;

public class ProductConfigurationD02 {
	
	public static String getD02ProductToAdd(String testName) throws Exception 
	{
		
		String finalProduct;
		
		if (testName.contains("_175_"))
		{
			finalProduct="Professional Internet";
		}
		else if(testName.contains("_220_"))
		{
			finalProduct="Voice Continuity";
		}
		else if(testName.contains("_239_"))
		{
			finalProduct="Phone Line";
		}
		else
		{
			throw new Exception("Not possible to identify Test Case");
		}
		
		return finalProduct;
		
	}
	
	public static ArrayList<String> getD02ConfigurationToApplyByDefault(String product) throws Exception
	{
		ArrayList<String> configuration = new ArrayList<String>();
			
		switch(product)
		{
		case "Professional Internet":
			throw new Exception("Configuration Not Built");
		case "Voice Continuity":
			configuration.add(ExcelDataFetch.searchDT(6,"defaultContractType"));
			configuration.add(ExcelDataFetch.searchDT(6,"defaultVoiceProductSelection"));
			configuration.add(ExcelDataFetch.searchDT(6,"defaultVoiceInstallationStatus"));
			configuration.add(ExcelDataFetch.searchDT(6,"defaultLineIdentifier"));
			configuration.add(ExcelDataFetch.searchDT(6,"defaultNewProductReference"));
			configuration.add(ExcelDataFetch.searchDT(6,"defaultDISDForBilling"));
			configuration.add(ExcelDataFetch.searchDT(6,"defaultVoiceContinuityFlavour"));
			break;
		case "Phone Line":
			throw new Exception("Configuration Not Built");
		default:
			throw new Exception("Product not found");
		}
		
		
		
		return configuration;
	}

}
