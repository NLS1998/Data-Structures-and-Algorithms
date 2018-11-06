package main;

import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		CSVReader reader = new CSVReader();// reads csvreader class
		LinkedList<Stop> stopList = reader.createList();// Creates List
		Scanner scan = new Scanner(System.in);

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
							if (higher.objectSearch.compareTo(lower.objectSearch) < 0) {
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
}