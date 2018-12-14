package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
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
		ArrayList<String> uniqueGender = generateUniqueGender(stopList);
		ArrayList<String> uniqueType = generateUniqueType(stopList);
		ArrayList<String> remOfClothes = generateUniqueremOfClothes(stopList);
		// Unique Objects Of Search done Later On
		
		do {
			System.out.println("\n** MAIN MENU **");
			System.out.println("1 - Object Of Search + Relating data search."); // Feature A

			System.out.println(
					"2 - Find and report the legislation which produces the highest Stop and Search frequency for a specified month ");

			System.out.println(
					"3 - Find which (self-determined) ethnic group has the highest number of recorded stop and search events, based on specific criteria.");
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
				specifiedMonth(stopListArray, uniqueLegislation);
				break;
			}

			case "3": {
				specifiedEthnicity(stopListArray, uniquePoliceForce, uniqueLegislation, uniqueSelfEthnicity);
				break;
			}

			case "4": {
				ownFeature(stopListArray, uniqueType);
				break;
			}
		}
			
		} while (!choice.equals("Q"));
		System.out.println("-- GOODBYE --");

	}
	private static void ownFeature(List<Stop> stopList, ArrayList<String> uniqueType) {
		System.out.println("Totals based on stop type: ");
		System.out.println();
		ArrayList<Integer> typeCounters = new ArrayList<>();
		int count = 0;
		
		for(String type : uniqueType) {
			for(Stop stop : stopList) {
				if(stop.getType().equals(type)) {
					count++;
			}
		}
		typeCounters.add(count);
		count = 0;
	}
		
		for(int i = 0; i < uniqueType.size(); i++) {
			System.out.println(uniqueType.get(i));
			System.out.println(typeCounters.get(i) + " :  Where undertaken!");
			System.out.println("");
		}
		
		System.out.println("Below are statistics based on gender stops:");
		
		// Gender
			// Age Range
				// Clothes removed
		
		// Male
			// Age
				// number (how many had clothes removed)
			// Age 
			// Age
		
		List<String> genderList = new ArrayList<String>(); // Hard-coded, genders are unlikely to change.
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Other");
		
		List<Stop> maleStops = new ArrayList<Stop>();
		List<Stop> femaleStops = new ArrayList<Stop>();
		List<Stop> otherStops = new ArrayList<Stop>();
		
		List<EnumAgeRange> uniqueAgeRanges = new ArrayList<EnumAgeRange>();

		List<Integer> ageRangeCounters = new ArrayList<Integer>();
	
		
		
		for(Stop stop : stopList) { 
			
			if(!(uniqueAgeRanges.contains(stop.getAgeRange()))) {
			uniqueAgeRanges.add(stop.getAgeRange());
			}
			
			if(stop.getGender().equals("Male")) {
				maleStops.add(stop);
			} else if (stop.getGender().equals("Female")) {
				femaleStops.add(stop);
			} else {
				otherStops.add(stop);
			}
		}
		
		for(EnumAgeRange ageRange : uniqueAgeRanges) {
			int i = 0; 
			for(Stop stop : maleStops) {
				if (ageRange.equals(stop.getAgeRange())) {
					i ++; 
				}
			}
			
			System.out.println("\n\nFor the age range "+ageRange+":");
			
			System.out.println("Males have been stopped "+i+" times.");
			i = 0;
			for(Stop stop : femaleStops) {
				if (ageRange.equals(stop.getAgeRange())) {
					i ++; 
				}
			}
			System.out.println("Females have been stopped "+i+" times.");
			i = 0;
			for(Stop stop : otherStops) {
				if (ageRange.equals(stop.getAgeRange())) {
					i ++; 
				}
			}
			System.out.println("Other genders have been stopped "+i+" times.");
		}
		
		System.out.println();
		System.out.println("Amount of males that where stopped: " + maleStops.size());
		System.out.println("Amount of females that where stopped: " + femaleStops.size());
		System.out.println("Amount of times gender was not specified: " + otherStops.size());
	}

	private static void specifiedMonth(List<Stop> stopList, ArrayList<String> uniqueLegislation) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n** Which month would you like to search for? [1 - 12] **\n "); // asks for the month the
		
		String specifiedMonth = "Placeholder";
		Integer intMonth = 0;
		
		HashMap<String, Integer> legislationMap = new HashMap<String, Integer>();
		
		HashMap<String, Integer> legislationMapSuccess = new HashMap<String, Integer>();
		
		do {
			specifiedMonth = scan.next();
			
			try {
				intMonth = Integer.parseInt(specifiedMonth);
				break;
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, Please Type the Wanted Month's Number.");
			}
			
		} while(true);

		for(Stop stop : stopList) {
			if(stop.getDate().getMonth() == intMonth) {

				int count = 1;

				
				
				if(legislationMap.containsKey(stop.getLegislation())){
					count = legislationMap.get(stop.getLegislation());
					count++;
				}
				legislationMap.put(stop.getLegislation(), count);
				
				if(stop.getOutcomeObjectSearch()) {
					if(legislationMapSuccess.containsKey(stop.getLegislation())){
						count = legislationMapSuccess.get(stop.getLegislation());
						count++;
					}
					legislationMapSuccess.put(stop.getLegislation(), count);
				}
			}
		}
		
		int highestVal = 0;
		String highestLeg = "";
		for(Entry<String, Integer> entry : legislationMap.entrySet()) {
			if(entry.getValue() > highestVal) {
				highestVal = entry.getValue();
				highestLeg = entry.getKey();
			}
		}
		
		System.out.println(highestLeg + " has the highest amount of stops: " + highestVal);
		
		highestVal = 0;
		highestLeg = "";
		for(Entry<String, Integer> entry : legislationMapSuccess.entrySet()) {
			if(entry.getValue() > highestVal) {
				highestVal = entry.getValue();
				highestLeg = entry.getKey();
			}
		}
		
		System.out.println(highestLeg + " has the highest amount of succesfull stops: " + highestVal);
		
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
		
		System.out.println("Do you wish to find the highest recorded stop and search count for:");
		
		System.out.println("[1] Specific Month & Police Force");
		System.out.println("[2] Specific Legislation");
		
		String answer = scan.next();
		Integer intAnswer = 0;
		
		do {
			try {
				intAnswer = Integer.parseInt(answer);
				
				if(intAnswer > 2 || intAnswer < 0) {
					System.out.println("Please specify one of the given options!");
				} else {
					break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input, Please Specificy one of the Given Criteria. [0 - 9]");
			}
		} while (true);
		
		switch(intAnswer) {
		
		case 1 : { // Specific Month & Police Force
			
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
			
			// POLICE FORCE
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
			
			ArrayList<Stop> temporaryStops = new ArrayList<Stop>();
			ArrayList<Integer> ethnicityCounters = new ArrayList<Integer>();
			
			
			for(String ethnicity : uniqueSelfEthnicity) {
				int count = 0;
				
				for(Stop stop : stopList) {
					
					if(specifiedPoliceForce.equals(stop.getPoliceForce()) && intMonth == stop.getDate().getMonth() && ethnicity.equals(stop.getSelfEthnicity())) {
						count++;
						
						
						
						// Store this stop in an array, so that it can be sorted later and output (FEATURE G)
					}
				}
				ethnicityCounters.add(count);
				System.out.println(ethnicity + " was stopped " + count + " times.");
				count = 0;
			}
			
			int finalIndex = 0;
			int current = 0;
			int highest = 0;
			for (int idx = 0; idx < uniqueSelfEthnicity.size(); idx++) {
				
				
				current = ethnicityCounters.get(idx);
				
				System.out.println(uniqueSelfEthnicity.get(idx));
				System.out.println(current);
				
				if(current > highest) {
					System.out.println("Final Index Changed!");
					highest = current;
					finalIndex = idx;
				}
			}
			
			System.out.println(uniqueSelfEthnicity.get(finalIndex) + " is the highest self-defined ethnicity that is stopped!");
			
			for(Stop stop : stopList) {
			
				if(specifiedPoliceForce.equals(stop.getPoliceForce()) && intMonth == stop.getDate().getMonth() && uniqueSelfEthnicity.get(finalIndex).equals(stop.getSelfEthnicity())) {
					temporaryStops.add(stop);
				}
			
			}
			
			//TODO:
			// Currently only orders them by the DAY, not by the Hour/Minute/Second -- Ask David for help on this?
			
			Collections.sort(temporaryStops, new Comparator<Stop>()
					{
						public int compare(Stop stop1, Stop stop2)
						{
							return stop1.getDate().compareTo(stop2.getDate());
							//return Integer.valueOf(Integer.toString(stop1.getDate().getDay()).compareTo(Integer.toString(stop2.getDate().getDay())));
						}
					}
			);
			
			for(Stop stop : temporaryStops) {
				stop.getDate().dateToString();
			}
			break;
		} 
		
		case 2 : { // Specific Legislation
			
			String specifiedLegislation;
			Integer intLeg = 0;
			System.out.println("What legislation do you want?");
			
			Integer i = 1;
			for(String leg : uniqueLegislation) {
				
				System.out.println(i + ": " + leg);
				i++;
			}
			i = 0;

			do {
				specifiedLegislation = scan.next();
				try {
					intLeg = Integer.parseInt(specifiedLegislation);
					
					if(intLeg > uniqueLegislation.size() && intLeg > 0) {
						System.out.println("Invalid Input, please specify a number from the given list!");
					} else {
						break;
					}
					
				} catch (NumberFormatException e) {
					System.out.println("Invalid Input, Please Input a Number!");
				}
			} while(true);
			
			specifiedLegislation = uniqueLegislation.get(intLeg - 1);
			
			for(String ethnicity : uniqueSelfEthnicity) {
				Integer count = 0;
				for(Stop stop : stopList) {
					if(ethnicity.equals(stop.getSelfEthnicity()) && specifiedLegislation.equals(stop.getLegislation())) {
						count++;
					}
				}
				System.out.println(ethnicity + " was stopped " + count + " times.");
				count = 0;
			}
			break;
			}
		}
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
	private static ArrayList<String> generateUniqueGender(LinkedList<Stop> stopList) {
		
		ArrayList<String> uniqueGender = new ArrayList<>();
		
		for(Stop stop : stopList) {
			
			if (!(uniqueGender.contains(stop.getGender()))) {
				uniqueGender.add(stop.getGender());
				
			}	
		}		
		return uniqueGender;	
	}
	private static ArrayList<String> generateUniqueType(LinkedList<Stop> stopList) {
		ArrayList<String> uniqueType = new ArrayList<>();
		
		for(Stop stop : stopList) {
			if (!(uniqueType.contains(stop.getType()))) {
				uniqueType.add(stop.getType());
			}
		}
		return uniqueType;
	}
	private static ArrayList<String> generateUniqueremOfClothes(LinkedList<Stop> stopList) {
		ArrayList<String> remOfClothes = new ArrayList<>();
		
		for(Stop stop : stopList) {
			if (!(remOfClothes.contains(stop.getClothesRemoval()))) {
				remOfClothes.add(stop.getClothesRemoval());
			}
		}
		return remOfClothes;
	}
}
