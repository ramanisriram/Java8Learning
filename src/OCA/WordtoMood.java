package OCA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordtoMood {
	private static final String SAD = "SAD";
	private static final String HAPPY = "HAPPY";
	static Map<String, String> wordMap = new HashMap<String, String>();
	public static void main(String args[]) {
		String inputWord = "Today was a terrible day";
		wordMap.put("sad",SAD);
		wordMap.put("ok",HAPPY);
		wordMap.put("terrible",SAD);
		wordMap.put("awesome",HAPPY);
		String[] words = inputWord.split("\\s");
		String returnValue = Stream.of(words).map(String::toLowerCase).map(wordMap::get)
				.filter(value -> value != null).distinct().collect(Collectors.joining(","));
		System.out.println("returnValue:"+returnValue);
		
		
	}
}