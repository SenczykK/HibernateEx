package com.senczyk.hibernateEx.colors;

import javax.persistence.Converter;

@Converter
public enum Color {
	RED("R"), GREEN("G"), BLUE("B");
	
	private String st;
	
	private Color(String s) {
		this.st = s;
	}
	
	public String getColor() {
		return this.st;
	}
	
}
