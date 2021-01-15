package testExecutionData;

import fetchDataFromExcelFiles.ExcelDataFetch;

public class ProductConfigurationD03 
{
	public static String getNonQuotableProduct(String product)
	{
		String productToReturn;
		
		productToReturn=ExcelDataFetch.searchDT(10, product);
				
				return productToReturn;
	}

}
