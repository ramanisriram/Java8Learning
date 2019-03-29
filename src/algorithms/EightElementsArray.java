package algorithms;

public class EightElementsArray {
	public static void main(String args[]) {
		int days = 2;
		
		int[] input = {1,1,1,0,1,1,1,1};
		for(int i=0;i<days;i++) {
			input = computeValue(input);
		}
		for(int j=0;j<input.length;j++) {
			System.out.print(input[j]);
		}
	}

	private static int[] computeValue(int[] input) {
		int[] output = new int[input.length];
		int prev = 0;
		int next = 0;
		for(int j=0;j<input.length;j++) {
			if(j==0) {
				prev = 0;
				next = input[j+1];
				output[j] = prev ^ next;
			} else if (j==input.length-1) {
				prev = input[j-1];
				next = 0;
				output[j] = prev ^ next;
			} else {
				prev = input[j-1];
				next = input[j+1];
				output[j] = prev ^ next;
			}
		}
		return output;
	}
}