package org.demo.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;


import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;


public class StreamCollectors {

	public static void main(String[] args) {
		
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
		
		/*
		 * Collectors.toList()
		 * toList collector can be used for collecting all Stream elements into a List instance.
		 */
		
		List<String> result = givenList.stream().collect(toList());
		
		result.add("def");
		result.stream().forEach(str -> System.out.println(str));
		
		/*
		 * Collectors.toUnmodifiableList()
		 * Java 10 introduced a convenient way to accumulate the Stream elements into an unmodifiable List
		 */
		
		result = givenList.stream().collect(toUnmodifiableList());
		
		try {
			result.add("def");
			
		}
		catch(UnsupportedOperationException ex) {
			System.out.print(ex);
		}
		
		// an example of using toCollection()
		result = givenList.stream().collect(toCollection(ArrayList::new));
		
		/*
		 * Collectors.toSet()
		 * ToSet collector can be used for collecting all Stream elements into a Set instance.
		 */
		Set<String> resultSet = givenList.stream().collect(toSet());

	}

}
