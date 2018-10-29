package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner scan = new Scanner(System.in);

		String choice = "";

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
	}}
	
	