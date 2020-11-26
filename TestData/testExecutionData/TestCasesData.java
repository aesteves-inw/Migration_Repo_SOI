package testExecutionData;

import executionTools.ExecStructure;
import fetchDataFromExcelFiles.ExcelDataFetch;

public class TestCasesData {
	
	public static int tcDataindex(int tcNumber) throws Exception
	{
		int tcindex;

		// add more 
		switch(tcNumber)
		{
		case 1:
			tcindex = 3;
			break;
		case 2:
			tcindex = 4;
			break;
		case 3:
			tcindex = 5;
			break;
		default:
			throw new Exception("Not possible to identify Test Case");
		}

		return tcindex;
	}
	
	
	public static String[] getSalesforceUser(String user) throws Exception
	{
		
		if(user.contains("regularUser"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(0, "envUserNameITTQA"), ExcelDataFetch.searchDT(0, "envPasswordITTQA")};
			return finalUser;
		}
		else if(user.contains("approverProfile"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(0, "approverProfileUser"), ExcelDataFetch.searchDT(0, "approverProfilePass")};
			return finalUser;
		}
		else if(user.contains("costumerSupportProfile"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(0, "costumerSupportProfileUser"), ExcelDataFetch.searchDT(0, "costumerSupportProfilePass")};
			return finalUser;
		}
		else if(user.contains("salesSupportProfile"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(0, "salesSupportProfileUser"), ExcelDataFetch.searchDT(0, "salesSupportProfilePass")};
			return finalUser;
		}
		else if(user.contains("SysAdmin"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(0, "sysAdminProfileUser"), ExcelDataFetch.searchDT(0, "sysAdminProfilePass")};
			return finalUser;
		}
		else if(user.contains("farmerUser"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(1, "envUserNameITTQA"), ExcelDataFetch.searchDT(1, "envPasswordITTQA")};
			return finalUser;
		}
		else
		{
			throw new Exception("Not possible to identify User Profile");
		}
	}

	
	public static String getOPTYName(String testClassName)
	{
		String optyName=ExecStructure.getTestExecutionString(testClassName);
		
		return optyName;
	}

}
