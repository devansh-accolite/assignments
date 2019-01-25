package com.au.abstractfactory.factory;
import com.au.abstractfactory.model.Computer;

public class FactoryProducer {
	public static ComputerAbstractFactory getFactory(Computer.TYPE computerType) {
		if(computerType == Computer.TYPE.LAPTOP) {
			return new LaptopFactory();
		}
		if(computerType == Computer.TYPE.DESKTOP) {
			return new DesktopFactory();
		}
		return null;
	}
}
