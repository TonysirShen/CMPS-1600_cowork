package com.actions;

import com.entities.*;
import com.entities.Character;

public class Sleep implements IAction {
	private Character character;
	private Furniture bed;
	@Override
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
		return false;
	}

}
