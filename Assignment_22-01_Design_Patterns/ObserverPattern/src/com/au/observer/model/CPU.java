package com.au.observer.model;
import java.util.ArrayList;
import java.util.List;

import com.au.observer.interfaces.Observer;
import com.au.observer.interfaces.Subject;

public class CPU implements Subject {
	boolean startup;
	List<String> drivers;
	
	List<Observer> observers;

	public CPU() {
		drivers = new ArrayList<String>();
		drivers.add("display");
		drivers.add("keyboard");
		
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void regObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		int i = 0;
		for(Observer o: observers) {
			o.updateDevice(drivers.get(i++));
		}
	}
	
	public void cpuStartup() {
		startup = true;
		System.out.println("CPU started\n");
		
		notifyObservers();
	}
}
