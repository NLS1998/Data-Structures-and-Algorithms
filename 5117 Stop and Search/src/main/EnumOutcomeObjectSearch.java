package main;

public enum EnumOutcomeObjectSearch {
	True("True"),
	False("False"),
	Blank("N/A");
	private final String str;
	private EnumOutcomeObjectSearch(String aStr) {
	this.str = aStr;
	}
	public String toString() {
	return this.str;
	}
	
	public static EnumOutcomeObjectSearch getFrom(String aStr) {
		for (EnumOutcomeObjectSearch r : EnumOutcomeObjectSearch.values())
		if (r.str.equals(aStr))
		return r;
		throw new IllegalArgumentException("No Outcome");
	}
}