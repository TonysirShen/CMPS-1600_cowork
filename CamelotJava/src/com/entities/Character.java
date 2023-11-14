package com.entities;

import com.entities.IThing.ThingNames;

public class Character implements IEntity, IThing<Character.BodyTypes>{
	private String name;
	protected BodyTypes bodyType = BodyTypes.A;
	public enum BodyTypes{A,B,C,D,E,F,G,H};
	private Clothing clothing = Clothing.Peasant;
	public enum Clothing{Bandit,Beggar,LightArmour,HeavyArmour,Merchant,Noble,Peasant,Priest, Naked, King,Warlock, };
	private HairStyle hairStyle = HairStyle.Short;
	public enum HairStyle{Long,Spiky,Short,Short_Full,Ponytail_ACEG,Straight_aceg,Mage, Mage_Beard, Mage_Full    };
	
	//Constructors
	public Character(String name) {
	    this(name, BodyTypes.A);
	}

	public Character(String name, BodyTypes bodyType) {
	    this(name, bodyType, null);
	}

	public Character(String name, BodyTypes bodyType, Clothing clothing) {
	    this(name, bodyType, clothing, null);
	}

	public Character(String name, BodyTypes bodyType, Clothing clothing, HairStyle hairStyle) {
	    this.name = name;
	    this.bodyType = bodyType;
	    this.clothing = clothing;
	    this.hairStyle = hairStyle;
	}
	
	public Character(ThingNames name) {
		this(name.toString(),null);
	}
		// TODO Auto-generated constructor stub

	//interface methods
	@Override
	public BodyTypes getTemplate() {
		return bodyType;
	}

	@Override
	public String getName() {
		return name;
	}
	

	public HairStyle getHairStyle() {
		// TODO Auto-generated method stub
		return this.hairStyle;
	}

	public Clothing getClothing() {
		// TODO Auto-generated method stub
		return this.clothing;
	}
}
