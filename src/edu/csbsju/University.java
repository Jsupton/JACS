package edu.csbsju;

import java.util.*;

/**
 * This Class is a class that models a university object. It takes
 * the attributes specified below and created a university object from them.
 * The University object is made up of several attributes that pertain
 * to a real University object.
 * @author ajdehn
 * @version 03-21-17
 */
public class University {
	
	/**
	 * This string instance variable represents the name of a
	 * specific university
	 */
	private String universityName;
	/**
	 * This string instance variable represents the Location of a
	 * specific university
	 */
	private String location;
	/**
	 * This string instance variable represents the state that a
	 * specific university is in
	 */
	private String state;
	/**
	 * This string instance variable represents the Control of a
	 * specific university
	 */
	private String control;
	/**
	 * This string instance variable represents the Number of students
	 * at a specific university
	 */
	private int numberOfStudents;
	/**
	 * This string instance variable represents the percent female at a
	 * specific university
	 */
	private double percentFemale;
	/**
	 * This string instance variable represents the Verbal SAT scores of a
	 * specific university
	 */
	private int satVerbal;
	/**
	 * This string instance variable represents the math SAT scores of a
	 * specific university
	 */
	private int satMath;
	/**
	 * This string instance variable represents the Expenses of a
	 * specific university
	 */
	private double expenses;
	/**
	 * This string instance variable represents the Financial Aid of a
	 * specific university
	 */
	private double financialAid;
	/**
	 * This string instance variable represents the Number of applicants of a
	 * specific university
	 */
	private int numberOfApplicants;
	/**
	 * This string instance variable represents the Percent Admitted of a
	 * specific university
	 */
	private double percentAdmitted;
	/**
	 * This string instance variable represents the percent Enrolled of a
	 * specific university
	 */
	private double percentEnrolled;
	/**
	 * This string instance variable represents the Academic Scale at a
	 * specific university
	 */
	private int academicScale;
	/**
	 * This string instance variable represents the Social Scale at a
	 * specific university
	 */
	private int socialScale;
	/**
	 * This string instance variable represents the Quality of life at a
	 * specific university
	 */
	private int qualityOfLife;
	/**
	 * This string instance variable represents the Emphases of a
	 * specific university
	 */
	private List<String> emphases;
	
	/**
	 * General Constructor making a University Object. Sets each parameter value to
	 * its corresponding instance variable.
	 * @param universityName The name of a university
	 * @param location The location of a university
	 * @param state The state of a university
	 * @param control The control of a university
	 * @param numberOfStudents the number of students at a university
	 * @param percentFemale the percent female of a university
	 * @param satVerbal SAT of a university
	 * @param satMath SAT of a university
	 * @param expenses The Expenses of a university
	 * @param financialAid the Financial aid at a university
	 * @param numberOfApplicants Number of Applicants of a university
	 * @param percentAdmitted The percent admitted of a university
	 * @param percentEnrolled The percent Enrolled of a university
	 * @param academicScale The academic scale of a university
	 * @param socialScale Social scale of a university
	 * @param qualityOfLife Quality of life of a university
	 * @param emphases emphases of a university
	 */
	public University(String universityName, String state, String location, String control, int numberOfStudents,
			double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
			double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife,
			List<String> emphases) {
		super();
		this.universityName = universityName;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numberOfStudents = numberOfStudents;
		this.percentFemale = percentFemale;
		this.satVerbal = satVerbal;
		this.satMath = satMath;
		this.expenses = expenses;
		this.financialAid = financialAid;
		this.numberOfApplicants = numberOfApplicants;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.qualityOfLife = qualityOfLife;
		this.emphases = emphases;
	}
	
	/**
	 * The constructor that only takes the name of an object. The university Name
	 * is set to the parameter value and the rest of the instance variables are 
	 * either set to null (if they are Strings) or to 0 (if they are double or int)
	 * @param universityName a name of a university
	 */
	public University(String universityName) {
		super();
		this.universityName = universityName;
		this.location = "-1";
		this.state = "-1";
		this.control = "-1";
		this.numberOfStudents = -1;
		this.percentFemale = -1.0;
		this.satVerbal = -1;
		this.satMath = -1;
		this.expenses = -1.0;
		this.financialAid = -1.0;
		this.numberOfApplicants = -1;
		this.percentAdmitted = -1.0;
		this.percentEnrolled = -1.0;
		this.academicScale = -1;
		this.socialScale = -1;
		this.qualityOfLife = -1;
		this.emphases = null;
	}

	/**
	 * gets the name of the university
	 * @return the universityName
	 */
	public String getUniversityName() {
		return universityName;
	}
	
	/**
	 * sets the name of the university
	 * @param universityName the universityName to set
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	/**
	 * gets the location of the university
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * sets the location of the university
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * gets the state that the university it in
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * sets the state that the university is in
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * gets the control of the university
	 * @return the control
	 */
	public String getControl() {
		return control;
	}
	
	/**
	 * sets the control of the university
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}
	
	/**
	 * gets the number of students at the university
	 * @return the numberOfStudents
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	/**
	 * sets the number of students at the university
	 * @param numberOfStudents the numberOfStudents to set
	 */
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
	/**
	 * gets the percent female at the university
	 * @return the percentFemale
	 */
	public double getPercentFemale() {
		return percentFemale;
	}
	
	/**
	 * sets the percent female at the university
	 * @param percentFemale the percentFemale to set
	 */
	public void setPercentFemale(double percentFemale) {
		this.percentFemale = percentFemale;
	}
	
	/**
	 * gets the Verbal SAT scores at a university
	 * @return the satVerbal
	 */
	public int getSatVerbal() {
		return satVerbal;
	}
	
	/**
	 * sets the verbal SAT scores at a university
	 * @param satVerbal the satVerbal to set
	 */
	public void setSatVerbal(int satVerbal) {
		this.satVerbal = satVerbal;
	}
	
	/**
	 * gets that Math SAT scores at a university
	 * @return the satMath
	 */
	public int getSatMath() {
		return satMath;
	}
	
	/**
	 * sets the math SAT scores at a university
	 * @param satMath the satMath to set
	 */
	public void setSatMath(int satMath) {
		this.satMath = satMath;
	}
	
	/**
	 * gets the expenses of a university
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}
	
	/**
	 * sets the expenses at a specified university
	 * @param expenses the expenses to set
	 */
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	
	/**
	 * gets the financial aid at a university
	 * @return the financialAid
	 */
	public double getFinancialAid() {
		return financialAid;
	}
	
	/**
	 * sets the financial aid at a university
	 * @param financialAid the financialAid to set
	 */
	public void setFinancialAid(double financialAid) {
		this.financialAid = financialAid;
	}
	
	/**
	 * gets the number of Applicants at a university
	 * @return the numberOfApplicants
	 */
	public int getNumberOfApplicants() {
		return numberOfApplicants;
	}
	
	/**
	 * sets the number of applicants at a university
	 * @param numberOfApplicants the numberOfApplicants to set
	 */
	public void setNumberOfApplicants(int numberOfApplicants) {
		this.numberOfApplicants = numberOfApplicants;
	}
	
	/**
	 * gets the percent admitted at a university
	 * @return the percentAdmitted
	 */
	public Double getPercentAdmitted() {
		return percentAdmitted;
	}
	
	/**
	 * sets the percent admitted at a university
	 * @param percentAdmitted the percentAdmitted to set
	 */
	public void setPercentAdmitted(Double percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}
	
	/**
	 * gets the percent enrolled at a university
	 * @return the percentEnrolled
	 */
	public Double getPercentEnrolled() {
		return percentEnrolled;
	}
	
	/**
	 * sets the percent enrolled at a university
	 * @param percentEnrolled the percentEnrolled to set
	 */
	public void setPercentEnrolled(Double percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}
	
	/**
	 * gets the academic scale of a university
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return academicScale;
	}
	
	/**
	 * sets the Academic scale of a university
	 * @param academicScale the academicScale to set
	 */
	public void setAcademicScale(int academicScale) {
		this.academicScale = academicScale;
	}
	
	/**
	 * gets the Social Scale at a university
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}
	
	/**
	 * sets the social Scale at a university
	 * @param socialScale the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}
	
	/**
	 * gets the "Quality of life" at a university
	 * @return the qualityOfLife
	 */
	public int getQualityOfLife() {
		return qualityOfLife;
	}
	
	/**
	 * sets the "Quality of life" at a university
	 * @param qualityOfLife the qualityOfLife to set
	 */
	public void setQualityOfLife(int qualityOfLife) {
		this.qualityOfLife = qualityOfLife;
	}
	
	/**
	 * gets all the Emphases at a university
	 * @return the emphases
	 */
	public List<String> getEmphases() {
		return emphases;
	}

	/**
	 * This is like a toString method. It prints out all of the 
	 * attributes for a given University.
	 */
	public void printString() {
		System.out.println( "Name: \t\t\t" + universityName + "\nLocation: \t\t" + location + "\nState: \t\t\t" + state
				+ "\nControl: \t\t" + control + "\nNumber Of Students: \t" + numberOfStudents + "\nPercent Female: \t" + percentFemale
				+ "\nSAT Verbal: \t\t" + satVerbal + "\nSAT Math: \t\t" + satMath + "\nExpenses: \t\t" + expenses + "\nfinancialAid: \t\t"
				+ financialAid + "\nNumber Of Applicants: \t" + numberOfApplicants + "\nPercent Admitted: \t" + percentAdmitted
				+ "\nPercen tEnrolled: \t" + percentEnrolled + "\nAcademic Scale: \t" + academicScale + "\nSocial Scale: \t\t"
				+ socialScale + "\nQuality Of Life: \t" + qualityOfLife + "\nEmphases: \t\t" + emphases + "]\n");
	}
	
	/**
	 * adds an emphases to the list
	 * @param emp String representing the emphases
	 */
	public void addEmphases(String emp){
		emphases.add(emp);
	}
	
	/**
	 * adds an emphases to the list
	 * @param emp String representing the emphases
	 */
	public void removeEmphases(String emp){
		for(String e:emphases){
			if(emp.equals(e)){
				emphases.remove(e);
			}
		}
	}
	
	/**
	   * This method allows an admin to be able to edit a university object
	   * The changes are sent to the Database to save the changes
	   * @param universityName The name of a university
	   * @param location The location of a university
	   * @param state The state of a university
	   * @param control The control of a university
	   * @param numberOfStudents the number of students at a university
	   * @param percentFemale the percent female of a university
	   * @param satVerbal SAT of a university
	   * @param satMath SAT of a university
	   * @param expenses The Expenses of a university
	   * @param financialAid the Financial aid at a university
	   * @param numberOfApplicants Number of Applicants of a university
	   * @param percentAdmitted The percent admitted of a university
	   * @param percentEnrolled The percent Enrolled of a university
	   * @param academicScale The academic scale of a university
	   * @param socialScale Social scale of a university
	   * @param qualityOfLife Quality of life of a university
	   * @return the newly changes university object
	   */
	  public University editUniversity(String universityName, String state, String location, String control, int numberOfStudents,
	                             double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
	                             double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife){
		   if(state!=null){
			   this.setState(state);
		   }
		   if(location!=null){
			   this.setLocation(location);
		   }
		   if(control!=null){
			   this.setControl(control);
		   }
		   if(numberOfStudents!=0){
			   this.setNumberOfStudents(numberOfStudents);
		   }
		   if(percentFemale!=0.0){
			   this.setPercentFemale(percentFemale);
		   }
		   if(satVerbal!=0){
			   this.setSatVerbal(satVerbal);
		   }
		   if(satMath!=0){
			   this.setSatMath(satMath);
		   }
		   if(expenses!=0.0){
			   this.setExpenses(expenses);
		   }
		   if(financialAid!=0.0){
			   this.setFinancialAid(financialAid);
		   }
		   if(numberOfApplicants!=0){
			   this.setNumberOfApplicants(numberOfApplicants);
		   }
		   if(percentAdmitted!=0.0){
			   this.setPercentAdmitted(percentAdmitted);
		   }
		   if(percentEnrolled!=0.0){
			   this.setPercentEnrolled(percentEnrolled);
		   }
		   if(academicScale!=0.0){
			   this.setAcademicScale(academicScale);
		   }
		   if(socialScale!=0.0){
			   this.setSocialScale(socialScale);
		   }
		   if(qualityOfLife!=0.0){
			   this.setQualityOfLife(qualityOfLife);
		   }
		   return this;
	  }
	  
	  /**
	   * This method allows an admin to be able to edit a university object
	   * The changes are sent to the Database to save the changes
	   * @param universityName The name of a university
	   * @param location The location of a university
	   * @param state The state of a university
	   * @param control The control of a university
	   * @param numberOfStudents the number of students at a university
	   * @param percentFemale the percent female of a university
	   * @param satVerbal SAT of a university
	   * @param satMath SAT of a university
	   * @param expenses The Expenses of a university
	   * @param financialAid the Financial aid at a university
	   * @param numberOfApplicants Number of Applicants of a university
	   * @param percentAdmitted The percent admitted of a university
	   * @param percentEnrolled The percent Enrolled of a university
	   * @param academicScale The academic scale of a university
	   * @param socialScale Social scale of a university
	   * @param qualityOfLife Quality of life of a university
	   * @return the newly added University object
	   */
	  public University addUniversity(String universityName, String state, String location, String control, int numberOfStudents,
	                            double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
	                            double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife){
	    University u = new University(universityName, state, location, control, numberOfStudents,
	                    percentFemale, satVerbal, satMath, expenses, financialAid, numberOfApplicants,
	                    percentAdmitted, percentEnrolled, academicScale, socialScale, qualityOfLife, null);
	   return u;
	  }

	/**
	 * Main METHOD, used in order to test to make sure that all methods
	 * within this class alone perform their function correctly.
	 * @param args the parameter value for the main method 
	 */
	public static void main(String args[]){
		ArrayList<String> l = new ArrayList<String>();
		l.add("Beer");
		l.add("Popcorn");
		University u = new University("St. John's University","Minnesota","RURAL","MATH",2112,0,1300,1350,52433.0,25000.0,1000,68.0,98.0,5,5,5,l);
		u.printString();
		
	}
	
	

}