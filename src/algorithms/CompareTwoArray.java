package algorithms;

public class CompareTwoArray {
	public static void main(String args[]) {
		int[] remArr = new int[2];
		int arrCnt = 0;
		int[] num = { 1, 2, 3, 4, 5 };
		int[] input1 = { 1, 3, 5 };

		boolean nosNotFound = true;
		for (int i = 0; i < num.length; i++) {
			nosNotFound = false;
			for (int j = 0; j < input1.length; j++) {
				if (num[i] == input1[j]) {
					nosNotFound = false;
					break;
				} else {
					nosNotFound = true;
				}
			}
			if (nosNotFound) {
				remArr[arrCnt++] = num[i];
			}
		}

		for (int k = 0; k < 2; k++) {
			System.out.println("remArr:" + remArr[k]);
		}

	}
}