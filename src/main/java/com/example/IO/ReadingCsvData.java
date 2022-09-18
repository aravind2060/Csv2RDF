package com.example.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingCsvData {

	public List<MovieModel> readDataFromCSVFile(String fileName) {
		
		BufferedReader br=null;
		
		try {
			br=new BufferedReader(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName+" file not found exception!");
		}
		
		List<MovieModel> records=new ArrayList<MovieModel>();
		
		try {
		String line=br.readLine();
			while((line=br.readLine())!=null)
			{
			   String temp[]=line.split(",");
			   
			   String actor=temp[0].replaceAll(" ", "_");
			   String movie=temp[1].replaceAll(" ", "_");
			   String country=temp[2].replaceAll(" ", "_");
			
			   records.add(new MovieModel(actor,movie,country));
			}
		} catch (IOException e) {
			System.out.println("Problem reading "+fileName);
		}
		
		return records;
	}
	
	
}
