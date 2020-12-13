package org.demo.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {
		
		
		/* Stream Creation..
		 * Streams can be created from different element sources 
		 * e.g. collection or array with the help of stream() and of() methods
		 * */
		
		String[] arr = new String[] {"a","b","c","d"};
		Stream<String> stream = Arrays.stream(arr);
		stream = Stream.of("a","b","c","d");
		
		List<Integer> list = new ArrayList<>();
		Stream<Integer> streamInt = list.stream();
		
		
		/*
		 * Stream API also simplifies multithreading by providing the parallelStream() method that 
		 * runs operations over stream's elements in parallel mode.
		 */
		
		List<String> cityList = Arrays.asList("Istanbul","İzmir","Ankara","Trabzon");
		cityList.parallelStream().forEach(city -> System.out.println(city));
		
		
		/*
		 * Stream Operations..
		 * 
		 * They are divided into intermediate operations (return Stream<T>) and 
		 * terminal operations (return a result of definite type).
		 * Intermediate operations allow chaining.
		 */
		
		List<Integer> numList = Arrays.asList(1,2,3,4,3,2,1,1,5);
		long count = numList.stream().distinct().count();
		System.out.println(count);
		
		/*
		 * Iterating
		 * Stream API helps to substitute for, for-each, and while loops. 
		 * It allows concentrating on operation's logic, but not on the iteration over the sequence of elements. 
		 */
		
		for(Integer num : numList) {
			if(num == 3)
				System.out.println(true);
		}
		
		boolean isExist = numList.stream().anyMatch(num -> num == 3);
		System.out.println(isExist);
		
		/*
		 * Filtering
		 * The filter() method allows us to pick a stream of elements that satisfy a predicate.
		 */
		
		cityList.stream().filter(city -> city.contains("T")).collect(Collectors.toList());
		
		
	}
	

}
