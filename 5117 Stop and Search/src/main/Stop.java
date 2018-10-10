package main;

public class Stop {
	int ID;
	String type;
	Date date;
	
	boolean policingOperation;
	String policingOperationType;
	
	float latitude;
	float longitude;
	
	// ENUMERATORS -- Making it easier to search and sort by specific attributes
	EnumGender gender;
	EnumAgeRange ageRange;
	String selfEthnicity;
	EnumEthnicity ethnicity;
	EnumLegislation legislation;
	EnumSearchReason searchReason;
	
}
