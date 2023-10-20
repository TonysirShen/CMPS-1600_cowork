package com.entities;

import com.entities.Things.ThingNames;

public class Character implements IEntity, IThing<Character.BodyTypes>{
	private ThingNames name;
	protected BodyTypes bodyType;
	public enum BodyTypes{A,B,C,D,E,F,G,H};
	private Clothing clothing;
	public enum Clothing{Bandit,Beggar,LightArmour,HeavyArmour,Merchant,Noble,Peasant,Priest};
	private HairStyle hairStyle;
	private enum HairStyle{Long,Spiky,Short};
	
	//Constructor
	public Character(String name) {
	    this(name, null);
	}

	public Character(String name, BodyTypes bodyType) {
	    this(name, bodyType, null);
	}

	public Character(String name, BodyTypes bodyType, Clothing clothing) {
	    this(name, bodyType, clothing, null);
	}

	public Character(ThingNames name, BodyTypes bodyType, Clothing clothing, HairStyle hairStyle) {
	    this.name = name;
	    this.bodyType = bodyType;
	    this.clothing = clothing;
	    this.hairStyle = hairStyle;
	    Things.add(ThingNames.(this.name), this);
	}
	
	public Character(ThingNames name) {
		this(name.toString(),null);
	}
		// TODO Auto-generated constructor stub
	}

	//interface methods
	@Override
	public BodyTypes getTemplate() {
		return bodyType;
	}

	@Override
	public String getName() {
		return name;
	}
	public Character get() {
		try {
			return (Character)(Things.get(ThingNames.(this.name)).get());	
			
	}
		catch(Exception e) {
			return null;
		}
}
