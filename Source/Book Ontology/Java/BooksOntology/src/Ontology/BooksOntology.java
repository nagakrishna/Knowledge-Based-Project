package Ontology;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;


import uk.ac.manchester.cs.jfact.JFactFactory;

public class BooksOntology {

	private  OWLOntology ontology;
	private  OWLReasoner reasoner;
	private  OWLOntologyManager manager;
	private  OWLDataFactory df;
	public  Preferences PREFERENCES = null;
	private String IRI_ = "https://github.com/nagakrishna/Knowledge-Based-Project/ontology#";
	public BooksOntology(){
		 loadOntology();
	     setupReasoner();
	}
	
	public void loadOntology(){
		manager = OWLManager.createOWLOntologyManager();
        df = manager.getOWLDataFactory();
        PREFERENCES = new Preferences();
		File file = new File("D:/Knowledge/books.owl");
		try {
			ontology = manager.loadOntologyFromOntologyDocument(file);
		} catch (OWLOntologyCreationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public OWLOntology getOntology() {
	        return ontology;
	 }
	  
	public void setupReasoner(){
	    try {
            JFactFactory factory = new JFactFactory();
            reasoner = factory.createReasoner(ontology);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "A reasoner error has ocurred.\n" +
                            "[" + e.getMessage() + "]",
                    "Reasoner Error",
                    JOptionPane.ERROR_MESSAGE);
        }
	}
	
	 public OWLReasoner getReasoner() {
	        return reasoner;
	    }
	 
	 
	 public JSONObject getAuthorsList(){
		 PREFERENCES = new Preferences();
		 OWLClass AuthorCls = df.getOWLClass(PREFERENCES.getAuthorClassName());
	        Collection<OWLClass> c = reasoner.getSubClasses(AuthorCls, true).getFlattened();
	        int counter=0;
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			for(Iterator it = c.iterator(); it.hasNext(); counter++) {
				OWLClass cls = (OWLClass) it.next();
				System.out.println(cls.toString());
				String k = render(cls.toString());
				jsonArray.put(k);
				System.out.println(k);
			}
			jsonObject.put("Authors", jsonArray);
			return jsonObject;
	 }
	 
	 public JSONObject getYearList(){
		 PREFERENCES = new Preferences();
		 OWLClass YearCls = df.getOWLClass(PREFERENCES.getYearClassName());
	        Collection<OWLClass> c = reasoner.getSubClasses(YearCls, true).getFlattened();
	        int counter=0;
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			for(Iterator it = c.iterator(); it.hasNext(); counter++) {
				OWLClass cls = (OWLClass) it.next();
				System.out.println(cls.toString());
				String k = render(cls.toString());
				jsonArray.put(k);
				System.out.println(k);
			}
			jsonObject.put("Year", jsonArray);
			return jsonObject;
	 }
	 
	 public JSONObject getCategoryList(){
		 PREFERENCES = new Preferences();
		 OWLClass CategoryCls = df.getOWLClass(PREFERENCES.getCategoryClassName());
	        Collection<OWLClass> c = reasoner.getSubClasses(CategoryCls, true).getFlattened();
	        int counter=0;
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			for(Iterator it = c.iterator(); it.hasNext(); counter++) {
				OWLClass cls = (OWLClass) it.next();
				System.out.println(cls.toString());
				String k = render(cls.toString());
				jsonArray.put(k);
				System.out.println(k);
			}
			jsonObject.put("Category", jsonArray);
			return jsonObject;
	 }
	    public String render(String str) {
	    	String result[] = str.split("#");
	    	String a = result[1];
	    	a = a.replaceAll(">", "").replace("]", "").replace("_", " ");
	        return a;
	    }
	public  void LoadOntology() throws OWLOntologyCreationException{
		manager = OWLManager.createOWLOntologyManager();
        df = manager.getOWLDataFactory();
		PREFERENCES = new Preferences();
		File file = new File("D:/Knowledge/books.owl");
		ontology = manager.loadOntologyFromOntologyDocument(file);
		JFactFactory factory = new JFactFactory();
		reasoner = factory.createReasoner(ontology);
		OWLObjectProperty WrittenByProp = df.getOWLObjectProperty(PREFERENCES.getWrittenByPropName());
		
		//Get book written by author
//		OWLClass AuthorClass = df.getOWLClass(PREFERENCES.DEFAULT_Author2_Class_IRI);
//		OWLClassExpression temp = df.getOWLObjectSomeValuesFrom(WrittenByProp, AuthorClass);
//		NodeSet<OWLClass> temp1 =  reasoner.getSubClasses(temp, true);
//		Collection<OWLClass> c =  filterClasses(reasoner.getSubClasses(temp, true));
		
		//Get book by year
//		OWLClass Year2011Class = df.getOWLClass(PREFERENCES.getYear2011ClassName());
//		OWLObjectProperty PublishedInProp = df.getOWLObjectProperty(PREFERENCES.getPublishedInPropName());
//		OWLClassExpression temp = df.getOWLObjectSomeValuesFrom(PublishedInProp, Year2011Class);
//		NodeSet<OWLClass> temp1 =  reasoner.getSubClasses(temp, true);
//		Collection<OWLClass> c =  filterClasses(reasoner.getSubClasses(temp, true));
		
		//Get book by Category
//		OWLClass CategoryBibliographyClass = df.getOWLClass(PREFERENCES.getCategoryBibliographyClassName());
//		OWLObjectProperty CategorizedAsProp = df.getOWLObjectProperty(PREFERENCES.getCategrizedAsPropName());
//		OWLClassExpression temp = df.getOWLObjectSomeValuesFrom(CategorizedAsProp, CategoryBibliographyClass);
//		NodeSet<OWLClass> temp1 =  reasoner.getSubClasses(temp, true);
//		Collection<OWLClass> c =  filterClasses(reasoner.getSubClasses(temp, true));
		
		
		
		/*Intersection of year and author
		 * 
		 */
		
		OWLClass AuthorClass = df.getOWLClass(PREFERENCES.DEFAULT_Author2_Class_IRI);
		OWLClassExpression temp = df.getOWLObjectSomeValuesFrom(WrittenByProp, AuthorClass);
		Set<OWLClassExpression> classes = new HashSet<OWLClassExpression>();
		classes.add(temp);
	
		OWLClass Year2011Class = df.getOWLClass(PREFERENCES.getYear2011ClassName());
		OWLObjectProperty PublishedInProp = df.getOWLObjectProperty(PREFERENCES.getPublishedInPropName());
		OWLClassExpression temp5 = df.getOWLObjectSomeValuesFrom(PublishedInProp, Year2011Class);
		classes.add(temp5);
		
		OWLClassExpression temp2 = df.getOWLObjectIntersectionOf(classes);
		NodeSet<OWLClass> temp1 =  reasoner.getSubClasses(temp2, true);
		Collection<OWLClass> c =  filterClasses(reasoner.getSubClasses(temp2, true));
		
		int counter=0;
		for(Iterator it = c.iterator(); it.hasNext(); counter++) {
			OWLClass cls = (OWLClass) it.next();
			FinalResults(cls);
		}
		
	}
	
	public JSONObject IntersectionResults(String authorCls, String yearCls, String categoryCls){
		Set<OWLClassExpression> classes = new HashSet<OWLClassExpression>();
		if(!(authorCls.equals("none"))){
			String newAuthor = authorCls;
			newAuthor = newAuthor.replace(" ", "_");
			newAuthor = IRI_ + newAuthor;
			IRI Author_CLASS_IRI = IRI.create(newAuthor);
			OWLClass AuthorClass = df.getOWLClass(Author_CLASS_IRI);
			OWLObjectProperty WrittenByProp = df.getOWLObjectProperty(PREFERENCES.getWrittenByPropName());
			OWLClassExpression temp = df.getOWLObjectSomeValuesFrom(WrittenByProp, AuthorClass);
			classes.add(temp);
		}
		if(!(yearCls.equals("none"))){
			String newYear= yearCls;
			newYear = newYear.replace(" ", "_");
			newYear = IRI_ + newYear;
			IRI Year_CLASS_IRI = IRI.create(newYear);
			OWLClass YearClass = df.getOWLClass(Year_CLASS_IRI);
			OWLObjectProperty PublishedInProp = df.getOWLObjectProperty(PREFERENCES.getPublishedInPropName());
			OWLClassExpression temp = df.getOWLObjectSomeValuesFrom(PublishedInProp, YearClass);
			classes.add(temp);
		}
		if(!(categoryCls.equals("none"))){
			String newCategory = categoryCls;
			newCategory = newCategory.replace(" ", "_");
			newCategory = IRI_ + newCategory;
			IRI Category_CLASS_IRI = IRI.create(newCategory);
			OWLClass CategoryClass = df.getOWLClass(Category_CLASS_IRI);
			OWLObjectProperty CategorizedAsProp = df.getOWLObjectProperty(PREFERENCES.getCategrizedAsPropName());
			OWLClassExpression temp = df.getOWLObjectSomeValuesFrom(CategorizedAsProp, CategoryClass);
			classes.add(temp);
		}
		
		OWLClassExpression temp2 = df.getOWLObjectIntersectionOf(classes);
		Collection<OWLClass> c =  filterClasses(reasoner.getSubClasses(temp2, true));
		int counter=0;
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for(Iterator it = c.iterator(); it.hasNext(); counter++) {
			OWLClass cls = (OWLClass) it.next();
			jsonArray.put(FinalResults(cls));
		}
		jsonObject.put("results", jsonArray);
		return jsonObject;
	}
	public JSONObject FinalResults(OWLClass cls){
		
		OWLObjectProperty InverseCategorizedProp = df.getOWLObjectProperty(PREFERENCES.getInverseCategrizedAsPropName());
		OWLObjectProperty InverseIsbnProp = df.getOWLObjectProperty(PREFERENCES.getInverseHasIsbnPropName());
		OWLObjectProperty InversePublishedProp = df.getOWLObjectProperty(PREFERENCES.getInversePublishedInPropName());
		OWLObjectProperty InverseWrittenProp = df.getOWLObjectProperty(PREFERENCES.getInverseWrittenByPropName());
		
		OWLClassExpression category = df.getOWLObjectSomeValuesFrom(InverseCategorizedProp, cls);
		Collection<OWLClass> c1 =  filterClasses(reasoner.getSubClasses(category, true));
		
		OWLClassExpression isbn = df.getOWLObjectSomeValuesFrom(InverseIsbnProp, cls);
		Collection<OWLClass> c2 =  filterClasses(reasoner.getSubClasses(isbn, true));
		
		OWLClassExpression published = df.getOWLObjectSomeValuesFrom(InversePublishedProp, cls);
		Collection<OWLClass> c3 =  filterClasses(reasoner.getSubClasses(published, true));
		
		OWLClassExpression author = df.getOWLObjectSomeValuesFrom(InverseWrittenProp, cls);
		Collection<OWLClass> c4 =  filterClasses(reasoner.getSubClasses(author, true));
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", render(cls.toString()));
		jsonObject.put("category",render(c1.toString()));
		jsonObject.put("isbn",render(c2.toString()));
		jsonObject.put("year",render(c3.toString()));
		jsonObject.put("author",render(c4.toString()));
		return jsonObject;
	}
	protected  Set<OWLClass> filterClasses(NodeSet<OWLClass> original) {
        Set<OWLClass> result = new TreeSet<OWLClass>();
        for (OWLClass cls : original.getFlattened()) {
            if (reasoner.isSatisfiable(cls)) {
                result.add(cls);
            }
        }
        return result;
    }
}
