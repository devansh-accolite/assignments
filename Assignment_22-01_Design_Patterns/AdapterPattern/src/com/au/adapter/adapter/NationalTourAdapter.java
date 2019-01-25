package com.au.adapter.adapter;

public class NationalTourAdapter implements InternationalTour {
	private NationalTour nationalTour;
	
	public NationalTourAdapter(NationalTour nationalTour) {
		super();
		this.nationalTour = nationalTour;
	}

	@Override
	public double getCurrencyRate() {
		return 1;
	}

	@Override
	public int getDuration() {
		return nationalTour.getDuration();
	}

	@Override
	public int getDailyCost() {
		return nationalTour.getDailyCost();
	}

	@Override
	public String getName() {
		return nationalTour.getName();
	}
}
