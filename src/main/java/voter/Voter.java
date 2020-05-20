package voter;

public class Voter {

	
	//Setting all properties of voter

	private static String passportNumber;
	
	private static int age;
	
	private static String fullName;
	
	private static String birthDate;
	
	private static String vote;
	
	
	
	//GETTERS AND SETTERS

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Voter [passport=" + passportNumber + ", fullName=" + fullName + ", birthDate=" + birthDate + ", vote=" + vote
				+ "]";
	}


	
	
	
	
	


	
}
