package main;

public class Stop {
	
	// COMMENTS ARE ON HOW TO SERIALIZE EACH DATA TYPE								Position in csvParts List
	String policeForce; // Substring on File's Name									0
	String type; // Read in directly												1
	Date date; // Date class will have serialization method, use substrings.		2
	boolean policingOperation; // If statement										3
	String policingOperationType; // Read in directly								4
	float latitude; // Read in directly												5
	float longitude; // Read in directly											6
	String legislation; // Read in directly											7
	String searchReason; // Read in directly										8
	EnumGender gender; // If statement												9
	EnumAgeRange ageRange; // If statement											10
	EnumEthnicity ethnicity; // If statement										11
	String selfEthnicity; // Read in directly										12
	
	public Stop(String csvString, String SEP){
		
		String[] csvParts = csvString.split(SEP, -1); // Returns an array
		
	}
	
	
	
	
	
}