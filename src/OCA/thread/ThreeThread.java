package OCA.thread;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class ThreeThread {
	public static void main(String args[]) {
		
		
		ConcurrentHashMap<Integer, String> data = new ConcurrentHashMap();
		
		new Thread() {
			public void run() {
				data.put(1, "a");
				data.put(2, "b");
			}
		}.start();
		
		new Thread() {
			public void run() {
				Iterator<Entry<Integer, String>> testIt = data.entrySet().iterator();
				while(testIt.hasNext()) {
					testIt.next();
					testIt.remove();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				Iterator<Entry<Integer, String>> testIt = data.entrySet().iterator();
				while(testIt.hasNext()) {
					Entry<Integer, String> entVal = testIt.next();
					System.out.println(entVal.getKey() + ":");
					System.out.println(entVal.getValue());
				}
			}
		}.start();
	}
}