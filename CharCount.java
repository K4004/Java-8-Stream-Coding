package com.kone.code.stream;

import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {

	public static void main(String[] args) {
		
		getCharCount("Innovation");
	}
	 public static void getCharCount(String input) {
		 
		 input.toUpperCase().chars()
		 .mapToObj(ch->(char)ch)
		 .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		 .entrySet()
		 .forEach(System.out :: println);
		 
	 }

}
