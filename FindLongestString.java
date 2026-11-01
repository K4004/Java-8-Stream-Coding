package com.kone.code.stream;

import java.util.Arrays;
import java.util.List;

public class FindLongestString {

	public static void main(String[] args) {
		
		List<String> input= Arrays.asList("Java", "Stream", "API");
		 String longest=input.stream()
			.reduce((word1,word2)-> word1.length()>word2.length() ? word1:word2 )
			.orElse(null);
		 
		 System.out.println(longest);
	}

}
