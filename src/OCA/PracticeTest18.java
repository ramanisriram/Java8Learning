package OCA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeTest18 {

	/*
	 * Learnings: 1. Method References : How to use and what is method references.
	 * 2. computeIfAbsent method available in Maps to make use and see if the object
	 * already exists or not. 3. How to use lambda Expressions to create new
	 * objects. 4. What and how to use BiConsumer in Hashmaps 5. How to use
	 * computeIfPresent function in Map to update existing objects if there is any
	 * change 6. Use of BiFunction, which takes 2 argument and returns 1 argument 7.
	 * putIfAbsent function used to put into map if it finds the object searching to
	 * be absent 8. Comparator.comparing() - to do comparing based on certain
	 * specific field or condition to be set inside 9. Invocation of function using
	 * :: 10. Use of Optional; Optional.Of - just checks if null and throws null
	 * before the use of the actual object Optional.OfNullable has ifPresent and
	 * isPresent methods to see if available and call any consumer functions Count,
	 * Limit, Map, Collect, COnsumers, flatMap, Sorted, Max, min, reduce,
	 * sequential, allMatch, anyMatch, noneMatch, peek, findFirst, findLast,
	 * findAny, generate, forEachOrdered, collector.joining, skip, sequential,
	 * parallel, spliterator, sublist, unordered parallel etc
	 * 
	 */

	static Map<String, Employee> employeeMap = new HashMap<String, Employee>();
	
	public static void collectionsExample() {
		Map<String, String> map = new HashMap<>(); 
        map.put("Name", "Aman"); 
        map.put("Address", "Kolkata"); 
  
        // Print the map 
        System.out.println("Map: " + map); 
  
        // remap the values using compute() method 
        map.compute("Name", (key, val) 
                                -> val.concat(" Singh")); 
        map.compute("Address", (key, val) 
                                   -> val.concat(" West-Bengal")); 
  
        // print new mapping 
        System.out.println("New Map: " + map); 
	}
	
	
	public static void streamLearnings() {
		
		// filter
				List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
				List<String> allString = strings.stream().collect(Collectors.toList());
				List<String> filteredStr = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
				filteredStr.forEach(System.out::println);
				
				
				// forEachOrdered is to ensure that the order in which the stream is provided is
				// preserved
				System.out.println("ForEachOrdered");
				Stream.of("a", "d", "c").parallel().forEachOrdered(System.out::println);

				// forEach order is not preserved during parallel and parsing from the stream
				System.out.println("ForEach");
				Stream.of("a", "d", "c").parallel().forEach(System.out::println);
		
				
				List<String> namesList = new ArrayList<String>();
				namesList.add("Sriram");
				namesList.add("Sumanth");
				namesList.add("Jai");
				namesList.add("Navaneetha");
				namesList.add("Praveen");
				namesList.add("Siva");
				namesList.add("Vinayagam");
				namesList.add("Sakthi");
				namesList.add("Sundar");

				

				// Count. Count function returns long
				System.out.println("Count is:" + namesList.stream().filter(s -> s.startsWith("S")).count());
				// limit
				filteredStr = namesList.stream().limit(5).collect(Collectors.toList());
				filteredStr.forEach(System.out::println);
				
				// findAny and print
				namesList.stream().findAny().ifPresent(s -> System.out.println(s));
				
				// map
				List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 4, 3, 6, 7);
				List<Integer> squaresList = numbers.stream().map(q -> q * q).distinct().collect(Collectors.toList());
				// static method references
				squaresList.forEach(System.out::println);
				
				
				// Max and min
				// Show string which has the maximum length / max characters in names
				// String max =
				// namesList.stream().max(Comparator.comparing(String::length)).get();
				String max = namesList.stream().max(Comparator.comparing(a -> a)).get();
				System.out.println("Max : " + max);
				// Show string which has the minimum length / min characters in names
				String min = namesList.stream().min(Comparator.comparing(String::length)).get();
				System.out.println("Min : " + min);

				// Reduce
				// This is used to add the sum of numbers and return.
				int sum = numbers.stream().reduce(100, (a, b) -> a + b);
				System.out.println("Sum:" + sum);

				// peek
				// This returns a stream back again after performing the consumer action
				// Prints only if collect or some other terminal operations are performed.
				// Just peek does not give a shit
				System.out.println("Peek-----------------Peek");
				namesList.stream().peek(s -> System.out.println(s.replace("S", "R")));
				// .collect(Collectors.toList());

				namesList.stream().peek(System.out::print).filter(s -> s.startsWith("S"))
						.forEach(nam -> System.out.println(nam));

				Arrays.asList(1, 2, 3).stream().peek(System.out::println).allMatch(num -> num < 2);

				// skip
				// skips the number of element in the provided stream or list
				namesList.stream().skip(2).forEach(s -> System.out.println(s));

				// Collectors.joining()
				String namesCommaSep = namesList.stream().map(s -> s.replace("S", "R")).collect(Collectors.joining(","));
				System.out.println("Comma separated names :" + namesCommaSep);

				// Flatmap
				// This returns a stream object
				System.out.println("----------------------------------");
				List<String> list1 = Arrays.asList("AAA", "BBB");
				List<String> list2 = Arrays.asList("CCC", "DDD");
				Stream.of(list1, list2).flatMap(list -> list.stream()).forEach(s -> System.out.println(s));

				// Another example of flatmap
				List<String> stringsss = Arrays.asList("a", "b", "c", "d");
				List<Integer> integers = Arrays.asList(1, 2, 3, 4);

				System.out.println("FlatMap values");
				Stream.of(stringsss, integers).flatMap(e -> Stream.of(e)).forEach(System.out::println);
				
				System.out.println("FlatMap values");
				
				
				
				List<Integer> nextInts = Arrays.asList(5, 6, 7, 8);

				//is1.forEach(System.out::println);

				
				int sumAno = nextInts.stream().collect(Collectors.summingInt(i->i));
				System.out.println("sumAno:"+sumAno);
				
				//summarizingInt - provides summarizing like sum, avberage, min etc
				//int sumAno1 = nextInts.stream().collect(Collectors.summarizingInt(j->j));
				//System.out.println("sumAno1:"+sumAno1);

				// Generate
				// Returns infinite sequential and unordered stream
				Employee nameEmp = new Employee("JohnCena");
				Stream<String> st = Stream.generate(nameEmp::getName);
				// st.forEach(s->System.out.println(s)); - returns infinite value, so commented

				// Sequential and Parallel accessing of streams
				System.out.println("Sequential access:-----------------------");
				namesList.stream().sequential().forEach(System.out::println);
				System.out.println("Parallel access:-----------------------");
				namesList.stream().parallel().forEach(System.out::println);

				// spliterator is for parallel processing
				Spliterator<String> testSpliterator = namesList.spliterator();

				// Sublist is to sublist elements from a list to another list. FromIndex to
				// ToIndex. In this case, 0,1,2
				System.out.println("SubList:-----------------------");
				List subList1 = namesList.subList(0, 3);
				subList1.forEach(System.out::println);

				// Unordered - returns stream in an unordered
				Stream<String> unOrdStream = namesList.stream().unordered();
				unOrdStream.forEach(System.out::println);

				//Range.
				//This takes the intStream as value 1,2,3,4. End value is not considered
				System.out.println("IntStream-------------------");
				IntStream intSt = IntStream.range(1, 5);
				//Optional sum1 = intSt.reduce((x,y)->x+y).orElse(0);//This line will throw error
				intSt.forEach(System.out::print);
				
				IntStream closedIntSt = IntStream.rangeClosed(1, 5);
				closedIntSt.forEach(System.out::print);
				System.out.println("IntStream ending-------------------");
				
				
				//parallel is used to parse the stream in parallel. The output 1,2 will be displayed by different
				//threads so the order is not confirmed here.
				IntStream.range(1, 3).parallel().forEach(System.out::print);
				
				//.boxed converts it to wrapper
				Stream<Integer> selSt = intSt.boxed();
				
				//PartitioningBy is a BiPredicate type that checks a boolean condition and then returns a map of key as boolean
				//and the value as the object whatever is under the stream
				Object obj = selSt.collect(Collectors.partitioningBy(x -> x * 4 > 10));
				System.out.println("IntStream obj:" + obj);

				//findAny - finds any value in the stream and prints it
				String foundName = namesList.stream().filter(s -> s.equals("Sriram")).findAny().get();
				System.out.println("foundName:" + foundName);
	}
	
	

	public static void main(String args[]) {
		
		streamLearnings();

		



		

		

		

		Employee emp1 = new Employee();
		emp1.setFirstName("Sriram");
		emp1.setLastName("Ramani");
		emp1.setGender(Employee.Gender.MALE);
		emp1.setDepartment("SW");
		emp1.setAge(31);
		addEmployee(emp1);

		emp1 = new Employee();
		emp1.setFirstName("Jaisudha");
		emp1.setLastName("Jeyaraman");
		emp1.setGender(Employee.Gender.FEMALE);
		emp1.setDepartment("SW");
		emp1.setAge(31);
		addEmployee(emp1);

		emp1 = new Employee("SumanthSatya");
		emp1.setGender(Employee.Gender.MALE);
		emp1.setDepartment("OR");
		emp1.setAge(30);
		addEmployee(emp1);

		emp1 = new Employee("NavaneethaKrishnan");
		emp1.setGender(Employee.Gender.MALE);
		emp1.setDepartment("OR");
		emp1.setAge(29);
		addEmployee(emp1);

		emp1 = new Employee("PrabhavathiSenthil");
		emp1.setGender(Employee.Gender.FEMALE);
		emp1.setDepartment("OR");
		emp1.setAge(28);
		addEmployee(emp1);

		emp1 = new Employee();
		emp1.setFirstName("Sriram");
		emp1.setLastName("Ramani");
		emp1.setDepartment("SW");
		emp1.setGender(Employee.Gender.MALE);
		emp1.setAge(32);
		updateEmployee(emp1);

		System.out.println("Print all Values");
		System.out.println("-----------------------------------");
		displayEmployees();

		System.out.println("-----------------------------------");
		System.out.println("Sorting");
		System.out.println("-----------------------------------");
		sortEmployees();

		getEmployee("SriramRamanii");

		findEmployee(Employee.Gender.MALE);
		findEmployee(Employee.Gender.TRANS);

		System.out.println("Finally--------------------------");
		List<Employee> dummyList = new ArrayList<Employee>();
		BiConsumer<String, Employee> biConAction = (name, empObj) -> {
			dummyList.add(empObj);
		};

		employeeMap.forEach(biConAction);

		//Max - using Comparator.comparing and using age in here to do the comparison
		String maxAgedEmpName = dummyList.stream().max(Comparator.comparing(Employee::getAge)).get().getName();
		System.out.println("maxAgedEmp:" + maxAgedEmpName);

		// mapElementsBasedonGender();

		// Predicate example
		// Predicate is by default of Object type. Hence you need to cast it here
		Predicate<Integer> even = (Integer i) -> i % 2 == 0;
		Predicate even1 = i -> (Integer) i % 2 == 0;

		// Stream array example
		Stream<String> stream = Arrays.stream(new String[] { "a", "b", "c" });
		
		//peek is just to peek something, based on the operation after the peek is performed.
		String output = stream.filter(s -> {
			if (s.compareTo("abc") > 0)
				return true;
			else
				return false;
		}).peek(System.out::print).collect(Collectors.joining());
		
		
		//Supplier has the .get method to get the value set in the supplier function
		Employee te = new Employee("Test");
		Supplier<String> test = te::getName;
		test.get();

		groupAndPrintElements();

		nosToCharListTest();

		//This is to test 2 different predicates and check the outcome
		predicatePositiveNegative();

		//Trying to add null into an array list and then using this value in a 
		//switch statement which is a string. This throws a null pointer exception in
		//switch(s) because this uses equals method initially to start using switch statement.
		nullInListAndString();
		
		partitioningAndGroupingByEx();
	}

	private static void partitioningAndGroupingByEx() {
		List<Student> studentsList = new ArrayList();
		Student a = new Student("A");
		a.setDepartment("Business");
		a.setMark(8.0);
		Student b = new Student("A");
		b.setDepartment("Business");
		b.setMark(8.0);
		Student c = new Student("A");
		c.setDepartment("Finance");
		c.setMark(8.0);
		Student d = new Student("A");
		d.setDepartment("Finance");
		d.setMark(8.0);

		ToDoubleFunction<Student> markFunc = Student::getMark;
		studentsList.add(a);
		studentsList.add(b);
		studentsList.add(c);
		studentsList.add(d);
		studentsList.stream().collect(Collectors.groupingBy(Student::getDepartment)).forEach((x, y) -> {// System.out.println("x:"
																										// + x);
			//double avg = y.stream().collect(Collectors.averagingDouble(markFunc));
			double avg = y.stream().collect(Collectors.averagingDouble(Student::getMark));
			System.out.println("Avg:" + avg);
		});
		
		studentsList.stream().collect(Collectors.partitioningBy(q -> q.getDepartment()
				== "Business")).forEach((k,v) -> System.out.println(v));
		
		studentsList.stream().collect(Collectors.partitioningBy(q -> q.getMark() > 6)).
		forEach((k,v) -> System.out.println(v));
	}

	private static void nullInListAndString() {

		List<String> nullList = Arrays.asList(null, "null");
		for (String s : nullList) {
			switch (s) {
			case "null":
				System.out.println("null string");
				break;
			default:
				System.out.println("in default");
			}
		}
	}

	private static void predicatePositiveNegative() {
		System.out.println("-------predicatePositiveNegative---------");
		List<Integer> list = Arrays.asList(-2, -1, 0, 1, 2);
		Predicate<Integer> positive = i -> {
			System.out.print(i);
			return i > 0;
		};

		Predicate<Integer> negative = i -> {
			System.out.print(i);
			return i < 0;
		};

		list.stream().filter(positive).allMatch(negative);
		list.stream().filter(positive).anyMatch(negative);
		list.stream().filter(positive).noneMatch(negative);
		System.out.println("-------predicatePositiveNegative ended---------");

		

	}

	public static void addEmployee(Employee emp) {
		// The below function computes if the object already exists and if not then
		// calls the
		// functional apply to execute the code written
		/*
		 * employeeMap.computeIfAbsent(emp.getFirstName()+emp.getLastName(), new
		 * Function<String, Employee>() {
		 * 
		 * @Override public Employee apply(String t) { System.out.println("t:"+t);
		 * return emp; } });
		 */

		// creates a new Object with that specified string one argument
		// employeeMap.computeIfAbsent(emp.getName(), Employee::new);

		// this is different from computeIfAbsent. This checks if absent and then adds
		// the new object specified
		employeeMap.putIfAbsent(emp.getName(), emp);

	}

	public static void mapElementsBasedonGender() {
		// In this method, im trying to use toMap which maps
		// values in the list to Hashmap using key value pairs
		// This will throw exception below coz for the same MALE and FEMALE
		// there are more than one value in map. So it may throw exception
		List<Employee> allEmpsList = new ArrayList();
		BiConsumer<String, Employee> putInListCons = (na, em) -> {
			allEmpsList.add(em);
		};
		employeeMap.forEach(putInListCons);
		// The format is toMap(key, value). So we need to make sure the key is unique
		System.out.println(allEmpsList.stream().collect(Collectors.toMap(Employee::getGender, Employee::getName)));
	}

	public static void displayEmployees() {
		// BiConsumer
		BiConsumer<String, Employee> biConsumerAction = (s, em1) -> {
			System.out.print(em1.getName() + "||");
			System.out.println(em1.getAge());
		};
		System.out.println("BiConsumer result");
		employeeMap.forEach(biConsumerAction);

		// BiFunction
		BiFunction<String, Employee, String> biFunctionAction = (s, em1) -> {
			return em1.getName() + "||" + em1.getAge();
		};
		String result = biFunctionAction.apply("SriramRamani", new Employee("SriramRamani"));
		System.out.println("BiFunction Result : " + result);

		// BiPredicate
		BiPredicate<String, Employee> biPredicateAction = (s, em1) -> {
			return employeeMap.containsKey("SriramRamani");
		};

		biPredicateAction.test("SriramRamani", new Employee("SriramRamani"));

		Consumer<Employee> testCon = p -> System.out.println(p.getName());

	}

	public static void updateEmployee(Employee emp) {
		BiFunction<String, Employee, Employee> biUpdateAction = (name, oldEmp) -> {
			Employee newEmp = new Employee();
			System.out.println("In updateEmployees function");
			newEmp.setName(emp.getName());
			newEmp.setAge(emp.getAge());
			newEmp.setGender(emp.getGender());
			newEmp.setDepartment("SW");
			return newEmp;
		};
		employeeMap.computeIfPresent(emp.getName(), biUpdateAction);

	}

	public static void sortEmployees() {
		// Sort the employees based on the age descending order
		// Sorted. Comparator.Comparing and Reversed.
		// Reversed is used to reverse the order in this comparator
		List<Employee> sortedAgeList = employeeMap.values().stream()
				.sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());


		Consumer<Employee> sortedListAction = item -> {
			System.out.println(item.getName());
		};
		sortedAgeList.forEach(sortedListAction);
		
		
	}

	// BiConsumer
	public static void getEmployee(String name) {
		Employee obj = employeeMap.get(name);
		// Optional<Employee> foundEmp = Optional.of(obj);

		Optional<Employee> foundEmp = Optional.ofNullable(obj);
		Consumer<Employee> consumer = emp -> {
			if (emp.getAge() > 21) {
				System.out.println("Found the employee and the age is :" + emp.getAge());
			}
		};
		foundEmp.ifPresent(consumer);
	}

	// AllMatch, Anymatch and nonMatch checks if any values in the stream matches
	// the Predicate.
	public static void findEmployee(Employee.Gender empGender) {
		// If all Employees are male

		Predicate<Employee> allMat = employee -> {
			Optional<Employee.Gender> genderVal = Optional.ofNullable(employee.getGender());
			if (genderVal.isPresent()) {
				return genderVal.get().equals(empGender);
			} else {
				return genderVal.isPresent();
			}
		};

		List<Employee> empsList = new ArrayList<Employee>();

		BiConsumer<String, Employee> doAction = (empName, emplObj) -> {
			empsList.add(emplObj);
		};
		employeeMap.forEach(doAction);

		
		List<String> collectedList = empsList.stream().map(Employee::getName).collect(Collectors.toList());

		Consumer<String> doColAction = (empName) -> {
			System.out.println("empName:" + empName);
		};
		collectedList.forEach(doColAction);

		boolean empFindStatus = empsList.stream().allMatch(allMat);
		System.out.println("All employees match " + empGender + "?:" + empFindStatus);

		// Find if any employee are male
		empFindStatus = empsList.stream().anyMatch(allMat);
		System.out.println("Atleast one employee match \" + empGender + \"?:" + empFindStatus);

		// Find if none employee are TransGender
		empFindStatus = empsList.stream().noneMatch(allMat);
		System.out.println("Is there no employee matching \" + empGender + \":?" + empFindStatus);
	}

	public static void groupAndPrintElements() {
		List<Employee> allEmpsList = new ArrayList();
		BiConsumer<String, Employee> putInListCons = (na, em) -> {
			allEmpsList.add(em);
			System.out.println(em.getDepartment());
		};
		employeeMap.forEach(putInListCons);

		// Gonna group elements as Map<Employee.Gender, map<department,
		// List<Employee>>>;
		Map<Employee.Gender, Map<String, List<Employee>>> empsMapMap = allEmpsList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.groupingBy(Employee::getDepartment)));
		System.out.println(empsMapMap);
	}

	public static void nosToCharListTest() {
		List<Character> testList = new ArrayList();
		for (char c = 'z'; c <= 'a'; c--) {
			testList.add(c);
		}

		System.out.println("amount:" + testList.stream().filter(c -> c.compareTo('u') > 0).count());

		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(sum);
		double sum1 = list.stream().mapToInt(x -> x).sum();
		System.out.println(sum1);

		System.out.println("--------------NoseDrops---------------");
		List<Integer> intList = Arrays.asList(14, 38, 35, 2);
		System.out.println(intList.stream().max(Comparator.comparingInt(a -> a)).get());
	}
	
	public static void everyThingElse() {
		List<Map<String, String>> testLit = new ArrayList();
		testLit.add(new HashMap());
		Map<?,?> map = testLit.get(0);
		//map.put("key", "value");
		List<Integer> intList = Arrays.asList(14, 38, 35, 2);
		
		long val = 0xb_1;
	}
	
	public static <T extends Number> List<T> process(List<T> args) {
		return null;
		
	}
	
	public static void genericsLearning() {
		
		//Number, object, integer.
		
		ArrayList<Integer> list = new ArrayList();
		List<? super Integer> numbers = process(list);
		
		
		List<? super Number> list1 = new ArrayList();//List of Object type
		List<? extends Number> list2 = new ArrayList();//List of ? that extends Number, for example Integer

		
		list1.add(1);//no compiler error because it boxes to object
		//list2.add(1);//because its specific to Integer object, need (int)
		//int num1 = list1.get(0);//fails because the retrieved value here is an object and need to cast
	//	int num2 = list2.get(0);//fails because the retrieved value here is an Integer object and needs to be cast to int
		
		
		//String and Object
		List<String> stList = new ArrayList();
		List<? super String> superStringSubList = new ArrayList();
		stList.addAll(new ArrayList());
//		stList.addAll(superStringSubList);
	}
	
	
		
}