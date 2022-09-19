package com.java.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	static int getRandomNumber(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = getRandomNumber(5, 20);
		List<Floor> floors = new ArrayList<>();
		for(int i = 0; i < n; ++i) {
			Floor floor = new Floor(i);
			floors.add(floor);
		}
		Elevator elevator = new Elevator(floors);
	
		elevator.moveUp();
		elevator.moveDown();
		System.out.println("Finished succesfuly!");
	}

}
