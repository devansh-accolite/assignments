package com.au.abstractfactory.model;
public class HPLaptop implements Computer {
	@Override
	public NAME getCompany() {
		return Computer.NAME.HP;
	}

	@Override
	public TYPE getType() {
		return Computer.TYPE.LAPTOP;
	}

	@Override
	public String getDesc() {
		return "This is a HP laptop\n";
	}
}
