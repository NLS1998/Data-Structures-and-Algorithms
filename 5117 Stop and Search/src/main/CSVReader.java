package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader 
{
public static void main(String[] args)
    {

try
         {
             File dir = new File(
                     "data");
             for (File fn : dir.listFiles())
             {
                 BufferedReader br = new BufferedReader(new FileReader(fn));
                 String strLine;
                 while ((strLine = br.readLine()) != null)
                 {
                     System.out.println(strLine);
                 }          
                 br.close();
             }

         }
         catch (FileNotFoundException e1)
         {
             e1.printStackTrace();
         }
         catch (IOException e)
         {
        	 e.printStackTrace();
         }
     }
 }

