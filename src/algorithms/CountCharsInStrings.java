package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

//Question2
public class CountCharsInStrings {
	public static void main(String args[]) {
		String inputString = "sriram";
		countCharsTotally(inputString);
		//countCharsIndividually(inputString);
		List<String> inputStringList = new ArrayList<String>();
		inputStringList.add("s");
		inputStringList.add("r");
		inputStringList.add("i");
		inputStringList.add("r");
		inputStringList.add("a");
		inputStringList.add("m");
		//Count number of distinct characters in a string using java8
		countCharsUsingStreams(inputStringList);
	}
	
	public static void countCharsIndividually(String inputString) {
		String oldVal = String.valueOf(inputString.charAt(0));
		String saveString = "";
		int counter = 1;
		for(int i=1; i<inputString.length(); i++) {
			String newVal = String.valueOf(inputString.charAt(i));
			if(oldVal.equals(newVal)) {
				counter++;
			} else {
				saveString += oldVal + counter;
				counter = 1;
			}
			if(i == inputString.length()-1) {
				saveString += newVal + counter;
			}
			oldVal = newVal;
		}
		System.out.println("Individual:"+saveString);
	}
	
	public static void countCharsTotally(String inputString) {
		int counter = 1;
		Map<String, Integer> testMap = new HashMap();
		for(int i=0; i<inputString.length(); i++) {
			String charVal = String.valueOf(inputString.charAt(i));
			if(testMap.containsKey(charVal)) {
				counter = testMap.get(charVal);
				testMap.put(charVal, ++counter);
			} else {
				testMap.put(charVal, 1);
			}
		}
		
		BiConsumer<String, Integer> action = (val, count) -> {
			System.out.print(val+count);
		};
		testMap.forEach(action);
	}
	
	public static void countCharsUsingStreams(List<String> inputStringList) {
		System.out.println(inputStringList.stream().distinct().count());
	}
}