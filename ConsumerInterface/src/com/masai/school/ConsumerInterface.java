package com.masai.school;

import java.util.Arrays;
import java.util.List;

interface PrintList {
	void display(List<String> city);
}

public class ConsumerInterface {

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Pune", "Nashik", "Mumbai", "Satara", "Nagpur");

		PrintList printCityNames = (city) -> {
			cities.stream().forEach((c) -> System.err.println(c));
		};
		
		printCityNames.display(cities);
	}

}
