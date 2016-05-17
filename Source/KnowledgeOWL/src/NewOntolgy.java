import org.apache.jena.ontology.AllValuesFromRestriction;
import org.apache.jena.ontology.CardinalityQRestriction;
import org.apache.jena.ontology.CardinalityRestriction;
import org.apache.jena.ontology.ComplementClass;
import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.EnumeratedClass;
import org.apache.jena.ontology.HasValueRestriction;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.IntersectionClass;
import org.apache.jena.ontology.MaxCardinalityQRestriction;
import org.apache.jena.ontology.MaxCardinalityRestriction;
import org.apache.jena.ontology.MinCardinalityQRestriction;
import org.apache.jena.ontology.MinCardinalityRestriction;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.SomeValuesFromRestriction;
import org.apache.jena.ontology.UnionClass;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.update.GraphStore;
import org.apache.jena.update.GraphStoreFactory;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.OWL2;
import org.apache.jena.vocabulary.XSD;

public class NewOntolgy {
	
	public static void main(String args[]){
		String uriBase = "http://www.eswc2006.org/technologies/ontology";
		String NS = uriBase + "#";
		OntModel base = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM );
		base.createOntology(uriBase);
		
//		base.read(SOURCE, "RDF/XML");
		
		
		//Creating Classes
		OntClass UMKC = base.createClass(uriBase+"#UMKC");
		
		//Sub classes in UMKC
		OntClass Hospital = base.createClass(uriBase+"#Hospital");
		OntClass IS = base.createClass(uriBase+"#IS");
		OntClass Libraries = base.createClass(uriBase+"#Libraries");
		OntClass Schools = base.createClass(uriBase+"#Schools");
		OntClass Buildings = base.createClass(uriBase+"#Buildings");
		OntClass Swinney = base.createClass(uriBase+"#Swinney");
		UMKC.addSubClass(Hospital);
		UMKC.addSubClass(IS);
		UMKC.addSubClass(Libraries);
		UMKC.addSubClass(Schools);
		UMKC.addSubClass(Buildings);
		UMKC.addSubClass(Swinney);
		
		//Sub classes in Schools
		OntClass Arts = base.createClass(uriBase+"#Arts_and_Sciences");
		OntClass BS = base.createClass(uriBase+"#Bloch_School");
		OntClass SCE = base.createClass(uriBase+"#SCE");
		OntClass Medicine = base.createClass(uriBase+"#Medicine");
		OntClass LS = base.createClass(uriBase+"#Law_School");
		Schools.addSubClass(Arts);
		Schools.addSubClass(BS);
		Schools.addSubClass(SCE);
		Schools.addSubClass(Medicine);
		Schools.addSubClass(LS);
		
		//Sub classes in SCE
		OntClass Faculty = base.createClass(uriBase+"#Faculty");
		OntClass Student = base.createClass(uriBase+"#Student");
		OntClass Course = base.createClass(uriBase+"#Course");
		SCE.addSubClass(Faculty);
		SCE.addSubClass(Student);
		SCE.addSubClass(Course);
		
		//Sub classes in Hospital
		OntClass Doctor = base.createClass(uriBase+"#Doctor");
		OntClass Patient = base.createClass(uriBase+"#Patient");
		Hospital.addSubClass(Doctor);
		Hospital.addSubClass(Patient);
		
		//Sub classes in Hospital
		OntClass Sports = base.createClass(uriBase+"#Sports");
		OntClass Pool = base.createClass(uriBase+"#Pool");
		OntClass Gym = base.createClass(uriBase+"#Gym");
		Swinney.addSubClass(Sports);
		Swinney.addSubClass(Pool);
		Swinney.addSubClass(Gym);
		
		//Sub classes in Bloch School
		OntClass Professors_BS = base.createClass(uriBase+"#Professors_BS");
		OntClass Students_BS = base.createClass(uriBase+"#Students_BS");
		BS.addSubClass(Professors_BS);
		BS.addSubClass(Students_BS);
		
		
		//Sub classes in Gym
		OntClass Morning_Session = base.createClass(uriBase+"#Morning_Session");
		OntClass Afternoon_Session = base.createClass(uriBase+"#Afternoon_Session");
		OntClass Evening_Session = base.createClass(uriBase+"#Evening_Session");
		Gym.addSubClass(Morning_Session);
		Gym.addSubClass(Afternoon_Session);
		Gym.addSubClass(Evening_Session);
		
		//Sub classes in Gym
		OntClass Basket_Ball = base.createClass(uriBase+"#Basket_Ball");
		OntClass Volley_Ball = base.createClass(uriBase+"#Volley_Ball");
		OntClass Badminton = base.createClass(uriBase+"#Badminton");
		Sports.addSubClass(Basket_Ball);
		Sports.addSubClass(Volley_Ball);
		Sports.addSubClass(Badminton);
		
		//Sub classes in Pool
		OntClass Men_Pool = base.createClass(uriBase+"#Men_Pool");
		Pool.addSubClass(Men_Pool);		
		
		//Object Properties
		//Creating Object property enrolls
		ObjectProperty enrolls = base.createObjectProperty(uriBase+"#enrolls");
		enrolls.setDomain(Student);
		enrolls.setRange(Course);
		
		//Creating Object property offers
		ObjectProperty offers = base.createObjectProperty(uriBase+"#offers");
		offers.setDomain(SCE);
		offers.setRange(Course);
		
		//Creating Object property teaches
		ObjectProperty teaches = base.createObjectProperty(uriBase+"#teaches");
		teaches.setDomain(Faculty);
		teaches.setRange(Course);
		
		//Creating Connects Property for Buildings - Symmentric Property
		ObjectProperty connects = base.createObjectProperty(NS + "connects");
		connects.setDomain(Buildings);
		connects.setRange(Buildings);
		connects.convertToSymmetricProperty();
		connects.convertToTransitiveProperty();
		
		
		
		//Creating Data Properties
		
		DatatypeProperty ExamDate = base.createDatatypeProperty(NS+"ExamDate");
		ExamDate.addDomain(Course);
		ExamDate.addRange(XSD.integer);
		
		//Creating Individuals
		
		//Creating KDM course
		Individual KDM = base.createIndividual(NS+"KDM", Course);
	
		//Creating ASE course
		Individual ASE = base.createIndividual(NS + "ASE", Course);
		
		//Creating ASE course
		Individual PB = base.createIndividual(NS + "PB", Course);
		
		//Creating Faculty
		Individual Lee = base.createIndividual(NS + "Lee", Faculty);
		Lee.setPropertyValue(teaches, KDM);
		Lee.setPropertyValue(teaches, ASE);
		
		Individual Rao = base.createIndividual(NS + "Rao", Faculty);
		Rao.setPropertyValue(teaches, PB);
		
		//Creating Students - Individuals
		Individual Naga = base.createIndividual(NS + "Naga", Student);
		Naga.setPropertyValue(enrolls, KDM);
		Naga.setPropertyValue(enrolls, ASE);
		
		Individual Krishna = base.createIndividual(NS + "Krishna", Student);
		Krishna.setPropertyValue(enrolls, ASE);
		
		Individual Vadlamudi = base.createIndividual(NS + "Vadlamudi", Student);
		Vadlamudi.setPropertyValue(enrolls, PB);
		
		
		//Creating Building - Instances
		Individual FH = base.createIndividual(NS + "FH", Buildings);
		Individual Haag_Hall = base.createIndividual(NS + "Haag_Hall", Buildings);
		Individual Royal_Hall = base.createIndividual(NS + "Royal_Hall", Buildings);
		Individual Student_Union = base.createIndividual(NS + "Student_Union", Buildings);
		Individual ASSC = base.createIndividual(NS + "ASSC", Buildings);
		
		
//		Setting Exam Dates - Data property assertions
		base.add(KDM, ExamDate, "05-20-2016 09:00:00");
		base.add(ASE, ExamDate, "05-25-2016 09:00:00");
		base.add(PB, ExamDate, "05-30-2016 09:00:00");

		//Connecting buildings
		base.add(FH, connects, Haag_Hall);
		base.add(Haag_Hall, connects, Royal_Hall);
		
		
		
		//Transitive Property
		
		/*Functional Property - is same as setting cardinality to one
		 * Each faculty can offer Directory Reading to only one student
		 */

		ObjectProperty offers_DR = base.createObjectProperty(NS + "DR");
		offers_DR.setDomain(Faculty);
		offers_DR.setRange(Student);
		offers_DR.convertToFunctionalProperty();
		base.add(Lee, offers_DR, Naga);
		
		
		
		//Inverse of Property
		ObjectProperty treats = base.createObjectProperty(NS + "Treats");
		treats.setDomain(Doctor);
		treats.setRange(Patient);
		
		ObjectProperty gets_treatment = base.createObjectProperty(NS + "gets_treatment");
		gets_treatment.setDomain(Patient);
		gets_treatment.setRange(Doctor);
		gets_treatment.setInverseOf(treats);
		
		Individual Jim = base.createIndividual(NS + "Jim", Doctor);
		Individual George = base.createIndividual(NS + "George", Patient);
		
		base.add(Jim, treats, George);
		base.add(George, gets_treatment, Jim);
		
		/*Equivalent Property*/
		DatatypeProperty CourseFullName = base.createDatatypeProperty(NS + "CourseFullName");
		CourseFullName.setDomain(Course);
		CourseFullName.setRange(XSD.xstring);
		
		DatatypeProperty CourseTitle = base.createDatatypeProperty(NS + "CourseTitle");
		CourseTitle.setDomain(Course);
		CourseTitle.setRange(XSD.xstring);
		
		CourseTitle.setEquivalentProperty(CourseFullName);
		
		/* Some values from Property
		 * Professors, Students from Bloch School should register in at least one area (Subclass) of Swinney
		 * Now using some values from property - A Student should Register in 
		 * at least one session at Gym (morning or afternoon or evening session)
		 */
		ObjectProperty Register = base.createObjectProperty(NS + "Register");
		Register.setDomain(BS);
		Register.setRange(Swinney);
		SomeValuesFromRestriction svfr = base.createSomeValuesFromRestriction(null, Register, Gym);
		svfr.addSubClass(Students_BS);
		
		/*All Values from Property
		 * Schools can use all areas (Subclasses) of Swinney
		 * Restricting the Range of SCE to use only GYM in Swinney
		 * SCE can have all range values from only GYM
		 */
		ObjectProperty Uses = base.createObjectProperty(NS + "Uses");
		Uses.setDomain(Schools);
		Uses.setRange(Swinney);
		AllValuesFromRestriction avfr = base.createAllValuesFromRestriction(null, Uses, Gym);
		avfr.addSubClass(SCE);
		
		/*Has Value Restriction Property
		 * 
		 * 
		 */
		
//		HasValueRestriction hvr = base.createHasValueRestriction(uri, prop, value)
		
		
		/* Cardinality - Equivalent to functional property if Cardinality is 1
		 * Every Course will have single final exam data
		 */
		CardinalityRestriction cr = base.createCardinalityRestriction(null, ExamDate, 1);
		cr.addSubClass(Course);
		
		/*Min Cardinality - Minimum course that a student can enroll is 1
		 * Max Cardinality - Maxim number of courses that a student can enroll is 3
		 */
		MinCardinalityRestriction micr = base.createMinCardinalityRestriction(null, enrolls, 1);
		MaxCardinalityRestriction macr = base.createMaxCardinalityRestriction(null, enrolls, 3);
		micr.addSubClass(Student);
		macr.addSubClass(Student);
		
		
		/*Intersection Class - creating Sports_BS class
		 * Sports_BS = people from Bloch school who only registers in sports at Swinney
		 */
		
		
		AllValuesFromRestriction avfr1 = base.createAllValuesFromRestriction(null, Register, Sports);
		IntersectionClass Sports_B =
			    base.createIntersectionClass( NS + "Sports_BS",
			                               base.createList( new RDFNode[] {BS, avfr1} ) );
		
		/*Union Class - new class which have people from bloch school register from
		 * only in Gym and Sports at Swinney
		 */
		AllValuesFromRestriction registerSports = base.createAllValuesFromRestriction(null, Register, Sports);
		AllValuesFromRestriction registerGym = base.createAllValuesFromRestriction(null, Register, Gym);
		UnionClass GymSports = base.createUnionClass(NS + "GymSports", base.createList( new RDFNode[] {registerSports, registerGym} ));
		IntersectionClass GymSportsInter = base.createIntersectionClass(NS + "GymSportsInter", base.createList(new RDFNode[]{BS, GymSports}));
		
		/*Complement Class
		 * Assume 2 sub pools in Pool at Swinney, one already defined sub class Men_Pool
		 * Now other which is not yet defined is Women_Pool
		 * Women_Pool = Intersection of Pool and Complement of Men_Pool
		 */
		ComplementClass sampleClass =
			    base.createComplementClass( NS + "sampleClass", Men_Pool);
		IntersectionClass Women_Pool = 
				base.createIntersectionClass(NS + "Women_Pool",
					base.createList(new RDFNode[]{Pool, sampleClass}));
		
		/*Ennumerated Class 
		 * Create class who took Dr. Lee courses or can also add new students
		 */
		EnumeratedClass Lee_Students = base.createEnumeratedClass( NS + "Lee_Students", null );
		Lee_Students.addOneOf( Naga ) ;
		Lee_Students.addOneOf( Student.createIndividual( NS + "New_Student" ) );
		
		
		/*Equivalent Class
		 * 
		 */
		OntClass StudentOfLee = base.createClass(NS + "StudentOfLee");
		StudentOfLee.setEquivalentClass(Lee_Students);

		/*Disjoint Class
		 * Making Pool class disjoint with Gym and Sports
		 */		
		Pool.addDisjointWith(Gym);
		Pool.addDisjointWith(Sports);
		//Show Class Hierarchy
//		ClassHierarchy classHierarchy = new ClassHierarchy();
//		classHierarchy.showHierarchy(System.out, base);
				
		base.write(System.out, "RDF/XML-ABBREV");
//		base.writeAll(System.out, "TURTLE", null);
	}
	
}
