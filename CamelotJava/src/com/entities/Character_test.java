package com.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.entities.Things.ThingNames;

class Character_test {

	@Test
	void testget() {
		var tom = new Character(ThingNames.Tom);
		var test = tom.get();
		assertEquals(test,tom);
	}

}
