package main;

import java.util.LinkedList;

public class Stop extends Main {

	// COMMENTS ARE ON HOW TO SERIALIZE EACH DATA TYPE Position in csvParts List
	public final String SEP = ",";
	public String type; // 0
	public String date; // Date class will have serialization method, use substrings. 1
	public String policingOperation; // 2
	public String policingOperationType; // 3
	public String latitude; // 4
	public String longitude; // 5
	public EnumGender gender;// 6
	EnumAgeRange ageRange;// 7
	public String selfEthnicity;// 8
	EnumEthnicity ethnicity;// 9
	public String legislation; // 10
	EnumObjectSearch objectSearch;// 11
	public String outcome;// 12
	EnumOutcomeObjectSearch outcomeObjectSearch;// 13
	EnumClothesRemoval clothesRemoval;// 14

	public Stop(String csvString) {

		String[] csvParts = csvString.split(SEP, -1); // Returns an array
		type = csvParts[0];
		date = csvParts[1];
		policingOperation = csvParts[2];
		policingOperationType = csvParts[3];
		latitude = csvParts[4];
		longitude = csvParts[5];
		gender = EnumGender.getFrom(csvParts[6]);
		ageRange = EnumAgeRange.getFrom(csvParts[7]);
		selfEthnicity = csvParts[8];
		ethnicity = EnumEthnicity.getFrom(csvParts[9]);
		legislation = csvParts[10];
		objectSearch = EnumObjectSearch.getFrom(csvParts[11]);
		outcome = csvParts[12];
		outcomeObjectSearch = EnumOutcomeObjectSearch.getFrom(csvParts[13]);
		clothesRemoval = EnumClothesRemoval.getFrom(csvParts[14]);
	}
	public String tocsvString() {
		
		return  objectSearch + SEP ;

	}

	public static void insertSortA(LinkedList<Stop> stopList) {

		for (int i = 1; i < stopList.size(); i++) {
			for (int j = i; j > 0; j--) {
				Stop lower = stopList.get(j - 1);
				Stop higher = stopList.get(j);
				if (higher.objectSearch.compareTo(lower.objectSearch) < 0) {
					stopList.set(j, lower);
					stopList.set(j - 1, higher);
				} else
					break;
			}
		}
	}
}