package testReportComposition;

public class TestStepReportStructure {

	//Report Step Elements
	int stepID;
	String stepDescription;
	String expectedOutcome;
	String actualOutcome;
	String stepStatus;
	String timeStamp;
	String screenshotName;
	
	
	
	// Constructor for Test Step Report	Object
	public TestStepReportStructure(int stepID, String stepDescription, String expectedOutcome, String actualOutcome, String stepStatus, String timeStamp, String screenshotName) {
		this.stepID = stepID;
		this.stepDescription = stepDescription;
		this.expectedOutcome = expectedOutcome;
		this.actualOutcome = actualOutcome;
		this.stepStatus = stepStatus;
		this.timeStamp = timeStamp;
		this.screenshotName = screenshotName;
		
	}
	
	// Test Step elements
	public int getStepID() {
		return stepID;
	}
	
	public String getRepStepID() {
		Integer repStepID = stepID;
		return repStepID.toString();
	}
	
	public String getStepDescription() {
		return stepDescription;
	}
	
	public String getExpectedOutcome() {
		return expectedOutcome;
	}
	
	public String getActualOutcome() {
		return actualOutcome;
	}
	
	public String getStepStatus() {
		return stepStatus;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public String getScreenshotName() {
		return screenshotName;
	}


}
