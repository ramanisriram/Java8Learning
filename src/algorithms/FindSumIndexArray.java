package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindSumIndexArray {
	public static void main(String args[]) {
		//brute force method
		int[] inpArr = {1,3,4,5,6};
		int noToCheck = 9;
		List<Integer> inpList = new ArrayList<Integer>();
		List<String> prepList = new ArrayList<String>();
		for(int i=0; i<inpArr.length; i++) {
			inpList.add(inpArr[i]);
		}
		for(int j=0; j<inpArr.length; j++) {
			int vals = inpList.get(j);

			Consumer<Integer> consAction = input -> {
				System.out.println(vals + "," + input);
				prepList.add(vals + "," + input);
			};
			inpList.stream().filter(val -> !prepList.contains(val+","+vals) && (val+vals) == noToCheck)
					.forEach(consAction);
		}
		
		//simple solution method
		
	}
}