package Java8Features;

public class Employee {
	
	private String name;
	private int empId;
	public Employee(String name, int empId) {
	
		this.name = name;
		this.empId = empId;
		System.out.println("Two parameters constructor called:  " + name + " " + empId);
		
	}
	
	public Employee() {
		System.out.println("No parameter");
	}
	
	public Employee(String name) {
		
		this.name = name;
		System.out.println("Employee is created " + name);
	}
	
	

}
