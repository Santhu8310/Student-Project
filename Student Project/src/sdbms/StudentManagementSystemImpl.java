 package sdbms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

class StudentManagementSystemImpl implements StudentManagementSystem {
	Scanner scan=new Scanner(System.in);
	LinkedHashMap<Integer,Student>db=new LinkedHashMap<Integer,Student>();
	@Override
	public void addStudent() {
System.out.println("Enter Id,Name,Age and marks:");
int id=scan.nextInt();
String name=scan.next();
int age=scan.nextInt();
double marks=scan.nextDouble();

//db.put(id,new Student(id,name,age,marks));

Student std=new Student(id, name, age, marks);
db.put(id, std);//db.put(std.getId(),std);
System.out.println("Student Record Inserted Succesfully");
}

	@Override
	public void removeStudent() {
		System.out.println("Enter Student Id:");
		int id=scan.nextInt();//key->containsKey()
		
		if (db.containsKey(id)){
			db.remove(id);
			System.out.println("Student Record Deleted");
			
		}
		else{
			try{
				throw new StudentNotFoundException("Student Data Not Found!");
			}
			catch(StudentNotFoundException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void removeAllStudent() {
     db.clear();
     System.out.println("All the Student Records Deleted Successfully");
		
	}

	@Override
	public void displayStudent() {
   System.out.println("Enter Student Id:");
   int id=scan.nextInt();   
   
   if(db.containsKey(id)){
	   //System.out.println(db.get(id));
	   Student std=db.get(id);//Student std=new Student(10,'A'....);
	   //System.out.println(std);//since toString is overridden
	   System.out.println("Id is:"+std.getId());
	   System.out.println("Age is:"+std.getAge());
	   System.out.println("Name is:"+std.getName());
	   System.out.println("Marks is:"+std.getMarks());
	   
   }
   else{
		try{
			throw new StudentNotFoundException("Student Data Not Found!");
		}
		catch(StudentNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
	
   
		
	}

	@Override
	public void displayAllStudent() {
      Set<Integer> setOfKeys=db.keySet();//creating a set of student id's
        
      for(int id:setOfKeys){
    	  System.out.println(db.get(id));
      }
      
      /* for(int key:setOfKeys){
        Student s=db.get(Key);
        System.out.println("Id:"s.getId()+\tName:"+s.getName());
        System.out.println("\tAge:"+s.getAge()+"\tMarks:"+s.getMarks());
       */
		
	}

	@Override
	public void updateStudent() {
    System.out.println("Enter Student Id:");
    int id=scan.nextInt();
    
    if(db.containsKey(id)){
    	Student s=db.get(id);
    	System.out.println("1.Update Age\n2:Update Name\n3:Update Marks");
    	System.out.println("Enter choice:");
    	int choice=scan.nextInt();
    	
    	switch(choice){
    	case 1:
    		System.out.println("Entet Age:");
    		int age=scan.nextInt();
    		s.setAge(age);
    		break;
    	case 2:
    		System.out.println("Entet Name:");
    		String name=scan.next();
    		s.setName(name);
    		break;
    	case 3:
    		System.out.println("Entet Marks:");
    		double marks=scan.nextDouble();
    		s.setMarks(marks);
    		break;
    	
    		default:
    			System.out.println("Invalid choice!");
    		
    	
    	}
    }
		
	}

	@Override
	public void countStudents() {
System.out.println("No of Student Records Present:"+db.size());
		
	}

	@Override
	public void sortStudents() {
		ArrayList<Student>l=new ArrayList<Student>();
		Set<Integer>s=db.keySet();
		for(int id:s){
			l.add(db.get(id));
		}
		System.out.println("1:Sort Based on Id\n2:Sort Based On Name");
		System.out.println("3:Sort Based on Marks\n4:Sort Based On Age");
		System.out.println("Enter choice:");
		int choice=scan.nextInt();
		
		switch(choice){
		case 1:
			Collections.sort(l,new SortStudentById());
			for(Student s1: l){
				System.out.println(s1);
			}
			break;
		case 2:
			Collections.sort(l,new SortStudentByName());
			display(l);
			
			break;
		case 3:
			Collections.sort(l,new SortStudentByAge());
			display(l);
			
			break;
		case 4:
			Collections.sort(l,new SortStudentByMarks());
			display(l);
			
			break;
	
           default:
				System.out.println("Invalid Choice!");
		}
	}

	private static void display(List<Student>l)
	{
		for(Student s1: l){
			System.out.println(s1);
		}
	}
}
