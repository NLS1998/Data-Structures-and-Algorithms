package main;

public class Stop {
	
	// COMMENTS ARE ON HOW TO SERIALIZE EACH DATA TYPE								Position in csvParts List
	public final String SEP = ",";
	String type; //																	0
	String date; // Date class will have serialization method, use substrings.		1
	String policingOperation; // 													2
	String policingOperationType; //												3
	double latitude; // 															4
	double longitude; // 															5
	public EnumGender gender;//														6
	EnumAgeRange ageRange;//														7
	String selfEthnicity;//															8
	EnumEthnicity ethnicity;//														9
	String legislation; // 															10
	EnumObjectSearch objectSearch;//												11
	EnumOutcome outcome;// 															12
	EnumOutcomeObjectSearch outcomeObjectSearch;//									13
	EnumClothesRemoval clothesRemoval;//											14
	
	public Stop(String csvString, String SEP){
		
		String[] csvParts = csvString.split(SEP, -1); // Returns an array
		type = csvParts[0];
		date = csvParts[1];
		policingOperation = csvParts[2];
		policingOperationType = csvParts[3];
		latitude = Double.valueOf(csvParts[4]);
		longitude = Double.valueOf(csvParts[5]);
		gender = EnumGender.getFrom(csvParts[6]);
		ageRange = EnumAgeRange.getFrom(csvParts[10]);
		selfEthnicity =  csvParts[12];
		ethnicity = EnumEthnicity.getFrom(csvParts[11]);
		legislation = csvParts[6];
		objectSearch = EnumObjectSearch.getFrom(csvParts[13]);
		outcome = EnumOutcome.getFrom(csvParts[14]);
		outcomeObjectSearch = EnumOutcomeObjectSearch.getFrom(csvParts[15]);
		clothesRemoval = EnumClothesRemoval.getFrom(csvParts[16]);
	}
	
	public String toCSVString() {
		return  SEP + type + SEP + date + SEP + policingOperation + SEP + policingOperationType + SEP
				+  SEP + latitude + SEP + longitude + SEP + gender + SEP + ageRange + SEP  + selfEthnicity
				 + SEP + ethnicity + SEP + legislation + SEP + objectSearch + SEP + outcome + SEP + outcomeObjectSearch + SEP + clothesRemoval;
	
	}
	
}