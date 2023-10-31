package com.actions;

import com.entities.Character;

public class Die implements IAction {
	Character character;
	
	public Die(Character c) {
		this.character =c;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Die";
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
