package OCA.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallRunnFut {
	public static void main(String args[]) {
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		Runnable runnable = () -> System.out.println("Im Runnable");
		Callable<Object> callable = () -> {
			System.out.println("Im Callable");
			return null;
		};
		Future runnableResult = threadPool.submit(runnable);
		Future<Object> callableResult = threadPool.submit(callable);
	}
}