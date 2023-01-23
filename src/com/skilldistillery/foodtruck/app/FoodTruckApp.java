package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.Foodtruck;

public class FoodTruckApp {
	// fleet of food trucks
	private Foodtruck[] fleet;
	private int MAX_TRUCKS = 5;
	private int numberOfTrucks;

	public FoodTruckApp() {
		fleet = new Foodtruck[MAX_TRUCKS];
		numberOfTrucks = 0;
	}

	public void startApp() {
		Scanner input = new Scanner(System.in);

		// Loop to prompt user for food truck info *User story 1
		while (numberOfTrucks < MAX_TRUCKS) {
			System.out.println("Enter a food truck name or type 'quit' to exit app:");

			String truckName = input.nextLine();
			if (truckName.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("Enter the truck's food type:");
			String foodType = input.nextLine();
			System.out.println("Enter a rating from 0 to 5");
			int starRating = input.nextInt();
			input.nextLine();
			// Instantiate a new truck
			Foodtruck truckBeingAdded = new Foodtruck(truckName, foodType, starRating);
			fleet[numberOfTrucks++] = truckBeingAdded;
		}
//Loop for menu options
		while (true) {
			System.out.println("Make a selection:");
			System.out.println("Enter 1 to list food trucks");
			System.out.println("Enter 2 to show average rating for all food trucks");
			System.out.println("Enter 3 to show highest-rated food truck");
			System.out.println("Enter 4 to quit program");

			int num = input.nextInt();
			
			switch (num) {
			case 1:
				truckList();
				break;
			case 2:
				displayAverageRating();
				break;
			case 3:
				displayHighestRatedTruck();
				break;
			case 4:
				System.out.println("Closing program now");
				return;
			default:
				System.out.println("Try again");

				input.close();
			}

	}
	}

	// List of food trucks method
	private void truckList() {
		for (int i = 0; i < numberOfTrucks; i++) {
			System.out.println(fleet[i]);
		}
	}

	// Calculate average method
	// Display average rating for trucks
	private void displayAverageRating() {
		int totalStarRating = 0;
		for (int i = 0; i < numberOfTrucks; i++) {
			totalStarRating += fleet[i].getStarRating();
		}
		double averageStars = totalStarRating / numberOfTrucks;
		System.out.println("Average rating for all trucks: " + averageStars);
	}

	// Highest rated truck method
	private void displayHighestRatedTruck() {
		Foodtruck highestRated = fleet[0];
		for (int i = 1; i < numberOfTrucks; i++) {
			if (fleet[i].getStarRating() > highestRated.getStarRating()) {
				highestRated = fleet[i];
			}
		}
		System.out.println("Highest Rated Food Truck: " + highestRated);

	}

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.startApp();
	}
}
