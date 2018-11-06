package main;

public enum EnumEthnicity {
	WHITE("White"),
	BLACK("Black"),
	ASIAN("Asian"),
	OTHER("Other"),
	BLANK("");
	private final String str;
	private EnumEthnicity(String aStr) {
	this.str = aStr;
	}
	public String toString() {
	return this.str;
	}
	
	public static EnumEthnicity getFrom(String aStr) {
		for (EnumEthnicity r : EnumEthnicity.values())
		if (r.str.equals(aStr))
		return r;
		throw new IllegalArgumentException("No Specified Ethnicity");
	}
}
// Fail-Safe

