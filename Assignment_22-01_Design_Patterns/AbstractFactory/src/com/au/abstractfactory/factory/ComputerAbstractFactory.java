package com.au.abstractfactory.factory;
import com.au.abstractfactory.model.Computer;

public abstract class ComputerAbstractFactory {
	public abstract Computer getComputer(Computer.NAME computerName);
}
