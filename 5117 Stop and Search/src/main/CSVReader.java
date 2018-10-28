package main;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class CSVReader {
    public static void main(String[] args) 
    {
        // Directory path here
    	String rootPath = "data";
    	try {
			Files.walk(Paths.get(rootPath)).filter(Files::isRegularFile).forEach(file -> {
			    File csv = new File(file.toUri());
			    //logic with file
			    System.out.println(csv.getAbsolutePath());
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}