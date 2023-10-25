package com.actions; 
import com.entities.*;
import com.entities.Character;

public class Give implements IAction {
	private Character character;
	private Item item;
	private Character other;
	
	public Give(Character character, Item item, Character other) {
		this.character = character;
		this.item = item;
		this.other = other;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Give";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String toString() {
		return String.format("%s(%s,%s,%s)", getName(), character.getName(), item.getName(), other.getName());
	}
	

}
