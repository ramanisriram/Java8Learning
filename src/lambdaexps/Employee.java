package lambdaexps;

public class Employee {
	private String firstName;
	private String lastName;

	public Employee(String fname, String lname) {
		this.firstName = fname;
		this.lastName = lname;
	}

	public static int nameCompare(Employee a1, Employee a2) {
		return a1.firstName.compareTo(a2.firstName);
	}

	public String toString() {
		return firstName;
	}
}