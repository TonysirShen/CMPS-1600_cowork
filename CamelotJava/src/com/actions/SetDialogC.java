package com.actions;

import com.entities.Character;

public class SetDialogC implements IAction {
	Character character;
	String position;
	public SetDialogC(Character c, String s) {
		this.character = c;
		this.position = s;
	}
	@Override
	public String getName() {
		if (position.equals("left") || position.equals("Left")) {
			return "SetLeft";
		}
		else {
		return "SetRight";
		}
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	public String toString() {
		return String.format("%s(%s)", getName(), character.getName());
	}
}
