package notInclude;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import execReport.TestStepReportStructure;
import execStructure.TestStructure;
import functionalSteps.SFDS.StpsSalesHomePage;

public class NewTest extends LoginAndLogoutDS{

	@Test
	public void step02() throws Exception 
	{
		stepsExecuted++;

		try 
		{

			TestStepReportStructure step02 = StpsSalesHomePage.logoutSFDS(driver, testName, stepsExecuted);
			testExecStructure.add(step02);
			
			if (step02.getStepStatus().toLowerCase().contains("failed")) 
			{

				throw new Exception("Validation Failed on Step "+stepsExecuted);
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new Exception("Test Failed on Step "+stepsExecuted,e);
		}
	}
	
	@AfterClass
  public void afterTest() 
  {
	  TestStructure.finishTest(testName, initialTestDate, startTime, stepsExecuted, testExecStructure, testData, driver);
	  
  }

}
