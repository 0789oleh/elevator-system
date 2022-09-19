package com.java.elevator;

public class Passenger {
	
	private int destinationFloor;
	private int currentFloor;
	

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloror(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	public boolean arrived() {
		return currentFloor == destinationFloor;
	}
	
	public boolean lower() {
		return currentFloor < destinationFloor;
	}
	
	public boolean higher() {
		return currentFloor > destinationFloor;
	}

}
