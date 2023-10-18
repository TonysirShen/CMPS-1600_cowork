package com.entities;

import com.entities.Things.ThingNames;

public class Item implements IEntity, IThing<Item.Items>{
	private String name;
	private Items template;
	public enum Items{SpellBook,Sword,Torch,Scroll,LitTorch,Helmet}
	// constructor
	public Item(){}
	public Item(String name, Items input) {
		this.name = name;
		this.template = input;
	}
	public Item(ThingNames name, Items input) {
		this.name = name.toString();
		this.template = input;// TODO Auto-generated constructor stub
	}
	// Interface methods
	@Override
	public Items getTemplate() {
		return template;
	}
	@Override 	
	public String getName() {
		return name;
	}
	
}
