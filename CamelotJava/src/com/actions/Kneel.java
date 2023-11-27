package com.actions;

import com.entities.Character;

public class Kneel implements IAction {
	Character character;
	boolean died;
	public Kneel(Character c) {
		this.character =c;
		this.died = true;
	}
	public Kneel(Character c, boolean d) {
		this.character = c;
		this.died = d;
	}
	@Override
	public String getName() {
		if (died){// TODO Auto-generated method stub
			return "Kneel";
		}
		else {
			return"Revive";
		}
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(),character.getName());
	}
}
