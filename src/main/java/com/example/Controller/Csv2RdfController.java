package com.example.Controller;

import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

import com.example.IO.MovieModel;
import com.example.IO.ReadingCsvData;
import com.example.IO.WritingRDFData;

public class Csv2RdfController {

	/* Util: https://issemantic.net/rdf-visualizer  This link helps to visualize output.ttl*/
	
	public static void main(String args[]) {
		
		/*Reading Data from raw csv*/
		ReadingCsvData rcd=new ReadingCsvData();
		List<MovieModel> records=rcd.readDataFromCSVFile("src/main/resources/data.csv");
		
		/*Creating a model graph*/
        Model buildedModel=buildModel(records);
       
      /*Writing the model graph to output.ttl*/  
      WritingRDFData wrd=new WritingRDFData();
      wrd.writeDataToFile("src/main/resources/output.ttl", buildedModel);
	   
	   
	   

	}
	
	public static Model buildModel(List<MovieModel> records) {
		
		String db="https://dbpedia.org/page/";
		String dbo="https://dbpedia.org/ontology/";
		String rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#";
		String rdfs="http://www.w3.org/2000/01/rdf-schema#";
		
		
		Model movieGraph=ModelFactory.createDefaultModel();
		
		Property releasedIn=movieGraph.createProperty(dbo+"country");
		
		Property starring=movieGraph.createProperty(dbo+"starring");
		
		Property rdfType=movieGraph.createProperty(rdf+":type");
		
		Property name=movieGraph.createProperty(rdfs+":label");
		
		Property film=movieGraph.createProperty(dbo+"Film");
		
		Property actor=movieGraph.createProperty(dbo+"Actor");
		
		Property starredin=movieGraph.createProperty(dbo+"starredIn");
		
		for(int i=0;i<records.size();i++) {
			
			Resource actorResource=movieGraph.createResource(db + records.get(i).getActor());
			Resource movieResource=movieGraph.createResource(db + records.get(i).getMovie());
			Resource countryResource=movieGraph.createResource(db + records.get(i).getCountry());
			
			
			movieResource.addProperty(rdfType, film);
		    movieResource.addProperty(name, records.get(i).getMovie());
			movieResource.addProperty(releasedIn, countryResource);
			movieResource.addProperty(starring, actorResource);
			
//			actorResource.addProperty(rdfType,actor);
//			actorResource.addProperty(name, records.get(i).getActor());
//			actorResource.addProperty(starredin, movieResource);
			
		}
		
		/*To print output to screen*/
		//movieGraph.write(System.out, "TURTLE");
	    
		return movieGraph;   
	}
}
