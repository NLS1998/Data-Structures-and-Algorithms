package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



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
				} catch (FileNotFoundException e) {
					e.printStackTrace();			} 
    	  
    	  String allData; 
    	  try {
			while ((allData = br.readLine()) != null) 
			    System.out.println(allData);
		} catch (IOException e) {
			e.printStackTrace();
		} 
			    System.out.println(csv.getAbsolutePath());
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 
}
}