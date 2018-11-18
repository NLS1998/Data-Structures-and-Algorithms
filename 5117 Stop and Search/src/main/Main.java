package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		CSVReader reader = new CSVReader();// reads csvreader class
		LinkedList<Stop> stopList = reader.createList();// Creates List
		ArrayList<Stop> stopListArray = new ArrayList<>(stopList);// Converts stopList to array.
		ArrayList<Stop> stopListArrays = new ArrayList<>(stopList);
		Scanner scan = new Scanner(System.in);
		outputCrimes(stopList);
		String choice = "";
		String choices = "";

		do {
			System.out.println("\n** MAIN MENU **");
			System.out.println("1 - Object Of Search");
			System.out.println("2 - Choose Object Of Search Data To View.");
			System.out.println("3 - Lsoa Name");
			System.out.println("Q - Quit");
			System.out.print("Pick : ");

			choice = scan.next().toUpperCase();

			switch (choice) {
			case "1": { // loops through StopListArray and compares duplicates, if duplicate is found it
						// is removed.

				System.out.println("\n Search Categories.\n");
				for (int i = 0; i < stopListArray.size(); i++) {
					for (int j = i + 1; j < stopListArray.size(); j++) {
						if (stopListArray.get(i).tocsvString().equals(stopListArray.get(j).tocsvString())) {
							stopListArray.remove(j);
							stopListArray.remove(null);
							j--;
						}
					}

					System.out.println("** " + stopListArray.get(i).tocsvString());
				}
				System.out.println("\n** Please enter the object of search name you would like to view data on **\n");
				Scanner scans = new Scanner(System.in);
				choices = scans.nextLine();
				boolean listContainsInput = false;
				
			    for  (int counter = 0; counter < stopListArrays.size(); counter++){  
			        if (choices.equals(stopListArrays.get(counter).getObjectSearch())){
			            listContainsInput = true;
			        
			    }
			    if(listContainsInput) {
			        System.out.println("** " + stopListArrays.get(counter).DatatoCSVString()); //if statments works but when a string is found prints everything instead of just objectSearch
			        																		   //data relating to the entered search name...
			    } else {
			        System.out.println("Incorrect");
			    }
			}
			}

			case "2": {
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
