package OCA.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureSleep {
	
	
	//In this program, future.get will block the call for the specified timeout
	//invoke the thread after 2 seconds. Still when you give thread.sleep it waits for 2 more seconds so
	//timeout exception occurs
	public static void main(String args[]) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService threadPool = Executors.newFixedThreadPool(1);
		Future<String> future = threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws InterruptedException {
				Thread.sleep(1000);
				return "I have wokenup from sleep";
			}
		});
		System.out.println(System.currentTimeMillis());
		System.out.println(future.get(2, TimeUnit.SECONDS));
		System.out.println(System.currentTimeMillis());
		
	}
}