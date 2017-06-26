package Validations;

import java.util.*;
import java.io.File;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;

public class Utils {
	//given a directory, loads all the files in a local model.
    public static OntModel loadDirectory(String dirPath){
        OntModel model = ModelFactory.createOntologyModel();
        File dir = new File (dirPath);
        if(dir.isDirectory()){
            for (File currf : dir.listFiles()){
                loadFileInModel(model, currf);
            }
            return model;
        }
        System.err.println("The path "+dirPath+ " is not a directory");
        return null;
        
    }
    
    private static OntModel loadFileInModel(OntModel m, File f){
        try{
            System.out.println("Loading file: "+f.getName());
            m.read(f.getAbsolutePath(), null, "TURTLE");
        }catch(Exception e){
            System.err.println("Could not load the file in turtle. Attempting to read it in turtle...");
            try{
                m.read(f.getAbsolutePath(), null, "RDF/XML");
            }catch(Exception e1){
                System.err.println("Could not load ontology in rdf/xml.");
            }
        }
        return m;
    }
    
    public static ResultSet queryLocalRepository(String queryIn, OntModel repository){
        Query query = QueryFactory.create(queryIn);
        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, repository);
        ResultSet rs =  qe.execSelect();
        //qe.close();
        return rs;
    }
    
    public static String getCountOf (String query, OntModel m, String varToQuery){
        ResultSet r =  Utils.queryLocalRepository(query, m);
        String result = "";
        while (r.hasNext()){
            QuerySolution qs = r.nextSolution();
            result+=qs.getLiteral("?"+varToQuery).getString();
            System.out.println("result is "+result);
        }
        
        return result;
    }
    public static ArrayList<Integer> queryresult (String query, OntModel m, String varToQuery1,String varToQuery2){
        ResultSet r =  Utils.queryLocalRepository(query, m);
        String result = "";
        HashSet<String> hs1=new HashSet<>();
        HashSet<String> hs2=new HashSet<>();
        while (r.hasNext()){
            QuerySolution qs = r.nextSolution();
            String var1="";
            String var2="";
            var1=qs.getResource("?"+varToQuery1).getLocalName();
            var2=qs.getResource("?"+varToQuery2).getLocalName();
            System.out.println();
            
            System.out.println("var 1 "+var1);
            System.out.println("var 2 "+var2);
            hs1.add(var1);
            hs2.add(var2);
        }
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(hs1.size());
        arr.add(hs2.size());
        return arr;
    }
            
    
    //given an online repository, perform a test against a template/run.
    //TO DO
}
