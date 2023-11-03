package com.entities;

public interface IThing<T> {
	public enum ThingNames{
		/* Characters*/jojo,guard,king,blacksmith,warlock,bandit1,bandit2,bandit3,tom, merchant, beggar,
		/* Items*/sword,helmet,Greenpotion, Bluecloth, Coin,Hammer1,Hammer2,Hammer3,EvilBook,
		/*Places*/home,city,camp,castlecrossroad,GreatHall,Spookypath,jail, Port,Ruins,BShouse, guard2
	} 
	public String getName();
	public T getTemplate();
}
