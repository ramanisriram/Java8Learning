package inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Car extends Vehicle {

	public static void main(String args[]) {
		
		List<Integer> list = Arrays.asList(2,4,6,7,8);
		list.stream().allMatch(i->{
			System.out.println(i);
			return i%2==0;
		});
		
		Optional<Boolean> result = list.stream().noneMatch(i->i%2==1);
		System.out.println(result.get());
	}
}
