package com.entities;

public interface IThing<T> {
	public enum ThingNames{Tom, Home, Sword} 
	public String getName();
	public T getTemplate();
}
