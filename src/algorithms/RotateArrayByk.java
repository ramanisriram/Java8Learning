package algorithms;

public class RotateArrayByk {
	
	public static void main(String args[]) {
		
		leftShift();
		//rightShift();
	}
	
	public static void leftShift() {
		
		
		//Using Arrays
		int k=3;
		int[] input = {3,8,9,7,6};
		int[] rightShiftArr = new int[input.length+k];

		for(int i=0; i<input.length; i++) {
			rightShiftArr[i+k] = input[i];
		}
		
		
		for(int i=0; i<rightShiftArr.length; i++) {
			System.out.print(rightShiftArr[i]);
		}
		
		System.out.println();
		
		for(int i=k-1; i>=0; i--) {
			rightShiftArr[i] = rightShiftArr[input.length+i];
			rightShiftArr[input.length+i] = 0;
		}
		
		for(int i=0; i<rightShiftArr.length; i++) {
			System.out.print(rightShiftArr[i]);
		}
	}
	
	public static void rightShift() {
		//Using string
		String rightShifted = "2356";
		int k=3;
		for(int i=0; i<k; i++) {
			rightShifted = rightShifted.substring(1) + rightShifted.charAt(0);
		}
		System.out.println(rightShifted);
		
		//Using Arrays
		int[] input = {3,8,9,7,6};
		int[] rightShiftArr = new int[input.length+3];

		for(int i=0; i<input.length; i++) {
			rightShiftArr[i] = input[i];
		}
		for(int i=0; i<rightShiftArr.length; i++) {
			System.out.print(rightShiftArr[i]);
		}
		for(int i=0; i<k; i++) {
			rightShiftArr[input.length+i] = input[i];
			rightShiftArr[i] = 0;
		}
		for(int i=0; i<rightShiftArr.length; i++) {
			System.out.print(rightShiftArr[i]);
		}
	}
}