package com.kone.code.stream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRetingChar {
	public static void main(String[] args) {
		List<String> input=List.of("apple", "banana", "cherryl");
		
		input.stream().flatMapToInt(st-> st.chars())
		.mapToObj(ch->(char)ch)
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream()
		.filter(en->en.getValue()==1)
		.findFirst()
		.ifPresent(en-> System.out.println( en.getKey()));
		
		
		
	
	}
}
