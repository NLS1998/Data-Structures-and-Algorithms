package main;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		CSVReader reader = new CSVReader();// reads csvreader class
		LinkedList<Stop> stopList = reader.createList();// Creates List
		Scanner scan = new Scanner(System.in);
		outputCrimes(stopList);
		String choice = "";

		for (Stop stop : stopList) {

			do {
				System.out.println("\n** MAIN MENU **");
				System.out.println("1 - Object Of Search");
				System.out.println("2 - Last Outcome");
				System.out.println("3 - Lsoa Name");
				System.out.println("Q - Quit");
				System.out.print("Pick : ");

				choice = scan.next().toUpperCase();

				switch (choice) {
				case "1": { // Iterates through object search column and prints to String.
					for (int i = 1; i < stopList.size(); i++) {
						for (int j = i; j > 0; j--) {
							Stop lower = stopList.get(j - 1);
							Stop higher = stopList.get(j);
							if (higher.getObjectSearch().compareTo(lower.getObjectSearch()) < 0) {
								stopList.set(j, lower);
								stopList.set(j - 1, higher);
								System.out.println(stopList.get(j).tocsvString());
								;

							} else
								break;
						}
					}
				}
				case "2": {
					break;
				}
				case "3": {

					break;
				}
				}
			} while (!choice.equals("Q"));
			System.out.println("-- GOODBYE --");
		}
	}

	// Got this part in for task C however cannot get the successful part to work
	// It constantly says that it cannot convert from an Enum to a boolean
	// However it is the True or False value from the data we need to sort this part
	
	//TODO: Counts are wrong??
	
	private static void outputCrimes(List<Stop> stopList) {
		int successful = 0, partSuccessful = 0, unsuccessful = 0, invalid = 0;
		for (int i = 0; i < stopList.size(); i++) {
			Stop currentCrime = stopList.get(i);
			if (currentCrime != null) {
				System.out.println(currentCrime.getOutcomeObjectSearch());
				if (currentCrime.getOutcomeObjectSearch().toString() == "TRUE") { // If outcome was related to object of search, then it was a successful stop.
					successful++;
				}
				else if (currentCrime.getOutcome().equals("Nothing found - no further action")) { // If nothing was found and no further action was taken, it was unsuccessful.
					unsuccessful++;
				}
				else if (!(currentCrime.getOutcome().equals("Nothing found - no further action") && currentCrime.getOutcomeObjectSearch().toString() == "FALSE")) { // If the outcome WASNT 'Nothing found' AND the outcome wasn't equal to the object of search, partial success.
					partSuccessful++;
				}
				else {
					invalid++;
				}
			}
		}
		
		System.out.println("There are " + stopList.size() + " recorded crimes; ");
		System.out.println(successful + " were successful");
		System.out.println(partSuccessful + " were partially successful");
		System.out.println(unsuccessful + " were unsuccessful");
		if(invalid != 0) System.out.println(invalid + " have invalid enumerators!");
	}
	
}