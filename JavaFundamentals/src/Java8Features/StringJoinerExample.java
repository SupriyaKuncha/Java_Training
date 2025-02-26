package Java8Features;

import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;

public class StringJoinerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringJoiner sj = new StringJoiner(" , ");
		sj.add("Name1");
		sj.add("Name2");
		sj.add("Name3");
		sj.add("Name4");
		System.out.println(sj.toString());
		System.out.println("----------------------------------");
		StringJoiner sj2 = new StringJoiner(" , ");
		sj2.add("Name1");
		sj2.add("Name2");
		sj2.add("Name3");
		sj2.add("Name4");
		System.out.println(sj2.toString());
		System.out.println("----------------------------------");
		//optional class
		
		Optional<String> name = Optional.of("java");
		name.ifPresent(n->System.out.println("Name is present: " + n));
		Optional<String> name1 = Optional.empty();
		name1.ifPresent(n->System.out.println("Name is present: " + n));
		
		System.out.println("----------------------------------");
		//parallel sort
		double[] stockPrices = {123.31, 234.24, 112.56, 431.34, 675.12};
		Arrays.parallelSort(stockPrices);
		System.out.println("Sorted Array : paralelly : " + Arrays.toString(stockPrices));

	}

}
