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

	// Got this part in for task C however cannot get the successful part to work
	// It constantly says that it cannot convert from an Enum to a boolean
	// However it is the True or False value from the data we need to sort this part

	// TODO: Counts are wrong??

	private static void outputCrimes(List<Stop> stopList) {
		int successful = 0, partSuccessful = 0, unsuccessful = 0, invalid = 0;
		for (int i = 0; i < stopList.size(); i++) {
			Stop currentCrime = stopList.get(i);
			if (currentCrime != null) {
				if (currentCrime.getOutcome()
						.matches("(Suspect|Offender|Local|Article|Arrest|Khat|Penalty|Community|Summons|Caution).*")
						&& currentCrime.getOutcomeObjectSearch() == true) { // If outcome was related to object of
																			// search, then it was a successful stop.
					successful++;
				} else if (currentCrime.getOutcome()
						.matches("(Suspect|Offender|Local|Article|Arrest|Khat|Penalty|Community|Summons|Caution).*") 
						&& currentCrime.getOutcomeObjectSearch() == false) { // If the outcome WASNT 'Nothing
																			 // found' AND the outcome wasn't
																			// equal to the object of
												 							// search, partial success.
					partSuccessful++;
				} else if (currentCrime.getOutcome().matches("(A no further action disposal|Nothing found).*")
						&& currentCrime.getOutcomeObjectSearch() != true || false) { // If nothing was found and no
																					 // further
																					 // action was taken, it was
																					 // unsuccessful.
					unsuccessful++;
				} else {
					invalid++;
				}
			}
		}
		String stars = "*****||******************************************************************||";
		System.out.println("        THERE ARE " + stopList.size() + " RECORDED CRIMES! ");
		System.out.println(stars);
		System.out.println(successful + "  || Were successful and related to stop");
		System.out.println(stars);
		System.out.println(partSuccessful + "  || Were partially successful and not related to stop");
		System.out.println(stars);
		System.out.println(unsuccessful + " || Were unsuccessful");
		System.out.println(stars);
		System.out.println(invalid + "   || Were null");
		System.out.println(stars);
	}
}
