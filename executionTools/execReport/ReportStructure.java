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

}
