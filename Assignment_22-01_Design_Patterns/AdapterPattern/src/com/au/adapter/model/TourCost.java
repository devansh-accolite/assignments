package com.au.adapter.model;
import java.util.ArrayList;
import java.util.List;

import com.au.adapter.adapter.InternationalTour;

public class TourCost {
	static List<InternationalTour> list = new ArrayList<>();

	public void addTour(InternationalTour it) {
		list.add(it);
	}

	public List<InternationalTour> getList() {
		return list;
	}
	
	public void calcCost() {
		for (InternationalTour it : list) {
			System.out.println(it.getCurrencyRate() * it.getDailyCost());
		}
	}
}
