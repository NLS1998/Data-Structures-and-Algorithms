package main;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		CSVReader reader = new CSVReader();
		LinkedList<Stop> stopList = reader.createList();
		Scanner scan = new Scanner(System.in);

		String choice = "";

		for (Stop stop : stopList) {

			do {
				System.out.println("\n** MAIN MENU **");
				System.out.println("1 - Crime Type");
				System.out.println("2 - Last Outcome");
				System.out.println("3 - Lsoa Name");
				System.out.println("Q - Quit");
				System.out.print("Pick : ");

				choice = scan.next().toUpperCase();

				switch (choice) {
				case "1": {
					Stop.insertSortA(stopList);
					break;
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