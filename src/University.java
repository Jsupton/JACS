import java.util.*;

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

	public void addEmphases(String emp) {
	}

	public void removeEmphases(String emp) {
	}

	public void editUniversity() {
	}

	public void addUniversity(University U) {
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String uName) {
		this.universityName = uName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String loc) {
		this.location = loc;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int students) {
		this.numberOfStudents = students;
	}

	public int getPercentFemale() {
		return percentFemale;
	}

	public void setPercentFemale(int percent) {
		this.percentFemale = percent;
	}

	public int getSatVerbal() {
		return satVerbal;
	}

	public void setSatVerbal(int verbal) {
		this.satVerbal = verbal;
	}

	public int getSatMath() {
		return satMath;
	}

	public void setSatMath(int math) {
		this.satMath = math;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public Double getFinancialAid() {
		return financialAid;
	}

	public void setFinancialAid(Double financialAid) {
		this.financialAid = financialAid;
	}

	public int getNumberOfApplicants() {
		return numberOfApplicants;
	}

	public void setNumberOfApplicants(int applicants) {
		this.numberOfApplicants = applicants;
	}

	/**
	 * 
	 * @return
	 */
	public double getPercentAdmitted() {
		return percentAdmitted;
	}

	public void setPercentAdmitted(double percAdmitted) {
		this.percentAdmitted = percAdmitted;
	}

	public double getPercentEnrolled() {
		return percentEnrolled;
	}

	void setPercentEnrolled(double percEnrolled) {
		this.percentEnrolled = percEnrolled;
	}

	public int getAcademicScale() {
		return academicScale;
	}

	public void setAcademicScale(int aScale) {
		this.academicScale = aScale;
	}

	public int getSocialScale() {
		return socialScale;
	}

	public void setSocialScale(int socScale) {
		this.socialScale = socScale;
	}

	public int getQualityOfLife() {
		return qualityOfLife;
	}

	public void setQualityOfLife(int quality) {
		this.qualityOfLife = quality;
	}

	public ArrayList<String> getEmphases() {
		return emphases;
	}

	public void setEmphases(ArrayList<String> emphasis) {
		this.emphases = emphasis;
	}

}