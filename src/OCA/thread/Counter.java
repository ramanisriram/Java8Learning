package OCA.thread;

public class Counter {

	private static int count;

	public synchronized static void increment() {
		count++;
	}

	public static int getCount() {
		return count;
	}
}