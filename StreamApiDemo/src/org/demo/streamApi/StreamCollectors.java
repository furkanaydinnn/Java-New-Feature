package org.demo.streamApi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.ArrayList;

/* some collector import */
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.teeing;

public class StreamCollectors {

	public static void main(String[] args) {
		
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd","bb");
		List<Integer> givenIntList = Arrays.asList(1,2,456,67,3,4,2,1);
		
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
		
		Set<String> resultHashSet = givenList.stream().collect(collectingAndThen(toList(), HashSet::new));
		
		/*
		 * Collectors.joining()
		 * Joining collector can be used for joining Stream<String> elements.
		 */
		
		String resultStr = givenList.stream().collect(joining());
		System.out.println(resultStr);
		
		System.out.println(givenList.stream().collect(joining(" ")));
		
		System.out.println(givenList.stream().collect(joining(" ","PRE-","-POST")));
		
		/*
		 * Collectors.counting()
		 * Counting is a simple collector that allows simply counting of all Stream elements.
		 */
		
		System.out.println(givenList.stream().collect(counting()));
		
		/*
		 * Collectors.groupingBy()
		 * GroupingBy collector is used for grouping objects by some property and storing results in a Map instance.
		 */
		
		
		Map<Integer,List<String>> resultGrouping = givenList.stream().collect(groupingBy(String::length));
		System.out.println(resultGrouping);
		
		resultGrouping.get(3).stream().forEach(s->System.out.println(s));
		
		/*
		 * Collectors.maxBy()/minBy()
		 */
		
		Optional<Integer> min = givenIntList.stream().collect(minBy(Integer::compareTo));
		
		Optional<Integer> max = givenIntList.stream().collect(maxBy(Integer::compareTo));
		
		Object rs = givenIntList.stream().collect(teeing(minBy(Integer::compareTo),
				maxBy(Integer::compareTo),(min,max)-> Integer.valueOf(max+min)));
		

	}

}
