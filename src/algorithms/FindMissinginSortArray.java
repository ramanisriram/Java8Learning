package algorithms;

public class FindMissinginSortArray {

	public static void main(String args[]) {
		//Done here

		int[] input = { 1, 2, 3, 5, 7, 9, 10, 11, 14, 16, 18, 20 };

		int[] register = new int[input[input.length - 1]];

		// System.out.println("register:" + register.length);

		for (int i : input) {
			register[i] = 1;
			// System.out.println(register[i]);
		}

		for (int i = 1; i < register.length; i++) {
			// System.out.println("i" + register[i]);
			if (register[i] == 0) {
				System.out.println(i);
			}
		}
	}
}