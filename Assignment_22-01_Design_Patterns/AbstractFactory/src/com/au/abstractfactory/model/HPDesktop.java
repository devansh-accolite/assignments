package com.au.abstractfactory.model;
public class HPDesktop implements Computer {

	@Override
	public NAME getCompany() {
		return Computer.NAME.HP;
	}

	@Override
	public TYPE getType() {
		return Computer.TYPE.DESKTOP;
	}

	@Override
	public String getDesc() {
		return "This is a HP desktop\n";
	}
}
