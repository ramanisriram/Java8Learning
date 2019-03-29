package OCA.thread;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallable implements Callable<String> {
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return Thread.currentThread().getName();
		
	}
	
	public static void main(String args[]) {
		ExecutorService exService = Executors.newFixedThreadPool(10);

		List<Future<String>> futureList = new ArrayList<Future<String>>();
		Callable<String> myCallInstance = new FutureAndCallable();
		for(int i=0; i<10; i++) {
			Future<String> futObj = exService.submit(myCallInstance);
			futureList.add(futObj);
		}
		
		for(Future<String> futItem : futureList) {
			try {
				System.out.println("Date:" + new Date() + ":" + futItem.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		exService.shutdown();
	}
}