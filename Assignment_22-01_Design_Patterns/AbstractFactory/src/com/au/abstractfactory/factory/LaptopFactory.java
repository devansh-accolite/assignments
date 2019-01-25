package com.au.abstractfactory.factory;
import com.au.abstractfactory.model.Computer;
import com.au.abstractfactory.model.DellLaptop;
import com.au.abstractfactory.model.HPLaptop;

public class LaptopFactory extends ComputerAbstractFactory {
	@Override
	public Computer getComputer(Computer.NAME computerName) {
		if(computerName == Computer.NAME.HP) {
			return new HPLaptop();
		}
		if(computerName == Computer.NAME.DELL) {
			return new DellLaptop();
		}
		return null;
	}
}
