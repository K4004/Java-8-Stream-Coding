package com.kone.code.stream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateFibonacciSequence {
	public static void main(String[] args) {
		int n=20;
		// java 8
		List<Integer> fibonacci=
		Stream.iterate(new int[] {0,1}, fib-> new int[] {fib[1],fib[0]+fib[1]})
		.limit(n) 
		.map(fib->fib[0])
		.collect(Collectors.toList());
		System.out.println(fibonacci);
		//java17
		List<Integer> fibonacci2=
				Stream.iterate(new int[] {0,1,0},
						fib->fib[2]<n,
						fib-> new int[] {fib[1],fib[0]+fib[1],fib[2]+1})
				.map(fib->fib[0])
				.toList();
		System.out.println(fibonacci2);
		
		
	}
}
