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
			}
				break;

			case "2": {
				
				specifiedMonth(stopList);
//				 Map<String,Integer> map = new HashMap<String, Integer>();
//			        for(int i=0;i<stopListArray.size();i++){            
//			            Integer count = map.get(stopListArray.get(i).getLegislation());       
//			            map.put(stopListArray.get(i).getLegislation(), count==null?1:count+1);   //auto boxing and count
//			        }
//			      System.out.println(map);
//			     System.out.println("");
			 //prints all legislations and displays occurrences amount per legislation, need to allow the user to choose
			 //the month they want and display the highest stop for that month.
			    
//				String decision = scan.nextLine();
//
//				List<String> A1 = new ArrayList<>();// Stores legislation categories.
//				List<String> A2 = new ArrayList<>();// Stores legislation data
//				int indexs;
//				for (int i = 0; i < stopListArray.size(); i++) {
//					String legislation = stopListArray.get(i).getLegislation();
//					String legislations = stopListArray.get(i).DatatoCSVString();
//					if (!A1.contains(legislation))
//						A1.add(legislation);
//					A2.add(legislations);
//					indexs = i;
//				}
//				System.out.println("\n" + A1);
//				System.out.println(A2);
				// the data of both arrays stored and printing we need link each legislation to
				// each legislation.
				
				break;
			}

			case "3": {
				
				break;
			}

			case "4": {

				break;
			}
		}
			
		} while (!choice.equals("Q"));
		System.out.println("-- GOODBYE --");

	}

	private static void specifiedMonth(List<Stop> stopList) {
		
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
		
		
		ArrayList<String> uniqueLegislation = new ArrayList<>();
		ArrayList<Integer> legislationCounters = new ArrayList<>();
		ArrayList<Integer> successCounters = new ArrayList<>();
		Integer legIndex = 0;
		int count = 0;
		int successCount = 0;
		
		for(Stop stop : stopList) {
			
			if (!(uniqueLegislation.contains(stop.getLegislation()))) {
				uniqueLegislation.add(stop.getLegislation());
			}	
		}
		
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

}
