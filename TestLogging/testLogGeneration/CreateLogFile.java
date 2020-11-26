package testLogGeneration;

import java.util.List;

import testLogBuilder.TestLog;
import testLogBuilder.TestLogElements;
import testReportComposition.TestReportHeaderStructure;
import testReportComposition.TestStepReportStructure;
import testReportGeneration.CreateTestReport;

public class CreateLogFile {
	
	public CreateLogFile(List<TestLog> logInfo, List<TestStepReportStructure> testReport, TestReportHeaderStructure testHeader)
	{
		try
		{
			String testName=testHeader.getTestName();
			
			StringBuilder logSB = new StringBuilder();
			
			//log header
			logSB.append("###############################################################################"+"\r\n");
			logSB.append("Simple Ordering Intake Project - Test Automation"+"\r\n");
			logSB.append("###############################################################################"+"\r\n");
			logSB.append("Test Case: "+testName+"\r\n");
			//logSB.append("Environment: "++"\r\n");
			logSB.append("Log Date: "+testHeader.getInitialTestDate()+"\r\n");
			logSB.append("Test Status: "+TestLogElements.testFinalStatus(testReport)+"\r\n");
			logSB.append("###############################################################################"+"\r\n");
			
			for(TestLog li:logInfo)
			{
				logSB.append(li.getTimeOfTheLog()+ " - "+li.getSignOfTheLog()+" - "+li.getComponentOfTheLog()+" - "+li.getMessageOfTheLog()+"\r\n");
			}
			
			logSB.append("############################# End Of Log File #################################"+"\r\n");
			
			CreateTestReport.WriteToFile(logSB.toString(), "testExecutionLog.txt", testName);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
