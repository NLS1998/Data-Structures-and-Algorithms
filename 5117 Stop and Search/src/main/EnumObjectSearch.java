package main;

public enum EnumObjectSearch {
	ArticleForUseInTheft("Theft"),
	ArticleForUseInCriminalDamage("Criminal Damage"),
	ControlledDrugs("Controlled Drugs"),
	OffensiveWeapons("Offensive Weapons"),
	StolenGoods("Stolen Goods");// Fail-Safe
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
		throw new IllegalArgumentException("No Specified Gender");
	}
}
