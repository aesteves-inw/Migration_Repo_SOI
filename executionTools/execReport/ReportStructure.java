package execReport;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReportStructure {
	
	public static long estimatedDuration(long beginTime, long endTime)
	{
		
		long elapsedTime = endTime - beginTime;
		long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
		return convert;
	}
	
	public static String timeConversion(long durationTime)
	{
		int segs = (int) durationTime;
		int p1 = segs % 60;
	    int p2 = segs / 60;
	    int p3 = p2 % 60;
	    p2 = p2 / 60;
	    String timeFormatted=p2 + ":" + p3 + ":" + p1;
	    return timeFormatted;
	}
	
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
			finalStatus="<font color=\"green\"><b>Passed</b></font>";
		}
		else
		{
			finalStatus="<font color=\"red\"><b>Failed</b></font>";
		}
		
		
		return finalStatus;
	}
	
	
	//02-03-2020 - Added in order to manage Report from TestStep Class
	public static String evidenceName(int stepID, String stepNameMin)
	{
		String evidenceName=stepID+"_"+stepNameMin;
		return evidenceName;
	}
	
	public static String[] testReportElements(char status)
	{
		
		String passedStep ="Validation with success";
		
		String failedStep="Not possible to validate";
		
		char statusChar=Character.toLowerCase(status);
		
		if(statusChar == 'p')
		{
			String[] reportElements= {"Passed", passedStep, passedStep};
			return reportElements;
		}
		else
		{
			String[] reportElements= {"Failed", passedStep, failedStep};
			return reportElements;
		}
		
		
	}
	
	public static String testReportElement(String[] testReportElements, int p)
	{
		return testReportElements[p];
	}
	
	public static String testReportFinalElement(char status, char element) throws Exception
	{
		/*
		 * Examples of usage: testReportFinalElement('p', 's');
		 * Examples of usage: testReportFinalElement('p', 'e');
		 * Examples of usage: testReportFinalElement('p', 'a');
		 * Examples of usage: testReportFinalElement('f', 's');
		 * Examples of usage: testReportFinalElement('f', 'e');
		 * Examples of usage: testReportFinalElement('f', 'a');
		 * 
		 */
		
		char fCharEl=Character.toLowerCase(element);
		
		switch(fCharEl)
		{
		case 's':
			return testReportElement(testReportElements(status), 0);
		case 'e':
			return testReportElement(testReportElements(status), 1);
		case 'a':
			return testReportElement(testReportElements(status), 2);
		default:
			throw new Exception("Not possible to identify Test Report Element");
				
		}
	}
}
