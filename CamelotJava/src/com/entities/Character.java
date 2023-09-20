package com.entities;

public class Character implements IEntity, IThing{
	private String name;
	private BodyType bodyType;
	private enum BodyType{A,B,C,D,E,F,G,H};
	private Clothing clothing;
	private enum Clothing{Bandit,Beggar,LightArmour,HeavyArmour,Merchant,Noble,Peasant,Priest};
	private HairStyle hairStyle;
	private enum HairStyle{Long,Spiky,Short};
	
	//Constructor
	public Character(String name) {
	    this(name, null);
	}

	public Character(String name, BodyType bodyType) {
	    this(name, bodyType, null);
	}

	public Character(String name, BodyType bodyType, Clothing clothing) {
	    this(name, bodyType, clothing, null);
	}

	public Character(String name, BodyType bodyType, Clothing clothing, HairStyle hairStyle) {
	    this.name = name;
	    this.bodyType = bodyType;
	    this.clothing = clothing;
	    this.hairStyle = hairStyle;
	}
	
	//interface methods
	@Override
	public BodyType getTemplate() {
		// TODO Auto-generated method stub
		return bodyType;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
