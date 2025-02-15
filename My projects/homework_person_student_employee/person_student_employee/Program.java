package person_student_employee;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		
		Person spas = new Person("Spas", 24, true);
		Person maria = new Person("Maria", 24, false);
		Student vasil = new Student("Vasil", 14, true, 4.5);
		Student cecko = new Student("Cvetomir", 12, true, 6);
		Employee toshko = new Employee("Todor", 17, true, 60);
		Employee vladi = new Employee("Vladimir", 30, true, 75);
		
		Person[] persons = new Person[10];
		persons[0] = spas;
		persons[1] = maria;
		persons[2] = vasil;
		persons[3] = cecko;
		persons[4] = toshko;
		persons[5] = vladi;
		
		displayInfo(persons);
		
		displayOverTime(persons);
		
		System.out.println(Arrays.toString(persons));
		
	}
	static void displayInfo(Person[] array){
		
		for(Person v : array){
			
			if(v != null){
				
				Class<? extends Person> c = v.getClass();
				
				if(c.equals(Student.class)){
					((Student) v).showStudentInfo();
				}else if(c.equals(Employee.class)){
					((Employee) v).showEmployeeInfo();
				}else{
					v.showPersonInfo();
				}
				
			}
		}
	}
	
	static void displayOverTime(Person[] array){
		
		for(Person v : array){
			
			if(v != null){
				
				Class<? extends Person> c = v.getClass();
				
				if(c.equals(Employee.class)){
					System.out.println(((Employee) v).calculateOvertime(2));
				}
			}
		}
	}
	
}
