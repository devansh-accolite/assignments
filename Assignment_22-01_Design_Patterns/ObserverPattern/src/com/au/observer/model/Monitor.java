package com.au.observer.model;
import java.util.Date;

import com.au.observer.interfaces.Observer;

public class Monitor implements Observer {
	@Override
	public void updateDevice(String driver) {
		System.out.println("Loaded " + driver + " driver...\nMonitor started at " + new Date().getTime() + "\n");	
	}
}
