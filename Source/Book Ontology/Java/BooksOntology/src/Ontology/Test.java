package Ontology;

import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class Test {
	public static void main(String args[]) throws OWLOntologyCreationException{
		BooksOntology books = new BooksOntology();
//		books.LoadOntology();
//		books.getAuthorsList();
		books.IntersectionResults(null, "2011", null);
	}
}
