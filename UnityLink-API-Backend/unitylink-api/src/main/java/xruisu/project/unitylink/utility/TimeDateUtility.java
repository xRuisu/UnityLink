package xruisu.project.unitylink.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeDateUtility {
		
	private static LocalDate getDate = LocalDate.now(); 
	
	private static String currentDate  = getDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	
	public  static String getCreationDate() {
		return currentDate;
	}
}
