package com.au.adapter.model;
import com.au.adapter.adapter.NationalTour;

public class Goa implements NationalTour {
	@Override
	public String getTransportMode() {
		return "Train";		
	}

	@Override
	public int getDuration() {
		return 10;
	}

	@Override
	public int getDailyCost() {
		return 200;
	}

	@Override
	public String getName() {
		return "Goa";
	}
}
