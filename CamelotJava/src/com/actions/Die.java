package com.actions;

import com.entities.Character;

public class Die implements IAction {
	Character character;
	boolean died;
	public Die(Character c) {
		this.character =c;
		this.died = true;
	}
	public Die(Character c, boolean d) {
		this.character = c;
		this.died = d;
	}
	@Override
	public String getName() {
		if (died){// TODO Auto-generated method stub
			return "Die";
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
