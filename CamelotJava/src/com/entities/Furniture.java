package com.entities;

public class Furniture implements IEntity{
	private String furniture_name;

	
	
	public void setName(String name) {
		this.furniture_name = name;
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return furniture_name;
	}
}
