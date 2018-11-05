package main;

public enum EnumOutcome {
	ArticleFound("Found"),
	LocalResolution("Local Resolution"),
	DrugsWarning("Drugs Warning"),
	PenaltyNotice("Penalty Notice"),
	SuspectArrested("Suspect Arrested"),
	Court("Court");// Fail-Safe
	private final String str;
	private EnumOutcome(String aStr) {
	this.str = aStr;
	}
	public String toString() {
	return this.str;
	}
	
	public static EnumOutcome getFrom(String aStr) {
		for (EnumOutcome r : EnumOutcome.values())
		if (r.str.equals(aStr))
		return r;
		throw new IllegalArgumentException("No Outcome");
	}
}
