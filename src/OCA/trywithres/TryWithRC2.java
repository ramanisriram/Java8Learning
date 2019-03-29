package OCA.trywithres;

import java.io.IOException;

public class TryWithRC2 implements AutoCloseable {
	private int id;
	public TryWithRC2(int id) {
		this.id = id;
		if(id > 1) {
			throw new RuntimeException();
		}
	}
	public void close() throws IOException {
		System.out.println("Closing app" + id);
		throw new IOException();
	}
	
	public static void main(String args[]) throws Exception {
		try(TryWithRC2 rc1 = new TryWithRC2(1); TryWithRC2 rc2 = new TryWithRC2(2)) {
			System.out.println("My APP");
		}
	}
}
