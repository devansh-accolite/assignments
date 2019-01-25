package com.au.adapter.model;
import com.au.adapter.adapter.InternationalTour;

public class Switzerland implements InternationalTour {
	@Override
	public double getCurrencyRate() {
		return 70;
	}

	@Override
	public int getDuration() {
		return 10;
	}

	@Override
	public int getDailyCost() {
		return 75;
	}

	@Override
	public String getName() {
		return "Switzerland";
	}
}
