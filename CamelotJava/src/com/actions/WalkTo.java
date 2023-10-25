package com.actions;

import com.entities.Character;

public class WalkTo implements IAction {
	private Character character;
	private Character other;

	public WalkTo(Character character, Character other) {
		this.character = character;
		this.other = other;
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
		return String.format("%s(%s,%s)", getName(),character.getName(),other.getName());
	}

}
