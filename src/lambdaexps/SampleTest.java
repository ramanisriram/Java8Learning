package lambdaexps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SampleTest {
	public static void main(String args[]) {
		Integer[] arra = new Integer[0];
		System.out.println(arra[0]);
		SampleTest ab = new SampleTest();
		List<String> namesList = new ArrayList<String>();
		namesList.add("Sriram");
		namesList.add("Ramani");
		ab.sortUsing7(namesList);
		System.out.println(namesList);
		System.out.println("Sort using Java 8 syntax: ");

		List<String> namesList1 = new ArrayList<String>();
		namesList1.add("Jaisudha");
		namesList1.add("Jeyaraman");
		ab.sortUsing8(namesList1);
		System.out.println(namesList1);
		
		//Lambda with parameters
		Stringcheck doStr = (s1, s2) -> (s1.concat(s2));
		System.out.println(doStr.massageString("Sriram", "Ramani"));
		namesList1.forEach(System.out::println);
		
		//Simple Lambda
		GreetingService message = () ->	System.out.println("HelloMan");
		message.sayHello();
		
		//Sorting arrays based on some bean object names and sorting this array
		Employee[] employeesArr = {new Employee("Sriram","Ramani"), new Employee("Jaisudha","Jeyaraman")};
		Arrays.sort(employeesArr, Employee::nameCompare);
		
		System.out.println("After Sorting Names "+Arrays.toString(employeesArr));
		
	}

	public void sortUsing7(List<String> sortList) {3 
		Collections.sort(sortList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	public void sortUsing8(List<String> sortList) {
		Collections.sort(sortList, (s1, s2) -> ((String) s1).compareTo((String) s2));
	}
	
	@FunctionalInterface
	interface Stringcheck {
		String massageString(String ab1, String ab2);
	}
	
	@FunctionalInterface
	interface GreetingService {
		void sayHello();
	}

}