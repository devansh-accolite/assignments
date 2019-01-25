package com.au.abstractfactory.main;
import com.au.abstractfactory.factory.ComputerAbstractFactory;
import com.au.abstractfactory.factory.FactoryProducer;
import com.au.abstractfactory.model.Computer;

public class MainClass {
	public static void main(String[] args) {
		ComputerAbstractFactory laptopFactory = FactoryProducer.getFactory(Computer.TYPE.LAPTOP);
		
		Computer hpLaptop = laptopFactory.getComputer(Computer.NAME.HP);
		System.out.println(hpLaptop.getDesc());
		
		Computer dellLaptop = laptopFactory.getComputer(Computer.NAME.DELL);
		System.out.println(dellLaptop.getDesc());
		
		ComputerAbstractFactory desktopFactory = FactoryProducer.getFactory(Computer.TYPE.DESKTOP);
		
		Computer hpDesktop = desktopFactory.getComputer(Computer.NAME.HP);
		System.out.println(hpDesktop.getDesc());
		
		Computer dellDesktop = desktopFactory.getComputer(Computer.NAME.DELL);
		System.out.println(dellDesktop.getDesc());
	}
}
