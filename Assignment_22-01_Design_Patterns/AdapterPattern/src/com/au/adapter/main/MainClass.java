package com.au.adapter.main;
import com.au.adapter.adapter.InternationalTour;
import com.au.adapter.adapter.NationalTourAdapter;
import com.au.adapter.model.Goa;
import com.au.adapter.model.London;
import com.au.adapter.model.Shimla;
import com.au.adapter.model.Switzerland;
import com.au.adapter.model.TourCost;

public class MainClass {
	public static void main(String[] args) {
		TourCost tourCost = new TourCost();
		
		System.out.println("Adding tours...\n");
		
		tourCost.addTour(new Switzerland());
		tourCost.addTour(new London());
		tourCost.addTour(new NationalTourAdapter(new Shimla()));
		tourCost.addTour(new NationalTourAdapter(new Goa()));
		
		System.out.println("Tour list...");
		for(InternationalTour it: tourCost.getList()) {
			System.out.println(it.getName());
		}
		System.out.println();
		
		System.out.println("Calculating costs...");
		tourCost.calcCost();
	}
}
