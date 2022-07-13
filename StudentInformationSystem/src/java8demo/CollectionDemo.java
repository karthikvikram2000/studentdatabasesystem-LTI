package java8demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionDemo {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1001,"John",4500));
		employees.add(new Employee(1003,"Peter",10000));
		employees.add(new Employee(1005,"Adams",6900));
		employees.add(new Employee(1004,"Kreese",8200));
		employees.add(new Employee(1002,"Miguel",7200));
		
		Collections.sort(employees);
		employees.stream().map(e->e.getEmployeeId()+" "+e.getEmployeeName()+" "+e.getSalary()).forEach(e->System.out.println(e));
//		System.out.println();
//		Collections.sort(employees,new SortByName());
//		employees.stream().map(e->e.getEmployeeId()+" "+e.getEmployeeName()+" "+e.getSalary()).forEach(e->System.out.println(e));
		System.out.println();
		Comparator<Employee> sortByName = (e1,e2)->e1.getEmployeeName().compareTo(e2.getEmployeeName());
		Collections.sort(employees,sortByName);
//		Collections.sort(employees,(e1,e2)->e1.getEmployeeName().compareTo(e2.getEmployeeName()));
		employees.stream().map(e->e.getEmployeeId()+" "+e.getEmployeeName()+" "+e.getSalary()).forEach(e->System.out.println(e));
//		System.out.println();
//		Collections.sort(employees,new SortBySalary());
//		employees.stream().map(e->e.getEmployeeId()+" "+e.getEmployeeName()+" "+e.getSalary()).forEach(e->System.out.println(e));
		System.out.println();
		Collections.sort(employees,(e1,e2)->e1.getSalary() - e2.getSalary());
		employees.stream().map(e->e.getEmployeeId()+" "+e.getEmployeeName()+" "+e.getSalary()).forEach(e->System.out.println(e));
	}
}
class SortByName implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getEmployeeName().compareTo(e2.getEmployeeName());
	}
}

class SortBySalary implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getSalary() - e2.getSalary();
	}
}