package testExecutionData;


import fetchDataFromExcelFiles.ExcelDataFetch;

public class ProductConfigurationD01 {
	
	public static String[] prodConfiguration(int tcNumber) throws Exception
	{
		String[] pConfig = {ExcelDataFetch.searchDT(TestCasesData.tcDataindex(tcNumber), "productContractValue"), ExcelDataFetch.searchDT(TestCasesData.tcDataindex(tcNumber), "productContractDuration"), ExcelDataFetch.searchDT(TestCasesData.tcDataindex(tcNumber), "productRevenueType"), ExcelDataFetch.searchDT(TestCasesData.tcDataindex(tcNumber), "productProductRegime")};
		return pConfig;
	}

}
