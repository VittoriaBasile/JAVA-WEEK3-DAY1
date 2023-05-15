package Application;

public class Student {
	private int id;
	private String name;
	private String lastName;
	private char gender;
	private String birthDate;
	private double minVote;
	private double maxVote;
	private double avg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public double getMinVote() {
		return minVote;
	}

	public void setMinVote(double minVote) {
		this.minVote = minVote;
	}

	public double getMaxVote() {
		return maxVote;
	}

	public void setMaxVote(double maxVote) {
		this.maxVote = maxVote;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public Student(String name, String lastName, char gender, String birthDate, double minVote, double maxVote) {
		setName(name);
		setLastName(lastName);
		setGender(gender);
		setBirthDate(birthDate);
		setMinVote(minVote);
		setMaxVote(maxVote);

	}

}
