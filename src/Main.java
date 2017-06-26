
public class Main {
public static void main(String[] args) {
	System.out.println("Transform an template to OPMW");
    Mapper instance = new Mapper();
  String lib = "/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/lib.owl";
  
  //String execution = "/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/executions/spacer/spacer-ex.owl";
  //String execution = "/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/executions/parasimple/cpexe.owl";
  //String execution = "/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/ab2ex.owl";
  
  String execution ="/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/abex1.owl";
  //String execution ="/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/abex2.owl";
  //String execution ="/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/abex3.owl";
  
  
   //String template="/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/executions/parasimple/CaesarCypherParallelSimple.owl";
   //String template="/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/abstractTest2.owl";

   String template="/Users/Tirthmehta/Desktop/WINGS_PROVENANCE_EXPORT_ISI/ab1temp.owl";
    String mode = "RDF/XML";
  String outFileOPMW = "testResultOPMW";
  String outFilePROV = "testResultPROV";
  String outFile = "testTemplateabstractTest1";
    
  	//String ans=instance.transformWINGSElaboratedTemplateToOPMW(template, mode, outFile, null);
  	String ans=instance.transformWINGSResultsToOPMW(execution, lib, mode, outFileOPMW, outFilePROV, null);
    System.out.println("--------------------------");
    System.out.println("location is :"+ans);
 
    
    
    //http://datascience4all.org/wings-portal/export/users/tirth/TestingDomain/workflows/spacer.owl
    //http://datascience4all.org/wings-portal/export/users/tirth/TestingDomain/workflows/abstract.owl
    ///Users/Tirthmehta/Documents/workspace/WINGS_PROVENANCE_EXPORT_ISI/executions/spacer/spacer-ex.owl
    //http://datascience4all.org/wings-portal/export/users/tirth/TestingDomain/executions/spacer-64c57dfd-d9ad-44f2-b114-2cfc3d0e50a1.owl
    //http://datascience4all.org/wings-portal/export/users/tirth/TestingDomain/executions/abstractTest1-83-cdd28105-a8a5-4fe8-bfb9-c8291a31ac7a.owl
    //http://datascience4all.org/wings-portal/export/users/tirth/TestingDomain/executions/library.owl
    //http://datascience4all.org/wings-portal/export/users/tirth/CaesarCypher/workflows/CaesarCypherParallelSimple.owl
    
    //expanded template for abstractTest1
    //http://datascience4all.org/wings-portal/export/users/tirth/TestingDomain/executions/abstractTest1-83-7336709c-6108-4fc8-9ecd-810f27c8d870.owl#abstractTest1-83-7336709c-6108-4fc8-9ecd-810f27c8d870
    
}
}
