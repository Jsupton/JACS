package edu.csbsju;

/**
 * Class used to manage universities
 * @author ajdehn
 * @version 02-26-17
 */
public class UniversityController {
	
	/**
	 * This instance variable represents a university object
	 */
	private University university;
	
	/**
	 * This is a DBController object used to access the Database
	 */
	private DBController d;
	
	public UniversityController(){
		this.d = new DBController();
	}
	
	/**
	 * Adds a university to the database
	 * @param u New University to be added to the database
	 */
	public void addUniversity(University u)
	{
		d.addUniversity(u);
	}
	
	/**
	 * Allows changes to be made to details of a university
	 * @param u University to be edited
	 */
	public void editUniversity(String universityName, String state, String location, String control, int numberOfStudents,
            double percentFemale, int satVerbal, int satMath, double expenses, double financialAid, int numberOfApplicants,
            double percentAdmitted, double percentEnrolled, int academicScale, int socialScale, int qualityOfLife){
		University u = d.getAUniversity(universityName);
		   u.setState(state);
		   u.setLocation(location);
		   u.setControl(control);
		   u.setNumberOfStudents(numberOfStudents);
		   u.setPercentFemale(percentFemale);
		   u.setSatVerbal(satVerbal);
		   u.setSatMath(satMath);
		   u.setExpenses(expenses);
		   u.setFinancialAid(financialAid);
		   u.setNumberOfApplicants(numberOfApplicants);
		   u.setPercentAdmitted(percentAdmitted);
		   u.setPercentEnrolled(percentEnrolled);
		   u.setAcademicScale(academicScale);
		   u.setSocialScale(socialScale);
		   u.setQualityOfLife(qualityOfLife);
		d.editUniversity(u);
	}
	
	/**
	 * Shows details of a university
	 * @param u University object requested
	 */
	public void displayUniversity(University u)
	{
		u.printString();
	}
	
}
