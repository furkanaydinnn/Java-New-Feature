package org.demo.streamApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.ArrayList;


import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.collectingAndThen;

public class StreamCollectors {

	public static void main(String[] args) {
		
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd","bb");
		
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
		resultSet.stream().forEach(str -> System.out.println(str));
		
		/*
		 * Collectors.toMap()
		 * ToMap collector can be used to collect Stream elements into a Map instance. To do this, we need to provide two functions:
				keyMapper
				valueMapper
			keyMapper will be used for extracting a Map key from a Stream element, and 
			valueMapper will be used for extracting a value associated with a given key.
		 */
		
		Map<String,Integer> resultMap = givenList.stream().collect(toMap(Function.identity(),String::length,(item, identicalItem) -> item));
		
		/*
		 * Collectors.collectingAndThen()
		 */
		
		givenList.stream().collect(collectingAndThen(toList(), HashSet::new));

	}

}
