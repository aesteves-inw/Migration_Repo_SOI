package testExecutionData;

import fetchDataFromExcelFiles.ExcelDataFetch;

public class CompaniesTestData {
	
	
	public static String tdCompanyName(String testName) throws Exception
	{		

		String tdCompanyName, testNameLower;
		
		testNameLower=testName.toLowerCase();

		if(testNameLower.contains("soi_66"))
		{
			tdCompanyName=ExcelDataFetch.searchDT(2,"testingCompanySOI66");
		}
		else if(testNameLower.contains("soi_68"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI68");
		}
		else if(testNameLower.contains("soi_69"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI69");
		}
		else if(testNameLower.contains("soi_70"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI70");
		}
		else if(testNameLower.contains("soi_72"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI72");
		}
		else if(testNameLower.contains("soi_76"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI76");
		}
		else if(testNameLower.contains("soi_79"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI79");
		}
		else if(testNameLower.contains("soi_80"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI80");
		}
		else if(testNameLower.contains("soi_84"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI84");
		}
		else if(testNameLower.contains("soi_150"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI150");
		}
		else if(testNameLower.contains("soi_273"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI273");
		}
		else if(testNameLower.contains("soi_718"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI718");
		}
		else if(testNameLower.contains("soi_720"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI720");
		}
		else if(testNameLower.contains("soi_721"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI721");
		}
		else if(testNameLower.contains("soi_770"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI770");
		}
		else if(testNameLower.contains("soi_880"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI880");
		}
		// 28-07-2020 - Delivery D02 Companies
		else if(testNameLower.contains("soi_175"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI175");
		}
		else if(testNameLower.contains("soi_220"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI220");
		}
		else if(testNameLower.contains("soi_239"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI239");
		}
		else if(testNameLower.contains("soi_1312"))
		{
			tdCompanyName= ExcelDataFetch.searchDT(2,"testingCompanySOI1312");
		}
		else
		{
			throw new Exception("Not possible to identify Test Case");
		}

		return tdCompanyName;

	}

	public static String tdCompanyID(String testName) throws Exception
	{
		String tdCompanyID, testNameLower;
		
		testNameLower=testName.toLowerCase();

		if(testNameLower.contains("soi_66"))
		{
			tdCompanyID=ExcelDataFetch.searchDT(2,"idTestingCompanySOI66");
		}
		else if(testNameLower.contains("soi_68"))
		{
			tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI68");
		}
		else if(testNameLower.contains("soi_69"))
		{
			tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI69");
		}
		else if(testNameLower.contains("soi_70"))
		{
			tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI70");
		}
		else if(testNameLower.contains("soi_76"))
		{
			tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI76");
		}
		else if(testNameLower.contains("soi_79"))
		{
			tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI79");
		}
		else if(testNameLower.contains("soi_150"))
		{
			tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI150");
		}
		else if(testNameLower.contains("soi_273"))
		{
			tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI273");
		}
		else if(testNameLower.contains("soi_718"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI718");
        }
		else if(testNameLower.contains("soi_720"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI720");
        }
		else if(testNameLower.contains("soi_721"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI721");
        }
		else if(testNameLower.contains("soi_770"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI770");
        }
		else if(testNameLower.contains("soi_880"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI880");
        }
		// 28-07-2020 - Delivery D02 Companies
		else if(testNameLower.contains("soi_175"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI175");
        }
		else if(testNameLower.contains("soi_220"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI220");
        }
		else if(testNameLower.contains("soi_239"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI239");
        }
		else if(testNameLower.contains("soi_1312"))
        {
            tdCompanyID= ExcelDataFetch.searchDT(2,"idTestingCompanySOI1312");
        }
		else
		{
			throw new Exception("Not possible to identify Test Case");
		}

		return tdCompanyID;
	}

}
