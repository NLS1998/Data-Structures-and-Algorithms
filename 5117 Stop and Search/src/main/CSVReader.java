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