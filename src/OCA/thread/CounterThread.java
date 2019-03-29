package OCA.thread;

public class CounterThread extends Thread {

	public static void main(String args[]) {
		try {
			
			CounterThread obj1 = new CounterThread();
			obj1.start();
			
			CounterThread obj2 = new CounterThread();
			obj2.start();
			
			//IntSummaryStatistics stats = integers.stream().mapToInt((x) −> x).summaryStatistics();

			System.out.println("finalcount:" + Counter.getCount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		Counter.increment();
	}

}