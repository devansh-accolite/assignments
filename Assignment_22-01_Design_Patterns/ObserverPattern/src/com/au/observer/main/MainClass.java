package com.au.observer.main;
import com.au.observer.model.CPU;
import com.au.observer.model.Keyboard;
import com.au.observer.model.Monitor;

public class MainClass {
	public static void main(String args[]) {
		CPU cpu = new CPU();

		Monitor monitor = new Monitor();
		Keyboard keyboard = new Keyboard();
		
		cpu.regObserver(monitor);
		cpu.regObserver(keyboard);
		
		cpu.cpuStartup();
	}
}
