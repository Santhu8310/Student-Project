package sdbms;

import java.util.Comparator;

class SortStudentByAge implements Comparator<Student> {
	@Override
	public int compare(Student x,Student y){
		return x.getAge()-y.getAge();
	}

}
