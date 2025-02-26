package Java8Features;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRef {
	
	
	public static void main(String[] args) {
			Map<String,Integer> employees = new HashMap<>();
			employees.put("Name1", 123);
			employees.put("Name2", 234);
			employees.put("Name3", 1234);
			
			//lambda exp
			employees.keySet().forEach(name-> new Employee(name));
			System.out.println("---------------------------");
			
			//constructor ref
			employees.keySet().forEach(Employee::new);
			
			//bi function
			
			BiFunction<String,Integer,Employee> employee = (name,id)-> new Employee(name, id);
			employee.apply("Name4", 123);
			BiFunction<String,Integer,Employee> employee2 = Employee::new;
			employee.apply("Name5", 1235);
			
			//supplier
			Supplier<Employee> emp1 = ()->new Employee();
			emp1.get();
			Supplier<Employee> emp2 = Employee :: new;
			emp2.get();
			
			//function ref
			System.out.println("---------------------------");
			Function<String,Employee> emp3 = Employee::new;
			emp3.apply("Supriya");
			
			
			
			
	}
	


}
