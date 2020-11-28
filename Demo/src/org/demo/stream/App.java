package org.demo.stream;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<String> cityList = Arrays.asList("Istanbul","Paris","Napoli","","Tahran","","London");
		
		cityList.stream().forEach(c -> System.out.println(c));
		
		
		System.out.println("End..");
		
		String producer = Vehicle.producer();
		System.out.println(producer);
		
		Vehicle vehicle = new VehicleImpl();
		
		System.out.println(vehicle.getOverview());
		
		
		long count = cityList.stream().filter(c -> c.contains("an")).count();
		System.out.println(count);
		
	}
	

}
