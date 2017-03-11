
package edu.csbsju;

import java.util.*;
import java.util.Comparator; 
import java.lang.*;
/**
 * This class Class the responsible for searching the database for a University.
 * This method works hand in hand with the Database in order to search and 
 * return to the user a list of universities that meet the Search criteria 
 * that the user entered 
 * @author jsupton
 * @version 02-26-17
 */
public class SearchController {
	
	/**
	 * This is an Account object instance variable
	 */
	private Account a;
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
	/**
	 * This is a University object used to access a University
	 */
	private University u;
	
	 /**
	  * Default Constructor
	  */
	 public SearchController() {
		 super();
		 this.d = new DBController();
		 this.a = null;
		 this.u = null;
	 }
	
	 /**
	  * This method allows the user to search for a specific university. It takes 
	  * in a University object as a parameter. The attributes for the university object are
	  * the search criteria that the user input. The search criteria is used to search the 
	  * Database. All universities that match the attributes of the search criteria are 
	  * gathered into an arrayList.
	  * @return ArrayList<University>
	  */
	 public List<University> search(University u){
		 List<University> matches = new ArrayList<University>();
 		 List<University> s = new ArrayList<University>();
		 s = d.getAllUniversities();
		 for(University university:s){
			 boolean b = true;
			 if(u.getUniversityName()!=null && b == true)
				 b = university.getUniversityName().contains(u.getUniversityName());
			 else if(u.getState()!=null && b == true)
				 b = university.getState().equals(u.getState());
			 else if(u.getLocation()!=null && b == true)
				 b = university.getLocation().equals(u.getLocation());
			 else if(u.getControl()!=null && b == true)
				 b = university.getControl().equals(u.getControl());
			 else if(u.getNumberOfStudents()!=0 && b == true)
				 b = university.getNumberOfStudents() == (u.getNumberOfStudents());
			 else if(u.getPercentFemale()!= 0 && b == true)
				 b = university.getPercentFemale() == (u.getPercentFemale());
			 else if(u.getSatVerbal()!= 0 && b == true)
				 b = university.getSatVerbal() == (u.getSatVerbal());
			 else if(u.getExpenses()!= 0.0 && b == true)
				 b = university.getExpenses() == (u.getExpenses());
			 else if(u.getFinancialAid()!= 0.0 && b == true)
				 b = university.getFinancialAid() == (u.getFinancialAid());
			 else if(u.getNumberOfApplicants()!= 0 && b == true)
				 b = university.getNumberOfApplicants() == (u.getNumberOfApplicants());
			 else if(u.getPercentAdmitted()!= 0.0 && b == true)
				 b = university.getPercentAdmitted() == (u.getPercentAdmitted());
			 else if(u.getPercentEnrolled()!= 0.0 && b == true)
				 b = university.getPercentEnrolled() == (u.getPercentEnrolled());
			 else if(u.getAcademicScale()!= 0.0 && b == true)
				 b = university.getAcademicScale() == (u.getAcademicScale());
			 else if(u.getSocialScale()!= 0.0 && b == true)
				 b = university.getSocialScale() == (u.getSocialScale());
			 else if(u.getEmphases()!=null && b == true){
				 b = false;
				 for(String x : u.getEmphases()){
					 for(String y: university.getEmphases()){
						 if(x.equals(y))
								 b = true;
					 }
				 }
			 }
			 if(b == true){
				 matches.add(university);
			 }
		 }
	  return matches;
	 }
	 
	 /**
	  * /**
	  * This method allows the user to search for a specific university. It takes 
	  * in a University object as a parameter. The attributes for the university object are
	  * the search criteria that the user input. The search criteria is used to search the 
	  * Database. All universities that match the attributes of the search criteria are 
	  * gathered into an arrayList.
	  * @param universityName the name of the university
	  * @param location the location (SUBURBAN,URBAN,SMALL-CITY or -1 for unknown)
	  * @param state the state the university is in
	  * @param control (PRIVATE,STATE,CITY, or -1 for unknown
	  * @param numberOfStudentsLOWER the lower bound of number of students
	  * @param numberOfStudentsUPPER the upper bound of number of students
	  * @param percentFemaleLOWER the lower bound for percent female
	  * @param percentFemaleUPPER the upper bound for percent female
	  * @param satVerbalLOWER the lower bound for verbal sat scores
	  * @param satVerbalUPPER the upper bound for verbal sat scores
	  * @param satMathLOWER the lower bound for math sat scores
	  * @param satMathUPPER the upper bound for math sat scores
	  * @param expensesLOWER the lower bound for expenses
	  * @param expensesUPPER the upper bound for expenses
	  * @param financialAidLOWER the lower bound for financial aid
	  * @param financialAidUPPER the upper bound for financial aid
	  * @param numberOfApplicantsLOWER the lower bound for the number of applicants
	  * @param numberOfApplicantsUPPER the upper bound for the number of applicants
	  * @param percentAdmittedLOWER the lower bound for the percent of students admitted
	  * @param percentAdmittedUPPER the upper bound for the percent of students admitted
	  * @param percentEnrolledLOWER the lower bound for the percent enrolled
	  * @param percentEnrolledUPPER the upper bound for the percent enrolled
	  * @param academicScaleLOWER the upper bound for the academic scale
	  * @param academicScaleUPPER the upper bound for the academic Scale
	  * @param socialScaleLOWER the lower bound for the social scale
	  * @param socialScaleUPPER the upper bound for the social scale
	  * @param qualityOfLifeLOWER the lower bound for the quality of life
	  * @param qualityOfLifeUPPER the upper bound for the quality of life
	  * @param emphases the emphases for a university
	  * @return ArrayList<University>
	  */
	 public List<University> search(String universityName, String state, String location, String control, String numberOfStudentsLOWER,
			 	String numberOfStudentsUPPER, String percentFemaleLOWER, String percentFemaleUPPER, String satVerbalLOWER, String satVerbalUPPER, 
			 	String satMathLOWER, String satMathUPPER, String expensesLOWER, String expensesUPPER, String financialAidLOWER, String financialAidUPPER,  
			 	String numberOfApplicantsLOWER, String numberOfApplicantsUPPER, String percentAdmittedLOWER,String percentAdmittedUPPER, 
			 	String percentEnrolledLOWER,  String percentEnrolledUPPER, String academicScaleLOWER, String academicScaleUPPER, String socialScaleLOWER, 
			 	String socialScaleUPPER, String qualityOfLifeLOWER, String qualityOfLifeUPPER, List<String> emphases){
		 List<University> matches = new ArrayList<University>();
 		 List<University> s = new ArrayList<University>();
		 s = d.getAllUniversities();
		 for(University university:s){
			 boolean b = true;
			 if(universityName!=null && b == true)
				 b = university.getUniversityName().contains(universityName);
			 else if(state!=null && b == true)
				 b = university.getState().equals(state);
			 else if(location!=null && b == true)
				 b = university.getLocation().equals(location);
			 else if(control!=null && b == true)
				 b = university.getControl().equals(control);
			 else if(numberOfStudentsLOWER !=null && b == true){
				 int nosl = (Integer.parseInt(numberOfStudentsLOWER));
				 if(numberOfStudentsUPPER !=null){
					 int nosu = (Integer.parseInt(numberOfStudentsLOWER));
					 b = (university.getNumberOfStudents()>=nosl && university.getNumberOfStudents()<=nosu);
				 }
				 b = (university.getNumberOfStudents() >= nosl);
			 }
			 else if(percentFemaleLOWER!= null && b == true){
				 int pfl = (Integer.parseInt(percentFemaleLOWER));
				 if(percentFemaleUPPER !=null){
					 int pfu = (Integer.parseInt(percentFemaleUPPER));
					 b = (university.getPercentFemale()>=pfl && university.getPercentFemale()<=pfu);
				 }
				 b = (university.getPercentFemale() >= pfl);
			 }	
			 else if(satVerbalLOWER != null && b == true){
				 int svl = (Integer.parseInt(satVerbalLOWER));
				 if(satVerbalUPPER !=null){
					 int svu = (Integer.parseInt(satVerbalUPPER));
					 b = (university.getSatVerbal()>=svl && university.getSatVerbal()<=svu);
				 }
				 b = (university.getSatVerbal() >= svl);
			 }	
			 else if(satMathLOWER!= null && b == true){
				 int sml = (Integer.parseInt(satMathLOWER));
				 if(satMathUPPER !=null){
					 int smu = (Integer.parseInt(satMathUPPER));
					 b = (university.getSatMath()>=sml && university.getSatMath()<=smu);
				 }
				 b = (university.getSatMath() >= sml);
			 }	
			 else if(financialAidLOWER != null && b == true){
				 int fal = (Integer.parseInt(financialAidLOWER));
				 if(financialAidUPPER !=null){
					 int fau = (Integer.parseInt(financialAidUPPER));
					 b = (university.getFinancialAid()>=fal && university.getFinancialAid()<=fau);
				 }
				 b = (university.getFinancialAid() >= fal);
			 }	
			 else if(numberOfApplicantsLOWER != null && b == true){
				 int noal = (Integer.parseInt(numberOfApplicantsLOWER));
				 if(numberOfApplicantsUPPER !=null){
					 int noau = (Integer.parseInt(numberOfApplicantsUPPER));
					 b = (university.getNumberOfApplicants()>=noal && university.getNumberOfApplicants()<=noau);
				 }
				 b = (university.getNumberOfApplicants() >= noal);
			 }
			 else if(percentAdmittedLOWER != null && b == true){
				 int pal = (Integer.parseInt(percentAdmittedLOWER));
				 if(percentAdmittedUPPER !=null){
					 int pau = (Integer.parseInt(percentAdmittedUPPER));
					 b = (university.getPercentAdmitted()>=pal && university.getPercentAdmitted()<=pau);
				 }
				 b = (university.getPercentAdmitted() >= pal);
			 }
			 else if(percentEnrolledLOWER!=null && b == true){
				 int pel = (Integer.parseInt(percentEnrolledLOWER));
				 if(percentEnrolledUPPER !=null){
					 int peu = (Integer.parseInt(percentEnrolledUPPER));
					 b = (university.getPercentEnrolled()>=pel && university.getPercentEnrolled()<=peu);
				 }
				 b = (university.getPercentEnrolled() >= pel);
			 }
			 else if(academicScaleLOWER!= null && b == true){
				 int asl = (Integer.parseInt(academicScaleLOWER));
				 if(academicScaleUPPER !=null){
					 int asu = (Integer.parseInt(academicScaleUPPER));
					 b = (university.getAcademicScale()>=asl && university.getAcademicScale()<=asu);
				 }
				 b = (university.getAcademicScale() >= asl);
			 }
			 else if(socialScaleLOWER!= null && b == true){
				 int ssl = (Integer.parseInt(socialScaleLOWER));
				 if(socialScaleUPPER !=null){
					 int ssu = (Integer.parseInt(socialScaleUPPER));
					 b = (university.getSocialScale()>=ssl && university.getSocialScale()<=ssu);
				 }
				 b = (university.getSocialScale() >= ssl);
			 }
			 else if(u.getEmphases()!=null && b == true){
				 b = false;
				 for(String x : u.getEmphases()){
					 for(String y: university.getEmphases()){
						 if(x.equals(y))
								 b = true;
					 }
				 }
			 }
			 if(b == true){
				 matches.add(university);
			 }
		 }
	  return matches;
	 }
	 
	 /**
	  * This method allows the user to search for a specific university. It takes 
	  * in a University object as a parameter. The attributes for the university object are
	  * the search criteria that the user input. The search criteria is used to search the 
	  * Database. All universities that match the attributes of the search criteria are 
	  * gathered into an arrayList.
	  * @return Account
	  */
	 public Account search(String u){
		 Account newAccount;
		 ArrayList<Account> accounts = d.getAccounts();
		 for(Account ac:accounts){
			 if(u.equals(ac.getUsername())){
				 return ac;
			 }
		 }
	  return null;
	 }
	 
	 /**
	  * This method takes a university object in as a parameter, and then goes through every
	  * Other University in the Database to determine its distance from that given university. To
	  * figure out this distance, we simply subtract each attribute from the parameter university object
	  * with that of each of the other universities, then divide that by the difference of the largest and smallest
	  * attribute values of all the universities. If the attributes are strings, we simply add one for that value 
	  * if they are different, and 0 if they are the same.
	  * @param u University Object
	  * @return List of 5 universities closest to the Given university
	  */
	 public List<University> display5Schools(University u){
		 int maxNumberOfStudents = 0, minNumberOfStudents = 0;
		 double minPercentFemale = 0.0, maxPercentFemale = 0.0;
		 int minSatVerbal = 0, maxSatVerbal = 0;
		 int minSatMath = 0, maxSatMath = 0;
		 double minExpenses = 0.0, maxExpenses = 0.0;
		 double minFinancialAid = 0.0, maxFinancialAid = 0.0;
		 int minNumberOfApplicants = 0, maxNumberOfApplicants = 0;
		 double minPercentAdmitted = 0, maxPercentAdmitted = 0.0;
		 double minPercentEnrolled = 0, maxPercentEnrolled = 0.0;
		 int minAcademicScale = 0, maxAcademicScale = 0;
		 int minSocialScale = 0, maxSocialScale = 0;
		 int minQualityOfLife = 0, maxQualityOfLife = 0;
		 List<University> l = new ArrayList<University>();
		 l = d.getAllUniversities();
		 String[][] distance = new String[l.size()-1][2];
		 List<University> matches = new ArrayList<University>();
		 for(University uni:l){
			 if(!(u.getUniversityName().equals(uni.getUniversityName()))){
				 //These two if statements finds the max and min of the number of students 
				 if(uni.getNumberOfStudents()<minNumberOfStudents)
					 minNumberOfStudents = uni.getNumberOfStudents();
				 else if(uni.getNumberOfStudents()>maxNumberOfStudents)
					 maxNumberOfStudents = uni.getNumberOfStudents();
				 //These two if statements finds the max and the min of the percent female
				 if(uni.getPercentFemale()<minPercentFemale)
					 minPercentFemale = uni.getPercentFemale();
				 else if(uni.getPercentFemale()>maxPercentFemale)
					 maxPercentFemale = uni.getPercentFemale();
				//These two if statements finds the max and the min of the satVerbal score
				 if(uni.getSatVerbal()<minSatVerbal)
					 minSatVerbal = uni.getSatVerbal();
				 else if(uni.getSatVerbal()>maxSatVerbal)
					 maxSatVerbal = uni.getSatVerbal();
				//These two if statements finds the max and the min of the satMath score
				 if(uni.getSatMath()<minSatMath)
					 minSatMath = uni.getSatMath();
				 else if(uni.getSatMath()>maxSatMath)
					 maxSatMath = uni.getSatMath();
				//These two if statements finds the max and the min of the Expenses
				 if(uni.getExpenses()<minExpenses)
					 minExpenses = uni.getExpenses();
				 else if(uni.getExpenses()>maxExpenses)
					 maxExpenses = uni.getExpenses();
				//These two if statements finds the max and the min of the Financial Aid
				 if(uni.getFinancialAid()<minFinancialAid)
					 minFinancialAid = uni.getFinancialAid();
				 else if(uni.getFinancialAid()>maxFinancialAid)
					 maxFinancialAid = uni.getFinancialAid();
				//These two if statements finds the max and the min of the number of Applicants
				 if(uni.getNumberOfApplicants()<minNumberOfApplicants)
					 minNumberOfApplicants = uni.getNumberOfApplicants();
				 else if(uni.getNumberOfApplicants()>maxNumberOfApplicants)
					 maxNumberOfApplicants = uni.getNumberOfApplicants();
				//These two if statements finds the max and the min of the Percent Admitted
				 if(uni.getPercentAdmitted()<minPercentAdmitted)
					 minPercentAdmitted = uni.getPercentAdmitted();
				 else if(uni.getPercentAdmitted()>maxPercentAdmitted)
					 maxPercentAdmitted = uni.getPercentAdmitted();
				//These two if statements finds the max and the min of the Percent Enrolled
				 if(uni.getPercentEnrolled()<minPercentEnrolled)
					 minPercentEnrolled = uni.getPercentEnrolled();
				 else if(uni.getPercentEnrolled()>maxPercentEnrolled)
					 maxPercentEnrolled = uni.getPercentEnrolled();
				//These two if statements finds the max and the min of the Academic Scale
				 if(uni.getAcademicScale()<minAcademicScale)
					 minAcademicScale = uni.getAcademicScale();
				 else if(uni.getAcademicScale()>maxAcademicScale)
					 maxAcademicScale = uni.getAcademicScale();
				//These two if statements finds the max and the min of the Social Scale
				 if(uni.getSocialScale()<minSocialScale)
					 minSocialScale = uni.getSocialScale();
				 else if(uni.getSocialScale()>maxSocialScale)
					 maxSocialScale = uni.getSocialScale();
				//These two if statements finds the max and the min of the Quality of life
				 if(uni.getQualityOfLife()<minQualityOfLife)
					 minQualityOfLife = uni.getQualityOfLife();
				 else if(uni.getQualityOfLife()>maxQualityOfLife)
					 maxQualityOfLife = uni.getQualityOfLife();
			 }
		 }
		 int i = 0;
		 for(University uni:l){
			 double sum = 0;
			 if(!(u.getUniversityName().equals(uni.getUniversityName()))){
				 //gets the distance between the university parameter and the university object's name
				 if(!(uni.getUniversityName().equals(u.getUniversityName())))
					 sum =+ 1;
				 //gets the distance between the university parameter and the university object's state
				 if(!(uni.getState().equals(u.getState())))
					 sum =+1;
				 //gets the distance between the university parameter and the university object's location
				 if(!(uni.getLocation().equals(u.getLocation())))
					 sum =+1;
				 //gets the distance between the university parameter and the university object's control
				 if(!(uni.getControl().equals(u.getControl())))
					 sum =+1;
				 //gets the distance between the university parameter and the university object's number of students
				 double sum1 = (Math.abs((double)u.getNumberOfStudents()-(double)uni.getNumberOfStudents())) / (Math.abs((double)maxNumberOfStudents - (double)minNumberOfStudents));
				 //gets the distance between the university parameter and the university object's percent Female
				 double sum2 =+ (Math.abs(u.getPercentFemale()-uni.getPercentFemale())) / (Math.abs(maxPercentFemale - minPercentFemale));
				 //gets the distance between the university parameter and the university object's SAT Verbal score
				 double sum3 =+ (Math.abs((double)u.getSatVerbal()-(double)uni.getSatVerbal())) / (Math.abs((double)maxSatVerbal - (double)minSatVerbal));
				 //gets the distance between the university parameter and the university object's SAT Math score
				 double sum4 =+ (Math.abs((double)u.getSatMath()-(double)uni.getSatMath())) / (Math.abs((double)maxSatMath - (double)minSatMath));
				 //gets the distance between the university parameter and the university object's Expenses
				 double sum5 =+ (Math.abs(u.getExpenses()-uni.getExpenses())) / (Math.abs(maxExpenses - minExpenses));
				 //gets the distance between the university parameter and the university object's % financial Aid
				 double sum6 =+ (Math.abs(u.getFinancialAid()-uni.getFinancialAid())) / (Math.abs(maxFinancialAid - minFinancialAid));
				 //gets the distance between the university parameter and the university object's number of applicants
				 double sum7 =+ (Math.abs((double)u.getNumberOfApplicants()-(double)uni.getNumberOfApplicants())) / (Math.abs((double)maxNumberOfApplicants - (double)minNumberOfApplicants));
				 //gets the distance between the university parameter and the university object's % admitted
				 double sum8 =+ (Math.abs(u.getPercentAdmitted()-uni.getPercentAdmitted())) / (Math.abs(maxPercentAdmitted - minPercentAdmitted));
				 //gets the distance between the university parameter and the university object's % enrolled
				 double sum9 =+ (Math.abs(u.getPercentEnrolled()-uni.getPercentEnrolled())) / (Math.abs(maxPercentEnrolled - minPercentEnrolled));
				 //gets the distance between the university parameter and the university object's Academic Scale
				 double sum10 =+ (Math.abs((double)u.getAcademicScale()-(double)uni.getAcademicScale())) / (Math.abs((double)maxAcademicScale - (double)minAcademicScale));
				 //gets the distance between the university parameter and the university object's Social Scale
				 double sum11 =+ (Math.abs((double)u.getSocialScale()-(double)uni.getSocialScale())) / (Math.abs((double)maxSocialScale - (double)minSocialScale));
				 //gets the distance between the university parameter and the university object's Quality of life
				 double sum12 =+ (Math.abs((double)u.getQualityOfLife()-(double)uni.getQualityOfLife())) / (Math.abs((double)maxQualityOfLife - (double)minQualityOfLife));
				
				 sum = sum+sum1+sum2+sum3+sum4+sum5+sum6+sum7+sum8+sum9+sum10+sum11+sum12;
				 distance[i][0] = uni.getUniversityName();
				 distance[i][1] = Double.toString(sum);
				 i++;
			 }
		 }
		 //Sorts the distance array by the second column. It compares
		 //The two strings and then puts them in the correct order
		 Arrays.sort(distance, new Comparator<String[]>() {
		 @Override
		 public int compare(final String[] x, final String[] y) {
			 final String distance1 = x[1];
		     final String distance2 = y[1];
		     return distance1.compareTo(distance2);
		     }
		 });
		 
		 //Displays the sorted Distances, just for testing purposes
		 //System.out.print("\nSORTED DISTANCES \n");
	     //for (final String[] s : distance) {
		     //System.out.println(s[0] + " " + s[1]);}
		 
		 //gets the 5 top schools in the sorted list, and then puts them in an 
		 //array list of university objects
		 for(i=0;i<5;i++){
			 University x = d.getAUniversity(distance[i][0]);
			 matches.add(x);
		 }
		 
		 for(University university: matches){
			 university.printString();
		 }
		 return matches;
	 }
	 
	 public static void main(String args[]){
		 SearchController sc = new SearchController();
		 ArrayList<String> l = new ArrayList<String>();
		 //gives you all suburban colleges
		 University u = new University("YANKTOWN COLLEGE","SUBURBAN","SOUTH DAKOTA","PRIVATE",10000, 30.0, 450, 400, 15736.0,
				 95.0, 4000, 95.0, 90.0, 1, 2, 2, null);
		 University x = new University(null, null,"SUBURBAN",null,0,0,0,0,0.0,0.0,0,0.0,0.0,0,0,0,l);
		 //List<University> s = sc.search(x);
		 //List<University> y = sc.search(null,null, "SUBURBAN", null, null, null, null, null, null, null, 
			 	//"400", "600", null, null, null, null, null, null, "50","100", null,  null, null, null, null, 
			 	//null,null, null, null);
		 //for(University p: y){
			//p.printString();}
	 	sc.display5Schools(u);
	 }
	 
}
