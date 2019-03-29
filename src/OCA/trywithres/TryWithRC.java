package OCA.trywithres;

import java.io.IOException;

public class TryWithRC {
	public static void main(String args[]) {
		try(MyRc resource = new MyRc()) {
			System.out.println("inside");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("exception ");
			for(Throwable throwable : e.getSuppressed()) {
				System.out.println(throwable.getClass().getName());
			}
		}
	}
}

class MyRc implements AutoCloseable {
	public void close() throws IOException {
		System.out.println("resource");
		throw new IOException();
	}
}