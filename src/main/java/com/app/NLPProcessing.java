package com.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.dcoref.Document;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class NLPProcessing {
 
	public String process(String text) throws FileNotFoundException {
		
    	String word=null;
    	String pos = null;
    	int wordCount=0;
    	int nounCount=0;
    	int verbCount=0;
    	
        // creating properties object and setting up the list of annotators to use ( POS, tokenize, spplit)
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos");
        
        // Building StandfordCoreNLP pipeline with properties object
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);
        
     // Making list of all the sentences in document
     List<CoreMap> sentences = document.get(SentencesAnnotation.class);
     
     // Number of sentences
     System.out.println("Number of sentences are: "+sentences.size());
     
     for(CoreMap sentence: sentences) {
       // looping through words in the current sentence
       for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
         // Extracting word
         word = token.get(TextAnnotation.class);
         // Extracting the word's part of speech
         pos = token.get(PartOfSpeechAnnotation.class);
         
       //System.out.println(String.format("Print word: [%s] pos: [%s]", word, pos));
         
         // Selecting only words which are nouns and keeping their count in variable named - nounCount
         if (pos.contains("NN"))
        	 nounCount++;
         
         // Selecting only words which are verbs and keeping their count in variable named - verbCount
         if(pos.contains("VB"))
        	 verbCount++;
         
         /* Characters such as ',', '.', '?', etc are also being considered as words. These characters
          * cannot be considered as words. Hence, comparing a word with a regex pattern of alphabets
          * to make sure only words are selected and their count is maintained in a variable named - wordCount
          */
         if(word.matches("[a-zA-Z]+"))
        	 wordCount++;
       }
    
     }
     
     //Number of words
     System.out.println("Total number of words are: "+wordCount);
     
     // Number of nouns
     System.out.println("Total number of nouns are: "+nounCount);
     
     // Number of verbs
     System.out.println("Total number of verbs are: "+verbCount);
     
     //Creating output string to send back to Servlet
     String out = " \n Number of sentences are: "+ sentences.size() + " \n\n Number of words are: " + wordCount +
    		 " \n Number of nouns are: " + nounCount + " \n Number of verbs are: " + verbCount;
     
     return out;
     
	}
	
}
