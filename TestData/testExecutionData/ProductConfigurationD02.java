package testExecutionData;

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

	public static String[] convertConfiguration(String dataFromExcel)
	{			
		String[] ProductConfiguration = dataFromExcel.split(",");

		return ProductConfiguration;
	}

	public static String[] getD02ConfigurationToApply(String product, String configurationIndex) throws Exception
	{
		String[] configuration;
		String dataFromExcel;

		switch(product)
		{
		case "Professional Internet":
			dataFromExcel=ExcelDataFetch.searchDT(5, configurationIndex);
			configuration=convertConfiguration(dataFromExcel);
			break;
		case "Voice Continuity":
			dataFromExcel=ExcelDataFetch.searchDT(6, configurationIndex);
			configuration=convertConfiguration(dataFromExcel);
			break;
		case "Phone Line":
			dataFromExcel=ExcelDataFetch.searchDT(6, configurationIndex);
			configuration=convertConfiguration(dataFromExcel);
			break;
		default:
			throw new Exception("Product not found");
		}

		return configuration;
	}

	public static String getSalesforceMappedProduct(String product) throws Exception
	{
		String productMapped;

		switch(product)
		{
		//D02 StandAlone Products Mapping
		case "Voice Continuity":
			productMapped="Fix Voice Value Added Services";
			break;
		case "Enterprise Voice":
			productMapped="VoIP Access & Traffic";
			break;
		case "Phone Line":
			productMapped="PSTN/ISDN Access & Traffic";
		case "Professional Internet":
		productMapped="Professional Internet";
			break;
			//D02 ECS Products
			//D03 Products Mapping
		case "PABX":
		productMapped="VoIP Access & Traffic";
			break;
		default:
			throw new Exception("Product not found");
		}
		
		return productMapped;
	}
}
