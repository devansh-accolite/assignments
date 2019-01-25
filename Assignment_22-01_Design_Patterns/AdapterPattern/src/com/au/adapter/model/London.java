package com.au.adapter.model;
import com.au.adapter.adapter.InternationalTour;

public class London implements InternationalTour {
	@Override
	public double getCurrencyRate() {
		return 90;
	}

	@Override
	public int getDuration() {
		return 8;
	}

	@Override
	public int getDailyCost() {
		return 100;
	}

	@Override
	public String getName() {
		return "London";
	}
}
