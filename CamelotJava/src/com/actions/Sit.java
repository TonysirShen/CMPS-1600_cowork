 package com.actions;

import com.entities.Character;
import com.entities.Furniture;

public class Sit implements IAction {
	private Character character;
	private Furniture seat;
	public Sit(Character c, Furniture f) {
		this.character = c;
		this.seat = f;
	}
	@Override
	public String getName() {
		return "Sit";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	public String toString() {
		return String.format("%s(%s,%s)", getName(),character.getName(),seat.getName());
	}
}
