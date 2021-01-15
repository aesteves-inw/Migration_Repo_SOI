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
		
		if(user.contains("salesUser"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(1, "PRX_SalesUserProfile_userName"), ExcelDataFetch.searchDT(1, "PRX_SalesUserProfile_passWord")};
			return finalUser;
		}
		else if(user.contains("salesSupportUser"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(1, "PRX_SalesSupportProfile_userName"), ExcelDataFetch.searchDT(1, "PRX_SalesSupportProfile_passWord")};
			return finalUser;
		}
		else if(user.contains("costumerSupportProfile"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(1, "PRX_EBUCustomerSupportProfile_userName"), ExcelDataFetch.searchDT(1, "PRX_EBUCustomerSupportProfile_passWord")};
			return finalUser;
		}
		else if(user.contains("SysAdmin"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(1, "sysAdminProfile_userName"), ExcelDataFetch.searchDT(1, "sysAdminProfile_passWord")};
			return finalUser;
		}
		else if(user.contains("farmerUser"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(1, "PRXPartnerFarmerProfile_userName"), ExcelDataFetch.searchDT(1, "PRXPartnerFarmerProfile_passWord")};
			return finalUser;
		}
		else if(user.contains("hunterUser"))
		{
			String[] finalUser= {ExcelDataFetch.searchDT(1, "PRXPartnerHunterProfile_userName"), ExcelDataFetch.searchDT(1, "PRXPartnerHunterProfile_passWord")};
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

	public static String getIDByURL(String urlOfElement)
	{
		// Debug of data passing
		//int c=0;
		
		String idToReturn;
		
		//optyURL="https://proximus--prxitt.lightning.force.com/lightning/r/Opportunity/0063M000002X6MuQAK/view";
		
		String[] urlToValidate=urlOfElement.split("/");
		
		/* Debug of data passing
		for(String s:urlToValidate)
		{
			System.out.println("Componente do endereço: "+c+" - "+s);
			c++;
		}
		*/
		idToReturn=urlToValidate[6];
		
		return idToReturn;
	}

}


