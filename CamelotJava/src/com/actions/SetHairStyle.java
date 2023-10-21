package com.actions;

import com.entities.Character;
import com.entities.Character.HairStyle;


public class SetHairStyle implements IAction{
	private Character character;
	private HairStyle hairstyle;
	@Override
	public String getName() {
		return "SetHairStyle";
	}
	@Override
	public boolean getShouldWait() { 
		return false;
	}
	public SetHairStyle(Character c) {
		this.character = c;
		this.hairstyle = c.getHairStyle();
	}
	public SetHairStyle(Character c, HairStyle HS) {
		this.character = c;
		this.hairstyle = HS;
	}
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), hairstyle.toString());
	}
}
