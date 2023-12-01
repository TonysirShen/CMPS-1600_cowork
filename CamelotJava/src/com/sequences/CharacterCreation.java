package com.sequences;

import com.actions.*;
import com.entities.Character;

public class CharacterCreation extends ActionSequence{
	public CharacterCreation(Character character) {
		add(new Create<Character>(character));
		add(new SetClothing(character));
		if(character.getHairStyle() != null) {
		add(new SetHairStyle(character));
		}
	}
}
