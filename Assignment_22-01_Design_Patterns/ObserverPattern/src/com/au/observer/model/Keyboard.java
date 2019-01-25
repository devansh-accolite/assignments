package com.au.observer.model;
import java.util.Date;

import com.au.observer.interfaces.Observer;

public class Keyboard implements Observer {
	@Override
	public void updateDevice(String driver) {
		System.out.println("Loaded " + driver + " driver...\nKeyboard started at " + new Date().getTime() + "\n");	
	}
}
