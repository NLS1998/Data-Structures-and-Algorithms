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
		Scanner scan = new Scanner(System.in);
		outputCrimes(stopList);
		String choice = "";

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

				System.out.println("Search Categories.\n");
				for (int i = 0; i < stopListArray.size(); i++) {
					for (int j = i + 1; j < stopListArray.size(); j++) {
						if (stopListArray.get(i).tocsvString().equals(stopListArray.get(j).tocsvString())) {
							stopListArray.remove(j);
							j--;
						}
					}

					System.out.println("Object of Search =   " + stopListArray.get(i).tocsvString());
				}
				System.out.println("\n** Please enter the object search name you would like to view data on **");
				Scanner scanner = new Scanner(System.in);
				String scans = scanner.nextLine();
//				choice = scanner.next().toUpperCase();
				boolean isExists = false;
				
				for(int counter = 0; counter < stopListArray.size(); counter++) {
					for (int j = counter + 1; j < stopListArray.size(); j++) {
					if (stopListArray.get(counter).getObjectSearch().equals(scans)) {
						isExists = true; 
						j--;
						break;
					}	
					
					
						System.out.println("Object of Search =   " + stopListArray.get(counter).DatatoCSVString());
					}
				}
				
			}
				

//			case "2": {
//				System.out.println("Search Categories.\n");
//				for (int i = 0; i < stopListArray.size(); i++) {
//					for (int j = i + 1; j < stopListArray.size(); j++) {
//						if (stopListArray.get(i).tocsvString().equals(stopListArray.get(j).tocsvString())) {
//							stopListArray.remove(j);
//							j--;
//						}
//					}
//
//					System.out.println("Object of Search =   " + stopListArray.get(i).tocsvString());
//					System.out.println("\n** Object of Search Choice **");
//					System.out.println("1 - Offensive weapons");
//					System.out.println("2 - Controlled drugs");
//					System.out.println("3 - Article for use in theft");
//					System.out.println("4 - Firearms");
//					System.out.println("5 - Evidence of offences under the Act");
//					System.out.println("6 - Fireworks");
//					System.out.println("7 - Crossbows");
//					System.out.println("8 - Goods on which duty has not been paid etc");
//					System.out.println("Q - Quit");
//					System.out.print("Pick : ");
//					
//					choice = scan.next().toUpperCase();
//					
//					switch (choice) {
//					case "1": {
//
//						for (int a = 1; a < stopListArray.size(); a++) {
//							for (int b = a; b > 0; b--) {
//								Stop lower = stopListArray.get(b - 1);
//								Stop higher = stopListArray.get(b);
//								if (higher.getObjectSearch().compareTo(lower.getObjectSearch()) < 0) {
//									stopListArray.set(b, lower);
//									stopListArray.set(b - 1, higher);
//								} else
//									break;
//							}
//							
//							
//							System.out.println("Object of Search =   " + stopListArray.get(a).DatatoCSVString());
//							//NEED TO COMPARE THIS AGAINST THE STRING OFFENSIVE WEAPONS TO IT ONLY PRINTS RELEVANT DATA.
//						}
//						
//						
//
//				}
//			}
//				}
//			}

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
