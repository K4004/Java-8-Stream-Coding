package com.kone.code.stream;

public class FirstRepetedChar {

	public static void main(String[] args) {
		String [] arr= { "is", "very", "cool","language"};
		
		String newString=String.join("", arr);
		newString.chars()
			.mapToObj(ch->(char)ch)
			.filter(ch->newString.indexOf(ch)!=newString.lastIndexOf(ch))
			.findFirst()
			.ifPresent(System.out::println);
			
		 
	}

}
