package com.entities;

import com.entities.IThing.ThingNames;

public class Place implements IThing<Place.Places> {
	private String place_name;
	private Places template; 
	public enum Places {Cottage,City,Camp,CastleCrossroads,GreatHall,SpookyPath,Dungeon,Ruins,Port, Blacksmith};
	
	public Place(ThingNames name, Places template) {
		this.place_name = name.toString();
		this.template = template;// TODO Auto-generated constructor stub
	}

	public void Place(String name, Places template) {
		this.place_name = name;
		this.template = template;
	}

	@Override
	public String getName() {
		return place_name;
	}

	@Override
	public Places getTemplate() {
		return template;
	}
	public Furniture getFurniture(String furniture) {
		Furniture Furn_1 = new Furniture();
		Furn_1.setName(this.place_name + "." + furniture);
		return Furn_1;
		
	}
	
}
