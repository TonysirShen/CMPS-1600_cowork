package com.actions;

import com.entities.Furniture;
import com.entities.Character;

public class OpenFurniture implements IAction {
	private Character character;
	private Furniture f;
	
	public OpenFurniture(Character c, Furniture f) {
		this.character = c;
		this.f = f;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Open Furniture";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s(%s,%s)", getName(),character.getName(),f.getName());
	}

	

}
