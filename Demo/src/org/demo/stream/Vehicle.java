package org.demo.stream;

public interface Vehicle {
	
	static String producer() {
		return "General Motors";
	}
	
	default String getOverview() {
		return "American Cars created by " + producer();
	}
	
	String getModel();

}
