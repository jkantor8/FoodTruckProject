package com.skilldistillery.foodtruck.entities;

public class Foodtruck {
	private static int nextTruckId = 1;
	private int id;
	private String truckName;
	private String foodType;
	private int starRating;

	public Foodtruck() {

	}

	public Foodtruck(String truckName, String foodType, int starRating) {
		this.id = nextTruckId++;
		this.truckName = truckName;
		this.foodType = foodType;
		this.starRating = starRating;
	}

	public static int getNextTruckId() {
		return nextTruckId;
	}

	public static void setNextTruckId(int nextTruckId) {
		Foodtruck.nextTruckId = nextTruckId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}

	public String toString() {
		return "ID: " + id + ", Name: " + truckName + ", Food Type: " + foodType + ", Rating: " + starRating;
	}
}
