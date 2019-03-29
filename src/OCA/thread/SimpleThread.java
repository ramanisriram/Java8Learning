package OCA.thread;

import java.io.IOException;
import java.util.concurrent.Callable;

import OCA.Employee;

public class SimpleThread extends Thread {
	
	static int integerValue = 0;
	
	public static void main(String args[]) throws InterruptedException {
		
		System.out.println("At the beginning");
		
		SimpleThread thread1 = new SimpleThread();
		SimpleThread thread2 = new SimpleThread();
		SimpleThread thread3 = new SimpleThread();
		
		thread1.start();
		System.out.println("After thread 1--------");
		//thread1.sleep(1000);
		Thread.sleep(1000);
		System.out.println("Integer Value:"+integerValue);
		
		thread2.start();
		System.out.println("After thread 2--------");
		//thread2.sleep(1000);
		Thread.sleep(1000);
		System.out.println("Integer Value:"+integerValue);
		
		thread3.start();
		System.out.println("After thread 3--------");
		//thread3.sleep(1000);
		Thread.sleep(1000);
		System.out.println("Integer Value:"+integerValue);
	}
	
	public void run() {
		integerValue++;
	}

	
}