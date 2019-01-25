package com.au.abstractfactory.factory;
import com.au.abstractfactory.model.Computer;
import com.au.abstractfactory.model.DellDesktop;
import com.au.abstractfactory.model.HPDesktop;

public class DesktopFactory extends ComputerAbstractFactory {
	@Override
	public Computer getComputer(Computer.NAME computerName) {
		if(computerName == Computer.NAME.HP) {
			return new HPDesktop();
		}
		if(computerName == Computer.NAME.DELL) {
			return new DellDesktop();
		}
		return null;
	}
}
