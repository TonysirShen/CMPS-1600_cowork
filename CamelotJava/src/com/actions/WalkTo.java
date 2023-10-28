package com.actions;

import com.entities.Character;
import com.entities.Furniture;

public class WalkTo implements IAction {
	private Character character;
	private Character other;
	private Furniture furniture;
	public WalkTo(Character character, Character other) {
		this.character = character;
		this.other = other;
		// TODO Auto-generated constructor stub
	}

	public WalkTo(Character character, Furniture furniture) {
		this.character = character;
		this.furniture = furniture;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "WalkTo";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String toString() {
		if(furniture == null) {
			return String.format("%s(%s,%s)", getName(),character.getName(),other.getName());
		}
		else {
			return String.format("%s(%s,%s)", getName(),character.getName(),furniture.getName());
		}
	}

}
