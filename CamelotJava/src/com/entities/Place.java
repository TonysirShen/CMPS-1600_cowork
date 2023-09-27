package com.entities;

public class Place implements IThing<Place.Places> {
	private String place_name;
	private Places template; 
	enum Places {AlchemyShop,Blacksmith,Bridge,Camp,CastleBedroom,CastleCrossroads,City,Cottage,Courtyard};
	
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
