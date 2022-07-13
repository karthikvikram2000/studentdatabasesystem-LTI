package java8demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		Stream<Integer> streamOfInt = Stream.of(40,20,35,18,39,46,75,10);
		streamOfInt.filter(i->i>30).sorted().forEach(i->System.out.println(i));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1001,"John",4500));
		employees.add(new Employee(1003,"Peter",10000));
		employees.add(new Employee(1005,"Adams",6900));
		employees.add(new Employee(1004,"Kreese",8200));
		employees.add(new Employee(1002,"Miguel",7200));
		
		List<String> employeeNames = employees.stream().map(e->e.getEmployeeName()).collect(Collectors.toList());
		System.out.println(employeeNames);
		
		Long countOfEmployees = employees.stream().count();
		System.out.println("Number of employees: "+countOfEmployees);
		
		Double averageSalary = employees.stream().map(e->e.getSalary()).collect(Collectors.averagingInt(e->e));
		Double average = 0.0;
		for(Employee e:employees) {
			average+=e.getSalary();
		}
		System.out.println(averageSalary+" == "+(average/countOfEmployees));
	}
}
