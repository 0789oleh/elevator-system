package com.java.elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Elevator {
	
	private static final int MAX_NUMBER_OF_PASSSENGERS = 5;
	private int numberOfPassengers;
	private int currentFloor;
	private List<Passenger> passengers = new LinkedList<>();
	private List<Floor> floors = new ArrayList<>();
	private Floor floor;
	private static final Logger LOGGER = Logger.getLogger(Elevator.class.getName());
	
	public Elevator(List<Floor> floors) {
		this.floors = floors;
	}
	
	public void addPassenger() {
		if (numberOfPassengers >= MAX_NUMBER_OF_PASSSENGERS) {
			return;
		}
		Passenger pass = floor.removeWaitingPassenger();
		passengers.add(pass);
		numberOfPassengers++;
	}
	
	public void removePassenger(Passenger pass) {
		passengers.remove(pass);
		numberOfPassengers--;
		floor.addWaitingPassenger(pass);
	}
	
	public void moveUp() {
		Optional<Passenger> destinationFloors = passengers.stream().
				filter(p->p.lower()).findAny();
		while(destinationFloors.isPresent()) {
			currentFloor++;
			floor = floors.get(currentFloor);
			for (Passenger pass : passengers ) {
				if (pass.getDestinationFloor() == currentFloor) {
					removePassenger(pass);
				}
			}			
			while(numberOfPassengers < MAX_NUMBER_OF_PASSSENGERS && floor.hasPassengers()) {
				addPassenger();
			}
			LOGGER.info("Current floor" + currentFloor);
			LOGGER.info("Passengers in elevatror: " + numberOfPassengers + " | destination floors: " + 
			floor.getPassengers().stream().
			mapToInt(p->p.getDestinationFloor())
			.toArray());
		}
	}
	
	public void moveDown() {
		
		Optional<Passenger> destinationFloors = passengers.stream().
				filter(p->p.lower()).findAny();
		while(destinationFloors.isPresent()) {
			currentFloor++;
			floor = floors.get(currentFloor);
			for (Passenger pass : passengers ) {
				if (pass.getDestinationFloor() == currentFloor) {
					removePassenger(pass);
				}
			}			
			while(numberOfPassengers < MAX_NUMBER_OF_PASSSENGERS && floor.hasPassengers()) {
				addPassenger();
			}
			LOGGER.info(() -> "Current floor " + currentFloor);
			LOGGER.info(() -> "Passengers in elevatror: "+ numberOfPassengers);
			LOGGER.info(() -> "destination floors: " +
					floor.getPassengers().stream().
			mapToInt(p->p.getDestinationFloor())
			.toArray());
		}
	}

}
