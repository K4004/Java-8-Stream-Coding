package com.kone.code.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeesByDeptThenAge {
	public record Employee(String name, String department, double salary){};
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
	            new Employee("Alice", "IT", 90000),
	            new Employee("Bob", "IT", 80000),
	            new Employee("Charlie", "IT", 60000),
	            new Employee("David", "IT", 70000),
	            new Employee("Jos", "IT", 50000),
	            new Employee("Root", "IT", 50000),
	            
	            new Employee("Root", "HR", 70000),
	            new Employee("Harry", "HR", 80000),
	            new Employee("Ben", "HR", 60000),
	            new Employee("Jofra", "HR", 50000),
	            new Employee("Cook", "HR", 90000)
	        );
		
		Map<String,List<Employee>> top3ByDept=
		employees.stream().collect(Collectors.groupingBy(e->e.department,
					Collectors.collectingAndThen(
							Collectors.toList(), 
							empList-> empList.stream()
							.sorted(Comparator.comparingDouble(Employee:: salary).reversed())
							.limit(3)
							.collect(Collectors.toList())
							)
				));
		
		top3ByDept.forEach((dept,emplist)->{
			System.out.println(dept +"---->");
			emplist.forEach(emp->System.out.println(emp));
			
			}
				);
		
		
//		System.out.println(top3ByDept);
		
	}
	
/*	
	class Employee {
	    String name, department;
	    int age;
	    Employee(String name, String department, int age) {
	        this.name = name;
	        this.department = department;
	        this.age = age;
	    }
	}
	*/
}


