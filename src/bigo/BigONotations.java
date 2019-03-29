package bigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BigONotations {
	int[] nosArr = {3,48,1,2,8,9,34,124,7,543,56,233,18,6,8567,689,65,234,343};
	
	public static void main(String args[]) {
		BigONotations obj = new BigONotations();
		obj.doLinearSearch(343);//Calculating based on worst case. Hence sending the last item
		obj.doBinarySearch(234, obj.nosArr);
	}
	
	void doLinearSearch(int number) {
		int count = 0;
		for(int i=0; i<this.nosArr.length; i++) {
			++count;
			if(number == this.nosArr[i]) {
				System.out.println("Item found");
				break;
			}
		}
		
		System.out.println("No of times the loop is executed:" + count);
		if(count == this.nosArr.length) {
			System.out.println("Big O is O(n)");
		}
	}
	
	void doBinarySearch(int number, int[] arrToSearch) {
		int[] localArr = arrToSearch;
		Arrays.sort(localArr);
		//Sort the array and find
		int arrSize = localArr.length;
		System.out.println("arrSize:"+arrSize/2);
		List leftArrList = new ArrayList();
		List rightArrList = new ArrayList();
		for(int i=0;i<localArr.length;i++) {
			if(i < arrSize/2) {
				leftArrList.add(localArr[i]);
			} else {
				rightArrList.add(localArr[i]);				
			}
		}
		
		rightArrList.forEach(System.out::println);
		
		
		if((Integer)(leftArrList.get(leftArrList.size()-1)) < number) {
			System.out.println("Item not in left array");
		} else {
			System.out.println("Item in the left array");
		}
		
	}
}