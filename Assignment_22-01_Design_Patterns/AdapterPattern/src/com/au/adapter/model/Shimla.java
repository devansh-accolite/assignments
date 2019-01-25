package com.au.adapter.model;
import com.au.adapter.adapter.NationalTour;

public class Shimla implements NationalTour {
	@Override
	public String getTransportMode() {
		return "Air";
	}

	@Override
	public int getDuration() {
		return 7;
	}

	@Override
	public int getDailyCost() {
		return 150;
	}

	@Override
	public String getName() {
		return "Shimla";
	}
}
