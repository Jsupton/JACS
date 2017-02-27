package edu.csbsju;

import java.util.*;

/**
 * @author ajdehn
 * @version 02-26-17
 */
public class University {
	
	private String universityName;
	private String location;
	private String state;
	private String control;
	private int numberOfStudents;
	private int percentFemale;
	private int satVerbal;
	private int satMath;
	private Double expenses;
	private Double financialAid;
	private int numberOfApplicants;
	private Double percentAdmitted;
	private Double percentEnrolled;
	private int academicScale;
	private int socialScale;
	private int qualityOfLife;
	private ArrayList<String> emphases;
	
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
	public University(String universityName, String location, String state, String control, int numberOfStudents,
			int percentFemale, int satVerbal, int satMath, Double expenses, Double financialAid, int numberOfApplicants,
			Double percentAdmitted, Double percentEnrolled, int academicScale, int socialScale, int qualityOfLife,
			ArrayList<String> emphases) {
		super();
		this.universityName = universityName;
		this.location = location;
		this.state = state;
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
	 * @return the universityName
	 */
	public String getUniversityName() {
		return universityName;
	}
	/**
	 * @param universityName the universityName to set
	 */
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the control
	 */
	public String getControl() {
		return control;
	}
	/**
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}
	/**
	 * @return the numberOfStudents
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}
	/**
	 * @param numberOfStudents the numberOfStudents to set
	 */
	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	/**
	 * @return the percentFemale
	 */
	public int getPercentFemale() {
		return percentFemale;
	}
	/**
	 * @param percentFemale the percentFemale to set
	 */
	public void setPercentFemale(int percentFemale) {
		this.percentFemale = percentFemale;
	}
	/**
	 * @return the satVerbal
	 */
	public int getSatVerbal() {
		return satVerbal;
	}
	/**
	 * @param satVerbal the satVerbal to set
	 */
	public void setSatVerbal(int satVerbal) {
		this.satVerbal = satVerbal;
	}
	/**
	 * @return the satMath
	 */
	public int getSatMath() {
		return satMath;
	}
	/**
	 * @param satMath the satMath to set
	 */
	public void setSatMath(int satMath) {
		this.satMath = satMath;
	}
	/**
	 * @return the expenses
	 */
	public Double getExpenses() {
		return expenses;
	}
	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}
	/**
	 * @return the financialAid
	 */
	public Double getFinancialAid() {
		return financialAid;
	}
	/**
	 * @param financialAid the financialAid to set
	 */
	public void setFinancialAid(Double financialAid) {
		this.financialAid = financialAid;
	}
	/**
	 * @return the numberOfApplicants
	 */
	public int getNumberOfApplicants() {
		return numberOfApplicants;
	}
	/**
	 * @param numberOfApplicants the numberOfApplicants to set
	 */
	public void setNumberOfApplicants(int numberOfApplicants) {
		this.numberOfApplicants = numberOfApplicants;
	}
	/**
	 * @return the percentAdmitted
	 */
	public Double getPercentAdmitted() {
		return percentAdmitted;
	}
	/**
	 * @param percentAdmitted the percentAdmitted to set
	 */
	public void setPercentAdmitted(Double percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}
	/**
	 * @return the percentEnrolled
	 */
	public Double getPercentEnrolled() {
		return percentEnrolled;
	}
	/**
	 * @param percentEnrolled the percentEnrolled to set
	 */
	public void setPercentEnrolled(Double percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}
	/**
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return academicScale;
	}
	/**
	 * @param academicScale the academicScale to set
	 */
	public void setAcademicScale(int academicScale) {
		this.academicScale = academicScale;
	}
	/**
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}
	/**
	 * @param socialScale the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}
	/**
	 * @return the qualityOfLife
	 */
	public int getQualityOfLife() {
		return qualityOfLife;
	}
	/**
	 * @param qualityOfLife the qualityOfLife to set
	 */
	public void setQualityOfLife(int qualityOfLife) {
		this.qualityOfLife = qualityOfLife;
	}
	/**
	 * @return the emphases
	 */
	public ArrayList<String> getEmphases() {
		return emphases;
	}
	/**
	 * @param emphases the emphases to set
	 */
	public void setEmphases(ArrayList<String> emphases) {
		this.emphases = emphases;
	}
	
	/**
	 * @param emp the emphases to add
	 */
	public void addEmphasis(String emp){
		
	}
	
	/**
	 * @param emp the emphases to remove
	 */
	public void removeEmphasis(String emp){
		
	}
	

}