package methodDefaults;

@FunctionalInterface
public interface vehicle {

		   void print();
		   
		   default void doDefault() {
			   System.out.println("Default");
		   }
		  
		}