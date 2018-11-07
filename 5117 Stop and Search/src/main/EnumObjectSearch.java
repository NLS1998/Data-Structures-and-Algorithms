package main;

import java.util.HashSet;
import java.util.LinkedList;

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
	public LinkedList objectSearch;
	private EnumObjectSearch(String aStr) {
	this.str = aStr;
	}
	public String toString() {
	return this.str;
	}
	
//	HashSet<String> set = new HashSet<String>(); 
//	LinkedList current = objectSearch; 
//	while (current != null && !set.contains(current.data)) 
//	{ set.add(current.data); 
//	current = current.next; 
//	} 
//	return current;
	
	public static EnumObjectSearch getFrom(String aStr) {
		for (EnumObjectSearch r : EnumObjectSearch.values())
		if (r.str.equals(aStr))
		return r;
		throw new IllegalArgumentException("Nothing Found");
	}
	
}
