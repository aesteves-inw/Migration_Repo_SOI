package executionTools;

import java.util.List;

import testReportComposition.TestStepReportStructure;

public class TestExecutionReport {
	
	public static int stepOfTestStep(List<TestStepReportStructure> testExecStructure)
	{
		int sizeOfTestExecStructure;
		
		sizeOfTestExecStructure=testExecStructure.size();
		
		++sizeOfTestExecStructure;		
		
		return sizeOfTestExecStructure;
	}

}
