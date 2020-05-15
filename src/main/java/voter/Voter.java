package voter;

public class Voter {

	
	//Setting all properties of voter

	private String passport;
	
	private int age;
	
	public static String fullName;
	
	private int vote;
	
	private String birthDate;

	public String getId() {
		return passport;
	}

	public void setId(String id) {
		this.passport = id;
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

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
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
		return "Voter [id=" + passport + ", fullName=" + fullName + "]";
	}
	
	
	
	


	
}
