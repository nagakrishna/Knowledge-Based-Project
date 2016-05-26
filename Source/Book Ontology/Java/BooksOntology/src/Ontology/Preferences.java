package Ontology;

import org.semanticweb.owlapi.model.IRI;

public class Preferences {
	
	public static final IRI DEFAULT_SCE_CLASS_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#SCE");
	
	public static final IRI DEFAULT_INDIVIDUAL_KDM_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#KDM");
	
	public static final IRI DEFAULT_STUDENT_CLASS_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#Student");
	
	public static final IRI DEFAULT_UMKC_CLASS_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#UMKC");
	
	
	
	//Books
	public static final IRI DEFAULT_WrittenBy_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#writtenBy");
	
	public static final IRI DEFAULT_InverseWrittenBy_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#InverseWrittenBy");
	
	public static final IRI DEFAULT_Isbn_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#hasIsbn");
	
	public static final IRI DEFAULT_InverseIsbn_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#InverseHasIsbn");
	
	public static final IRI DEFAULT_Published_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#publishedIn");
	
	public static final IRI DEFAULT_InversePublished_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#InversePublishedIn");
	
	public static final IRI DEFAULT_CategorizedAs_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#CategorizedAs");
	
	public static final IRI DEFAULT_InverseCategorizedAs_Property_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#InverseCategorizedAs");
	
	public static final IRI DEFAULT_Author_Class_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#Author");
	
	public static final IRI DEFAULT_Author2_Class_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#Johnson");
	
	public static final IRI DEFAULT_Year2011_Class_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#2011");
	
	public static final IRI DEFAULT_Category_Class_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#Category");
	
	public static final IRI DEFAULT_CategoryBibliography_Class_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#Bibliography");
	
	public static final IRI DEFAULT_Year_Class_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#Year");
	
	
//	public static final IRI DEFAULT_Isbn_Class_IRI = IRI.create("https://github.com/nagakrishna/Knowledge-Based-Project/ontology#hasIsbn");
	
	public IRI getSCEClassName() {
        return DEFAULT_SCE_CLASS_IRI;
    }
	
	public IRI getKDMIndividual() {
        return DEFAULT_INDIVIDUAL_KDM_IRI;
    }
	
	public IRI getStudentClassName() {
        return DEFAULT_STUDENT_CLASS_IRI;
    }
	
	public IRI getUmkcClassName() {
        return DEFAULT_UMKC_CLASS_IRI;
    }
	
	public IRI getWrittenByPropName() {
        return DEFAULT_WrittenBy_Property_IRI;
    }
	
	public IRI getInverseWrittenByPropName() {
        return DEFAULT_InverseWrittenBy_Property_IRI;
    }
	
	public IRI getCategrizedAsPropName() {
        return DEFAULT_CategorizedAs_Property_IRI;
    }
	
	public IRI getInverseCategrizedAsPropName() {
        return DEFAULT_InverseCategorizedAs_Property_IRI;
    }
	
	public IRI getHasIsbnPropName() {
        return DEFAULT_Isbn_Property_IRI;
    }
	
	public IRI getInverseHasIsbnPropName() {
        return DEFAULT_InverseIsbn_Property_IRI;
    }
	
	public IRI getPublishedInPropName() {
        return DEFAULT_Published_Property_IRI;
    }
	
	public IRI getInversePublishedInPropName() {
        return DEFAULT_InversePublished_Property_IRI;
    }
	
	public IRI getAuthorClassName() {
        return DEFAULT_Author_Class_IRI;
    }
	
	public IRI getAuthor2ClassName() {
        return DEFAULT_Author2_Class_IRI;
    }
	
	public IRI getYear2011ClassName() {
        return DEFAULT_Year2011_Class_IRI;
    }
	
	public IRI getCategoryClassName() {
        return DEFAULT_Category_Class_IRI;
    }
	
	public IRI getCategoryBibliographyClassName() {
        return DEFAULT_CategoryBibliography_Class_IRI;
    }
	
	public IRI getYearClassName() {
        return DEFAULT_Year_Class_IRI;
    }
}


