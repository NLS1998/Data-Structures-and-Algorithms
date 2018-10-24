package main;

public class Stop {
	int ID;
	String type;
	Date date;
	
	boolean policingOperation;
	String policingOperationType;
	
	float latitude;
	float longitude;
	
	String legislation;
	String searchReason;
	
	// ENUMERATORS -- Making it easier to search and sort by specific attributes
	EnumGender gender;
	EnumAgeRange ageRange;
	String selfEthnicity; // due to how complex self-identified ethnicities are, we can't assume anything.
	EnumEthnicity ethnicity;
	
	
	
}
