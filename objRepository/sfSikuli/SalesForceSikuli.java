package sfSikuli;

import org.sikuli.script.Pattern;

import execStructure.ExecStructure;

public class SalesForceSikuli {
	
	 //Sikuli elements location
	static String sikulilocalrepository=ExecStructure.workingDir+"\\testData\\sikuli_Support\\";
	
	//Sikuli elements
	
	//Open File - Upload window
	public static Pattern uploadBarFilePathOpenCancel = new Pattern(sikulilocalrepository+"uploadBarFilePathOpenCancel.png").similar(0.8f);
	
	public static Pattern filePath = new Pattern(sikulilocalrepository+"filePath.png").similar(0.8f);
	
	public static Pattern searchFileBar= new Pattern(sikulilocalrepository+"searchFile.png").similar(0.8f);
	
	public static Pattern file2Upload= new Pattern(sikulilocalrepository+"dummyFile.png").similar(0.8f);
	
	public static Pattern openButton = new Pattern(sikulilocalrepository+"openButton.png").similar(0.8f);
	
	public static Pattern uploadFilesDoneSalesforce = new Pattern(sikulilocalrepository+"uploadFilesDoneSalesforce.png").similar(0.8f);
	
	public static Pattern doneButton = new Pattern(sikulilocalrepository+"doneButton.png").similar(0.8f);
	
}
