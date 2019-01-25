package com.au.abstractfactory.model;

public interface Computer {
	public static enum TYPE { DESKTOP, LAPTOP };
	public static enum NAME { HP, DELL };
	
	public NAME getCompany();
	public TYPE getType();
	public String getDesc();
}
