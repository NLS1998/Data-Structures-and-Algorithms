package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;



public class CSVReader {
    	
	public LinkedList<Stop> createList() {
	
    	String rootPath = "data"; // Hardcoded data folder
    	
    	LinkedList<Stop> stopList = new LinkedList<Stop>();
    	
    	try {
			Files.walk(Paths.get(rootPath)).filter(Files::isRegularFile).forEach(file -> { // Walk through each of the child folders, finding the actual files. (not folders, isRegularFile)
			    File csv = new File(file.toUri()); // Gets the file's directory, turning into an individual file.
			    
			    BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(csv));
					br.readLine();
				} catch (FileNotFoundException e) {
					e.printStackTrace();			
					} catch (IOException e) {
					e.printStackTrace();
				} 

    	  try {
    		  	String allData;
				while ((allData = br.readLine()) != null) 
				{
					stopList.add(new Stop(allData));
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}		    
				});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stopList;

	}
}
		
		
		
		
		
		
		
		
//public final static String SEP = ","; // Comma seperated value, this is the delimiter.
//public static String date;
//public static String partPolicingOp;
//public static String policingOp;
//public static double longitude;
//public static double latitude;
//public static String gender;
//public static String ethnicity;
//public static String officerEthnicity; 
//public static String legislation; 
//public static String objectSearch;
//public static String outcome;
//public static String outcomeObjectSearch;
//public static String clothesRemoval;
		
//		policeforce idx = 0;		
//		date = csvParts[idx++];
//		partPolicingOp = csvParts[idx++];
//		policingOp = csvParts[idx++];
//		longitude = Double.valueOf(csvParts[idx++]);
//		latitude = Double.valueOf(csvParts[idx++]);
//		gender = csvParts[idx++];
//		ethnicity = csvParts[idx++];
//		officerEthnicity = csvParts[idx++];
//		legislation = csvParts[idx++];
//		objectSearch = csvParts[idx++];
//		outcome = csvParts[idx++];
//		outcomeObjectSearch = csvParts[idx++];
//		clothesRemoval = csvParts[idx++];
		
//	public String toCSVString() {
//		return  SEP + date + SEP + partPolicingOp + SEP + policingOp + SEP + longitude + SEP + latitude + SEP
//				+ gender + SEP + ethnicity + SEP + officerEthnicity + SEP + legislation + SEP + objectSearch + SEP + outcome + SEP + outcomeObjectSearch + clothesRemoval;
//	}