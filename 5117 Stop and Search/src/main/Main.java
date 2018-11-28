package main;

import java.awt.RenderingHints.Key;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		CSVReader reader = new CSVReader(); // reads csvreader class
		LinkedList<Stop> stopList = reader.createList(); // Creates List
		ArrayList<Stop> stopListArray = new ArrayList<>(stopList); // Converts stopList to array.
		outputCrimes(stopList);
		Scanner scan = new Scanner(System.in);
		String choice = "";
		String choices;
		int index = 0;
		
		//		*** GENERATING UNIQUE LIST ***		//
		ArrayList<String> uniqueLegislation = generateUniqueLegislation(stopList);
		ArrayList<String> uniquePoliceForce = generateUniquePoliceForce(stopList);
		ArrayList<String> uniqueSelfEthnicity = generateUniqueSelfEthnicity(stopList);
		
		
		do {
			System.out.println("\n** MAIN MENU **");
			System.out.println("1 - Object Of Search + Relating data search."); // Feature A

			System.out.println(
					"2 - Find and report the legislation which produces the highest Stop and Search frequency for a specified month ");

			System.out.println(
					"3 - Find which (self-determined) ethnic group has the highest number of recorded stop and search events, and output this data");
					// Based on police force AND month + Reverse Chronological Order
					// Based on specific legislation
			
			System.out.println(
					"4 - OUR OWN FEATURE");
			
			System.out.print("Pick : ");

			choice = scan.next().toUpperCase();

			switch (choice) {
			case "1": { // loops through StopListArray and compares duplicates, if duplicate is found it is removed
				
				List<String> objectsOfSearch = new ArrayList<>(); // new arraylist to hold data from StopListArray while
																	// deleting
																	// Duplicates.

				System.out.println("\n Search Categories.\n");
				for (int i = 0; i < stopListArray.size(); i++) {
					String object = stopListArray.get(i).getObjectSearch();
					if (!objectsOfSearch.contains(object))
						objectsOfSearch.add(object);
				}

				for (Iterator<String> iterate = objectsOfSearch.iterator(); iterate.hasNext(); index++) {
					String pos = iterate.next();
					System.out.println(index + ": " + pos);
				}
				System.out.println(
						"\n** Please enter the number of Object of Search you would like to view data on? **\n");
				Scanner scans = new Scanner(System.in);
				choices = scans.nextLine();
				int choiceNum = Integer.parseInt(choices);
				boolean listContainsInput = false;

				if (choiceNum >= 11) {
					System.out.println("** ERROR!! Please enter a correct index position I.E. 0-10. **"); // works
					break;
				}

				String objectOf = objectsOfSearch.get(choiceNum);
				for (int counter = 0; counter < stopListArray.size(); counter++) {
					if (objectOf.equals(stopListArray.get(counter).getObjectSearch())) {
						listContainsInput = true;
						System.out.println("** " + stopListArray.get(counter).DatatoCSVString()); // if statments
					}
				}
				index = 0;
				break;
			}
				

			case "2": {
				specifiedMonth(stopList, uniqueLegislation);
				break;
			}

			case "3": {
				specifiedEthnicity(stopList, uniquePoliceForce, uniqueLegislation, uniqueSelfEthnicity);
				break;
			}

			case "4": {

				break;
			}
		}
			
		} while (!choice.equals("Q"));
		System.out.println("-- GOODBYE --");

	}

	private static void specifiedMonth(List<Stop> stopList, ArrayList<String> uniqueLegislation) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n** Which month would you like to search for? [1 - 12] **\n "); // asks for the month the
		
		String specifiedMonth = "Placeholder";
		Integer intMonth = 0;
		
		
		do {
			specifiedMonth = scan.next();
			
			try {
				intMonth = Integer.parseInt(specifiedMonth);
				break;
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, Please Type the Wanted Month's Number.");
			}
			
		} while(true);

		ArrayList<Integer> legislationCounters = new ArrayList<>();
		ArrayList<Integer> successCounters = new ArrayList<>();
		Integer legIndex = 0;
		int count = 0;
		int successCount = 0;

		for(String legislation : uniqueLegislation) {
			for(Stop stop : stopList) {
				if(stop.getLegislation().equals(legislation) && stop.getDate().getMonth() == intMonth) {
					count++;
					if (stop.getOutcome()
							.matches("(Suspect|Offender|Local|Article|Arrest|Khat|Penalty|Community|Summons|Caution).*")
							&& stop.getOutcomeObjectSearch() == true) { // If outcome was related to object of
																				// search, then it was a successful stop.
						successCount++;
					}
					
				}
			}
			legislationCounters.add(count);
			successCounters.add(successCount);
			count = 0;
			successCount = 0;
		}
		
		for(int i = 0; i < uniqueLegislation.size(); i++) {
			System.out.println(uniqueLegislation.get(i));
			System.out.println(legislationCounters.get(i)  + " (Successful: " + successCounters.get(i) + ")");
			System.out.println("");
		}
	}
	
	
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
		System.out.println(invalid + "   || Had no outcome");
		System.out.println(stars);
	}

	private static void specifiedEthnicity(List<Stop> stopList, ArrayList<String> uniquePoliceForce, ArrayList<String> uniqueLegislation, ArrayList<String> uniqueSelfEthnicity) {
		
		Scanner scan = new Scanner(System.in);
		
		// MONTH
		System.out.println("\n** Which month would you like to search for? [1 - 12] **\n "); // asks for the month the
		String specifiedMonth = "Placeholder";
		String specifiedPoliceForce = "Placeholder";
		
		Integer intMonth = 0;
		Integer intPF = 0;
		do {
			specifiedMonth = scan.next();
			try {
				intMonth = Integer.parseInt(specifiedMonth);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, Please Type the Wanted Month's Number.");
			}
		} while(true);
		
		System.out.println("What police force do you want?");
		
		int i = 1;
		for(String PF : uniquePoliceForce) {
			
			System.out.println(i + ": " + PF);
			i++;
		}
		i = 0;

		do {
			specifiedPoliceForce = scan.next();
			try {
				intPF = Integer.parseInt(specifiedPoliceForce);
				
				if(intPF > uniquePoliceForce.size() && intPF > 0) {
					System.out.println("Invalid Input, please specify a number from the given list!");
				} else {
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, Please Input a Number!");
			}
		} while(true);
		
		specifiedPoliceForce = uniquePoliceForce.get(intPF - 1);
		
		
		String specifiedLegislation;
		Integer intLeg = 0;
		System.out.println("What legislation do you want?");
		
		i = 1;
		for(String leg : uniqueLegislation) {
			
			System.out.println(i + ": " + leg);
			i++;
		}
		i = 0;

		do {
			specifiedLegislation = scan.next();
			try {
				intLeg = Integer.parseInt(specifiedLegislation);
				
				if(intPF > uniqueLegislation.size() && intPF > 0) {
					System.out.println("Invalid Input, please specify a number from the given list!");
				} else {
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, Please Input a Number!");
			}
		} while(true);
		
		specifiedLegislation = uniqueLegislation.get(intLeg - 1);
		
		ArrayList<Integer> selfEthnicityCounters = new ArrayList<>();
		
		// TODO:
		// Counters
		
	}
	
	
	private static ArrayList<String> generateUniqueLegislation(LinkedList<Stop> stopList) {
		
		ArrayList<String> uniqueLegislation = new ArrayList<>();
		
		for(Stop stop : stopList) {
			
			if (!(uniqueLegislation.contains(stop.getLegislation()))) {
				uniqueLegislation.add(stop.getLegislation());
				
			}	
		}			
		return uniqueLegislation;
	}
	
	private static ArrayList<String> generateUniqueSelfEthnicity(LinkedList<Stop> stopList) {
		
		ArrayList<String> uniqueSelfEthnicity = new ArrayList<>();
		
		for(Stop stop : stopList) {
			
			if (!(uniqueSelfEthnicity.contains(stop.getSelfEthnicity()))) {
				uniqueSelfEthnicity.add(stop.getSelfEthnicity());
				
			}	
		}			
		return uniqueSelfEthnicity;
	}
	
	private static ArrayList<String> generateUniquePoliceForce(LinkedList<Stop> stopList) {
		
		ArrayList<String> uniquePoliceForce = new ArrayList<>();
		
		for(Stop stop : stopList) {
			
			if (!(uniquePoliceForce.contains(stop.getPoliceForce()))) {
				uniquePoliceForce.add(stop.getPoliceForce());
				
			}	
		}		
		return uniquePoliceForce;	
	}
}
