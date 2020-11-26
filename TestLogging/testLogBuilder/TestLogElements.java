package testLogBuilder;

import java.util.List;

import testReportComposition.TestStepReportStructure;

public class TestLogElements {
	
	public static String testFinalStatus(List<TestStepReportStructure> testReport)
	{
		String finalStatus;
		
		int failedCounter=0;
		
		for(TestStepReportStructure ts:testReport)
		{
			if (ts.getStepStatus().equalsIgnoreCase("failed"))
			{
				failedCounter++;
			}
		}
		
		if (failedCounter == 0)
		{
			finalStatus="Passed";
		}
		else
		{
			finalStatus="Failed";
		}
		
		
		return finalStatus;
	}
	

}
