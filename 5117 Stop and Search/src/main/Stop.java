package main;

public class Stop extends Main {

	// COMMENTS ARE ON HOW TO SERIALIZE EACH DATA TYPE Position in csvParts List
	private final String SEP = ",";
	private String type; // 0
	private String date; // Date class will have serialization method, use substrings. 1
	private String policingOperation; // 2
	private String policingOperationType; // 3
	private String latitude; // 4
	private String longitude; // 5
	private EnumGender gender;// 6
	private EnumAgeRange ageRange;// 7
	private String selfEthnicity;// 8
	private EnumEthnicity ethnicity;// 9
	private String legislation; // 10
	private EnumObjectSearch objectSearch;// 11
	private String outcome;// 12
	private EnumOutcomeObjectSearch outcomeObjectSearch;// 13
	private EnumClothesRemoval clothesRemoval;// 14

	Stop(String csvString) {// Serialises all read in data

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

		return objectSearch + SEP; // Prints only Object Search column
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPolicingOperation() {
		return policingOperation;
	}

	public void setPolicingOperation(String policingOperation) {
		this.policingOperation = policingOperation;
	}

	public String getPolicingOperationType() {
		return policingOperationType;
	}

	public void setPolicingOperationType(String policingOperationType) {
		this.policingOperationType = policingOperationType;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public EnumGender getGender() {
		return gender;
	}

	public void setGender(EnumGender gender) {
		this.gender = gender;
	}

	public EnumAgeRange getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(EnumAgeRange ageRange) {
		this.ageRange = ageRange;
	}

	public String getSelfEthnicity() {
		return selfEthnicity;
	}

	public void setSelfEthnicity(String selfEthnicity) {
		this.selfEthnicity = selfEthnicity;
	}

	public EnumEthnicity getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(EnumEthnicity ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getLegislation() {
		return legislation;
	}

	public void setLegislation(String legislation) {
		this.legislation = legislation;
	}

	public EnumObjectSearch getObjectSearch() {
		return objectSearch;
	}

	public void setObjectSearch(EnumObjectSearch objectSearch) {
		this.objectSearch = objectSearch;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public EnumOutcomeObjectSearch getOutcomeObjectSearch() {
		return outcomeObjectSearch;
	}

	public void setOutcomeObjectSearch(EnumOutcomeObjectSearch outcomeObjectSearch) {
		this.outcomeObjectSearch = outcomeObjectSearch;
	}

	public EnumClothesRemoval getClothesRemoval() {
		return clothesRemoval;
	}

	public void setClothesRemoval(EnumClothesRemoval clothesRemoval) {
		this.clothesRemoval = clothesRemoval;
	}

	public String getSEP() {
		return SEP;
	}	
}

	
