
package edu.csbsju;

import java.util.*;
import java.lang.*;
/**
 * This class Class the responsible for searching the database for a University.
 * This method works hand in hand with the Database in order to search and 
 * return to the user a list of universities that meet the Search criteria 
 * that the user entered 
 * @author jsupton
 * @version 03-21-17
 */
public class SearchController {
	
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
	
	 /**
	  * Default Constructor, This constructor creates a new DBContorller 
	  * object and then sets that to the DBController instance variable.
	  */
	 public SearchController() {
		 super();
		 this.d = new DBController();
	 }
	 
	 /**
	  * This method allows us to determine if the search criteria are empty or not.
	  * If all the search criteria are either null (if they are strings) or 0 (if they
	  * are double or int), then the method returns true.
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
	  * @return boolean, if the search criteria are empty it returns true.
	  */
	 public boolean criteriaEmpty(String universityName, String state, String location, String control, int numberOfStudentsLOWER,
			 	int numberOfStudentsUPPER, double percentFemaleLOWER, double percentFemaleUPPER, int satVerbalLOWER, int satVerbalUPPER, 
			 	int satMathLOWER, int satMathUPPER, double expensesLOWER, double expensesUPPER, double financialAidLOWER, double financialAidUPPER,  
			 	double numberOfApplicantsLOWER, int numberOfApplicantsUPPER, double percentAdmittedLOWER,double percentAdmittedUPPER, 
			 	double percentEnrolledLOWER,  double percentEnrolledUPPER, int academicScaleLOWER, int academicScaleUPPER, int socialScaleLOWER, 
			 	int socialScaleUPPER, int qualityOfLifeLOWER, int qualityOfLifeUPPER, List<String> emphases){
		 int i = 0;
		 for(String s:emphases){
			 i++;
		 }
	  return ((universityName==null) && (state==null) && ( location==null) && ( control==null) && ( numberOfStudentsLOWER==0) && (numberOfStudentsUPPER==0) &&
			  (percentFemaleLOWER==0.0) && ( percentFemaleUPPER==0.0) && ( satVerbalLOWER ==0) && ( satVerbalUPPER ==0) &&
			 	( satMathLOWER==0) && (satMathUPPER==0) &&( expensesLOWER==0.0) && (expensesUPPER==0.0) &&  (financialAidLOWER==0.0) && (financialAidUPPER==0.0)&&  
			 	( numberOfApplicantsLOWER==0) && ( numberOfApplicantsUPPER==0) && (percentAdmittedLOWER==0.0) && (percentAdmittedUPPER==0.0) && 
			 	( percentEnrolledLOWER==0.0)  && (percentEnrolledUPPER==0.0) && (academicScaleLOWER==0) && (academicScaleUPPER==0) && (socialScaleLOWER==0) 
			 	&& (socialScaleUPPER==0) && (qualityOfLifeLOWER==0) && (qualityOfLifeUPPER==0) && (i==0));
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
	  * @return ArrayList<University> a list of univeristy objects that match search criteria
	  */
	 public List<University> search(String universityName, String state, String location, String control, int numberOfStudentsLOWER,
			 	int numberOfStudentsUPPER, double percentFemaleLOWER, double percentFemaleUPPER, int satVerbalLOWER, int satVerbalUPPER, 
			 	int satMathLOWER, int satMathUPPER, double expensesLOWER, double expensesUPPER, double financialAidLOWER, double financialAidUPPER,  
			 	double numberOfApplicantsLOWER, int numberOfApplicantsUPPER, double percentAdmittedLOWER,double percentAdmittedUPPER, 
			 	double percentEnrolledLOWER,  double percentEnrolledUPPER, int academicScaleLOWER, int academicScaleUPPER, int socialScaleLOWER, 
			 	int socialScaleUPPER, int qualityOfLifeLOWER, int qualityOfLifeUPPER, List<String> emphases){
		 List<University> matches = new ArrayList<University>();
 		 List<University> s = new ArrayList<University>();
		 s = d.getAllUniversities();
		 boolean bo = criteriaEmpty( universityName, state, location, control, numberOfStudentsLOWER, numberOfStudentsUPPER, 
				    percentFemaleLOWER, percentFemaleUPPER, satVerbalLOWER, satVerbalUPPER, 
				    satMathLOWER, satMathUPPER, expensesLOWER, expensesUPPER, financialAidLOWER, financialAidUPPER,  
				 	numberOfApplicantsLOWER, numberOfApplicantsUPPER, percentAdmittedLOWER, percentAdmittedUPPER, 
				    percentEnrolledLOWER, percentEnrolledUPPER, academicScaleLOWER, academicScaleUPPER, socialScaleLOWER, 
				    socialScaleUPPER, qualityOfLifeLOWER, qualityOfLifeUPPER,emphases);
		 if(bo){
			 return s;
		 }
		 for(University university:s){
			 boolean b = true;
			 if(universityName !=null && b == true)
				 b = university.getUniversityName().contains(universityName);
			 if(state!=null && b == true)
				 b = university.getState().equals(state);
			 if(location!=null && b == true)
				 b = university.getLocation().equals(location);
			 if(control!=null && b == true)
				 b = university.getControl().equals(control);
			 if(numberOfStudentsLOWER !=0 && b == true){
				 if(numberOfStudentsUPPER !=0){
					 b = (university.getNumberOfStudents()>=numberOfStudentsLOWER && university.getNumberOfStudents()<=numberOfStudentsUPPER);
				 }
				 else
					 b = (university.getNumberOfStudents() >= numberOfStudentsLOWER);
			 }
			 if(percentFemaleLOWER!= 0.0 && b == true){
				 if(percentFemaleUPPER !=0){
					 b = (university.getPercentFemale()>=percentFemaleLOWER && university.getPercentFemale()<=percentFemaleUPPER);
				 }
				 else
					 b = (university.getPercentFemale() >= percentFemaleLOWER);
			 }	
			 if(satVerbalLOWER != 0 && b == true){
				 if(satVerbalUPPER !=0){
					 b = (university.getSatVerbal()>=satVerbalLOWER && university.getSatVerbal()<=satVerbalUPPER);
				 }
				 else 
					 b = (university.getSatVerbal() >= satVerbalLOWER);
			 }	
			 if(satMathLOWER!= 0 && b == true){
				 if(satMathUPPER !=0 && satMathUPPER>=satMathLOWER){
					 b = (university.getSatMath()>=satMathLOWER && university.getSatMath()<=satMathUPPER);
				 }
				 else
					 b = (university.getSatMath() >= satMathLOWER);
			 }	
			 if(expensesLOWER!= 0 && b == true){
				 if(expensesUPPER !=0){
					 b = (university.getExpenses()>=expensesLOWER && university.getExpenses()<=expensesUPPER);
				 }
				 else
					 b = (university.getExpenses() >= expensesLOWER);
			 }
			 if(financialAidLOWER != 0.0 && b == true){
				 if(financialAidUPPER !=0.0){
					 b = (university.getFinancialAid()>=financialAidLOWER && university.getFinancialAid()<=financialAidUPPER);
				 }
				 else
					 b = (university.getFinancialAid() >= financialAidLOWER);
			 }	
			 if(numberOfApplicantsLOWER != 0 && b == true){
				 if(numberOfApplicantsUPPER !=0){
					 b = (university.getNumberOfApplicants()>=numberOfApplicantsLOWER && university.getNumberOfApplicants()<=numberOfApplicantsUPPER);
				 }
				 else
					 b = (university.getNumberOfApplicants() >= numberOfApplicantsLOWER);
			 }
			 if(percentAdmittedLOWER != 0 && b == true){
				 if(percentAdmittedUPPER !=0){
					 b = (university.getPercentAdmitted()>=percentAdmittedLOWER && university.getPercentAdmitted()<=percentAdmittedUPPER);
				 }
				 else
					 b = (university.getPercentAdmitted() >= percentAdmittedLOWER);
			 }
			 if(percentEnrolledLOWER!=0.0 && b == true){
				 if(percentEnrolledUPPER !=0.0){
					 b = (university.getPercentEnrolled()>=percentEnrolledLOWER && university.getPercentEnrolled()<=percentEnrolledUPPER);
				 }
				 else
					 b = (university.getPercentEnrolled() >= percentEnrolledLOWER);
			 }
			 if(academicScaleLOWER!= 0 && b == true){
				 if(academicScaleUPPER !=0){
					 b = (university.getAcademicScale()>=academicScaleLOWER && university.getAcademicScale()<=academicScaleUPPER);
				 }
				 else
					 b = (university.getAcademicScale() >= academicScaleLOWER);
			 }
			 if(socialScaleLOWER!= 0 && b == true){
				 if(socialScaleUPPER !=0){
					 b = (university.getSocialScale()>=socialScaleLOWER && university.getSocialScale()<=socialScaleUPPER);
				 }
				 else
					 b = (university.getSocialScale() >= socialScaleLOWER);
			 }
			 if(qualityOfLifeLOWER!= 0 && b == true){
				 if(socialScaleUPPER !=0){
					 b = (university.getQualityOfLife()>=qualityOfLifeLOWER && university.getQualityOfLife()<=qualityOfLifeUPPER);
				 }
				 else
					 b = (university.getQualityOfLife() >= qualityOfLifeLOWER);
			 }
			 if(emphases!=null && b == true){
				for(String x : emphases){
					for(String y: university.getEmphases()){
						if(!(x.equals(y))){
							b = false;
							break;
						}
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
		 if(u!=null){
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
			 return matches;
		 }
		 return matches;
	 }
	 
	 /**
	  * A Main method that allows us to test if all of the methods in this class
	  * are performing correctly by themselves. 
	  * @param args the parameter value for the main method
	  */
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
