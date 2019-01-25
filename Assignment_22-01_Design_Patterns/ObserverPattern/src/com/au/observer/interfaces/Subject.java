package com.au.observer.interfaces;

public interface Subject {
	public void regObserver(Observer o);
	public void unregObserver(Observer o);
	public void notifyObservers();
}
