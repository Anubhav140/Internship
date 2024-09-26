package pnb.entity;

public class User {
	private String CaseID;
	private String CaseType;
	private String Description;
	private int Number_Of_Files;
	public User(String caseID, String caseType, String description, int number_Of_Files) {
		super();
		CaseID = caseID;
		CaseType = caseType;
		Description = description;
		Number_Of_Files = number_Of_Files;
	}
	public String getCaseID() {
		return CaseID;
	}
	public void setCaseID(String caseID) {
		CaseID = caseID;
	}
	
	public String getCaseType() {
		return CaseType;
	}
	public void setcaseType(String CaseType) {
		CaseType = CaseType;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNumber_Of_Files() {
		return Number_Of_Files;
	}
	public void setNumber_Of_Files(int number_Of_Files) {
		Number_Of_Files = number_Of_Files;
	}
	
	
}
