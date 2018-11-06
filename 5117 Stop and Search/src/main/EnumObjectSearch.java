package main;

public enum EnumObjectSearch {
	ArticleForUseInTheft("Article for use in theft"),
	ArticleForUseInCriminalDamage("Articles for use in criminal damage"),
	Firearms("Firearms"),
	EvidenceAct("Evidence of offences under the Act"),
	ControlledDrugs("Controlled drugs"),
	OffensiveWeapons("Offensive weapons"),
	StolenGoods("Stolen goods"),
	Crossbow("Crossbows"),
	Fireworks("Fireworks"),
	GoodsNotPaid("Goods on which duty has not been paid etc."),
	Blank("");// Fail-Safe
	private final String str;
	private EnumObjectSearch(String aStr) {
	this.str = aStr;
	}
	public String toString() {
	return this.str;
	}
	
	public static EnumObjectSearch getFrom(String aStr) {
		for (EnumObjectSearch r : EnumObjectSearch.values())
		if (r.str.equals(aStr))
		return r;
		throw new IllegalArgumentException("Nothing Found");
	}
}
