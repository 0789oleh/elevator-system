package com.java.elevator;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Floor {

	private int numberOfPassengers;
	private int level;
	private List<Passenger> passengers = new LinkedList<>();
	
	public Floor(int level) {
		this.level = level;
		// initializing passengers on the floor with floor
		numberOfPassengers = Main.getRandomNumber(0, 10);
		for(int i = 0; i < numberOfPassengers; ++i) {
			Passenger pass = new Passenger();
			passengers.add(pass);
		}
	}

	public void addWaitingPassenger(Passenger pass) {
		passengers.add(pass);
		numberOfPassengers++;
	}
	
	public boolean hasPassengers() {
		return !passengers.isEmpty();
	}
	
	public boolean hasLowerPassengers() {
		return passengers.stream().anyMatch(p->p.lower());
	}
	
	public boolean hasHigherPassengers() {
		return passengers.stream().anyMatch(p->p.higher());
	}

	public Passenger removeWaitingPassenger() {
		Passenger pass = passengers.stream().
				filter(p->!p.arrived()).findFirst().orElse(null);
		passengers.remove(pass);
		numberOfPassengers--;
		return pass;
	}
	
	public List<Passenger> getPassengers() {
		return passengers;
	}

	public int getLevel() {
		return level;
	}	
		
	@Override
	public int hashCode() {
		return level;
	}
	
	@Override
	public boolean equals(Object floor) {
		if (Objects.isNull(floor)) {
			return false;
		}
		return this.level == ((Floor) floor).getLevel();
	}
}
