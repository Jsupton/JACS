package edu.csbsju;

import java.util.*;

/**
 * This Class is a class that models a university object. I takes
 * the attributes specified below and created a university object from them
 * @author ajdehn
 * @version 02-26-17
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
	 * General Constructor making a University Object
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
	 * @param emphases empases of a university
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
	 * The constructor that only takes the name of an object
	 * @param universityName
	 */
	public University(String universityName) {
		super();
		this.universityName = universityName;
		this.location = null;
		this.state = null;
		this.control = null;
		this.numberOfStudents = 0;
		this.percentFemale = 0;
		this.satVerbal = 0;
		this.satMath = 0;
		this.expenses = 0.0;
		this.financialAid = 0.0;
		this.numberOfApplicants = 0;
		this.percentAdmitted = 0.0;
		this.percentEnrolled = 0.0;
		this.academicScale = 0;
		this.socialScale = 0;
		this.qualityOfLife = 0;
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
	 * sets the exepenses at a specified university
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


	public void printString() {
		System.out.println( "University [universityName=" + universityName + "\nlocation=" + location + "\nstate=" + state
				+ "\ncontrol=" + control + "\nnumberOfStudents=" + numberOfStudents + "\npercentFemale=" + percentFemale
				+ "\nsatVerbal=" + satVerbal + "\nsatMath=" + satMath + "\nexpenses=" + expenses + "\nfinancialAid="
				+ financialAid + "\nnumberOfApplicants=" + numberOfApplicants + "\npercentAdmitted=" + percentAdmitted
				+ "\npercentEnrolled=" + percentEnrolled + "\nacademicScale=" + academicScale + "\nsocialScale="
				+ socialScale + "\nqualityOfLife=" + qualityOfLife + "\nemphases=" + emphases + "]\n");
	}

	//Fake main method to test Class
	public static void main(String args[]){
		ArrayList<String> l = new ArrayList<String>();
		l.add("Beer");
		l.add("Popcorn");
		University u = new University("St. John's University","Minnesota","RURAL","MATH",2112,0,1300,1350,52433.0,25000.0,1000,68.0,98.0,5,5,5,l);
		u.printString();
		
	}
	
	

}