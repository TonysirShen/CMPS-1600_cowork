package com.entities;

public interface IThing<T> {
	public enum ThingNames{
		/* Characters*/jojo,guard,king,blacksmith,warload,bandit,tom,
		/* Items*/sowrd,helmet,Greenpotion,
		/*Places*/home,city,camp,castlecrossroad,GreatHall,Spookypath,Dungeon 
	} 
	public String getName();
	public T getTemplate();
}
