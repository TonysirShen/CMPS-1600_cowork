package com.entities;

public class Item implements IEntity, IThing<Item.Items>{
	private String name;
	private Items template;
	enum Items{SpellBook,Sword,Torch,Scroll,LitTorch,Helmet}
	// constructor
	public Item(){}
	public Item(String name, Items input) {
		this.name = name;
		this.template = input;
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
