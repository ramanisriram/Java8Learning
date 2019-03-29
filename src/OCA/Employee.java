package OCA;

public class Employee {
	private String name;
	private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private Gender gender;
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	static enum Gender {
		MALE, FEMALE, TRANS
	};
	
	private int age;

	public void setFirstName(String firstName) {
		this.name = firstName;
	}

	public void setLastName(String lastName) {
		this.name += lastName;
	}


	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Employee(String fNamelName) {
		this.name = fNamelName;
	}
	
	public Employee() {
		
	}
	
	public Employee(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender.MALE;
	}
	
	public void displayAll() {
		System.out.println("Name:" + this.name);
		System.out.println("Age:" + this.age);
		System.out.println("Gender:" + this.gender);
	}
}