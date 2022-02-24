package com.sddevops.BookingAttraction;

import java.util.*;

public class AttractionCollection {
	

    private ArrayList<Attraction> attractions = new ArrayList<>();
    private int capacity;

    public AttractionCollection() {
    	/*attractions.add(new Attraction("0001","Universal Studios Singapore","This is a theme park","asdasdasda.png",55,"11:00-19:00 open daily","sentosa 123456"));
          attractions.add(new Attraction("0002","Singapore Zoo","This is a zoo","asdasdqweqwe.png",55,"11:00-21:00 open daily","mandai 123456"));;
          */

        this.capacity = 20;
    }

    public AttractionCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void addAttraction(Attraction attraction) {
    	if(attractions.size() != capacity) {
    		attractions.add(attraction);
    	}
    }
    
    public void deleteAttraction(Attraction attraction) {
    	if(attractions.size() != capacity) {
    		attractions.remove(attraction);
    	}
    }


}
