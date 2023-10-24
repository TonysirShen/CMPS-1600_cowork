package com.actions;

import com.entities.*;
import com.entities.Character;

public class Sleep implements IAction {
	private Character character;
	private Furniture bed;
	public Sleep(Character character, Furniture bed) {
		this.character = character;
		this.bed = bed;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return "Sleep";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s,%s)", getName(),character.getName(),bed.getName());
	}

}
