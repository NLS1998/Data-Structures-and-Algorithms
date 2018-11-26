package main;

public class Stop extends Main {

	// COMMENTS ARE ON HOW TO SERIALIZE EACH DATA TYPE Position in csvParts List
	private final String SEP = ",";
	private String type; // 0
	private Date date; // Date class will have serialization method, use substrings. 1
	private String policingOperation; // 2
	private String policingOperationType; // 3
	private String latitude; // 4
	private String longitude; // 5
	private String gender;// 6
	private EnumAgeRange ageRange;// 7
	private String selfEthnicity;// 8
	private String ethnicity;// 9
	private String legislation; // 10
	private String objectSearch;// 11
	private String outcome;// 12
	private Boolean outcomeObjectSearch;// 13
	private String clothesRemoval;// 14
	
	Stop(String csvString) {// Serialises all read in data

		String[] csvParts = csvString.split(SEP, -1); // Returns an array
		int idx = 0;
		type = csvParts[idx++];
		date = new Date(csvParts[idx++]);
		policingOperation = csvParts[idx++];
		policingOperationType = csvParts[idx++];
		latitude = csvParts[idx++];
		longitude = csvParts[idx++];
		gender = csvParts[idx++];
		ageRange = EnumAgeRange.getFrom(csvParts[idx++]);
		selfEthnicity = csvParts[idx++];
		ethnicity = csvParts[idx++];
		legislation = csvParts[idx++];
		objectSearch = csvParts[idx++];
		outcome = csvParts[idx++];
		outcomeObjectSearch =  Boolean.parseBoolean(csvParts[idx++]);
		clothesRemoval = csvParts[idx++];
	}

	public String tocsvString() {

		return objectSearch; // Prints only Object Search column
	}
	
	public String csvString() {

		return legislation + SEP; // Prints only Object Search column
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getLegislation() {
		
		if(legislation.equals("")) {
			this.legislation = "No Legislation";
		}
		
		return legislation;
	}

	public void setLegislation(String legislation) {
		this.legislation = legislation;
	}

	public String getObjectSearch() {
		return objectSearch;
	}

	public void setObjectSearch(String objectSearch) {
		this.objectSearch = objectSearch;
	}

	public String getOutcome() {
		return outcome;
	}
	
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getClothesRemoval() {
		return clothesRemoval;
	}

	public void setClothesRemoval(String clothesRemoval) {
		this.clothesRemoval = clothesRemoval;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSEP() {
		return SEP;
	}		

	public Boolean getOutcomeObjectSearch() {
		// TODO Auto-generated method stub
		return outcomeObjectSearch;
	}
	public void setOutcomeObjectSearch(Boolean outcomeObjectSearch) {
		this.outcomeObjectSearch = outcomeObjectSearch;
	}
	public String DatatoCSVString() {
		return type + SEP + "Y:" + date.getYear() + " M:" + date.getMonth() + " D:" + date.getDay() + " Time - Hr:" + date.getHour() + " Mins:" + date.getMinutes() + " Secs:" + date.getSeconds() + SEP + policingOperation + SEP + policingOperationType + SEP + latitude + SEP + longitude + SEP
				+ gender + SEP + ageRange + SEP + selfEthnicity + SEP + ethnicity + SEP + legislation + SEP + objectSearch + SEP + outcome + SEP + outcomeObjectSearch + SEP + clothesRemoval;
	}
	}
