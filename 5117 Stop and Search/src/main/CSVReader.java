package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CSVReader {
    public static void main(String[] args) 
    {
    	String rootPath = "data";
    	try {
			Files.walk(Paths.get(rootPath)).filter(Files::isRegularFile).forEach(file -> {
			    File csv = new File(file.toUri());
			    BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(csv));
					System.out.println(csv.getAbsolutePath());
				} catch (FileNotFoundException e) {
					e.printStackTrace();			} 
    	  
    	  String allData; 
    	  try {
			while ((allData = br.readLine()) != null) 
			    System.out.println(allData);
		} catch (IOException e) {
			e.printStackTrace();
		}		    
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 
}
    public final String SEP = ",";
    public Stop stop;
	public String date;
	public String partPolicingOp;
	public String policingOp;
	public double longitude;
	public double latitude;
	public String gender;
	public String ethnicity;
	public String officerEthnicity; 
	public String legislation; 
	public String objectSearch;
	public String outcome;
	public String outcomeObjectSearch;
	public String clothesRemoval;
	
	
	public CSVReader(String csvString) {
		String[] csvParts = csvString.split(SEP, -1);
		int idx = 0;		
		stop = Stop.getFrom(csvParts[idx++]);
		date = csvParts[idx++];
		partPolicingOp = csvParts[idx++];
		policingOp = csvParts[idx++];
		longitude = Double.valueOf(csvParts[idx++]);
		latitude = Double.valueOf(csvParts[idx++]);
		gender = csvParts[idx++];
		ethnicity = csvParts[idx++];
		officerEthnicity = csvParts[idx++];
		legislation = csvParts[idx++];
		objectSearch = csvParts[idx++];
		outcome = csvParts[idx++];
		outcomeObjectSearch = csvParts[idx++];
		clothesRemoval = csvParts[idx++];
	}

	public String toCSVString() {
		return stop + SEP + date + SEP + partPolicingOp + SEP + policingOp + SEP + longitude + SEP + latitude + SEP
				+ gender + SEP + ethnicity + SEP + officerEthnicity + SEP + legislation + SEP + objectSearch + SEP + outcome + SEP + outcomeObjectSearch + clothesRemoval;
	}
}