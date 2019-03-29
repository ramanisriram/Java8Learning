package OCA.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteVsArrayList extends Thread {

	public void run() {
		System.out.println("Adding through thread:"+this.name);
		if(this.name.equals("Sidhu"))
			syList1.add("Sidhu");
		
		if(this.name.equals("Hope")) {
			syList1.remove("Sidhu");
			syList1.add("Hope");
		}
		
		if(this.name.equals("Both")) {
			syList1.remove("Hope");
			syList1.add("Sidhu");
			syList1.add("Hope");
		}
	}
	
	String name;
	public CopyOnWriteVsArrayList(String lName) {
		name = lName;
	}

	// CopyOnWriteArrayList - add, set, remove etc are done on a new copy of
	// arraylist.
	// Thread-safe version of arraylist.
	// Iterator on Copyonwritearraylist cannot perform remove operation
	static CopyOnWriteArrayList<String> syList1 = new CopyOnWriteArrayList();
	
	//static List<String> syList1 = new ArrayList();

	public static void main(String args[]) {

		try {
			
			syList1.add("Sriram");
			syList1.add("Jaisudha");
			
			System.out.println("Before gajagaja start:" + syList1);
			
			CopyOnWriteVsArrayList thread1 = new CopyOnWriteVsArrayList("Sidhu");
			thread1.start();

			Iterator itr = syList1.iterator(); 
	        while (itr.hasNext()) {
	        	//If i use ArrayList for syList1 instead of CopyOnWriteArrayList, i will get 
	        	//concurrentmodificationexception in the below line.
	            String s = (String)itr.next();
	            System.out.println(s); 
	            Thread.sleep(1000); 
	        } 
			
			System.out.println("Printing output list:" + syList1);
			
			CopyOnWriteVsArrayList thread2 = new CopyOnWriteVsArrayList("Hope");
			thread2.start();
			
			//thread2.sleep(1000);
			
			System.out.println("After delivery of Hope:" + syList1);
			
			CopyOnWriteVsArrayList thread3 = new CopyOnWriteVsArrayList("Both");
			thread3.start();
			
			//thread3.sleep(1000);
			
			System.out.println("After final delivery:" + syList1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}