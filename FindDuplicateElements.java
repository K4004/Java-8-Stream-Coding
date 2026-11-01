package com.kone.code.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateElements {
	public static void main(String[] args) {
	
		List<Integer> input=Arrays.asList(1,2,5,7,3,4,3,5,7);
		//With object
		Set<Integer> unique= new HashSet<>();
		 Set<Integer> duplicte=input.stream().filter(num->!unique.add(num))
				 .collect(Collectors.toSet());
		 System.out.println(duplicte);
		 
		//Without object 
		 Set<Integer> duplicte2=input.stream().collect(Collectors.groupingBy(Function.identity(),
				 Collectors.counting()))
		 	.entrySet().stream().filter(en->en.getValue()>1).map(en-> en.getKey())
		 	.collect(Collectors.toSet());
		 System.out.println(duplicte2);
		 
	}

}
