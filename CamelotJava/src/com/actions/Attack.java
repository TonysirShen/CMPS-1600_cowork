package com.actions;
import com.entities.Character;

public class Attack implements IAction {
	private Character character;
	private Character other;
	
	public Attack(Character c, Character o) {
		this.character = c;
		this.other = o;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Attack";
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
