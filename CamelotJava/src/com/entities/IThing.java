package com.entities;

public interface IThing<T> {
	public enum ThingNames{
		/* Characters*/jojo,guard,king,blacksmith,warlock,bandit1,bandit2,bandit3,tom, merchant, beggar,
		/* Items*/sword,helmet,Greenpotion, Bluecloth, Coin,
		/*Places*/home,city,camp,castlecrossroad,GreatHall,Spookypath,jail, Port,Ruins,BShouse
	} 
	public String getName();
	public T getTemplate();
}
