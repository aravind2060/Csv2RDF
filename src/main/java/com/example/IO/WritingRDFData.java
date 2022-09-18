package com.example.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.jena.rdf.model.Model;

public class WritingRDFData {

	/**
	 * This method helps to write Model into file with TURTLE format
	 * */
	public void writeDataToFile(String fileName,Model m) {
		
		File outputfile=new File(fileName);
		
		OutputStream os=null;
		try {
			os=new FileOutputStream(outputfile,true);
			
		} catch (FileNotFoundException e) {
			System.out.println(fileName+" file doesn't exist");
		}
		
		m.write(os, "TURTLE");
		
	}
	
	
	
}
