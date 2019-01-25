package com.au.abstractfactory.model;
public class DellLaptop implements Computer {

	@Override
	public NAME getCompany() {
		return Computer.NAME.DELL;
	}

	@Override
	public TYPE getType() {
		return Computer.TYPE.LAPTOP;
	}

	@Override
	public String getDesc() {
		return "This is a Dell laptop\n";
	}

}
